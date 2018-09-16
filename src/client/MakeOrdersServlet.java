package client;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.BusinessService;
import service.impl.BusinessServiceInter;
import utils.EncoderUtil;

import domain.Cart;
import domain.CartItem;
import domain.Order;
import domain.OrderItem;
import domain.User;

public class MakeOrdersServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		try{
			User user=(User) request.getSession().getAttribute("user");
			Cart cart=(Cart) request.getSession().getAttribute("cart");
			
			if(user==null){
				request.setAttribute("message", "���ȵ�¼��");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			
			if(cart==null){
				request.setAttribute("message", "����δѡ����");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			System.out.println("1");
			Order order=new Order();
			order.setId(EncoderUtil.generateId());
			order.setOrderTime(new Date());
			order.setUser(user);
			order.setTotalprice(cart.getTotalprice());
			order.setState(false);
			
			Map<String,OrderItem>map=new HashMap<String,OrderItem>();
			for(Entry<String, CartItem> item:cart.getMap().entrySet()){
				OrderItem orderItem=new OrderItem();
				orderItem.setId(EncoderUtil.generateId());
				orderItem.setNum(item.getValue().getNum());
				orderItem.setPrice(item.getValue().getBook().getPrice());
				orderItem.setSum(item.getValue().getSum());
				orderItem.setBook(item.getValue().getBook());
				orderItem.setOrder_id(order.getId());
		
				map.put(item.getValue().getBook().getId(), orderItem);
			}
			System.out.println("2");
			order.setMap(map);
			System.out.println("3");
			//�������ݿ�
			BusinessServiceInter service=new BusinessService();	
			System.out.println("4");
			service.addOrder(order);	//"�µ�ʧ��"���������ԭ�򡣼�����ȥ����dao�������
			
			request.setAttribute("message", "�µ��ɹ���");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "�µ�ʧ�ܣ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doGet(request,response);
	}

}
