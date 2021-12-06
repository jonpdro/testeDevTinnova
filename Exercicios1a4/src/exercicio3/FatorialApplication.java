package exercicio3;

import java.util.*;

public class FatorialApplication {

	public static void main(String[] args) {

		// Instanciamento para receber um parametro
		Scanner ler = new Scanner(System.in);

		// Váriaveis
		int n, fatorial = 1;

		// Exibir no console o parametro informado pelo usuário
		System.out.print("Informe um número qualquer: ");
		n = ler.nextInt();

		// Condição para ver se o valor é zero ou negativo
		if (n <= 0) {
			System.out.println("O fatorial só pode ser realizado com números maiores que 0!");
			System.out.printf("O fatorial do número inserido é: %d", n);

		} else {
			// Caso o contrário da condição acima, o laço de repetição irá fazer o calculo
			// fatorial
			for (int i = 1; i <= n; i++) {
				fatorial *= i;
			}

			// Exibição final no console o resultado do fatorial
			System.out.printf("O fatorial do número inserido é: %d", fatorial);
		}
	}

}
