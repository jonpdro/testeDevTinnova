package exercicio2;

public class BubbleSort {

	// Construtor vazio
	public BubbleSort() {

	}

	// Método que recebe um vetor e evita erros
	public BubbleSort(int[] v) throws Exception {

		// Váriaveis
		boolean iteracao;
		int repeticao, contador;

		// Atribuição de valores às váriaveis
		repeticao = 0;
		iteracao = true;

		// Laço de repetição para a iteração do BubbleSort
		while (iteracao == true) {
			iteracao = false;

			// Laço de repetição para realizar o BubbleSort
			for (int x = 0; x < v.length - 1; x++) {

				// Verificação da condição
				if (v[x] > v[x + 1]) {

					// "Calculos"
					contador = v[x];
					v[x] = v[x + 1];
					v[x + 1] = contador;
					iteracao = true;
					repeticao++;

					// Exibição no console em qual iteração está
					System.out.println();
					System.out.println(repeticao + "ª Iteração:");

					// Laço de repetição para repetir os numeros do vetores e o que foi trocado, no
					// console
					for (int i = 0; i < v.length; i++) {
						if (i == x) {
							System.out.println(v[i] + " <— Valor menor trocado");
						} else if (i == (x + 1)) {
							System.out.println(v[i] + " <— Valor maior trocado");
						} else {
							System.out.println(v[i]);
						}
					}
					// Pausa de 700ms por cada iteração
					pausa();
				}
			}
		}

		// Exibição final dos vetores
		System.out.println();
		System.out.println("Depois de " + repeticao + " iterações, eis o vetor ordenado:");
		for (int i = 0; i < v.length; i++) {
			System.out.println(i + 1 + "º Número: " + v[i]);
		}
	}

	// Método da pausa de 700ms
	public static void pausa() throws Exception {
		Thread.sleep(750);
	}
}
