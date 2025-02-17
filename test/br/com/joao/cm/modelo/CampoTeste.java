package br.com.joao.cm.modelo;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.joao.cm.excecao.ExplosaoException;

public class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoDistancia1Esquerda() {
		Campo vizinho = new Campo(3,2);
		boolean resultado  = campo.adiconarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistancia1Direita() {
		Campo vizinho = new Campo(3,4);
		boolean resultado  = campo.adiconarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia1EmCima() {
		Campo vizinho = new Campo(2,3);
		boolean resultado  = campo.adiconarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia1EmBaixo() {
		Campo vizinho = new Campo(4,3);
		boolean resultado  = campo.adiconarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinholDistancia2Diagonal1() {
		Campo vizinho = new Campo(2,2);
		boolean resultado  = campo.adiconarVizinho(vizinho);
		assertTrue(resultado);
	}
	@Test
	void testeVizinholDistancia2Diagonal2() {
		Campo vizinho = new Campo(4,2);
		boolean resultado  = campo.adiconarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinholDistancia2Diagonal3() {
		Campo vizinho = new Campo(2,4);
		boolean resultado  = campo.adiconarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinholDistancia2Diagonal4() {
		Campo vizinho = new Campo(4,4);
		boolean resultado  = campo.adiconarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinholDistancia2() {
		Campo vizinho = new Campo(2,2);
		boolean resultado  = campo.adiconarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1,2);
		boolean resultado  = campo.adiconarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() { // verifiando o valor padrao.
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlterarMarcacao() { // Testando a alteração de marcacao.
		campo.alterarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlterarMarcacaoDuasChamadas() { // Testando duas chamadas 
		campo.alterarMarcacao();
		campo.alterarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	
	void testeAbrirNaoMinandoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinandoMarcado() {
		campo.alterarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinandoMarcado() {
		campo.alterarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinandoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> { // Testar exceção.
			campo.abrir();		
		});
			
	}

	@Test
	void testeAbrirComVizinhos() {
		Campo campo11 = new  Campo(1,1);
		Campo campo22 = new  Campo(2,2);
		campo22.adiconarVizinho(campo11);
		
		campo.adiconarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}

	@Test
	void testeAbrirComVizinhos2() {
		Campo campo11 = new  Campo(1,1);
		Campo campo12 = new  Campo(1,1);
		campo12.minar();
		Campo campo22 = new  Campo(2,2);
		campo22.adiconarVizinho(campo11);
		campo22.adiconarVizinho(campo12);
		
		campo.adiconarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
}
	
	


