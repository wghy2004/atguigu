<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<title>后台管理</title>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<@nav nav="mainNav"/>
	<#-- 内容开始 -->
	<div id="content">
		<@breadcrumb />
		<div class="warp">
			主面板
		</div>
	</div>
	<#-- 内容结束 --> 
	<#include "/common/footer.ftl"> 
	<@modal/>
</body>
</html>
