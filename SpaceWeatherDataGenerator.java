import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SpaceWeatherDataGenerator {
    public static void main(String[] args) {
        String outputPath = "space_weather_data.txt";
        int numRecords = 1000;

        String[] conditions = {"Calm", "Minor Storm", "Major Storm", "Severe Storm"};

        Random rand = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            for (int i = 0; i < numRecords; i++) {
                String date = "2024-05-" + (rand.nextInt(30) + 1);
                String time = rand.nextInt(24) + ":" + rand.nextInt(60);
                String condition = conditions[rand.nextInt(conditions.length)];
                int solarFlareIntensity = rand.nextInt(1000); // Arbitrary intensity measure
                int geomagneticActivity = rand.nextInt(100); // Arbitrary activity measure
                
                writer.write(date + " " + time + " " + condition + " " + solarFlareIntensity + " " + geomagneticActivity);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

