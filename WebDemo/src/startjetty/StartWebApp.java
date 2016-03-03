package startjetty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class StartWebApp {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) throws Exception {
		try {
			@SuppressWarnings("unused")
			ApplicationContext applicationContext = new FileSystemXmlApplicationContext(new String[] {
					"D://JAVASoft//GitProject//GitRep//WebDemo//WebContent//WEB-INF//applicationContext.xml" });

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
