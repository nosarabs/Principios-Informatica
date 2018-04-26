import javax.swing.*;
import java.util.Random;

public class Juego {

  private int[][] tablero = new int[5][5];

  Juego() {
    llenar(tablero);
    // Descomentar para probar
    //print(tablero);
  }

  public void llenar(int[][] mat) {
    for (int i = 0; i < mat.length; ++i) {
      for (int j = 0; j < mat[0].length; ++j) {
        int d1 = (int)(Math.random()*11);
        tablero[i][j] = d1;
      }
    }
  }

  public void print(int[][] mat) {
    for (int i = 0; i < mat.length; ++i) {
      System.out.println();
      for (int j = 0; j < mat[0].length; ++j) {
        System.out.print(mat[i][j]+" | ");
      }
    }
    System.out.println();
  }

  public void jugar() {
    int aciertos = 0;
    int fallos = 0;
    int intentos = 10;

    while (intentos > 0) {
      String par = JOptionPane.showInputDialog(null, "Ingresar la fila y la columna: \nEjemplo: 2, 5", "Juego", JOptionPane.PLAIN_MESSAGE);
      int f = Character.getNumericValue((par.charAt(0)));
      int c = Character.getNumericValue((par.charAt(3)));
      if (f > 5 || f < 1 || c > 5 || c < 1) {
        JOptionPane.showMessageDialog(null, "Posicion Invalida \nPosiciones Validas entre 1 y 5.", "ERROR DE CAPA 8", JOptionPane.ERROR_MESSAGE);
      } else {
        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Posicion Seleccionada \nFila: "+f+" | Columna: "+c+"\n\n Adivine el valor en esta posicion: ", "Juego", JOptionPane.PLAIN_MESSAGE));
        if (tablero[f-1][c-1] == x) {
          JOptionPane.showMessageDialog(null, "Felicidades Acerto", "Juego", JOptionPane.INFORMATION_MESSAGE);
          ++aciertos;
        } else {
          JOptionPane.showMessageDialog(null, "Intento Fallido", "Juego", JOptionPane.INFORMATION_MESSAGE);
          ++fallos;
        }
      --intentos;
      }
    }
    JOptionPane.showMessageDialog(null, "Aciertos: "+aciertos+"\nFallos: "+fallos, "Juego", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void main(String args[]) {
      Juego j = new Juego();
      j.jugar();
  }
}
