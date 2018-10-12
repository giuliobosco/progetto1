package helper.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.Charset;
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
     * @param filePath
     * @param separator
     * @throws IOException
     */
    public Csv(Path filePath, char separator) throws IOException {
        if (Files.exists(filePath) && !Files.notExists(filePath)) {
            this.filePath = filePath;

            this.csv = Files.readAllLines(filePath);
            this.separator = separator;
        } else {
            Files.createFile(filePath);

            this.filePath = filePath;

            csv = Files.readAllLines(filePath);
        }
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------ Generals Methods

    public void save() throws IOException {
        if (Files.isWritable(filePath)) {
            Files.write(filePath, csv, Charset.forName("UTF-8"));
        }
    }

    public void addLine(String string) {
        csv.add(string);
    }

    public void addLine(String[] strings) {
        String add = "";

        for (String string : strings) {
            add += string + separator;
        }

        this.addLine(add);
    }

    public void addLines(String[] strings) {
        for (String string : strings) {
            this.addLine(string);
        }
    }
}
