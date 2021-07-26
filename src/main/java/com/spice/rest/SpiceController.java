package com.spice.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spice.data.Spice;
import com.spice.service.SpiceService;

@RestController

public class SpiceController {

	private SpiceService service;

	public SpiceController(SpiceService service) {
		super();
		this.service = service;
	}

	private List<Spice> spices = new ArrayList<>();

	@PostMapping("/createSpice")
	public Spice createSpice(@RequestBody Spice spice) {
		return this.service.createSpice(spice);
	}

	@GetMapping("/getAllSpices")
	public List<Spice> getAllSpices() {
		return this.service.getAllSpices();
	}

	@GetMapping("/getByName/{name}")
	public List<Spice> getByName(@PathVariable String name) {
		return this.service.findByNameIgnoreCase(name);
	}

	@GetMapping("/getSpice/{id}")
	public Spice getSpice(@PathVariable int id) {
		return this.service.getSpice(id);
	}

	@PutMapping("/replaceSpice/{id}")
	public Spice replaceSpice(@PathVariable int id, @RequestBody Spice newSpice) {
		return this.service.replaceSpice(id, newSpice);
	}

	@DeleteMapping("/deleteSpice/{id}")
	public String deleteSpice(@PathVariable int id) {
		return this.service.deleteSpice(id);
	}

}
