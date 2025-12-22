import java.util.Arrays;

public class Dijkstra {

    private static final int INACESSIVEL = -1;

    public int[] executar(Grafo g, int verticeInicial) {

        int n = g.getNumVertices();
        int[][] matriz = g.getMatriz();

        int[] dist = new int[n];
        boolean[] visitado = new boolean[n];
        int[] predecessor = new int[n]; // π

        // Inicialização
        Arrays.fill(dist, INACESSIVEL);
        Arrays.fill(predecessor, INACESSIVEL);

        dist[verticeInicial] = 0;

        System.out.println("\nIteração | S | d[]");

        for (int iter = 0; iter < n; iter++) {

            int u = -1;
            int menor = Integer.MAX_VALUE;

            // Escolhe vértice não visitado com menor distância
            for (int i = 0; i < n; i++) {
                if (!visitado[i] && dist[i] != INACESSIVEL) {
                    if (dist[i] < menor) {
                        menor = dist[i];
                        u = i;
                    }
                }
            }

            if (u == -1) break;

            visitado[u] = true;

            // Relaxamento
            for (int v = 0; v < n; v++) {
                if (!visitado[v] && matriz[u][v] != INACESSIVEL) {

                    int novaDist = dist[u] + matriz[u][v];

                    if (dist[v] == INACESSIVEL || novaDist < dist[v]) {
                        dist[v] = novaDist;
                        predecessor[v] = u; // π[v] = u
                    }
                }
            }

            // Isso aqui é seguindo a forma como o slide mostra
            System.out.print("(" + iter + ") | { ");
            for (int i = 0; i < n; i++) {
                if (visitado[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.print("} | ");

            for (int i = 0; i < n; i++) {
                if (dist[i] == INACESSIVEL) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(dist[i] + " ");
                }
            }
            System.out.println();
        }

        // Caminhos mínimos
        System.out.println("\nCaminhos mínimos:");
        for (int i = 0; i < n; i++) {
            System.out.print(verticeInicial + " -> " + i + ": ");
            imprimirCaminho(predecessor, i);

            if (predecessor[i] != INACESSIVEL) {
                System.out.print(" | π[" + i + "] = " + predecessor[i]);
            } else {
                System.out.print(" | π[" + i + "] = ∅");
            }

            System.out.println();
        }

        // Impressão dos predecessores para cada vértice
        System.out.println("\nVetor de predecessores (π):");
        for (int i = 0; i < n; i++) {
            if (predecessor[i] == INACESSIVEL) {
                System.out.println("π[" + i + "] = ∅");
            } else {
                System.out.println("π[" + i + "] = " + predecessor[i]);
            }
        }

        // Resultado final
        System.out.println("\nResultado final (menores distâncias):");
        for (int i = 0; i < n; i++) {
            if (dist[i] == INACESSIVEL) {
                System.out.println("Vértice " + i + ": inacessível");
            } else {
                System.out.println("Vértice " + i + ": " + dist[i]);
            }
        }

        return dist;
    }

    private void imprimirCaminho(int[] pred, int v) {
        if (v == INACESSIVEL) {
            return;
        }
        imprimirCaminho(pred, pred[v]);
        System.out.print(v + " ");
    }
}