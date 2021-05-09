<%@ page language="java" contentType="text/html;  charset=UTF-8"
import="java.util.*"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>

  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    
    <title>Sell Assets</title>
    
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
<header>
<jsp:include page="header.jsp"></jsp:include>
</header>
      <br>
      <div class="container">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6 ">
                <div class="card text-center shadow-lg">
                    <img class="card-img-top img-fluid" src="https://previews.123rf.com/images/nesdesign/nesdesign1803/nesdesign180300002/97015699-sell-property-and-building-asset-for-investment-business-concept-3d-rendering.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Sell Assets</h4>
                        <p class="card-text">Select the assets which you want to sell.</p>
                     
                        
                         <form method="post" onSubmit=" return checker();" action="/sellAssetsSelected" >
                        
                         <table border="1" class=table style="margin-left: auto;margin-right: auto;">
                			<tr>
                    			<th scope=col>Asset ID</th>
                    			<!-- <th scope=col>Asset Name</th> -->
                    			<th scope=col>Asset Type</th>
                    			<th scope=col>Number of units you hold</th>
                    			<th scope=col>Units to be sold</th>
                         	<tr>
                         	<c:forEach items="${asset}" var="temp" >
                         	
                        <tr>
                         
                         <td scope=row><input type="checkbox" value="${temp.assetid}" name="selected">${temp.assetid }</td>
                         
                         <td scope=row>${temp.type}</td>
                         <td scope=row>${temp.units}</td>
                         <td scope=row><input  type="number" id="quantity" name="quantity" value="0" min="0" max="${temp.units}"></td> 
                         </c:forEach>
                         
                         </tr>
                        
                         </table>
                         
                         <button type="submit" name="submit"  class="btn btn-black btn-secondary" style="margin-bottom:10px;">SELL</button>
                         </form>     
       
                         
                         
                         
                    </div>
                </div>
            </div>
            </div>
            </div><br>
            <!--footer starts from here-->
	
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
	
            <script type="text/javascript" >
            	var a=document.getElementById("quantity")
            	function checker(){
                	var count=0;
					var l = document.getElementsByName("selected");
					for(var i=0;i<l.length;i++){
						if(l[i].checked)count++;
					}
					//console.log(count);
					 if(count==0){
						alert("Please select a value");
						return false;
					}else return true; 	
                }
            </script>
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