package com.example.frisbeegolfsb.classes;

import java.util.ArrayList;

/**
 * This class is to make Course class and course information about its name, how many holes course
 * have, fairways par information and lengths
 */
public class Course {
    private String courseName = "";
    private int holes = 0;
    private ArrayList<Integer> par = new ArrayList<Integer>();
    private ArrayList<Integer> length = new ArrayList<Integer>();

    //Constructors

    public Course(){
    }

    public Course(String courseName, int holes){
        this.courseName = courseName;
        this.holes = holes;
    }

    /**
     * Set course name
     * @param courseName name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Get course name
     * @return course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets how many holes course have
     * @param holes holes
     */
    public void setHoles(int holes) {
        this.holes = holes;
    }

    /**
     * Get information from how many holes course have
     * @return
     */
    public int getHoles() {
        return holes;
    }

    /**
     * Sets par Arraylist
     * @param par
     */
    public void setPar(ArrayList<Integer> par) {
        this.par = par;
    }

    /**
     * Gets par ArrayList variable
     * @return par ArrayList variable
     */
    public ArrayList<Integer> getPar() {
        return par;
    }

    /**
     * Sets course fairways lengths variable
     * @param length ArrayList length variable
     */
    public void setLength(ArrayList<Integer> length) {
        this.length = length;
    }

    /**
     * Gets course fairways lengths variable
     * @return ArrayList length variable
     */
    public ArrayList<Integer> getLength() {
        return length;
    }



    //Methods for elements

    /**
     * Sets new value to par ArrayList
     * @param i value
     */
    public void setPar(int i){
        par.add(i);
    }

    /**
     * Gets value from par ArrayList
     * @param i list index to return
     * @return par value at place i
     */
    public int getPar(int i) {
        return par.get(i);
    }

    /**
     * Sets new value to length ArrayList
     * @param i value
     */
    public void setLength(int i) {
        length.add(i);
    }

    /**
     * Gets value from length ArrayList
     * @param i list index to return
     * @return par value at place i
     */
    public int getLength(int i) {
        return length.get(i);
    }

}
