<%@page import="com.jsp.entities.Category"%>
<%@page import="com.jsp.dao.CategoryDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.jsp.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="com.jsp.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<%@include file="components/message.jsp"%>
	<div class="container">
		<div class="row mt-3 container-flex">
			<%
			CategoryDao cdao = new CategoryDao(Persistence.createEntityManagerFactory("jeeban"));
			List<Category> cli = cdao.getCategories();
			ProductDao dao = new ProductDao(Persistence.createEntityManagerFactory("jeeban"));
			List<Product> li = dao.getAllProduct();
			%>
			<!-- show Category -->
			<div class="col-md-2">
				<h1><%=cli.size()%></h1>
				<%
				for (Category c : cli) {
					out.println(c.getCategoryTitel() + "<br>");
				%>

				<%
				}
				%>
			</div>
			<!-- show product -->
			<div class="col-md-8">
				<div class="row">
					<%
					for (Product p : li) {
					%>
					<div class="col-sm-4 mt-3">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title"><%=p.getpName()%></h5>
								<p class="card-text"><%=p.getpDesc() %>.</p>
								<p class="card-text"><%=p.getCategory() %></p>
								<h6 class="card-text">Rs. <%=p.getpPrice() %></h6>
								<a href="#" class="btn btn-primary">Add to cart</a>
							</div>
						</div>
					</div>

					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>