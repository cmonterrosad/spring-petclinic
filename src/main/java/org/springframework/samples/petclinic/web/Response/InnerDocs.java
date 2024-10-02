package org.springframework.samples.petclinic.web.Response;

import java.util.List;

public class InnerDocs {

	List<String> author_key;

	List<String> author_name;

	List<String> contributor;

	List<String> isbn;

	String title;

	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getIsbn() {
		return isbn;
	}

	public void setIsbn(List<String> isbn) {
		this.isbn = isbn;
	}

	public List<String> getAuthor_key() {
		return author_key;
	}

	public void setAuthor_key(List<String> author_key) {
		this.author_key = author_key;
	}

	public List<String> getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(List<String> author_name) {
		this.author_name = author_name;
	}

	public List<String> getContributor() {
		return contributor;
	}

	public void setContributor(List<String> contributor) {
		this.contributor = contributor;
	}

}
