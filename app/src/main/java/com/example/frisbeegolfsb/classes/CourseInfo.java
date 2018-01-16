package com.example.frisbeegolfsb.classes;

import android.content.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class handles reading and saving courses info (name, holes, par, lengths ans scores)
 */

public class CourseInfo { // implements Iterable<Player> {
    private Context context;
    private ArrayList<Course> courses = new ArrayList<Course>();


    //TODO this part needs to think if needed and where
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
    public void loadCoursesFromFile(String filename){
        Scanner scan = null;
        String s, s2;
        try{
            scan = new Scanner(new File(filename));
            while (scan.hasNext()){
                Course courseinfo = new Course();
                s = scan.next();
                //this line makes reading spaces in strings right (keeps as one string and not splits
                // also from spaces) needed if course name have spaces
                s2 = s.concat(scan.nextLine());

                String[] fileInfo = s2.split("[|]");
                courseinfo.setCourseName(fileInfo[0]);
                courseinfo.setHoles(Integer.parseInt(fileInfo[1]));

                for (int j = 2; j < courseinfo.getHoles()+2; j++){
                    courseinfo.setLength(Integer.parseInt(fileInfo[j]));
                }

                for (int j = courseinfo.getHoles()+2; j < fileInfo.length; j++){
                    courseinfo.setPar(Integer.parseInt(fileInfo[j]));
                }

                courses.add(courseinfo);
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
     * Saves courses info into file
     * @param filename filename where to write
     */
    public void saveFile(String filename) {

        try {
            FileWriter fileWriter = new FileWriter(filename);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int i = 0; i < courses.size(); i++){

                Course course = courses.get(i);

                printWriter.printf("%s|%d", course.getCourseName(), course.getHoles());
                for (int j = 0; j < course.getHoles(); j++){
                    printWriter.printf("|%d", course.getLength(j));
                }

                for (int j = 0; j < course.getHoles(); j++){
                    printWriter.printf("|%d", course.getPar(j));
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
        String filename = "app\\src\\main\\java\\com\\example\\frisbeegolfsb\\classes\\coursedata.txt";
        String filename2 = "coursedata.txt";
        String fileo = "app\\src\\main\\java\\com\\example\\frisbeegolfsb\\classes\\coursedatao.txt";
        CourseInfo test = new CourseInfo();

        System.out.println(new File(filename2).getAbsolutePath());


        test.loadCoursesFromFile(filename);

        System.out.println(test.courses.get(1).getPar().size());
        System.out.println(test.courses.get(1).getLength().size());
        System.out.println(test.courses.size());

        System.out.println("---");

        System.out.println(test.courses.get(1).getLength(1));

        //testing that saved file looks same as original
        test.saveFile(fileo);




    }

}
