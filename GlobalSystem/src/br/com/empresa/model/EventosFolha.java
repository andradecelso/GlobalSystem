package br.com.empresa.model;

public class EventosFolha {

	private double salarioBase;
	private double gratificacao;
	private double planoSaude;
	private double adiantamento;
	private double combustivel;
	private double capacitacao;
	private double inss;
	private double fgts;
	private double impostoRenda;
	
	public EventosFolha() {
		
	}
	
	
	public EventosFolha(double salarioBase) {
		
		this.salarioBase = salarioBase;
		}
	
	
	
	
	
	public EventosFolha(double salarioBase, double gratificacao, double planoSaude, double adiantamento,
			double combustivel, double capacitacao, double inss, double fgts, double impostoRenda) {
	
		this.salarioBase = salarioBase;
		this.gratificacao = gratificacao;
		this.planoSaude = planoSaude;
		this.adiantamento = adiantamento;
		this.combustivel = combustivel;
		this.capacitacao = capacitacao;
		this.inss = inss;
		this.fgts = fgts;
		this.impostoRenda = impostoRenda;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getGratificacao() {
		return gratificacao;
	}

	public void setGratificacao(double gratificacao) {
		this.gratificacao = gratificacao;
	}

	public double getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(double planoSaude) {
		this.planoSaude = planoSaude;
	}

	public double getAdiantamento() {
		return adiantamento;
	}

	public void setAdiantamento(double adiantamento) {
		this.adiantamento = adiantamento;
	}

	public double getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(double combustivel) {
		this.combustivel = combustivel;
	}

	public double getCapacitacao() {
		return capacitacao;
	}

	public void setCapacitacao(double capacitacao) {
		this.capacitacao = capacitacao;
	}

	public double getInss() {
		return inss;
	}

	public void setInss(double salarioBase) {
		
		
		if (salarioBase <= 1693.72) {   // 8%
			
			this.inss = salarioBase * 8 /100;
		}
		if (salarioBase > 1693.73 && salarioBase < 2822) {  // 9%
			
			this.inss = salarioBase * 9 /100;
		}
		
		if (salarioBase > 2822 && salarioBase < 5645) {  // 11%
			
			this.inss = salarioBase * 11 /100;
		}
			
	
	}

	public double getFgts() {
		return fgts;
	}

	public void setFgts(double salarioBase) {
		this.fgts = salarioBase * 7 / 100;
	}

	public double getImpostoRenda() {
		return impostoRenda;
	}

	public void setImpostoRenda(double salarioBase,double inss) {
	
		double baseCalculoIr=0;
		baseCalculoIr = salarioBase - inss;
		
		
		if (baseCalculoIr >= 1903.99 && baseCalculoIr <= 2826.65) {
						
			this.impostoRenda = (baseCalculoIr  * 7.5 /100) - 142.80; 
		}
		if (baseCalculoIr >= 2826.66 && baseCalculoIr <= 3751.05) {
			
			this.impostoRenda = (baseCalculoIr  * 15 /100) - 354.80; 
		}
		if (baseCalculoIr >= 3751.06 && baseCalculoIr <= 4664.68) {
			
			this.impostoRenda = (baseCalculoIr  * 22.55 /100) - 636.13; 
		}
		if (baseCalculoIr > 4664.68) {
			
			this.impostoRenda = (baseCalculoIr * 27.5 /100 ) - 869.36;
		}

/*
Base de cálculo mensal, em R$	alíquota	parcela a deduzir do IR, em R$
De 1.903,99 até 2.826,65	7,5%	142,80
De 2.826,66 até 3.751,05	15%	354,80
De 3.751,06 até 4.664,68	22,5%	636,13
Acima de 4.664,68	27,5%	869,36
*/
		
	
	
	}


	@Override
	public String toString() {
		return "\nVantagens:-->" + ",\tsalarioBase= " + salarioBase + ",\t gratificacao= " + gratificacao + ",\t combustivel= " + combustivel 
				+ ",\t capacitacao= " + capacitacao 
				+ "Descontos:--> " 
				+ ",\t planoSaude= " + planoSaude + ",\t adiantamento= " + adiantamento +   ",\t inss= " + inss + ",\t impostoRenda=" + impostoRenda 
				;
	}
		
	
	
	
	
	
}

