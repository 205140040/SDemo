package template;

public class CharDisplay extends AbstractDisplay{
	/**
	 * Ó¦Êä³öµÄ×Ö·û
	 */
	private char ch;
	
	

	public CharDisplay(char ch) {
		super();
		this.ch = ch;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.print("<<");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println(">>");
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print(ch);
	}

}
