package template;

public class StringDisplay extends AbstractDisplay {
	private String string;
	private int width;
	
	
	public StringDisplay(String string) {
		super();
		this.string = string;
		this.width = string.getBytes().length;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		this.printLine();
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		this.printLine();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("|"+string+"|");
	}
	
	private void printLine(){
		System.out.print("+");
		for(int i=0;i<width;i++){
			System.out.print("-");
		}
		System.out.println("+");
	}

}
