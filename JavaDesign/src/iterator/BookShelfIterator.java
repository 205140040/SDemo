package iterator;
/**
 * 
 * 
 * @date 2015年8月1日
 * @author hyc
 * @description 扫描bookshelf 的类
 */
public class BookShelfIterator implements Iterator{
	private BookShelf bookShelf;
	private int index;
	
	
	

	public BookShelfIterator(BookShelf bookShelf) {
		super();
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (index<bookShelf.getLength()) {
			return true;
		}else{
			return false;
		}
		
		
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Book book=bookShelf.getBookAt(index);
		index++;
		return book;
	}

}
