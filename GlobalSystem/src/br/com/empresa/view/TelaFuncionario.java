
package br.com.empresa.view;

import java.util.Scanner;

import br.com.empresa.control.ControlFuncionario;
import br.com.empresa.dao.FuncionarioDAO;
import br.com.empresa.model.Endereco;
import br.com.empresa.model.EventosFolha;
import br.com.empresa.model.Funcionario;


public class TelaFuncionario {

	public static TelaFuncionario instance;

	public static TelaFuncionario getInstance() {

		if (instance == null)
			instance = new TelaFuncionario();

		return instance;
	}

	
	Endereco endereco = new Endereco();
	
	
	@SuppressWarnings("resource")
	public void DesenhaTelafuncionario() {

		boolean cond=true;
		int op=0;
		
		do {
		    
		    try {
		
			System.out.printf("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
			System.out.printf("          Tela Cadastro Funcionario       \n");
			System.out.printf("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

			System.out.println(""
					+ "[1] Adicionar Funcionario\n" 
					+ "[2] Listar Funcionarios\n"
					+ "[3] Editar Funcionario\n"
					+ "[4] Excluir Funcionario\n"
					+ "[0] Sair\n "

			);
			System.out.printf("Escolha opcao:");
			op = new Scanner(System.in).nextInt();
				
		    }
		    catch (Exception e) {
			
			System.out.println("apenas numeros");
				continue;
		    }

		    
			switch (op) {
			case 1:
				TelaFuncionario.getInstance().adicionarFuncionario();
				break;
			case 2: 
				TelaTestes.getInstance().exibeCadastroEmArquivo();
				break;
			case 3:
				TelaTestes.getInstance().editarFuncionarioArquivo();
				break;
			case 4:
				TelaTestes.getInstance().removerFuncionarioArquivo();
				break;
			case 5:
				break;
			case 6:  
				break;
			case 7: 
			break;
			case 8: 
			break;
			case 9: 
			break;
			case 0: cond=false; 
				break;
			default:
				break;

			}


		} while (cond==true);

	}// fim funcao

	
	@SuppressWarnings("resource")
	public void adicionarFuncionario() {
		boolean opcao=false;
		boolean valor=true;
		String cpf;
		String tipoFunc;
		String descricaoTipo ="";
		int tipo=0;
		
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("-=-=-= Preencha os dados abaixo -=-=-=\n");
			System.out.printf("Nome:");
			String nome = sc.nextLine();

			do {
			System.out.printf("CPF:");
			cpf = sc.nextLine();
	
			if (cpf.length()==11) {
							
				String parte1=cpf.substring(0,3);
				String parte2=cpf.substring(3,6);
				String parte3=cpf.substring(6,9);
				String parte4=cpf.substring(9,11);
				
			
				cpf = (parte1+"."+parte2+"."+parte3+"-"+parte4);
			
				valor =true;
				
			} else {
				System.out.println("cpf invalido");
				valor=false;
			}
			
			} while(valor == false);
			
			String matricula = cpf.substring(0,3) + "000" + FuncionarioDAO.getInstance().recuperarCadastroArquivo().size()+1; 
			
			
/*	*
*/		do {   //laco funcionario tipo
    
			tipo = 100;
			
			System.out.println("Tipo (F)uncionario | (D)iretor | (G)erente?: ");
			tipoFunc = sc.nextLine();
			
			if (tipoFunc.equalsIgnoreCase("D")) {
				tipo = 1;
				descricaoTipo="Diretoria";
				break;
				
			} 
			else if (tipoFunc.equalsIgnoreCase("F")) {
				tipo = 3;
				descricaoTipo="Funcionario";
				break;
			
			}else if (tipoFunc.equalsIgnoreCase("G")) {
				tipo = 2;
				descricaoTipo="Gerente";
				break;
			
			} else
			{
			    System.out.printf("Opcao incorreta");
			    opcao = false;
			}
			
		} while (opcao == true); 

		Funcionario funcionario = new Funcionario(nome ,matricula, cpf, tipo, descricaoTipo);
		
		

		ControlFuncionario.getInstance().solicitarSalvarCadastroArquivo(funcionario);

		System.out.println("inserido --> " + "Nome: " + funcionario.getNome() + " Matricula: " + matricula + "\tCPF: "+ funcionario.getCpf() + "\tTipo: " + funcionario.getTipo() + " " + funcionario.getDescricaoTipo());

	do {  // laco outr funcionario
	    	System.out.printf("Outro funcionario? (S) ou (N)");
	    	String escolha = sc.nextLine();
        	if (escolha.equalsIgnoreCase("n")) {
        		opcao=false;
        		break;
        	} else if (escolha.equalsIgnoreCase("s")) {
        	 	opcao = true;
        		break;
        	}
        		else {
        	  
        	    System.out.printf("opcao incorreta");
        	    continue;
        	}
        		
        	}while(opcao != false);

	
		}while (opcao == true);

	} // fim funcao
	
	
	

	
	
		
	

	
	@SuppressWarnings("resource")
	public void alterarFuncionario() {
		boolean cond = false;
		int opcao=100;
		Scanner escolhido = new Scanner(System.in);
		
		if (FuncionarioDAO.getInstance().meusFuncionarios.isEmpty()) {
			
			System.out.println("Nao ha funcionarios cadastrados");
			System.out.printf("Deseja cadastrar? (S)im ou (N)ao");
			String resp = escolhido.nextLine();
			
			if (resp.equalsIgnoreCase("s")) {
				TelaFuncionario.getInstance().adicionarFuncionario();
				
			} 
		
		} 
		else
			{
			
			do {	
			
				try {
				
				
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n"
							+  "-=-=-=-  TELA EDICAO FUNCIONARIO -=-=-=\n"
							+  "[1] Nome\n"
							+  "[2] CPF\n"
							+  "[3] Endereco\n"
							+  "[4] Salario\n"
							+  "[5] Tipo de funcionario\n"
							+  "[0] Sair\n" 
					
					);
			
			
			    System.out.printf("Qual campo deseja alterar?");
				opcao = new Scanner(System.in).nextInt();				
						
			    }
			    catch (Exception e) {
				
				System.out.println("apenas numeros");
				
			    }

						
				
				switch(opcao) {
				
				case 1:// alterarNome();
					break;
				case 2://alterarCpf();
					break;
				case 3: alterarEndereco();
					break;
				case 4: remuneraFuncionario();
					break;
				case 5://alterarTipoFuncionario();
					break;
				case 0: cond = true;
					break;
				default:
					break;
				
				}
			} while (cond != true);
		
			}	
		
	}
	
