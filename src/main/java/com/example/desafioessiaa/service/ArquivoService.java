package com.example.desafioessiaa.service;

import com.example.desafioessiaa.Exception.BusinessException;
import com.example.desafioessiaa.model.Arquivo;
import com.example.desafioessiaa.repository.ArquivoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;

    @Transactional
    public Arquivo create(final Arquivo arquivo) {
        return arquivoRepository.save(arquivo);
    }

    public List<Arquivo> findAll() {
        return arquivoRepository.findAll();
    }

    public Optional<Arquivo> findById(Long id) {
        return arquivoRepository.findById(id);
    }

    public Optional<Arquivo> update(Long id, Arquivo detalhesArquivo) {
        Optional<Arquivo> optionalArquivo = arquivoRepository.findById(id);
        if (optionalArquivo.isPresent()) {
            Arquivo arquivo = optionalArquivo.get();
            arquivo.setNome(detalhesArquivo.getNome());
            arquivo.setDiretorio(detalhesArquivo.getDiretorio());
            return Optional.of(arquivoRepository.save(arquivo));
        } else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id) {
        try {
            Optional<Arquivo> arquivo = arquivoRepository.findById(id);
            if (arquivo.isPresent()) {
                arquivoRepository.delete(arquivo.get());
                return true;
            } else {
                throw new BusinessException("Arquivo com o ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            throw new BusinessException("Erro ao excluir o arquivo com ID " + id + ". Detalhes: " + e.getMessage());
        }
    }

}

