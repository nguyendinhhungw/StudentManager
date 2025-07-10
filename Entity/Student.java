/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nguoi.Entity;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class Student extends Person {
    private String idStudent;
    private String university;
    private int startYear;
    private float gpa;
    public Student(){

    }
    public Student(String idStudent, String university, int startYear, float gpa, int id, String name, LocalDate birth, String address, float height, float weight) {
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

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }


    @Override
    public String toString() {
        return "Thong tin sinh vien bao gom: " +super.toString()+"\n" + "idStudent=" + idStudent + ", university=" + university + ", startYear=" + startYear + ", gpa=" + gpa+ ", Performance=" + GpaScale.getPerformance(gpa) ;
    }

}

    
    
    
    

