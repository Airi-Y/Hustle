public interface Person {
    String getName();
    String getRank();
    String getGender();

    int getSalary();


    void setName(String name);
    void setGender(String gender);
    void setCurrentRank(String rank);
    String hireEmployee();
    String fireEmployee();

    void setSalary(int salary, PersonImpl person);
    void promoteEmployee(String rank);

    void askForRaise(int raise);

    void setSalary(int newsalary);
}
