package br.com.gsind.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BeanContato {
	private String tel01;
	private String tel02;
	private String cel01;
	private String cel02;
	private String email01;
	private String email02;
	private String webPage;
	private int dddTel01;
	private int dddTel02;
	private int dddCel01;
	private int dddCel02;
	public String getTel01() {
		return tel01;
	}
	public void setTel01(String tel01) {
		this.tel01 = tel01;
	}
	public String getTel02() {
		return tel02;
	}
	public void setTel02(String tel02) {
		this.tel02 = tel02;
	}
	public String getCel01() {
		return cel01;
	}
	public void setCel01(String cel01) {
		this.cel01 = cel01;
	}
	public String getCel02() {
		return cel02;
	}
	public void setCel02(String cel02) {
		this.cel02 = cel02;
	}
	public String getEmail01() {
		return email01;
	}
	public void setEmail01(String email01) {
		this.email01 = email01;
	}
	public String getEmail02() {
		return email02;
	}
	public void setEmail02(String email02) {
		this.email02 = email02;
	}
	public String getWebPage() {
		return webPage;
	}
	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}
	public int getDddTel01() {
		return dddTel01;
	}
	public void setDddTel01(int dddTel01) {
		this.dddTel01 = dddTel01;
	}
	public int getDddTel02() {
		return dddTel02;
	}
	public void setDddTel02(int dddTel02) {
		this.dddTel02 = dddTel02;
	}
	public int getDddCel01() {
		return dddCel01;
	}
	public void setDddCel01(int dddCel01) {
		this.dddCel01 = dddCel01;
	}
	public int getDddCel02() {
		return dddCel02;
	}
	public void setDddCel02(int dddCel02) {
		this.dddCel02 = dddCel02;
	}
	
}
