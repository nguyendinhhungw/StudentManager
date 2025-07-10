package Nguoi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ManagerStudent.saveStudentsToFile("sinhvien.txt");
        }));

        Scanner sc = new Scanner(System.in);
        ManagerStudent managerStudent = new ManagerStudent();
        while(true){
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
                    String idStudent = ManagerStudent.validateStudentId(new Scanner(System.in));
                    String university = ManagerStudent.validateUniversity(new Scanner(System.in));
                    int startYear = ManagerStudent.validateStartYear(new Scanner(System.in));
                    double gpa = ManagerStudent.validateGpa(new Scanner(System.in));
                    String name = ManagerStudent.validateName(new Scanner(System.in));
                    LocalDate birth = ManagerStudent.validateBirth(new Scanner(System.in));
                    String address = ManagerStudent.validateAddress(new Scanner(System.in));
                    double height = ManagerStudent.validateHeight(new Scanner(System.in));
                    double weight = ManagerStudent.validateWeight(new Scanner(System.in));
                    // Tạo đối tượng Student và thêm vào danh sách
                    Student student = new Student(idStudent, university, startYear, gpa, ManagerStudent.studentCount+1, name, birth, address, height, weight);
                    managerStudent.addStudent(student);
                    System.out.println("Student added successfully.");
                    System.out.println(student);
                    break;
                case "2":
                    System.out.println("Enter student ID to read information: ");
                    String searchId = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < ManagerStudent.studentCount; i++) {
                        if (ManagerStudent.students[i].getIdStudent().equals(searchId)) {
                            System.out.println("Student found: " + ManagerStudent.students[i]);
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
                    for (int i = 0; i < ManagerStudent.studentCount; i++) {
                        if (ManagerStudent.students[i].getIdStudent().equals(updateId)) {
                            String newUniversity = ManagerStudent.validateUniversity(new Scanner(System.in));
                            int newStartYear = ManagerStudent.validateStartYear(new Scanner(System.in));
                            double newGpa = ManagerStudent.validateGpa(new Scanner(System.in));
                            String newName = ManagerStudent.validateName(new Scanner(System.in));
                            LocalDate newBirth = ManagerStudent.validateBirth(new Scanner(System.in));
                            String newAddress = ManagerStudent.validateAddress(new Scanner(System.in));
                            double newHeight = ManagerStudent.validateHeight(new Scanner(System.in));
                            double newWeight = ManagerStudent.validateWeight(new Scanner(System.in));
                            // Cập nhật thông tin sinh viên
                            ManagerStudent.students[i] = new Student(updateId, newUniversity, newStartYear, newGpa, ManagerStudent.students[i].getId(), newName, newBirth, newAddress, newHeight, newWeight);

                            System.out.println("Student information updated successfully.");
                            System.out.println("Student information after update: "+ ManagerStudent.students[i]);
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
                    for (int i = 0; i < ManagerStudent.studentCount; i++) {
                        if (ManagerStudent.students[i].getIdStudent().equals(deleteId)) {
                            // Xóa sinh viên bằng cách dịch chuyển các phần tử sau nó
                            for (int j = i; j < ManagerStudent.studentCount - 1; j++) {
                                ManagerStudent.students[j] = ManagerStudent.students[j + 1];
                            }
                            ManagerStudent.students[ManagerStudent.studentCount - 1] = null; // Đặt phần tử cuối cùng thành null
                            ManagerStudent.studentCount--; // Giảm số lượng sinh viên
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
                    System.out.println("Total number of students: "+ManagerStudent.studentCount);
                    System.out.println("List of all students:");
                    for (Student s: ManagerStudent.students) {
                        System.out.println(s);
                    }
                    if (ManagerStudent.studentCount == 0) {
                        System.out.println("No students found.");
                    }
                    break;
                case "6":
                    System.out.println("Academic performance distribution of students, sorted from highest to lowest:");
                    ManagerStudent.percentageOfPerformance();
                    break;
                case "7":
                    System.out.println("The percentage distribution of students' average scores (GPAs) in the list ");
                    ManagerStudent.gpaDistributionByRange();
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
}
