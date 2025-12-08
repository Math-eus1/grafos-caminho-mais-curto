import java.util.Scanner;

public class TesteGrafo {

    public static void main(String[] args) {

        System.out.println("Insira a quantidade de Vértices: ");
        Scanner scanner = new Scanner(System.in);
        int inputVertices = scanner.nextInt();

        Grafo grafo = new Grafo(inputVertices);
        System.out.println("--- Grafo criado com " + inputVertices + " vertices ---");
        System.out.println();

        boolean sistema = true;
        int opcao;
        int SimOuNao;
        while (sistema == true) {

            System.out.println("Selecione a ação que deseja: ");
            System.out.println("1) Inserir Arestas");
            System.out.println("2) Verificar existencia da Aresta");
            System.out.println("3) Remover Aresta(s)");
            System.out.println("4) Listar Adjacentes");
            System.out.println("5) Imprimir Grafo por aresta");
            System.out.println("6) Imprimir Grafo por Matriz");
            System.out.println("0) Sair do Sistema");

            opcao = scanner.nextInt();
            int inicializador = 0; 
            int vert1;
            int vert2;
            int pesoAresta;

            if (opcao == 1) {
                while (inicializador < (inputVertices*inputVertices)) {
                    System.out.println("inserir aresta? SIM (1) / NAO (0)");
                    SimOuNao = scanner.nextInt();
                    if (SimOuNao == 0) {
                        inicializador = (inputVertices*inputVertices);
                        continue;
                    }else{
                        System.out.println("Forneça o v1, v2 e o peso: ");
                        vert1 = scanner.nextInt();
                        vert2 = scanner.nextInt();
                        pesoAresta = scanner.nextInt();
                        grafo.InserirAresta(vert1, vert2, pesoAresta);
                        inicializador++;
                    }
                }
            }
            else if (opcao == 2) {
                System.out.println("Quer verificar a existencia da aresta? ");
                SimOuNao = scanner.nextInt();
                if (SimOuNao == 0) {
                    continue;
                }else{
                    while (SimOuNao == 1) {
                        System.out.println("Forneça os vértices os quais você quer verificar se existe aresta: ");
                        vert1 = scanner.nextInt();
                        vert2 = scanner.nextInt();  
                        grafo.ExisteAresta(vert1, vert2);
                        System.out.println("Quer verificar a existencia da aresta? ");
                        SimOuNao = scanner.nextInt();
                    }
                }
            }
            else if (opcao == 3) {
                System.out.println("deseja remover aresta? ");
                SimOuNao = scanner.nextInt();
                if (SimOuNao == 0) {
                    continue;
                }else{
                    for (int i = 0; i <= 2; i++) {
                        System.out.println("Forneça os vértices os quais você quer verificar se existe aresta: ");
                        vert1 = scanner.nextInt();
                        vert2 = scanner.nextInt();  
                        grafo.RemoveAresta(vert1, vert2);
                    }
                }
            }
            else if (opcao == 4) {
                System.out.println("Deseja listar adjacentes? ");
                SimOuNao = scanner.nextInt();
                if (SimOuNao == 0) {
                    continue;
                }else{
                    while (SimOuNao == 1) {
                        System.out.println("Qual vertice voce deseja verificar os adjacentes? ");
                        vert1 = scanner.nextInt();
                        grafo.ListarAdjacentes(vert1);
                        System.out.println("Deseja listar adjacentes? ");
                        SimOuNao = scanner.nextInt();
                    }
                }
            }
            else if (opcao == 5) {
                grafo.ImprimeGrafoPorAresta();
                continue;
            }
            else if (opcao == 6) {
                grafo.ImprimeGrafoMatriz();
                continue;
            }
            else if (opcao == 0) {
                System.out.println("Não vai usar nada, então? Portanto, tenha uma ótima noite");
                break;
            }
            else{
                System.out.println("Insira uma opcao valida!");
                continue;
            }

        }
        scanner.close();
        
    }
}