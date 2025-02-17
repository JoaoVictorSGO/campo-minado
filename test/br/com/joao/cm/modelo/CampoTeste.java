package br.com.joao.cm.modelo;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	
}

