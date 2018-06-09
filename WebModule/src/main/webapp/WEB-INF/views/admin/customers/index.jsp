<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Customers</h1>
</div>
<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/customers/add">
            <span class="glyphicon glyphicon-plus"></span>
        </a>
    </p>

</div>
<table class="table table-hover table-striped">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th> 
        <th>Contact No</th> 
        <th>Added Date</th> 
        <th>Modified Date</th> 
        <th>Status</th> 
        <th>Complains</th>
        <th>Action</th> 

    </tr>
    <tr>
        <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName} ${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>${customer.contactNo}</td>
            <td>${customer.adddedDate}</td>
            <td>${customer.modifiedDate}</td>
            <td>${customer.status}</td>
            <td>
                <a href="">${customer.complains.size()}</a>
<!--             <a href="${SITE_URL}/admin/customers/add">
                    <span class="glyphicon glyphicon-plus"></span>
                </a>-->
                <a href="javascript:void(0)" data-title="${customer.firstName} ${customer.lastName}" data-id="${customer.id}" class="add-complain-btn btn btn-default" title="Add complains">
                    <span class="glyphicon glyphicon-plus">
                    </span>
                </a>
            </td>

            <td> 
                <a href="${SITE_URL}/admin/customers/edit/${customer.id}" class="btn btn-default">
                    <span class="glyphicon glyphicon-pencil">
                    </span>
                </a>
                <a href="${SITE_URL}/admin/customers/delete/${customer.id}" class="btn btn-default">
                    <span class="glyphicon glyphicon-trash">
                    </span>
                </a>

            </td>
        </tr>
    </c:forEach>

</table>
<!--

<!-- Modal -->
<div class="modal fade" id="complain-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modal-title">Modal title</h4>
            </div>
            <form id="complain-form">
                <div class="modal-body">
                    <div class="form-group">
                        <label>Subject</label>
                        <input type="text" name="title" class="form-control" required="required" value="${skill.name}"/> 
                    </div>
                    <div class="form-group">
                        <label>Message</label>
                        <textarea name="message" class="form-control" style="height:150px " required="required" value="${skill.name}"/> 
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="hidden"  id="csrf-token-id" name="${_csrf.parameterName}"
                           value=""/>
                    <input type="hidden" id="customer-id" name="customer.id" />
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="save-complain-btn save-btn btn-primary">Add Complain</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
    var $csrf = "${_csrf.token}";
            $(".add-complain-btn").on('click', function () {
    var $this = $(this);
            $("#csrf-token-id").val($csrf);
            $("#customer-id").val($this.attr('data-id'));
            $("#modal-title").html('Add complain of ' + $this.attr('data-title'))
            $("#complain-dialog").modal();
    });
            $(".save-complain-btn").on('click', function () {
    $.post('${SITE_URL}/admin/complains/save',
            $('#complain-form').serialize(), function (res) {
    document.forms["complain-form"].reset();
            $("#complain-dialog").modal(':hide');
    })
    });
    }
</script>



<%@include file="../shared/footer.jsp" %>