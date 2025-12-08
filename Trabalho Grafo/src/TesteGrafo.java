import java.util.*;

public class TesteGrafo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira a quantidade de vértices: \n");
        int inputVertices = scanner.nextInt();

        Grafo grafo = new Grafo(inputVertices);
        System.out.println("\n--- Grafo criado com " + inputVertices + " vértices ---\n");

        int opcao;
        int SimOuNao = 1;

        while (true) {

            System.out.println("\n===== MENU DO GRAFO =====");
            System.out.println("1) Inserir Arestas");
            System.out.println("2) Verificar Existência da Aresta");
            System.out.println("3) Remover Aresta");
            System.out.println("4) Listar Adjacentes");
            System.out.println("5) Imprimir Grafo por Aresta");
            System.out.println("6) Imprimir Grafo por Matriz");
            System.out.println("0) Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            int vert1, vert2, pesoAresta;

            if (opcao == 1) {
                SimOuNao = 1;
                while (SimOuNao == 1) {

                    System.out.print("Informe v1, v2 e o peso: \n");
                    vert1 = scanner.nextInt();
                    vert2 = scanner.nextInt();
                    pesoAresta = scanner.nextInt();

                    if (!validaVertices(vert1, vert2, inputVertices)) {
                        System.out.println("Vértices inválidos!");
                        continue;
                    }

                    grafo.InserirAresta(vert1, vert2, pesoAresta);
                    System.out.println("Aresta inserida com sucesso!");

                    System.out.print("Deseja inserir outra aresta? SIM (1) / NAO (0): ");
                    SimOuNao = scanner.nextInt();
                }
            }

            else if (opcao == 2) {
                SimOuNao = 1;
                while (SimOuNao == 1) {

                    System.out.print("Informe v1 e v2 para verificação: \n");
                    vert1 = scanner.nextInt();
                    vert2 = scanner.nextInt();

                    if (!validaVertices(vert1, vert2, inputVertices)) {
                        System.out.println("Vértices inválidos!");
                        continue;
                    }

                    grafo.ExisteAresta(vert1, vert2);

                    System.out.print("Deseja verificar outra aresta? SIM (1) / NAO (0): ");
                    SimOuNao = scanner.nextInt();
                }
            }

            else if (opcao == 3) {
                SimOuNao = 1;
                while (SimOuNao == 1) {

                    System.out.print("Informe v1 e v2 da aresta a remover: \n");
                    vert1 = scanner.nextInt();
                    vert2 = scanner.nextInt();

                    if (!validaVertices(vert1, vert2, inputVertices)) {
                        System.out.println("Vértices inválidos!");
                        continue;
                    }

                    grafo.RemoveAresta(vert1, vert2);
                    System.out.println("Aresta removida!");

                    System.out.print("Deseja remover outra aresta? SIM (1) / NAO (0): ");
                    SimOuNao = scanner.nextInt();
                }
            }

            else if (opcao == 4) {
                SimOuNao = 1;
                while (SimOuNao == 1) {

                    System.out.print("Informe o vértice para listar adjacentes: ");
                    vert1 = scanner.nextInt();

                    if (vert1 < 0 || vert1 >= inputVertices) {
                        System.out.println("Vértice inválido!");
                        continue;
                    }

                    ArrayList<Integer> adjacentes = grafo.ListarAdjacentes(vert1);

                    if (adjacentes.isEmpty()) {
                        System.out.println("O vértice " + vert1 + " não possui adjacentes.");
                    } else {
                        System.out.print("Adjacentes de " + vert1 + ": ");
                        for (int adj : adjacentes) {
                            System.out.print(adj + ", ");
                        }
                        System.out.println();
                    }

                    System.out.print("Deseja listar outro vértice? SIM (1) / NAO (0): ");
                    SimOuNao = scanner.nextInt();
                }
            }

            else if (opcao == 5) {
                grafo.ImprimeGrafoPorAresta();
            }

            else if (opcao == 6) {
                grafo.ImprimeGrafoMatriz();
            }

            else if (opcao == 0) {
                System.out.println("Sistema finalizado!");
                break;
            }

            else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    private static boolean validaVertices(int v1, int v2, int limite) {
        return v1 >= 0 && v1 < limite && v2 >= 0 && v2 < limite;
    }
}
