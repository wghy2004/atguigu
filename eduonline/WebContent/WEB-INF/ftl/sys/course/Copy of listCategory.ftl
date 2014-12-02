<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<title>分组类型</title>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<#-- 内容开始 -->
	<div class="warp container">
		<form action="${base}/sys/category">

			<#-- 查询条件 -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<span>查询条件</span>
					<ul class="option-group">
						<li><a href="javascript:void(0)" ssr-show-detail="detail" class="glyphicon glyphicon-chevron-down" title="高级查询"></a></li>
					</ul>
				</div>
				<table class="table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<th>名称</th>
							<td><input type="text" class="form-control" name="dicNameLike" value="${(query.dicNameLike)!}"></td>
							<th>组</th>
							<td><input type="text" class="form-control" name="dicGroupLike" value="${(query.dicGroupLike)!}"></td>
							<td rowspan="10">
								<button type="submit" class="btn btn-default">
									<span class="glyphicon glyphicon-search"></span> 查询
								</button>
							</td>
						</tr>
						<tr class="detail hidden">
							<th>组</th>
							<td><input type="text" class="form-control"></td>
							<th>类型</th>
							<td><input type="text" class="form-control"></td>
						</tr>
						<tr class="detail hidden">
							<th>组</th>
							<td><input type="text" class="form-control"></td>
							<th>类型</th>
							<td><input type="text" class="form-control"></td>
						</tr>
					</tbody>
				</table>
			</div>

			<#-- 结果列表 -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<span>分组类型列表</span>
					<ul class="option-group">
						<li><a data-toggle="modal" data-backdrop="static" data-target="#myModal" href="${base}/sys/category/add" class="glyphicon glyphicon-plus" title="添加"></a></li>
						<li><a href="${base}/sys/category/group/delete" ssr-delete-all="checkboxItem" class="glyphicon glyphicon-trash" title="批量删除"></a></li>
					</ul>
				</div>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th><input type="checkbox" ssr-select-all="checkboxItem"> 序号</th>
							<th>名称</th>
							<th>代码</th>
							<th>上级分类</th>
							<th>所属分组</th>
							<td>权重</td>
							<th>操作</th>
						</tr>
					</thead>
					<#list page.content as result>
					<tr>
						<td>
							<input type="checkbox" class="checkboxItem" value="${result.id}">
							<a href="${base}/sys/category/group/${result.id}" data-toggle="modal" data-backdrop="static" data-target="#myModal">${result_index+1}</a>
						</td>
						<td>${result.name}</td>
						<td>${result.code}</td>
						<td>${result.parentName}</td>
						<td>${result.sysCategoryGroup.name}</td>
						<td>${result.weight}</td>
						<td>
							<ul class="option-group">
								<li><a data-toggle="modal" data-backdrop="static" data-target="#myModal" href="${base}/sys/category/edit/${result.id}" title="编辑"
									class="glyphicon glyphicon-edit"></a></li>
								<li><a href="${base}/sys/category/${result.id}" ssr-delete-one title="删除" class="glyphicon glyphicon-trash"></a>
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
	<#-- 内容结束 --> 
	<#include "/common/footer.ftl"> 
	<@modal/>
</body>
</html>
