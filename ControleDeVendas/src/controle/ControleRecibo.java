package controle;

import modelo.*;

/**
 * Classe ControleRecibo faz o gerenciamento dos dados da classe Recibo.
 * @author Arthur Rodrigues Sousa
 *
 */
public class ControleRecibo {
	private Recibo[] rec;
	private int qtdRecibos;

	/**
	 * Construtor da classe que recebe os dados (@param d) dos recibos criados.
	 * @param d - Classe que pega os recibos dos clientes.
	 * @param cliIndex - index do cliente portador dos recibos.
	 */
	public ControleRecibo(ControleDados d, int cliIndex) {
		this.rec = d.getRecibo(cliIndex);
		this.qtdRecibos = d.getQtdRecibos(cliIndex);
	}

	/**
	 * retorna o codigo dos Recibos de dado Cliente.
	 * @return String[]
	 */
	public String[] getCodigoRec() {
		String[] s = new String[qtdRecibos];
		for(int i = 0; i < qtdRecibos; i++) {
			s[i] = String.valueOf(rec[i].getCodigo());
		}
		return s;
	}
	
	
	public int getQtd() {
		return qtdRecibos;
	}

	public void setQtd(int qtd) {
		this.qtdRecibos = qtd;
	}

	
	public String getCodigo(int i) {		
		return String.valueOf(rec[i].getCodigo());
	}

	public Cliente getComprador(int i) {
		return rec[i].getComprador();
	}

	public String getData(int i) {
		return String.valueOf(rec[i].getData());
	}

	public double getValor(int i) {
		return rec[i].getValor_total();
	}
	
	public Produto[] getProdutos (int i) {
		return rec[i].getProdutos();
	}
	
	public int[] getQtds (int i) {
		return rec[i].getQtd();
	}

}
