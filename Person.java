/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nguoi;


import java.time.LocalDate;

/**
 * @author Admin
 */
public class Person {
    private static int nextId = 1;
    private int id;
    private String name;
    private LocalDate birth;
    private String address;
    private double height;
    private double weight;
    public Person(){

    }
    public Person(int id, String name, LocalDate birth, String address, double height, double weight) {
        this.id = nextId++;
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.height = height;
        this.weight = weight;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "  " + "id=" + id + ", name=" + name + ", birth=" + birth + ", address=" + address + ", height=" + height + ", weight=" + weight + " ";
    }
}

    



    

    