import javax.swing.*;
import java.lang.Math;
import java.util.Arrays;

class Vector {
  
  private int[] vectorA = new int[10];
  private int[] vectorB = new int[10];
  private int[] vectorC = new int[10];
  private char[] vectorD = new char[10];

  public void llenarVectorManualmente() {
    for (int i = 0; i < vectorA.length; ++i) {
      int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite un número:", "Vectores",JOptionPane.QUESTION_MESSAGE));
      vectorA[i] = num;
    }
  }
  
  public void llenarVectorAutomatico() {
    for (int i = 0; i < vectorB.length; ++i) {
       Double d1 = new Double(Math.random()*101);
       vectorB[i] = d1.intValue();
    }
    // Se hace 2 veces para que no se llenen con los mismos numeros.
    for (int j = 0; j < vectorC.length; ++j) {
       Double d2 = new Double(Math.random()*101);
       vectorC[j] = d2.intValue();
    }
  }
  
  public void llenarVectorLetras() {
    for (int i = 0; i < vectorD.length; ++i) {
      String s = JOptionPane.showInputDialog(null, "Digite una letra en mayúscula:", "Vectores",JOptionPane.QUESTION_MESSAGE);
      char letra = s.charAt(0);
      vectorD[i] = letra;
    }
  
  }
  
  public void llenarOrdenarVectorLetras() {
    Arrays.sort(vectorD);
    for (int k = 0; k < vectorD.length; ++k) {
      System.out.print(vectorD[k]+" | ");
    }
  
  }
  
  public void esCapicua() {
    int i = 0;
    int j = vectorD.length - 1;
    boolean x = true;
    while (i < j && x) {
      if (vectorD[i] == vectorD[j]) {
        ++i;
        --j;
      } else {
        JOptionPane.showMessageDialog(null, "No es capicúa" , "Vectores",JOptionPane.INFORMATION_MESSAGE);
        x = false;
      }
    }
    if (i >= j) {
      JOptionPane.showMessageDialog(null, "Es capicúa" , "Vectores",JOptionPane.INFORMATION_MESSAGE);
    }
  
  }
  
  public void unirVectores() {
    int vectorE [] = new int [vectorB.length+vectorC.length];
    int i = 0;
    while (i < vectorB.length || vectorC.length + i < vectorE.length) {
      vectorE[i] = vectorB[i];
      vectorE[vectorC.length+i] = vectorC[i];
      ++i;
    }
    mostrarVector(vectorE);
  
  }
  
  public void mostrarVector(int v[]) {
    for (int i = 0; i < v.length; ++i) {
      System.out.print(v[i]+" | ");
    }
  }
  
  // PREGUNTA OPCIONAL 1
  public void opc1 (int [] vec) {
    int contador = 0;
    for (int i = 0; i < vec.length; ++i) {
      for (int j = i + 1; j < vec.length; ++j) {
        if (vec[i] == vec[j] && vec[i] != -1) {
          ++contador;
          vec[j] = -1; // Si se usan numeros negativos se debe usar otra marca, podria ser null
        }
      }
    }
    int x = vec.length - contador;
    int [] vecR = new int [x];
    int y = 0;
    for (int k = 0; k < vec.length ; ++k) {
      if (vec[k] != -1) {
        vecR[y] = vec[k];
        ++y;
        System.out.print(vec[k]+" | ");
      }
    }
  }
  
  // PREGUNTA OPCIONAL 2
  public void opc2 (int [] vec) {
    int i = 0;
    int j = vec.length - 1;
    boolean x = true;
    while (i < j && x) {
      if (vec[i] == vec[j]) {
        ++i;
        --j;
      } else {
        JOptionPane.showMessageDialog(null, "No es capicúa" , "Vectores",JOptionPane.INFORMATION_MESSAGE);
        x = false;
      }
    }
    if (i >= j) {
      JOptionPane.showMessageDialog(null, "Es capicúa" , "Vectores",JOptionPane.INFORMATION_MESSAGE);
    }
  }
  
  public static void main (String [] args) {
    Vector v = new Vector();
    //v.llenarVectorManualmente();
    v.llenarVectorAutomatico();
    v.llenarVectorLetras();
    v.llenarOrdenarVectorLetras();
    v.esCapicua();
    v.unirVectores();
  }
}





