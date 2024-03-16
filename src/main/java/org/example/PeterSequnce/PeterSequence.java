package org.example.PeterSequnce;

public class PeterSequence {

    /*
progresion de peter
a peter se le dan 2 Strings y necesita completar la progresion comun la cual es una sub secuencia que conserva el orden originalpero los caracteres no necesitan estar uno junto al otro
toma como entrada 4 lineas, la primera linea es un entero que indica el largo del primer String, la segunda linea es un entero que indica el largo del segundo String, la tercera linea contiene el primer string y la cuarta linea contiene el segundo string
Ejemplo de entrada y salida
Entra:
6
6
CORTAN
FLODRA
salida
3
 ya que ORA es comun en ambos string
implementarlo en java
    * */

    public static void main(String[] args) {
        String str1 = "CORTANNANA";
        String str2 = "FLODRAN";

        System.out.println(longitudProgresionComun(str1, str2, str1.length(), str2.length()));
    }

    private static int longitudProgresionComun(String str1, String str2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        System.out.println("Initial dp: " );
        printMatrix(dp);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    System.out.println("");
                    System.out.println("i: "+i+" j: "+j+" char1: "+str1.charAt(i - 1)+" char2: "+str2.charAt(j - 1));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    System.out.println("");
                    System.out.println("i: "+i+" j: "+j+" char1: "+str1.charAt(i - 1)+" char2: "+str2.charAt(j - 1));
                }
                printMatrix(dp);
            }
        }

        return dp[m][n];
    }

    static void printMatrix(int[][] dp){
        System.out.println("");
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
