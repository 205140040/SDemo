package adapter;
/**
 * 
 * 
 * @date 2015年8月4日
 * @author hyc
 * @description 适配器类
 */
public class PrintBanner extends Banner implements Print {
	
	

	public PrintBanner() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PrintBanner(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void printWeek() {
		// TODO Auto-generated method stub
		showWithParen();
	}

	@Override
	public void printStrong() {
		// TODO Auto-generated method stub
		showWithAster();
	}

}
