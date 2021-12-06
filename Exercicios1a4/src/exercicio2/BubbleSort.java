package exercicio2;

public class BubbleSort {

	public BubbleSort() {
		
	}
	
	public BubbleSort(int[] v) throws Exception {
		boolean iteracao;
		int repeticao, contador;

		repeticao = 0;
		iteracao = true;

		while (iteracao == true) {
			iteracao = false;

			for (int x = 0; x < v.length - 1; x++) {

				if (v[x] > v[x + 1]) {
					contador = v[x];

					v[x] = v[x + 1];
					v[x + 1] = contador;

					iteracao = true;
					repeticao++;

					System.out.println();
					System.out.println(repeticao + "ª Iteração:");

					for (int i = 0; i < v.length; i++) {
						if (i == x) {
							System.out.println(v[i] + " <— Valor menor trocado");

						} else if (i == (x + 1)) {
							System.out.println(v[i] + " <— Valor maior trocado");

						} else {
							System.out.println(v[i]);

						}

					}
					pausa();
				}
			}
		}

		System.out.println();
		System.out.println("Depois de " + repeticao + " iterações, eis o vetor ordenado:");

		for (int i = 0; i < v.length; i++) {
			System.out.println(i + 1 + "º Número: " + v[i]);

		}
	}

	public static void pausa() throws Exception {
		Thread.sleep(750);
	}
}
