package org.kosa.myproject.model;

public class CustomerVo {
	private String id;
	private String name;
	private String address;
	
	public CustomerVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerVo(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerVo [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
