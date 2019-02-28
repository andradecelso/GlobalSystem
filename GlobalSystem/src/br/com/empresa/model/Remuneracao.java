package br.com.empresa.model;

public class Remuneracao {

	private double salario;
	private	double descontos;
	private double vantagens;
	
	private EventosFolha eventosFolha = new EventosFolha();
	
	
	public Remuneracao() {
		
	}

	
	public void getDescontos() {
		
		this.descontos = eventosFolha.getAdiantamento() + eventosFolha.getImpostoRenda()+eventosFolha.getPlanoSaude() + eventosFolha.getInss();
		
	}
	
	
	public void setVantagens(double combustivel,double gratificacao,double capacitacao) {
		
	this.vantagens = combustivel + gratificacao + capacitacao;
				
	}
	
	
	
	public double getVantagens() {
		
		return this.vantagens;
		
	}
	
	
	public Remuneracao(double salario, double descontos) {
	
		this.salario = salario;
		this.descontos = descontos;
			
	}

	@Override
	public String toString() {
		return "Remuneracao [salario=" + salario + ", descontos=" + descontos + "]";
	}
	
	
	
	
	
}
