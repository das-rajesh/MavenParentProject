<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Add Customer</h1>
</div>
<form method="post" action="${SITE_URL}/admin/customers/save">
    <div class="form-group">
        <label>First Name</label>
        <input type="text" name="firstName" class="form-control" required="required"/> 
    </div>
    <div class="form-group">
        <label>Last Name</label>
        <input type="text" name="lastName" class="form-control" required="required"/> 
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="email" name="email" class="form-control" required="required"/> 
    </div>
    <div class="form-group">
        <label>Contact No</label>
        <input type="text" name="contactNo" class="form-control" required="required"/> 
    </div>
    
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
    <button type="submit" class="btn btn-sucess">Save</button>
    <a href="${SITE_URL}/admin/customers" class="btn btn-danger">back</a>
    
</form>
<%@include file="../shared/footer.jsp" %>