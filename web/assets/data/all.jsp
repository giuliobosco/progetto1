<%@ page import="data.RecordManager" %>
<%@ page import="java.io.IOException" %>
<%@ page import="helper.csv.NoCsvHeaderException" %>
<%
    RecordManager rm = new RecordManager();
    String records = "";

    try {
        records = rm.getFullRecords();
    } catch (IOException ioe) {

    } catch (NoCsvHeaderException nche) {

    }
%>
<%=records%>