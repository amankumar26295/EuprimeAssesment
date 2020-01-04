<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title> home </title>
<link rel="stylesheet"  type="text/css" href="css/style.css">
<link rel="stylesheet"  type="text/css" href="css/form.css">
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
</head>
<body>

<div class="mainContainer">
	<div class="container1">
			<img class="mySlides" src="images/slide4" style="width:100%;height:500px;">
		  	<img class="mySlides" src="images/slide1" style="width:100%;height:500px;">
		  	<img class="mySlides" src="images/slide2" style="width:100%;height:500px;">
		  	<img class="mySlides" src="images/slide3" style="width:100%;height:500px;">
	</div>
	<div class="container2">
		<p style="text-align:center;"><img alt="" src="images/logo" width="22%;"></p>
		<p style="font-size:30px;text-align:center;">Find the best! Men's and Womens's parlours in your locality</p>
			<br>
			
			
					
		<form action="search" method="post">
		 	<div style="width:50%; float:right;margin-right:20%;">
		 		<div  style="margin-top:2%;">
		 			<!-- <p style="color:black; font-size:30px;">Parlour Type :</p> -->
					<select name="type"  required>
					  	<option value="women">Women</option>
					  	<option value="men">Men</option>
					  	<option value="both">Both</option>
					</select>
				</div>
		 	</div>
	 		<div style="width:50%; float:right;margin-right:20%;">
	 			<div style="margin-top:2%;">
				<!-- <p style="color:black; font-size:30px;">Locality :</p> -->
 					<input  type="text" placeholder="Search for locality" name="locality" required>
 					</div>
	 		</div>
	 		<div style="width:50%; float:right;margin-right:10%;">
	 			<input type="submit" value="Search Parlours" style="margin-top:4%;width:60%;">
	 		</div>	
  		</form>
	</div>	 	
</div>
	
<script>
	var myIndex = 0;
	carousel();
	
	function carousel() {
		var i;
		var x = document.getElementsByClassName("mySlides");
		for (i = 0; i < x.length; i++) {
	    	x[i].style.display = "none";  
	  	}
		myIndex++;
		if (myIndex > x.length) {myIndex = 1}    
		x[myIndex-1].style.display = "block";  
		setTimeout(carousel, 10000); // Change image every 10 seconds
	}
</script>

</body>
</html>
