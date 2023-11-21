import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ScoreManager {
    //this part should be put into the main of the program. 
    public static void main(String[] args) {
        readScoresAndWriteToFile("scores.txt", "scores.txt");
    }

    public static void readScoresAndWriteToFile(String scores, String scoreKeeper) {
        try (BufferedReader reader = new BufferedReader(new FileReader("scores.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String playerName = parts[0];
                    int score = Integer.parseInt(parts[1]);

                    // Validate player name and score
                    if (isValidPlayerName(playerName) && isValidScore(score)) {
                        // Write the validated data to the output file
                        writer.write(playerName + " " + score);
                        writer.newLine();
                    } else {
                        System.out.println("Invalid data: " + line);
                    }
                } else {
                    System.out.println("Invalid format: " + line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidPlayerName(String playerName) {
        // Player name should be three characters long
        return playerName.length() == 3;
    }

    private static boolean isValidScore(int score) {
        // Score should be in the range of 0 to 100
        return score >= 0 && score <= 100;
    }
}
