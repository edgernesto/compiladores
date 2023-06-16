package compilador;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);

		char[] alfabeto = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'l', 'm', 'n', 'o', 'p', 'r', 's', 't', 'u', 'v',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'V', 'Y', 'y', '0',
				'1', '2', '3', '4', '5', '6', '7', '8', '9', 'x', 'X', 'z', 'Z' };

		char[] alfabetoConsoante = { 'b', 'c', 'd', 'f', 'g', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v', 'B', 'C', 'D',
				'F', 'G', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'V', 'Y', 'y', 'x', 'X', 'z', 'Z' };

		char[] alfabetoVogal = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

		char[] alfabetoNumerico = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		String palavra = "";
		boolean loop = true;
		ArrayList<String> palavrasLidas = new ArrayList<String>();

		do {
			System.out.println("Digite a palavra");
			palavra = input.nextLine();

			int contador = 0;
			char[] analisador = palavra.toCharArray();

			for (char valor : analisador) {
				for (char valor2 : alfabeto) {
					if (valor == valor2) {
						contador++;
					}
				}
			}

			if (palavra.charAt(0) == 'z' || palavra.charAt(0) == 'Z' || palavra.charAt(0) == 'x'
					|| palavra.charAt(0) == 'X') {
				System.out.println("Palavras iniciadas por X e Z são palavras reservadas pelo sistema");
			} else if (contador == analisador.length) {
				palavrasLidas.add(palavra);
			} else {
				System.out.println("Essa palavra não pertence ao alfabeto");
			}

			boolean parar = false;
			while (parar == false) {
				System.out.println("\nCONTINUAR = 0 | PARAR = 1");
				String parar2 = inputInt.next();

				if (parar2.equals("0")) {
					loop = true;
					parar = true;
				} else if (parar2.equals("1")) {
					loop = false;
					parar = true;
				} else {
					System.out.println("Escolha uma opção válida");
					parar = false;
				}
			}
		} while (loop == true);

		ArrayList<String> palavrasAceitas = new ArrayList<String>();

		for (String valor : palavrasLidas) {
			int contador = 0;
			char[] analisador = valor.toCharArray();

			for (int i = 0; i < analisador.length; i++) {

				if (analisador.length > 10) {
					break;

				} else if (i == analisador.length - 1) {
					for (char valor2 : alfabetoNumerico) {
						contador++;
						break;
					}

				} else if (i % 2 == 0) {

					for (char valor2 : alfabetoConsoante) {
						if (analisador[i] == valor2) {
							contador++;
						}
					}

				} else if (i % 2 == 1) {
					for (char valor2 : alfabetoVogal) {
						if (analisador[i] == valor2) {
							contador++;
						}
					}

				}
				if (contador == analisador.length) {
					palavrasAceitas.add(valor);
				}

			}

		}

		System.out.println("Palavras Aceitas:");
		for (String valor : palavrasAceitas) {
			System.out.println(valor);
		}

	}

}