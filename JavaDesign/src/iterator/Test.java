package iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookShelf bookShelf=new BookShelf(4);
		bookShelf.appendBook(new Book("A��������"));
		bookShelf.appendBook(new Book("B���μ�"));
		bookShelf.appendBook(new Book("C��¥��"));
		bookShelf.appendBook(new Book("Dˮ䰴�"));
		
		Iterator iterator=bookShelf.iteartor();
		while(iterator.hasNext()){
			Book book=(Book)iterator.next();
			System.out.println("����ϵ������ƣ�"+book.getName());
		}
		
	}

}
