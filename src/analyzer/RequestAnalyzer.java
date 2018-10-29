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

/**
 * Analyze the request.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class RequestAnalyzer {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Attributes of the request.
     */
    public static final String[] attributes = {
            "name",
            "surname",
            "day",
            "month",
            "year",
            "street",
            "streetNumber",
            "city",
            "nap",
            "email",
            "number",
            "gender",
            "hobby",
            "work"
    };

    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods

    /**
     * Analyze the request.
     * Check if all the required attributes are present.
     * The required attributes are the first twelve, the last 2 are optional.
     * If all the required attributes are inserted they will be copied returned as strings array.
     *
     * @param request Http Request to analyze.
     * @return Analysis result.
     */
    public static String[] analize(HttpServletRequest request) {
        String[] analysis = new String[attributes.length];

        for (int i = 0; i < attributes.length - 2; i++) {
            if (request.getParameter(attributes[i]) == null) {
                return null;
            }
        }

        for (int i = 0; i < attributes.length; i++) {
            analysis[i] = request.getParameter(attributes[i]);
        }

        return analysis;
    }

    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components
    
}
