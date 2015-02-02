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
		<div class="warp" style="padding:10px;min-height:500px;">
			<h3>欢迎您登录管理后台</h3>
			
			<h5>网站信息</h5>
			<div class="home">
				<p>
					<span>站点名称：</span> <a title="在线课堂" class="imp" href="/html/index.html">在线课堂</a>
				</p>
			</div>
				
			 <h5>数据统计</h5>
			 <div class="home">
				 <p>
				 	<span>昨日注册人数：</span> <b>${model.yesterdayRegCount}</b>
				 </p>
				 <p>
				 	<span>今日注册人数：</span> <b>${model.todayRegCount}</b>
				 </p>
			 </div>
		</div>
	</div>
	<#-- 内容结束 --> 
	<#include "/common/footer.ftl"> 
	<@modal/>
</body>
</html>
