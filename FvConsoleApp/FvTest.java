
import java.io.*;

/**
 *
 * @author : david.tobing
 * @Program : Test Pemograman
 */
class FvTest {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\n\nSilahkan Masukkan Panjang Matrix : ");
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 0) {
            System.out.println("Maaf, Silahkan Masukkan Bilangan Ganjil!");

        } else if (n == 1) {
            System.out.println("Maaf, Silahkan Masukkan Bilangan Ganjil! Selain 1!!");

        } else {
            
            // membuat magic matrix
            // dengan variabel A, dimana variable n sebagai panjang row dan column
            int A[][] = new int[n][n];
            
            // membuat variabel pada koordinat x, y dan z
            int x, y, z;

            // cell pada matrix dimulai dari titik 0
            for (x = 0; x < n; x++) {
                for (y = 0; y < n; y++) {
                    A[x][y] = 0;
                }
            }

            // rumusan pada variabel x, y dan z
            x = 0;
            y = n / 2;
            z = 1;

            // mendapatkan nilai dari variabel x, y, dan z yang menghasilkan nilai dari variable A 
            // dengan rumusan diatas dan besar matrix yg di input
            while (z <= n * n) {
                A[x][y] = z++;
                x--;
                y++;

                // mengkondisikan elemen pada x-y / atas-kanan
                if (x < 0 && y > n - 1) {
                    x = x + 2;
                    y--;
                }

                // membungkus variabel x / row
                if (x < 0) {
                    x = n - 1;
                }

                // membungkus variable y / column
                if (y > n - 1) {
                    y = 0;
                }

                // mengkondisikan variable A pada koordinat x dan y
                if (A[x][y] > 0) {
                    x = x + 2;
                    y--;
                }
            }
            
            /* 
            * Output magic matrix
            */
            System.out.println("Panjang Dari Matrix " + n + " x " + n + " menghasilkan:");
            for (x = 0; x < n; x++) {
                for (y = 0; y < n; y++) {
                    System.out.print(A[x][y] + "\t");
                }
                System.out.println();
            }
        }
    }
}
