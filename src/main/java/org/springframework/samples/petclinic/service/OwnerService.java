package org.springframework.samples.petclinic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.web.Response.InnerDocs;
import org.springframework.samples.petclinic.web.Response.OpenLibResponse;
import org.springframework.samples.petclinic.web.Response.OwnerPetBooks;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {

	private final OwnerRepository owners;

	private final RestTemplate restTemplate;

	public OwnerService(OwnerRepository ownerRepository, RestTemplateBuilder builder) {
		this.owners = ownerRepository;
		this.restTemplate = builder.build();
	}

	public Page<Owner> findAllOwners() {
		return this.owners.findAll(Pageable.ofSize(5));
	}

	public Owner findOwnerById(int id) {
		int BOOKS = 9;
		int count = 0;
		Owner owner = this.owners.findById(id);
		OwnerPetBooks books = getData();
		List<InnerDocs> innerbook = new ArrayList<>();
		for (InnerDocs docs : books.getOwnerPetBooks().get(0).getDocs()) {
			if (count <= BOOKS) {
				innerbook.add(docs);
				count++;
			}
		}
		owner.setBooks(innerbook);
		return owner;
	}

	public OwnerPetBooks getData() {

		Owner owner = this.owners.findById(1);

		OpenLibResponse response = this.restTemplate.getForObject("https://openlibrary.org/search.json?q=dog",
				OpenLibResponse.class);

		return new OwnerPetBooks(owner, response);
	}

}
