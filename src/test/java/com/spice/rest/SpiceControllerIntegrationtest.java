package com.spice.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spice.data.Spice;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:spice-schema.sql",
		"classpath:spice-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SpiceControllerIntegrationtest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Spice testKit = new Spice("Bay Leaf", "Global", 9, 12);

		String testKitAsJSON = this.mapper.writeValueAsString(testKit);

		System.out.println(testKit);
		System.out.println(testKitAsJSON);

		RequestBuilder request = post("/createSpice").contentType(MediaType.APPLICATION_JSON).content(testKitAsJSON);

		ResultMatcher checkStatus = status().is(201);

		Spice testCreatedKit = new Spice("Bay Leaf", "Global", 9, 12);
		testCreatedKit.setId(2);
		String testCreatedKitAsJSON = this.mapper.writeValueAsString(testCreatedKit);

		ResultMatcher checkBody = content().json(testCreatedKitAsJSON);
		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		int id = 1;
		Spice newSpice = new Spice(id, "Cloves", "Global", 9, 8);
		String newSpiceAsJSON = this.mapper.writeValueAsString(newSpice);

		RequestBuilder req = put("/replaceSpice/" + id).contentType(MediaType.APPLICATION_JSON).content(newSpiceAsJSON);

		ResultMatcher checkStatus = status().isAccepted();

		ResultMatcher checkBody = content().json(newSpiceAsJSON);

		this.mockMVC.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void findById() throws Exception {
		RequestBuilder req = get("/getSpice/1");

		ResultMatcher checkStatus = status().isOk();

		Spice testSpice = new Spice(1, "Cinnamon", "Global", 9, 12);

		String testSpiceAsJSON = this.mapper.writeValueAsString(testSpice);

		ResultMatcher checkBody = content().json(testSpiceAsJSON);

		this.mockMVC.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testFindByName() throws Exception {
		RequestBuilder request = get("/getByName/Cinnamon");

		ResultMatcher checkStatus = status().isOk();

		List<Spice> testSpices = List.of(new Spice(1, "Cinnamon", "Global", 9, 12));

		String testSpicesAsJSON = this.mapper.writeValueAsString(testSpices);

		ResultMatcher checkBody = content().json(testSpicesAsJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {

		RequestBuilder request = delete("/deleteSpice/1");

		ResultMatcher checkStatus = status().is(204);
		ResultMatcher checkBody = content().string("Deleted: 1");

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

}
