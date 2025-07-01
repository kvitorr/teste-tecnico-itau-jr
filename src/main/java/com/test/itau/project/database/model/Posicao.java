package com.test.itau.project.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "posicoes",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"usuario_id", "ativo_id", "data_hora"}
        ))
public class Posicao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ativo_id", nullable = false)
    private Ativo ativo;

    @DecimalMin("0.000001")
    @Column(nullable = false, precision = 19, scale = 6)
    private BigDecimal quantidade;

    @DecimalMin("0.00")
    @Column(name = "preco_medio", nullable = false, precision = 19, scale = 6)
    private BigDecimal precoMedio;

    @Column(name = "pl", precision = 19, scale = 6)
    private BigDecimal profitAndLoss;

    @NotNull
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    public Posicao(UUID id, Usuario usuario, Ativo ativo, BigDecimal quantidade, BigDecimal precoMedio, BigDecimal profitAndLoss, LocalDateTime dataHora) {
        this.id = id;
        this.usuario = usuario;
        this.ativo = ativo;
        this.quantidade = quantidade;
        this.precoMedio = precoMedio;
        this.profitAndLoss = profitAndLoss;
        this.dataHora = dataHora;
    }

    public Posicao() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(BigDecimal precoMedio) {
        this.precoMedio = precoMedio;
    }

    public BigDecimal getProfitAndLoss() {
        return profitAndLoss;
    }

    public void setProfitAndLoss(BigDecimal profitAndLoss) {
        this.profitAndLoss = profitAndLoss;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
