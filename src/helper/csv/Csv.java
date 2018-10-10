package helper.csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Properties;

/**
 * Csv File Manager.
 * Can read, read and modify and create an CSV file.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class Csv {
    // ###################################################################################################### Attributes
    /**
     * Path of the CSV file.
     */
    private Path filePath;

    /**
     * Content of the CSV file.
     */
    private List<String> csv;

    /**
     * Path of the properties file.
     */
    private Path propertiesPath;

    /**
     * Order of the fields for create new CSV file.
     */
    private Properties properties;

    /**
     * Csv Separator.
     */
    private char separator;

    // #################################################################################################### Constructors

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

    /**
     * Constructor with the path of the CSV file and the properties file.
     *
     * @param filePath Path of the CSV file.
     * @param propertiesPath Path of the properties file.
     */
    public Csv(Path filePath, char separator, Path propertiesPath) throws IOException {
        this(filePath, separator);

        if (Files.exists(propertiesPath) && !Files.notExists(propertiesPath)) {
            this.propertiesPath = propertiesPath;

            this.properties = new Properties();

        } else {
            throw new FileNotFoundException("Properties \"" + propertiesPath + "\" not found.");
        }
    }

    // #################################################################################################### Help Methods
    // ################################################################################################ Generals Methods

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
