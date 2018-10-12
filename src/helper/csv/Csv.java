package helper.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.List;

/**
 * Csv File Manager.
 * Can read, read and modify and create an CSV file.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class Csv {
    // ------------------------------------------------------------------------------------------------------ Attributes
    /**
     * Path of the CSV file.
     */
    private Path filePath;

    /**
     * Content of the CSV file.
     */
    private List<String> csv;

    /**
     * Csv Separator.
     */
    private char separator;

    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructor with the file path
     *
     * @param filePath  Path of the CSV file.
     * @param separator CSV separator.
     * @throws IOException Error on the file system.
     */
    public Csv(Path filePath, char separator) throws IOException {
        if (Files.exists(filePath) && !Files.notExists(filePath)) {
            this.filePath = filePath;

            this.csv = Files.readAllLines(filePath);
        } else {
            Files.createFile(filePath);

            this.filePath = filePath;

            csv = Files.readAllLines(filePath);
        }
        this.separator = separator;
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------ Generals Methods

    /**
     * Save on the file system.
     *
     * @throws IOException Error on the file system.
     */
    public void save() throws IOException {
        if (Files.isWritable(filePath)) {
            Files.write(filePath, csv, Charset.forName("UTF-8"));
        }
    }

    /**
     * Add line to the CSV.
     * Add the full line passed as parameter, not check the separator or integrity of the string.
     *
     * @param string Line to add. The full line.
     */
    public void addLine(String string) {
        csv.add(string);
    }

    /**
     * Add line to the CSV.
     * Add the values in the string array and insert them in the csv with the separator.
     *
     * @param strings Values of the line to add to the CSV.
     */
    public void addLine(String[] strings) {
        String add = "";

        for (String string : strings) {
            add += string + separator;
        }

        this.addLine(add);
    }

    /**
     * Ad many lines to the CSV.
     * Each row needs the full string.
     *
     * @param strings Lines to add to the csv.
     */
    public void addLines(String[] strings) {
        for (String string : strings) {
            this.addLine(string);
        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Get test record.
     *
     * @return Test record.
     */
    public static String[] getRecord() {
        String[] record = new String[3];

        record[0] = "1";
        record[1] = "John";
        record[2] = "Doe";

        return record;
    }

    /**
     * Test method of the class.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Path path = Paths.get("CsvTest.csv");
        try {
            Csv csv = new Csv(path, ';');

            String[] record = getRecord();

            csv.addLine(record);

            csv.save();
        } catch (IOException ioe) {

        }
    }
}
