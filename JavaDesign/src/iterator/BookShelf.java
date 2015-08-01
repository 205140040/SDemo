
package iterator;

/**
 * 
 * 
 * @date 2015��8��1��
 * @author hyc
 * @description �����
 */
public class BookShelf implements Aggregate{
	
	private Book[] books;
	
	private int last=0;
	
	
	
	
	public BookShelf(int maxsize) {
		super();
		this.books=new Book[maxsize];
	}

	/**
	 * 
	 * @param index
	 * @return
	 * @date 2015��8��1��
	 * @author hyc
	 * @description �����±�õ�ͼ��
	 */
	public Book getBookAt(int index){
		return books[index];
	}
	
	public void appendBook(Book book){
		this.books[last]=book;
		last++;
	}
	
	public int getLength(){
		return last;
	}


	@Override
	public Iterator iteartor() {
		// TODO Auto-generated method stub
		return new BookShelfIterator(this);
	}

}
