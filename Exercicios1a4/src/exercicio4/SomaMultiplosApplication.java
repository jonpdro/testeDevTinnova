package exercicio4;

import java.util.*;

public class SomaMultiplosApplication {

	public static void main(String[] args) {

		// Instanciamento para receber um parametro
		Scanner ler = new Scanner(System.in);

		// Váriaveis
		int x, soma = 0;

		// Exibir no console o parametro informado pelo usuário
		System.out.print("Informe um valor: ");
		x = ler.nextInt();

		// Condição para ver se o valor inserido é multiplo de 3 ou 5
		if (x % 3 == 0 || x % 5 == 0) {
			
			// Laço de repetição para fazer o calculo da soma dos múltiplos
			for (int i = x - 1; i > 0; i--) {
				if (i % 3 == 0 || i % 5 == 0) {
					soma += i;
				}
			}

			// Exibindo no console o resultado da soma
			System.out.printf("\nO valor inserido foi: %d.\nA soma dos multíplos de 3 ou 5 é de: %d.", x, soma);
		} else {
		
			// Se a condição acima for falsa, o retorno no console que o valor é negativo ou não múltiplo.
			System.out.println("O valor informado é negativo ou não pode ser multiplo de 3 ou 5.");

		}
	}

}
