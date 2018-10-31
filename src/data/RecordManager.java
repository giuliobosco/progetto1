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
package data;

import helper.csv.Csv;
import helper.csv.CsvToJson;
import helper.csv.NoCsvHeaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

/**
 * @author giuliobosco
 * @version 1.0
 */
public class RecordManager {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Registration folders.
     */
    public static final String FOLDER = "Registrazioni";

    /**
     * Full Registrations file.
     * If empty will be used all.
     * Will be automatically added the extension
     */
    public static final String FULL_FILE = "Registrazioni_Tutte";

    /**
     * Daily registrations file.
     * If empty will be used yyyy-mm-dd.
     * The extension and the date will be automatically added.
     */
    public static final String DAILY_FILE = "Registrazione_";

    /**
     * Extension of the file.
     */
    public static final String EXTENSION = "csv";

    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Full registrations file.
     */
    private Path fullPath;

    /**
     * Daily registrations file.
     */
    private Path dailyPath;

    /**
     * Csv.
     */
    private Csv csv;


    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructor without parameters.
     * Set the pats of the files.
     */
    public RecordManager() throws IOException {
        this.fullPath = Paths.get(FOLDER, FULL_FILE + "." + EXTENSION);

        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        String todayString = calendar.get(Calendar.YEAR) + "-"
                + calendar.get(Calendar.MONTH) + "-"
                + calendar.get(Calendar.DAY_OF_MONTH);

        this.dailyPath = Paths.get(FOLDER, DAILY_FILE + todayString + "." + EXTENSION);

        Files.createDirectories(this.fullPath.getParent());
        Files.createDirectories(this.dailyPath.getParent());
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    /**
     * Add a record to the csv with the path.
     *
     * @param path   Path of the CSV file.
     * @param record Record to add.
     * @throws IOException          Error on the file system.
     * @throws NoCsvHeaderException No CSV Header.
     */
    private void addRecord(Path path, Record record) throws IOException, NoCsvHeaderException {
        Csv writer = new Csv(path, ';');

        writer.setHeader(record.getAttributesStrings());
        writer.addLine(record.getDataStrings());

        writer.save();
    }

    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Get last record.
     *
     * @return Last record of the CSV.
     * @throws IOException          Error on the file system.
     * @throws NoCsvHeaderException No CSV Header.
     */
    public String getLastRecord() throws IOException, NoCsvHeaderException {
        return new CsvToJson(this.fullPath, ';').getLastJson();
    }

    /**
     * Get the records from today.
     *
     * @return Record of today in JSON.
     * @throws IOException          Error on the file system.
     * @throws NoCsvHeaderException No CSV Header.
     */
    public String getDailyRecords() throws IOException, NoCsvHeaderException {
        return new CsvToJson(this.dailyPath, ';').getJson();
    }

    /**
     * Get all the records.
     *
     * @return All the records.
     * @throws IOException          Error on the file system.
     * @throws NoCsvHeaderException No CSV Header.
     */
    public String getFullRecords() throws IOException, NoCsvHeaderException {
        return new CsvToJson(this.fullPath, ';').getJson();
    }

    /**
     * Add an record to the daily and full CSV.
     *
     * @param record Record to insert in the CSV.
     * @throws IOException          Error on the file system.
     * @throws NoCsvHeaderException No CSV Header.
     */
    public void addRecord(Record record) throws IOException, NoCsvHeaderException {
        this.addRecord(this.dailyPath, record);
        this.addRecord(this.fullPath, record);
    }

    // ----------------------------------------------------------------------------------------------- Static Components

}
