package com.spice.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spice.data.Spice;
import com.spice.data.repos.SpiceRepo;

@Primary
@Service
public class SpiceServiceDB implements SpiceService {

	private SpiceRepo repo;

	public SpiceServiceDB(SpiceRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Spice replaceSpice(int id, Spice newSpice) {

		Spice found = this.repo.findById(id).get();

		System.out.println("FOUND: " + found);

		found.setPrice(newSpice.getPrice());
		found.setName(newSpice.getName());
		found.setCuisine(newSpice.getCuisine());
		found.setFlavourRating(newSpice.getFlavourRating());

		System.out.println("FOUND AFTER UPDATE: " + found);

		Spice updated = this.repo.save(found);
		System.out.println("UPDATED: " + updated);
		return updated;
	}

	@Override
	public Spice createSpice(Spice spice) {
		return this.repo.save(spice);
	}

	@Override
	public List<Spice> getAllSpices() {
		return this.repo.findAll();
	}

	@Override
	public Spice getSpice(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public String deleteSpice(int id) {
		this.repo.deleteById(id);

		if (this.repo.existsById(id)) {
			return "Not deleted: " + id;
		} else {
			return "Deleted: " + id;
		}
	}

	@Override
	public List<Spice> findByNameIgnoreCase(String name) {
		return this.repo.findByNameIgnoreCase(name);
	}

}
