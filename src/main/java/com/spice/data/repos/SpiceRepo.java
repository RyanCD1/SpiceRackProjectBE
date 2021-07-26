package com.spice.data.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spice.data.Spice;

@Repository
public interface SpiceRepo extends JpaRepository<Spice, Integer> {

	List<Spice> findByNameIgnoreCase(String name);
}
