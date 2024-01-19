<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/merchnatnav.jsp"%>
	<div class="container-fluid">
		<div class="row mt-5 bg-img">
			<div class="col-md-6 offset-md-3">
				<div class="card ms-4" style="width: 90%;">
				<%@include file="components/message.jsp" %>
					<div class="card-body">
						<center>
							<img alt="" src="img/login.png" style="width: 90px">
						</center>
						<h3 class="text-center">Merchant Login Form</h3>
						<form action="merchantlogin" method="get">
							<div class="mb-3">
								<label for="email" class="form-label">Email
									address</label> 
									<input type="email" class="form-control" name="email" required="required"
									id="exampleInputEmail1" aria-describedby="emailHelp">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control" name="password" required="required"
									id="exampleInputPassword1">
							</div>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input" required="required"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Are you human</label>
							</div>
							<a href="merchantsignup.jsp" class="d-block text-center">If you are new User click here</a>
							<div class="container text-center mt-2">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-primary">Reset</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>