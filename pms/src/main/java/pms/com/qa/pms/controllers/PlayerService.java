package pms.com.qa.pms.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.com.qa.pms.DTOs.PlayerDTO;
import pms.com.qa.pms.exceptions.PlayerNotFound;
import pms.com.qa.pms.models.Player;
import pms.com.qa.pms.repos.PlayerRepository;



@Service
public class PlayerService {

	private PlayerRepository repo;

	private ModelMapper mapper;

	private PlayerDTO mapToDTO(Player player) {
		return mapper.map(player, PlayerDTO.class);
	}

	@Autowired
	public PlayerService(PlayerRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public Player addPlayer(Player player) {
		return this.repo.save(player);
	}

	public List<PlayerDTO> getAllPlayers() {
		return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public Player searchFirstName(String firstName) {
		return repo.findPlayerByFirstName(firstName);
	}

	public Player searchLastName(String lastName) {
		return repo.findPlayerByLastName(lastName);
	}

	public Player getOnePlayer(long id) {
		return repo.findById(id).orElseThrow(PlayerNotFound::new);
	}

	public Player updatePlayer(Long id, Player player) {
		Optional<Player> existingOptional = this.repo.findById(id);
		Player existing = existingOptional.orElse(new Player());

		existing.setKitNumber(player.getKitNumber());
		existing.setFirstName(player.getFirstName());
		existing.setLastName(player.getLastName());
        existing.setPosition(player.getPosition());
        existing.setAge(player.getAge());

		return this.repo.save(existing);
	}

	public boolean removePlayer(Long id) {
		repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		if (exists == false) {
			throw new PlayerNotFound();
		}
		return !exists;
	}

}