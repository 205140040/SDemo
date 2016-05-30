import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import com.demo.bean.Student;

public class JunitTest {

	private Student s1;
	
	private Student s2;

	/**
	 * @before注解，和@beforeClass注解不同，class注解是类级别的，每次只运行一次,
	 *  运行测试时，初始化方法,每次运行都执行该方法
	 *  @beforeClass一般初始化数据库连接
	 *  5
	 */
	//@BeforeClass
	@Before
	public void methodInit() {
		s1 = new Student();
		s1.setName("啦啦啦");
		s2=null;
	}

	@Test
	public void testName() {
		Assert.assertEquals("啦啦啦1", s1.getName());
	}

	/**
	 * 运行测试时，销毁方法,每次运行都执行该方法
	 */
	@After
	public void destroy() {
		s1 = null;
	}
	
	/**
	 * 1.测试异常,expected=异常
	 * expected=NullPointerException.class,
	 * 2.测试设置超时时间，timeout设置
	 */
	@Test(timeout=3000)
	public void testNullExeception(){
		//Assert.assertNotNull(s2.getName());
		//使用unitils反射测试两个对象是否相等
		ReflectionAssert.assertReflectionEquals(s1, s2);
	}
}
