package org.kosa.myproject.model;

// VO : Value Object, DTO : Data Transfer Object
public class MemberVo {
	private String id;
	private String pwd;
	private String name;
	private String address;
	
	public MemberVo() {
		super();
		// 기본 생성자
	}
	
	// 오버로딩
	public MemberVo(String id, String pwd, String name, String address) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
	}

	public MemberVo(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		// address는 null 허용이기에 뺀 필드를 만들어봄
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", address=" + address + "]";
	}

}
