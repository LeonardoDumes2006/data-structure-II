package buscaSequencial;

public class ExemploBuscaSequencial {
	public static int buscaSequencial(int[] array, int valorProcurado) {
		int comparacoes = 0;
		for(int i=0; i<array.length;i++) {
			comparacoes++;
			if(array[i] == valorProcurado) {	
				System.out.println("Comparações " + comparacoes);
				return i;
			}
			
		}
		System.out.println("Comparações " + comparacoes);
		return -1;
	}
	public static void main(String[] args) {
		int[] numeros = {18,7,25,3,12,30,9};
		int valorProcurado = 12;
		
		int posicao = buscaSequencial(numeros, valorProcurado);
		if(posicao != -1) {
			System.out.println("Valor encontrado no índice " + posicao);
		}
		else {
			System.out.println("Valor não encontrado");
		}
		buscaSequencial(numeros, valorProcurado);
	}
}
