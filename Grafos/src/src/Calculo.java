package src;

public class Calculo {

    public int distancia[] = new int[10]; // Vetor das distâncias
    public static int custo[][] = new int[10][10]; // Matiz

    public int[] getDistancia() {
        return distancia;
    }

    public void setDistancia(int[] distancia) {
        this.distancia = distancia;
    }

    public static int[][] getCusto() {
        return custo;
    }

    public static void setCusto(int[][] custo) {
        Calculo.custo = custo;
    }

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
