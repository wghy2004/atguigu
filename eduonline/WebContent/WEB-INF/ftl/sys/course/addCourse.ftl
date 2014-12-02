<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/common.ftl">
<@pnotify/>
<@easyui/>
<style>
<div id="goodsSelectDiv"></div>
	<div id="photoDiv"></div>
	<style>
div {
	display: block
}

.cate-wrapper {
	width: 100%;
	padding: 10px;
	margin: auto;
}

#cate-container {
	border: 1px solid #D5E4FA;
	background: #F5F9FF;
	height: 298px;
}

.cate-wrapper  .nav {
	font-size: 14px;
	background: none repeat scroll 0 0 #F1F7FD;
	font-weight: bold;
	height: 25px;
	overflow: hidden;
	padding: 10px 0 5px 10px;
	text-align: left;
}

#cate-container .cat_box {
	display: block;
	float: left;
	margin-left: 5px;
	width: 223px;
	border-right: 2px solid #D5E4FA;
	overflow-y: auto;
	overflow-x: hidden;
	height: 100%
}

#cate-container .cat_box li {
	padding: 0 16px 0 14px;
	cursor: pointer;
	height: 20px;
	line-height: 20px;
	overflow: hidden;
}

#cate-container li.selected {
	border: 1px solid #9CD7FC;
	background-color: #DFF1FB;
}

#cate-path {
	color: #444;
	padding-top: 9px;
	position: relative;
	line-height: 22px;
	height: 54px;
	display: block;
}

#cate-path dl {
	background-color: #FFFAF2;
	border: 1px solid #FEDBAB;
	padding: 4px 27px;
}

#cate-path dt,#cate-path dd {
	float: left;
	margin: 0;
	padding: 0;
}

#cate-path dt {
	font-weight: 900;
}

#cate-path li {
	float: left;
	margin: 0;
	padding: 0;
}

ul,ol {
	list-style: none outside none;
	margin: 0;
	padding: 0;
}

.clearfix {
	display: block;
	height: 0;
	clear: both;
	height: 22px
}

#cateBottom {
	padding: 5px 0 24px;
	text-align: center;
}
</style>
<script>
$(function(){
	$(".contentTab>ul>li").on('click',function() {
		console.log('sdfsfd');
		var tabid = $(this).attr("tabid");
		$(".contentTab>ul>li").removeClass("contentTabS");
		$(this).addClass("contentTabS");
		$(".tab-page .tab-panel").hide();
		$(".tab-panel[tabid=" + tabid + "]").show();
	});
});

</script>
</head>
<body>
	<#include "/common/navbar.ftl"> 
	<div id="content">
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="#" class="current">Tables</a>
		</div>
		<div class="cate-wrapper">
		<div class="nav">选择分类</div>
		<div id="cate-container">
			<div class="cat_box" id="box_0">
				<li catid="35">珠宝钟表、饰品箱包1</li>
				<li catid="56">機械貿易</li>
				<li catid="79">厨房用品、清洁用品</li>
				<li catid="85">营养保健、健康器械</li>
				<li catid="86">服装鞋靴、内衣佩饰</li>
				<li catid="87">家居运动、汽车维护</li>
				<li catid="88">电脑、软件、办公用品</li>
				<li catid="89">手机通讯、数码电器</li>
			</div>
			<div class="cat_box" id="box_1">
				<li catid="35">珠宝钟表、饰品箱包1</li>
				<li catid="56">機械貿易</li>
				<li catid="79">厨房用品、清洁用品</li>
				<li catid="85">营养保健、健康器械</li>
				<li catid="86">服装鞋靴、内衣佩饰</li>
			</div>
		</div>

		<div id="cate-path">
			<dl>
				<div class="clearfix">
					<dt>您当前选择的是：</dt>
					<dd>
						<ol class="category-path"></ol>
					</dd>
				</div>
			</dl>

		</div>

		<div id="cateBottom">
			<input type="button" value="下一步" id="nextBtn"
				class="button blueButton" disabled="disabled" />
		</div>
	</div>
	</div>
	<#include "/common/footer.ftl"> 
	<@modal/>
</body>
</html>
