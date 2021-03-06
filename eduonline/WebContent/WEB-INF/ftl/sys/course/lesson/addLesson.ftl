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
	<@nav nav="newLessonNav"/>
	<div id="content">
		<@breadcrumb crumb1="课时" crumb2="新课时"/>
		<div class="main">
		<div class="input">
			<div class="easyui-panel" style="border-style: none;">
				<div style="display: block;" class="goods_input">
					<div class="contentTab">
						<ul class="tab">
							<li tabid="1" class="contentTabS">基本信息</li>
							<li tabid="2">视频</li>
						</ul>
					</div>
					<div class="shadowBoxWhite wf100 whiteBox">
						<div class="text">
							<div class="tab-page">
								<form  method="post" action="${base}/sys/course/lesson/add" class="validate" id="addForm">
								<div tabid="1" class="tab-panel" style="display: block;">
									<table class="form-table" width="100%">
										<tbody>
											<tr>
												<th style="width: 20%;">所属课程：</th>
												<td style="width: 80%; text-align: left;">
													<input type="hidden" name="courseId" id="courseId" value="${model.courseId}">
													<span>${model.sysCourse.title}</span>
												</td>
											</tr>
											<tr>
												<th>标题：</th>
												<td style="text-align: left;">
													<input	class="easyui-validatebox input_text  validatebox-text validatebox-invalid"	type="text" name="title" data-options="required:true"
													datatype="string" isrequired="true" autocomplete="off"
													title="">
												</td>
											</tr>
											<tr>
												<th>课时状态：</th>
												<td style="text-align: left;">
													<input type="radio" name="status" checked="checked" value="unpublished"	class="market_enable"> 草稿&nbsp;&nbsp; 
													<input type="radio" name="status" value="published"	class="market_enable"> 发布&nbsp;&nbsp;
												</td>
											</tr>
											<tr>
												<th>课时类型：</th>
												<td style="text-align: left;">
													<input type="radio"	name="type" checked="checked" value="normal" class="market_enable"> 视频
												</td>
											</tr>
											<tr>
												<th>视频来源：</th>
												<td style="text-align: left;">
													<input type="radio" name="mediaSource" checked="checked" value="self"	class="market_enable"> 本站上传&nbsp;&nbsp; 
													<input type="radio" name="mediaSource" value="youku" class="market_enable"> 优酷
												</td>
											</tr>
											<tr id="mediaYoukuTr" style="display:none;">
												<th>视频地址:</th>
												<td style="text-align: left;">
													<input type="text" id="mediaUri" name="mediaUri" value="" style="width:350px;">
												</td>
											</tr>
											<tr>
												<th>时长：</th>
												<td style="text-align: left;">
													<input type="text" id="mediaLength"	name="length" value="" class="market_enable">
												</td>
											</tr>
											<tr>
												<th>推荐：</th>
												<td style="text-align: left;">
													<input type="radio"	name="recommended" checked="checked" value="1"	class="market_enable"> 是&nbsp;&nbsp; 
													<input type="radio" name="recommended" value="0" class="market_enable"> 否</td>
											</tr>
											<tr>
												<th>推荐序号：</th>
												<td style="text-align: left;">
													<input type="text" class="nodiscount" name="recommendedSeq" value="0">
												</td>
											</tr>
												<tr>
												<th>摘要：</th>
												<td style="text-align: left;">
													<textarea name="summary"></textarea>
												</td>
											</tr>

											<tr>
												<td colspan="2">
													<input type="hidden" name="chapterId" value="0">
													<input type="hidden" name="number" value="3243">
													<input type="hidden" name="seq" value="1">
													<input type="hidden" name="free" value="1">
													<input type="hidden" name="tags" value="">
													<input type="hidden" name="content" value="">
													<input type="hidden" name="giveCredit" value="0">
													<input type="hidden" name="requireCredit" value="0">
													<input type="hidden" name="mediaId" id="mediaId" value="0">
													<input type="hidden" name="mediaName" value="">
													<input type="hidden" name="length" value="">
													<input type="hidden" name="materialNum" value="0">
													<input type="hidden" name="quizNum" value="0">
													<input type="hidden" name="learnedNum" value="0">
													<input type="hidden" name="viewedNum" value="0">
													<input type="hidden" name="startTime" value="">
													<input type="hidden" name="endTime" value="">
													<input type="hidden" name="memberNum" value="0">
													<input type="hidden" name="replayStatus" value="ungenerated">
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
														<th>视频文件：</th>
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
			var aboutEditor ;  
			$(".contentTab>ul>li").on('click',function() {
				var tabid = $(this).attr("tabid");
				$(".contentTab>ul>li").removeClass("contentTabS");
				$(this).addClass("contentTabS");
				$(".tab-page .tab-panel").hide();
				$(".tab-panel[tabid=" + tabid + "]").show();
			});
			KindEditor.ready(function(K) {
				aboutEditor = K.create('textarea[name="summary"]', {
					items :['source','bold','italic','underline','strikethrough','|','undo','redo','cut','copy','paste','selectall','plainpaste'],
					newlineTag : 'br'
				});
				prettyPrint();
			});
			//视频来源
			$('input[name=mediaSource]').on('change',function(){
				var source = $(this).val();
				if(source == 'youku'){
					$('#mediaYoukuTr').show();
					$('#mediaSelfTr').hide();
				}else if(source=='self'){
					$('#mediaSelfTr').show();
					$('#mediaYoukuTr').hide();
				}
			});
			//视频
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
								$('#addForm input[name=mediaId]').val(result.message.id);
								$('#addForm input[name=mediaUri]').val(result.message.uri);
								$('#addForm input[name=mediaSource]').val('self');
								$('#addForm input[name=length]').val($('#mediaLength').val());
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
			
				$('#about').val(aboutEditor.html());
				
				var formflag = $("#addForm").form('validate');
				if (formflag) {
					$("#lessonAddBtn").linkbutton("disable");
					$.Loading.show("正在保存请稍后..");
					var options = {
						url : '${base}/sys/course/lesson',
						type : "POST",
						dataType : "json",
						success : function(result) {
							$.Loading.success('成功添加课时:'+result.message.title);
							if (result.status == 'OK') {
								window.location.href = "${base}/sys/course/lesson";
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
