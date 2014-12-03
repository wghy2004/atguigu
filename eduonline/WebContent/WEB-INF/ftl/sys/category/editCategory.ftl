<#assign base=request.contextPath />
<div class="main" style="background-color: white;">
	<div class="easyui-panel" style="border-style: none;">
		<form class="validate" id="editForm">
			<table>
					<tbody><tr>
						<th>分类名称</th>
						<td>
							<input class="input_text" type="text" id="name" name="name" value="${category.name}">
							<input type="hidden"  name="id" value="${category.id}">
							<input type="hidden"  name="groupId" value="${category.groupId}">
						</td>
					</tr>
					<tr>
						<th>上级分类</th>
						<td>
							<input name="parentId" id="parentId" value="${category.parentId}">
							<input type="hidden" name="path" id="path" value="${category.path}">
						</td>
					</tr>
					<tr>
						<th>代码</th>
						<td>
							<input type="text" class="input_text" name="code"  value="${category.code}" id="code" >
						</td>
					</tr>
					<tr>
						<th>排序</th>
						<td>
							<input type="text" class="input_text" name="weight"  value="${category.weight}" id="weight" >
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$('#parentId').combotree({
			url:'${base}/sys/category/combotree?format=json',
			method:'get',
			required:false,
			value:'${category.parentId}',
			height:28,
			onSelect : function(rec){
			  $('#path').val(rec.path+rec.id+'|');
			}
		});
	});
</script>
