import javax.swing.*;

public class App {

  class Estudiante {
    private String nombre = "x";
    private String apellido1 = "x";
    private String apellido2 = "x";
    private int cedula = -1;
    private int notaFinal = -1;
    private String estado = "x";

    public void setNombre (String n) {
      this.nombre = n;
    }
    public void setApellido1 (String a1) {
      this.apellido1 = a1;
    }
    public void setApellido2 (String a2) {
      this.apellido1 = a2;
    }
    public void setCed (int c) {
      this.cedula = c;
    }
    public void setNota (int n) {
      this.notaFinal = n;
    }
    public void setEstado () {
      if (this.notaFinal >= 70) {
        this.estado = "aprobado";
      }
      if (this.notaFinal >= 60 && this.notaFinal < 70) {
        this.estado = "ampliacion";
      }
      if (this.notaFinal < 60) {
        this.estado = "reprobado";
      }
    }

    public int getCed () {
      return this.cedula;
    }
    public String getEstado () {
      return this.estado;
    }
    public int getNF () {
      return this.notaFinal;
    }
  }

  private int cantidadE = 0;
  private Estudiante [] baseDatos = new Estudiante[100];

  public void nuevoE () {
    Estudiante e = new Estudiante();
    e.setNombre(JOptionPane.showInputDialog(null, "Ingresar el nombre del estudiante:", "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE));
    e.setApellido1(JOptionPane.showInputDialog(null, "Ingresar el primer apellido del estudiante:", "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE));
    e.setApellido2(JOptionPane.showInputDialog(null, "Ingresar el segundo apellido del estudiante:", "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE));
    e.setCed(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar el numero de cedula:", "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE)));
    e.setNota(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar la nota:", "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE)));
    e.setEstado();
    baseDatos[this.cantidadE] = e;
    ++this.cantidadE;
  }

  //busqueda por cedula (bxC)
  public int bxC (int numC) {
    int i = -1;
    if (cantidadE >= 1) {
      i = 0;
      int ced = baseDatos[i].getCed();
      while (ced != numC && i < baseDatos.length-1 && baseDatos[i+1] != null) {
        ++i;
        ced = baseDatos[i].getCed();
      }
      if (ced != numC) {
        i = -1;
      }
    }
    return i;
  }

  public void ui () {
    Object[] ops1 = { "Profesor", "Estudiante"};
    String x = "Profesor";
    Object sel1 = JOptionPane.showInputDialog(null, "Ingresar como:", "Sistema de Notas", JOptionPane.QUESTION_MESSAGE, null, ops1, x);
    if (sel1 == "Estudiante") {
      int ced = Integer.parseInt(JOptionPane.showInputDialog(null, "Consultar Nota \n\nIngresar su numero de cedula:", "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE));
      int i = bxC(ced);
      if (i == -1) {
        JOptionPane.showMessageDialog(null, "Cedula Inexistente", "Sistema de Notas", JOptionPane.ERROR_MESSAGE);
      } else {
        int nf = baseDatos[i].getNF();
        String e = baseDatos[i].getEstado();
        JOptionPane.showMessageDialog(null, "Nota Final: "+nf+ "\nEstado: "+ e, "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE);
      }
      ui();
    }
    if (sel1 == "Profesor") {
      Object[] ops2 = { "Nuevo Estudiante", "Asignar Nota", "Generar Estadisticas"};
      String y = "Nuevo Estudiante";
      Object sel2 = JOptionPane.showInputDialog(null, "Que desea hacer: ", "Sistema de Notas", JOptionPane.QUESTION_MESSAGE, null, ops2, y);
      if (sel2 == "Nuevo Estudiante") {
        nuevoE( );
        JOptionPane.showMessageDialog(null, "Estudiate Guardado", "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE);
        ui();
      }
      if (sel2 == "Asignar Nota") {
        int ced = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar numero de cedula del estudiante:", "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE));
        int i = bxC(ced);
        if (i == -1) {
          JOptionPane.showMessageDialog(null, "Cedula Inexistente", "Sistema de Notas", JOptionPane.ERROR_MESSAGE);
        } else {
          int nf = Integer.parseInt(JOptionPane.showInputDialog(null, "Asignar Nota:", "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE));
          baseDatos[i].setNota(nf);
          JOptionPane.showMessageDialog(null, "Nota Guardada", "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE);
        }
        ui();
      }
      if (sel2 == "Generar Estadisticas") {
        if (cantidadE >= 1) {
          int a = 0;
          int ampli = 0;
          int re = 0;
          int pa = 0;
          int pg = 0;

          for (int i = 0; i < cantidadE; ++i) {
            pg += baseDatos[i].getNF();
            if (baseDatos[i].getEstado() == "aprobado") {
              ++a;
              pa += baseDatos[i].getNF();
            }
            if (baseDatos[i].getEstado() == "reprobado") {
              ++re;
            }
            if (baseDatos[i].getEstado() == "ampliacion") {
              ++ampli;
            }
          }
          pa = pa/a;
          pg = pg/cantidadE;
          JOptionPane.showMessageDialog(null, "Estadisticas \n\nEstudiantes Totales: "+cantidadE+"\nEstudiantes Aprobados: "+a+"\nEstudiantes en Ampliacion: "+ampli+"\nEstudiantes Reprobados: "+re+"\nNota Promedio de Aprobados: "+pa+"\nNota Promedio General: "+pg, "Sistema de Notas", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "No hay estudiantes registrados", "Sistema de Notas", JOptionPane.WARNING_MESSAGE);
        }
        ui();
      }
    }
  }

  public static void main(String args[]) {
      App a = new App();
      a.ui();
  }
}
