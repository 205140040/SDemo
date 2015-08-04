
package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @date 2015年8月1日
 * @author hyc
 * @description 书架类
 */
public class BookShelf implements Aggregate{
	
	private List<Book> books;
	
	private int last=0;
	
	
	
	
	public BookShelf(int maxsize) {
		super();
		this.books=new ArrayList<Book>();
	}

	/**
	 * 
	 * @param index
	 * @return
	 * @date 2015年8月1日
	 * @author hyc
	 * @description 根据下标得到图书
	 */
	public Book getBookAt(int index){
		return books.get(index);
	}
	
	public void appendBook(Book book){
		this.books.add(book);
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
