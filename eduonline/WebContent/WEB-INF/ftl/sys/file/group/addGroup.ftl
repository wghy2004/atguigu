<#assign base=request.contextPath />
<div class="main" style="background-color: white;">
	<div class="easyui-panel" style="border-style: none;">
		<form  method="post" action="${base}/sys/file/group/add" class="validate" id="addForm">
			<table>
					<tbody><tr>
						<th>分类名称</th>
						<td>
							<input class="input_text" type="text" id="name" name="name" >
						</td>
					</tr>
					<tr>
						<th>代码</th>
						<td>
							<input type="text" class="input_text" name="code"  value="" id="code" >
						</td>
					</tr>
					<tr>
						<th>公开</th>
						<td>
							<input type="radio"   name="isPublic"  value="0" id="isPublic" checked="checked"> 否 
							<input type="radio"   name="isPublic"  value="1" > 是 
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
