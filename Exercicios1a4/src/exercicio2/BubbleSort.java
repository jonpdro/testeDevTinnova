package exercicio2;

public class BubbleSort {

	// Construtor vazio
	public BubbleSort() {

	}

	// M�todo que recebe um vetor e evita erros
	public BubbleSort(int[] v) throws Exception {

		// V�riaveis
		boolean iteracao;
		int repeticao, contador;

		// Atribui��o de valores �s v�riaveis
		repeticao = 0;
		iteracao = true;

		// La�o de repeti��o para a itera��o do BubbleSort
		while (iteracao == true) {
			iteracao = false;

			// La�o de repeti��o para realizar o BubbleSort
			for (int x = 0; x < v.length - 1; x++) {

				// Verifica��o da condi��o
				if (v[x] > v[x + 1]) {

					// "Calculos"
					contador = v[x];
					v[x] = v[x + 1];
					v[x + 1] = contador;
					iteracao = true;
					repeticao++;

					// Exibi��o no console em qual itera��o est�
					System.out.println();
					System.out.println(repeticao + "� Itera��o:");

					// La�o de repeti��o para repetir os numeros do vetores e o que foi trocado, no
					// console
					for (int i = 0; i < v.length; i++) {
						if (i == x) {
							System.out.println(v[i] + " <� Valor menor trocado");
						} else if (i == (x + 1)) {
							System.out.println(v[i] + " <� Valor maior trocado");
						} else {
							System.out.println(v[i]);
						}
					}
					// Pausa de 700ms por cada itera��o
					pausa();
				}
			}
		}

		// Exibi��o final dos vetores
		System.out.println();
		System.out.println("Depois de " + repeticao + " itera��es, eis o vetor ordenado:");
		for (int i = 0; i < v.length; i++) {
			System.out.println(i + 1 + "� N�mero: " + v[i]);
		}
	}

	// M�todo da pausa de 700ms
	public static void pausa() throws Exception {
		Thread.sleep(750);
	}
}
