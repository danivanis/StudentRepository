package ro.siit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App extends Throwable {

    public static Logger logger = LogManager.getLogger(App.class.getName());

    private List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();

        Scanner scanner = new Scanner(System.in);

        String action;

        do {
            displayMenu();
            action = scanner.nextLine().toUpperCase();

            switch (action) {
                case "A":

                    String firstName = null;
                    String firstNameInput = "";
                    while (firstNameInput.isEmpty()) {
                        System.out.println("Please enter first name");
                        firstNameInput = scanner.nextLine();
                        firstName = firstNameInput;
                        if (firstNameInput.isEmpty()) {
                            try {
                                throw new Exception("First name cannot be empty");
                            } catch (Exception exception) {
                                logger.error(exception);
                            }
                        }
                    }

                    String lastName = null;
                    String lastNameInput = "";
                    while (lastNameInput.isEmpty()) {
                        System.out.println("Please enter last name");
                        lastNameInput = scanner.nextLine();
                        lastName = lastNameInput;
                        if (lastName.isEmpty()) {
                            try {
                                throw new Exception("Last name cannot be empty");
                            } catch (Exception exception) {
                                logger.error(exception);
                            }
                        }
                    }

                    int birthYear = 0;
                    boolean isValidYear = false;
                    while (!isValidYear) {
                        isValidYear = true;
                        System.out.println("Please enter birth year");
                        String yearInput = scanner.nextLine();
                        if (!yearInput.isEmpty() && Integer.parseInt(yearInput) > 1900 && Integer.parseInt(yearInput) < 2020){
                            birthYear = Integer.parseInt(yearInput);
                        } else {
                            try{
                                throw new Exception("Birth year needs to be between 1900 and 2020!");
                            } catch (Exception exception){
                                logger.error(exception);
                            }
                            isValidYear = false;
                        }
                    }

                    String gender = "";
                    while (gender.isEmpty()) {
                        System.out.println("Please enter gender");
                        gender = scanner.nextLine().toLowerCase();
                        if (gender.isEmpty()) {
                            try {
                                throw new Exception("Gender cannot be empty");
                            } catch (Exception exception) {
                                logger.error(exception);
                            }
                        }
                        while (!(gender.equals("m") || gender.equals("f"))) {
                            System.out.println("Please enter gender");
                            gender = scanner.nextLine().toLowerCase();
                            if (!(gender.equals("m") || gender.equals("f"))) {
                                try {
                                    throw new Exception("Gender must be 'M' or 'F'");
                                } catch (Exception exception) {
                                    logger.error(exception);
                                }
                            }
                        }
                    }

                    String CNP = "1";
                    while (CNP.length() < 13) {
                        System.out.println("Please enter ID (CNP) number");
                        CNP = scanner.nextLine();
                        if (CNP.length() < 13) {
                            try {
                                throw new Exception("ID (CNP) must be 13 digits long");
                            } catch (Exception exception) {
                                logger.error(exception);
                            }
                        }
                        while (!CNP.matches("\\b[1-8]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)\\d{4}\\b")) {
                            System.out.println("Please enter ID (CNP) number");
                            CNP = scanner.nextLine();
                            if (!CNP.matches("\\b[1-8]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)\\d{4}\\b")) {
                                try {
                                    throw new Exception("ID (CNP) must be 13 digits long");
                                } catch (Exception exception) {
                                    logger.error(exception);
                                }
                            }
                        }
                    }

                    app.addStudents(new Student(firstName, lastName, birthYear, gender, CNP));
                    break;

                case "R":
                    System.out.println("Enter the CNP of the student that you want to remove");
                    String studentToBeDeleted = scanner.nextLine();
                    if (studentToBeDeleted.isEmpty()) {
                        try {
                            throw new Exception("ID is empty, student does not exist");
                        } catch (Exception exception) {
                            logger.error(exception);
                        }
                    } else {
                        app.removeStudents(studentToBeDeleted);
                    }

                    break;

                case "L":
                    app.listStudents();
                    break;
            }
        } while (!"X".equals(action));

    }


    public void addStudents(Student student) {
        this.students.add(student);
    }

    public void removeStudents(String CNP) {
        if (!CNP.isEmpty()) {
            Student studentToBeDeleted = null;
            for (Student student : students) {
                if (student.getCNP().equals(CNP)) {
                    studentToBeDeleted = student;
                    break;
                }
            }
            if (studentToBeDeleted != null) {
                students.remove(studentToBeDeleted);
            }
        } else {
            try {
                throw new Exception("ID is empty, student does not exist");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void listStudents() {
        students.sort(new StudentAgeComparatorAscending());
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void displayMenu() {
        System.out.println("A = add");
        System.out.println("R = remove");
        System.out.println("L = list");
        System.out.println("X = exit");
        System.out.println("Type your option");
    }

}
