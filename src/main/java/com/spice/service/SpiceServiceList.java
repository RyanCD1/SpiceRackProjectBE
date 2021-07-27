package com.spice.service;

import java.util.ArrayList;
import java.util.List;

import com.spice.data.Spice;

public class SpiceServiceList implements SpiceService {
	private List<Spice> spices = new ArrayList<>();

	@Override
	public Spice createSpice(Spice spice) {
		System.out.println(spice);
		this.spices.add(spice);
		return this.spices.get(this.spices.size() - 1);
	}

	@Override
	public List<Spice> getAllSpices() {
		return this.spices;
	}

	@Override
	public Spice getSpice(int id) {
		Spice found = this.spices.get(id);
		return found;
	}

	@Override
	public Spice replaceSpice(int id, Spice newSpice) {
		return this.spices.set(id, newSpice);
	}

	@Override
	public String deleteSpice(int id) {
		this.spices.remove(id);

		return "Deleted spice at index: " + id;
	}

	@Override
	public List<Spice> findByNameIgnoreCase(String name) {
		return null;
	}

}
