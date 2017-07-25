<!-- start navbar here -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />
<!-- fixes date not displaying correctly in Eclipse browser -->

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Logo</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="Newsfeed">Home</a></li>
				<li><a href="#">Products</a></li>
				<li><a href="#">Deals</a></li>
				<li><a href="#">Stores</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"> <c:if test="${user != null }">
							<c:out value="${user.username}" />
						</c:if> <c:if test="${user == null }">
							<a href="login.jsp"> Your Account </a>
						</c:if>
				</a></li>
				<li><a href="MyCartServlet"><span
						class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
			</ul>
		</div>


		<div class="container">
			<div class="row" style="float: right">
				<div class="col-xs-8 col-xs-offset-2">
					<div class="input-group">
						<div class="input-group-btn search-panel">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								<span id="search_concept">Select List</span> <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#all">All Products</a></li>

								<c:if test="${user != null }">
									<li><a href="#purchase">Purchase History</a></li>
								</c:if>

							</ul>
						</div>
						<form action="Newsfeed" id="searchbar" name="searchbar">
							<input type="hidden" name="search_param" value="all"id="search_param" />
							 <input type="text" class="form-control" name="searchtext" placeholder="Search term..." /> 
							 <span	class="input-group-btn">
								<button class="btn btn-default" type="button"  onclick="searchbar.submit()">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</form>
						>
					</div>
				</div>
			</div>
		</div>

		<script>
			$(document).ready(function(e) {
				$('.search-panel .dropdown-menu').find('a').click(function(e) {
					e.preventDefault();
					var param = $(this).attr("href").replace("#", "");
					var concept = $(this).text();
					$('.search-panel span#search_concept').text(concept);
					$('.input-group #search_param').val(param);

				});
			});
		</script>
		<c:if test="${user != null }">
			<form class="navbar-form navbar-left" role="form" action="Newsfeed"
				method="post">
				<input type="hidden" name="action" id="action" value="logout" />
				<button class="btn btn-default" id="addBookButton">Logout</button>
			</form>
		</c:if>

		<!-- 	<form class="navbar-form navbar-right" role="search" action="Newsfeed"
			method="get">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search"
					name="searchtext">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
		 -->

	</div>


</nav>