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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Analysis of the http request.
 * Check if the parameters
 *
 * @author giuliobosco
 * @version 1.1
 */
public class RequestAnalysis {
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
     * Required attributes in the request.
     */
    private String[] requiredAttributes;

    /**
     * Optional attributes in the request.
     */
    private String[] optionalAttributes;

    /**
     * Result of the analysis.
     */
    private String[] analysis;

    /**
     * Result of the analysis as session.
     */
    private HttpSession session;

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

    /**
     * Getter for the result of the analysis as http session.
     *
     * @return Result of the analysis as session.
     */
    public HttpSession getSession() {
        return this.session;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructor with the required attributes and the request.
     *
     * @param requiredAttributes Required attributes in the request.
     * @param request            Request to analyze.
     */
    public RequestAnalysis(String[] requiredAttributes, HttpServletRequest request) {
        this(requiredAttributes, null, request);
    }

    /**
     * Constructor with the required and optional attributes, and the request.
     *
     * @param requiredAttributes Required attributes in the request.
     * @param optionalAttributes Optional attributes in the request.
     * @param request            Request to analyze.
     */
    public RequestAnalysis(String[] requiredAttributes, String[] optionalAttributes, HttpServletRequest request) {
        this.requiredAttributes = requiredAttributes;
        this.optionalAttributes = optionalAttributes;

        this.analyzeSession(request);
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    /**
     * Execute the analysis.
     * Analyze if all the requested attributes are present. If one of the required attribute has no reference his index
     * will be stored in the status.
     *
     * @param request Request to analyze.
     */
    public void analyze(HttpServletRequest request) {
        this.analysis = new String[this.requiredAttributes.length + this.optionalAttributes.length];

        for (int i = 0; i < this.requiredAttributes.length; i++) {
            if (request.getParameter(this.requiredAttributes[i]) == null) {
                status = i;
                return;
            }
        }

        for (int i = 0; i < this.requiredAttributes.length; i++) {
            this.analysis[i] = request.getParameter(this.requiredAttributes[i]);
        }

        for (int i = 0; i < this.optionalAttributes.length; i++) {
            this.analysis[this.requiredAttributes.length + i] = request.getParameter(this.optionalAttributes[i]);
        }

        status = ANALYSIS_FINE;
    }

    /**
     * Execute the analysis of the http request and write the result in the analysis and in the session.
     *
     * @param request Http Request to analyze.
     */
    public void analyzeSession(HttpServletRequest request) {
        this.analyze(request);

        HttpSession session = request.getSession();

        for (int i = 0; i < this.requiredAttributes.length; i++) {
            session.setAttribute(this.requiredAttributes[i], this.analysis[i]);
        }

        for (int i = 0; i < this.optionalAttributes.length; i++) {
            session.setAttribute(this.optionalAttributes[i], this.analysis[this.requiredAttributes.length + i]);
        }
    }

    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

}
