<%@page import="com.jkxy.model.Poetries"%>
<%@page import="java.util.* "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示全唐诗</title>
<link rel="stylesheet" type="text/css" href="css/display.css" />
</head>
<body>
	<%
		List poe = (List) session.getAttribute("poes");
		Iterator it = poe.iterator();
		int totalPage=poe.size()/20;
	%>
	<div class="context">
		<center>
			<table>
				<tr style="background:#ccccca">
					<td style="width:80px ;text-align: center;">id</td>
					<td style="width:80px;text-align: center;">作者</td>
					<td style="width:150px;text-align: center;">诗词名称</td>
					<td style="text-align: center;">诗词内容</td>
				</tr>
				<%
					int i = 0;
					while (it.hasNext()) {
						Poetries poets = (Poetries) it.next();
				%>
				<tr <%if (i % 2 == 0) {%> bgcolor="#f0f8ff" <%}%>>
					<td style="text-align: center;"><%=poets.getPoe_id()%></td>
					<td style="text-align: center;"><%=poets.getName()%></td>
					<td style="text-align: center;"><<<%=poets.getTitle()%>>></td>
					<td style="text-align: center;"><%=poets.getContent()%></td>
				</tr>
				<%
					i++;
					}
				%>
			</table>
		<%-- 		<%if(false) {%>
				<a href="QueryServlet?action=title&page=1&search_name=<%=session.getAttribute("name")%>"><input type="button" value="上一页" disabled="true"></a>
				<% }%><%
				else{
				%> 
				<a href="QueryServlet?action=title&page+=1&search_name=<%=session.getAttribute("name")%>"><input type="button" value="下一页"></a>
				<%}%> --%>
			
			
		</center>
	</div>
</body>
</html>