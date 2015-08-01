package iterator;

public interface Iterator {
	/**
	 * 
	 * @return
	 * @date 2015年8月1日
	 * @author hyc
	 * @description 检查有没有下一个元素
	 */
	public abstract boolean hasNext();
	
	/**
	 * 
	 * @return
	 * @date 2015年8月1日
	 * @author hyc
	 * @description 获取下一个元素
	 */
	public abstract Object next();
}
