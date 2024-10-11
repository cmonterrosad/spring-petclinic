package org.springframework.samples.petclinic.web.Response;

import java.util.List;

public class OpenLibResponse {

	public OpenLibResponse(int numFound, int start, boolean numFoundExact, List<InnerDocs> docs) {
		this.numFound = numFound;
		this.start = start;
		this.numFoundExact = numFoundExact;
		this.docs = docs;
	}

	int numFound;

	int start;

	boolean numFoundExact;

	List<InnerDocs> docs;

	public int getNumFound() {
		return numFound;
	}

	public void setNumFound(int numFound) {
		this.numFound = numFound;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public boolean isNumFoundExact() {
		return numFoundExact;
	}

	public void setNumFoundExact(boolean numFoundExact) {
		this.numFoundExact = numFoundExact;
	}

	public List<InnerDocs> getDocs() {
		return docs;
	}

	public void setDocs(List<InnerDocs> docs) {
		this.docs = docs;
	}

}
