package br.com.empresa.control;

import br.com.empresa.dao.FuncionarioDAO;
import br.com.empresa.model.Funcionario;

public class ControlFuncionario {

	private static ControlFuncionario instance;

	public static ControlFuncionario getInstance() {

		if (instance == null)
			instance = new ControlFuncionario();

		return instance;
	}

	public String solicitarAdicionarFuncionario(Funcionario funcionario) {

		FuncionarioDAO.getInstance().adicionarFuncionario(funcionario);

		return "Adicionado com Sucesso";

	}

	public void solicitarSalvarCadastroArquivo(Funcionario funcionario) {

		FuncionarioDAO.getInstance().salvarCadastroArquivo(funcionario);

	}

	public String solicitarRecuperarCadastroArquivo() {

		return FuncionarioDAO.getInstance().recuperarCadastroArquivo().toString();

	}

	public String solicitarBuscarFuncionarioArquivo(String matricula) {

		return FuncionarioDAO.getInstance().buscarFuncionarioArquivo(matricula);

	}

	public Funcionario solicitarBuscarFuncionario(int cod) {

		return FuncionarioDAO.getInstance().buscarFuncionario(cod);

	}

	public Object solicitarListarFuncionario() {

		return FuncionarioDAO.getInstance().listarFuncionario();

	}

	public String solicitarRemoverFuncionario(int cod) {

		return FuncionarioDAO.getInstance().excluirFuncionario(cod);

	}

}
