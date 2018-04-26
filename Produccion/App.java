import javax.swing.*;

class App {
  
  Producto produ;
  Pedido ped;
  
  App() {
    
    int anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año actual:", "Fecha de Formalización",JOptionPane.QUESTION_MESSAGE));
    int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de mes actual:", "Fecha de Formalización",JOptionPane.QUESTION_MESSAGE));
    int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia actual:", "Fecha de Formalización",JOptionPane.QUESTION_MESSAGE));
    if (anio < 2018 || mes > 12 || mes < 1 || dia > 31 || dia < 1 ) {
      JOptionPane.showMessageDialog(null, "Datos Invalidos" , "Fecha de Formalización",JOptionPane.ERROR_MESSAGE);
    }
    produ = new Producto();
    ped = new Pedido();
  }

  public void controlador() {
    
    produ.costo();
    ped.pago();
    ped.estado();
    
  }

public static void main (String [] args) {
   App a = new App();
   a.controlador();
  }
}