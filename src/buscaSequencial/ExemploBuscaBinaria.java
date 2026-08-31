package buscaSequencial;

public class ExemploBuscaBinaria {
	public static int buscaBinaria(int[] array, int valorProcurado) {
		int inicio = 0;
		int fim = array.length-1;
		int comparacoes = 0;
		
		while (inicio <= fim) {
			int meio = inicio + (fim-inicio) / 2;
			comparacoes ++;
			
			if(array[meio] == valorProcurado) {	
				System.out.println("Comparações " + comparacoes);
				return meio;
			}
			if(valorProcurado > array[meio]) {
				inicio = meio+1;
			}else {
				fim = meio -1;
			}
			
		}
		System.out.println("Comparações " + comparacoes);
		return -1;
		
	}
	
	public static void main(String[] args) {
		int[] numeros = {3,7,9,12,18,25,30};
		int valorProcurado = 25;
		
		int posicao = buscaBinaria(numeros, valorProcurado);
		
		if(posicao != -1) {
			System.out.println("Valor encontrado no índice " + posicao );
		}else {
			System.out.println("Valor não encontrado");
		}
		
		buscaBinaria(numeros, valorProcurado);

	}
}
