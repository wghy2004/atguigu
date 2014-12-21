<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<title>用户列表</title>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<@nav nav="userNav"/>
	<#-- 内容开始 -->
	<div id="content">
		<@breadcrumb crumb1="用户" crumb2="注册用户"/>
		<div class="warp">
		<form action="${base}/sys/user">
			<#-- 结果列表 -->
			<div class="panel panel-default">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th><input type="checkbox" ssr-select-all="checkboxItem"> 序号</th>
							<th>昵称</th>
							<th>角色</th>
							<th>邮箱是否验证</th>
							<th>是否禁止</th>
							<th>最后登陆时间</th>
							<th>最后登陆ip</th>
							<th>操作</th>
						</tr>
					</thead>
					<#list page.content as result>
					<tr>
						<td>
							<input type="checkbox" class="checkboxItem" value="${result.id}">
							<a href="${base}/sys/user/${result.id}" data-toggle="modal" data-backdrop="static" data-target="#myModal">${result_index+1}</a>
						</td>
						<td>${result.nickname}</td>
						<td>${result.roles}</td>
						<td>${result.emailVerified}</td>
						<td>${result.locked}</td>
						<td>${result.loginTime}</td>
						<td>${result.loginIp}</td>
						<td>
							<ul class="option-group">
								<li><a data-toggle="modal" data-backdrop="static" data-target="#myModal" href="${base}/sys/user/edit/${result.id}" title="编辑"
									class="glyphicon glyphicon-edit"></a></li>
								<li><a href="${base}/sys/user/${result.id}" ssr-delete-one title="删除" class="glyphicon glyphicon-trash"></a>
								</li>
							</ul>
						</td>
					</tr>
					</#list>
					<tr>
						<td colspan="100"><@tablePage/></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	</div>
	<#-- 内容结束 --> 
	<#include "/common/footer.ftl"> 
	<@modal/>
</body>
</html>
