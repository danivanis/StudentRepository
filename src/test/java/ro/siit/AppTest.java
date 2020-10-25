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

    public static void main(String[] args) {

        AppTest appTest = new AppTest();

    }

    public void testAddStudents() {
    }

    public void testRemoveStudents() {
    }

    public void testListStudents() {
    }

    public void testDisplayMenu() {
    }
}