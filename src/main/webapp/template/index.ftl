<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="content-language" content="ja" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>test</title>

</head>
<body>
<h1>リンクリスト</h1>
<br/>

<table border="1">
	<tr>
		<th>Test for tranction</th>
		<th><a href="/test/inputTestTbl.sp">/test/insertTestTbl.sp</a></th>
		<th><a href="/test/selectTestTbl.sp">/test/selectTestTbl.sp</a></th>
	</tr>
</table>

<form action="insertTestTbl.sp" method="post">

	<table border = "1">
	<tr>
		<td>
			<ul>
			<li>Number:<input type="text" name="testNum" value="" maxlength="8" size="16"/></li>
			<li>Name:<input type="text" name="testName" value="" maxlength="8" size="16"/></li>
			</ul>
		</td>
	</tr>
	</table>

	<br/>

	<input type="submit" value="Send" />

</form>

</body>
</html>