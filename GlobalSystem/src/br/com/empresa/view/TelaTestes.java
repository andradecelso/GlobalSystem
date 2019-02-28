package br.com.empresa.view;

import java.util.Scanner;

import br.com.empresa.control.ControlFuncionario;
import br.com.empresa.dao.FuncionarioDAO;
import br.com.empresa.model.Endereco;
import br.com.empresa.model.Funcionario;

public class TelaTestes {

	public static TelaTestes instance;

	public static TelaTestes getInstance() {

		if (instance == null)
			instance = new TelaTestes();

		return instance;
	}

	public void exibeCadastroEmArquivo() {
		String showLine="";
		String linha = "";

		if (FuncionarioDAO.getInstance().recuperarCadastroArquivo().isEmpty()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nao ha funcionarios cadastrados");

			System.out.printf("Deseja cadastrar? (S)im ou (N)ao");
			String resp = sc.nextLine();

			if (resp.equalsIgnoreCase("s")) {
				TelaFuncionario.getInstance().adicionarFuncionario();

			}

		} else {

			
			System.out.printf("Nome		matricula		cpf			tipo 	desc		endereco\n");
			for (int i = 0; i < FuncionarioDAO.getInstance().recuperarCadastroArquivo().size(); i++) {

				String[] linhaFunc = FuncionarioDAO.getInstance().recuperarCadastroArquivo().get(i).split(",");

					showLine = linhaFunc[0] +"\t\t\t"+ linhaFunc[1] +"\t"+ linhaFunc[2] +"\t"+ linhaFunc[3] +"\t"+ linhaFunc[4];
							
					
					
					 if (linhaFunc.length > 5){
					
						showLine += "\t" + linhaFunc[5] +","+ linhaFunc[6] + linhaFunc[7] + linhaFunc[8] + linhaFunc[9] + linhaFunc[10];
						
					}
					
					System.out.println(showLine);
					
				}
				
				
			}
			
		
			

		
	} // final funcao

	public void editarFuncionarioArquivo() {

		String editarFunc;
		String matriculaBusca;
		boolean cond = false;
		boolean valor = false;
		String nome, nomeTemp = "", tipoDesc = "", tipoDescTemp = "", tipoFuncTemp = "";
		String matricula;
		String cpf, cpfTemp;
		String[] funcTemp = null;
		int opcao, tipo, tipoTemp = 0;

		exibeCadastroEmArquivo();
		System.out.println("\n");

		System.out.printf("insira matricula que deseja editar: ");
		matriculaBusca = new Scanner(System.in).nextLine();

		if (!ControlFuncionario.getInstance().solicitarBuscarFuncionarioArquivo(matriculaBusca).isEmpty()) {

			editarFunc = ControlFuncionario.getInstance().solicitarBuscarFuncionarioArquivo(matriculaBusca);
			funcTemp = editarFunc.split(",");

		} else
			System.out.println("Ocorrência não encontrada");
		for (int i = 0; i > funcTemp.length; i++) {
			System.out.println(i);
		}

		nome = funcTemp[0];
		matricula = funcTemp[1];
		cpf = funcTemp[2];
		tipo = Integer.parseInt(funcTemp[3]);
		tipoDesc = funcTemp[4];

		do {

			System.out.println("-=-=-=-  EDITAR FUNCIONARIO ARQUIVO -=-=-=-=-=-\n");
			System.out.printf("[1] - Nome \n" + "[2] - cpf\n" + "[3] - Tipo\n" +"[4] - Endereco\n" + "[0] - sair\n" + "");

			System.out.printf("Qual opcao deseja: ");
			opcao = new Scanner(System.in).nextInt();

			if (opcao == 1) {    //nome

				System.out.println("Digite novo nome:");
				nomeTemp = new Scanner(System.in).nextLine();

				Funcionario funcionario = new Funcionario(matricula, nomeTemp, cpf, tipo, tipoDesc);
				FuncionarioDAO.getInstance().salvarCadastroArquivo(funcionario);
				FuncionarioDAO.getInstance().removerFuncionarioArquivo(matriculaBusca);

			}

			if (opcao == 2) {     //cpf
				do {
					System.out.println("Digite novo cpf:");
					cpfTemp = new Scanner(System.in).nextLine();

					if (cpfTemp.length() == 11) {

						String parte1 = cpfTemp.substring(0, 3);
						String parte2 = cpfTemp.substring(3, 6);
						String parte3 = cpfTemp.substring(6, 9);
						String parte4 = cpfTemp.substring(9, 11);

						cpfTemp = (parte1 + "." + parte2 + "." + parte3 + "-" + parte4);

						valor = true;

					} else {
						System.out.println("cpf invalido");
						valor = false;
					}

				} while (valor == false);

				Funcionario funcionario = new Funcionario(matricula, nome, cpfTemp, tipo, tipoDesc);
				FuncionarioDAO.getInstance().salvarCadastroArquivo(funcionario);
				FuncionarioDAO.getInstance().removerFuncionarioArquivo(matriculaBusca);

			}

			if (opcao == 3) {    //tipo

				System.out.println("Digite novo Tipo |(F)uncionario | (D)iretor | (G)erente| ");
				tipoFuncTemp = new Scanner(System.in).nextLine();

				if (tipoFuncTemp.equalsIgnoreCase("F")) {

					tipoTemp = 3;
					tipoDescTemp = "Funcionario";

				}

				if (tipoFuncTemp.equalsIgnoreCase("D")) {

					tipoTemp = 1;
					tipoDescTemp = "Diretoria";

				}

				if (tipoFuncTemp.equalsIgnoreCase("G")) {

					tipoTemp = 2;
					tipoDescTemp = "Gerente";

				}

				Funcionario funcionario = new Funcionario(matricula, nome, cpf, tipoTemp, tipoDescTemp);
				FuncionarioDAO.getInstance().salvarCadastroArquivo(funcionario);
				FuncionarioDAO.getInstance().removerFuncionarioArquivo(matriculaBusca);

			}
			
			
			if (opcao ==4) {
				
				alterarEndereco();
				
			}
			

			if (opcao == 0) {
				cond = true;
			}

		} while (cond == false);

		//

	}// final funcao

