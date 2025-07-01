package com.test.itau.project.database.model;

import java.math.BigDecimal;
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
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "posicoes",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"email"}
        ))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @Email
    @NotBlank
    @Size(max = 150)
    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @DecimalMin("0.00")
    @DecimalMax("100.00")
    @Column(name = "percent_corretagem", nullable = false, precision = 5, scale = 2)
    private BigDecimal percentCorretagem;

    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Operacao> operacoes;

    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Posicao> posicoes;

    public Usuario(UUID id, String nome, String email, BigDecimal percentCorretagem, List<Operacao> operacoes, List<Posicao> posicoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.percentCorretagem = percentCorretagem;
        this.operacoes = operacoes;
        this.posicoes = posicoes;
    }

    public Usuario() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getPercentCorretagem() {
        return percentCorretagem;
    }

    public void setPercentCorretagem(BigDecimal percentCorretagem) {
        this.percentCorretagem = percentCorretagem;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public List<Posicao> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(List<Posicao> posicoes) {
        this.posicoes = posicoes;
    }
}
