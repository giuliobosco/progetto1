<%@ page import="data.Record" %>
<%@ page import="analyzer.SessionAnalysis" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta content="width=device-width, initial-scale=1" name="viewport"/>
	
	<link rel="stylesheet" type="text/css" href="lib/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="lib/css/help.css">
	<link rel="stylesheet" type="text/css" href="lib/fonts/font-awesome/css/font-awesome.css">
	
	<link rel="stylesheet" type="text/css" href="assets/css/check.css">
	
	<title>Check Data</title>
</head>
<body>
<%
    SessionAnalysis sa = new SessionAnalysis(Record.REQUIRED_ATTRIBUTES, Record.OPTIONAL_ATTRIBUTES, session);

    if (sa.getStatus() != SessionAnalysis.ANALYSIS_FINE) {
        String redirectURL = response.encodeRedirectURL("insert.html");
        response.sendRedirect(redirectURL);
    }

    String[] analysis = sa.getAnalysis();
%>

<h1 class="text-center">Sport Club<span class="d"> - Insert Your Data</span></h1>
<h2 class="text-center m">Check Your Data</h2>

<div class="pt50"></div>

<form class="container" method="post" action="Save">
	<div class="row">
		<div class="col-md-6">
			<div class="user-input-wrp">
				<br/>
				<input type="text" class="inputText" name="name" disabled value="<%=analysis[0]%>">
				<span class="floating-label">nome<sup>*</sup></span>
			</div>
		</div>
		
		<div class="col-md-6">
			<div class="user-input-wrp">
				<br/>
				<input type="text" class="inputText" name="surname" disabled value="<%=analysis[1]%>">
				<span class="floating-label">cognome<sup>*</sup></span>
			</div>
		</div>
	</div>
	
	<div class="row pt10">
		<div class="col-md-4 col-md-offset-4 np">
			<div class="col-xs-4">
				<div class="user-input-wrp">
					<br/>
					<input type="number" class="inputText" name="day" disabled value="<%=analysis[2]%>">
					<span class="floating-label">giorno<sup>*</sup></span>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="user-input-wrp">
					<span class="floating-label-top">mese<sup>*</sup></span>
					<select class="inputText" name="month" disabled value="<%=analysis[3]%>">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="user-input-wrp">
					<br/>
					<input type="number" class="inputText" name="year" disabled value="<%=analysis[4]%>">
					<span class="floating-label">anno<sup>*</sup></span>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row pt10">
		<h3 class="col-md-12">Indirizzo:</h3>
		<div class="col-md-10 col-xs-8">
			<div class="user-input-wrp">
				<br/>
				<input type="text" class="inputText" name="street" disabled value="<%=analysis[5]%>">
				<span class="floating-label">Via<sup>*</sup></span>
			</div>
		</div>
		<div class="col-md-2 col-xs-4">
			<div class="user-input-wrp">
				<br/>
				<input type="text" class="inputText" name="streetNumber" disabled value="<%=analysis[6]%>">
				<span class="floating-label">
					<span class="d">Numero Civico<sup>*</sup></span>
					<span class="m">N Civico<sup>*</sup></span>
					
				</span>
			</div>
		</div>
	</div>
	<div class="row pt10">
		<div class="col-xs-6">
			<div class="user-input-wrp">
				<br/>
				<input type="text" class="inputText" name="city" disabled value="<%=analysis[7]%>">
				<span class="floating-label">Citt&agrave;<sup>*</sup></span>
			</div>
		</div>
		<div class="col-xs-6">
			<div class="user-input-wrp">
				<br/>
				<input type="text" class="inputText" name="nap" disabled value="<%=analysis[8]%>">
				<span class="floating-label">NAP<sup>*</sup></span>
			</div>
		</div>
	</div>
	
	<div class="row pt10">
		<div class="col-md-6">
			<div class="user-input-wrp">
				<br/>
				<input type="text" class="inputText" name="email" disabled value="<%=analysis[9]%>">
				<span class="floating-label">e-mail<sup>*</sup></span>
			</div>
		</div>
		<div class="col-md-6">
			<div class="user-input-wrp">
				<br/>
				<input type="text" class="inputText" name="number" disabled value="<%=analysis[10]%>">
				<span class="floating-label">Numero telefonico<sup>*</sup></span>
			</div>
		</div>
	</div>
	
	<div class="row pt10">
		<div class="col-md-4 col-md-offset-4 pt10">
			<section>
				<div class="col-md-4">
					Genere<sup>*</sup>
				</div>
				<div class="col-md-4">
					<input type="radio" name="gender" value="m" <%=analysis[11].charAt(0)=='m'?"checked":""%>> Maschio
				</div>
				<div class="col-md-4">
					<input type="radio" name="gender" value="f" <%=analysis[11].charAt(0)=='f'?"checked":""%>> Femmina
				</div>
			</section>
		</div>
	</div>
	
	<div class="row pt10">
		<div class="col-md-6">
			<h3>Hobby</h3>
			<textarea name="hobby" class="col-md-12" disabled><%=analysis[12]%></textarea>
		</div>
		
		<div class="col-md-6">
			<h3>Professione</h3>
			<textarea name="work" class="col-md-12" disabled><%=analysis[13]%></textarea>
		</div>
	</div>
	
	<div class="row pt10">
		<div class="col-md-12 pt10">
			<input class="pull-right col-md-1 button" type="submit" value="Salva>">
			<div class="pull-right ph5">&nbsp;</div>
			<input class="pull-right col-md-2 button" type="reset" value="Modifica">
		</div>
	</div>
</form>

<div class="pt25 m"></div>

<script src="lib/jquery/jquery.min.js"></script>
</body>
</html>