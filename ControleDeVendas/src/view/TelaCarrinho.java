package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.*;
import modelo.*;

/**
 * Tela que simula um carrinho de compras virtual.
 * @author Arthur Rodrigues Sousa
 *
 */
public class TelaCarrinho implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;

	private JButton TESTE = new JButton("T");
	
	private JLabel[] carrinho = new JLabel[10]; 
	private JButton botaoProdutos = new JButton("Selecionar Produto");
	private JButton botaoFinalizar = new JButton("Finalizar Compra");

	private Produto[] listaCarrinhoProd = new Produto[10];
	private int qtdCarrinhoProd;
	private int[] listaCarrinhoQtd = new int[10];
	private Produto prodSelec;
	
	private JFrame frameProdutos;
	private JList<String> listaProdsCadastrados;
	private JLabel labelQtdItem = new JLabel("Quantidade: ");
	private JTextField qtdItem = new JTextField(String.valueOf(1), 200);
	private JButton botaoAdicionar = new JButton("Adicionar");
	private String[] listaNomes = new String[50];
	private JButton[] botaoRemover = new JButton[10];
	
	private ControleDados dados;
	private int posicao;
	
	public void mostrarCarrinho(ControleDados d, int pos) {
		dados = d;
		posicao = pos;
		//dadosCart = dCart; 
		janela = new JFrame("Carrinho");
		carrinho = new JLabel[10]; 
		
		titulo = new JLabel("Realize as Compras Aqui");
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(70, 10, 250, 30);
		
		//Mostra os produtos no carrinho
		if (listaCarrinhoProd != null) {
			//System.out.println("Primeiro Item  " + carrinhoProd[0]);
			int i = 0;
			while (i < 10) {
				//System.out.println("OK while i");
				if (listaCarrinhoProd[i] != null) {
					
					carrinho[i] = new JLabel(listaCarrinhoQtd[i] + "x    " + listaCarrinhoProd[i].getNome());
					botaoRemover[i] = new JButton("X");
					carrinho[i].setBounds(35, (90+20*(i+1)), 180, 25);
					carrinho[i].setBackground(Color.lightGray);
					
					botaoRemover[i].setBounds(320, (90+20*(i+1)), 15, 15);
					botaoRemover[i].setBackground(Color.red);
					botaoRemover[i].setOpaque(true);
					botaoRemover[i].setBorder(null);
					botaoRemover[i].setBorderPainted(true);
					
					janela.add(carrinho[i]);
					janela.add(botaoRemover[i]);
					botaoRemover[i].addActionListener(this);
				}
				i++;
			}
		}
		
		janela.setLayout(null);
		janela.setSize(400, 420);
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		botaoProdutos.setBounds(30, 60, 150, 30);
		botaoFinalizar.setBounds(200, 60, 150, 30);
		TESTE.setBounds(330, 20, 25, 25);
		
		janela.add(titulo);
		janela.add(botaoProdutos);
		janela.add(botaoFinalizar);
		
		botaoProdutos.addActionListener(this);
		botaoFinalizar.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Abre tela de Selecao de Produtos
		if(src == botaoProdutos) {
			System.out.println("ABRINDO LISTA DE SELECAO DE PRODS");
			botaoProdutos.removeActionListener(this);
			botaoFinalizar.removeActionListener(this);
			botaoProdutos.removeActionListener(this);
			TESTE.removeActionListener(this);				

			janela.dispose();
			listaNomes = new ControleProduto(dados).getNomeProd();
			listaProdsCadastrados = new JList<String>(listaNomes);
			frameProdutos = new JFrame("Produtos");
			titulo = new JLabel("Selecione um Produto");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaProdsCadastrados.setBounds(20, 50, 350, 120);
			listaProdsCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaProdsCadastrados.setVisibleRowCount(5);
			
			labelQtdItem.setBounds(30, 180, 150, 25);
			qtdItem.setBounds(105, 180, 30, 25);
			botaoAdicionar.setBounds(200, 180, 100, 30);	
			
			frameProdutos.setLayout(null);

			frameProdutos.add(titulo);
			frameProdutos.add(listaProdsCadastrados);
			frameProdutos.add(labelQtdItem);
			frameProdutos.add(qtdItem);
			frameProdutos.add(botaoAdicionar);

			frameProdutos.setSize(400, 250);
			frameProdutos.setVisible(true);
			
			//abre novamente o carrinho ao fechar a selecao de produtos
			frameProdutos.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        mostrarCarrinho(dados, posicao);
			    }
			});

			listaProdsCadastrados.addListSelectionListener((ListSelectionListener) this);
			
		}

		if(src == botaoAdicionar && prodSelec != null) {
			
			//botaoRemover[j].removeActionListener(this);
			botaoAdicionar.removeActionListener(this);
			botaoProdutos.removeActionListener(this);
			botaoFinalizar.removeActionListener(this);
			TESTE.removeActionListener(this);		
			
			//System.out.println("Botao Adicionar foi acionado");
			
			if (Integer.parseInt(qtdItem.getText()) > 0) {
				botaoAdicionar.addActionListener(this);
				for (int i = 0; i < 10; i++) {
					if (listaCarrinhoProd[i] == null) {
	
						//System.out.println("OK for botaoAdd && prodSelec");
						listaCarrinhoProd[i] = prodSelec;
						//System.out.println("OK carProd  " + listaCarrinhoProd[i]);
						listaCarrinhoQtd[i] =  Integer.parseInt(qtdItem.getText());
						//System.out.println("OK carQtd  " + listaCarrinhoQtd[i]);
						//qtdCarrinhoProd++;
						break;
					}
				}
				//Reseta o produto selecionado e fecha a janela de Selecao apos confirmar
				prodSelec = null;
				frameProdutos.dispose();
				mostrarCarrinho(dados, posicao);
			}
				
		}
		
		int j = 0;
		while(listaCarrinhoProd[j] != null) {
			if(src == botaoRemover[j]) {
				
				botaoRemover[j].removeActionListener(this);
				botaoProdutos.removeActionListener(this);
				botaoAdicionar.removeActionListener(this);
				botaoFinalizar.removeActionListener(this);
				TESTE.removeActionListener(this);	
				
				removerItem(j);
				janela.dispose();
				mostrarCarrinho(dados, posicao);
				break;
			}
			j++;
			
		}
		
		if (src == botaoFinalizar) {
			if (carrinho[0] != null) {
				System.out.println("Finalizando Compra :D");
				dados.finalizarCompra(posicao, listaCarrinhoProd, listaCarrinhoQtd);
				System.out.println(dados.getRecibo(posicao)[dados.getQtdRecibos(posicao)-1]);	
				janela.dispose();				
			}
		}
	}
	
	/**
	 * Captura eventos relacionados a lista de produtos a serem selecionados.
	 * Confere se o produto selecionado ja esta no carrinho.
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaProdsCadastrados) {
			prodSelec = dados.getProduto()[listaProdsCadastrados.getSelectedIndex()];	
			boolean valid = true;
			
			for (int k = 0; k < 10; k++) {
				if (prodSelec == listaCarrinhoProd[k]) {					
					valid = false;
					mensagemProdutoRepetido();
					botaoAdicionar.removeActionListener(this);
					break;
				}
			}
			
			if (valid) {
				botaoAdicionar.addActionListener(this); //Botao Adicionar so fara algo depois que um produto for selecionado				
			}
		}
		

	}
	
	/**
	 * Chamada ao pressionar o botao vermelho, remove um item da tela de carrinho.
	 * @param pos - index do item a ser removido do carrinho
	 * @return boolean
	 */
	public boolean removerItem(int pos) {
		qtdCarrinhoProd = 0;
		int i = 0;
		while (i < listaCarrinhoProd.length) {
			if (listaCarrinhoProd[i] != null) {
				qtdCarrinhoProd++;
			}
			i++;
		}
		
		if(pos == (qtdCarrinhoProd - 1)) { // O Item a ser removido está no final do array
			listaCarrinhoProd[qtdCarrinhoProd - 1] = null;
			listaCarrinhoQtd[pos] = 0;
			botaoRemover[pos] = null;
			return true;
			
		} else { // o item a ser removido está no meio do array
			//Rotina swap
			for(int j = pos; j < qtdCarrinhoProd - 1; j++) {
				listaCarrinhoProd[j] = null;
				listaCarrinhoProd[j] = listaCarrinhoProd[j+1];
				listaCarrinhoQtd[j] = 0;
				listaCarrinhoQtd[j] = listaCarrinhoQtd[j+1];
				botaoRemover[j] = null;
				botaoRemover[j] = botaoRemover[j+1];
			}
			
			listaCarrinhoProd[qtdCarrinhoProd - 1] = null;
			return true;
		}
	}
	
	/**
	 * Mostra mensagem caso o usuario selecione um item que ja esta no carrinho.
	 */
	public void mensagemProdutoRepetido() {
		JOptionPane.showMessageDialog(null,"ITEM JÁ ESTÁ NO CARRINHO!\n "
				+ "Você já adicionou esse produto, se deseja alterar a quantidade, remova-o e adicione novamente", null, 
				JOptionPane.ERROR_MESSAGE);
		}
	
}
