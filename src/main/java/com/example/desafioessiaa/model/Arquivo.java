package com.example.desafioessiaa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "TB_ARQUIVOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @ManyToOne
    @JoinColumn(name = "diretorio_id")
    private Diretorio diretorio;
}
