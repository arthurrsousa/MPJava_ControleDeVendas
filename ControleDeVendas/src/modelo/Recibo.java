package modelo;

import java.util.Date;

/**
 * Classe Recibo simula o comportamento de um recibo e 
 * possui um Cliente associado, assim como um array de Produtos.
 * @author Arthur Rodrigues Sousa
 *
 */
public class Recibo {
	private int codigo;
	private Cliente comprador;
	private Date data;
	private double valor_total;
	private int[] qtd;
	private Produto[] produtos; 
	
	/**
	 * Construtor do Recibo, onde recebe o Cliente, o array de Produtos e
	 * outras informacoes a serem apresentadas ao usuario.
	 */
	public Recibo(int cod, Cliente cli, Date dt, double vt, int[] qtd, Produto[] prods) {
		this.codigo = cod;
		this.comprador = cli;
		this.data = dt;
		this.valor_total = vt;
		this.qtd = qtd;
		this.produtos = prods;
	}
	
	
	public String toString() {	
		return "Codigo da nota: " + codigo + "\n"+
				"Consumidor(a) incrito(a) no cpf sob o numero: " + comprador.getCpf() + "\n"+
				"Emitida em: " + data + "\n" +
				"Total pago: " + valor_total;
	}
	
	public String getCodigo() {
		return String.valueOf(codigo);
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Cliente getComprador() {
		return comprador;
	}
	
	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}
	
	
	public String getData() {
		return String.valueOf(data);
	}
	
	
	public void setData(Date data) {
		this.data = data;
	}
	
	
	public double getValor_total() {
		return valor_total;
	}
	
	
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	
	public int[] getQtd() {
		return qtd;
	}

	
	public void setQtd(int[] qtd) {
		this.qtd = qtd;
	}
	

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}

	
	
}
