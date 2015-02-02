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
		<@breadcrumb crumb1="用户" crumb2="用户资料"/>
		<div class="main">
		<div class="input">
			<div class="easyui-panel" style="border-style: none;">
				<div style="display: block;" class="goods_input">
					<div class="contentTab">
						<ul class="tab">
							<li tabid="1" class="contentTabS">用户资料</li>
						</ul>
					</div>
					<div class="shadowBoxWhite wf100 whiteBox">
						<div class="text">
							<div class="tab-page">
								<form  method="post" action="${base}/sys/user/profile" class="validate" id="addForm">
								<input type="hidden" name="_method" value="put">
								<input type="hidden" name="id"  value="${profile.id}">
								<div tabid="1" class="tab-panel" style="display: block;">
									<table class="form-table" width="100%">
										<tbody>
											<tr>
												<th style="width: 20%;">真实姓名：</th>
												<td style="width: 80%; text-align: left;">
													<input type="text" name="truename" id="truename" value="${profile.truename}">
												</td>
											</tr>
											<tr>
												<th>身份证号码：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.idcard}"  name="idcard"	>
												</td>
											</tr>
											<tr>
												<th>性别：</th>
												<td style="text-align: left;">
													<input type="radio"	name="gender"  <#if profile.gender =="male">checked</#if>  value="male" class="market_enable">  男&nbsp;&nbsp;
													<input type="radio" name="gender"  <#if profile.gender =="female">checked</#if> value="female"	class="market_enable"> 女&nbsp;&nbsp; 
													<input type="radio" name="gender"  <#if profile.gender =="secret">checked</#if> value="secret" class="market_enable"> 保密
												</td>
											</tr>
											<tr>
												<th>我是谁：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.iam}"  name="iam"	>
												</td>
											</tr>
											<tr>
												<th>生日：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.birthday}"  name="birthday"	>
												</td>
											</tr>
											<tr>
												<th>城市：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.city}"  name="city" >
												</td>
											</tr>
											<tr>
												<th>手机：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.mobile}"  name="mobile" >
												</td>
											</tr>
											<tr>
												<th>QQ：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.qq}"  name="qq" >
												</td>
											</tr>
											<tr>
												<th>签名：</th>
												<td style="text-align: left;">
													<textarea name="signature" style="width:180px">${profile.signature}</textarea>
												</td>
											</tr>
											<tr>
												<th>自我介绍：</th>
												<td style="text-align: left;">
													<textarea name="about" style="width:480px;height:100px;">${profile.about}</textarea>
												</td>
											</tr>
											<tr>
												<th>公司：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.company}"  name="company" >
												</td>
											</tr>
											<tr>
												<th>工作：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.job}"  name="job" >
												</td>
											</tr>
											<tr>
												<th>学校：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.school}"  name="school" >
												</td>
											</tr>
											<tr>
												<th>班级：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.clazz}"  name="clazz" >
												</td>
											</tr>
											<tr>
												<th>微博：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.weibo}"  name="weibo" >
												</td>
											</tr>
											<tr>
												<th>微信：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.weixin}"  name="weixin" >
												</td>
											</tr>
											<tr>
												<th>网站：</th>
												<td style="text-align: left;">
													<input type="text"  value="${profile.site}"  name="site" >
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			<div class="buttonWrap">
				<a href="javascript:;" class="easyui-linkbutton" id="courseAddBtn">确定</a>
			</div>
		</div>
	</div>
	</div>
	</div>
	<#include "/common/footer.ftl"> 
	<@modal/>
	<script>
		$(function(){
			$("#courseAddBtn").click(function() {
				var formflag = $("#addForm").form('validate');
				if (formflag) {
					$("#courseAddBtn").linkbutton("disable");
					$.Loading.show("正在保存请稍后..");
					var options = {
						url : '${base}/sys/user/profile',
						type : "POST",
						dataType : "json",
						success : function(result) {
							$.Loading.success('成功添加资料');
							if (result.status == 'OK') {
								window.location.href = "${base}/sys/user";
							}else{
								$.Loading.error("出错了,请重试");
							}
						},
						error : function(e) {
							$.Loading.error("出错了,请重试");
							$("#courseAddBtn").linkbutton("enable");
						}
					};
					$('#addForm').ajaxSubmit(options);
				}
			});
			
		});
	</script>
</body>
</html>
