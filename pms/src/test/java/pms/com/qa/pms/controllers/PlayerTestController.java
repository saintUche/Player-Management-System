package pms.com.qa.pms.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import pms.com.qa.pms.DTOs.PlayerDTO;
import pms.com.qa.pms.models.Player;
import pms.com.qa.pms.runner.PmsApplication;

@SpringBootTest(classes = PmsApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PlayerTestController {

    @Autowired
	private MockMvc mock;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ObjectMapper jsonifier;
    
    private PlayerDTO mapToDTO(Player expected) {
		return mapper.map(expected, PlayerDTO.class);
	}

	private final Long TEST_ID = 4L;
	private final Player TEST_PLAYER = new Player(null, "2", "uche", "egbon", "cb", 2);

	@Test 
	public void create(){

		Player expected = TEST_PLAYER;
		expected.setID(TEST_ID);

		try {

			mock.perform(post("player/create").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_PLAYER)))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object mapToDTO(List<PlayerDTO> expected) {
		return mapper.map(expected, PlayerDTO.class);
	}


	@Test
	public void getAll(){

		PlayerDTO TEST_PLAYER = new PlayerDTO(1L, "uche", "egbon", "2", "st", 22);

		List<PlayerDTO> expected = new ArrayList<>();
		expected.add(TEST_PLAYER);
	

		try {

			mock.perform(get("player/getAll").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_PLAYER)))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}


	}

	///@GetMapping("/player/search")
	//public Player search(@PathParam("firstName") String firstName, @PathParam("LastName") String lastName) {
	//	if (firstName != null) {
	//		return service.searchFirstName(firstName);
//		}
//		if (lastName != null) {
//			return service.searchLastName(lastName);
//		} else {
//			return null;
//		}

//	}

	public void search(){

		Player TEST_PLAYER = new Player(null, "2", "uche", "egbon", "cb", 2);

		Player expected = TEST_PLAYER;

		expected.setID(1l);
	

		try {

			mock.perform(get("player/search").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_PLAYER.getFirstName())))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@PostMapping("/player/delete")
//	public boolean delete(@PathParam("id") Long id) {
//		return service.removePlayer(id);
//	}
    
    @Test
	public void delete(){
		
		Player TEST_PLAYER = new Player(1L, "2", "uche", "egbon", "cb", 2);
		
		Player expected = null;
	

		try {

			mock.perform(post("player/delete").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_PLAYER.getID())))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@PostMapping("/player/update")
//	public Player update(@PathParam("id") Long id, @RequestBody Player player) {
//		return service.updatePlayer(id, player);
//	}

	@Test
	public void update(){

		Player expected = TEST_PLAYER;
		expected.setID(TEST_ID);
	

		try {

			mock.perform(post("player/update").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_PLAYER)))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Test
	public void getOne(){

		Player expected = TEST_PLAYER;
		expected.setID(TEST_ID);
	

		try {

			mock.perform(post("player/getOne").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_PLAYER.getID())))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}











