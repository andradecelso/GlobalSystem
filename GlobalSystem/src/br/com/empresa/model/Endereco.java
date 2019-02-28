
package br.com.empresa.model;



public class Endereco {

	String rua="";
	String cep="";
	int numero=0;
	String cidade="";
	String bairro="";
	String uf="";
	String meusEstados[] = {"PE","PB","AL","CE","BA","PI","SE","MA","RN","SP","RJ","GO","DF","ES","RS","MG","MS","MT","AM","PA","PR","RR","AC","AP","RO","TO","SC"}; 
	
	
	
	
	
	public Endereco(String rua, int numero, String cidade, String bairro, String cep,String uf) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.uf = uf;
		
	}

public Endereco(){
		
		
	}
	
	
	public String[] getEstado() {
		
				
		return this.meusEstados;
	}
	
	
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

/*
	@Override
	public String toString() {
		return "rua: " + rua + ", cep: " + cep + ", numero: " + numero +  ", bairro: "
				+ bairro + ", cidade: " + cidade + ", UF: " + uf;
	}
*/	
	
	@Override
	public String toString() {
		return "" + rua + "," + numero + "," + bairro +  ","
				+ cep + "," + cidade + "," + uf;
	}
	
	
	
}
