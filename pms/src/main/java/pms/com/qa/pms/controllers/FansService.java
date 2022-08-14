package pms.com.qa.pms.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.com.qa.pms.DTOs.FansDTO;
import pms.com.qa.pms.exceptions.FansNotFound;
import pms.com.qa.pms.repos.FansRepository;
import pms.com.qa.pms.models.Fans;
import pms.com.qa.pms.models.Player;


@Service
public class FansService {

	private FansRepository repo;

	private ModelMapper mapper;

	private FansDTO mapToDTO(Fans fans) {
		return mapper.map(fans, FansDTO.class);
	}

	@Autowired
	public FansService(FansRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public Fans addFans(Fans fans) {
		return this.repo.save(fans);
	}

	public List<FansDTO> getAllFanss() {
		return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}


	public Fans getOneFans(long id) {
		return repo.findById(id).orElseThrow(FansNotFound::new);
	}

	public Fans updateFans(Long id, Fans fans) {
		Optional<Fans> existingOptional = this.repo.findById(id);
		Fans existing = existingOptional.orElse(new Fans());

		existing.setSupporters(fans.getSupporters());
		existing.setHaters(fans.getHaters());

		return this.repo.save(existing);
	}

	public boolean removeFans(Long id) {
		repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		if (exists == false) {
			throw new FansNotFound();
		}
		return !exists;
	}

}