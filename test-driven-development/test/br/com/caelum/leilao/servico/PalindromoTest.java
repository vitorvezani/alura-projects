package br.com.caelum.leilao.servico;

import org.junit.Assert;
import org.junit.Test;

public class PalindromoTest {

	@Test
	public void ehPalindromoTest() {
		Palindromo pal = new Palindromo();

		Assert.assertTrue(pal.ehPalindromo("aiia"));

		Assert.assertFalse(pal.ehPalindromo("false"));
	}

}
