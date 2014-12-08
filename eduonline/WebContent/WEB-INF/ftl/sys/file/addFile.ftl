<#assign base=request.contextPath />
<div class="main" style="background-color: white;">
	<div class="easyui-panel" style="border-style: none;">
		<form  method="post" action="${base}/sys/file/upload" class="validate" id="addForm" enctype="multipart/form-data">
			<table>
					<tbody>
					<tr>
						<th>文件组</th>
						<td><input id="groupId" class="easyui-combobox" name="groupId"   data-options="valueField:'id',method:'get',textField:'name',url:'${base}/sys/file/group/list'"></td>
					</tr>
					<tr>
						<th>选择文件</th>
						<td>
							<input class="input_text" type="file" id="files" name="files" >
						</td>
					</tr>
					<tr>
						<th>状态</th>
						<td>
							<input type="text" class="input_text" name="status"  value="0" id="status" >
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
