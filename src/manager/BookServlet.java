package manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Exception.PrivilegeException;

import domain.Book;
import domain.Category;
import domain.Page;
import domain.User;

import service.impl.BusinessService;
import service.impl.BusinessServiceInter;
import utils.EncoderUtil;
import utils.MyBeanUtils;
import utils.ServiceFactory;


public class BookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String method=request.getParameter("method");		
			
			if(method.equalsIgnoreCase("addBook")){
				addBook(request,response);
			}else if(method.equalsIgnoreCase("updateBookUI")){
				updateBookUI(request,response);
			}
//			else if(method.equalsIgnoreCase("findBook")){
//				findBook(request,response);
//			}
			else if(method.equalsIgnoreCase("updateBook")){
				updateBook(request,response);
			}else if(method.equalsIgnoreCase("deleteBook")){
				deleteBook(request,response);
			}else if(method.equalsIgnoreCase("listAllBook")){
				listAllBook(request,response);
			}else if(method.equalsIgnoreCase("addBookUI")){
				addBookUI(request,response);
			}else{
				request.setAttribute("message", "��֧�ִ��������");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
			
	}
	
	 //���ҳ�ͼ�������ķ���
	private void addBookUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		try{
			User user=(User) request.getSession().getAttribute("user");
			BusinessServiceInter service=ServiceFactory.getInstance().getBusinessService(BusinessService.class, user);
			List<Category> list=service.find();
			
			request.setAttribute("book_category", list);
			request.getRequestDispatcher("/manager/addBook.jsp").forward(request, response);
			
//			document.getElementById("body").innerHTML="/manager/addBook.jsp ";
		}catch (Exception e) {
			if(e.getCause() instanceof PrivilegeException){
				request.setAttribute("message",e.getCause().getMessage());
			}else{
				request.setAttribute("message", "����ʧ��!");
			}
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
	}
	
	/* �鿴ͼ�� */
	private void listAllBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
			BusinessServiceInter service=new BusinessService();
			String pagenum=request.getParameter("pagenum");
			Page page=service.getBookPage(pagenum,9);
			page.setServlet("manager/"+this.getServletName()+"?method=listAllBook&");

			request.setAttribute("page", page);
			request.getRequestDispatcher("/manager/listBook.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "����ʧ�ܣ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
	}

	private void deleteBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			System.out.println("33");
			User user=(User) request.getSession().getAttribute("user");
			BusinessServiceInter service=ServiceFactory.getInstance().getBusinessService(BusinessService.class, user);
			System.out.println("22");
			//Book book=doFileupload(request);	//�������⣬ServiceFactory��invoke������user==null
			Book book =new Book();
			System.out.println("55");
			String id=request.getParameter("id");
			book.setId(id);
			System.out.println("44");
			service.deleteBook(book);
			
			request.setAttribute("message", "ɾ���ɹ���");
		}catch (Exception e) {
			if(e.getCause() instanceof PrivilegeException){
				request.setAttribute("message",e.getCause().getMessage());
			}else{
				request.setAttribute("message", "����ʧ��!");
			}
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	 //���ҳ�ͼ�������ķ��ಢfindBookָ��ͼ��
	private void updateBookUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		try{
			User user=(User) request.getSession().getAttribute("user");
			BusinessServiceInter service=ServiceFactory.getInstance().getBusinessService(BusinessService.class, user);
			List<Category>list=service.find();
			request.setAttribute("book_category", list);//���ط����б�
			
			String id=request.getParameter("id");	//ͨ��id�ҵ���Ҫ�Ķ���book��bean����
			request.setAttribute("book", service.findBook(id));	//����updateBook.jsp
			
		}catch (Exception e) {
			if(e.getCause() instanceof PrivilegeException){
				request.setAttribute("message",e.getCause().getMessage());
			}else{
				request.setAttribute("message", "updateBook��ʼ������ʧ��!");
			}
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/manager/updateBook.jsp").forward(request, response);
	}
	
//	private void findBook(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		try{
//			User user=(User) request.getSession().getAttribute("user");
//			BusinessServiceInter service=ServiceFactory.getInstance().getBusinessService(BusinessService.class, user);
//			//Book book=doFileupload(request);	//�������⣬ServiceFactory��invoke������user==null
//			Book book =new Book();
//			String id=request.getParameter("id");
//			book.setId(id);
//			book = service.findBook(id);	//ͨ��id�ҵ���Ҫ�Ķ���book��bean����
//			request.setAttribute("book", book);	//����updateBook.jsp
//			
//		}catch (Exception e) {
//			if(e.getCause() instanceof PrivilegeException){
//				request.setAttribute("message",e.getCause().getMessage());
//			}else{
//				request.setAttribute("message", "����ʧ��!");
//			}
//		}
//		request.getRequestDispatcher("/manager/updateBook.jsp").forward(request, response);
//	}
	
	private void updateBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			User user=(User) request.getSession().getAttribute("user");
			BusinessServiceInter service=ServiceFactory.getInstance().getBusinessService(BusinessService.class, user);
			//Book book=doFileupload(request);	//�������⣬ServiceFactory��invoke������user==null
			
//			String id=request.getParameter("id");
//			String name=request.getParameter("name");
//			String author=request.getParameter("author");
//			double price=request.getParameter("price");
//			String image=request.getParameter("image");
//			String description=request.getParameter("description");
//			Book book =new Book(id,name,author,price,image,description);
//			request.getRequestDispatcher("/manager/updateBook.jsp").forward(request, response);
			System.out.println("startUpdateBook");
			System.out.println(request.getParameter("id"));
//			Book book=new Book();
			Book book=doFileupload(request);
			System.out.println(book.getName()+""+book.getAuthor()+""+book.getPrice()+""+book.getImage()+""+book.getDescription()+""+book.getCategory_id());
			System.out.println("UpdateBooking");
			service.updateBook(book);
			
			request.setAttribute("message", "�޸ĳɹ���");
		}catch (Exception e) {
			if(e.getCause() instanceof PrivilegeException){
				request.setAttribute("message",e.getCause().getMessage());
			}else{
				request.setAttribute("message", "�޸�ͼ��ʧ��!");
			}
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void addBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
			User user=(User) request.getSession().getAttribute("user");
			BusinessServiceInter service=ServiceFactory.getInstance().getBusinessService(BusinessService.class, user);
			Book book=doFileupload(request);	//�������⣬ServiceFactory��invoke������user==null
			service.addBook(book);
			
			request.setAttribute("message", "��ӳɹ���");
		}catch (Exception e) {
			if(e.getCause() instanceof PrivilegeException){
				request.setAttribute("message",e.getCause().getMessage());
			}else{
				request.setAttribute("message", "����ʧ��!");
			}
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/*�������������Ǹ���ģ���ͼƬ�йء����д���402��403֮��Ĵ���*/
	@SuppressWarnings("unchecked")	//��������һ��ָ��������Ա���ע�Ĵ���Ԫ���ڲ���ĳЩ���汣�־�Ĭ�� 
	private Book doFileupload(HttpServletRequest request) {
		try{
			Book book =new Book();
			String id1=request.getParameter("id");
			System.out.println("get id"+id1);
			if(book.getId()==null) {
				book.setId(id1);
			}
			System.out.println("set id"+book.getId());
			DiskFileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			List<FileItem> list=upload.parseRequest(request);
			
			/*�õ��ϴ����������ϵ��ļ�·��*/
			String savepath=this.getServletContext().getRealPath("/resource/images");//�ļ���ַ����Ȼ��eclipse�Ĺ����ռ�
			//D:\Repositories\GitHub\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\BookStore-master\resource\images
			System.out.println("�ϴ���eclipse�����ռ䣺"+savepath);
			for(FileItem item:list){
				if(item.isFormField()){
					String name=item.getFieldName();
					String value=item.getString();
					value=new String(value.getBytes("ISO8859-1"),"UTF-8");//�����������
					BeanUtils.setProperty(book, name, value);
					System.out.println(name+":"+value);
				}else{
					String filename=item.getName();
					filename=filename.substring(filename.lastIndexOf("\\")+1);
					if(filename==null || filename.trim().equals("")){
						return null;
					}else {
							//��������
					String realpath=makeRealPath(savepath,filename);	//����ͼƬ�ڷ������ĵ�ַ
					System.out.println("ͼƬ������ַ��"+realpath);
					BeanUtils.setProperty(book, "image",realpath.substring(realpath.indexOf("\\resource\\images")));//����bean��ֵ
					System.out.println(book.getImage());
//					BeanUtils.setProperty(book, "image",realpath);
					InputStream in=item.getInputStream();
					FileOutputStream out=new FileOutputStream(realpath);
					int len =0;
					byte[] buffer=new byte[1024];
					while((len=in.read(buffer))>0){
						out.write(buffer, 0, len);
					}
					
					in.close();
					out.close();
					}
				}
			}
			return book;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/*�ϴ��ļ���������*/
	private String makeRealPath(String savepath, String filename) {
		//�����ļ���������
		filename=UUID.randomUUID()+"_"+filename;	//�ҽ����name�ĳ�bookid
//		filename=EncoderUtil.generateId()+".jpg";
		//���ɶ���ļ��д����ļ�
//		int dir1=filename.hashCode()&0xf;
//		int dir2=(filename.hashCode()&0xf)>>4;
//		File file=new File(savepath+"/"+dir1+"/"+dir2);//����β�ͣ�����Ӧ�������ֺ���
		File file=new File(savepath);
		
		if(!file.exists()){
			file.mkdirs();
		}
		
		return file+"/"+filename;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
