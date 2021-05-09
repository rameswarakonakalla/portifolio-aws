<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

<title>Home</title>

<style type="text/css">
/*footer*/
footer {
	width: 100%;
	background-color: #263238;
	min-height: 100px;
	padding: 10px 0px 25px 0px;
}
/* .pt2 { padding-top:40px ; margin-bottom:20px ;}  */
footer p {
	font-size: 13px;
	color: #CCC;
	padding-bottom: 0px;
	margin-bottom: 8px;
}

.mb10 {
	padding-bottom: 15px;
}

.foote_bottom_ul_amrc li {
	display: inline;
}

.foote_bottom_ul_amrc li a {
	color: #999;
	margin: 0 12px;
}

.social_footer_ul {
	display: table;
	margin: 15px auto 0 auto;
	list-style-type: none;
}

.social_footer_ul li {
	padding-left: 20px;
	padding-top: 10px;
	float: left;
}

.social_footer_ul li a {
	color: #CCC;
	border: 1px solid #CCC;
	padding: 8px;
	border-radius: 50%;
}

.social_footer_ul li i {
	width: 20px;
	height: 20px;
	text-align: center;
}
</style>





</head>
<body>
	<!-- <nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
		<a class="navbar-brand" href="#"
			style="margin-left: 20px; margin-right: 900px;"> <img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjxGDl9hG7JE2Z4YhCgE3D2P4rjn0f0jRiXA&usqp=CAU"
			width="30" height="30" class="d-inline-block align-top" alt="">
			Portfolio Manager
		</a>

		<form action="/logout" method="GET">
			<button type="button float-right" style="margin-right: 20px;"
				class="btn btn-outline-light">LOGOUT</button>
		</form>


	</nav> -->
<header>
<jsp:include page="header.jsp"></jsp:include>
</header>

	<br>
	<div class="container" style="margin-top: 5%">
		<div class="row">
			<div class="col-sm-4">
				<div class="card text-center">
					<img class="card-img-top img-fluid"
						src="https://uci.ac.cr/wp-content/uploads/2016/08/portfolio-management.jpg"
						style="width: 600x; height: 300px;" alt="Card image cap">


					<div class="card-block">
						<h4 class="card-title">View Portfolio</h4>
						<p class="card-text">Click to view shares and funds</p>
						<form action="/viewportfolio" method="GET">
							<button type="submit" value="submit"
								class="btn btn-outline-secondary">PORTFOLIO</button>
						</form>
						<p></p>
					</div>
				</div>
			</div>

			<div class="col-sm-4">
				<div class="card text-center">
					<img class="card-img-top img-fluid"
						src="https://www.thestreet.com/.image/t_share/MTY5NDYzMzA2MzI1NTk5NzA3/stock-vs-shares.png"
						style="width: 600x; height: 300px;" alt="Card image cap">
					<div class="card-block">
						<h4 class="card-title">Net Worth</h4>
						<p class="card-text">Click to calculate net worth</p>
						<form action="/viewNetworth" method="GET">
							<button type="submit" value="submit"
								class="btn btn-outline-secondary">NETWORTH</button>
						</form>
						<p></p>
					</div>
				</div>
			</div>



			<div class="col-sm-4">
				<div class="card text-center">
					<img class="card-img-top img-fluid"
						src="https://g.foolcdn.com/image/?url=https%3A%2F%2Fg.foolcdn.com%2Feditorial%2Fimages%2F606349%2Finvestor-pressing-sell-button-getty.jpg&w=700&op=resize"
						style="width: 600x; height: 300px;" alt="Card image cap">
					<div class="card-block">
						<h4 class="card-title">Sell</h4>
						<p class="card-text">Click to sell asset</p>
						<form action="/sellAssets" method="GET">
							<button type="submit" name="submit"
								class="btn btn-outline-secondary">SELL</button>
						</form>
						<p></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--footer starts from here-->
	<div class="fixed-bottom">
		<footer class="footer">

			<div class="container">

				<p class="text-center">
					&copy Copyright @2021 | <a
						href="https://www.cognizant.com/">Cognizant</a>
				</p>

				<ul class="social_footer_ul">
					<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
					<li><a href="#"><i class="fab fa-twitter"></i></a></li>
					<li><a href="#"><i class="fab fa-linkedin"></i></a></li>
					<li><a href="#"><i class="fab fa-instagram"></i></a></li>
				</ul>
				<!--social_footer_ul ends here-->
			</div>
		</footer>
	</div>
<!-- 
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	 -->

</body>


</html>

