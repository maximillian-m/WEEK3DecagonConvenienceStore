package org.SuperStore.Models;

public class Applicants {
    private String name;
    private int Age;

    private int yearsOfExperience;
    private boolean isHired = false;

    public void setHired(boolean hired) {
        isHired = hired;
    }

    public boolean isHired() {
        return isHired;
    }
    public Applicants(String name, int age, int yearsOfExperience) {
        this.name = name;
        Age = age;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Age;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
