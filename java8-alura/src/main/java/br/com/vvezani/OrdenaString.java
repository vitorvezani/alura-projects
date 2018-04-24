package br.com.vvezani;

import java.util.ArrayList;
import java.util.List;

public class OrdenaString {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		palavras.forEach(System.out::println);
		
		palavras.sort(String::compareTo);
		palavras.forEach(System.out::println);
	}
	
}
