import com.model.Course;
import com.model.Professor;
import com.model.Student;
import com.service.AcademicService;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AcademicService academicService = new AcademicService();

        int option = showOptionsMenuAndCaptureOption();
        while (option != 9) {

            switch (option) {
                case 1 -> registerNewProfessor(academicService);
                case 2 -> registerNewCourse(academicService);
                case 3 -> registerNewStudent(academicService);
                case 4 -> enrollStudentToCourse(academicService);
                case 5 -> enrollProfessorToCourse(academicService);
                case 6 -> findAProfessor(academicService);
                case 7 -> findAStudent(academicService);
                case 8 -> findACourse(academicService);
            }
            option = showOptionsMenuAndCaptureOption();
        }
    }

    private static Professor findAProfessor(AcademicService academicService) {
        System.out.println("Enter the id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        Optional<Professor> professorOptional = academicService.findProfessorById(id);
        if (!professorOptional.isEmpty()) {
            System.out.println(professorOptional.get());
            return professorOptional.get();
        } else {
            System.out.println("Professor with id: " + id + " not found");
        }
        return professorOptional.get();
    }

    private static Student findAStudent(AcademicService academicService) {
        System.out.println("Enter the id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        Optional<Student> studentOptional = academicService.findStudentById(id);
        if (!studentOptional.isEmpty()) {
            System.out.println(studentOptional.get());
            return studentOptional.get();
        } else {
            System.out.println("Professor with id: " + id + " not found");
        }
        return studentOptional.get();
    }

    private static Course findACourse(AcademicService academicService) {
        System.out.println("Enter the Code: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        Optional<Course> optionalCourse = academicService.findCourseByCode(code);
        if (!optionalCourse.isEmpty()) {
            System.out.println(optionalCourse.get());
            return optionalCourse.get();
        }else {
            System.out.println("Professor with id: " + code + " not found");
        }
        return optionalCourse.get();
    }


    private static void enrollStudentToCourse(AcademicService academicService) {

        Student student = findAStudent(academicService);
        Course course = findACourse(academicService);
        student.addCourseToStudent(course);
    }

    private static void enrollProfessorToCourse(AcademicService academicService) {

        Professor professor = findAProfessor(academicService);
        Course course = findACourse(academicService);
        professor.addCourseToTeach(course);
    }

    private static void registerNewStudent(AcademicService academicService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id: ");
        String id = scanner.nextLine();
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        Student student = new Student(id, name, email, phoneNumber);
        academicService.addStudent(student);
    }

    private static void registerNewCourse(AcademicService academicService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name Course: ");
        String name = scanner.nextLine();
        System.out.println("Enter the code: ");
        String code = scanner.nextLine();
        System.out.println("Enter the credits: ");
        Integer credits = scanner.nextInt();
        Course course = new Course(name, code, credits);
        academicService.addCourse(course);
    }

    private static void registerNewProfessor(AcademicService academicService) {
        //String id, String name, String email, String phoneNumber
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id: ");
        String id = scanner.nextLine();
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        Professor professor = new Professor(id, name, email, phoneNumber);
        academicService.addProfessor(professor);
    }


    private static int showOptionsMenuAndCaptureOption() {
        System.out.println("*----------------------------------------------*");
        System.out.println("| Please select one of the following options:  |");
        System.out.println("| 1. Register a new Professor                  |");
        System.out.println("| 2. Register a new Course                     |");
        System.out.println("| 3. Register a new Student                    |");
        System.out.println("| 4. Enroll Student to Course                  |");
        System.out.println("| 5. Enroll Professor to Course                |");
        System.out.println("| 6. Find  a  Professor                        |");
        System.out.println("| 7. Find  a  Student                          |");
        System.out.println("| 8. Find  a  Course                           |");
        System.out.println("| 9. Exit                                      |");
        System.out.println("*----------------------------------------------*");
        Scanner scanner = new Scanner(System.in);
        int option = 8;
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 8) {
                System.out.println("| The Option selected is not valid. Please try again |");
                showOptionsMenuAndCaptureOption();
            }
        } catch (Exception e) {
            System.out.println("| The Option selected is not valid. Please try again |");
            showOptionsMenuAndCaptureOption();
        }
        return option;
    }
}