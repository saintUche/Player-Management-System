package com.qa.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.DTOs.PlayerDTO;
import com.qa.models.Player;


@Service
@RestController

public class PlayerController {

	@GetMapping("/player")
	public String home() {
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
		return service.getAllPlayers();
	}

	@GetMapping("/player/search")
	public Player search(@PathParam("firstName") String firstName, @PathParam("LastName") String lastName) {
		if (firstName != null) {
			return service.searchFirstName(firstName);
		}
		if (lastName != null) {
			return service.searchLastName(lastName);
		} else {
			return null;
		}

	}

	@PostMapping("/player/create")
	public Player create(@RequestBody Player player) {
		return service.addPlayer(player);
	}

	@PostMapping("/player/delete")
	public boolean delete(@PathParam("id") Long id) {
		return service.removePlayer(id);
	}

	@PostMapping("/player/update")
	public Player update(@PathParam("id") Long id, @RequestBody Player player) {
		return service.updatePlayer(id, player);
	}

	@GetMapping("/player/getOne")
	public Player getOne(@PathParam("id") Long id) {
		return service.getOnePlayer(id);
	}

}