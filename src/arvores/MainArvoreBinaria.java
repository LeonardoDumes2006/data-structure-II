package arvores;

public class MainArvoreBinaria {
	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		
		ArvoreBinaria.No noA = arvore.criarRaiz('A');
		
		ArvoreBinaria.No noB = arvore.adicionarEsquerda(noA, 'B');
		
		ArvoreBinaria.No noC = arvore.adicionarDireita(noA, 'C');
		
		arvore.adicionarEsquerda(noB, 'D');
		
		arvore.adicionarDireita(noB, 'E');
		
		arvore.adicionarDireita(noC, 'F');
		
		System.out.println("Pré-ordem");
		arvore.preOrdem();
		
		System.out.println("Em ordem");
		arvore.emOrdem();
		
		System.out.println("Pós-ordem");
		arvore.posOrdem();
	}
}
