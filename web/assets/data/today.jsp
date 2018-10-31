<%@ page import="data.RecordManager" %>
<%@ page import="java.io.IOException" %>
<%@ page import="helper.csv.NoCsvHeaderException" %>
<%
    /*
     * Today's subscriptions in json.
     *
     * @author giuliobosco
     * @version 1.0
     */
%>
<%
    RecordManager rm = new RecordManager();
    String records = "Error";
    try {
        records = rm.getDailyRecords();
    } catch (IOException ioe) {

    } catch (NoCsvHeaderException nche) {

    }
%>
<%=records%>