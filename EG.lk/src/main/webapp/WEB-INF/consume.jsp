<%@ page import="com.Consumption"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Power Consumption Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/consume.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">

				<h1>Power Consumption Management</h1>

				<form id="formConsume" name="formConsume">

					Customer ID: <input id="customerID" name="customerID" type="text"
						class="form-control form-control-sm"> <br> Account
					NO: <input id="accountNO" name="accountNO" type="text"
						class="form-control form-control-sm"> <br> Date: <input
						id="date" name="date" type="text"
						class="form-control form-control-sm"> <br> Units: <input
						id="units" name="units" type="text"
						class="form-control form-control-sm"> <br> <input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidConsumIDSave" name="hidConsumIDSave" value="">
				</form>

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divConsumptionGrid">
					<%
Consumption consumeobj = new Consumption();
out.print(consumeobj.readConsume());
%>
				</div>

			</div>
		</div>
	</div>
</body>
</html>