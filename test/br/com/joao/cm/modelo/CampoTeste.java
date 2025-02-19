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
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,2);
		campo12.minar();
		Campo campo22 = new Campo(2,2);
		campo22.adiconarVizinho(campo11);
		campo22.adiconarVizinho(campo12);
		
		campo.adiconarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
	
	@Test
	void testeIsFechado() {
		assertTrue(campo.isFechado());
	}
	
	@Test
	void testeIsFechadoDuasVezes(){
		assertTrue(campo.isFechado());
		assertTrue(campo.isFechado());
	}
	@Test
	void testeGetColuna() {
		assertEquals(campo.getColuna(), 3);
	}
	
	@Test
	void testeGetLinha() {
		assertEquals(campo.getLinha(), 3);
	}
	@Test
	void testeTotalDeMinas() {
		Campo campo1 = new Campo(2,3);
		Campo campo2 = new Campo(4,3);
		Campo campo3 = new Campo(2,2);
		Campo campo4 = new Campo(2,4);
		
		campo2.minar();
		campo4.minar();
		
		campo.adiconarVizinho(campo4);
		campo.adiconarVizinho(campo3);
		campo.adiconarVizinho(campo2);
		campo.adiconarVizinho(campo1);
		
		assertEquals(campo.minasNaVizinhanca(), 2);
	}
	
	@Test
	void testeObjetivoAlcancadoSemMinaEAberto() {
		Campo campo1 = new Campo(2,3);
		campo1.abrir();
		assertTrue(campo1.objetivoAlcancado());
	}
	@Test
	void testeObjetivoAlcancadoMinadoEMarcado() {
		Campo campo1 = new Campo(2,3);
		
		campo1.minar();
		campo1.alterarMarcacao();
		assertTrue(campo1.objetivoAlcancado());
	}
	
	@Test
	void testeObjetivoAlcancadoMinadoEAberto() {
		Campo campo1 = new Campo(2,3);
		
		campo1.minar();
		campo1.alterarMarcacao();
		campo1.abrir();

		assertTrue(campo1.objetivoAlcancado());
	}
	
	@Test
	void testeReniciarJogo() {
		Campo campo1 = new Campo(2,3);
		campo1.minar();
		campo1.alterarMarcacao();
		campo.abrir();
		campo1.reniciar();
		campo.reniciar();
		
		assertFalse(campo1.isAberto());
		assertFalse(campo1.isMarcado());
		assertTrue(campo.isFechado());
	}
	
	@Test
	void testeToStringMarcado() {
		campo.alterarMarcacao();
		String resultado = campo.toString();
		assertEquals("x", resultado);
	}
	
	@Test
	void testeToStringAbertoEMinado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> { // Testar exceção.
			campo.abrir();		
		});
		String resultado = campo.toString();
		assertEquals("*", resultado);
	}
	
	@Test
	void testeToStringAbertoEMinasNaVizinhaca1() {
		Campo campo1 = new Campo(2, 2);
		campo1.minar();
		campo.adiconarVizinho(campo1);
		campo.abrir();
		assertEquals(1, campo.minasNaVizinhanca());
	}
	@Test
	void testeToStringAbertoEMinasNaVizinhaca2() {
		Campo campo1 = new Campo(2, 2);
		Campo campo2 = new Campo(2, 3);
		campo1.minar();
		campo2.minar();
		campo.adiconarVizinho(campo1);
		campo.adiconarVizinho(campo2);
		campo.abrir();
		assertEquals(2, campo.minasNaVizinhanca());
	}
	
	@Test
	void testeToStringAbertoEMinasNaVizinhaca3() {
		Campo campo1 = new Campo(2, 2);
		Campo campo2 = new Campo(2, 3);
		Campo campo3 = new Campo(3, 2);
		campo1.minar();
		campo2.minar();
		campo3.minar();
		campo.adiconarVizinho(campo1);
		campo.adiconarVizinho(campo2);
		campo.adiconarVizinho(campo3);
		campo.abrir();
		assertEquals(3, campo.minasNaVizinhanca());
	}
	
	@Test
	void testeToStringAberto() {
		campo.abrir();
		assertEquals(" ", campo.toString());
	}
	
	@Test
	void testeToString() {
		String resultado = campo.toString();
		assertEquals("?", resultado);
	}
}
	
	


