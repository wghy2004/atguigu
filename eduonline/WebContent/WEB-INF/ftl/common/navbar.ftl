<#assign base=request.contextPath />
<!-- SSR实验员--导航条开始 -->
<div id="header">
	<h1><a href="./dashboard.html">Unicorn Admin</a></h1>		
</div>
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav btn-group">
        <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">${user.nickname}</span></a></li>
        <li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a class="sAdd" title="" href="#">new message</a></li>
                <li><a class="sInbox" title="" href="#">inbox</a></li>
                <li><a class="sOutbox" title="" href="#">outbox</a></li>
                <li><a class="sTrash" title="" href="#">trash</a></li>
            </ul>
        </li>
        <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
        <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
    </ul>
</div>
<#macro nav nav>    
<div id="sidebar">
	<a href="#" class="visible-phone"><i class="icon icon-th-list"></i> Tables</a>
	<ul>
		<li id="mainNav"><a href="/eduonline/sys/admin"><i class="icon icon-home"></i> <span>主页</span></a></li>
		<li>
			<a href="widgets.html"><i class="icon icon-inbox"></i> <span>系统设置</span></a>
		</li>
		<li class="submenu">
			<a href="#"><i class="icon icon-th-list"></i> <span>课程</span> <span class="label">3</span></a>
			<ul>
				<li id="newCourseNav"><a href="/eduonline/sys/course/add">新课程</a></li>
				<li id="courseCategoryNav"><a href="/eduonline/sys/category/">课程分类</a></li>
				<li id="courseNav"><a href="/eduonline/sys/course">全部课程</a></li>
			</ul>
		</li>
		<li class="submenu">
			<a href="#"><i class="icon icon-file"></i> <span>课时</span> <span class="label">2</span></a>
			<ul>
				<li><a href="invoice.html">新课时</a></li>
				<li><a href="chat.html">全部课时</a></li>
			</ul>
		</li>
		<li class="submenu">
			<a href="#"><i class="icon icon-file"></i> <span>文件</span> <span class="label">5</span></a>
			<ul>
				<li><a href="invoice.html">上传视频</a></li>
				<li><a href="chat.html">视频列表</a></li>
				<li><a href="chat.html">图片列表</a></li>
				<li id="fileNav"><a href="${base}/sys/file">文件列表</a></li>
				<li id="fileGroupNav"><a href="${base}/sys/file/group">文件组</a></li>
			</ul>
		</li>
		<li>
			<a href="charts.html"><i class="icon icon-signal"></i> <span>用户</span></a>
		</li>
	</ul>
</div>
<script>
	$(function(){
		var curNav = '${nav}';
		$('#sidebar li').removeClass('active open');
		$('li#'+curNav).addClass('active').parents('.submenu').addClass('active open');
	});
</script>
</#macro>
<!-- 导航条结束 -->