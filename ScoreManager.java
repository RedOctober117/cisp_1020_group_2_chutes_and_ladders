import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreManager implements Parse
{
    private String filePath;

    public ScoreManager(String filePath) {
        this.filePath = filePath;
    }

    // Method to read scores from a file
    public List<Integer> readScores() {
        List<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each line contains a single score
                int score = Integer.parseInt(line);
                scores.add(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file reading errors here
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle invalid score format in the file
        }
        return scores;
    }

    // Method to write scores to a file
    public void writeScores(ArrayList<Player> players) {

        int test_score = (int)players.get(0).getTrait(Score.KEY).getTraitValue();
        String test_name = (String)players.get(0).getTrait(Identifier.KEY).getTraitValue();

        "ABC"
        test_score = 100
        ABC 100
        DBF 67

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int score : scores) {
                writer.write(String.valueOf(score));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file writing errors here
        }
    }

}
