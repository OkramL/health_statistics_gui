import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private String filename;
    private List<FileContent> contents; // Failisisu
    private List<Integer> years; // Unikaalsed aastad


    public Model() {
        filename = ""; // Mudeli loomisel on failinimi tühi/puudu
        contents = new ArrayList<>();  // Loome tühja contents listi
    }

    public void readFileContents() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line; // Failist loetud rida
            int first = 0; // Mitmenda reaga on tegemist
            boolean right = false; // Kas on õige fail (User details)
            contents.clear(); // Tühjenda Listi sisu
            while ((line = br.readLine()) != null) {  // Käime faili rea kaupa läbi
                String[] parts = line.replace("\"", "").split(";");
                if(first == 0) { // Kas on esimene rida
                    if(parts[0].equals("User details")) { // Kas on User details
                        right = true;  // Õige faili sisuga on tegu
                    }
                }
                if(right && first >= 11) {
                    //"Date";"Time";"Weight";"BMI";"Body fat";"Water content";"Muscle percentage";"Bone mass";"Comment";"Medication"
                    //"30.04.2024";"08:27";"79.7";"24.6";"22.5";"53.2";"39.6";"3.2";"";""
                    // Teisendused õigesse tüüpi (LocalDate, LocalTime, double)
                    LocalDate date = LocalDate.parse(parts[0], dateFormatter);
                    LocalTime time = LocalTime.parse(parts[1], timeFormatter);
                    double weight = Double.parseDouble(parts[2]);
                    double bmi = Double.parseDouble(parts[3]);
                    double body = Double.parseDouble(parts[4]);
                    double water = Double.parseDouble(parts[5]);
                    double muscle = Double.parseDouble(parts[6]);
                    double bone = Double.parseDouble(parts[7]);
                    contents.add(new FileContent(date, time, weight, bmi, body, water, muscle, bone));
                }
                first++; // Suurenda rea loendurit
            }
            System.out.println(contents.size()); // Testiks

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<FileContent> getContents() {
        return contents;
    }
}
