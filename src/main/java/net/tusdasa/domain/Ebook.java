package net.tusdasa.domain;

import java.io.Serializable;

public class Ebook implements Serializable {
	
	private static final long serialVersionUID = 2355442528923007324L;

	private int eid;
	
	private String title="暂无标题";
	
	private String cover="暂无封面";
	
	private String desciption="暂无作者简介";
	
	private String context="暂无内容简介";
	
	private String type="epub";
	
	private String category="Other";
	
	private String epub="本书暂无EPUB格式";
	
	private String mobi="本书暂无mobi格式";
	
	private String azw3="本书暂无azw3格式";
	
	private String pdf="本书暂无pdf格式";

	
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEpub() {
		return epub;
	}

	public void setEpub(String epub) {
		this.epub = epub;
	}

	public String getMobi() {
		return mobi;
	}

	public void setMobi(String mobi) {
		this.mobi = mobi;
	}

	public String getAzw3() {
		return azw3;
	}

	public void setAzw3(String azw3) {
		this.azw3 = azw3;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