	public void buscarFuncionarioArquivoMatricula() {
		String mat = "";

		exibeCadastroEmArquivo();
		System.out.println("\n");

		System.out.printf("insira matricula que deseja exibir: ");
		mat = new Scanner(System.in).nextLine();

		System.out.println(FuncionarioDAO.getInstance().buscarFuncionarioArquivo(mat));

	} // final funcao

	public void detectarSistemaOperacional() {

		String so = String.valueOf(System.getProperty("os.name"));
		String user = String.valueOf(System.getProperty("user.home"));

		System.out.println(so + user);

	}

	public void removerFuncionarioArquivo() {

		exibeCadastroEmArquivo();

		System.out.printf("insira matricula que deseja excluir: ");
		String matricula = new Scanner(System.in).nextLine();

		System.out.println(FuncionarioDAO.getInstance().removerFuncionarioArquivo(matricula));

	} // final funcao

	@SuppressWarnings("resource")
	public void alterarEndereco() {
		
		Scanner sc = new Scanner(System.in);
		int numero=0;
		String cep=null;
		boolean valor = false;
		String uf="";
		String[] funcTemp = null;
		Endereco endereco = new Endereco();
		
		
		
		System.out.println("-=-=-=-=-  Editar Endereco -=-=-=-=-=-=-\n");

		exibeCadastroEmArquivo();
	
		System.out.printf("\nDigite matricula do funcionario para alteracaoao");
		String matriculaBusca = new Scanner(System.in).nextLine();
		
		
		System.out.println("Preencha os campos a seguir:");
		System.out.printf("Rua: ");
		String rua = sc.nextLine();
		
		do {
			
			try {
				System.out.printf("Numero: ");
				numero = new Scanner(System.in).nextInt();
				break;
				
			}catch (Exception e) {

				System.err.print("valor invalido");
					
			}
			
			} while (true); 
		

		System.out.printf("Cidade: ");
		String cidade = sc.nextLine();
		
		System.out.printf("Bairro: ");
		String bairro = sc.nextLine();
		
		
do {
			System.out.printf("CEP:");
			cep = new Scanner(System.in).nextLine();
			
			
			if (cep.length()==8) {
							
				String parte1=cep.substring(0,2);
				String parte2=cep.substring(2,5);
				String parte3=cep.substring(5,8);
			
				cep = (parte1 + "." + parte2 + "-" + parte3);
						
				valor =true;
				
			} else {
				System.out.println("cep invalido");
				valor=false;
			}
		}while (valor == false);
			

		String estados[] = endereco.getEstado();


		do {
				System.out.printf("UF: ");
				uf = new Scanner(System.in).nextLine();		
			
				for (int i=0;i < estados.length ; i++) {
					
					if (!uf.equalsIgnoreCase(estados[i])) {
						valor = false;
					}else
					{	
						valor = true;
						break;
					}
				}
				
				if (valor == false)
					System.out.printf("Valor incorreto");
							
		}while (valor == false);
		
		
		String funcionarioTemp = ControlFuncionario.getInstance().solicitarBuscarFuncionarioArquivo(matriculaBusca);
	
		Endereco enderecoNovo = new Endereco(rua, numero,cidade,bairro,cep,uf);
	
			
		funcTemp = funcionarioTemp.split(",");
	
		String nomeTemp = funcTemp[0];
		String matriculaTemp = funcTemp[1];
		String cpfTemp = funcTemp[2];
		int tipoTemp = Integer.parseInt(funcTemp[3]);
		String tipoDescTemp = funcTemp[4];
		
		Funcionario funcionario = new Funcionario(nomeTemp,matriculaTemp,cpfTemp,tipoTemp,tipoDescTemp,enderecoNovo);
		
		FuncionarioDAO.getInstance().salvarCadastroArquivo(funcionario);
	FuncionarioDAO.getInstance().removerFuncionarioArquivo(matriculaBusca);		
				
		
		
	}// final funcao

}
