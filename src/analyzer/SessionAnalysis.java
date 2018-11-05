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
package analyzer;

import javax.servlet.http.HttpSession;

/**
 * Analysis of the http session.
 * Check if the session attribute are right.
 *
 * @author giuliobosco
 * @version 1.1
 */
public class SessionAnalysis {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Analysis of the result went fine.
     */
    public static final int ANALYSIS_FINE = -1;

    /**
     * Analysis hasn't be executed yet.
     */
    public static final int ANALYSIS_NOT_EXECUTED = -2;

    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Status of the analysis.
     */
    private int status = ANALYSIS_NOT_EXECUTED;

    /**
     * Required attributes in the http session.
     */
    private String[] requiredAttributes;

    /**
     * Optional attributes in the http session.
     */
    private String[] optionalAttributes;

    /**
     * Result of the analysis.
     */
    private String[] analysis;

    // ----------------------------------------------------------------------------------------------- Getters & Setters

    /**
     * Getter for the status of the analysis.
     *
     * @return Status of the analysis.
     */
    public int getStatus() {
        return this.status;
    }

    /**
     * Getter for the result of the analysis.
     *
     * @return Result of the analysis.
     */
    public String[] getAnalysis() {
        return this.analysis;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructor with the required attributes and the http session.
     *
     * @param requiredAttributes Required attributes in the http session.
     * @param session            Request to analyze.
     */
    public SessionAnalysis(String[] requiredAttributes, HttpSession session) {
        this(requiredAttributes, null, session);
    }

    /**
     * Constructor with the required and optional attributes, and the http session.
     *
     * @param requiredAttributes Required attributes in the http session.
     * @param optionalAttributes Optional attributes in the http session.
     * @param session            Http session to analyze.
     */
    public SessionAnalysis(String[] requiredAttributes, String[] optionalAttributes, HttpSession session) {
        this.requiredAttributes = requiredAttributes;
        this.optionalAttributes = optionalAttributes;

        this.analyze(session);
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    /**
     * Execute the analysis.
     * Analyze if all the requested attributes are present. If one of the required attribute has no reference his index
     * will be stored in the status.
     *
     * @param session Http session to analyze.
     */
    public void analyze(HttpSession session) {
        this.analysis = new String[this.requiredAttributes.length + this.optionalAttributes.length];

        for (int i = 0; i < this.requiredAttributes.length; i++) {
            if (session.getAttribute(this.requiredAttributes[i]) == null) {
                status = i;
                return;
            }
        }

        for (int i = 0; i < this.requiredAttributes.length; i++) {
            this.analysis[i] = (String) session.getAttribute(this.requiredAttributes[i]);
        }

        for (int i = 0; i < this.optionalAttributes.length; i++) {
            this.analysis[this.requiredAttributes.length + i] = (String) session.getAttribute(this.optionalAttributes[i]);
        }

        status = ANALYSIS_FINE;
    }

    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

}
