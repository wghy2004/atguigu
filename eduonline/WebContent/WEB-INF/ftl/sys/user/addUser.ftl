<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>后台管理</title>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<@kindeditor/>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<@nav nav="userNav"/>
	<#-- 内容开始 -->
	<div id="content">
		<@breadcrumb crumb1="用户" crumb2="新用户"/>
		<div class="main">
		<div class="input">
			<div class="easyui-panel" style="border-style: none;">
				<div style="display: block;" class="goods_input">
					<div class="contentTab">
						<ul class="tab">
							<li tabid="1" class="contentTabS">基本信息</li>
							<li tabid="2">头像</li>
						</ul>
					</div>
					<div class="shadowBoxWhite wf100 whiteBox">
						<div class="text">
							<div class="tab-page">
								<form  method="post" action="${base}/sys/course/user/add" class="validate" id="addForm">
								<div tabid="1" class="tab-panel" style="display: block;">
									<table class="form-table" width="100%">
										<tbody>
											<tr>
												<th style="width: 20%;">用户名：</th>
												<td style="width: 80%; text-align: left;">
													<input type="text" name="nickname">
												</td>
											</tr>
											<tr>
												<th>密码：</th>
												<td style="text-align: left;">
													<input	class="easyui-validatebox input_text  validatebox-text validatebox-invalid"	type="text" name="password" data-options="required:true"
													datatype="string" isrequired="true" autocomplete="off"
													title="">
												</td>
											</tr>
											<tr>
												<th>邮箱：</th>
												<td style="text-align: left;">
													<input	class="easyui-validatebox input_text  validatebox-text validatebox-invalid"	type="text" name="email" data-options="required:true"
													datatype="string" isrequired="true" autocomplete="off"
													title="">
												</td>
											</tr>
											<tr>
												<th>是否禁止：</th>
												<td style="text-align: left;">
													<input type="radio" name="locked" checked="checked" value="0"	class="market_enable"> 正常&nbsp;&nbsp; 
													<input type="radio" name="locked" value="1"	class="market_enable"> 禁止&nbsp;&nbsp;
												</td>
											</tr>
											<tr>
												<th>角色：</th>
												<td style="text-align: left;">
													<select name="roles">
														<option value="">请选择</option>
														<option value="member">注册会员</option>
														<option value="teacher">老师</option>
														<option value="admin">管理员</option>
													</select>
												</td>
											</tr>

											<tr>
												<td colspan="2">
													<input type="hidden" name="chapterId" value="0">
													<input type="hidden" name="salt" value="">
													<input type="hidden" name="uri" value="">
													<input type="hidden" name="tags" value="1">
													<input type="hidden" name="type" value="">
													<input type="hidden" name="title" value="">
													<input type="hidden" name="point" value="0">
													<input type="hidden" name="coin" value="0">
													<input type="hidden" name="smallAvatar" value="0">
													<input type="hidden" name="mediumAvatar" id="mediaId" value="">
													<input type="hidden" name="mediaName" value="">
													<input type="hidden" name="largeAvatar" value="">
													
													<input type="hidden" name="emailVerified" value="0">
													<input type="hidden" name="setup" value="0">
													
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								</form>
								<div tabid="2" style="display: none;" class="tab-panel">
									<div id="album_tab" class="form-table albumbox">
										<div ><img style="max-height:300px;" id="largePicturePreview" src="" /></div>
										<form  method="post" action="${base}/sys/file/upload" class="validate" id="addFileForm" enctype="multipart/form-data">
											<table>
													<tbody>
													<tr id="mediaSelfTr">
														<th>头像：</th>
														<td style="text-align: left;">
															<input class="input_text" type="file" id="files" name="files" >
														</td>
													</tr>
												</tbody>
											</table>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			<div class="buttonWrap">
				<a href="javascript:;" class="easyui-linkbutton" id="lessonAddBtn">确定</a>
			</div>
		</div>
	</div>
	</div>
	</div>
	<#include "/common/footer.ftl"> 
	<@modal/>
	<script>
		$(function(){
			//头像
			$('#files').on('change',function(){
				var formflag = $("#addFileForm").form('validate');
				if (formflag) {
					$.Loading.show("正在上传封面请稍后..");
					var options = {
						url : '${base}/sys/file/upload',
						type : "POST",
						dataType : "json",
						success : function(result) {
							if (result.status == 'OK') {
								$.Loading.success('视频上传成功!');
								$('#addForm input[name=title]').val(result.message.uri);
							}
						},
						error : function(e) {
							$.Loading.error("出错了,请重试");
						}
					};
					$('#addFileForm').ajaxSubmit(options);
				}
			});
			
			$("#lessonAddBtn").click(function() {
			
				var formflag = $("#addForm").form('validate');
				if (formflag) {
					$("#lessonAddBtn").linkbutton("disable");
					$.Loading.show("正在保存请稍后..");
					var options = {
						url : '${base}/sys/user',
						type : "POST",
						dataType : "json",
						success : function(result) {
							$.Loading.success('成功添加用户!');
							if (result.status == 'OK') {
								window.location.href = "${base}/sys/user";
							}else{
								$.Loading.error("出错了,请重试");
							}
						},
						error : function(e) {
							$.Loading.error("出错了,请重试");
							$("#lessonAddBtn").linkbutton("enable");
						}
					};
					$('#addForm').ajaxSubmit(options);
				}
			});
			
		});
	</script>
</body>
</html>
