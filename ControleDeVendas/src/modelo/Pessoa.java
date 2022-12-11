package modelo;

/**
 * Superclasse abstrata Pessoa simula o comportamento de uma Pessoa.
 * @author Arthur Rodrigues Sousa
 *
 */
public abstract class Pessoa {
	protected String nome;
	protected int cpf; 
	protected String endereco;
	protected int telefone;
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	
	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public int getTelefone() {
		return telefone;
	}


	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

}