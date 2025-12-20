public class Dijkstra {

    private final int INACESSIVEL = -1;

    public void Executar(Grafo g, int verticeInicial) {

        int numVertices = g.getNumVertices();
        int[][] matriz = g.getMatriz();

        int[] distancia = new int[numVertices];
        boolean[] visitado = new boolean[numVertices];

        // Inicialização
        for (int i = 0; i < numVertices; i++) {
            distancia[i] = INACESSIVEL;
            visitado[i] = false;
        }

        distancia[verticeInicial] = 0;

        // Algoritmo de Dijkstra
        for (int i = 0; i < numVertices - 1; i++) {

            int verticeAtual = -1;
            int menorDistancia = Integer.MAX_VALUE;

            // Escolhe o vértice não visitado com menor distância
            for (int v = 0; v < numVertices; v++) {
                if (!visitado[v] && distancia[v] != INACESSIVEL) {
                    if (distancia[v] < menorDistancia) {
                        menorDistancia = distancia[v];
                        verticeAtual = v;
                    }
                }
            }

            if (verticeAtual == -1) break;

            visitado[verticeAtual] = true;

            // Atualiza as distâncias dos vizinhos
            for (int v = 0; v < numVertices; v++) {
                if (matriz[verticeAtual][v] != INACESSIVEL && !visitado[v]) {
                    if (distancia[v] == INACESSIVEL ||
                        distancia[verticeAtual] + matriz[verticeAtual][v] < distancia[v]) {

                        distancia[v] = distancia[verticeAtual] + matriz[verticeAtual][v];
                    }
                }
            }
        }

        // Resultado
        System.out.println("Menor distância a partir do vértice " + verticeInicial);
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vértice " + i + " -> " + distancia[i]);
        }
    }
}
