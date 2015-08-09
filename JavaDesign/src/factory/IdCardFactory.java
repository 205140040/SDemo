package factory;

import java.util.Vector;

public class IdCardFactory extends Factory{
	private Vector owners=new Vector();

	@Override
	public Product createProduct(String owner) {
		// TODO Auto-generated method stub
		return new IdCard(owner);
	}

	@Override
	public void registerProduct(Product product) {
		// TODO Auto-generated method stub
		owners.add(((IdCard)product).getOwner());
	}

	public Vector getOwners() {
		return owners;
	}

	public void setOwners(Vector owners) {
		this.owners = owners;
	}
	
	

}
