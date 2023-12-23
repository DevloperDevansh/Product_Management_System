<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-5">
		<h1 class="text-center mb-3">Add Product Form</h1>
		<form action="handle-product" method="post">
			<div class="form-group">
				<label for="productName">Product Name:</label> <input type="text"
					class="form-control" id="productName" name="name" required>
			</div>

			<div class="form-group">
				<label for="productDescription">Product Description:</label>
				<textarea class="form-control" id="productDescription"
					name="description" rows="4" required></textarea>
			</div>

			<div class="form-group">
				<label for="productPrice">Product Price:</label> <input
					type="number" class="form-control" id="productPrice"
					name="price" step="0.01" required>
			</div>

            <div class= "container text-center">
                <a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
                <button type="submit" class="btn btn-primary">Add Product</button>
            </div>
			
		</form>
	</div>


</body>
</html>