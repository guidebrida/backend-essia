package com.example.desafioessiaa.dto;

import com.example.desafioessiaa.model.Diretorio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoDTO {

    private Long id;

    private String nome;

    private Diretorio diretorio;

}

