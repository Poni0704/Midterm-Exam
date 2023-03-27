<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="sidebarMenu"
	class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
	<div class="position-sticky pt-3 sidebar-sticky">
		<c:if test="${LoginUser==null}">
			<h4 style="font-weight: bold">
				登入後即可使用以下功能
				<h4>
					<div style="font-size: 10px; color: red">(僅限管理員)</div>
		</c:if>
		<h5>課程管理</h5>

		<c:if test="${LoginUser.isAdmin=='admin' }">
			<ul class="nav flex-column">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="ShowAllProduct.do"> <img
						src="Component/2.png">查詢課程
				</a> <a class="nav-link active" aria-current="page" href="CreatePage.do">
						<img src="Component/2.png">新增課程
				</a></li>
		</c:if>

		<h5>會員管理</h5>

		<c:if test="${LoginUser.isAdmin=='admin' }">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="ShowAllMemberDetail.do"> <img src="Component/2.png">查詢會員
			</a> <a class="nav-link active" aria-current="page" href="CreateMemberDetailPage.do">
					<img src="Component/2.png">新增會員
			</a></li>
		</c:if>
		</ul>
	</div>
</nav>