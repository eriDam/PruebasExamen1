//ExamenTipo1 Pruebas mias
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;



public class ExamenE extends JFrame {

	private JPanel contentPane;
	private JTextField campotxIntroIng;
	private JTextField campotxIntroGasto;
	private JTextField campoTxtTotal;
	private JLabel numIngr;
	private JLabel numGast;
	
	//Se creará un atributo privado que será un array de 10 float para almacenar los ingresos.
	//Se creará un atributo privado que almacenará el número de ingresos introducidos.
	 private int ingIntrod=0;
	 private float ingresos[]=new float [10]; 
	
	//Se creará un atributo privado que será un array de 10 float para almacenar los gastos.
	//Se creará un atributo privado que almacenará el número de gastos introducidos.

	private int gastoIntrod=0;
	private float gastos[]=new float [10];
	/**
	 * Create the frame.
	 */
	public ExamenE() {
		setTitle("AppExamen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Crea las etiquetas
		JLabel etIntroIng = new JLabel("Introducir ingreso");
		etIntroIng.setBounds(32, 15, 118, 14);
		contentPane.add(etIntroIng);
		
		JLabel etIntroGasto = new JLabel("Introducir gasto");
		etIntroGasto.setBounds(32, 52, 118, 14);
		contentPane.add(etIntroGasto);
		
		JLabel etIngIntro = new JLabel("Ingresos introducidos");
		etIngIntro.setBounds(32, 106, 138, 14);
		contentPane.add(etIngIntro);
		
		JLabel etGastIntro = new JLabel("Gastos introducidos");
		etGastIntro.setBounds(32, 131, 138, 14);
		contentPane.add(etGastIntro);
		
		//Crea los botones
		//Boton Total
		JButton btnCalcTotal = new JButton("Calcular Total");
		btnCalcTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			//Creo las variables para almacenar datos
			 float totalIngresos = 0;
			 float totalGastos = 0;
			 float total;
			 //sumo el primer array ingresos
			 for(int i=0;i<ingresos.length;i++) {
				 totalIngresos+=ingresos[i];
				 }
			 for(int g=0;g<gastos.length;g++){
				 totalGastos+=gastos[g];
			 }
			  total= totalIngresos-totalGastos;
			  
			  String tTotal=String.valueOf(total);
			  campoTxtTotal.setText(tTotal);
			  JOptionPane.showMessageDialog(null,"Saldo: "+total);
			  
			}
		
		});
		
		btnCalcTotal.setBounds(42, 156, 360, 23);
		contentPane.add(btnCalcTotal);
	
		
		//Boton guardar ingreso
		
		JButton btnGuardarI = new JButton("Guardar Ingreso");
		//metodo de escucha y accion procesa los eventos de campo de texto
		btnGuardarI.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//todo el codigo a ejecutar dentro de try para q lo intente y catch captura si hay excepción
				try{
				//Se comprobará que no hay más ingresos de 10
				if(ingIntrod<10){
				
				//guardo en el array el texto campotxIntroIng  convertido a float
				ingresos[ingIntrod]=Float.parseFloat(campotxIntroIng.getText());			
				//Voy imprimiendo x consola a ver
				System.out.println("Número de ingreso: "+ingIntrod+ " introducido en caja con un valor de  "+ingresos[ingIntrod]);
				/*Muestro un mensaje en pantalla en otra ventana para q informe del gasto almacenado . 
				Lo dejo comentado para q no salte cada vez
				//JOptionPane.showMessageDialog(null,"Número de ingreso: "+ingIntrod+ " introducido en caja con un valor de  "+ingresos[ingIntrod]); 
				*/
				//aumento en uno la posicion del array
				ingIntrod++;
				//este numIngr vale la variable ingIntrod convertida a String para mostrarlo en pantalla
				numIngr.setText(String.valueOf(ingIntrod));	
				campotxIntroIng.setText("");
				}
				else//si se pasan de ingresos  muestro otra ventana
				JOptionPane.showMessageDialog(null, "Has superado el numero máximo de ingresos");
				//catch especifica entre parentesis 1 parametro d excepcion
				}catch ( NumberFormatException noNumber) { //ArithmeticException, ClassCastException, IndexOutOfBoundsException, NullPointerException
					//Si no se que excepcion quiero capturar pongo e 
			      JOptionPane.showMessageDialog (null,"¡¡ Fijate, has puesto algo que no es un número \n     o lo has dejado en blanco !!");	
				 }catch( ArrayIndexOutOfBoundsException excepExcederPos){
					 JOptionPane.showMessageDialog (null,"¡¡ Te has excedido en las posiciones !!");
				 }	
			}
		});

		btnGuardarI.setBounds(268, 15, 138, 23);
		contentPane.add(btnGuardarI);
		 
        
		
		
		//Boton Guardar Gastos
		
		JButton btnGuardarG = new JButton("Guardar Gasto");
		btnGuardarG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				//Cada vez que se apreta el botón “guardar gastos”: Se comprobará que no hay más gastos de 10
				if(gastoIntrod<10){
				//Si hay menos, se almacenará el nuevo gasto al final del array correspondiente y se incrementará el número de gastos.
				//guardo en el array el texto introducido en campotxIntroGasto  convertido a float
				 gastos[gastoIntrod]=Float.parseFloat(campotxIntroGasto.getText()); 
				
				 //Voy imprimiendo x consola a ver
				System.out.println("Número de Gasto: "+gastoIntrod+" introducido en caja con un valor de  "+gastos[gastoIntrod]);
							
				//Se actualizará la ventana con el valor de número de gastos.
				gastoIntrod++;
				//este texto vale la variable gastoIntrod convertida a String para mostrarlo en pantalla
				numGast.setText(String.valueOf(gastoIntrod));
				//EXTRA cuando el campo de texto sea introducido se pondra en blanco despues de guardar
				campotxIntroGasto.setText("");
				}else//si se pasan de gastos  muestro otra ventana
					JOptionPane.showMessageDialog(null, "Has superado el numero máximo de gastos");
				
				//cath especifica entre parentesis 1 parametro d excepcion
				}catch ( NumberFormatException noNumber) { //ArithmeticException, ClassCastException, IndexOutOfBoundsException, NullPointerException
					//Si no se que excepcion quiero capturar pongo e 
			      JOptionPane.showMessageDialog (null,"¡¡ Fijate, has puesto algo que no es un número \n     o lo has dejado en blanco !!");	
				 }catch( ArrayIndexOutOfBoundsException excepExcd){
					 JOptionPane.showMessageDialog (null,"¡¡ Te has excedido en las posiciones !!");
				 }			
			}
		});
		
		
		btnGuardarG.setBounds(268, 48, 138, 23);
		contentPane.add(btnGuardarG);
		
		
		//---------------------------------------------EXTRA PARA USAR LOS METODOS CREADOS-------------------------------------------
		//Botón para Imprimir gastos e ingresos -Me toma la pos 0 como primer ingreso pero a 0 sin guardar el ingreso
		  
		JButton btnImpI = new JButton("Imprimir Ingresos");
		btnImpI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			for(int i=0;i<ingresos.length;i++){
			JOptionPane.showMessageDialog(null,"Número de ingreso: "+i+ " introducido en caja con un valor de  "+ingresos[i]);
			
				//String cadena= (String.valueOf(ingresos));
				//ingIntrod=bf.readLine();//capturamos dato	
				
				
				//Para poder almacenar todo estos datos necesito concatenarlos
				//Guardar
				//escribir.println("Número de ingreso: "+i+ " introducido en caja con un valor de  "+ingresos[i]+cadena);
				//dato=bf.readLine();
				}
				//Despues del bucle importante cerrar el  flujo de archivos
				//listaIngresos.close();
				 
				}
		});
		btnImpI.setBounds(268, 97, 138, 23);
		contentPane.add(btnImpI);
		
		JButton btnImpGastos = new JButton("Imprimir Gastos");
		btnImpGastos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Quiero q saque una ventana en pantalla utilizando el método devolverIngresos NO VA alternativa 1 for
				//JOptionPane.showMessageDialog(null,"Número de Gastos: "+devolverGastos());
				for(int i=0;i<gastos.length;i++){
					
				JOptionPane.showMessageDialog(null,"Número de gasto: "+i+ " introducido en caja con un valor de  "+gastos[i]);
				}
				
			}
		});
		btnImpGastos.setBounds(268, 127, 138, 23);
		contentPane.add(btnImpGastos);
	
