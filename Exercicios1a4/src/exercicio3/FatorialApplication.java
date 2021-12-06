package exercicio3;

import java.util.*;

public class FatorialApplication {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int n, fatorial = 1;

		System.out.print("Informe um número qualquer: ");
		n = ler.nextInt();

		if (n <= 0) {
			System.out.println("O fatorial só pode ser realizado com números maiores que 0!");
			System.out.printf("O fatorial do número inserido é: %d", n);

		} else {
			for (int i = 1; i <= n; i++) {
				fatorial *= i;
			}

			System.out.printf("O fatorial do número inserido é: %d", fatorial);
		}
	}

}
