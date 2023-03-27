<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header
	class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 ">
	<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6"
		href="index.jsp"><img src="Component/1.png" class="biglogo"><span
		class="biglogofont">EEIT162</span></a>
	<button class="navbar-toggler position-absolute d-md-none collapsed"
		type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
		aria-controls="sidebarMenu" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<input class="form-control form-control-dark w-50 rounded-0 border-0"
		type="text" placeholder="Search" aria-label="Search" id="tags" ><a href="#"><img src="Component/search.png"/></a>
	<div class="navbar-nav">
		
		
		
		
		<!-- 如果username是空值，就看不到任何畫面 -->
		<c:if test="${LoginUser==null}">
			<a class="nav-link px-3" href="LoginPage.jsp"><img
				src="Component/login.png">請登入</a>
		</c:if>


		<!-- 如果username有值，就看到任何畫面 -->
		<c:if test="${LoginUser!=null }">
			<div class="loginfont">Hi!${LoginUser.username}<a href="Logout.do">登出</a></div>
		</c:if>


	</div>
</header>