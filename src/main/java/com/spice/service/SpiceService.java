package com.spice.service;

import java.util.List;

import com.spice.data.Spice;

public interface SpiceService {

	public void createSpice(Spice spice);

	public List<Spice> getAllSpices();

	public Spice getSpice(int id);

	public Spice replaceSpice(int id, Spice newSpice);

	public String deleteSpice(int id);

}
