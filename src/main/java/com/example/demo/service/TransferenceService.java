package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transference;
import com.example.demo.repository.TransferenceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferenceService {
	
	@Autowired
	TransferenceRepository transferenceRepository;
	
	public Transference calculo(Transference transference) {
		
		int dayTransference = transference.getDataTransference().getDayOfMonth();
		int dayAgendado = transference.getDataAgendada().getDayOfMonth();
		if (transference.getDataTransference().equals(transference.getDataAgendada()) ) {
			transference.setTaxa(transference.getTaxa().add(new BigDecimal("1"))
					.multiply(new BigDecimal("3")));
			
			
			
			transference.setValor(transference.getValor().add(transference.getTaxa()));
			return transference;
		}
		//Operação Tipo B
		if (dayAgendado - dayTransference <= 10) {
			transference.setTaxa(transference.getTaxa().add(new BigDecimal("12.00")));
			transference.setValor(transference.getValor().add(transference.getTaxa()));
			return transference;
		}
		//Operação Tipo C.1
		else if(dayAgendado - dayTransference > 10 && dayAgendado - dayTransference < 20) {
			transference.setTaxa(transference.getTaxa().add(new BigDecimal("1.00")));
			transference.setTaxa(transference.getTaxa()
					.multiply(new BigDecimal("8.2")
					.divide(new BigDecimal("100"))));
			transference.setValor(transference.getValor().add(transference.getTaxa()));
			return transference;
		}
		//Operação Tipo C.2
		else if(dayAgendado - dayTransference > 20 && dayAgendado - dayTransference < 30) {
			transference.setTaxa(transference.getTaxa().add(new BigDecimal("1.00")));
			transference.setTaxa(transference.getTaxa()
					.multiply(new BigDecimal("6.9")
					.divide(new BigDecimal("100"))));
			transference.setValor(transference.getValor().add(transference.getTaxa()));
			return transference;
		}
		//Operação Tipo C.3
		else if(dayAgendado - dayTransference > 30 && dayAgendado - dayTransference < 40) {
			transference.setTaxa(transference.getTaxa().add(new BigDecimal("1.00")));
			transference.setTaxa(transference.getTaxa()
					.multiply(new BigDecimal("4.7")
					.divide(new BigDecimal("100"))));
			transference.setValor(transference.getValor().add(transference.getTaxa()));
			return transference;
		}
		//Operação Tipo C.4
		else if(dayAgendado - dayTransference > 40) {
			transference.setTaxa(transference.getTaxa().add(new BigDecimal("1.00")));
			transference.setTaxa(transference.getTaxa()
					.multiply(new BigDecimal("1.7")
					.divide(new BigDecimal("100"))));
			transference.setValor(transference.getValor().add(transference.getTaxa()));
			return transference;
		}
		return transference;
	}
	
	public List<Transference> buscarTodos() {
		return transferenceRepository.findAll();
	}
	
	public Optional<Transference> buscarPorId(Long id) {
		return transferenceRepository.findById(id);
	}
	
	public Transference salvar(Transference transference) {
		Transference newTransference = this.calculo(transference); 
		return transferenceRepository.save(newTransference);
	}
	
	

	
	

} 

