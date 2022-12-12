import java.lang.reflect.*;
import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) {
        TestDrive test = new TestDrive();

        Person p1 = new PersonImpl();
        p1.setName("Lucky");
        p1.setGender("Male");
        Person ownerProxy = test.getOwnerProxy(p1);

        Person p2 = new PersonImpl();
        p2.setName("Jones");
        p2.setGender("Male");
        Person employeeProxy = test.getEmployeeProxy(p2);

//         employee tries to change the salary of the owner
        System.out.println("\n--" + employeeProxy.getName() + ", the " + employeeProxy.getRank() + ", wants to do something--\n");
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        do {
            System.out.print("What do you want to do? ");
            String option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "hire":
                    try {
                        employeeProxy.hireEmployee();
                    } catch (Exception e) {
                        System.out.println("You are not allowed to hire someone.\n");
                    }
                    break;
                case "fire":
                    try {
                        employeeProxy.fireEmployee();
                    } catch (Exception e) {
                        System.out.println("You are not allowed to fire someone.\n");
                    }
                    break;
                case "set salary":
                    try {
                        employeeProxy.setSalary(100, (PersonImpl) p2);
                    } catch (Exception e) {
                        System.out.println("Oops, you are cannot set the salary.\n");
                    }
                    break;
                case "raise":
                    try {
                        System.out.println("OLD SALARY: " + employeeProxy.getSalary());
                        System.out.print("How much do you want? ");
                        int raise = scanner.nextInt();
                        System.out.println("You've asked for a " + raise + " peso raise.");
                        try {
                            ownerProxy.setSalary(raise, (PersonImpl) p2);
                            System.out.println("It was granted!");
                        } catch (Exception e) {
                            System.out.println("Oops, you are not allowed to set the salary.\nSalary raise was not granted.");
                        }
                        System.out.println("NEW SALARY: " + employeeProxy.getSalary() + "\n");
                    } catch (Exception e) {
                        System.out.println("You are cannot ask for a raise.\n");
                    }
                    scanner.nextLine();
                    break;
                case "done":
                    run = false;
                    break;
            }
        } while (run);

        System.out.println("\n--" + ownerProxy.getName() + ", the " + ownerProxy.getRank() + ", wants to do something--\n");
        boolean ownerRun = true;
        do {
            System.out.print("What do you want to do? ");
            String option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "hire":
                    try {
                        ownerProxy.hireEmployee();
                        System.out.println("Employee hired!\n");
                    } catch (Exception e) {
                        System.out.println("You are not allowed to hire someone.\n");
                    }
                    break;
                case "fire":
                    try {
                        ownerProxy.fireEmployee();
                        System.out.println("Employee fired!\n");
                    } catch (Exception e) {
                        System.out.println("You are not allowed to fire someone.\n");
                    }
                    break;
                case "set salary":
                    try {
                        System.out.print("By how much? ");
                        int newsalary = scanner.nextInt();
                        ownerProxy.setSalary(newsalary);
                        System.out.println("New salary set to " + newsalary + "\n");
                    } catch (Exception e) {
                        System.out.println("Oops, you are cannot set the salary.\n");
                    }
                    scanner.nextLine();
                    break;
                case "raise":
                    try {
                        ownerProxy.askForRaise(100);
                    } catch (Exception e) {
                        System.out.println("A foolish question. You're the owner. Who's gonna stop you?\n");
                    }
                    break;
                case "done":
                    ownerRun = false;
                    break;
            }
        } while (ownerRun);

    }

    Person getOwnerProxy(Person person) {
        person.setCurrentRank("Owner");
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person)
        );
    }

    Person getEmployeeProxy(Person person) {
        person.setCurrentRank("Employee");
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new EmployeeInvocationHandler(person)
        );
    }

}