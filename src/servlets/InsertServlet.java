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
package servlets;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import analyzer.RequestAnalysis;
import data.Record;

/**
 * Insert the data in the system.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class InsertServlet extends HttpServlet {
    /**
     * Do on post request.
     *
     * @param request  Http request.
     * @param response Http response.
     * @throws ServletException Error on the servlet.
     * @throws IOException      Error on the I/O.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestAnalysis ra = new RequestAnalysis(Record.REQUIRED_ATTRIBUTES, Record.OPTIONAL_ATTRIBUTES, request);

        if (ra.getStatus() == RequestAnalysis.ANALYSIS_FINE) {
            HttpSession session = ra.getSession();

            String redirectURL = response.encodeRedirectURL("check.jsp");
            response.sendRedirect(redirectURL);
        } else {
            String redirectURL = response.encodeRedirectURL("insert.html");
            response.sendRedirect(redirectURL);
        }
    }

    /**
     * Do on get request.
     * Recall the doPost.
     *
     * @param request  Http request.
     * @param response Http response.
     * @throws ServletException Error on the servlet.
     * @throws IOException      Error on the I/O.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
