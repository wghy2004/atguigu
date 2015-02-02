<#assign base=request.contextPath />
<#if Session.admin?exists>  
	 <#assign user = Session["admin"]>
</#if>  


<#-- 公共标签引入 -->
<#include "/common/breadcrumb.ftl"/>
<#include "/common/easyui-page.ftl"/>
<#include "/common/page.ftl"/>
<#include "/common/modal.ftl"/>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<#--CSS样式定义 -->
<link href="${base}/resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${base}/resources/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${base}/resources/css/uniform.css" />
<link rel="stylesheet" href="${base}/resources/css/select2.css" />		
<link rel="stylesheet" href="${base}/resources/css/unicorn.main.css" />
<link rel="stylesheet" href="${base}/resources/css/unicorn.grey.css" class="skin-color" />
<link rel="stylesheet" type="text/css" href="${base}/resources/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="${base}/resources/css/main.css">
<link rel="stylesheet" type="text/css" href="${base}/resources/css/style.css">

<#-- JS脚本定义 -->
<script type="text/javascript" src="${base}/resources/js/jquery/1.11.0/jquery-1.11.0.min.js"></script>
<script src="${base}/resources/js/jquery.blockUI.js"></script>
<script src="${base}/resources/js/jquery.loading.js"></script>
<script src="${base}/resources/js/jquery.form.js"></script>
<script type="text/javascript" src="${base}/resources/js/bootstrap.min.js"></script>
<script src="${base}/resources/js/unicorn.js"></script>
<script src="${base}/resources/js/common/common.js"></script>
<script src="${base}/resources/js/common/util.js"></script>

<#-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="${base}/resources/js/common/html5shiv.min.js"></script>
  <script src="${base}/resources/js/common/respond.min.js"></script>
<![endif]-->

<#-- easyui组件信息 --> 
<#macro easyui>
<link href="${base}/resources/plugs/easy-ui/1.3.5/themes/gray/easyui.css" rel="stylesheet">
<link href="${base}/resources/plugs/easy-ui/1.3.5/themes/icon.css" rel="stylesheet">
<script type="text/javascript" src="${base}/resources/plugs/easy-ui/1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${base}/resources/plugs/easy-ui/1.3.5/locale/easyui-lang-zh_CN.js"></script>
</#macro>
<#-- jstree组件信息 --> 
<#macro jstree>
<link rel="stylesheet" href="${base}/resources/plugs/jstree/3.0.8/dist/themes/default/style.min.css" />
<script type="text/javascript" src="${base}/resources/plugs/jstree/3.0.8/dist/jstree.min.js"></script>
</#macro>

<#-- pnotify组件  -->
<#macro pnotify>
	<link href="${base}/resources/plugs/pnotify/1.2.2/jquery.pnotify.default.css" rel="stylesheet">
	<link href="${base}/resources/plugs/pnotify/1.2.2/jquery.pnotify.default.icons.css" rel="stylesheet">
	<script type="text/javascript" src="${base}/resources/plugs/pnotify/1.2.2/jquery.pnotify.js"></script>
</#macro>
<#-- kindeditor组件  -->
<#macro kindeditor>
	<link rel="stylesheet" href="${base}/resources/plugs/kindeditor/4.1.10/themes/default/default.css" />
	<link rel="stylesheet" href="${base}/resources/plugs/kindeditor/4.1.10/plugins/code/prettify.css" />
	<script charset="utf-8" src="${base}/resources/plugs/kindeditor/4.1.10/kindeditor.js"></script>
	<script charset="utf-8" src="${base}/resources/plugs/kindeditor/4.1.10/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${base}/resources/plugs/kindeditor/4.1.10/plugins/code/prettify.js"></script>
</#macro>

