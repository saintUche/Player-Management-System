package pms.com.qa.pms.controllers;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pms.com.qa.pms.DTOs.PlayerDTO;
import pms.com.qa.pms.models.Player;




@Service
@RestController

public class PlayerController {


	@GetMapping("/player")
	public String home(Model model) {
		return "home";
	}

	private PlayerService service;

	@Autowired
	public PlayerController(PlayerService service) {
		super();
		this.service = service;
	}

	@GetMapping("/player/getAll")
	public List<PlayerDTO> getAll() {
		return this.service.getAllPlayers();
	}
	@PostMapping("/player/create")
	public Player create(@RequestBody Player player) {
		return this.service.addPlayer(player);
	}

	@DeleteMapping("/player/delete/{id}")
	public boolean delete(@PathParam("id") Long id) {
		return this.service.removePlayer(id);
	}

	@PutMapping("/player/update/{id}")
	public Player update(@PathParam("id") Long id, @RequestBody Player player) {
		return this.service.updatePlayer(id, player);
	}

	@GetMapping("/player/getOne/{id}")
	public Player getOne(@PathParam("id") Long id) {
		return this.service.getOnePlayer(id);
	}

}