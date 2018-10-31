<%@ page import="data.RecordManager" %>
<%@ page import="java.io.IOException" %>
<%@ page import="helper.csv.NoCsvHeaderException" %>
<%
    /*
     * Last subscription in json.
     *
     * @author giuliobosco
     * @version 1.0
     */
%>
<%
    RecordManager rm = new RecordManager();
    String record = "Error";
    try {
        record = rm.getLastRecord();
    } catch (IOException ioe) {

    } catch (NoCsvHeaderException nche) {

    }
%>
<%=record%>