package com.spice.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.spice.data.Spice;
import com.spice.data.repos.SpiceRepo;

@SpringBootTest
@ActiveProfiles("test")
public class SpiceServiceDBUnitTest {

	@Autowired
	private SpiceServiceDB service;

	@MockBean
	private SpiceRepo repo;

	@Test
	void testCreate() {

		Spice newSpice = new Spice("Cinnamon", "Global", 12, 10);

		Spice savedSpice = new Spice(1, "Cinnamon", "Global", 12, 10);

		Mockito.when(this.repo.save(newSpice)).thenReturn(savedSpice);

		assertThat(this.service.createSpice(newSpice)).isEqualTo(savedSpice);

		Mockito.verify(this.repo, Mockito.times(1)).save(newSpice);
	}

	@Test
	void testGetAll() {
		List<Spice> testSpices = List.of(new Spice(1, "Bay Leaf", "Global", 12, 10));

		Mockito.when(this.repo.findAll()).thenReturn(testSpices);

		assertThat(this.service.getAllSpices()).isEqualTo(testSpices);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testGetAllByName() {

		List<Spice> testSpices = List.of(new Spice(1, "Bay Leaf", "Global", 12, 10));

		String search = "Bay Leaf";
		Mockito.when(this.repo.findByNameIgnoreCase(search)).thenReturn(testSpices);

		assertThat(this.service.findByNameIgnoreCase(search)).isEqualTo(testSpices);

		Mockito.verify(this.repo, Mockito.times(1)).findByNameIgnoreCase(search);
	}

	@Test
	void testUpdate() {
		int id = 1;

		Spice testSpice = new Spice(id, "Basil", "European", 8, 7);
		Spice testNewSpice = new Spice(id, "Cloves", "Global", 12, 8);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testSpice));
		Mockito.when(this.repo.save(new Spice(id, "Cloves", "Global", 12, 8))).thenReturn(testNewSpice);

		Spice actual = this.service.replaceSpice(id, testNewSpice);

		assertThat(actual).isEqualTo(testNewSpice);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(new Spice(id, "Cloves", "Global", 12, 8));
	}

	@Test
	void testDeleteSucceeds() {
		int id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.deleteSpice(id)).isEqualTo("Deleted: " + id);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

	@Test
	void testDeleteFails() {
		int id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(true);

		assertThat(this.service.deleteSpice(id)).isEqualTo("Not deleted: " + id);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

	void testGetById() {

		int id = 1;
		Spice testBook = new Spice(id, "Cadammon", "Indian", 11, 12);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testBook));
		Mockito.when(this.repo.save(new Spice(id, "Cadammon", "Indian", 11, 12))).thenReturn(testBook);

		Spice actual = this.service.getSpice(id);

		assertThat(actual).isEqualTo(testBook);

		Mockito.verify(this.repo, Mockito.times(1)).getById(id);
	}

}
