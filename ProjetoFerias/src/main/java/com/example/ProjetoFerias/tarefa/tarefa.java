package com.example.ProjetoFerias.tarefa;

import jakarta.persistence.*;

@Table(name = "tarefa")
@Entity(name = "tarefa")
public class tarefa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    public tarefa(){

    }
// CONSTRUTOR PARA CONVERTER O OBJETO tarefarequestDTO EM tarefa


    public tarefa(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

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

    @Override
    public String toString() {
        return "tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public tarefa(tarefarequestDTO  data) {

        this.nome = data.nome();
        this.descricao = data.descricao();
    }




}
