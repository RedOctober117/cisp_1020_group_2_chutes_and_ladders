// Michael

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ScoreManager {

    private final String filePath = "txt/scores.txt";

    public void writeScore(String playerName, int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(playerName + " " + score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayScores() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Player Scores:");
            for (int i = 0; i < 5; i++) {
                line = reader.readLine();
            // while ((line = reader.readLine()) != null) {
                // Assuming the file format is "PlayerName Score"
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String playerName = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    System.out.println(playerName + ": " + score);
                } else {
                    System.out.println("Invalid line in the file: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// ScoreManager
// + final filePath: String
// + writeScore(playerName: String, score: int): void
// + displayScores(): void

    // public static void main(String[] args) {
    //     ScoreManager scoreManager = new ScoreManager();

    //     // Write a score
    //     scoreManager.writeScore("ABC", 100);

    //     // Display scores in the terminal
    //     scoreManager.displayScores();
    // }
}
