package arvores;
import java.util.Queue;
import java.util.LinkedList;

public class ArvoreBinariaBusca {
	private class No{
		int valor;
		No dir;
		No esq;
		
		public No(int valor) {
			this.valor = valor;
			dir = esq = null;
		}
	}
	
	No raiz; 
	
	public void inserir(int valor) {
		raiz = inserir(raiz,valor);
	}
	
	private No inserir(No no, int valor) {
		if(no == null) {
			no = new No(valor);
			return no;
		} 
		
		if(valor<no.valor) {
			no.esq = inserir(no.esq, valor);
		}else if(valor > no.valor) {
			no.dir = inserir(no.dir,valor);
		}else {
			System.out.println("O Valor " + valor + " já existe na árvore");
		}
		
		return no;
	}
	
	public void emOrdem() {
		emOrdem(raiz);
		
	}
	
	private void emOrdem(No no) {
		if(no != null) {
			emOrdem(no.esq);
			System.out.println(no.valor);
			emOrdem(no.dir);
		}
	}
	
	public boolean buscar(int valor) {
		No atual = raiz;
		while(atual != null) {
			if(valor == atual.valor) {
				return true;
			}
			if(valor<atual.valor) {
				atual = atual.esq;
			}else {
				atual = atual.dir;
			}
			
		}
		return false;
	}
	public void remover(int valor) {
		if(!buscar(valor)) {
			System.out.println("Valor " + valor + "não existe na árvore");
			return;
		}
		raiz = remover(raiz,valor);
	}
	
	private No remover(No no, int valor) {
		// Procurar pelo nó
		if(valor < no.valor) {
			no.esq = remover(no.esq,valor);
		}
		else if(valor > no.valor) {
			no.dir = remover(no.dir,valor);
		}
		else {
			// caso 1: nó folha 
			if( no.esq == null && no.dir==null) {
				return null;
			}
			
			// caso 2: possui somente um filho à direita
			if(no.esq == null) {
				return no.dir;
			}
			// caso 2: possui somente um filho à esquerda
			if(no.dir == null) {
				return no.esq;
			}
			
			// caso 3: possui dois filhos 
			No sucessor = encontrarMenor(no.dir);
			
			// Copia o valor do sucessor
			no.valor = sucessor.valor;
			
			// Remover o sucessor da posição original
			no.dir = remover(no.dir, sucessor.valor);
		}
		return no;
	}
	
	private No encontrarMenor(No no) {
		while ( no.esq != null) {
			no = no.esq;
		}
		
		return no;
	}
	 
	private No encontrarMaior(No no) {
		while ( no.dir != null) {
			no = no.dir;
		}
		
		return no;
	}
			
	public void mostrarPorNivel() {
		if(raiz == null) {
			System.out.println("Árvore vazia");
			return;
		}
		Queue<No> fila = new LinkedList<>();
		fila.add(raiz);
		while ( !fila.isEmpty()) {
			int nivelSize = fila.size();
			for(int i=0; i<nivelSize; i++) {
				No noAtual = fila.poll();
				
				if(noAtual != null) {
					System.out.print(noAtual.valor + " ");
					fila.add(noAtual.esq);
					fila.add(noAtual.dir);
				}else {
					System.out.print("- ");
				}
				
			}
			System.out.println();
		}
	}
	
	public int quantidadeNos() {
		return quantidadeNos(raiz);
	}
	
	private int quantidadeNos(No no) {
		// Se o nó for nulo, não tem o que contar (retorna 0)
		if(no == null) {
			return 0;
		}
		
		// Retorna 1 (nó atual) + a quantidade de nós da esquerda + a quantidade da direita
		return 1 + quantidadeNos(no.esq) + quantidadeNos(no.dir);
	}
	
	public int nivelNo(int valor ) {
		int cont = 0;
		No atual = raiz;
		if(atual == null) {
			return 0;
		}else {
			while(atual != null) {
				if(valor == atual.valor) {
					cont++;
					return cont;
				}
				if(valor<atual.valor) {
					cont++;
					atual = atual.esq;
				}else {
					cont++;
					atual = atual.dir;
				}
			}
			return cont;
		}
		
	}
	
	public int alturaArvore(No raiz) {
	    // Árvore vazia não tem altura
	    if (raiz == null) {
	        return -1; // ou 0, dependendo da sua convenção
	    }

	    Queue<No> fila = new LinkedList<>();
	    fila.add(raiz); // Começa pela raiz
	    
	    int altura = -1; // Começa em -1 porque o nível da raiz vai somar +1 e virar 0

	    while (!fila.isEmpty()) {
	        // Quantos nós existem NESSE nível atual?
	        int tamanhoDoNivelAtual = fila.size();
	        
	        // Toda vez que entramos em um novo nível, aumentamos a altura
	        altura++;

	        // Agora tiramos TODOS os nós desse nível e colocamos os filhos deles na fila
	        for (int i = 0; i < tamanhoDoNivelAtual; i++) {
	            No noAtual = fila.poll();

	            // Se tiver filho na esquerda, joga pra fila
	            if (noAtual.esq != null) {
	                fila.add(noAtual.esq);
	            }
	            
	            // Se tiver filho na direita, joga pra fila
	            if (noAtual.dir != null) {
	                fila.add(noAtual.dir);
	            }
	        }
	    }

	    return altura;
	}
	
}
