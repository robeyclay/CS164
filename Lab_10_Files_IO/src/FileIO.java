/**
 * FileIO lab for CS 1.
 *
 * In this lab you will be writing methods to read from a file and write output to a new file
 *
 * @author YOUR_NAME
 *         YOUR_EMAIL
 * @version 202010
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FileIO {
   
   //Part 1
    public static String[] readFile(String filename) {

        //Student Code Here
        String[] lines = new String[1000];
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            int lineCounter = 0;
            for ( int i = 0; i < lines.length; i++) {
                if(fileScanner.hasNextLine()) {
                    lines[i] = fileScanner.nextLine();
                    lineCounter++;
                }
            }
            //3 lines below given to students. DO NOT MODIFY
            String[] rtn = new String[lineCounter];
            System.arraycopy(lines, 0, rtn, 0, lineCounter);
            return rtn;
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            lines[0] = "Exception Thrown in readFile Method";
            return lines;
        }
    }


    //Part 2
    public static void reverseFile(String[] parsedFile, String filename) {

        //Student Code Here
        File fileType = new File(filename);
        try {
            PrintWriter output = new PrintWriter(fileType);
            for (int i = parsedFile.length - 1; i >= 0; i--) {
                output.println(parsedFile[i]);
            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //Part 3
    public static void logFile(String[] parsedFile, String filename) {

       //Student Code Here
        try {

            PrintWriter output = new PrintWriter(new File(filename));
            for(int i = 0; i < parsedFile.length; i++) {
                    if (parsedFile[i].contains("LOG")) {
                        output.println(parsedFile[i]);
                    }

            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String[] arr = new String[5];
        System.out.println(Arrays.toString(readFile("purple")));
        String[] arr2 = readFile("purple");
       logFile(arr2,"out.txt");
       reverseFile(arr2,"out2.txt");
    }

}