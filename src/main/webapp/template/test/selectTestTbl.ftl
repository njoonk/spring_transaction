<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="content-language" content="ja" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Event Group List</title>

</head>
<body>
<a href="/test/">Index Page</a>

<div>
	<span>${errorMessage?if_exists}</span>
</div>

<table cellspacing="0" cellpadding="0" border="1" width="100%"> 

<#if model.listTestTblBean?has_content>
<#list model.listTestTblBean as testTblBean>
  <tr>
    <td>${testTblBean.testId?if_exists}</td>
    <td>${testTblBean.testNum?if_exists}</td>
    <td>${testTblBean.testName?if_exists}</td>
    <td>${testTblBean.updateTime?if_exists}</td>
  </tr>
</#list>
</#if>

</table>

<table cellspacing="0" cellpadding="0" border="1" width="100%"> 

<#if model.listJoonTblBean?has_content>
<#list model.listJoonTblBean as joonTblBean>
  <tr>
    <td>${joonTblBean.joonId?if_exists}</td>
    <td>${joonTblBean.joonNum?if_exists}</td>
    <td>${joonTblBean.joonName?if_exists}</td>
    <td>${joonTblBean.updateTime?if_exists}</td>
  </tr>
</#list>
</#if>

</table>

</body>
</html>