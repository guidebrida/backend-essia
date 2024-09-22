package com.example.desafioessiaa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "TB_DIRETORIOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Diretorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @ManyToOne
    @JoinColumn(name = "diretorioPai")
    private Diretorio diretorioPai;

    @OneToMany(mappedBy = "diretorio", cascade = CascadeType.ALL)
    private List<Arquivo> arquivos;

}
