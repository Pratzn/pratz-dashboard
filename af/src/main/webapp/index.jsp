<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>File Uploading Form</title>
    </head>
    <body>
        <h3>File Upload:</h3>
        Select a file to upload: <br />
        <form action="uploadFile.jsp" method="post"
              enctype="multipart/form-data">
            <input type="file" name="file" size="50" />
            <br />
            <input type="submit" value="Upload File" />
        </form>
        <br/>
        <a href="http://pratz.ap01.aws.af.cm/uploaddata/Task Tracking Report 2014_Mr.Prat.xls">Task Tracking Report 2014_Mr.Prat.xls</a>
    </body>
</html>
