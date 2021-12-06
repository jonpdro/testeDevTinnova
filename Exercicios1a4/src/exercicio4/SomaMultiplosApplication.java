package exercicio4;

import java.util.*;

public class SomaMultiplosApplication {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int x, soma = 0;

		System.out.print("Informe um valor: ");
		x = ler.nextInt();

		if (x % 3 == 0 || x % 5 == 0) {
			for (int i = x - 1; i > 0; i--) {
				if (i % 3 == 0 || i % 5 == 0) {
					soma += i;
				}
			}

			System.out.printf("\nO valor inserido foi: %d.\nA soma dos multíplos de 3 ou 5 é de: %d.", x, soma);

		} else {
			System.out.println("O valor informado é negativo ou não pode ser multiplo de 3 ou 5.");

		}
	}

}
