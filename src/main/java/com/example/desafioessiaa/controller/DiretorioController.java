package com.example.desafioessiaa.controller;

import com.example.desafioessiaa.dto.DiretorioDTO;
import com.example.desafioessiaa.model.Diretorio;
import com.example.desafioessiaa.repository.DiretorioRepository;
import com.example.desafioessiaa.service.DiretorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diretorios")
@CrossOrigin(origins = "http://localhost:3000")
public class DiretorioController {

    @Autowired
    private DiretorioService diretorioService;

    @PostMapping
    public Diretorio criarDiretorio(@RequestBody DiretorioDTO diretorioDTO) {
        Diretorio diretorio = new Diretorio();
        diretorio.setId(diretorioDTO.getId());
        diretorio.setDiretorioPai(diretorioDTO.getDiretorioPai());
        diretorio.setNome(diretorioDTO.getNome());
        return diretorioService.create(diretorio);
    }

    @GetMapping
    public List<Diretorio> listarDiretorios() {
        return diretorioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diretorio> obterDiretorio(@PathVariable Long id) {
        Optional<Diretorio> diretorio = diretorioService.findById(id);
        if (diretorio.isPresent()) {
            return ResponseEntity.ok(diretorio.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diretorio> atualizarDiretorio(@PathVariable Long id, @RequestBody Diretorio detalhesDiretorio) {
        Optional<Diretorio> diretorioAtualizado = diretorioService.update(id, detalhesDiretorio);
        if (diretorioAtualizado.isPresent()) {
            return ResponseEntity.ok(diretorioAtualizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDiretorio(@PathVariable Long id) {
        diretorioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
