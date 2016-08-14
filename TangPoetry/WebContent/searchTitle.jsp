<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索诗词名称</title>
</head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<body>
	<div class="search">
		<form action="QueryServlet?action=title" method="post">
			<input type="text" name="search_name" id="s_text" > 
			<input type="text" name="page" style="display:none" value="0">
			<input type="submit"
				value="搜索一下" id="s_sub">
		</form>
	</div>
</body>
</html>