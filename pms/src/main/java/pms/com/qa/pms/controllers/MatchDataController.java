package pms.com.qa.pms.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import pms.com.qa.pms.DTOs.MatchDataDTO;
import pms.com.qa.pms.models.MatchData;

@Service
@RestController

public class MatchDataController {

	@GetMapping("/matchData")
	public String home() {
		return "home";
	}

	private MatchDataService service;

	@Autowired
	public MatchDataController(MatchDataService service) {
		super();
		this.service = service;
	}

	@GetMapping("/matchData/getAll")
	public List<MatchDataDTO> getAll() {
		return service.getAllMatchData();
	}

	@GetMapping("/matchData/search")
	public MatchData search(@PathParam("playerId") String playerId) {
		if (playerId != null) {
			return service.searchPlayerID(playerId);
		} else {
			return null;
		}

	}

	@PostMapping("/matchData/create")
	public MatchData create(@RequestBody MatchData matchData) {
		return service.addMatchData(matchData);
	}

	@PostMapping("/matchData/delete")
	public boolean delete(@PathParam("id") Long id) {
		return service.removeMatchData(id);
	}

	@PostMapping("/matchData/update")
	public MatchData update(@PathParam("id") Long id, @RequestBody MatchData matchData) {
		return service.updateMatchData(id, matchData);
	}

	@GetMapping("/matchData/getOne")
	public MatchData getOne(@PathParam("id") Long id) {
		return service.getOneMatch(id);
	}

}