	@SuppressWarnings("resource")
	public void alterarEndereco() {
		
		Scanner sc = new Scanner(System.in);
		int numero=0;
		String cep=null;
		boolean valor = false;
		String uf="";
		
		
		
		
		System.out.println("-=-=-=-=-  Editar Endereco -=-=-=-=-=-=-\n");

	
	
		System.out.printf("\nDigite o codigo do funcionario para alteracaoao");
		int codigo = new Scanner(System.in).nextInt();
		
		
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
		

		Endereco endereco = new Endereco(rua, numero,cidade,bairro,cep,uf);
	
		FuncionarioDAO.getInstance().buscarFuncionario(codigo).setEndereco(endereco);
		
		Funcionario funcionario = FuncionarioDAO.getInstance().buscarFuncionario(codigo);
		
		ControlFuncionario.getInstance().solicitarSalvarCadastroArquivo(funcionario);
				
	}// final funcao
	

	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("resource")
	public void remuneraFuncionario() {
	boolean cond = false;
		
		
		if (FuncionarioDAO.getInstance().meusFuncionarios.isEmpty()) {
			
			System.out.println("Nao ha funcionarios cadastrados");
			System.out.printf("Deseja cadastrar? (S)im ou (N)ao");
			String resp = new Scanner(System.in).nextLine();
			
			if (resp.equalsIgnoreCase("s")) {
				TelaFuncionario.getInstance().adicionarFuncionario();
			} 
		} 
		else
		{
			
		//	listarFuncionario();
			
			do {
			
			System.out.printf("-=-=-=-=- TELA SALARIO -=-=-=-=-=-=-=  \n");
			System.out.printf("\n[1] - Vantagens");
			System.out.printf("\n[2] - Descontos");
			System.out.printf("\n[3] - Calcular Folha");
			System.out.printf("\n[0] - Sair");
			System.out.printf("\nO que deseja alterar:");
			int menuSalario = new Scanner(System.in).nextInt();
			
			
			if (menuSalario == 1) {
				telaVantagens();
					
			}
			if (menuSalario ==2 ) {
				telaDescontos();
			}
			
			if (menuSalario==3) {
				calcularFolha();
			}
			
			if (menuSalario == 0) {
				cond = true;
				break;
			}
			else {
				System.out.println("opcao incorreta");
				continue;
			}
				
			}while (cond == false);
			
		};
		
	} //final funcao
	
	
	@SuppressWarnings("resource")
	public void telaVantagens() {
		
		System.out.println("Digite o codigo do funcionario para alteracaoao");
		int codigo = new Scanner(System.in).nextInt();
		Scanner entrada = new Scanner(System.in);
		EventosFolha eventos = new EventosFolha();
		double salarioBase=0;
		double gratificacao=0;
		double capacitacao=0;
		double combustivel=0;
		boolean cond = false;
		
		do {
		
		System.out.printf("-=-=-=-=- TELA VANTAGENS -=-=-=-=-=-=-=  \n");
		System.out.printf("[1] - Salario base");
		System.out.printf("\n[2] - Gratificacao");
		System.out.printf("\n[3] - Plano capacitacao");
		System.out.printf("\n[4] - Combustivel");
		//System.out.printf("\n[5] - Participacao de lucros");
		System.out.printf("\n[0] - Sair");
		System.out.printf("\nO que deseja alterar:");
		int vantagens = new Scanner(System.in).nextInt();
		
		
		if (vantagens == 1) {
			System.out.println("Digite valor Salario-base: ");
			salarioBase = entrada.nextDouble(); 
			eventos.setSalarioBase(salarioBase);
		}
		
		if (vantagens == 2) {
			System.out.println("Digite valor Gratificacao: ");
			gratificacao = entrada.nextDouble(); 
			eventos.setGratificacao(gratificacao);
		}
		
		if (vantagens == 3) {
			System.out.println("Digite valor Capacitacao: ");
			capacitacao = entrada.nextDouble(); 
			eventos.setCapacitacao(capacitacao);
		}
		
		if (vantagens == 4) {
			System.out.println("Digite valor Combustivel: ");
			combustivel = entrada.nextDouble(); 
			eventos.setCombustivel(combustivel);
		}
		if (vantagens ==0) {
			cond = true;
			break;
		}
		
		}while(cond == false);
		
		
		FuncionarioDAO.getInstance().meusFuncionarios.get(codigo).setEventosFolha(eventos);	
		
	} //final funcao
	
	
	public void telaDescontos() {
		int descontos=0;
		double planoSaude=0;
		double adiantamento=0;
		Scanner entrada = new Scanner(System.in);
		boolean cond = false;
		
		EventosFolha eventos = new EventosFolha();
		System.out.println("Digite o codigo do funcionario para alteracaoao");
		int codigo = new Scanner(System.in).nextInt();
		
		do {
		System.out.printf("-=-=-=-=- TELA DESCONTOS -=-=-=-=-=-=-=  \n");
		System.out.printf("  [1] - Plano de saude");
		System.out.printf("\n[2] - Adiantamento");
		System.out.printf("\n[3] - ");
		System.out.printf("\n[4] - ");
		System.out.printf("\n[5] - ");
		System.out.printf("\n[0] - Sair");
		System.out.printf("\nO que deseja alterar:");
		descontos = new Scanner(System.in).nextInt();
		
		
		if (descontos == 1) {
			System.out.println("Digite valor Plano de Saude: ");
			planoSaude = entrada.nextDouble(); 
			eventos.setPlanoSaude(planoSaude);
		}
		
		if (descontos == 2) {
			System.out.println("Digite valor adiantamento: ");
			adiantamento = entrada.nextDouble(); 
			eventos.setAdiantamento(adiantamento);
		}
		if (descontos ==0) {
			cond = true;
			break;
		}
			
		}while(cond == false);
		
		FuncionarioDAO.getInstance().meusFuncionarios.get(codigo).setEventosFolha(eventos);	
		
	}// final funcao
	
	
	public void calcularFolha() {
		
		System.out.println("-=-=-= FOLHA PAGAMENTO -=-=-=-=-");

		for (int i=0; i < FuncionarioDAO.getInstance().meusFuncionarios.size();i++) {
			
	
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}// fim classe
