package net.tusdasa.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Article implements Serializable {

	private static final long serialVersionUID = -5200717943490278910L;

	private int aid;

	private String title;

	private String author;

	private Date time;

	private String category;

	private String text;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		return sf.format(time);
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
