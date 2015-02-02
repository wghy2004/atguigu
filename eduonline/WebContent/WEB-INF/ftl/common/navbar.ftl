<#assign base=request.contextPath />
<!-- SSR实验员--导航条开始 -->
<div id="header">
	<h1><a href="./dashboard.html">Unicorn Admin</a></h1>		
</div>
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav btn-group">
        <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">${user.nickname}</span></a></li>
        <li class="btn btn-inverse"><a title="" href="${base}/sys/logout"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
    </ul>
</div>
<#macro nav nav>    
<div id="sidebar">
	<ul>
		<li id="mainNav"><a href="/eduonline/sys/admin"><i class="icon icon-home"></i> <span>主面板</span></a></li>
		<li class="submenu">
			<a href="#"><i class="icon icon-inbox"></i> <span>系统设置</span> <span class="label">1</span></a>
			<ul>
				<li id="templateNav"><a href="/eduonline/sys/template">静态化</a></li>
			</ul>
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
			<a href="#"><i class="icon icon-file"></i> <span>课时</span> <span class="label">1</span></a>
			<ul>
				<li id="lessonNav"><a href="/eduonline/sys/course/lesson">全部课时</a></li>
			</ul>
		</li>
		<li class="submenu">
			<a href="#"><i class="icon icon-file"></i> <span>文件</span> <span class="label">2</span></a>
			<ul>
				<li id="fileNav"><a href="${base}/sys/file">文件列表</a></li>
				<li id="fileGroupNav"><a href="${base}/sys/file/group">文件组</a></li>
			</ul>
		</li>
		<li  class="submenu">
			<a href="#"><i class="icon icon-signal"></i> <span>用户</span> <span class="label">1</span></a>
			<ul>
				<li id="userNav"><a href="${base}/sys/user?roles=member">学员列表</a></li>
				<li id="teacherNav"><a href="${base}/sys/user?roles=teacher">老师列表</a></li>
				<li id="adminNav"><a href="${base}/sys/user?roles=admin">管理员列表</a></li>
			</ul>
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