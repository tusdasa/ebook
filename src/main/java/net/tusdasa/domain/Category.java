package net.tusdasa.domain;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = 3348101614831360195L;
	
	private int cid;
	
	private String category;
	
	private String type;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
