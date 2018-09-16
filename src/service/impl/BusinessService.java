package service.impl;

import java.sql.SQLException;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.DaoFactory;
import utils.DataSourceUtil;
import utils.EncoderUtil;
import utils.Permission;
import dao.impl.dao_Book;
import dao.impl.dao_Category;
import dao.impl.dao_Order;
import dao.impl.dao_User;
import domain.Book;
import domain.Category;
import domain.Order;
import domain.Page;
import domain.User;
/*
 * ע�⣬Ȩ��
 * */
@SuppressWarnings("all")
public class BusinessService implements BusinessServiceInter {

	private dao_Category dao_category=DaoFactory.getInstance().createDao("dao.impl.dao_Category");
	private dao_Book dao_book=DaoFactory.getInstance().createDao("dao.impl.dao_Book");
	private dao_User dao_user=DaoFactory.getInstance().createDao("dao.impl.dao_User");
	private dao_Order dao_order=DaoFactory.getInstance().createDao("dao.impl.dao_Order");
	
	//ͼ�����
	@Permission("��ӷ���")
	public void add(Category c){
		try{
			c.setId(EncoderUtil.generateId());
			dao_category.add(c);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Permission("ɾ������")
	public void delete(Category c){
		try{
			//c.setId(EncoderUtil.generateId());
			System.out.println("delete");
			dao_category.delete(c);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
		
	@Permission("�޸ķ���")
	public void update(Category c){
		try{
//			c.setId(EncoderUtil.generateId());
			System.out.println("update");
			dao_category.update(c);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//@Permission("�鿴����")
	public Category find(String id){
		try{
			return dao_category.find(id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Category> find(){
		try{
			return dao_category.find();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	//ͼ��
	@Permission("���ͼ��")
	public void addBook(Book book){
		try{
			book.setId(EncoderUtil.generateId());
			dao_book.addBook(book);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Permission("ɾ��ͼ��")
	public void deleteBook(Book book){
		try{
//			book.setId(EncoderUtil.generateId());
			dao_book.deleteBook(book);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Permission("�޸�ͼ��")
	public void updateBook(Book book){
		try{
//			book.setId(EncoderUtil.generateId());
			System.out.println("service:updateStart");
			System.out.println(book.getName());
			dao_book.updateBook(book);
			System.out.println("service:updateEnd");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//@Permission("����ͼ��")
	public Book findBook(String id){
		try{
//			Book book = new Book();
//			book = dao_book.find(id);
//			return book;
			return dao_book.find(id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	//@Permission("��������ͼ��")
	public List<Book> findBook(){
		try{
			return dao_book.find();	
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//��ȡ����ͼ���ҳ����
	@Permission("��������ͼ��")
	public Page getBookPage(String pa,int simplePageSize){//simplePageSizeָ��һҳ���ж�������¼
		try{
			int pagenum;
			if(pa!=null){
				pagenum=Integer.valueOf(pa);
			}else{
				pagenum=1;
			}
			
			int totalRecord=dao_book.getTotalRecord();
			
			Page page=new Page(totalRecord, pagenum,simplePageSize);
			
			List<Book>list=dao_book.getPageData(page.getStartindex(),simplePageSize);
			page.setList(list);
			
			return page;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * ��ȡָ������ͼ��ķ�ҳ����
	 * @param pa
	 * @param simplePageSize
	 * @return
	 */
	public Page getBookInCategoryPage(String category_id,String pa,int simplePageSize){//simplePageSizeָ��һҳ���ж�������¼
		try{
			int pagenum;
			if(pa!=null){
				pagenum=Integer.valueOf(pa);
			}else{
				pagenum=1;
			}
			
			int totalRecord=dao_book.getSelectedTotalRecord(category_id);
			
			Page page=new Page(totalRecord, pagenum,simplePageSize);
			
			List<Book>list=dao_book.getBookInCategoryPageData(category_id, page.getStartindex(), simplePageSize);
			page.setList(list);
			
			return page;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * ��ָ����������ͼ��
	 * @param category_id
	 * @return
	 * @throws SQLException 
	 */
	public List findCategoryBook(String category_id){
		try{
			return dao_book.findCategoryBook(category_id);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	//�û�
	public void add(User user){
		try{
			user.setId(EncoderUtil.generateId());
			dao_user.add(user);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String id){
		try{
			dao_user.delete(id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(User user){
		try{
			dao_user.update(user);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public User findUser(String username,String password){
		try{
			return dao_user.find(username, password);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public User findUser(String id){
		try{
			return dao_user.find(id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List findUsers(){
		try{
			return dao_user.find();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List findPrivileges(String user_id){
		try{
			return dao_user.findPrivilege(user_id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//Order����
	public void addOrder(Order order){
		try{
			dao_order.add(order);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List findOrders(String user_id){
		try{
			return dao_order.find(user_id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Order findOrder(String user_id,String order_id){
		try{
			return dao_order.find(user_id, order_id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Order findOrder(String order_id){
		try{
			return dao_order.findOrderItems(order_id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List findStateOrder(boolean state){
		try{
			return dao_order.findStateOrder(state);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void updateState(String order_id,boolean state){
		try{
			dao_order.updateState(order_id, state);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}






















