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
<!-- 製作給使用者填的表單 -->
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

.memberdetailpic {
	width: 100px;
	height: 100px;
}

.formgroup {
	clear: left;
	width: 450px;
	border-bottom: 2px solid gray;
	margin: 20px;
	padding-bottom: 20px;
}

/* 按鈕對齊 */
.buttongroup {
	width: 450px;
	margin: 10px auto;
	text-align: center;
}

/* 項目標題文字對齊 */
.t1 {
	float: left;
	width: 100px;
	text-align: right;
}

fieldset {
	width: 500px;
	border-radius: 15px;
	margin: auto;
	border: 3px solid rgb(53, 52, 52)
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
	height: 54px;
	margin-top: 38px;
	text-align: center;
	/* padding-top:10px; */
	font-size: 10px;
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
				<h2 class="title">Update MemberDetail</h2>
				<div class="table-responsive">

					<form action="UpdateMemberDetail.do" method="post"
						enctype="multipart/form-data">
						<fieldset>
							<div class="formgroup">
								<label class="t1">會員姓名：</label> <input type="text"
									value="${memberdetail.username}" name="username" />
							</div>

							<div class="formgroup">
								<label class="t1">性別：</label> <input type="text"
									value="${memberdetail.gender}" name="gender" />
							</div>

							<div class="formgroup">
								<label class="t1">年齡： </label> <input type="text"
									value="${memberdetail.age}" name="age" />
							</div>
							<div class="formgroup">
								<label class="t1">生日：</label> <input type="text"
									value="${memberdetail.birth}" name="birth" />
							</div>

							<div class="formgroup">
								<label class="t1">電話：</label> <input type="text"
									value="${memberdetail.phone}" name="phone" />
							</div>

							<div class="formgroup">
								<label class="t1">住址： </label> <input type="text"
									value="${memberdetail.address}" name="address" />
							</div>
							<div class="formgroup">
								<label class="t1">信箱： </label> <input type="text"
									value="${memberdetail.email}" name="email" />
							</div>

							<div class="formgroup">
								<label class="t1">大頭貼： </label> <img src="${memberdetail.photo}"
									class="memberdetailpic" /> <input type="file" name="photo" />
							</div>
						</fieldset>

						<div class="buttongroup">
							<input type="submit" value="送出" name="submit" /> <input
								type="reset" value="清除" name="reset" />
						</div>
					</form>
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
