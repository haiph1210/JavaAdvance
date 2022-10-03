package VTI;

import VTI.entity.Gender;
import VTI.entity.Student;
import VTI.repository.StudentRepository;
import VTI.utils.HibernateUtils;


import java.util.List;

public class Program {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();

        // Create students
        System.out.println("------------ Create students ------------");
        repository.create(new Student("Nam", Gender.FEMALE));
        repository.create(new Student("Duyên", Gender.MALE));
        repository.create(new Student("Trung", Gender.FEMALE));
        repository.create(new Student("Giang", Gender.MALE));

        // Get all students
        System.out.println("------------ Get all students ------------");
        List<Student> students = repository.getAll();
        for (Student student : students) {
            System.out.println("student = " + student);
        }

        HibernateUtils.closeSeesion();
    }
}