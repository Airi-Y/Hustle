import java.awt.*;

public class PersonImpl implements Person{
    String name;
    String gender;
    int salary = 11_000;
    String rank;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setCurrentRank(String rank) {
        this.rank = rank;
    }


    @Override
    public String getRank() {
        return rank;
    }


    @Override
    public String hireEmployee() {
        return "Employee is hired!";
    }

    @Override
    public String fireEmployee() {
        return "Employee is fired!";
    }

    @Override
    public void setSalary(int salary, PersonImpl person) {
        person.addSalary(salary);
//        this.salary = salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    private void addSalary(int salary) {
        this.salary += salary;
    }

    @Override
    public void promoteEmployee(String rank) {
        this.rank = rank;
    }

    @Override
    public void askForRaise(int raise) {
        salary += raise;
    }

}
