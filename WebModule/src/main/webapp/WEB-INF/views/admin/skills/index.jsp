<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Skills</h1>
</div>
<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/skills/add">
            <span class="glyphicon glyphicon-plus"></span>
        </a>
    </p>

</div>
<table class="table table-hover table-striped">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th> 
    </tr>
    <tr>
        <c:forEach var="skill" items="${skills}">
        <tr>
            <td>${skill.id}</td>
            <td>${skill.name}</td>
            <td>
                <a href="${SITE_URL}/admin/skills/edit/${skill.id}" class="btn btn-default">
                    <span class="glyphicon glyphicon-pencil">
                    </span>
                </a>
                <a href="${SITE_URL}/admin/skills/delete/${skill.id}" class="btn btn-default">
                    <span class="glyphicon glyphicon-trash">
                    </span>
                </a>
            </td>
        </tr>
    </c:forEach>

</table>
<%@include file="../shared/footer.jsp" %>