package modelo;

/**
 * Classe Cliente simula o comportamento de um cliente e herda da classe Pessoa .
 * @author Arthur Rodrigues Sousa
 *
 */
public class Cliente extends Pessoa{
	private double total_pago;
	private int compras_realizadas;
	private Recibo[] recibos = new Recibo[20];
	private int qtdRecibos = 0;
	
	
	/**
	 * Construtor da classe Cliente onde recebe seus atributos proprios (total_pago, compras_realizadas etc) 
	 * e o da classe pai Pessoa (nome, endereco etc)
	 */
	public Cliente(String n, String e, int CPF, int tel, double totalPago, int totalCompras) {
		this.nome = n;
		this.endereco = e;
		this.cpf = CPF;
		this.telefone = tel;
		this.total_pago = totalPago;
		this.compras_realizadas = totalCompras;
	}

	
	public String toString() {	
		return "Nome do cliente: " + nome +
				"/n Já realizou " + compras_realizadas + " compra(s)"
				+ "/n e pagou R$" + total_pago;
	}
	
	/**
	 * Altera o array de Recibos do Cliente adicionando um novo Recibo (@param rec). 
	 * Caso o index do array (@param pos) seja igual a quantidade de Recibos
	 * entao a quantidade de recibos do Cliente aumentara.
	 */
	public void comprar(Recibo rec, int pos) {
		this.recibos[pos] = rec;
		if(pos == qtdRecibos) qtdRecibos++;
	}
	
	
	public double getTotal_pago() {
		return total_pago;
	}


	public void setTotal_pago(double d) {
		this.total_pago = d;
	}


	public int getCompras_realizadas() {
		return compras_realizadas;
	}


	public void setCompras_realizadas(int compras_realizadas) {
		this.compras_realizadas = compras_realizadas;
	}


	public Recibo[] getRecibo() {
		return recibos;
	}


	public void setRecibos(Recibo[] recibos) {
		this.recibos = recibos;
	}


	public int getQtdRecibos() {
		return qtdRecibos;
	}


	public void setQtdRecibos(int qtdRecibos) {
		this.qtdRecibos = qtdRecibos;
	}
	
}
