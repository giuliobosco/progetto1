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
package helper.data;

import helper.validators.NameValidator;
import helper.validators.IntegerValidator;
import helper.validators.UsernameValidator;

/**
 * Address Class.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class Address {
    /**
     * Street of the address.
     */
    private String street;

    /**
     * Civic number of the address.
     */
    private int civicNumber;

    /**
     * Letter of the civic number.
     * Example: "16a"
     */
    private String civicNumberLetter;

    /**
     * Second line of the address.
     */
    private String secondLineStreet;

    /**
     * Nap of the address.
     */
    private String nap;

    /**
     * City of the address.
     */
    private String city;

    /**
     * Country of the address.
     */
    private String country;

    /**
     * Initials of the country address.
     */
    private String countryCode;

    /**
     * Name validator.
     * Used for validate street, second line street, city, country and country initials.
     */
    private NameValidator streetValidator;

    /**
     * Integer validator.
     * Used for validate civicNumber.
     */
    private IntegerValidator integerValidator;

    /**
     * Nap Validator.
     * Used fo the nap.
     */
    private NameValidator napValidator;

    /**
     * Country Code Validator.
     * Used for the country code.
     */
    private NameValidator countryCodeValidator;

    /**
     * Letter Number Validator.
     */
    private UsernameValidator letterNumValidator;

    /**
     * Getter for the Street of the address.
     *
     * @return Street of the address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for the Street of the address.
     *
     * @param street Street of the address.
     */
    public void setStreet(String street) {
        if (streetValidator.isValid(street)) {
            this.street = street;
        }
    }

    /**
     * Getter for the Civic number of the address.
     *
     * @return Civic number of the address.
     */
    public int getCivicNumber() {
        return civicNumber;
    }

    /**
     * Setter for the Civic number of the address.
     *
     * @param civicNumber Civic number of the address.
     */
    public void setCivicNumber(int civicNumber) {
        if (integerValidator.isValid(civicNumber)) {
            this.civicNumber = civicNumber;
        }
    }

    /**
     * Getter for the Letter of the civic number.
     *
     * @return Letter of the civic number.
     */
    public String getCivicNumberLetter() {
        return this.civicNumberLetter;
    }

    /**
     * Setter for the Letter of the civic number.
     *
     * @param civicNumberLetter Letter of the civic number.
     */
    public void setCivicNumberLetter(String civicNumberLetter) {
        if (letterNumValidator.isValid(civicNumberLetter)) {
            this.civicNumberLetter = civicNumberLetter;
        }
    }

    /**
     * Getter for the Second line of the address.
     *
     * @return Second line of the address.
     */
    public String getSecondLineStreet() {
        return secondLineStreet;
    }

    /**
     * Setter for the Second line of the address.
     *
     * @param secondLineStreet Second line of the address.
     */
    public void setSecondLineStreet(String secondLineStreet) {
        if (streetValidator.isValid(secondLineStreet) || integerValidator.isValid(secondLineStreet)) {
            this.secondLineStreet = secondLineStreet;
        }
    }

    /**
     * Getter for the nap of the address.
     *
     * @return Nap of the address.
     */
    public String getNap() {
        return nap;
    }

    /**
     * Setter for the nap of the address.
     *
     * @param nap Nap of the address.
     */
    public void setNap(String nap) {
        if (letterNumValidator.isValid(nap)) {
            this.nap = nap;
        }
    }

    /**
     * Getter for the city of the address.
     *
     * @return City of the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for the city of the address.
     *
     * @param city City of the address.
     */
    public void setCity(String city) {
        if (streetValidator.isValid(city)) {
            this.city = city;
        }
    }

    /**
     * Getter for the country of the address.
     *
     * @return Country of the address.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter for the country of the address.
     *
     * @param country Country of the address.
     */
    public void setCountry(String country) {
        if (streetValidator.isValid(country)) {
            this.country = country;
        }
    }

    /**
     * Getter for the country code of the address.
     *
     * @return Country code of the address.
     */
    public String getCountryInitials() {
        return this.countryCode;
    }

    /**
     * Setter for the country code of the address.
     *
     * @param countryCode Country code of the address.
     */
    public void setCountryCode(String countryCode) {
        if (countryCodeValidator.isValid(countryCode)) {
            this.countryCode = countryCode;
        }
    }

    public Address() {
        setValidators();
    }

    public Address(String street, int civicNumber, String nap, String city, String country) {
        super();

        this.setStreet(street);
        this.setCivicNumber(civicNumber);
        this.setNap(nap);
        this.setCity(city);
        this.setCountry(country);
    }

    private void setValidators() {
        this.countryCodeValidator = new NameValidator(2,2);
        this.streetValidator = new NameValidator(1,50);
        this.napValidator = new NameValidator(4,8);

        this.integerValidator = new IntegerValidator(0,99999);
        this.letterNumValidator = new UsernameValidator(1,6,true,true);
    }
}
