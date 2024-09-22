package com.example.desafioessiaa.repository;

import com.example.desafioessiaa.dto.DiretorioDTO;
import com.example.desafioessiaa.model.Diretorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorioRepository extends JpaRepository<Diretorio, Long> {
}
