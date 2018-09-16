package manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import domain.User;
import service.impl.BusinessService;
import service.impl.BusinessServiceInter;
import utils.ServiceFactory;


/*
 * ͼ�����servlet
 * */
public class CategoryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String method=request.getParameter("method");		
		System.out.println(method);
		if(method.equalsIgnoreCase("addCategory")){
			addCategory(request,response);
		}else if(method.equalsIgnoreCase("updateCategory")){
			updateCategory(request,response);
		}else if(method.equalsIgnoreCase("deleteCategory")){
			deleteCategory(request,response);
		}else if(method.equalsIgnoreCase("listAllCategory")){
			listAllCategory(request,response);
		}else{
			request.setAttribute("message", "��֧�ִ��������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
	}

	//��ȡ�����б�
	private void listAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			BusinessServiceInter service=new BusinessService();

			List<Category> list=service.find();
			if(list==null){
				request.setAttribute("message", "��δ���κη��࣡");
				request.getRequestDispatcher("/message.jap").forward(request, response);
				return;
			}
			request.setAttribute("list", list);	//request������
//			System.out.println(list);
			request.getRequestDispatcher("/manager/listCategory.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "����ʧ�ܣ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		
	}

	//ɾ�����࣬�����ӷ������
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			System.out.println("3");
//			BusinessServiceInter service=new BusinessService();
			User user=(User) request.getSession().getAttribute("user");
			BusinessServiceInter service=ServiceFactory.getInstance().getBusinessService(BusinessService.class, user);
			System.out.println("1");
			String id=request.getParameter("id");
			String name=request.getParameter("name");
//			Category c=(Category)request.getAttribute("category");
//			System.out.println(id);
			Category c=new Category();
			c.setId(id);
			c.setName(name);
			
			service.delete(c);
			
			request.setAttribute("message", "����ɾ���ɹ���");

			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "����ɾ��ʧ�ܣ�");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	//�޸ķ���
	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
//			BusinessServiceInter service=new BusinessService();
			User user=(User) request.getSession().getAttribute("user");
			BusinessServiceInter service=ServiceFactory.getInstance().getBusinessService(BusinessService.class, user);
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String description=request.getParameter("description");
//			Category c=(Category)request.getAttribute("category");
//			System.out.println(id);
			Category c=new Category();
			System.out.println("newCategory:"+id+name+description);
			c.setId(id);
			c.setName(name);
			c.setDescription(description);
			
			service.update(c);
			
			request.setAttribute("message", "�����޸ĳɹ���");

			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "�����޸�ʧ�ܣ�");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	//��ӷ���
	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try{
//			BusinessServiceInter service=new BusinessService();
			User user=(User) request.getSession().getAttribute("user");
			BusinessServiceInter service=ServiceFactory.getInstance().getBusinessService(BusinessService.class, user);
			String name=request.getParameter("name");	//request��API
			String description=request.getParameter("description");
			
			Category c=new Category();
			c.setName(name);
			c.setDescription(description);
			service.add(c);
			
			request.setAttribute("message", "������ӳɹ���");
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "�������ʧ�ܣ�");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
