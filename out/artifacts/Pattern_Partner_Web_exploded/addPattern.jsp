<%--
  Pattern Partner: Add Pattern

  User: Kolya
  Date: 2016-02-21
  Time: 2:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<form class="form-horizontal" action="processPattern.jsp" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>Upload Pattern</legend>
        <div class="form-group">
            <label for="title" class="col-lg-2 control-label">Title</label>
            <div class="col-lg-10">
                <input type="text" class="form-control" id="title" placeholder="Title">
            </div>
        </div>
        <div class="form-group">
            <label for="patternFile" class="col-lg-2 control-label">File</label>
            <div class="col-lg-10">
                <input type="file" class="form-control" id="patternFile" name="patternFile" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-10 col-lg-offset-2">
                <button type="reset" class="btn btn-default">Cancel</button>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </fieldset>
</form>

<jsp:include page="footer.jsp" />