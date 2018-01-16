package com.example.frisbeegolfsb.classes;

import android.content.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class purpose is save and handle individual players game scores
 * Player name/nickname is supposed to be unique for each player.
 */

public class PlayerScores {
    private Context context;
    private ArrayList<Player> players = new ArrayList<Player>();


    //TODO think this purpose and add this to make sure that we have a file
    public void createFile(String filename){
        try{
            File file = new File(context.getFilesDir(), filename);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     *
     * Loads course info from file
     * @param filename filename which is read and loaded
     */
    public void loadPlayerInfoFromFile(String filename){
        Scanner scan = null;
        String s, s2;
        try{
            scan = new Scanner(new File(filename));
            while (scan.hasNext()){
                Player playerinfo = new Player();
                s = scan.next();
                //this line makes reading spaces in strings right (keeps as one string and not splits
                // also from spaces) needed if course name have spaces
                s2 = s.concat(scan.nextLine());

                String[] fileInfo = s2.split("[|]");
                playerinfo.setName(fileInfo[0]);
                playerinfo.setCourseName(fileInfo[1]);

                for (int j = 2; j < fileInfo.length; j++){
                    playerinfo.setScore(Integer.parseInt(fileInfo[j]));
                }


                players.add(playerinfo);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            scan.close();
        }
    }


    /**
     * Saves Players info into file
     * @param filename filename where to write
     */
    public void saveFile(String filename) {

        try {
            FileWriter fileWriter = new FileWriter(filename);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < players.size(); i++){

                Player player = players.get(i);

                printWriter.printf("%s|%s", player.getName(), player.getCourseName());
                for (int j = 0; j < player.getScore().size(); j++){
                    printWriter.printf("|%d", player.getScore(j));
                }

                printWriter.print("\n");

            }
            printWriter.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        //testing class workability
        String filename = "app\\src\\main\\java\\com\\example\\frisbeegolfsb\\classes\\playerinfo.txt";
        String filename2 = "playerinfo.txt";
        String fileo = "app\\src\\main\\java\\com\\example\\frisbeegolfsb\\classes\\playerinfoo.txt";
        PlayerScores test = new PlayerScores();

        System.out.println(new File(filename2).getAbsolutePath());


        test.loadPlayerInfoFromFile(filename);

        System.out.println(test.players.get(1).getScore().size());
        System.out.println(test.players.get(1).getName());
        System.out.println(test.players.size());

        System.out.println("---");

       // System.out.println(test.courses.get(1).getLength(1));

        //testing that saved file looks same as original
        test.saveFile(fileo);




    }



}
