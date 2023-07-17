package com.example.ProjetoFerias.controller;

import com.example.ProjetoFerias.tarefa.tarefa;
import com.example.ProjetoFerias.tarefa.tarefaRepository;
import com.example.ProjetoFerias.tarefa.tarefarequestDTO;
import com.example.ProjetoFerias.tarefa.tarefarespondeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tarefa")
@CrossOrigin(origins = "http://localhost:3000")
public class tarefacontroller {
    @Autowired
    private tarefaRepository repository;

        @PostMapping("/cadastrar")
        public Boolean cadastrar(@RequestBody tarefarequestDTO data) {
            tarefa tarefa = new tarefa(data);
            System.out.println(tarefa.toString());
            repository.save(tarefa);
            return true;
        }


        // FUNCIONANDO

        @GetMapping("/listar")
        public List<tarefarespondeDTO> listar() {
            List<tarefarespondeDTO> tarefas = repository.findAll().stream().map(tarefarespondeDTO::new).collect(Collectors.toList());
            return tarefas;
        }

//        @PutMapping("/editar")
//        public tarefarequestDTO editar(@RequestBody tarefarequestDTO data) {
//            // PEGANDO O ID PELO BODY INVEZ DE UM PARAMETRO
//            tarefa tarefa = repository.getReferenceById(data.id());
//            tarefa.setNome(data.nome());
//            tarefa.setDescricao(data.descricao());
//            repository.save(tarefa);
//            return ResponseEntity.ok(data).getBody();
//        }

    @PutMapping("/editar/{id}")
    public ResponseEntity<tarefa> editar(@PathVariable Long id, @RequestBody tarefarequestDTO data) {
        // pegando ID PELO PARAMETRO
        tarefa tarefa = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada com o ID: " + id));
        tarefa.setNome(data.nome());
        tarefa.setDescricao(data.descricao());
        repository.save(tarefa);
        return ResponseEntity.ok(tarefa);
    }

        @DeleteMapping ("/excluir/{id}")
        public Boolean excluir(@PathVariable Long id) {
            repository.deleteById(id);
            return true;
        }




}
