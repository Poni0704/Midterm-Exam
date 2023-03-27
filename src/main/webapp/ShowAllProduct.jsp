<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.108.0">
<title>Badminton Dashboard</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


<style>
.title {
	font-family: 'Noto Sans TC', sans-serif;
	text-align: center;
}

table {
	border: 0.5px solid black;
	border-collapse: collapse;
	margin: auto;
	text-align: center;
	width: 800px;
	font-family: 'Noto Sans TC', sans-serif;
	font-size: 20px;
}

tr, td {
	border: 0.5px solid black;
}

.teacherpic {
	width: 100px;
	height: 100px;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.biglogo {
	margin-right: 20px;
}

.biglogofont {
	font-size: 23px;
	margin-top: 15px;
}

.loginfont {
	color: white;
	font-size: 20px;
	margin-right: 50px;
}

footer {
	background-color: black;
	color: white;
	height: 50px;
	margin-top: 700px;
	text-align: center;
	/* padding-top:10px; */
	font-size: 10px;
}

.highlight {
	background: white;
	color: black;
}

.focus {
	background: black;
}
</style>

<!-- Custom styles for this template -->
<link href="dashboard.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container-fluid">
		<div class="row">

			<jsp:include page="sidebarnav.jsp" />


			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<h2 class="title">Badminton Course</h2>
				<div class="table-responsive">
					<table>
						<thead>
							<tr>
								<td>ID</td>
								<td>授課教師</td>
								<td>課程名稱</td>
								<td>課程費用</td>
								<td>師資照片</td>
								<td>刪除課程</td>
								<td>修改課程</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pList}" var="p">
								<tr>
									<td>${p.id}</td>
									<td>${p.pteacher}</td>
									<td>${p.pcontent}</td>
									<td>${p.price}</td>
									<td><img src="${p.photo}" class="teacherpic"></td>

									<td><a href="DeleteProductByID.do?id=${p.id}"><button>
												<img src="Component/delete.png">
											</button></td>
									</a>
									<td><a href="GetUpdatePage.do?id=${p.id}"><button>
												<img src="Component/pencil.png">
											</button></td>
									</a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</main>
		</div>
	</div>
	<footer class="footer">
		<p>本網頁所載的所有資料、標誌、圖像、影片、連結及其他資料等，僅供資策會(EEIT162)作業使用，如有侵權，請聯繫：a0938659639@gmail.com，會將資料全數下架，謝謝。</p>
		<p>COPYRIGHT© BadmintonCompany. ALL RIGHTS RESERVED.</p>
	</footer>
</body>
</html>