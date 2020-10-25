package ro.siit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Student {

    private String firstName;
    private String lastName;
    private Integer birthYear;
    private String gender;
    private String CNP;

    public static Logger logger = LogManager.getLogger(App.class.getName());

    public Student(String firstName, String lastName, Integer birthYear, String gender, String CNP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
        this.CNP = CNP;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            try {
                throw new Exception("First name cannot be empty");
            } catch (Exception exception) {
                logger.error(exception);
            }
        } else {
            this.firstName = firstName;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastname(String lastname) {
        if (lastName.isEmpty()) {
            try {
                throw new Exception("Last name cannot be empty");
            } catch (Exception exception) {
                logger.error(exception);
            }
        } else {
            this.lastName = lastName;
        }
    }

    public String getLastname() {
        return lastName;
    }

    public void setBirthYear(Integer birthYear) {
        if (birthYear.equals("") || birthYear < 1900 || birthYear > 2020) {
            try {
                throw new Exception("Birth year needs to be between 1900 and 2020!");
            } catch (Exception exception) {
                logger.error(exception);
            }
        } else {
            this.birthYear = birthYear;
        }
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getAge() {
        Integer age = 2020 - getBirthYear();
        return age;
    }

    public void setGender(String gender) {
        if (gender.isEmpty()) {
            try {
                throw new Exception("Gender cannot be empty");
            } catch (Exception exception) {
                logger.error(exception);
            }
        } else if (!(gender.equals("m") || gender.equals("f"))) {
            try {
                throw new Exception("Gender must be 'M' or 'F'");
            } catch (Exception exception) {
                logger.error(exception);
            }
        } else {
            this.gender = gender;
        }

    }

    public String getGender() {
        return gender;
    }

    public void setCNP(String CNP) {
        if (CNP.length() < 13) {
            try {
                throw new Exception("ID (CNP) must be 13 digits long");
            } catch (Exception exception) {
                logger.error(exception);
            }
        } else if (!CNP.matches("\\b[1-8]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)\\d{4}\\b")) {
            try {
                throw new Exception("ID (CNP) must be 13 digits long");
            } catch (Exception exception) {
                logger.error(exception);
            }
        } else {
            this.CNP = CNP;
        }
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
    public String toString() {
        return lastName + " " + getAge() + " years";
    }

}
