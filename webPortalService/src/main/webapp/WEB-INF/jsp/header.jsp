<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
    background-color: whitesmoke;
}

    
    .topnav {
      overflow: hidden;
      background-color: #333;
      
    }
    
    .topnav a {
      float: left;
      color: #f2f2f2;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
      
    }
    
    
    
    
    .topnav-right {
      float: right;
    }

.navbar {
    position: fixed;
    display: flex;
    padding: .4rem 1rem;
    background-color: #343a40 !important;
    -webkit-box-sizing: border-box;
            box-sizing: border-box;
    line-height: 1.649999;
    width: 100%;
    -webkit-box-shadow: 0px 3px 5px black;
            box-shadow: 0px 3px 5px black;
            z-index: 999;
  }
  
  .navbar-nav {
    display: -ms-flexbox;
    display: -webkit-box;
    display: flex;
    margin-top: -6vh;
    /* margin-right: 8%; */
    -ms-flex-direction: row;
    -webkit-box-orient: horizontal;
    -webkit-box-direction: normal;
            flex-direction: row;
    list-style: none;
  }
  .nav-link {
    display: block;
    color: white;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    text-decoration: none;
    cursor: pointer;
  }
  
  .nav-link:hover {
    color:lightgray;
  }
  
  .nav-link:active {
    color: lightgray;
  }
  
  .navbar-brand {
    display: inline-block;
    padding-top: .3125rem;
    padding-bottom: .3125rem;
    margin-right: 1rem;
    font-size: 1.25rem;
    line-height: inherit;
    white-space: nowrap;
    color: whitesmoke;
    padding-left: 2rem;
  /* margin-left: 1rem; */
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    text-decoration: none;
  }
  
  .navbar-brand:hover {
    color: lightgray;
  }
  
  .navbar-brand:active {
    color: lightgray;
  }
  /* The sidebar menu */
.sidebar {
  height: 100%; /* 100% Full-height */
  width: 0; /* 0 width - change this with JavaScript */
  position: fixed; /* Stay in place */
  /* z-index: 1; Stay on top */
  top: 0;
  right: 0;
  background-color: #111; /* Black*/
  overflow-x: hidden; /* Disable horizontal scroll */
  padding-top: 60px; /* Place content 60px from the top */
  transition: 0.5s; /* 0.5 second transition effect to slide in the sidebar */
  z-index: 9;
}

/* The sidebar links */
.sidebar a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 18px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

/* When you mouse over the navigation links, change their color */
.sidebar a:hover {
  color: #f1f1f1;
}

/* Position and style the close button (top right corner) */
.sidebar .closebtn {
  position: absolute;
  top: 6%;
  right: 10px;
  font-size: 36px;
  margin-left: 50px;
}

/* The button used to open the sidebar */
.openbtn {
 
  cursor: pointer;
  
  color: whitesmoke;
  
  /* padding: 10px 15px; */
  border: none;
  position: fixed;
  margin-left: -6%;
  outline: none;
  /* margin-top: 38%; */
  /* margin-bottom: -40%; */
}

.openbtn:hover {
  background-color: #444;
}
    </style>
</head>
<body>
  
  <div class="topnav">
    <a class="active" href="Home">Portfolio Manager
    </a>
   
    
    <div class="topnav-right">
     
      <a href="#about" class="openbtn" onclick="openNav()">Services</a>
    </div>
  </div>



  <div id="mySidebar" class="sidebar">
    <br>
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="/Home">Home</a>
    <a href="viewportfolio">View Portfolio</a>
    <a href="viewshares">View Shares</a>
    
    <a href="viewfunds">View Mutual Funds</a>
    <a href="viewNetworth">View Networth</a>
    <a href="sellAssets">Sell Assets</a>
    <!-- <a href="subscriptions">Subscriptions</a>
    <a href="/webportal/getAllRefill">Refill Status</a>
    <a href="refillDateEntry">Refill Due Date</a> -->
    <a href="logout">Logout</a>
  </div>
</body>


<script>
  
function openNav() {
document.getElementById("mySidebar").style.width = "200px";

}

/* Set the width of the sidebar to 0 and the left margin of the page content to 0 */
function closeNav() {
document.getElementById("mySidebar").style.width = "0";

}
</script>
</html>