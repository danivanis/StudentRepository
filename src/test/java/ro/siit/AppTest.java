package ro.siit;

import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AppTest extends TestCase {

    public static Logger logger = LogManager.getLogger(AppTest.class.getName());

    private List<Student> students = new ArrayList<>();

    Student student1 = new Student("asa", "", 1, "", "");

    public static void main(String[] args) {

        AppTest appTest = new AppTest();

    }

    public void testAddStudents(Student student1) {
        student1.setFirstName("Danut");
        student1.setLastname("Ivanis");
        student1.setBirthYear(1987);
        student1.setGender("m");
        student1.setCNP("1870101102030");
        student1.getFirstName();
        student1.getLastname();
        student1.getBirthYear();
        student1.getGender();
        student1.getCNP();
    }

    public void testRemoveStudents(String CNP) {
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

    public void testListStudents() {
        students.sort(new StudentAgeComparatorAscending());
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }


}