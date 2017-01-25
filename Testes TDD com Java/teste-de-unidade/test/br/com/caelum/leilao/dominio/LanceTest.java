package br.com.caelum.leilao.dominio;

import org.junit.Test;

public class LanceTest {

	@Test(expected=IllegalArgumentException.class)
	public void deveLevantarExcessaoAoCriarLanceComValorIgualAZero() {
		new Lance(new Usuario("Vitor"), 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void deveLevantarExcessaoAoCriarLanceComValorMenorQueZero() {
		new Lance(new Usuario("Vitor"), -100);
	}

}
