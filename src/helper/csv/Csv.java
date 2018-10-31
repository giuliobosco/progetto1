package helper.csv;

import helper.validators.NameValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Csv File Manager.
 * Can read, read and modify and create an CSV file.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class Csv {
    // ------------------------------------------------------------------------------------------------------- Constants

    public static final char DFL_SEPARATOR = ',';

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

    /**
     * Header of the CSV file.
     * Each Array element is an column title.
     */
    private String[] header;

    // ----------------------------------------------------------------------------------------------- Getters & Setters

    /**
     * Getter for the CSV.
     *
     * @return Content of the CSV.
     */
    public List<String> getCsv() {
        return this.csv;
    }

    /**
     * Getter for the CSV separator.
     *
     * @return CSV Separator.
     */
    public char getSeparator() {
        return this.separator;
    }

    /**
     * Setter for the Header of the Csv.
     * Set the header only if the Csv is empty.
     *
     * @param header Header of the Csv. Each element of the Array is an column.
     */
    public void setHeader(String[] header) {
        if (this.csv.size() != 0) {
            return;
        }

        this.header = header;

        String add = "";

        for (String column : header) {
            add += column + separator;
        }

        this.csv.add(add);
    }

    /**
     * Getter for the Header of the Csv.
     *
     * @return Header of the CSV.
     */
    public String[] getHeader() {
        return this.header;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructor with the file path and the separator.
     *
     * @param filePath  Path of the CSV file.
     * @param separator CSV separator.
     * @throws IOException          Error on the file system.
     * @throws NoCsvHeaderException No Header in the CSV file find.
     */
    public Csv(Path filePath, char separator) throws IOException, NoCsvHeaderException {
        if (Files.exists(filePath) && !Files.notExists(filePath)) {
            this.filePath = filePath;

            this.csv = Files.readAllLines(filePath);

            if (this.csv.size() == 0) {
                throw new NoCsvHeaderException("No Csv Header.");
            }

            String fullHeader = this.csv.get(0);
            this.header = fullHeader.split(Character.toString(separator));
        } else {
            Files.createFile(filePath);

            this.filePath = filePath;

            this.csv = new ArrayList<>();
        }
        this.separator = separator;
    }

    /**
     * Constructor with the file path.
     *
     * @param filePath Path of the CSV file.
     * @throws IOException          Error on the file System.
     * @throws NoCsvHeaderException No Header in the CSV file find.
     */
    public Csv(Path filePath) throws IOException, NoCsvHeaderException {
        this(filePath, DFL_SEPARATOR);
    }

    /**
     * Constructor with the file path and the separator.
     *
     * @param path      Path of the CSV file.
     * @param separator CSV separator.
     * @throws IOException          Error on the file system.
     * @throws NoCsvHeaderException No header in the CSV file find.
     */
    public Csv(String path, char separator) throws IOException, NoCsvHeaderException {
        this(Paths.get(path), separator);
    }

    /**
     * Constructor with the file path.
     *
     * @param path Path of the CSV file.
     * @throws IOException          Error on the file system.
     * @throws NoCsvHeaderException No header in the CSV file find.
     */
    public Csv(String path) throws IOException, NoCsvHeaderException {
        this(Paths.get(path));
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
    public void addLine(String string) throws NoCsvHeaderException {
        if (this.header == null) {
            throw new NoCsvHeaderException("No CSV Header set.");
        }

        this.csv.add(string);
    }

    /**
     * Add line to the CSV.
     * Add the values in the string array and insert them in the csv with the separator.
     *
     * @param strings Values of the line to add to the CSV.
     */
    public void addLine(String[] strings) throws NoCsvHeaderException {
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
    public void addLines(String[] strings) throws NoCsvHeaderException {
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
    public static String[] getTestRecord() {
        String[] record = new String[3];

        record[0] = "1";
        record[1] = "John";
        record[2] = "Doe";

        return record;
    }

    /**
     * Get the Header for the test.
     *
     * @return Test Header.
     */
    public static String[] getTestHeader() {
        return new String[]{"id", "name", "surname"};
    }

    /**
     * Test method of the class.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Path path = Paths.get("CsvTest.csv");
        try {
            Csv writer = new Csv(path, ';');

            String[] record = getTestRecord();

            writer.setHeader(getTestHeader());
            writer.addLine(record);

            writer.save();

            Csv reader = new Csv(path, ';');

            for (int i = 0; i < reader.header.length; i++) {
                System.out.print(reader.header[i] + ",");
            }
            System.out.println("\n");
            System.out.println(reader.getCsv());
        } catch (IOException ioe) {

        } catch (NoCsvHeaderException nche) {
            System.out.println("the csv has no Header");
        }
    }
}
