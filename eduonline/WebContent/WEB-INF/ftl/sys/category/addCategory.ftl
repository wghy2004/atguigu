<div class="main" style="background-color: white;">
	<div class="easyui-panel" style="border-style: none;">
		<form  method="post" action="${base}/sys/category" class="validate">
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
							<input style="width: 300px;" class="easyui-combotree combo" name="parentId"   id="parentId" data-options="url:'${base}/sys/category/child/0?format=json',method:'get',required:false,height:28" >
						</td>
					</tr>
					<tr>
						<th>代码</th>
						<td>
							<input type="text" class="input_text" name="code"  value="" id="dicValue" >
						</td>
					</tr>
					<tr>
						<th>排序</th>
						<td>
							<input type="text" class="input_text" name="weight"  value="" id="diccategory" >
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(function() {
	});
</script>
