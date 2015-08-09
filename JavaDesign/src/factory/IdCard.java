package factory;

public class IdCard extends Product{
	private String owner;
	
	IdCard(String owner){
		System.out.println("建立的："+owner+"卡");
		this.owner=owner;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		System.out.println("使用："+owner+"的卡");
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

}
