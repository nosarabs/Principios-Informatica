import javax.swing.*;
import java.lang.Math;

class Tutoria {


  public void maxMin () {
    int max;
    int min;

     int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el primer número:", "Algoritmos Generales",JOptionPane.QUESTION_MESSAGE));
     int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Primer Número: " + num1 + "\n\nDigite el segundo número:", "Algoritmos Generales",JOptionPane.QUESTION_MESSAGE));
     int num3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Primer Número: " + num1 + "\nSegundo Número: " + num2 + "\n\nDigite el tercer número:", "Algoritmos Generales",JOptionPane.QUESTION_MESSAGE));

     min = num3;
     if (num1 > num2) {
       max = num1;
       if (num2 < min) {
         min = num2;
       }
     } else {
       max = num2;
       min = num1;
     }
     if (num3 > max) {
       max = num3;
     }

     JOptionPane.showMessageDialog(null, "Primer Número: " + num1 + "\nSegundo Número: " + num2 + "\nTercer Número: "+ num3 +"\n\n Mínimo: "+ min +"\n\n Máximo: "+ max , "Algoritmos Generales",JOptionPane.INFORMATION_MESSAGE);
  }

  public void monto () {
    int mb = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el Monto Bruto:", "Algoritmos Generales",JOptionPane.QUESTION_MESSAGE));
    int mn = mb;

    if (mb >= 25000) {
      mn -= mb * 0.15;
    }

    JOptionPane.showMessageDialog(null, "Monto Neto: "+ mn , "Algoritmos Generales",JOptionPane.INFORMATION_MESSAGE);
  }

