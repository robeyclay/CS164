public class Game {
    static Player player1;
    static Player player2;

    Game(String file1, String file2){
        player1 = new Player(file1);
        player2 = new Player(file2);
    }

    public void tallyScores() {
        player1.score = compareMapToGuess(player2.map, player1.guess);
        player2.score = compareMapToGuess(player1.map, player2.guess);
    }

    // Step 5: compareMapToGuess method
    public int compareMapToGuess(int[][] map, int[][] guess) {
        int score = 0;
        int row;
        int col;
        for (int i = 0; i < guess.length; i++) {
                row = guess[i][0];
                col = guess[i][1];
             if (map[row][col] == 1) {
                score++;
            }
        }
        return score;
    }

    // Step 4: mapToString method
    public String mapToString(int[][] arr) {
        StringBuilder result = new StringBuilder();
        for ( int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result.append(arr[i][j] + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public String gameResults() {
        StringBuilder result = new StringBuilder("Player 1's Board:\n");
        result.append(mapToString(player1.map));

        result.append("\nPlayer 2's Board:\n");
        result.append(mapToString(player2.map));

        result.append("Player 1 Score: " + player1.score + "\tPlayer 2 Score: " + player2.score + "\n");

        String winner;
        if(player1.score > player2.score) winner = "Player 1";
        else if(player1.score < player2.score) winner = "Player 2";
        else winner = "It's a tie!";

        result.append("Winner: " + winner);
        return result.toString();
    }
    public static void main(String [] args) {
        Game test = new Game("map1","map2");

        System.out.println(test.gameResults());
    }
}