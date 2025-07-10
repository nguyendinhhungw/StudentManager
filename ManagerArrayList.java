package Nguoi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerArrayList {
    public static ArrayList<Student> students1 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagerArrayList managerArrayList = new ManagerArrayList();

        Student student1=new Student();
        while(true){
            System.out.println("Application Manager Student");
            System.out.println("1. Add Student");
            System.out.println("Enter 1: To create student: ");
            System.out.println("Enter 2: To read information student by id: ");
            System.out.println("Enter 3: To update information by id: ");
            System.out.println("Enter 4: To delete information by id: ");
            System.out.println("Enter 5: To show all students in Arraylist:");
            System.out.println("Enter 6: To exit:");
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
                            String newUniversity = ManagerStudent.validateUniversity(new Scanner(System.in));
                            int newStartYear = ManagerStudent.validateStartYear(new Scanner(System.in));
                            double newGpa = ManagerStudent.validateGpa(new Scanner(System.in));
                            String newName = ManagerStudent.validateName(new Scanner(System.in));
                            LocalDate newBirth = ManagerStudent.validateBirth(new Scanner(System.in));
                            String newAddress = ManagerStudent.validateAddress(new Scanner(System.in));
                            double newHeight = ManagerStudent.validateHeight(new Scanner(System.in));
                            double newWeight = ManagerStudent.validateWeight(new Scanner(System.in));
                            Student newStudent = new Student(updateId, newUniversity, newStartYear, newGpa, ManagerStudent.students[i].getId(), newName, newBirth, newAddress, newHeight, newWeight);
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


