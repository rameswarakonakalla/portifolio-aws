<%@ page language="java" contentType="text/html;  charset=UTF-8"
import="java.util.*"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    
   
    <title>Portfolio</title>
    <style type="text/css">
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
   

<header>
<jsp:include page="header.jsp"></jsp:include>
</header>
      <br>
      <div class="container">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6 ">
                <div class="card text-center shadow-lg">
                    <img class="card-img-top img-fluid" src="https://mediacloud.kiplinger.com/image/private/s--X-WVjvBW--/f_auto,t_content-image-full-desktop@1/v1602615863/Investing/nasdaq-100-etfs-mutual-funds.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Portfolio Details</h4>
                        
                        <p><center>Below are the assets that you own</center></p>
    
    						<form method="get" action="/sellAssets" >
    						
                         <table border="1" class=table style="margin-left: auto;margin-right: auto;">
                			<tr>
                    			<th scope=col>Asset ID</th>
                    			<!-- <th scope=col>Asset Name</th> -->
                    			<th scope=col>Asset Type</th>
                    			<th scope=col>Number of units you hold</th>
                    			
                         	<tr>
                         	<c:forEach items="${asset}" var="temp" >
                        <tr>
                         <td scope=row>${temp.assetid }</td>
                         <%-- <td scope=row>${temp.assetname}</td> --%>
                         <td scope=row>${temp.type}</td>
                         <td scope=row>${temp.units}</td>
                          </c:forEach>
                         </tr>
                         </table>
                         </form>    
                    </div>
                </div>
            </div>
             </div>
             </div>
           <div><br>
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
            
            
           

            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
            
            
</body>
</html>