package com.test.itau.project.database.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ativos")
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50, unique = true)
    private String codigo;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @OneToMany(
            mappedBy = "ativo",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Operacao> operacoes = new ArrayList<>();

    @OneToMany(
            mappedBy = "ativo",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Cotacao> cotacoes;

    @OneToMany(
            mappedBy = "ativo",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Posicao> posicoes;

    public Ativo(UUID id, String codigo, String nome, List<Operacao> operacoes, List<Cotacao> cotacoes, List<Posicao> posicoes) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.operacoes = operacoes;
        this.cotacoes = cotacoes;
        this.posicoes = posicoes;
    }

    public Ativo() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public List<Cotacao> getCotacoes() {
        return cotacoes;
    }

    public void setCotacoes(List<Cotacao> cotacoes) {
        this.cotacoes = cotacoes;
    }

    public List<Posicao> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(List<Posicao> posicoes) {
        this.posicoes = posicoes;
    }
}
