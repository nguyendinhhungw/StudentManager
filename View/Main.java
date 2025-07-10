package Nguoi.View;

import Nguoi.Service.ManagerStudent;
import Nguoi.Entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Management System");
        System.out.println("Choose your data structure:");
        System.out.println("1. Use fixed-size array");
        System.out.println("2. Use ArrayList");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            runArrayVersion();
        } else if (choice.equals("2")) {
            runArrayListVersion();
        } else {
            System.out.println("Invalid choice. Exiting.");
        }


    }

    public static void runArrayVersion() {
        Scanner sc = new Scanner(System.in);
        ManagerStudent managerStudent = new ManagerStudent();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            managerStudent.saveStudentsToFile("View/sinhvien1.csv");
        }));
        while (true) {
            System.out.println("Application Manager Student");
            System.out.println("1. Add Student");
            System.out.println("Enter 1: To create student: ");
            System.out.println("Enter 2: To read information student by id: ");
            System.out.println("Enter 3: To update information student by id: ");
            System.out.println("Enter 4: To delete information student by id: ");
            System.out.println("Enter 5: To show all students in list:");
            System.out.println("Enter 6: To show the academic performance distribution of students, sorted from highest to lowest:`");
            System.out.println("Enter 7: To show the percentage distribution of students' average scores (GPAs) in the list");
            System.out.println("Enter 8: To show the list of students based on academic performance entered from the keyboard:");
            System.out.println("Enter 9: To exit:");
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    String idStudent = managerStudent.validateStudentId(new Scanner(System.in));
                    String university = managerStudent.validateUniversity(new Scanner(System.in));
                    int startYear = managerStudent.validateStartYear(new Scanner(System.in));
                    float gpa = managerStudent.validateGpa(new Scanner(System.in));
                    String name = managerStudent.validateName(new Scanner(System.in));
                    LocalDate birth = managerStudent.validateBirth(new Scanner(System.in));
                    String address = managerStudent.validateAddress(new Scanner(System.in));
                    float height = managerStudent.validateHeight(new Scanner(System.in));
                    float weight = managerStudent.validateWeight(new Scanner(System.in));
                    // Tạo đối tượng Student và thêm vào danh sách
                    Student student = new Student(idStudent, university, startYear, gpa, managerStudent.studentCount + 1, name, birth, address, height, weight);
                    managerStudent.addStudent(student);
                    System.out.println("Student added successfully.");
                    System.out.println(student);
                    break;
                case "2":
                    System.out.println("Enter student ID to read information: ");
                    String searchId = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < managerStudent.studentCount; i++) {
                        if (managerStudent.students[i].getIdStudent().equals(searchId)) {
                            System.out.println("Student found: " + managerStudent.students[i]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No student found with ID: " + searchId);
                    }
                    break;
                case "3":
                    System.out.println("Enter student ID to update information: ");
                    String updateId = sc.nextLine();
                    boolean updated = false;
                    for (int i = 0; i < managerStudent.studentCount; i++) {
                        if (managerStudent.students[i].getIdStudent().equals(updateId)) {
                            String newUniversity = managerStudent.validateUniversity(new Scanner(System.in));
                            int newStartYear = managerStudent.validateStartYear(new Scanner(System.in));
                            float newGpa = managerStudent.validateGpa(new Scanner(System.in));
                            String newName = managerStudent.validateName(new Scanner(System.in));
                            LocalDate newBirth = managerStudent.validateBirth(new Scanner(System.in));
                            String newAddress = managerStudent.validateAddress(new Scanner(System.in));
                            float newHeight = managerStudent.validateHeight(new Scanner(System.in));
                            float newWeight = managerStudent.validateWeight(new Scanner(System.in));
                            // Cập nhật thông tin sinh viên
                            managerStudent.students[i] = new Student(updateId, newUniversity, newStartYear, newGpa, managerStudent.students[i].getId(), newName, newBirth, newAddress, newHeight, newWeight);

                            System.out.println("Student information updated successfully.");
                            System.out.println("Student information after update: " + managerStudent.students[i]);
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("No student found with ID: " + updateId);
                    }
                    break;
                case "4":
                    System.out.println("Enter student ID to delete: ");
                    String deleteId = sc.nextLine();
                    boolean deleted = false;
                    for (int i = 0; i < managerStudent.studentCount; i++) {
                        if (managerStudent.students[i].getIdStudent().equals(deleteId)) {
                            // Xóa sinh viên bằng cách dịch chuyển các phần tử sau nó
                            for (int j = i; j < managerStudent.studentCount - 1; j++) {
                                managerStudent.students[j] = managerStudent.students[j + 1];
                            }
                            managerStudent.students[managerStudent.studentCount - 1] = null; // Đặt phần tử cuối cùng thành null
                            managerStudent.studentCount--; // Giảm số lượng sinh viên
                            System.out.println("Student with ID " + deleteId + " has been deleted.");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("No student found with ID: " + deleteId);
                    }
                    break;
                case "5":
                    System.out.println("Total number of students: " + managerStudent.studentCount);
                    System.out.println("List of all students:");
                    for (Student s : managerStudent.students) {
                        System.out.println(s);
                    }
                    if (managerStudent.studentCount == 0) {
                        System.out.println("No students found.");
                    }
                    break;
                case "6":
                    System.out.println("Academic performance distribution of students, sorted from highest to lowest:");
                    managerStudent.percentageOfPerformance();
                    break;
                case "7":
                    System.out.println("The percentage distribution of students' average scores (GPAs) in the list ");
                    managerStudent.gpaDistributionByRange();
                case "8":
                    System.out.println("Enter the performance to show the list of students: ");
                    String performance = sc.nextLine();
                    break;
                case "9":
                    System.out.println("Exiting the application.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }


    }
    public static void runArrayListVersion() {
        ArrayList<Student> students1 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        ManagerStudent managerStudent = new ManagerStudent();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            managerStudent.saveStudentsToFile("sinhvien2.csv");

        }));
        Student student1=new Student();
        while (true) {
            System.out.println("Application Manager Student");
            System.out.println("1. Add Student");
            System.out.println("2. Read information student by id");
            System.out.println("3. Update information student by id");
            System.out.println("4. Delete information student by id");
            System.out.println("5. Show all students in list:");
            System.out.println("6. Exit:");
            String line = sc.nextLine();
            switch (line) {
                case "1":

                    String idStudent = managerStudent.validateStudentId(new Scanner(System.in));
                    String university = managerStudent.validateUniversity(new Scanner(System.in));
                    int startYear = managerStudent.validateStartYear(new Scanner(System.in));
                    float gpa = managerStudent.validateGpa(new Scanner(System.in));
                    String name = managerStudent.validateName(new Scanner(System.in));
                    LocalDate birth = managerStudent.validateBirth(new Scanner(System.in));
                    String address = managerStudent.validateAddress(new Scanner(System.in));
                    float height = managerStudent.validateHeight(new Scanner(System.in));
                    float weight = managerStudent.validateWeight(new Scanner(System.in));
                    Student student = new Student(idStudent, university, startYear, gpa, student1.getId(), name, birth, address, height, weight);
                    students1.add(student);
                    System.out.println("Student added successfully.");
                    System.out.println(student);
                    System.out.println(students1.size());
                    break;
                case "2":

                    System.out.println("Enter student ID to read information: ");
                    String searchId = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < students1.size(); i++) {
                        if (students1.get(i).getIdStudent().equals(searchId)) {
                            System.out.println("Student found: " + students1.get(i));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No student found with ID: " + searchId);
                    }
                    break;
                case "3":
                    System.out.println("Enter student ID to update information: ");
                    String updateId = sc.nextLine();
                    boolean updated = false;
                    for (int i = 0; i < students1.size(); i++) {
                        if (students1.get(i).getIdStudent().equals(updateId)) {
                            String newUniversity = managerStudent.validateUniversity(new Scanner(System.in));
                            int newStartYear = managerStudent.validateStartYear(new Scanner(System.in));
                            float newGpa = managerStudent.validateGpa(new Scanner(System.in));
                            String newName = managerStudent.validateName(new Scanner(System.in));
                            LocalDate newBirth = managerStudent.validateBirth(new Scanner(System.in));
                            String newAddress = managerStudent.validateAddress(new Scanner(System.in));
                            float newHeight = managerStudent.validateHeight(new Scanner(System.in));
                            float newWeight = managerStudent.validateWeight(new Scanner(System.in));
                            Student newStudent = new Student(updateId, newUniversity, newStartYear, newGpa, managerStudent.students[i].getId(), newName, newBirth, newAddress, newHeight, newWeight);
                            students1.add(newStudent);
                            System.out.println("Student information updated successfully.");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("No student found with ID: " + updateId);
                    }
                    break;
                case "4":
                    System.out.println("Enter student ID to delete: ");
                    String deleteId = sc.nextLine();
                    boolean deleted = false;
                    for (int i = 0; i < students1.size(); i++) {
                        if (students1.get(i).getIdStudent().equals(deleteId)) {
                            students1.remove(i);
                            System.out.println("Student with ID " + deleteId + " has been deleted successfully.");
                        }
                    }
                    if (!deleted) {
                        System.out.println("No student found with ID: " + deleteId);
                    }
                    break;
                case "5":
                    System.out.println("List of all students:");
                    for (Student stu : students1) {
                        System.out.println(stu);
                    }
                    break;
                case "6":
                    System.out.println("Exiting the application.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
