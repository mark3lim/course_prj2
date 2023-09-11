package kr.co.sist.course;

public class StudentVO {
	//돼라
	private int id;
	private String name;
	private String phone;
	private String email;
	private String majorName;
	private String dptName;
	private String addr;
	private String img;
	
	public StudentVO() {
	}
	
	public StudentVO(int id, String name, String phone, String email, String majorName, String dptName, String addr,
			String img) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.majorName = majorName;
		this.dptName = dptName;
		this.addr = addr;
		this.img = img;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getDptName() {
		return dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", majorName="
				+ majorName + ", dptName=" + dptName + ", addr=" + addr + ", img=" + img + "]";
	}
	
}
