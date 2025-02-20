package br.com.joao.cm.modelo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TabuleiroTeste {


	private Tabuleiro tabuleiro;
	
	private static final int linhas = 3;
	private static final int colunas = 3;
	private static final int minas = 0;
	
	@BeforeEach
	void iniciarCampo() {
		
		tabuleiro = new Tabuleiro(linhas,colunas, minas);
	}
	
	@Test
	void testeAbrir() { // Esse teste pode ter uma exceção por causa do método sortear minas!
		int linha = 1;
		int coluna = 1;
		tabuleiro.abrir(linha, coluna);
		
		Campo campo = tabuleiro
				.getCampos()
				.parallelStream()
				.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Campo não encontrado."))
				;
		
		assertTrue(campo.isAberto());
	}
	
	@Test
	void testeAlterarMarcacao() {
		int linha = 1;
		int coluna = 2;
		tabuleiro.alterarMarcacao(linha, coluna);
		
		Campo campo = tabuleiro.getCampos()
				.parallelStream()
				.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Campo não marcado"));
		
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeGerarCampos() {
		assertEquals(linhas * colunas, tabuleiro.getCampos().size());
	}
	
	@Test
	void testeAssociarVizinhosCentro(){
		int linha = 1;
		int coluna = 1;
		Campo campo = tabuleiro.getCampos()
				.parallelStream()
				.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Campo não marcado"));
		assertEquals(8, campo.getVizinhos().size());

	}
	@Test
	void testeAssociarVizinhosBordas(){
		int linha = 1;
		int coluna = 2;
		Campo campo = tabuleiro.getCampos()
				.parallelStream()
				.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Campo não marcado"));
		assertEquals(5, campo.getVizinhos().size());
		
	}
	
	@Test
	void testeAssociarVizinhosCantos(){
		int linha = 2;
		int coluna = 2;
		Campo campo = tabuleiro.getCampos()
				.parallelStream()
				.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Campo não marcado"));
		assertEquals(3, campo.getVizinhos().size());
		
	}
	
	
	
}
