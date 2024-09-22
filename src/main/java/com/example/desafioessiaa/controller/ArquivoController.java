package com.example.desafioessiaa.controller;

import com.example.desafioessiaa.model.Arquivo;
import com.example.desafioessiaa.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/arquivos")
@CrossOrigin(origins = "http://localhost:3000")
public class ArquivoController {

    @Autowired
    private ArquivoService arquivoService;

    @PostMapping
    public Arquivo criarArquivo(@RequestBody Arquivo arquivo) {
        return arquivoService.create(arquivo);
    }

    @GetMapping
    public List<Arquivo> listarArquivos() {
        return arquivoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arquivo> obterArquivo(@PathVariable Long id) {
        Optional<Arquivo> arquivo = arquivoService.findById(id);
        if (arquivo.isPresent()) {
            return ResponseEntity.ok(arquivo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Arquivo> atualizarArquivo(@PathVariable Long id, @RequestBody Arquivo detalhesArquivo) {
        Optional<Arquivo> arquivoAtualizado = arquivoService.update(id, detalhesArquivo);
        if (arquivoAtualizado.isPresent()) {
            return ResponseEntity.ok(arquivoAtualizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarArquivo(@PathVariable Long id) {
        boolean deletado = arquivoService.delete(id);
        if (deletado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}