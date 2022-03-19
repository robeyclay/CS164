import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
    // Step 1 Part A: declare map and guess arrays
    int[][] map;
    int[][] guess;
    // student code here
    int score;

    Player(String filename){
        // Step 1 Part B: initialize map and guess arrays
        map = new int[10][10];
        guess = new int[5][2];
        // student code here
        score = 0;
        readPlayerSheet(filename);
    }

    public void readPlayerSheet(String filename) {
        try {
            Scanner scnr = new Scanner(new File(filename));

            // Step 2: fill map array
            // student code here
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = scnr.nextInt();
                }
            }

            // this discards the next line in the file, since there is an empty line between the player's map and the player's guess
            scnr.nextLine();

            // Step 3: parse guesses from guessStr and fill guess array
            // 1-2 9-5 4-5 3-6 5-9
            String guessStr = scnr.nextLine();
            String[] arr = guessStr.split(" ");
            int row;
            int col;
            for (int i = 0; i < guess.length; i++) {
                for (int j = 0; j < guess[i].length; j++) {
                    String firstNum = arr[i].substring(0, arr[i].indexOf("-"));
                    String secondNum = arr[i].substring(arr[i].indexOf("-") + 1);
                    row = Integer.parseInt(firstNum);
                    col = Integer.parseInt(secondNum);
                    if (j == 0) {
                        guess[i][j] = row;
                    } else {
                        guess[i][j] = col;
                    }
                }
            }

            scnr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
