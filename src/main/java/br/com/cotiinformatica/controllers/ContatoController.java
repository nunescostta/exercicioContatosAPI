package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ContatoPostDto;
import br.com.cotiinformatica.dtos.ContatoPutDto;
import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.repositories.IContatoRepository;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

	@Autowired
	private IContatoRepository iContatoRepository;

	@PostMapping
	public ResponseEntity<String> post(@RequestBody ContatoPostDto dto) {
		try {

			Contato contato = new Contato();
			contato.setNome(dto.getNome());
			contato.setEmail(dto.getEmail());
			contato.setTelefone(dto.getTelefone());

			iContatoRepository.save(contato);

			return ResponseEntity.status(201).body("PRODUTO CADASTRADO COM SUCESSO");

		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());

		}
	}

	@PutMapping
	public ResponseEntity<String> put(@RequestBody ContatoPutDto dto) {
		try {

			Contato contato = iContatoRepository.findById(dto.getIdContato()).get();

			contato.setNome(dto.getNome());
			contato.setEmail(dto.getEmail());
			contato.setTelefone(dto.getTelefone());

			iContatoRepository.save(contato);

			return ResponseEntity.status(201).body("PRODUTO ATUALIZADO COM SUCESSO");

		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}

	}

	@DeleteMapping
	public ResponseEntity<String> delet(@PathVariable("id") Integer id) {
		try {

			Contato contato = iContatoRepository.findById(id).get();

			iContatoRepository.delete(contato);

			return ResponseEntity.status(201).body("PRODUTO EXCLUIDO COM SUCESSO");
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@GetMapping
	public List<Contato> get() {
		return iContatoRepository.findAll();
	}

}
