import javax.swing.*;

class Pedido {

  public void pago() {
    Object[] selectionValues1 = { "Un solo pago", "Varios pagos"};
    String initialSelection1 = "Un solo pago";
    Object selection1 = JOptionPane.showInputDialog(null, "Cantidad de Pagos?", "Pago Pedido", JOptionPane.QUESTION_MESSAGE, null, selectionValues1, initialSelection1);
    
    Object[] selectionValues2 = { "Tarjeta", "Ejectivo", "Cheque" };
    String initialSelection2 = "Tarjeta";
    Object selection2 = JOptionPane.showInputDialog(null, "Forma de Pago?", "Pago Pedido", JOptionPane.QUESTION_MESSAGE, null, selectionValues2, initialSelection2);
    int opc = 1;
    if (selection2 == "Efectivo") {
      opc = 2;
    }
    if (selection2 == "Cheque") {
      opc = 3;
    }
        String monthString;
        switch (opc) {
            case 1: // Tarjeta 
              int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de caducidad:"));
              int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de mes de caducidad:"));
              int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de caducidad:"));
              if (anio < 2018 || mes > 12 || mes < 1 || dia > 31 || dia < 1 ) {
                JOptionPane.showMessageDialog(null, "Datos Invalidos" , "Pago Pedido",JOptionPane.ERROR_MESSAGE);
              }
              int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la tarjeta:"));
              
              Object[] selectionValues3 = { "VISA", "Mastercard"};
              String initialSelection3 = "VISA";
              Object selection3 = JOptionPane.showInputDialog(null, "Tipo de Tarjeta?", "Pago Pedido", JOptionPane.QUESTION_MESSAGE, null, selectionValues3, initialSelection3);
                     break;
                     
            case 2: // Efectivo
              Object[] selectionValues4 = { "Colones", "Dolares", "Euros"};
              String initialSelection4 = "Colones";
              Object selection4 = JOptionPane.showInputDialog(null, "Tipo de Moneda?", "Pago Pedido", JOptionPane.QUESTION_MESSAGE, null, selectionValues4, initialSelection4);
             
                     break;
            case 3: // Cheque
              String nombre = JOptionPane.showInputDialog("Ingrese su nombre completo:");
              Object[] selectionValues5 = { "Banco Nacional", "Banco de Costa Rica", "Scotiabank", "Otro"};
              String initialSelection5 = "Banco Nacional";
              Object selection5 = JOptionPane.showInputDialog(null, "Entidad Bancaria?", "Pago Pedido", JOptionPane.QUESTION_MESSAGE, null, selectionValues5, initialSelection5);
              if (selection5 == "Otro") {
                String banco = JOptionPane.showInputDialog("Ingrese el nombre de su entidad bancaria:");
              }
                     break;
        }
        
    }
  
  public void estado() {
    Object[] selectionValues = { "Pendiente", "Pagado", "Procesando", "Enviado", "Entregado"};
    String initialSelection = "Pendiente";
    Object selection = JOptionPane.showInputDialog(null, "Seleccione el estado del pedido.", "Estado Pedido", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
  }

}