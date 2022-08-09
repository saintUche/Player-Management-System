package pms.com.qa.pms.controllers;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.com.qa.pms.DTOs.MatchDataDTO;
import pms.com.qa.pms.exceptions.MatchDataNotFound;
import pms.com.qa.pms.models.MatchData;
import pms.com.qa.pms.repos.MatchDataRepository;



@Service
public class MatchDataService {

	private MatchDataRepository repo;

	private ModelMapper mapper;

	private MatchDataDTO mapToDTO(MatchData matchData) {
		return mapper.map(matchData, MatchDataDTO.class);
	}

	@Autowired
	public MatchDataService(MatchDataRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public MatchData addMatchData(MatchData matchData) {
		System.out.println(matchData);
		return this.repo.save(matchData);
	}

	public List<MatchDataDTO> getAllMatchData() {
		return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public MatchData searchPlayerID(String playerId) {
		return repo.findMatchDataByPlayerID(playerId);
	}

	public MatchData getOneMatch(long id) {
		return repo.findById(id).orElseThrow(MatchDataNotFound::new);
	}

	public MatchData updateMatchData(Long id, MatchData matchData) {
		Optional<MatchData> existingOptional = this.repo.findById(id);
		MatchData existing = existingOptional.orElse(new MatchData());

		existing.setPlayer(matchData.getPlayer());
		existing.setNumOfGoals(matchData.getNumOfGoals());
		existing.setNumOfTackles(matchData.getNumOfTackles());

		return this.repo.save(existing);
	}

	public boolean removeMatchData(Long id) {
		repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		if (exists == false) {
			throw new MatchDataNotFound();
		}
		return !exists;
	}

}