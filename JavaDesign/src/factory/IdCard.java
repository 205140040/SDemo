package factory;

public class IdCard extends Product{
	private String owner;
	
	IdCard(String owner){
		System.out.println("�����ģ�"+owner+"��");
		this.owner=owner;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		System.out.println("ʹ�ã�"+owner+"�Ŀ�");
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

}
