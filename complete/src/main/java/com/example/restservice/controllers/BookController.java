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

@RestController
@RequestMapping("/api/books")
public class BookController {

	@GetMapping()
	public List<Book> read() {
		throw new ResponseStatusException(
				HttpStatus.NOT_IMPLEMENTED, "Not Implemented READ");
	}

	@GetMapping("/{id}")
	public Book readOne(@PathVariable(required = true) Long id) {
		throw new ResponseStatusException(
				HttpStatus.NOT_IMPLEMENTED, "Not Implemented");
	}

	@PostMapping()
	public Book create(@RequestBody Book book) {
		throw new ResponseStatusException(
				HttpStatus.NOT_IMPLEMENTED, "Not Implemented");
	}

	@PutMapping("/{id}")
	public Book update(@PathVariable(required = true) Long id, @RequestBody Book book) {
		throw new ResponseStatusException(
				HttpStatus.NOT_IMPLEMENTED, "Not Implemented");
	}

	@DeleteMapping("/{id}")
	public Book delete(@PathVariable Long id) {
		throw new ResponseStatusException(
				HttpStatus.NOT_IMPLEMENTED, "Not Implemented");
	}
}
