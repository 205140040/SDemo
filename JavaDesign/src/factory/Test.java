package factory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory factory=new IdCardFactory();
		Product product=factory.create("zss");
		Product product2=factory.create("lss");
		Product product3=factory.create("www");
		product.use();
		product2.use();
		product3.use();
		
	}

}
