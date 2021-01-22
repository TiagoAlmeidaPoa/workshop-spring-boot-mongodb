package com.tiagoalmeida.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoalmeida.workshopmongo.domain.User;
import com.tiagoalmeida.workshopmongo.dto.UserDto;
import com.tiagoalmeida.workshopmongo.repository.UserRepository;
import com.tiagoalmeida.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("User not found by id"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDto objDto) {
		User user = new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		return user;
	}

}
