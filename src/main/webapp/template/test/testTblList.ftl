<table cellspacing="0" cellpadding="0" border="1" width="100%"> 
  <tr>
    <th align="left">testId</th>
    <th align="left">testNum</th>
    <th align="left">testName</th>
    <th align="left">updateTime</th>
  </tr>

<#if model.listTestTblBean?has_content>
<#list model.listTestTblBean as testTbl>
  <tr>
    <td><a href="editTestTbl.sp?testId=${testTbl.testId?if_exists}">${testTbl.testId?if_exists} </a><input type="checkbox" name="deleteTestId" value="${testTbl.testId?if_exists}" /></td>
    <td>${testTbl.testNum?if_exists}</td>
    <td>${testTbl.testName?if_exists}</td>
    <td>${testTbl.updateTime?if_exists?datetime}</td>
  </tr>
</#list>
</#if>
</table>

<#if model?exists>
	<#if model.paging?exists>
	<#if model.paging.prevPage?exists>
		←<a href="inputTestTbl.sp?nowPage=${model.paging.prevPage.nowPage}&allCount=${model.paging.allCount?c}" title="前のページへ" accesskey="*"><span class="stepNavi">前へ</span></a>
	</#if>
	<#if model.paging.pagingInfoList?has_content>
		<#list model.paging.pagingInfoList as pageList>
			<#if model.paging.nowPage?if_exists == pageList.pageNumber?if_exists>
				${pageList.pageNumber}
			<#else>
				<a href="inputTestTbl.sp?nowPage=${pageList.pageNumber}&allCount=${model.paging.allCount?c}">${pageList.pageNumber}</a>
			</#if>
		</#list>
	</#if>
	<#if model.paging.nextPage?exists>
		<a href="inputTestTbl.sp?nowPage=${model.paging.nextPage.nowPage}&allCount=${model.paging.allCount?c}" accesskey="#" title="次のページへ"><span class="stepNavi">次へ</span></a>→
	</#if>
	</#if>
</#if>
