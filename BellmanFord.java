//package bellmanford;

/**
 *
 * @author Bruno
 */
public class BellmanFord {

    public static void main(String[] args) {

        Nodo matrizPrincipal = new Nodo(5);
        Nodo nodoA = new Nodo(5);
        Nodo nodoB = new Nodo(5);
        Nodo nodoC = new Nodo(5);
        Nodo nodoD = new Nodo(5);
        Nodo nodoE = new Nodo(5);
        Nodo matrizVizinhos = new Nodo(5);

        matrizPrincipal.inserirArco(Nodo.A, Nodo.A, 0);
        matrizPrincipal.inserirArco(Nodo.A, Nodo.B, 2);
        matrizPrincipal.inserirArco(Nodo.A, Nodo.C, 4);
        matrizPrincipal.inserirArco(Nodo.A, Nodo.D, Nodo.OO);
        matrizPrincipal.inserirArco(Nodo.A, Nodo.E, Nodo.OO);

        matrizPrincipal.inserirArco(Nodo.B, Nodo.A, 2);
        matrizPrincipal.inserirArco(Nodo.B, Nodo.B, 0);
        matrizPrincipal.inserirArco(Nodo.B, Nodo.C, 3);
        matrizPrincipal.inserirArco(Nodo.B, Nodo.D, 11);
        matrizPrincipal.inserirArco(Nodo.B, Nodo.E, Nodo.OO);

        matrizPrincipal.inserirArco(Nodo.C, Nodo.A, 4);
        matrizPrincipal.inserirArco(Nodo.C, Nodo.B, 3);
        matrizPrincipal.inserirArco(Nodo.C, Nodo.C, 0);
        matrizPrincipal.inserirArco(Nodo.C, Nodo.D, 1);
        matrizPrincipal.inserirArco(Nodo.C, Nodo.E, Nodo.OO);

        matrizPrincipal.inserirArco(Nodo.D, Nodo.A, Nodo.OO);
        matrizPrincipal.inserirArco(Nodo.D, Nodo.B, 11);
        matrizPrincipal.inserirArco(Nodo.D, Nodo.C, 1);
        matrizPrincipal.inserirArco(Nodo.D, Nodo.D, 0);
        matrizPrincipal.inserirArco(Nodo.D, Nodo.E, 2);

        matrizPrincipal.inserirArco(Nodo.E, Nodo.A, Nodo.OO);
        matrizPrincipal.inserirArco(Nodo.E, Nodo.B, Nodo.OO);
        matrizPrincipal.inserirArco(Nodo.E, Nodo.C, Nodo.OO);
        matrizPrincipal.inserirArco(Nodo.E, Nodo.D, 2);
        matrizPrincipal.inserirArco(Nodo.E, Nodo.E, 0);

        nodoA.retornaMatrizEspecifica(matrizPrincipal.matriz, Nodo.A);
        nodoB.retornaMatrizEspecifica(matrizPrincipal.matriz, Nodo.B);
        nodoC.retornaMatrizEspecifica(matrizPrincipal.matriz, Nodo.C);
        nodoD.retornaMatrizEspecifica(matrizPrincipal.matriz, Nodo.D);
        nodoE.retornaMatrizEspecifica(matrizPrincipal.matriz, Nodo.E);

        try {
            System.err.println("----- Matriz Principal -----");
            matrizPrincipal.printMatriz();

            System.out.println();
            System.err.println("------- Matriz A -------");
            nodoA.printMatriz();

            System.out.println();
            System.err.println("------- Matriz B -------");
            nodoB.printMatriz();

            System.out.println();
            System.err.println("------- Matriz C -------");
            nodoC.printMatriz();

            System.out.println();
            System.err.println("------- Matriz D -------");
            nodoD.printMatriz();

            System.out.println();
            System.err.println("------- Matriz E -------");
            nodoE.printMatriz();

            isVizinho(matrizPrincipal.matriz, matrizVizinhos.matriz);

        } catch (Exception e) {
            if (e.getMessage() != null && (!e.getMessage().equals(""))) {
                System.err.println("ERRO AO IMPRIMIR MATRIZ" + e.getMessage());
            } else {
                System.err.println("ERRO AO IMPRIMIR MATRIZ");
            }
        }
        /* FIM DO CATCH*/
        do {
            for (int i = 0; i < matrizPrincipal.matriz.length; i++) {
                for (int j = 0; j < matrizPrincipal.matriz.length; j++) {
                    for (int k = 0; k < matrizPrincipal.matriz.length; k++) {

                        if (matrizPrincipal.matriz[i][j] > (matrizPrincipal.matriz[k][j] + matrizPrincipal.matriz[i][k])) {
                            matrizPrincipal.matriz[i][j] = (matrizPrincipal.matriz[k][j] + matrizPrincipal.matriz[i][k]);
                        }
                    }
                }
            }
        } while (existirRotasIndefinidas(matrizPrincipal.matriz));

        /*
            for ($k = 0; $k < $len - 1; $k++) {
                for ($i = 0; $i < $len; $i++) {
                    for ($j = 0; $j < $len; $j++) {
                        if ($dist[$i] > $dist[$j] + $matrix[$j][$i]) {
                            $dist[$i] = $dist[$j] + $matrix[$j][$i];
                        }
                    }
                }
            }
         */
        
        try {
            System.out.println("----- Matriz Recalculada -----");
            System.out.print("   A    B    C    D    E\n");
            matrizPrincipal.printMatrizRecalculada();
        } catch (Exception e) {
            System.err.println("ERRO AO IMPRIMIR MATRIZ RECALDULADA");
        }

    }

    public static boolean existirRotasIndefinidas(int[][] matriz) {

        int contador = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == Nodo.OO) {
                    contador++;
                }
            }
        }

        return contador > 0;

    }

    public static void isVizinho(int[][] matriz, int[][] matrizVizinhos) {
        
        System.out.println();
        System.out.println("----- Matriz de Vizinhos -----");
        System.out.println(" S = VIZINHO \n N = NAO VIZINHO");
        System.out.println();

        System.out.print("   A    B    C    D    E");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println();

            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == Nodo.OO) {
                    matrizVizinhos[i][j] = 1;
                } else {
                    matrizVizinhos[i][j] = 0;
                }

                if (j == 0) {
                    if (i == 0) {
                        System.out.print(matrizVizinhos[i][j] == 0 ? "A [S] " : "A [N] ");
                    } else if (i == 1) {
                        System.out.print(matrizVizinhos[i][j] == 0 ? "B [S] " : "B [N] ");
                    } else if (i == 2) {
                        System.out.print(matrizVizinhos[i][j] == 0 ? "C [S] " : "C [N] ");
                    } else if (i == 3) {
                        System.out.print(matrizVizinhos[i][j] == 0 ? "D [S] " : "D [N] ");
                    } else {
                        System.out.print(matrizVizinhos[i][j] == 0 ? "E [S] " : "E [N] ");
                    }
                } else {
                    System.out.print(matrizVizinhos[i][j] == 0 ? " [S] " : " [N] ");
                }

            }

        }
        System.out.println("\n\n");
    }
}