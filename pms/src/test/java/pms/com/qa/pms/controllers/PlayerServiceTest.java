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

import pms.com.qa.pms.DTOs.PlayerDTO;
import pms.com.qa.pms.exceptions.PlayerNotFound;
import pms.com.qa.pms.models.Player;
import pms.com.qa.pms.repos.PlayerRepository;
import pms.com.qa.pms.runner.PmsApplication;

@SpringBootTest(classes = PmsApplication.class)
@ActiveProfiles("test")
public class PlayerServiceTest {

    @Autowired
	PlayerService service;

	@MockBean
	PlayerRepository repo;




    @Test
	public void testCreate() {


		Player player = new Player(null, "2", "uche", "egbon", "st", 22);

		Mockito.when(repo.save(player)).thenReturn(player);

		assertEquals(service.addPlayer(player), player);

		Mockito.verify(this.repo, Mockito.times(1)).save(player);

	}




  
    @Test
	public void testGetAll() {

        PlayerDTO player = new PlayerDTO(1L, "uche", "egbon", "2", "st", 22);
		Player player2 = new Player(1L, "2", "uche", "egbon", "st", 22);

        List<PlayerDTO> players = new ArrayList<>();
        players.add(player);

		List<Player> players2 = new ArrayList<>();
		players2.add(player2);

		Mockito.when(repo.findAll()).thenReturn(players2);

		assertEquals(service.getAllPlayers(), players);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}




	@Test 
	public void searchFirstName(){

		Player player = new Player(1L, "2", "uche", "egbon", "st", 22);

		Mockito.when(this.repo.findPlayerByFirstName("uche")).thenReturn(player);

		assertEquals(service.searchFirstName("uche"), player);

		Mockito.verify(this.repo, Mockito.times(1)).findPlayerByFirstName(player.getFirstName());


	}

	public Player searchLastName(String lastName) {
		return repo.findPlayerByLastName(lastName);
	}


	@Test 
	public void searchLastName(){

		Player player = new Player(1L, "2", "uche", "egbon", "st", 22);

		Mockito.when(this.repo.findPlayerByFirstName("egbon")).thenReturn(player);

		assertEquals(service.searchFirstName("egbon"), player);

		Mockito.verify(this.repo, Mockito.times(1)).findPlayerByFirstName(player.getLastName());


	}

	public Player getOnePlayer(long id) {
		return repo.findById(id).orElseThrow(PlayerNotFound::new);
	}

	@Test
	public void getOnePlayer(){

		Optional<Player> player = Optional.of(new Player(1L, "2", "uche", "egbon", "st", 22));

		Mockito.when(this.repo.findById(1L)).thenReturn(player);
		assertEquals(service.getOnePlayer(1L), player.get());

		Mockito.verify(this.repo, Mockito.times(1)).findById(player.get().getID());

	}


	@Test
	public void updatePlayer(){

		Optional<Player> player = Optional.of(new Player(1L, "2", "uche", "egbon", "st", 22));
		Player updatedPlayer = new Player(1L, "10", "uche", "egbon", "cb", 22);
		

		Mockito.when(this.repo.findById(1L)).thenReturn(player);
		Mockito.when(this.repo.save(updatedPlayer)).thenReturn(updatedPlayer);
		assertEquals(service.updatePlayer(1L, updatedPlayer), updatedPlayer);


		Mockito.verify(this.repo, Mockito.times(1)).findById(player.get().getID());
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedPlayer);


	}


	@Test
	public void removePlayer(){

		Optional<Player> player = Optional.of(new Player(1L, "2", "uche", "egbon", "st", 22));
		boolean expected = false;

		Mockito.when(this.repo.existsById(1L)).thenReturn(true, false);
		assertEquals(service.removePlayer(1l), expected);
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(player.get().getID());
	}



    
}
