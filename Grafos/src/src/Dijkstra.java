package src;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Dijkstra {

  public static void main(String args[]) {
    Calculo cl = new Calculo();
    JTextArea V = new JTextArea();
    String saida = "Nó \tA \tB \tC \tD\n";
    int c = 1;

    int nos, origem, i, j;
    Scanner in = new Scanner(System.in);

    System.out.print("Entre com o número de nós: ");
    nos = in.nextInt();
    Dijkstra d = new Dijkstra();

    System.out.println("Entre com a matriz: ");
    for (i = 1; i <= nos; i++) {
      saida += c++ + "\t";
      for (j = 1; j <= nos; j++) {
        d.custo[i][j] = in.nextInt();
        saida += d.custo[i][j] + "\t";
      }
      saida += "\n";
    }

    V.setText(saida);
    JOptionPane.showMessageDialog(null, V);

    System.out.print("Entre com o vértice de origem: ");
    origem = in.nextInt();
    d.calc(nos, origem);
    System.out.println("O Caminho mais curto da origem \t" + origem + "\n Todos os outros vertices : \n");
    for (i = 1; i <= nos; i++)
      if (i != origem)
        System.out.println("Origem :" + origem + "\t Destino :" + i + "\t Custo minimo é :" + d.distancia[i] + "\t");

    System.out.println("\nMatriz de custo");
    for (i = 0; i <= nos; i++) {
      for (j = 0; j <= nos; j++) {
        System.out.print(custo[i][j] + "\t");
      }
      System.out.println("");
    }
  }

  public int distancia[] = new int[10]; // Vetor das distâncias
  public static int custo[][] = new int[10][10]; // Matiz

  // Método que calcula a menor distância
  public void calc(int n, int origem) {
    int flag[] = new int[n + 1];
    int i, k, c, minimum;
    int minpos = 1;

    for (i = 1; i <= n; i++) {
      flag[i] = 0;
      this.distancia[i] = this.custo[origem][i];
    }
    c = 2;
    while (c <= n) {
      minimum = 99;
      for (k = 1; k <= n; k++) {
        if (this.distancia[k] < minimum && flag[k] != 1) {
          minimum = this.distancia[i];
          minpos = k;
        }
      }
      flag[minpos] = 1;
      c++;
      for (k = 1; k <= n; k++) {
        if (this.distancia[minpos] + this.custo[minpos][k] < this.distancia[k] && flag[k] != 1)
          this.distancia[k] = this.distancia[minpos] + this.custo[minpos][k];
      }
    }
  }

}
