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

import pms.com.qa.pms.DTOs.FansDTO;
import pms.com.qa.pms.models.Fans;
import pms.com.qa.pms.models.Player;
import pms.com.qa.pms.runner.PmsApplication;

@SpringBootTest(classes = PmsApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FansTestController {

    @Autowired
	private MockMvc mock;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ObjectMapper jsonifier;
    
    private FansDTO mapToDTO(Fans expected) {
		return mapper.map(expected, FansDTO.class);
	}
    private final Player player = new Player(1L, "2", "uche", "egbon", "st", 22);
	private final Long TEST_ID = 4L;
	private final Fans TEST_FAN = new Fans(null, player, 5, 10);

	@Test 
	public void create(){

		Fans expected = TEST_FAN;
		expected.setID(TEST_ID);

		try {

			mock.perform(post("/fans/create").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_FAN)))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object mapToDTO(List<FansDTO> expected) {
		return mapper.map(expected, FansDTO.class);
	}


	@Test
	public void getAll(){

		FansDTO TEST_FAN = new FansDTO(1L, player, 5, 10);
        Fans TEST_FAN2 = new Fans(1L, player, 10, 5);

		List<FansDTO> expected = new ArrayList<>();
		expected.add(TEST_FAN);

		List<Fans> expected2 = new ArrayList<>();
		expected2.add(TEST_FAN2);


		try {

			mock.perform(get("/fans/getAll").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_FAN2)))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}


	}


    
    @Test
	public void delete(){
		
		Fans TEST_FAN = new Fans(1L, player, 5, 10);
		
		Fans expected = null;
	

		try {

			mock.perform(post("/fans/delete/"+TEST_FAN.getID()).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_FAN.getID())))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}

	}



	@Test
	public void update(){

		Fans expected = TEST_FAN;
		expected.setID(TEST_ID);
	

		try {

			mock.perform(post("/fans/update/" + TEST_FAN.getID()).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_FAN)))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Test
	public void getOne(){

		Fans expected = TEST_FAN;
		expected.setID(TEST_ID);
	

		try {

			mock.perform(get("/fans/getOne/"+TEST_FAN.getID()).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
					.content(this.jsonifier.writeValueAsString(TEST_FAN.getID())))

					.andExpect(status().isOk())
					.andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(expected))));

		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