//--------------------------------------------------------------------------------------------------------------------------------------
		
		//Crea campos de texto
		campotxIntroIng = new JTextField();
		
		/*--------------------------------------------- EXTRA---------------------------------------------------------------------
		Creo el  ActionListener con el mismo código que el botón, ya q usuarios pueden pulsar enter y obviar boton guardar
		NO FUNCIONA, QUIZA SEA X ESTAR DUPLICADO	*/	
	
		campotxIntroIng.setBounds(139, 12, 100, 20);
		contentPane.add(campotxIntroIng);
		campotxIntroIng.setColumns(10);
		
		campotxIntroGasto = new JTextField();
		campotxIntroGasto.setBounds(139, 49, 100, 20);
		contentPane.add(campotxIntroGasto);
		campotxIntroGasto.setColumns(10);
		 
		numGast = new JLabel();
		numGast.setText("0");
		numGast.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		numGast.setBounds(244, 127, 24, 23);
		contentPane.add(numGast);
		
		campoTxtTotal = new JTextField();
		campoTxtTotal.setBounds(42, 190, 360, 20);
		contentPane.add(campoTxtTotal);
		campoTxtTotal.setColumns(10);
		campoTxtTotal.setEditable(false);//EXTRA está establecida en FALSE, NO permite que se pueda escribir sobre el JTextField,para q no m cambien las cuentas
		numIngr = new JLabel();
		numIngr.setText("0");
		numIngr.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		numIngr.setBounds(244, 103, 24, 20);
		contentPane.add(numIngr);
		
		JButton btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Component unComponente = null;
				int seleccion = JOptionPane.showOptionDialog(unComponente,"Seleccione opcion", "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,   // null para icono por defecto.
				new Object[] { "Gastos", "Ingresos", "?" },   // null para YES, NO y CANCEL
				"opcion 1");
						 
						if (seleccion != -1)
						   System.out.println("seleccionada opcion " + (seleccion + 1));
						
			}
		});
		btnOpciones.setBounds(184, 228, 89, 23);
		contentPane.add(btnOpciones);
	}
		
	//------------------------------------METODOS----------------------------------------------------------------------------
	
	
	//En la clase Examen se crearán los siguientes métodos:
	//------------------------------------------------------------------Metodo devolverIngresos: devolverá el array ingresos
	public float  devolverIngresos(){
    	for(int i=0;i<ingresos.length;i++){
    	//System.out.println("ingresos= "+ingresos[i]); 	
    	 
	}
		return ingIntrod;
	
	}
	//-----------------------------------Metodo devolverGastos: devolverá el array gastos------------------------------------
	public float devolverGastos(){
		/*for(int i=0;i<gastos.length;i++){
			
			JOptionPane.showMessageDialog(null,"Número de gasto: "+i+ " introducido en caja con un valor de  "+gastos[i]);
		}*/
		return gastoIntrod;
	}
	
	//------------------------------Metodo resetear: reseteará a 0 el array ingresos, gastos, número de ingresos y número de gastos.
   
    public void resetTotal(){
    	 
    	for(int i=0;i<ingresos.length;i++){
    		ingresos[i]=0;   		
    	}
    	for (int g=0;g<gastos.length;g++){
    		gastos[g]=0;
    	} 
    	numIngr.setText("0");
    	numGast.setText("0");
    	JOptionPane.showMessageDialog(null,"Número de Ingresos: "+ingIntrod+" \nNúmero de Gastos: "+gastoIntrod);
	    System.out.println("Número de Ingresos: "+ingIntrod+"\nNúmero de Gastos: "+gastoIntrod);
    }
}
    



