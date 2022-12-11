package modelo;

/**
 * Classe Vendedor simula o comportamento de um vendedor e herda da classe Pessoa .
 * @author Arthur Rodrigues Sousa
 *
 */
public class Vendedor extends Pessoa {
	private double saldo;
	private int qtd_vendas;
	
	/**
	 * Construtor da classe Vendedor onde recebe seus atributos proprios (saldo, qtd_vendas) 
	 * e o da classe pai Pessoa (nome, endereco etc)
	 */
	public Vendedor(String n, String e, int CPF, int tel, double saldo, int qtdVendas) {
		this.nome = n;
		this.endereco = e;
		this.cpf = CPF;
		this.telefone = tel;
		this.saldo = saldo;
		this.qtd_vendas = qtdVendas;
	}
	
	
	public String toString() {	
		return "Nome do vendedor: " + nome +
				"/n Saldo atual: " + saldo;
	}
	
	
	public double getSaldo() {
		return saldo;
	}
	
	
	public void setSaldo(double d) {
		this.saldo = d;
	}
	
	
	public int getQtd_vendas() {
		return qtd_vendas;
	}
	
	
	public void setQtd_vendas(int qtd_vendas) {
		this.qtd_vendas = qtd_vendas;
	}
	
	
}
