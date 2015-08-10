package prototype;

import java.util.Hashtable;

public class Manager {
	private Hashtable<String, Object> showcase=new Hashtable<>();
	
	public void register(String name,Product product){
		showcase.put(name, product);
	}
	
	public Product create(String protoname){
		Product p=(Product)showcase.get(protoname);
		return p.createClone();
	} 
}
