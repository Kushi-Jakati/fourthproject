package edu.guilford;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Dogs {
    DecimalFormat formatter = new DecimalFormat("0.00");
    //Create a new random list based on and put it into the array. 

    //attributes
    private String name;
    private String breed;
    private int age;
    private double weight;
    private Random rand = new Random();



    //constructor
    public Dogs(String name, String breed, int age, double weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    //random constructor generator 
    public Dogs(String name, String breed) {
        this.name = name;
        this.breed = breed;
        this.age = rand.nextInt(28);
        this.weight = Double.parseDouble(formatter.format(rand.nextDouble() * 120));
    }

    //toString method
    public String toString() {
        return "Basic Info. \n" + 
        "The name is " + name + "\n" +
        "The breed is " + breed + "\n" +
        "The age is " + age + "\n" + 
        "Finally, the weight is " + formatter.format(weight); 
    }

    //Helper methods: calculates liklihood of death based on randomly generated numbers
    public String liklihoodOfDeath() {
        
        String liklihood = "";
        if (age > 10 || weight > 80) {
            liklihood = name + " is likely to die early.";
        } else {
            liklihood = name + " is likely to live for a while.";
        }
        return liklihood;
    }


    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}

