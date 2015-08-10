package prototype;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager manager=new Manager();
		MessageBox mb=new MessageBox('*');
		manager.register("hello", mb);
		Product p=manager.create("hello");
		p.use("hello");
	}

}
