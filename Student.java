/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nguoi;

import java.text.DateFormat;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class Student extends Person{
    private String idStudent;
    private String university;
    private int startYear;
    private double gpa;
    public enum gpaScale {
        A(0,3.0,"Kém"),
        B(3.0,5.0,"Yếu"),
        C(5.0,6.5,"Trung bình"),
        D(6.5,7.5,"Khá"),
        F(7.5,9.0,"Giỏi"),
        G(9.0,10.0,"Xuất sắc");
        private final double minGpa;
        private final double maxGpa;
        private final String description;

        gpaScale(double minGpa, double maxGpa, String description) {
            this.minGpa = minGpa;
            this.maxGpa = maxGpa;
            this.description = description;
        }

        public double getMinGpa() {
            return minGpa;
        }
        public double getMaxGpa() {
            return maxGpa;
        }
        public String getDescription() {
            return description;
        }



        }

    public Student(){

    }
    public Student(String idStudent, String university, int startYear, double gpa, int id, String name, LocalDate birth, String address, double height, double weight) {
        super(id, name, birth, address, height, weight);

        this.idStudent = idStudent;
        this.university = university;
        this.startYear = startYear;
        this.gpa = gpa;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String getPerformance() {
         {
             if(gpa >= gpaScale.A.getMinGpa() && gpa < gpaScale.A.getMaxGpa()) {
                 return gpaScale.A.getDescription();
             } else if(gpa >= gpaScale.B.getMinGpa() && gpa < gpaScale.B.getMaxGpa()) {
                 return gpaScale.B.getDescription();
             } else if(gpa >= gpaScale.C.getMinGpa() && gpa < gpaScale.C.getMaxGpa()) {
                 return gpaScale.C.getDescription();
             } else if(gpa >= gpaScale.D.getMinGpa() && gpa < gpaScale.D.getMaxGpa()) {
                 return gpaScale.D.getDescription();
             } else if(gpa >= gpaScale.F.getMinGpa() && gpa < gpaScale.F.getMaxGpa()) {
                 return gpaScale.F.getDescription();
             } else if(gpa >= gpaScale.G.getMinGpa() && gpa <= gpaScale.G.getMaxGpa()) {
                 return gpaScale.G.getDescription();
             }
        }
        return "GPA không hợp lệ";
    }

    @Override
    public String toString() {
        return "Thong tin sinh vien bao gom: " +super.toString()+"\n" + "idStudent=" + idStudent + ", university=" + university + ", startYear=" + startYear + ", gpa=" + gpa+ ", Performance=" + getPerformance() ;
    }

}

    
    
    
    

