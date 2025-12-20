import java.util.ArrayList;

public class Grafo {

    private final int INACESSIVEL = -1; // Valor usado quando não se sabe a distância real
    private int [][] matriz;                           // entre o vértice inicial e os outros vértices, ai
    private int numVertices;                           // diz que é muito grande, muito longe, inacessível
    public int peso;

    // Criar um Grafo vazio
    public Grafo(int numVertices){
        this.numVertices = numVertices;
        matriz = new int [numVertices][numVertices];

        for (int i = 0; i < numVertices;i++){
            for (int j = 0; j < numVertices;j++){  
                    matriz[i][j] = INACESSIVEL;
            }
        }

    }

    public void InserirAresta(int v1, int v2, int peso){
        matriz[v1][v2] = peso; // Atribui o valor da Aresta ao peso e é direcionado, pois só tem um sentido
    }

    public void Insercao(){
        System.out.println("vertice 1: ");
        System.out.println("vertice 2: ");
        System.out.println("peso: ");
    }

    public void ExisteAresta(int v1, int v2){
        if (matriz[v1][v2] == INACESSIVEL){
            System.out.println("Essa Aresta não existe!");
        } else{
            System.out.println("Essa Aresta existe! O peso: "+ matriz[v1][v2]);
        }
    }

    public void RemoveAresta(int v1, int v2){
        if (matriz[v1][v2] == INACESSIVEL){
            System.out.println("Essa Aresta não existe!");
        }  else {
           peso = matriz[v1][v2];
           matriz[v1][v2] = INACESSIVEL;
        }
    }

    public ArrayList<Integer> ListarAdjacentes(int v){
        ArrayList<Integer> adjacentes = new ArrayList<>();

        for (int i = 0; i < numVertices; i++){
            if (v == i){
                continue;
            }

            if (matriz[v][i] != INACESSIVEL){
                adjacentes.add(i);
            }
        }
        return adjacentes;
    }

    public void ImprimeGrafoPorAresta(){
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++){
                if (matriz[i][j] != INACESSIVEL){
                    System.out.println("Aresta: " + i + " -> " + j + " [" + matriz[i][j] + "]");
                }
            }
        }
    }

    public void ImprimeGrafoMatriz() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matriz[i][j] == INACESSIVEL) {
                    System.out.print("-  "); //isso aqui é pra ele não mostrar o número max dos inteiros;
                } else {                       //dá pra trocar por 0 ou por inf também
                    System.out.print(matriz[i][j] + " "); 
                }
            }
            System.out.println(); 
        }
    }
    public int getNumVertices() {
        return numVertices;
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
}
