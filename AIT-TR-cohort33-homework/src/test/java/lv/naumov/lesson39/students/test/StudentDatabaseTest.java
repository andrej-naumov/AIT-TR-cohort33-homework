package lv.naumov.lesson39.students.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lv.naumov.lesson39.students.Student;
import lv.naumov.lesson39.students.StudentDatabase;

public class StudentDatabaseTest {
	private StudentDatabase database;
	
	@BeforeEach
    public void setUp() {
        database = new StudentDatabase();
    }
	
	@Test
    public void testAddContainsStudent() {
        Student student = new Student(1, "Иванов", 20);
        assertTrue(database.addStudent(student));
        assertTrue(database.containsStudent(student));
    }
	
    @Test
    public void testRemoveContainsStudentById() {
        Student student = new Student(1, "Иванов", 20);
        database.addStudent(student);
        assertTrue(database.removeStudentById(1));
        assertFalse(database.containsStudent(student));
    }
	
    @Test
    public void testFindStudentsByName() {
        Student Иванов = new Student(1, "Иванов", 20);
        Student Петров = new Student(2, "Петров", 22);
        Student Сидоров = new Student(3, "Сидоров", 19);
        database.addStudent(Иванов);
        database.addStudent(Петров);
        database.addStudent(Сидоров);

        Set<Student> students = database.findStudentsByName("ов");
        assertEquals(3, students.size());

        students = database.findStudentsByName("Иванов");
        assertEquals(1, students.size());

        students = database.findStudentsByName("Козлодоев");
        assertEquals(0, students.size());
    }
	
    @Test
    public void testGetStudentsInAgeRange() {
    	Student Иванов = new Student(1, "Иванов", 20);
        Student Петров = new Student(2, "Петров", 22);
        Student Сидоров = new Student(3, "Сидоров", 19);
        database.addStudent(Иванов);
        database.addStudent(Петров);
        database.addStudent(Сидоров);

        Set<Student> students = database.getStudentsInAgeRange(19, 21);
        assertEquals(2, students.size());

        students = database.getStudentsInAgeRange(22, 25);
        assertEquals(1, students.size());

        students = database.getStudentsInAgeRange(25, 30);
        assertEquals(0, students.size());
    }
}
