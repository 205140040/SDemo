package iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookShelf bookShelf=new BookShelf(4);
		bookShelf.appendBook(new Book("A三国演义"));
		bookShelf.appendBook(new Book("B西游记"));
		bookShelf.appendBook(new Book("C红楼梦"));
		bookShelf.appendBook(new Book("D水浒传"));
		
		Iterator iterator=bookShelf.iteartor();
		while(iterator.hasNext()){
			Book book=(Book)iterator.next();
			System.out.println("书架上的书名称："+book.getName());
		}
		
	}

}
