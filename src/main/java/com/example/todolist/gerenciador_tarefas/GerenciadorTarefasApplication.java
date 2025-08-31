package com.example.todolist.gerenciador_tarefas;

import com.example.todolist.gerenciador_tarefas.tarefa.Tarefa;
import com.example.todolist.gerenciador_tarefas.tarefa.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorTarefasApplication implements CommandLineRunner {

	@Autowired
	private TarefaRepository tarefaRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorTarefasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("### APLICAÇÃO INICIADA ###");
		System.out.println("--- Cadastrando uma tarefa de teste... ---");

		Tarefa tarefaTeste = new Tarefa(
				null,
				"TarefaTeste01",
				"Testando Cadastro de Tarefas",
				"Testes",
				"baixa",
				"doing"
		);

		this.tarefaRepository.save(tarefaTeste);

		System.out.println("--- Tarefa de teste cadastrada com sucesso! ---");
	}
}
