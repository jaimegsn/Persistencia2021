package com.example.atv5;

import com.example.atv5.dao.FuncDAO;
import com.example.atv5.model.Funcionario;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {
	@Autowired
	FuncDAO funcDAO;


	public void mostrarFuncionario() throws SQLException {
		List<Funcionario> funcionarios = funcDAO.search();
		List<String> dados = new ArrayList<>();

		for(Funcionario func: funcionarios){
			String show = "\nId: "+ func.getId()+
					"\nNome do Funcionário: "+ func.getNome()+
					"\nMatrícula do Funcionário: "+ func.getMatricula()+
					"\nCpf do Funcionário: " + func.getCpf()+
					"\nEmail do Funcionário: "+ func.getEmail() +
					"\nTelefone do Funcionário: "+func.getTelefone()+"\n";
			dados.add(show);
		}
		JOptionPane.showMessageDialog(null, dados);
	}


	public static void preencherDados(Funcionario funcionario){
		String nome = JOptionPane.showInputDialog("nome", funcionario.getNome());
		funcionario.setNome(nome);
		String matricula = JOptionPane.showInputDialog("matricula", funcionario.getMatricula());
		funcionario.setMatricula(matricula);
		String cpf = JOptionPane.showInputDialog("cpf", funcionario.getCpf());
		funcionario.setCpf(cpf);
		String email = JOptionPane.showInputDialog("email", funcionario.getEmail());
		funcionario.setEmail(email);
		String telefone = JOptionPane.showInputDialog("telefone", funcionario.getTelefone());
		funcionario.setTelefone(telefone);
	}

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
		builder.headless(false).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		char nav = '0';
		while(nav != '5') {
			nav = JOptionPane.showInputDialog("Digite a opção que desejar:\n"
					+"1: Cadastrar um novo funcionário\n"
					+"2: Atualizar funcionário\n"
					+"3: Excluir funcionário\n"
					+"4: Mostrar funcionários\n"
					+"5: Exit").charAt(0);

			switch (nav){
				case '1'->{
					Funcionario funcionario = new Funcionario();
					preencherDados(funcionario);
					funcDAO.insert(funcionario);
				}
				case '2' -> {
					Funcionario funcionario1 = new Funcionario();
					int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
					funcionario1.setId(id);
					preencherDados(funcionario1);
					funcDAO.update(funcionario1);
				}
				case '3' -> {
					int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
					funcDAO.delete(id);
				}
				case '4' -> {
					mostrarFuncionario();
				}

			}
		}
	}

}
