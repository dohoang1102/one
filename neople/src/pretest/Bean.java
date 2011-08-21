package pretest;

import java.io.Serializable;

class Bean implements Serializable{

	private static final long serialVersionUID = 7156901247907462449L;
	
	public enum Column{job,name,phone,mail}
	public enum Order{asc,desc}
	
	public Bean(String job, String name, String phone, String mail) {
		super();
		this.job = job;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
	}

	public Bean() {
	}

	String job;
	String name;
	String phone;
	String mail;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bean [job=");
		builder.append(job);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", mail=");
		builder.append(mail);
		builder.append("]");
		return builder.toString();
	}

}
