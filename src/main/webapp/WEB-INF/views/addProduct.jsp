<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file ="/WEB-INF/views/template/header.jsp" %>

<!-- CONTAINER Start -->

<div class="container-wrapper">
	<div class ="container">
		<div class = "page-header">
		<h1>Add new musical Instrument or Accessory</h1>
		
		<p class = "lead">Please fill the below information to add new product</p>
		</div>
		
		<form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
<!-- get Product Name -->
		
		<div class = "form-group">
			<label for = "name"> Name</label> <form:errors path="productName" cssStyle="color:#ff0000;"/>
			<form:input path = "productName" id="name" class ="form-control"/>
		</div>
		
<!-- get Product Category -->
		
	    <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="instrument" />Instrument</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="record" />Record</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="accessory" />Accessory</label>
        </div>
        
<!-- get Product Description -->
        	
        <div class = "form-group">
			<label for = "description"> Description</label>
			<form:textarea path = "productDescription" id="description" class ="form-control"/>
		</div>
		
<!-- get Product Price -->		

		 <div class = "form-group">
			<label for = "price"> Price</label> <form:errors path="productPrice" cssStyle="color:#ff0000;"/>
			<form:input path = "productPrice" id="price" class ="form-control"/>
		</div>
		
<!-- get Product Condition -->	

		 <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="new" />New</label>
             <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="used" />Used</label>
        </div>
        
<!-- get Product Status -->  
     
         <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="active" />Active</label>
             <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="inactive" />Inactive</label>
        </div>
		
		
<!-- get Product Unit In Stock -->		

        <div class="form-group">
            <label for="unitInStrock">Unit In Stock</label> <form:errors path="unitInStrock" cssStyle="color:#ff0000;"/>
            <form:input path="unitInStrock" id="unitInStrock" class="form-Control"/>
        </div>
		
<!-- get Product Manufacturer -->		

		 <div class = "form-group">
			<label for = "productManufacturer"> Manufacturer</label>
			<form:input path = "productManufacturer" id="productManufacturer" class ="form-control"/>
		</div>
		
		<div>
			<label class = "control-label" for= "productImage">Upload Picture</label>
			<form:input id="productImage" path = "productImage" type="file" class="form:input-large"/>
		</div>
		<br><br>
		
        <input type="submit" value="submit" class="btn btn-default">
       <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
        
		</form:form>
		
    <%@include file ="/WEB-INF/views/template/footer.jsp" %>