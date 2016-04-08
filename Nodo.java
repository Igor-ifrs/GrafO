/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package bellmanford;

/**
 *
 * @author Bruno
 */
public class Nodo {

    public static final int OO = 99999;//infinito 
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    public static final int E = 4;

    public int[][] matriz;
    public int[][] novaMatriz;

    public Nodo(int posicoes) {
        matriz = new int[posicoes][posicoes];
    }

    public Nodo() {
    }

    public void inserirArco(int linha, int coluna, int peso) {

        matriz[linha][coluna] = peso;

    }

    public boolean isVizinho(int linha, int coluna) {

        if (matriz[linha][coluna] != OO) {
            return true;
        } else {
            return false;
        }

    }

    public int[][] retornaMatrizEspecifica(int[][] matrizCompleta, int linha) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == linha) {
                    matriz[i][j] = matrizCompleta[i][j];
                }
            }
        }

        completarMatriz(linha);

        return matriz;
    }

    public void completarMatriz(int linha) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 0) {
                    matriz[i][j] = Nodo.OO;
                }

                matriz[linha][linha] = 0;
            }
        }
    }

    public void printMatriz() throws Exception {

        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz.length; j++) {

                System.out.printf(matriz[i][j] == Nodo.OO ? " [OO]" : (matriz[i][j] < 10 ? (" [" + matriz[i][j] + " ]") : (" [" + matriz[i][j] + "]")));
            }
            System.out.printf("\n");
        }
    }

    public void printMatrizRecalculada() throws Exception {

        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz.length; j++) {

                if (j == 0) {
                    switch (i) {
                        case 0:
                            System.out.printf(matriz[i][j] == Nodo.OO ? "A [OO] " : ("A [" + matriz[i][j] + "] "));
                            break;
                        case 1:
                            System.out.printf(matriz[i][j] == Nodo.OO ? "B [OO] " : ("B [" + matriz[i][j] + "] "));
                            break;
                        case 2:
                            System.out.printf(matriz[i][j] == Nodo.OO ? "C [OO] " : ("C [" + matriz[i][j] + "] "));
                            break;
                        case 3:
                            System.out.printf(matriz[i][j] == Nodo.OO ? "D [OO] " : ("D [" + matriz[i][j] + "] "));
                            break;
                        case 4:
                            System.out.printf(matriz[i][j] == Nodo.OO ? "E [OO] " : ("E [" + matriz[i][j] + "] "));
                            break;
                    }
                } else {
                    System.out.printf(matriz[i][j] == Nodo.OO ? " [OO] " : (" [" + matriz[i][j] + "] "));
                }

            }
            System.out.printf("\n");
        }
    }

}
