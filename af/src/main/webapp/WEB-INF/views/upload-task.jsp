<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3>File Upload:</h3>
Select a file to upload:
<br />
<form action="/uploadTask" method="post"
	enctype="multipart/form-data">
	<input type="file" name="file" size="50" /> <br /> <input
		type="submit" value="Upload File" />
</form>
<br />
<a href="http://pratz.ap01.aws.af.cm/resources/Task Tracking Report 2015_Mr.Prat.xls">Task
	Tracking Report 2015_Mr.Prat.xls</a>
