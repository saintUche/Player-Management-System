package pms.com.qa.pms.controllers;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pms.com.qa.pms.DTOs.FansDTO;
import pms.com.qa.pms.models.Fans;
import pms.com.qa.pms.models.Player;




@Service
@RestController
public class FansController {

	@GetMapping("/fans")
	public String home() {
		return "home";
	}

	private FansService service;

	@Autowired
	public FansController(FansService service) {
		super();
		this.service = service;
	}

	@GetMapping("/fans/getAll")
	public List<FansDTO> getAll() {
		return service.getAllFanss();
	}


	@PostMapping("/fans/create")
	public Fans create(@RequestBody Fans fans) {
		return service.addFans(fans);
	}

	@PostMapping("/fans/delete/{id}")
	public boolean delete(@PathParam("id") Long id) {
		return service.removeFans(id);
	}

	@PostMapping("/fans/update/{id}")
	public Fans update(@PathParam("id") Long id, @RequestBody Fans fans) {
		return service.updateFans(id, fans);
	}

	@GetMapping("/fans/getOne/{id}")
	public Fans getOne(@PathParam("id") Long id) {
		return service.getOneFans(id);
	}

}