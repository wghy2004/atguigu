<#assign base=request.contextPath />
<div class="main" style="background-color: white;">
	<div class="easyui-panel" style="border-style: none;">
		<form  method="post" action="${base}/sys/category/add" class="validate" id="addForm">
			<table>
					<tbody><tr>
						<th>分类名称</th>
						<td>
							<input class="input_text" type="text" id="name" name="name" >
							<input type="hidden"  name="groupId" value="1">
						</td>
					</tr>
					<tr>
						<th>上级分类</th>
						<td>
							<input name="parentId" id="parentId">
							<input type="hidden" name="path" id="path">
						</td>
					</tr>
					<tr>
						<th>代码</th>
						<td>
							<input type="text" class="input_text" name="code"  value="" id="code" >
						</td>
					</tr>
					<tr>
						<th>排序</th>
						<td>
							<input type="text" class="input_text" name="weight"  value="" id="weight" >
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
			height:28,
			onSelect : function(rec){
			  $('#path').val(rec.path+rec.id+'|');
			}
		});
	});
</script>
