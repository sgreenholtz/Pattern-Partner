<%--
  Pattern Partner: FAQ and Comments
  
  User: Kolya
  Date: 2016-02-21
  Time: 2:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<h1>Frequently Asked Questions</h1>
<br />

<h3>What is this thing?</h3>
<p>Pattern Pattern is a website to keep track of knit and crochet patterns. Instead of keeping your
patterns in whatever digital or physical repository you might have, Pattern Partner lets you upload
your patterns into your own pattern library. Then just click to highlight the row you're currently on. No more
flipping between apps, using row counters, or losing track of your place!</p>
<br />

<h3>But I already have an app where I track my pattern. Why do I need Pattern Partner?</h3>
<p>Unlike other apps and websites, Pattern Partner doesn't just let you keep track of your place in a pattern.
With Pattern Partner's pattern library, you can read the entire text of the pattern on the web and save your
current place in the text itself. The best part is, Pattern Partner loads the text of the pattern into the web
environment, so the text resizes to fit perfectly onto the screen you are using.</p>
<br />

<h3>What kinds of files can I upload to Pattern Partner?</h3>
<p>Right now, Pattern Partner only accepts plain text files (.txt) and PDFs as files. Future developments
will include uploading patterns directly from a website URL and Word documents. Check back for more changes!</p>
<br />

<h3>What do I do if my pattern has a stitch chart?</h3>
<p>Currently, Pattern Partner only allows one image per pattern. If there is only one chart in your pattern,
you can use that chart image as your library image for the pattern. Future developments will allow you to
include multiple images in your pattern, so check back for changes!</p>
<br />

<h3>I'm not sure how to upload my pattern!</h3>
<p>Check out the <a href="tutorial">tutorial page</a> for instructions on using Pattern Partner.</p>
<br />

<h3>What do I do if the formatting of my pattern looks weird?</h3>
<p>This is especially common with PDF patterns. Because the PDF is read line by line, any unusual line breaks
or columns will end up looking less than optimal when loaded into Pattern Partner. But don't fret! You can hit the
download button under the title to download a version of the pattern in plain text, then open that up in your
text editor and move the text around so it reads as you want it. Then delete the pattern in your library and
upload the edited text version.</p>
<br />

<h3>I want to leave feedback for the developer.</h3>
<form class="form-horizontal" action="sendComment" method="post">
    <div class="form-group">
        <label for="name" class="col-lg-2 control-label">Name</label>
        <div class="col-lg-10">
            <input type="text" class="form-control" id="name" name="name" placeholder="Name">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="col-lg-2 control-label">Email</label>
        <div class="col-lg-10">
            <input type="text" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email">
        </div>
    </div>
    <div class="form-group">
        <label for="comment" class="col-lg-2 control-label">Comment</label>
        <div class="col-lg-10">
            <textarea class="form-control" rows="3" id="comment" name="comment"></textarea>
        </div>
    </div>
    <div class="form-group">
        <div class="col-lg-10 col-lg-offset-2">
            <button type="reset" class="btn btn-default">Cancel</button>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
<form>
<jsp:include page="footer.jsp"/>