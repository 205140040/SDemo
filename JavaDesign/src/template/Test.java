package template;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractDisplay display1=new CharDisplay('h');
		AbstractDisplay display2=new StringDisplay("hello");
		display1.display();
		display2.display();
	}

}
