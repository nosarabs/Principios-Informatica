import javax.swing.*;

class Producto {

  private int cantidad = 0;
  private double impuesto = 0.0;
  private double precio = 0.0;
  private boolean existencia = false;
  
  Producto() {
    String nombre = JOptionPane.showInputDialog("Nombre del Producto:");
    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Productos:"));
    if (cantidad > 0) {
      existencia = true;
      JOptionPane.showMessageDialog(null, "Hay Productos Disponibles", "Producto",JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "No hay Productos Disponibles", "Producto",JOptionPane.INFORMATION_MESSAGE);
    }
    impuesto = Double.parseDouble(JOptionPane.showInputDialog("Porcentaje de Impuesto:"));
    precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
  
  }
  public void costo() {
    JOptionPane.showMessageDialog(null, "Costo total: " + (precio+(impuesto/100))*cantidad, "Producto",JOptionPane.INFORMATION_MESSAGE);
  }
  
}