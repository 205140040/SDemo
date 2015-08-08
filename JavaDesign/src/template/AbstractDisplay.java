package template;

public abstract class AbstractDisplay {
	public abstract void open();

	public abstract void close();

	public abstract void print();

	public final void display() {
		this.open();
		for (int i = 0; i < 5; i++) {
			this.print();

		}
		
		this.close();
	}
}
