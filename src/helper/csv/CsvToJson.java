/*
 * The MIT License
 *
 * Copyright 2018 giuliobosco.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package helper.csv;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Converter form Csv to Json.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class CsvToJson {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * CSV object to transform.
     */
    private Csv csv;

    /**
     * Attributes for each istance of the Json File
     */
    private String[] attributes;

    /**
     * Elements of the Json File.
     */
    private List<String> elements;

    // ----------------------------------------------------------------------------------------------- Getters & Setters

    /**
     * Getter for the CSV object to transfer.
     *
     * @param csv CSV object to transform.
     */
    public void setCsv(Csv csv) {
        this.csv = csv;
    }

    /**
     * Getter for the CSV object to transform.
     *
     * @return CSV object to transform
     */
    public Csv getCsv() {
        return this.csv;
    }

    /**
     * Getter for the JSON Elements.
     *
     * @return JSON Elements.
     */
    public List<String> getElements() {
        return this.elements;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructor with file path.
     *
     * @param filePath  Csv File path.
     * @param separator CSV Separator.
     * @throws IOException          Error on the file system.
     * @throws NoCsvHeaderException No Csv Header find.
     */
    public CsvToJson(Path filePath, char separator) throws IOException, NoCsvHeaderException {
        this.csv = new Csv(filePath, separator);

        this.attributes = this.csv.getHeader();
    }

    /**
     * Constructor with file path.
     *
     * @param filePath Csv File path.
     * @throws IOException          Error on the file system.
     * @throws NoCsvHeaderException No Csv Header find.
     */
    public CsvToJson(Path filePath) throws IOException, NoCsvHeaderException {
        this(filePath, Csv.DFL_SEPARATOR);
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    /**
     * Transfor csv to JSON formats.
     *
     * @param line Csv Line to transform.
     * @return JSON element.
     */
    private String csvToJson(String line) {
        String[] cont = line.split(Character.toString(this.csv.getSeparator()));

        if (!(cont.length == this.attributes.length)) {
            return null;
        }

        String result = "{\n";
        for (int i = 0; i < cont.length; i++) {
            result += "\"" + this.attributes[i] + "\":\"" + cont[i] + "\";\n";
        }

        return result + "}";
    }

    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Load CSV into Elements
     */
    public void load() {
        for (int i = 0; i < this.csv.getCsv().size(); i++) {
            String element = this.csv.getCsv().get(i);
            element = this.csvToJson(element);

            this.elements.add(element);
        }
    }

    /**
     * Get the JSON file.
     *
     * @return JSON File.
     */
    public String getJson() {
        String json = "[\n";

        if (this.elements.size() > 0) {
            json += this.elements.get(0);
        } else {
            return null;
        }

        for (int i = 1; i < this.elements.size(); i++) {
            json += ",\n" + this.elements.get(i);
        }

        return json + "]";
    }

    // ----------------------------------------------------------------------------------------------- Static Components
    /**
     * Test method of the class.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Path path = Paths.get("CsvTest.csv");

        try {
            //Csv.main(new String[0]);
            Csv writer = new Csv(path, ';');

            String[] record = Csv.getTestRecord();

            writer.setHeader(Csv.getTestHeader());
            writer.addLine(record);

            writer.save();

            CsvToJson csvToJson = new CsvToJson(path, ';');

            System.out.println(csvToJson.getJson());
        } catch (IOException ioe) {

        } catch (NoCsvHeaderException nche) {
            System.out.println("the csv has no Header");
        }
    }
}
