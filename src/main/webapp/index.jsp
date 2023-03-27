<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.108.0">
<title>Badminton Dashboard</title>

<jsp:include page="style.jsp" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">



<!-- Custom styles for this template -->
<!--<link href="dashboard.css" rel="stylesheet">  -->

</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container-fluid">
		<div class="row">

			<jsp:include page="sidebarnav.jsp" />

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

				<h2>Badminton Management System</h2>
				<div class="table-responsive">
					<div>
						<img src="Component/bwf.jpg" class="logo">
					</div>
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
