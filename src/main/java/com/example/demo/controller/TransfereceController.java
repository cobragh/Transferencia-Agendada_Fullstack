package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transference;
import com.example.demo.service.TransferenceService;

@RestController
@RequestMapping("/v1")
public class TransfereceController {
	
	@Autowired
	TransferenceService transferenceService;
	
	@GetMapping
	public List<Transference> buscarTodos() {
		return transferenceService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public Optional<Transference> buscaPorId(@PathVariable Long id) {
		return transferenceService.buscarPorId(id);
	}
	
	@PostMapping
	public Transference salvar(@RequestBody Transference transference) {
		return transferenceService.salvar(transference);
	}
	
}
