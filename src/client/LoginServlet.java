package client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;

import service.impl.BusinessService;
import service.impl.BusinessServiceInter;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			BusinessServiceInter service=new BusinessService();
			User user=service.findUser(username, password);
			
			if(user!=null){
				request.getSession().setAttribute("user", user);//让用户登录
			}
//			request.getRequestDispatcher("/client/head.jsp").forward(request, response);//跳转到旧主页
			request.getRequestDispatcher("/indexOld3.jsp").forward(request, response);//跳转到新主页
		}catch (Exception e) {
			request.setAttribute("message", "操作失败！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
