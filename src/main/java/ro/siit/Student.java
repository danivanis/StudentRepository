package ro.siit;

public class Student {

    private String firstName;
    private String lastName;
    private Integer birthYear;
    private String gender;
    private String CNP;

    public Student(String firstName, String lastName, Integer birthYear, String gender, String CNP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
        this.CNP = CNP;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getAge() {
        int age = 2020-getBirthYear();
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getCNP() {
        return CNP;
    }

    @Override
    public boolean equals(Object s) {
        if (this == s) return true;
        if (s == null || getClass() != getClass()) return false;
        Student student = (Student) s;
        return birthYear == student.birthYear && lastName.equals(student.lastName);
    }

    @Override
    public String toString(){
        return lastName + " " + getAge() + " years";
    }

}
