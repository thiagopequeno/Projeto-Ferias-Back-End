package com.example.ProjetoFerias.tarefa;

public record tarefarespondeDTO(Long id, String nome, String descricao) {

    public tarefarespondeDTO(tarefa tarefa) {
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao());
    }
}
