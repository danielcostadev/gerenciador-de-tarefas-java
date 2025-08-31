package com.example.todolist.gerenciador_tarefas.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefa> listarTodas(){
        return this.tarefaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Tarefa> cadastrarTarefa(@RequestBody Tarefa tarefa){

        Tarefa tarefaSalva = this.tarefaRepository.save(tarefa);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);
    }

}
