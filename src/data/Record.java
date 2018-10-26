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

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import helper.csv.Csv;
import helper.csv.NoCsvHeaderException;
import helper.data.Address;
import helper.validators.DateValidator;
import helper.validators.EmailValidator;
import helper.validators.NameValidator;

/**
 * Record for the CSV.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class Record {
    // ###################################################################################################### Attributes
    /**
     * Record date.
     */
    private Date data;

    /**
     * Name of the record.
     */
    private String name;

    /**
     * Surname of the record.
     */
    private String surname;

    /**
     * Born date of the record.
     */
    private Date bornDate;

    /**
     * Address of the record.
     */
    private Address address;

    /**
     * Phone number of the record.
     */
    private long phoneNumber;

    /**
     * Email of the record.
     */
    private String email;

    /**
     * Male or Female of the record.
     */
    private char mf;

    /**
     * Hobby of the record.
     */
    private String hobby;

    /**
     * Profession of the record.
     */
    private String work;

    /**
     * Name validator.
     */
    private NameValidator nameValidator;

    /**
     * Email validator.
     */
    private EmailValidator emailValidator;

    /**
     * Date validator.
     */
    private DateValidator dateValidator;

    // ################################################################################################ Getter & Setters

    /**
     * Getter for the Record date.
     *
     * @return Record date.
     */
    private Date getData() {
        return data;
    }

    /**
     * Setter for the Record date.
     *
     * @param data Record date.
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Getter for the Name of the record.
     *
     * @return Name of the record.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for the Name of the record.
     *
     * @param name Name of the record.
     */
    public void setName(String name) {
        if (nameValidator.isValid(name)) {
            this.name = name;
        }
    }

    /**
     * Getter for the Surname of the record.
     *
     * @return Surname of the record.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Setter for the Surname of the record.
     *
     * @param surname Surname of the record.
     */
    public void setSurname(String surname) {
        if (nameValidator.isValid(surname)) {
            this.surname = surname;
        }
    }

    /**
     * Getter for the Born date of the record.
     *
     * @return Born date of the record.
     */
    public Date getBornDate() {
        return bornDate;
    }

    /**
     * Setter for the Born date of the record.
     *
     * @param bornDate Born date of the record.
     */
    public void setBornDate(Date bornDate) {
        if (dateValidator.isValid(bornDate)) {
            this.bornDate = bornDate;
        }
    }

    /**
     * Getter for the Address of the record.
     *
     * @return Address of the record.
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Setter for the Address of the record.
     *
     * @param address Address of the record.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter for the Phone number of the record.
     *
     * @return Phone number of the record.
     */
    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Setter for the Phone number of the record.
     *
     * @param phoneNumber Phone number of the record.
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for the Email of the record.
     *
     * @return Email of the record.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter for the Email of the record.
     * @param email Email of the record.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for the Male or Female of the record.
     *
     * @return Male or Female of the record.
     */
    public char getMf() {
        return this.mf;
    }

    /**
     * Setter for the Male or Female of the record.
     *
     * @param mf Male or Female of the record.
     */
    public void setMf(char mf) {
        if (mf == 'm' || mf == 'M' || mf == 'f' || mf == 'F') {
            this.mf = mf;
        }
    }

    /**
     * Getter for the Hobby of the record.
     *
     * @return Hobby of the record.
     */
    public String getHobby() {
        return this.hobby;
    }

    /**
     * Setter for the Hobby of the record.
     *
     * @param hobby Hobby of the record.
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * Getter for the Profession of the record.
     *
     * @return Profession of the record.
     */
    public String getWork() {
        return this.work;
    }

    /**
     * Setter for the Profession of the record.
     *
     * @param work Profession of the record.
     */
    public void setWork(String work) {
        this.work = work;
    }

    // #################################################################################################### Constructors

    /**
     * Constructor without parameters.
     * Initialize the date attribute with the actual time.
     */
    public Record() {
        this.data = new Date();
        this.address = new Address();
        this.nameValidator = new NameValidator(1,50);
        this.emailValidator = new EmailValidator();
        this.dateValidator = new DateValidator(new Date());
    }

    // #################################################################################################### Help Methods

    // ################################################################################################# General Methods

    /**
     * Getter for all the data.
     * Collect all the data of the record and return
     *
     * @return Data of the attributes.
     */
    public String[] getDataStrings() {
        String[] ret = new String[13];

        ret[0] = "\"" + this.getData().toString() + "\"";
        ret[1] = "\"" + this.getName() + "\"";
        ret[2] = "\"" + this.getSurname() + "\"";
        ret[3] = "\"" + "" + "\"";//this.getBornDate().toString();
        ret[4] = "\"" + this.getAddress().getStreet() + "\"";
        ret[5] = "\"" + this.getAddress().getCivicNumberLetter() + "\"";
        ret[6] = "\"" + this.getAddress().getCity() + "\"";
        ret[7] = "\"" + this.getAddress().getNap() + "\"";
        ret[8] = "\"" + Long.toString(this.getPhoneNumber()) + "\"";
        ret[9] = "\"" + this.getEmail() + "\"";
        ret[10] = "\"" + Character.toString(this.getMf()) + "\"";
        ret[11] = "\"" + this.getHobby() + "\"";
        ret[12] = "\"" + this.getWork() + "\"";

        return ret;
    }

    /**
     * Getter all the names of the attributes.
     *
     * @return Names of the attributes.
     */
    public String[] getAttributesStrings() {
        String[] ret = new String[13];

        ret[0] = "\"data\"";
        ret[1] = "\"nome\"";
        ret[2] = "\"cognome\"";
        ret[3] = "\"dataDiNascita\"";
        ret[4] = "\"via\"";
        ret[5] = "\"numeroCivico\"";
        ret[6] = "\"città\"";
        ret[7] = "\"nap\"";
        ret[8] = "\"telefono\"";
        ret[9] = "\"email\"";
        ret[10] = "\"genere\"";
        ret[11] = "\"hobby\"";
        ret[12] = "\"professione\"";

        return ret;
    }

    /**
     * Main method of the class used to test the class.
     *
     * @param args Command Line arguments.
     */
    public static void main(String[] args) {
        Record record = new Record();

        record.setName("John");
        record.setSurname("Doe");
        record.setBornDate(new Date(2000,1,1));
        Address recordAddress = new Address();
        recordAddress.setStreet("Via Garibaldi");
        recordAddress.setCivicNumberLetter("57");
        recordAddress.setCity("milano");
        recordAddress.setNap("20121");
        record.setAddress(recordAddress);
        record.setEmail("john.doe@example.com");
        record.setMf('m');//record.setPhoneNumber(41796278810);
        record.setHobby("Play Football");
        record.setWork("Writer");

        try {
            Path path = Paths.get("Csv.txt");
            Csv writer = new Csv(path, ';');
            writer.setHeader(record.getAttributesStrings());

            writer.addLine(record.getDataStrings());

            writer.save();
        } catch (IOException ioe) {
            System.out.println("ioe");
        } catch (NoCsvHeaderException nche) {
            System.out.println("nche");
        }
    }
}
