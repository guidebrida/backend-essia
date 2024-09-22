package com.example.desafioessiaa.dto;

import com.example.desafioessiaa.model.Arquivo;
import com.example.desafioessiaa.model.Diretorio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiretorioDTO {

    private Long id;
    private String nome;
    private Diretorio diretorioPai;
}
