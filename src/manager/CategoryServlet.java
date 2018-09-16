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
 * 图书分类servlet
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
			request.setAttribute("message", "不支持此类操作！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
	}

	//获取分类列表
	private void listAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			BusinessServiceInter service=new BusinessService();

			List<Category> list=service.find();
			if(list==null){
				request.setAttribute("message", "暂未有任何分类！");
				request.getRequestDispatcher("/message.jap").forward(request, response);
				return;
			}
			request.setAttribute("list", list);	//request传对象
//			System.out.println(list);
			request.getRequestDispatcher("/manager/listCategory.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "操作失败！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		
	}

	//删除分类，借鉴添加分类代码
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
			
			request.setAttribute("message", "分类删除成功！");

			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "分类删除失败！");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	//修改分类
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
			
			request.setAttribute("message", "分类修改成功！");

			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "分类修改失败！");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	//添加分类
	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try{
//			BusinessServiceInter service=new BusinessService();
			User user=(User) request.getSession().getAttribute("user");
			BusinessServiceInter service=ServiceFactory.getInstance().getBusinessService(BusinessService.class, user);
			String name=request.getParameter("name");	//request的API
			String description=request.getParameter("description");
			
			Category c=new Category();
			c.setName(name);
			c.setDescription(description);
			service.add(c);
			
			request.setAttribute("message", "分类添加成功！");
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "分类添加失败！");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
