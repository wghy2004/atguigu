<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<title>课程</title>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<#-- 内容开始 -->
	<div id="content">
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="#" class="current">Tables</a>
		</div>
			
		<!-- 工具栏 -->
		<div class='buttonArea'>
			<span id="searchbtn">	
				<a href="javascript:void(0)" class="button blueButton"  onclick="newTab('添加商品','/version4/shop/admin/goods!selectCat.do')">添加</a>
				<a href="javascript:void(0)" class="button"  onclick="del()">删除</a>
				<a href="javascript:void(0)" class="button"  onclick="newTab('商品回收站','/version4/shop/admin/goods!trash_list.do')">回收站</a>
			</span>
			<span class="fr"> 
				<input id="searchKeyword" class="input_text  mr5" type="text" value="" size="30"	placeholder="请输入模糊关键字" name="searchKeyWord">
				<a href="javascript:void(0)" class="button " id="aAdvanced"  >高级搜索</a>
				<a href="javascript:void(0)" class="button " onclick="searchGoods()">搜索</a>
			</span>
		</div>
		
		<div id="tb" style="padding:5px;height:auto">
	        <div style="margin-bottom:5px">
	            <a href="${base}/sys/course/add"  title="添加" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
	            <a data-toggle="modal" data-backdrop="static" data-target="#myModal" href="${base}/sys/course/edit" id="btnEdit" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
	            <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
	            <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
	            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
	        </div>
	        <div>
	            分组: 
	            <select id="group" name="group" class="easyui-combobox" panelHeight="auto" style="width:100px">
						<option value="0">请选择</option>
						<#list model.groupList as group>
						<option value="${group.id}">${group.name}</option>
						</#list>
				</select>
	        </div>
	    </div>
		<#-- 结果列表 -->
		<table id="dg" style="width:100%;height:auto;border:1px solid #ccc;">
        <thead>
            <tr>
                <th data-options="field:'id'">id</th>
                <th data-options="field:'title',width:15">标题</th>
                <th data-options="field:'subtitle',width:20">副标题</th>
                <th data-options="field:'status',width:5">状态</th>
                <th data-options="field:'type',width:5">类型</th>
                <th data-options="field:'price',width:5">价格</th>
                <th data-options="field:'lessonNum',width:5">课时数</th>
                <th data-options="field:'studentNum',width:5">学员数</th>
                <th data-options="field:'sysCategory.name',width:5">课程分类</th>
                <th data-options="field:'createdTime',width:10">创建时间</th>
                <th data-options="field:'action',width:10" formatter="formatAction">操作</th
            </tr>
        </thead>
        <tbody>
     	   <#list page.content as result>
            <tr>
                <td>${result.id}</td><td>${result.title}</td><td>${result.subtitle}</td><td>${result.status}</td>
                <td>${result.type}</td>
                <td>${result.price}</td>
                <td>${result.lessonNum}</td>
                <td>${result.studentNum}</td>
                <td>${result.sysCategory.name}</td>
                <td>${result.createdTime}</td>
                <td><a>修改</a>&nbsp;&nbsp;<a>删除</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
	</div>
	<#-- 内容结束 --> 
	<#include "/common/footer.ftl"> 
	<@modal/>
	<script type="text/javascript">
		function formatAction(value,row,index){
			var val="<a class='edit' title='查看' href='#'>编辑</a><a class='edit' title='查看' href='#'>删除</a>";
			return val;
		}
		$(function(){
			$('#dg').datagrid({
				fit : true,
				fitColumns : true
			});
		});	
	</script>
</body>
</html>
