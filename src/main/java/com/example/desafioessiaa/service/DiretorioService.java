package com.example.desafioessiaa.service;

import com.example.desafioessiaa.Exception.BusinessException;
import com.example.desafioessiaa.dto.DiretorioDTO;
import com.example.desafioessiaa.model.Diretorio;
import com.example.desafioessiaa.repository.DiretorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiretorioService {
    @Autowired
    private DiretorioRepository diretorioRepository;

    public Diretorio create(Diretorio diretorio) {
        return diretorioRepository.save(diretorio);
    }

    public Optional<Diretorio> findById(Long id) {
        return diretorioRepository.findById(id);
    }

    public List<Diretorio> findAll() {
        return diretorioRepository.findAll();
    }

    public Optional<Diretorio> update(Long id, Diretorio detalhesDiretorio) {
        Optional<Diretorio> optionalDiretorio = diretorioRepository.findById(id);
        if (optionalDiretorio.isPresent()) {
            Diretorio diretorio = optionalDiretorio.get();
            diretorio.setNome(detalhesDiretorio.getNome());
            return Optional.of(diretorioRepository.save(diretorio));
        } else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id) {
        try {
            Optional<Diretorio> diretorio = diretorioRepository.findById(id);
            if (diretorio.isPresent()) {
                diretorioRepository.delete(diretorio.get());
                return true;
            } else {
                throw new BusinessException("Diretório com o ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            throw new BusinessException("Erro ao excluir o diretório com ID " + id + ". Detalhes: " + e.getMessage());
        }
    }
}