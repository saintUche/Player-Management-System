package pms.com.qa.pms.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import pms.com.qa.pms.DTOs.FansDTO;
import pms.com.qa.pms.exceptions.FansNotFound;
import pms.com.qa.pms.models.Fans;
import pms.com.qa.pms.models.Player;
import pms.com.qa.pms.repos.FansRepository;
import pms.com.qa.pms.runner.PmsApplication;

@SpringBootTest(classes = PmsApplication.class)
@ActiveProfiles("test")
public class FansServiceTest {

    @Autowired
	FansService service;

	@MockBean
	FansRepository repo;


    @Test
	public void testCreate() {

        Player player = new Player(1L, "2", "uche", "egbon", "st", 22);

		Fans fan = new Fans(null, player, 5, 10);


		Mockito.when(repo.save(fan)).thenReturn(fan);

		assertEquals(service.addFans(fan), fan);

		Mockito.verify(this.repo, Mockito.times(1)).save(fan);

	}


  
    @Test
	public void testGetAll() {

        Player player = new Player(1L, "2", "uche", "egbon", "st", 22);
        FansDTO fan = new FansDTO(1L, player, 5, 10);
		Fans fan2 = new Fans(1L, player, 10, 5);

        List<FansDTO> fans = new ArrayList<>();
        fans.add(fan);

		List<Fans> fans2 = new ArrayList<>();
		fans2.add(fan2);

		Mockito.when(repo.findAll()).thenReturn(fans2);

		assertEquals(service.getAllFanss(), fans);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}







	public Fans getOneFans(long id) {
		return repo.findById(id).orElseThrow(FansNotFound::new);
	}

	@Test
	public void getOneFans(){

        Player player = new Player(1L, "2", "uche", "egbon", "st", 22);
		Optional<Fans> fans = Optional.of(new Fans(1L, player, 5, 10));

		Mockito.when(this.repo.findById(1L)).thenReturn(fans);
		assertEquals(service.getOneFans(1L), fans.get());

		Mockito.verify(this.repo, Mockito.times(1)).findById(fans.get().getID());

	}


	@Test
	public void updateFans(){

        Player player = new Player(1L, "2", "uche", "egbon", "st", 22);
		Optional<Fans> fans = Optional.of(new Fans(1L, player, 5, 10));
		Fans updatedFans = new Fans(1L, player, 5, 12);
		

		Mockito.when(this.repo.findById(1L)).thenReturn(fans);
		Mockito.when(this.repo.save(updatedFans)).thenReturn(updatedFans);
		assertEquals(service.updateFans(1L, updatedFans), updatedFans);


		Mockito.verify(this.repo, Mockito.times(1)).findById(fans.get().getID());
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedFans);


	}


	@Test
	public void removeFans(){

        Player player = new Player(1L, "2", "uche", "egbon", "st", 22);
		Optional<Fans> fans = Optional.of(new Fans(1L, player, 5, 10));
		boolean expected = false;

		Mockito.when(this.repo.existsById(1L)).thenReturn(true, false);
		assertEquals(service.removeFans(1l), expected);
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(fans.get().getID());
	}



    
}