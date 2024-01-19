<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchant SignUp Page</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/merchnatnav.jsp"%>
	<div class="container-fluid">
		<div class="row mt-5 bg-img">
			<div class="col-md-6 offset-md-3">
				<div class="card ms-4" style="width: 90%;">
					<%@include file="components/message.jsp"%>
					<div class="card-body">
						<center>
							<img alt="" src="img/merchant.png" style="width: 90px">
						</center>
						<h3 class="text-center">Merchant SignUp form</h3>
						<form action="merchantsignup" method="get">
							<div class="mb-3">
								<label for="name" class="form-label">Enter your Name</label> <input
									name="name" required="required" type="text"
									class="form-control" placeholder="Enter your Name"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email address</label> <input
									name="email" required="required" type="email"
									class="form-control" placeholder="Enter Email"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="mb-3">
								<label for="password" class="form-label">Email password</label>
								<input name="password" required="required" type="text"
									class="form-control" placeholder="Enter Password"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="mb-3">
								<label for="phone" class="form-label">Phone no</label> <input
									name="phone" required="required" type="text"
									class="form-control" placeholder="Enter Phone no"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="mb-3">
								<label for="adress" class="form-label">Enter Address</label>
								<textarea name="address" style="height: 150px"
									class="form-control" placeholder="Enter address"></textarea>
							</div>
							<div class="container text-center">
								<button type="submit" class="btn btn-outline-success">Register</button>
								<button type="reset" class="btn btn-outline-warning">Reset</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>