package com.example.restservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/{id}")
	public Author readOne(@PathVariable(required = true) Long id) {
		var author = entityManager.find(Author.class, id);
		return author;
	}

	@GetMapping()
	public List<Author> read() {
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		var criteriaQuery = criteriaBuilder.createQuery(Author.class);
		var employeeRoot = criteriaQuery.from(Author.class);

		criteriaQuery.select(employeeRoot);

		var query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@PostMapping()
	@Transactional
	public void create(@RequestBody Author author) {
		entityManager.persist(author);
	}

	@PutMapping("/{id}")
	@Transactional
	public Author update(@PathVariable(required = true) Long id, @RequestBody Author author) {
		var current = entityManager.find(Author.class, id);
		if (current == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Author not found");
		}

		current.bio = author.bio;
		current.name = author.name;
		entityManager.flush();
		entityManager.clear();
		return current;

	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable(required = true) Long id) {
		var author = entityManager.find(Author.class, id);
		if (author == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Author not found");
		}

		entityManager.remove(author);
		entityManager.flush();
		entityManager.clear();
		return true;

	}
}
