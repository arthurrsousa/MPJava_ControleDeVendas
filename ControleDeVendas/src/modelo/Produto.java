package modelo;

/**
 * Classe Produto simula o comportamento de um Produto.
 * @author Arthur Rodrigues Sousa
 *
 */
public class Produto {
	private String nome;
	private String marca;
	private String categoria;
	private double valor;
	private String descricao;
	
	
	/**
	 * Construtor do Produto com as informacoes a serem apresentadas ao usuario.
	 */
	public Produto(String nom, String mar, String cat, double valor, String des) {
		this.nome = nom;
		this.marca = mar;
		this.categoria = cat;
		this.valor = valor;
		this.descricao = des;
	}
	
	
	public String toString() {	
		return "Nome do produto: " + nome +
				"\n" + descricao +
				 "\n Valor: R$" + valor + "\n";
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getMarca() {
		return marca;
	}
	
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	public String getCategoria() {
		return categoria;
	}
	
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public double getValor() {
		return valor;
	}
	
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
