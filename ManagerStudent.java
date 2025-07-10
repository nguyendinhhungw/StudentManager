package Nguoi;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagerStudent {
    public static final int MAX_STUDENTS = 15;
    public static Student[] students = new Student[MAX_STUDENTS];


    public static int studentCount = 0;
    Scanner sc = new Scanner(System.in);

    private static boolean isStudentIdExists(String id) {
        for (int i = 0; i < studentCount; i++) {
            // Đảm bảo phần tử mảng không null trước khi truy cập
            if (students[i] != null && students[i].getIdStudent().equals(id)) {
                return true; // ID đã tồn tại
            }
        }
        return false; // ID chưa tồn tại
    }

    public static void addStudent(Student student) {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Không thể thêm sinh viên mới. Đã đủ số lượng.");
            return;
        }
        students[studentCount++] = student;

    }

    static {
    }

    public static String validateStudentId(Scanner sc) {
        while (true) {
            try {

                System.out.println("Nhập mã sinh viên (10 ký tự): ");
                String idStudent = sc.nextLine();
                if (idStudent == null || idStudent.length() != 10 || isStudentIdExists(idStudent)) {
                    System.out.println("Mã sinh viên phải là 10 ký tự và không được trùng lặp. Vui lòng nhập lại.");

                } else {
                    return idStudent;
                }
            } catch (Exception e) {

                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại mã sinh viên.");

            }
        }
    }

    public static String validateUniversity(Scanner sc) {
        while (true) {
            try {

                System.out.println("Nhập tên trường đại học (dưới 200 ký tự): ");
                String university = sc.nextLine();
                if (university == null || university.isBlank() || university.length() >= 200) {
                    System.out.println("Tên trường đại học không được rỗng và phải < 200 ký tự. Vui lòng nhập lại.");

                } else {
                    return university;
                }
            } catch (Exception e) {

                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại tên trường đại học.");

            }
        }
    }

    public static int validateStartYear(Scanner sc) {
        while (true) {
            try {

                System.out.println("Nhập năm bắt đầu (từ 1990 đến năm hiện tại): ");
                int startYear = Integer.parseInt(sc.nextLine());
                if (startYear < 1990 || startYear > LocalDate.now().getYear()) {
                    System.out.println("Năm bắt đầu phải từ 1990 đến năm hiện tại. Vui lòng nhập lại.");

                } else {
                    return startYear;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại năm bắt đầu.");

            }
        }
    }

    public static double validateGpa(Scanner sc) {
        while (true) {
            try {
                System.out.println("Nhập điểm GPA (0.0 - 10.0): ");
                double gpa = Double.parseDouble(sc.nextLine());
                if (gpa < 0.0 || gpa > 10.0) {
                    System.out.println("Điểm GPA phải trong khoảng từ 0.0 đến 10.0. Vui lòng nhập lại.");

                } else {
                    return gpa;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại điểm GPA.");
            }
        }
    }

    public static String validateName(Scanner sc) {
        while (true) {
            try {
                System.out.println("Nhập tên (dưới 100 ký tự): ");
                String name = sc.nextLine();
                if (name.isBlank() || name.length() >= 100) {
                    System.out.println("Tên không được rỗng và phải < 100 ký tự. Vui lòng nhập lại.");
                } else {
                    return name;
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại tên.");

            }
            ;
        }
    }

    public static LocalDate validateBirth(Scanner sc) {
        while (true) {
            try {
                System.out.println("Nhập ngày sinh (YYYY-MM-DD): ");
                LocalDate birth = LocalDate.parse(sc.nextLine());
                if (birth.getYear() < 1900 || birth.getYear() > LocalDate.now().getYear()) {
                    System.out.println("Ngày sinh pha sau năm 1990 và phải trước ngày hiện tại. Vui lòng nhập lại (YYYY-MM-DD).");

                } else {
                    return birth;
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại ngày sinh (YYYY-MM-DD).");
            }
        }
    }

    public static String validateAddress(Scanner sc) {
        while (true) {
            try {
                System.out.println("Nhập địa chỉ (dưới 300 ký tự): ");
                String address = sc.nextLine();
                if (address.isBlank() || address.length() >= 300) {
                    System.out.println("Địa chỉ không được rỗng và phải < 300 ký tự. Vui lòng nhập lại.");
                    address = sc.nextLine();
                } else {
                    return address;
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại địa chỉ.");
                String address = sc.nextLine();
            }
        }
    }

    public static double validateHeight(Scanner sc) {
        while (true) {
            try {
                System.out.println("Nhập chiều cao (50.0 - 300.0 cm): ");
                double height = Double.parseDouble(sc.nextLine());
                if (height < 50.0 || height > 300.0) {
                    System.out.println("Chiều cao phải trong khoảng từ 50.0 đến 300.0 cm. Vui lòng nhập lại.");

                } else {
                    return height;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại chiều cao.");
                double height = Double.parseDouble(sc.nextLine());
            }
        }
    }

    public static double validateWeight(Scanner sc) {
        while (true) {
            try {
                System.out.println("Nhập cân nặng (5.0 - 1000.0 kg): ");
                double weight = Double.parseDouble(sc.nextLine());
                if (weight < 5.0 || weight > 1000.0) {
                    System.out.println("Cân nặng phải trong khoảng từ 5.0 đến 1000.0 kg. Vui lòng nhập lại.");

                } else {
                    return weight;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại cân nặng.");

            }
        }
    }

    public static void percentageOfPerformance() {


        // Tính phần trăm sinh viên đạt từng loại GPA
        String[] performanceTypes = {"Xuất sắc", "Giỏi", "Khá", "Trung bình", "Yếu", "Kém"};
        Double[] performancePercentages = new Double[6];
        int[] performanceCount = new int[6];
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                double gpa = students[i].getGpa();
                if (gpa >= 9.0) {
                    performanceCount[0]++;
                } else if (gpa >= 7.5) {
                    performanceCount[1]++;
                } else if (gpa >= 6.5) {
                    performanceCount[2]++;
                } else if (gpa >= 5.0) {
                    performanceCount[3]++;
                } else if (gpa >= 3.0) {
                    performanceCount[4]++;
                } else {
                    performanceCount[5]++;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            performancePercentages[i] = performanceCount[i] * 100.0 / studentCount;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (performancePercentages[i] < performancePercentages[j]) {
                    double tempPercentage = performancePercentages[i];
                    performancePercentages[i] = performancePercentages[j];
                    performancePercentages[j] = tempPercentage;
                    String tempType = performanceTypes[i];
                    performanceTypes[i] = performanceTypes[j];
                    performanceTypes[j] = tempType;
                }

            }


        }
        for (int i = 0; i < 6; i++) {
            System.out.printf("%s: %.2f%%\n", performanceTypes[i], performancePercentages[i]);
        }


    }
    public static void gpaDistributionByRange(){
        Map<String, Integer> gpaRanges = new LinkedHashMap<>();
        for(int i = 0; i < 10; i++){
            if(students[i] != null){
                double gpa = students[i].getGpa();
                int range=(int) gpa;
                String rangeKey;
                if (range >= 0 && range <9 ) {
                    rangeKey = range + " - " + (range + 1);
                } else {
                    rangeKey = "9 - 10";
                }
                gpaRanges.put(rangeKey, gpaRanges.get(rangeKey) + 1);// Tăng số lượng sinh viên trong khoảng GPA tương ứng

            }
        }
        for(Map.Entry<String, Integer> entry : gpaRanges.entrySet()){//trả về 1 tập hợp các Map.Entry. Mỗi Entry đại diện cho một cặp khóa-giá trị trong Map.
            String range = entry.getKey();
            int count = entry.getValue();
            double percentage = (count * 100.0) / studentCount;
            System.out.printf("%s: %.2f%%", range, percentage);
        }
    }
    public static void printStdentByPerformance(String performance) {
        int found = 0;
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && students[i].getPerformance().equalsIgnoreCase(performance)) {//hàm equalsIgnoreCase() so sánh hai chuỗi mà không phân biệt chữ hoa chữ thường
                System.out.println(students[i]);
                found = 1;
            }
        }
        if (found==0) {
            System.out.println("Không có sinh viên nào đạt loại " + performance);
        }
    }
    public static void saveStudentsToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < studentCount; i++) {
                if (students[i] != null) {
                    writer.write(students[i].toString() + "\n");
                }
            }
            System.out.println("Dữ liệu sinh viên đã được lưu vào tệp " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu dữ liệu: " + e.getMessage());
        }
    }
}

