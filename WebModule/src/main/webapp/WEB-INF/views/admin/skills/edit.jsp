<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Edit Skills</h1>
</div>
<form method="post" action="${SITE_URL}/admin/skills/save">
    <div class="form-group">
        <label>Name</label>
        <input type="next" name="name" class="form-control" required="required" value="${skill.name}"/> 
    </div>
    <input type="hidden"
	name="id"
	value="${skill.id}"/>
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
    <button type="submit" class="btn btn-sucess">Save</button>
    <a href="${SITE_URL}/admin/skills" class="btn btn-danger">back</a>
    
</form>
<%@include file="../shared/footer.jsp" %>