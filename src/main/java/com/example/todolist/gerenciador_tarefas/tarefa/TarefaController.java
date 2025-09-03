package com.example.todolist.gerenciador_tarefas.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefa> buscarTodas(){
        return this.tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id){
        Tarefa tarefaEncontrad = this.tarefaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.status(HttpStatus.OK).body(tarefaEncontrad);
    }

    @PostMapping
    public ResponseEntity<Tarefa> cadastrarTarefa(@RequestBody Tarefa tarefa){

        Tarefa tarefaSalva = this.tarefaRepository.save(tarefa);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtributos){
        Tarefa tarefaParaAtualizar = this.tarefaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        tarefaParaAtualizar.setNome(tarefaAtributos.getNome());
        tarefaParaAtualizar.setDescricao(tarefaAtributos.getDescricao());
        tarefaParaAtualizar.setCategoria(tarefaAtributos.getCategoria());
        tarefaParaAtualizar.setPrioridade(tarefaAtributos.getPrioridade());
        tarefaParaAtualizar.setStatus(tarefaAtributos.getStatus());

        Tarefa tarefaAtualizada = this.tarefaRepository.save(tarefaParaAtualizar);

        return ResponseEntity.ok(tarefaAtualizada);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTarefa(@PathVariable Long id){
        this.tarefaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
