//ExamenTipo1 Pruebas mias  
import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class Principal {
	  

		/**Codigo de Paco para lanzar la aplicación
			 * Launch the application.
			 */
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ExamenE frame = new ExamenE();
							frame.setVisible(true);
											
							
							 } catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			
			//Creo objeto de la clase examen para usar los metodos
			ExamenE e=new ExamenE();
			//Llamo a los metodos creados
			//Muestro en un mensaje en pantalla en otra ventana para q informe del gasto almacenado
			//Muestro en una ventana aparte el resultado de devolver ingresos y gastos
			e.devolverIngresos();
			e.devolverGastos();
			e.resetTotal();
				   
			}
			
			

}