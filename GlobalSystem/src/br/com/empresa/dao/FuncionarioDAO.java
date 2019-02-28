package br.com.empresa.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.com.empresa.model.Funcionario;
 


public class FuncionarioDAO {

	public ArrayList<Funcionario> meusFuncionarios = new ArrayList<>();

	
	public static FuncionarioDAO instance;

	public static FuncionarioDAO getInstance() {

		if (instance == null)
			instance = new FuncionarioDAO();

		return instance;

	}

	public void salvarCadastroArquivo(Funcionario funcionario) {
		
		String path = "";
		 String so = String.valueOf( System.getProperty("os.name") );
		 String home = String.valueOf( System.getProperty("user.home") );
		 
		 
		 if (so.equalsIgnoreCase("Linux")) {
			
			path = home+"/cadastro.txt"; //"/home/celso/cadastro.txt";
	
		 }else if (so.contains("Windows")) {
			 
			path = "c:\\temp\\cadastro.txt";
		 }
			
			 		 
		 
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
			
			bw.write(funcionario.toString());
			bw.newLine();
			
		} catch(IOException e) {
			e.printStackTrace();
			
		}
		
	} //final funcao
	
	
	public ArrayList<String> recuperarCadastroArquivo() {
		
		String path = "";
		 String so = String.valueOf( System.getProperty("os.name") );
		 String home = String.valueOf( System.getProperty("user.home") );
		 String line="";	
		 ArrayList<String> meuCadastro = new ArrayList<>();
		 
		 if (so.equalsIgnoreCase("Linux")) {
			
			path = home+"/cadastro.txt"; //"/home/celso/cadastro.txt";
	
		 }else if (so.contains("Windows")) {
			 
			path = "c:\\temp\\cadastro.txt";
		 }
			
			
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
						
			while (br.ready()) {
			line = br.readLine();
			meuCadastro.add(line);
			
			//System.out.println(line);
			
			
			}
		br.close();
		}
		 catch(IOException e) {
			e.printStackTrace();
			
		}
		
		return meuCadastro;
		
	} //final funcao
	
	
	public String buscarFuncionarioArquivo(String matricula) {
			
		String ocorrencia="";
		String path = "";
		 String so = String.valueOf( System.getProperty("os.name") );
		 String home = String.valueOf( System.getProperty("user.home") );
		 String line="";	
		 String[] busca = null;
				 
		 if (so.equalsIgnoreCase("Linux")) {
			path = home+"/cadastro.txt"; //"/home/celso/cadastro.txt";
	
		 }else if (so.contains("Windows")) {
			path = "c:\\temp\\cadastro.txt";
		 }
			try (BufferedReader br = new BufferedReader(new FileReader(path))){
							
				while (br.ready()) {
				line = br.readLine();
				
				busca = line.split(",");
				
				if (busca[1].contains(matricula))
				{
					ocorrencia = line;
				
					break;
				} else ocorrencia="nao encontrado";
					
				}
						br.close();	
			}
			 catch(IOException e) {
				e.printStackTrace();
				
			}
			
			return ocorrencia;
			
		} //final funcao
	
	
	
	public String editarFuncionarioArquivo(String matricula) {
		
		String ocorrencia="";
		String path = "";
		 String so = String.valueOf( System.getProperty("os.name") );
		 String home = String.valueOf( System.getProperty("user.home") );
		 String line="";	
		 String[] busca = null;
			 
		 
		 
		 if (so.equalsIgnoreCase("Linux")) {
			path = home+"/cadastro.txt"; //"/home/celso/cadastro.txt";
	
		 }else if (so.contains("Windows")) {
			path = "c:\\temp\\cadastro.txt";
		 }
			try (BufferedReader br = new BufferedReader(new FileReader(path))){
							
				while (br.ready()) {
				line = br.readLine();
				
				busca = line.split(",");
				
				if (busca[1].contains(matricula))
				{
					ocorrencia = line;
					
					break;
				} else ocorrencia="nao encontrado";
					
				}
						br.close();	
			}
			 catch(IOException e) {
				e.printStackTrace();
				
			}
			
			
			
			return ocorrencia;
			
		} //final funcao
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String removerFuncionarioArquivo(String matricula) {
		
		String ocorrencia="";
		String path = "";
		String pathNew = "";
		 String so = String.valueOf( System.getProperty("os.name") );
		 String home = String.valueOf( System.getProperty("user.home") );
		 String line="";	
		 String[] busca = null;
	
		boolean achou=false; 
		
		
		 if (so.equalsIgnoreCase("Linux")) {
			path = home+"/cadastro.txt"; //"/home/celso/cadastro.txt";
			pathNew = home+"/cadastro1.txt";
		 }else if (so.contains("Windows")) {
			path = "c:\\temp\\cadastro.txt";
			pathNew = "c:\\temp\\cadastro1.txt";
		 }
	
		 
			try (BufferedReader br = new BufferedReader(new FileReader(path))){
							
				while (br.ready()) {
				line = br.readLine();
				
				busca = line.split(",");
				
				if (busca[1].contains(matricula))
				{
					
					achou = true;
					ocorrencia = line;
					break;
					
					
					
					
				} else {
					ocorrencia="nao encontrado";
					achou = false;
				}
					
				}
				br.close();
			}
			 catch(IOException e) {
				e.printStackTrace();
				
			}
			// aqui fica remocao da linha
				if (achou == true) {
										
					try (BufferedReader br = new BufferedReader(new FileReader(path))){
						
						while (br.ready()) {
						line = br.readLine();
						
									if (!line.contains(ocorrencia)) {
										
										try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathNew,true))){
											
											bw.write(line.toString());
											bw.newLine();
											
										} catch(IOException e) {
											e.printStackTrace();
											
										}
							
							}
							
									
						}
						br.close();
						
				} catch (IOException e1) {
						e1.printStackTrace();
				
					}
				}
				
				File arquivo = new File(path);
				arquivo.delete();
				
				File caminho = new File("c:\\temp\\cadastro.txt");
				File arquivo1 = new File(pathNew);
				arquivo1.renameTo(caminho);				
				
				
			return ocorrencia;		
				
			}//final funcao
			
			
			
	
	
	public void adicionarFuncionario(Funcionario funcionario) {

		meusFuncionarios.add(funcionario);
	}

	
	
	public Funcionario buscarFuncionario(int cod) {

		return (Funcionario)meusFuncionarios.get(cod);

	}

	
	
	
	public Object listarFuncionario() {
				
		return meusFuncionarios;
			}
	
	
	
	public String excluirFuncionario(int cod) {

		meusFuncionarios.remove(cod);

		return "Removido com Sucesso";

	}
}
	
	
	
	

