package org.springframework.samples.petclinic.web.Response;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;

import java.util.ArrayList;
import java.util.List;

public class OwnerPetBooks {

	private String address;

	private String city;

	private String telephone;

	private final List<Pet> pets = new ArrayList<>();

	private final List<OpenLibResponse> ownerPetBooks = new ArrayList<>();

	public OwnerPetBooks(Owner owner, OpenLibResponse openLibResponse) {
		this.address = owner.getAddress();
		this.city = owner.getCity();
		this.telephone = owner.getTelephone();
		this.pets.addAll(owner.getPets());
		this.ownerPetBooks.add(openLibResponse);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<OpenLibResponse> getOwnerPetBooks() {
		return ownerPetBooks;
	}

	public List<Pet> getPets() {
		return pets;
	}

}
