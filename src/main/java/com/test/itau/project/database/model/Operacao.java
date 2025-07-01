package com.test.itau.project.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.test.itau.project.enums.TipoOperacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "operacoes",
        uniqueConstraints = @UniqueConstraint(
        columnNames = {"usuario_id", "ativo_id", "data_hora"}
))
public class Operacao implements Serializable {

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
    @Column(name = "preco_unitario", nullable = false, precision = 19, scale = 6)
    private BigDecimal precoUnitario;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_operacao", nullable = false, length = 10)
    private TipoOperacao tipoOperacao;

    @DecimalMin("0.00")
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal corretagem;

    @NotNull
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    public Operacao(UUID id, Usuario usuario, Ativo ativo, BigDecimal quantidade, BigDecimal precoUnitario, TipoOperacao tipoOperacao, BigDecimal corretagem, LocalDateTime dataHora) {
        this.id = id;
        this.usuario = usuario;
        this.ativo = ativo;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.tipoOperacao = tipoOperacao;
        this.corretagem = corretagem;
        this.dataHora = dataHora;
    }

    public Operacao() {
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

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public BigDecimal getCorretagem() {
        return corretagem;
    }

    public void setCorretagem(BigDecimal corretagem) {
        this.corretagem = corretagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
