package domain;

public class Category {
	
	private String id;
	private String name;
	private String description;
	//private String counter;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCounter() {
		return name;
	}
//	public void setCounter(String counter) {
//		this.counter = counter;
//	}
	public Category(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
//	public Category(String id) {	//可以不要
//		super();
//		this.id = id;
//	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
