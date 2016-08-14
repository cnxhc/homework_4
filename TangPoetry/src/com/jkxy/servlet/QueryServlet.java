package com.jkxy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jkxy.service.PoetriesService;


public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PoetriesService ps=new PoetriesService();
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("search_name");
		String page=request.getParameter("page");
		String action=request.getParameter("action");
		if(action.equals("all")){
			//查询200条诗词记录
			List poes=ps.queryAllPoet();
			HttpSession session=request.getSession();
			session.setAttribute("poes", poes);
			response.sendRedirect("displayAll.jsp");
		}else if(action.equals("title")){
			//通过诗人名查询该诗人的诗词作品
			List pes=ps.queryTitleByName(name);
			HttpSession session=request.getSession();
			session.setAttribute("pes", pes);
			session.setAttribute("name", name);
			if(!pes.isEmpty()){
				response.sendRedirect("displayTitle.jsp");
			}else{
				response.sendRedirect("displayTitle_fail.jsp");
			}
		}else if(action.equals("content")){
			//通过诗词名称查询诗词全文
			List pes=ps.queryContentByTitle(name);
			HttpSession session=request.getSession();
			session.setAttribute("pes", pes);
			session.setAttribute("name", name);
			if(!pes.isEmpty()){
				response.sendRedirect("displayContent.jsp");
			}else{
				response.sendRedirect("displayContent_fail.jsp");
			}
		}else if(action.equals("likeContent")){
			//通过名句查询诗词 名称，诗人名
			List pes=ps.queryNameTitleByContent(name);
			HttpSession session=request.getSession();
			session.setAttribute("pes", pes);
			session.setAttribute("name", name);
			if(!pes.isEmpty()){
				response.sendRedirect("displayNameTitle.jsp");
			}else{
				response.sendRedirect("displayNameTitle_fail.jsp");
			}
		}
	
	}

}
