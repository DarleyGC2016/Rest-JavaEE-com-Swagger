package com.stefanini.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "co_seq_perfil")
    private Long id;
    /**
     *
     */
    @NotNull
    @Column(name = "no_perfil")
    private String nome;
    /**
     *
     */
    @NotNull
    @Column(name = "ds_perfil")
    private String descricao;
    /**
     *
     */
    
    @Column(name = "dt_hora_inclusao")
    @NotNull
    private LocalDate dataHoraInclusao;
    /**
     *
     */
    
    @Column(name = "dt_hora_alteracao")
    private LocalDate dataHoraAlteracao;

//    /**
//     * Mapeamento de Pessoa
//     */
//    @ManyToMany(mappedBy = "perfils")
//    private Set<Pessoa> pessoas;


    public Perfil() {
    }

    public Perfil(@NotNull String nome, @NotNull String descricao, @NotNull LocalDate dataHoraInclusao, LocalDate dataHoraAlteracao) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataHoraInclusao = dataHoraInclusao;
        this.dataHoraAlteracao = dataHoraAlteracao;
//        this.pessoas = pessoas;
    }

//    public Set<Pessoa> getPessoas() {
//        return pessoas;
//    }
//
//    public void setPessoas(Set<Pessoa> pessoas) {
//        this.pessoas = pessoas;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataHoraInclusao() {
        return dataHoraInclusao;
    }

    public void setDataHoraInclusao(LocalDate dataHoraInclusao) {
        this.dataHoraInclusao = dataHoraInclusao;
    }

    public LocalDate getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDate dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataHoraInclusao=" + dataHoraInclusao +
                ", dataHoraAlteracao=" + dataHoraAlteracao +
//                ", pessoas=" + pessoas +
                '}';
    }
}
