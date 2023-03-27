package tw.com.eeit.badminton.model.bean;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String pteacher;
	private String pcontent;
	private int price;
	private String photo;
	
	public Product() {
		
	}
	
	
	public Product(String pcontent) {
		this.pcontent = pcontent;
	}


	public Product(int id, String pteacher, String pcontent, int price, String photo) {
		this.id = id;
		this.pteacher = pteacher;
		this.pcontent = pcontent;
		this.price = price;
		this.photo = photo;
	}
	
	public Product(String pteacher, String pcontent, int price, String photo) {
		this.pteacher = pteacher;
		this.pcontent = pcontent;
		this.price = price;
		this.photo = photo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPteacher() {
		return pteacher;
	}
	public void setPteacher(String pteacher) {
		this.pteacher = pteacher;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pteacher=" + pteacher + ", pcontent=" + pcontent + ", price=" + price
				+ ", photo=" + photo + "]";
	}
}
