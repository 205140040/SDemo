package adapter;

public class Banner {
	private String string;

	
	
	public Banner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Banner(String string) {
		super();
		this.string = string;
	}



	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	public void showWithParen(){
		System.out.println("("+string+")");
	}
	
	public void showWithAster(){
		System.out.println("*"+string+"*");
	}
}
