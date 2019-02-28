package br.com.empresa.model;

public class Funcionario {

	private String matricula;
	private String nome;
	private String cpf;
	private int tipo;
	private String descricaoTipo;
	private Endereco end ;
	private Remuneracao remuneracao;
	private EventosFolha eventosFolha;
	
	
	
	
	public Funcionario() {
		

			
	}
	
	
	
	
	public Funcionario(String nome,String matricula, String cpf,int tipo, String descricaoTipo) {
		
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
		this.descricaoTipo = descricaoTipo;
		
				
	}


public Funcionario(String nome,String matricula, String cpf,int tipo, String descricaoTipo, Endereco end) {
		
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
		this.descricaoTipo = descricaoTipo;
		this.end = end;
		
				
	}
		
		
		
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	



	public int getTipo() {
		
		return this.tipo;
	}
	

	public void setTipo(int tipo) {
		
		this.tipo = tipo;
		
	}
	
public String getDescricaoTipo() {
		
		return this.descricaoTipo;
	}
	

	public void setDescricaoTipo(String descricaoTipo) {
		
		this.descricaoTipo = descricaoTipo;
		
	}

	
	
	
	
	
	public void setEndereco(Endereco endereco) {
		
		this.end = endereco;
		
		
	}
	
	public Endereco getEndereco() {
		
		return this.end;
		
		
	}
	
	
	public void setRemuneracao(Remuneracao remuneracao) {
		
		this.remuneracao=remuneracao;
			
		}
	
	public Remuneracao getRemuneracao() {
		
		return this.remuneracao;
	}
	

	public void setEventosFolha(EventosFolha eventosFolha) {
		
		
		this.eventosFolha = eventosFolha;
	}
	
	
	public EventosFolha getEventosFolha() {
		
		return this.eventosFolha;
		
	}
	
	
	
	
/*	@Override
	public String toString() {
		return "nome: " + nome 
				+ ",\t matricula: " + matricula
				+ ",\t cpf: " + cpf 
				+ ",\tTipo: "  + getTipo() 
				+ ",\t " + getDescricaoTipo()
				+ ",\t Remuneracao: " + getEventosFolha()
				+ ",\t Endereco: " + getEndereco();
	}
*/	
	
	
	@Override
	public String toString() {
		return  "" + nome 
				+ "," + matricula
				+ "," + cpf 
				+ ","  + getTipo() 
				+ "," + getDescricaoTipo();
				//+ "," + getEndereco();
	}
	
		
}
