package com.example.desafioessiaa.repository;

import com.example.desafioessiaa.model.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {
}
