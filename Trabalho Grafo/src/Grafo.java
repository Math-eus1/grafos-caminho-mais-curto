import java.util.ArrayList;

public class Grafo {

    private final int INACESSIVEL = Integer.MAX_VALUE; // Valor usado quando não se sabe a distância real
    private int [][] matriz;                           // entre o vértice inicial e os outros vértices, ai
    private int numVertices;                           // diz que é muito grande, muito longe, inacessível
    public int peso;

    // Criar um Grafo vazio
    public Grafo(int numVertices){
        this.numVertices = numVertices;
        matriz = new int [numVertices][numVertices];

        for (int i = 0; i < numVertices;i++){
            for (int j = 0; j < numVertices;j++){
                if (i == j){
                    matriz[i][j] = 0;

                }else {
                    matriz[i][j] = INACESSIVEL;
                }
            }
        }

    }

    public void InserirAresta(int v1, int v2, int peso){
        matriz[v1][v2] = peso; // Atribui o valor da Aresta ao peso e é direcionado, pois só tem um sentido
    }

    public void ExisteAresta(int v1, int v2){

        if (v1 == v2) {
            System.out.println("Não há verificação de arestas de um vértice para ele mesmo.");
            return;
        }

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

}