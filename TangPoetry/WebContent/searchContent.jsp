<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找全诗词内容</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div class="search">
		<form action="QueryServlet?action=content" method="post">
			<input type="text" name="search_name" id="s_text" > <input type="submit"
				value="搜索一下" id="s_sub">
		</form>
	</div>
</body>
</html>