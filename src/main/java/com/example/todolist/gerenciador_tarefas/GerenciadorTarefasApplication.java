package com.example.todolist.gerenciador_tarefas;

import com.example.todolist.gerenciador_tarefas.tarefa.Tarefa;
import com.example.todolist.gerenciador_tarefas.tarefa.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorTarefasApplication {

	@Autowired
	private TarefaRepository tarefaRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorTarefasApplication.class, args);
	}

}