  public void primo () {
    boolean es = true;
    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite un número:", "Algoritmos Generales",JOptionPane.QUESTION_MESSAGE));

    if (num > 0) {
      for (int i = 2; i <= Math.ceil(Math.sqrt(num)); ++i) {
        if (num % i == 0) {
          JOptionPane.showMessageDialog(null, num + " no es primo", "Algoritmos Generales",JOptionPane.INFORMATION_MESSAGE);
          es = false;
        }
      }
      if (es) {
        JOptionPane.showMessageDialog(null, num + " sí es primo", "Algoritmos Generales",JOptionPane.INFORMATION_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(null, "¡El número debe ser mayor a 0!", "Algoritmos Generales",JOptionPane.WARNING_MESSAGE);
    }
  }

  public void calcula () {
    double segundos = 3700;
    JOptionPane.showMessageDialog(null, "Segundos a Convertir: "+ segundos , "Algoritmos Generales",JOptionPane.INFORMATION_MESSAGE);

    double minutos = segundos / 60;
    double horas = Math.floor(minutos % 60);


    minutos -= Math.floor(minutos);
    minutos *= 60;


    double segs = minutos - Math.floor(minutos);
    segs *= 60;

    JOptionPane.showMessageDialog(null, "Horas: "+ horas + "\nMinutos: " + Math.floor(minutos)+"\nSegundos: " + Math.floor(segs) , "Algoritmos Generales",JOptionPane.INFORMATION_MESSAGE);
  }


  // PARTE 3: VECTORES

  public int[] creaVec (int tam, boolean vacio) {
    int[] vec = new int[tam];

    for (int i = 0; i < tam; ++i) {
       Double d = new Double(Math.random()*10);
       vec[i] = d.intValue();
        if (vacio) {
          vec[i] = 0;
        }
     }
    return vec;
  }

  public void imprimirVec (int[] vec) {
    for (int i = 0; i < vec.length; ++i) {
      System.out.print(vec[i]+" | ");
    }
  }

  public int cantidad (int[] vec, int numero) {
    imprimirVec(vec);


    int contador = 0;

    for (int i = 0; i < vec.length; ++i) {

      if (vec[i] == numero) {
        ++contador;
      }
    }

    if (contador == 1) {
      JOptionPane.showMessageDialog(null, "El número "+ numero + " aparece una vez." , "Vectores",JOptionPane.INFORMATION_MESSAGE);
    } else {
    JOptionPane.showMessageDialog(null, "El número "+ numero + " aparece "+ contador + " veces." , "Vectores",JOptionPane.INFORMATION_MESSAGE);
    }
    return contador;
  }



  public int[] sumaVecs(int[] A, int[] B) {
    int tamC = Math.max(A.length, B.length);
    int C[] = creaVec(tamC, true);

    int i;
    for (i = 0; i < Math.min(A.length, B.length); ++i) {
      C[i] = A[i]+B[i];
    }

    if (A.length > B.length) {
      while (i < tamC) {
        C[i] = A[i];
        ++i;
      }
    } else {
      while (i < tamC) {
        C[i] = B[i];
        ++i;
      }
    }
    return C;
  }

  public void almacenar() {
    int[] vec = new int[10];
    int contador = 0;
    for (int i = 0; i < vec.length; ++i) {
      int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite un número:", "Vectores",JOptionPane.QUESTION_MESSAGE));
      vec[i] = num;
      contador += num;
    }
    JOptionPane.showMessageDialog(null, "Suma: "+ contador, "Vectores",JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, "Promedio: "+ (contador)/10, "Vectores",JOptionPane.INFORMATION_MESSAGE);
  }

  public void existe (int[] vec, int num) {
    boolean esta = false;
    int i = 0;

    while (i < vec.length && !esta) {
      if (vec[i] == num) {
        esta = true;
      }
      ++i;
    }

    if (esta) {
      JOptionPane.showMessageDialog(null, "El número "+ num + " sí aparece en el vector." , "Vectores",JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "El número "+ num + " no aparece en el vector." , "Vectores",JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void pares (int[] vec) {
    int contador = 0;
    for (int i = 0; i < vec.length; ++i) {
      if (vec[i] % 2 == 0) {
        ++contador;
      }
    }
  }

  public void concatenar(int [] v1, int [] v2) {
    int v3 [] = new int [v1.length+v2.length];
    int i = 0;
    while (i < v1.length || v2.length + i < v3.length) {
      v3[i] = v1[i];
      v3[v2.length+i] = v2[i];
      ++i;
    }
    for (int j = 0; j < v3.length; ++j) {
      System.out.print(v3[j]+" | ");
    }
  }

  public void ocurrencias (int [] vec) {
    int [] aux = new int [vec.length];
    int contador = 0;
    for (int i = 0; i < vec.length; ++i) {
      for (int j = 0; j < vec.length; ++j) {
        if (vec[i] == vec[j]) {
          ++contador;
        }
      }
      aux[i] = contador;
      contador = 0;
    }
    for (int k = 0; k < vec.length; ++k) {
      JOptionPane.showMessageDialog(null, vec[k]+" sale "+aux[k]+" veces." , "Vectores",JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public boolean esImpar(int num) {
    boolean es = true;
    if (num % 2 == 0) {
      es = false;
    }
    return es;
  }

  public void cantidadImpares(int vec[]) {
    int contador = 0;
    for (int i = 0; i < vec.length; ++i) {
      if (esImpar(vec[i])) {
        ++contador;
      }
    }
    if (contador == 1) {
      JOptionPane.showMessageDialog(null, "Solo hay un número impar en el vector." , "Vectores",JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Hay "+contador+" números impares en el vector." , "Vectores",JOptionPane.INFORMATION_MESSAGE);
    }
  }

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

  public void opc3 (int [] vec, int pos) {
    if (pos > vec.length - 1) {
      JOptionPane.showMessageDialog(null, "Posición Inválida" , "Vectores",JOptionPane.ERROR_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "El número en la posición "+pos+ " es "+vec[pos], "Vectores",JOptionPane.INFORMATION_MESSAGE);
    }
  }

  // PARTE 4: MATRICES

  public int[][] creaMat (int fil,int col, boolean vacio) {
    int[][] mat = new int[fil][col];

    for (int i = 0; i < fil; ++i) {
      for (int j = 0; j < col; ++j ) {
        Double d = new Double(Math.random()*10);
        mat[i][j] = d.intValue();
         if (vacio) {
          mat[i][j] = 0;
         }
       }
     }
    return mat;
  }

  public void imprimirMat (int[][] mat) {
    for (int i = 0; i < mat.length; ++i) {
      System.out.println();
      for (int j = 0; j < mat[i].length; ++j) {
        System.out.print(mat[i][j]+" | ");
      }
    }
    System.out.println();
  }

  public void invertir(int[][] mat) {
    int fil = mat.length;
    int col = mat[0].length;
    int[][] nuevaMat = creaMat(col,fil, true);

    for (int i = 0; i < col; ++i) {
      for (int j = 0; j < fil; ++j ) {
      nuevaMat[i][j]=mat[j][i];
      }
    }
    imprimirMat(nuevaMat);
  }

  public void suma (int[][] mat) {
    int contador = 0;
    int fil = mat.length;
    int col = mat[0].length;

    if (fil != col) {
      JOptionPane.showMessageDialog(null, "¡La matriz debe ser cuadrada!", "Matrices",JOptionPane.WARNING_MESSAGE);
    } else {

      for (int i = 0; i < fil; ++i) {
        for (int j = i; j < col; ++j ) {

          contador += mat[j][i];
        }
      }
      JOptionPane.showMessageDialog(null, "La suma total de los números que estan por debajo de la diagonal: "+contador , "Matrices",JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void triangularSup (int[][] mat) {
    int contador = 0;
    int fil = mat.length;
    int col = mat[0].length;

    if (fil != col) {
      JOptionPane.showMessageDialog(null, "¡La matriz debe ser cuadrada!", "Matrices",JOptionPane.WARNING_MESSAGE);
    } else {
      boolean es = true;
      for (int i = 0; i < fil; ++i) {
        for (int j = i+1; j < col; ++j ) {
          if (mat[j][i] != 0) {
            es = false;
          }
        }
      }
      if (!es) {
      JOptionPane.showMessageDialog(null, "No es triangular superior ", "Matrices",JOptionPane.INFORMATION_MESSAGE);
      } else {
       JOptionPane.showMessageDialog(null, "Sí es triangular superior ", "Matrices",JOptionPane.INFORMATION_MESSAGE);
      }
    }
  }

  public void sumaDiag (int[][] mat) {
    int fil = mat.length;
    int col = mat[0].length;

    if (fil != col) {
      JOptionPane.showMessageDialog(null, "¡La matriz debe ser cuadrada!", "Matrices",JOptionPane.WARNING_MESSAGE);
    } else {
      int suma = 0;
      for (int i = 0; i < fil; ++i) {
        suma += mat[i][i];
      }
      JOptionPane.showMessageDialog(null, "Suma de la diagonal es "+suma , "Matrices",JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void mayor (int[][] mat) {
    int fil = mat.length;
    int col = mat[0].length;
    int mayor = 0;
    int posi = 0;
    int posj = 0;

    for (int i = 0; i < fil; ++i) {
        for (int j = 0; j < col; ++j ) {
          if(mat[i][j] > mayor) {
            mayor = mat[i][j];
            posi = i;
            posj = j;
          }
        }
     }
    JOptionPane.showMessageDialog(null, "El mayor valor es "+mat[posi][posj]+" y se encuentra en la fila "+posi +", columna "+posj , "Matrices",JOptionPane.INFORMATION_MESSAGE);
  }

  public int sumaTotal(int[][] mat) {
    int contador = 0;
    int fil = mat.length;
    int col = mat[0].length;

    for (int i = 0; i < fil; ++i) {
        for (int j = 0; j < col; ++j ) {
          contador += mat[i][j];
        }
     }
    JOptionPane.showMessageDialog(null, "La suma total de los números de la matriz es: "+contador , "Matrices",JOptionPane.INFORMATION_MESSAGE);

    return contador;
  }

   public void positiva(int[][] mat) {
    boolean es = true;
    int fil = mat.length;
    int col = mat[0].length;

    for (int i = 0; i < fil; ++i) {
        for (int j = 0; j < col; ++j ) {
          if (mat[i][j] < 0) {
            es = false;
          }
        }
     }

    if (es) {
      JOptionPane.showMessageDialog(null, "La matriz es positiva." , "Matrices",JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void negativa(int[][] mat) {
    boolean es = true;
    int fil = mat.length;
    int col = mat[0].length;

    for (int i = 0; i < fil; ++i) {
        for (int j = 0; j < col; ++j ) {
          if (mat[i][j] <= 0) {
            es = false;
          }
        }
     }

    if (!es) {
      JOptionPane.showMessageDialog(null, "La matriz es negativa." , "Matrices",JOptionPane.INFORMATION_MESSAGE);
    }
  }



  public static void main(String[] args) {
    Tutoria x = new Tutoria();

    //x.maxMin();
    //x.monto();
    //x.primo();
    //x.calcula();

      int[] vecPrueba1 = x.creaVec(10,false);
      int w[] = {1,2,3,2,1};;
      x.opc3(w, 1);

    //x.concatenar(vecPrueba1,vecPrueba2);

    //x.cantidad(vecPrueba, 2);

    //int[]A = x.creaVec(5,false);
    //int[]B = x.creaVec(8,false);
    //int[]C = x.sumaVecs(A,B);

    //x.imprimirVec(A);
    //System.out.println();
    //x.imprimirVec(B);
    //System.out.println();
    //x.imprimirVec(C);

    //x.almacenar();
    //x.existe(vecPrueba, 2);
    //x.cantidadImpares(vecPrueba);

    //int[][] matPrueba = x.creaMat(3,3,true);


    //x.invertir(matPrueba);
    //x.triangularSup(matPrueba);
    //x.mayor(matPrueba);
    //x.sumaTotal(matPrueba);
    //matPrueba[0][0] = -2;

    //x.imprimirMat(matPrueba);

    //x.positiva(matPrueba);

    //x.negativa(matPrueba);
  }
}
