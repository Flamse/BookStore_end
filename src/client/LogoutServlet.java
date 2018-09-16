package client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;

import service.impl.BusinessService;
import service.impl.BusinessServiceInter;

public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			request.getSession().removeAttribute("user");//���û�ע����¼
//			request.getRequestDispatcher("/client/head.jsp").forward(request, response);//��ת������ҳ
			request.getRequestDispatcher("/indexOld3.jsp").forward(request, response);//��ת������ҳ
		}catch (Exception e) {
			request.setAttribute("message", "����ʧ�ܣ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
