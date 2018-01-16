package com.example.frisbeegolfsb.classes;

import java.util.ArrayList;

/**
 * This class purpose is keep necessary data from each disc golf player
 */

public class Player {
    private String name = "";
    private ArrayList<Integer> score = new ArrayList<Integer>();
    //private ArrayList<String> courseName = new ArrayList<String>();
    private String courseName = "";

    private int players = 0;
    private int holes = 0;

    /**
     * Sets player name
     * @param name Player name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns player name
     * @return name
     */
    public String getName(){
        return this.name;
    }


    /**
     * Sets score in specific element
     * @param i element place
     * @param score added score
     */
    public void setScore(int i, int score){
        this.score.add(i, score);
    }

    /**
     * Adds score end of the ArrayList
     * @param score score to add
     */
    public void setScore(int score){
        this.score.add(score);
    }

    /**
     * Returns element score from ArrayList
     * @param i element number
     * @return element i score
     */
    public int getScore(int i) {
        return this.score.get(i);
    }

    /**
     * Sets course name
     * @param name
     */
    public void setCourseName(String name){
        this.courseName = name;
    }

    /**
     * Gets course name
     * @return course name
     */
    public String getCourseName() {
        return this.courseName;
    }

    /**
     * This returns whole ArrayList list variable
     * @return ArrayList list variable for scores
     */
    public ArrayList<Integer> getScore(){
        return score;
    }

    //TODO may not needed at all
    public void setNumberOfPlayers(int players){
        this.players = players;
    }

    public void setNumberOfHoles(int holes){
        this.holes = holes;
    }


}
