package com.jasmine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasmine.model.User;
import com.jasmine.repository.UserRepository;

/**
 * Classe responsavel por expor os serviços disponiveis com a entidade User
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User login(String login, String password) {
		return this.userRepo.findByLoginAndPassword(login, password);
	}

	public User insert(User user) {
		return this.userRepo.insert(user);
	}

	public User save(User user) {
		return this.userRepo.save(user);
	}

	public void delete(User user) {
		this.userRepo.delete(user);
	}

	public void findOne(String id) {
		this.userRepo.findOne(id);
	}

}
