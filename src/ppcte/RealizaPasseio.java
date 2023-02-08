package ppcte;

/**
 *
 * @author Geam
 */
public class RealizaPasseio {

    final int Size = 8;
    int dx[] = {0, 2, 1, -1, -2, -2, -1, 1, 2};
    int dy[] = {0, 1, 2, 2, 1, -1, -2, -2, -1};
    int h[][]= new int[9][9];
    int n;
//----------------------------------------

    void Print() {
        /*int i, j;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                System.out.println(h[i][j]);
            }

        }*/
        System.out.println("===========================================");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (h[i][j] < 10) {
                    System.out.print(" ");
                }
                System.out.print(" ");
                System.out.print(h[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
//----------------------------------------

    public void TryNextMove(int i, int x, int y, boolean s) {
        Print();
        int u, v, k;
        boolean sucesso;
        k = 0;
        sucesso = false;
        do {
            k++;
            u = x + dx[k];
            v = y + dy[k];
            if (1 <= u && u <= n && 1 <= v && v <= n
                    && h[u][v] == 0) {
                h[u][v] = i;
                if (i < n * n) {
                    TryNextMove(i + 1, u, v, sucesso);
                    if (!sucesso) {
                        h[u][v] = 0;
                    }
                } else {
                    sucesso = true;
                }
            }
        } while (!sucesso && k < Size);
        s = sucesso;
    }

    public void executar() {
        int i, j;
        boolean q = false;
        System.out.println("Tamanho do tabuleiro (1-8): ");
        //cin >> n;
        n = 8;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                h[i][j] = 0;
            }
        }
        System.out.println("Posicao inicial do cavalo (x,y): ");
        i = 5;
        j = 5;
        h[i][j] = 1;
        TryNextMove(2, i, j, q);
        if (q) {
            Print();
        } else {
            System.out.println("Caminho nao encontrado" );
        }

    }
}
