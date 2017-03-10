<html>
<head>
	<title>Test</title>
</head>
<body>
<h1>Upload your Avatar File:</h1>
<img src="${request?.user.avatarFile()}"/>
Noble Avatar: ${request?.user?.memberProfile.avatar.nobleAvatar}
<g:form url="http://esmzone/showinput.php"  method="post"
  enctype="multipart/form-data">
    <g:hiddenField name="nobleAvatar" value="2537256960459" />
    <input type="file" name="avatarFile"/>
    <span class="buttons"><g:submitButton name="upload" class="save" value="Save" /></span>
</g:form>
</body>
</html>