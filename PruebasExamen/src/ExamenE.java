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
	
	//Se crear� un atributo privado que ser� un array de 10 float para almacenar los ingresos.
	//Se crear� un atributo privado que almacenar� el n�mero de ingresos introducidos.
	 private int ingIntrod=0;
	 private float ingresos[]=new float [10]; 
	
	//Se crear� un atributo privado que ser� un array de 10 float para almacenar los gastos.
	//Se crear� un atributo privado que almacenar� el n�mero de gastos introducidos.

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
				//todo el codigo a ejecutar dentro de try para q lo intente y catch captura si hay excepci�n
				try{
				//Se comprobar� que no hay m�s ingresos de 10
				if(ingIntrod<10){
				
				//guardo en el array el texto campotxIntroIng  convertido a float
				ingresos[ingIntrod]=Float.parseFloat(campotxIntroIng.getText());			
				//Voy imprimiendo x consola a ver
				System.out.println("N�mero de ingreso: "+ingIntrod+ " introducido en caja con un valor de  "+ingresos[ingIntrod]);
				/*Muestro un mensaje en pantalla en otra ventana para q informe del gasto almacenado . 
				Lo dejo comentado para q no salte cada vez
				//JOptionPane.showMessageDialog(null,"N�mero de ingreso: "+ingIntrod+ " introducido en caja con un valor de  "+ingresos[ingIntrod]); 
				*/
				//aumento en uno la posicion del array
				ingIntrod++;
				//este numIngr vale la variable ingIntrod convertida a String para mostrarlo en pantalla
				numIngr.setText(String.valueOf(ingIntrod));	
				campotxIntroIng.setText("");
				}
				else//si se pasan de ingresos  muestro otra ventana
				JOptionPane.showMessageDialog(null, "Has superado el numero m�ximo de ingresos");
				//catch especifica entre parentesis 1 parametro d excepcion
				}catch ( NumberFormatException noNumber) { //ArithmeticException, ClassCastException, IndexOutOfBoundsException, NullPointerException
					//Si no se que excepcion quiero capturar pongo e 
			      JOptionPane.showMessageDialog (null,"�� Fijate, has puesto algo que no es un n�mero \n     o lo has dejado en blanco !!");	
				 }catch( ArrayIndexOutOfBoundsException excepExcederPos){
					 JOptionPane.showMessageDialog (null,"�� Te has excedido en las posiciones !!");
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
				//Cada vez que se apreta el bot�n �guardar gastos�: Se comprobar� que no hay m�s gastos de 10
				if(gastoIntrod<10){
				//Si hay menos, se almacenar� el nuevo gasto al final del array correspondiente y se incrementar� el n�mero de gastos.
				//guardo en el array el texto introducido en campotxIntroGasto  convertido a float
				 gastos[gastoIntrod]=Float.parseFloat(campotxIntroGasto.getText()); 
				
				 //Voy imprimiendo x consola a ver
				System.out.println("N�mero de Gasto: "+gastoIntrod+" introducido en caja con un valor de  "+gastos[gastoIntrod]);
							
				//Se actualizar� la ventana con el valor de n�mero de gastos.
				gastoIntrod++;
				//este texto vale la variable gastoIntrod convertida a String para mostrarlo en pantalla
				numGast.setText(String.valueOf(gastoIntrod));
				//EXTRA cuando el campo de texto sea introducido se pondra en blanco despues de guardar
				campotxIntroGasto.setText("");
				}else//si se pasan de gastos  muestro otra ventana
					JOptionPane.showMessageDialog(null, "Has superado el numero m�ximo de gastos");
				
				//cath especifica entre parentesis 1 parametro d excepcion
				}catch ( NumberFormatException noNumber) { //ArithmeticException, ClassCastException, IndexOutOfBoundsException, NullPointerException
					//Si no se que excepcion quiero capturar pongo e 
			      JOptionPane.showMessageDialog (null,"�� Fijate, has puesto algo que no es un n�mero \n     o lo has dejado en blanco !!");	
				 }catch( ArrayIndexOutOfBoundsException excepExcd){
					 JOptionPane.showMessageDialog (null,"�� Te has excedido en las posiciones !!");
				 }			
			}
		});
		
		
		btnGuardarG.setBounds(268, 48, 138, 23);
		contentPane.add(btnGuardarG);
		
		
		//---------------------------------------------EXTRA PARA USAR LOS METODOS CREADOS-------------------------------------------
		//Bot�n para Imprimir gastos e ingresos -Me toma la pos 0 como primer ingreso pero a 0 sin guardar el ingreso
		  
		JButton btnImpI = new JButton("Imprimir Ingresos");
		btnImpI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			for(int i=0;i<ingresos.length;i++){
			JOptionPane.showMessageDialog(null,"N�mero de ingreso: "+i+ " introducido en caja con un valor de  "+ingresos[i]);
			
				//String cadena= (String.valueOf(ingresos));
				//ingIntrod=bf.readLine();//capturamos dato	
				
				
				//Para poder almacenar todo estos datos necesito concatenarlos
				//Guardar
				//escribir.println("N�mero de ingreso: "+i+ " introducido en caja con un valor de  "+ingresos[i]+cadena);
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
				//Quiero q saque una ventana en pantalla utilizando el m�todo devolverIngresos NO VA alternativa 1 for
				//JOptionPane.showMessageDialog(null,"N�mero de Gastos: "+devolverGastos());
				for(int i=0;i<gastos.length;i++){
					
				JOptionPane.showMessageDialog(null,"N�mero de gasto: "+i+ " introducido en caja con un valor de  "+gastos[i]);
				}
				
			}
		});
		btnImpGastos.setBounds(268, 127, 138, 23);
		contentPane.add(btnImpGastos);
	
//--------------------------------------------------------------------------------------------------------------------------------------
		
		//Crea campos de texto
		campotxIntroIng = new JTextField();
		
		/*--------------------------------------------- EXTRA---------------------------------------------------------------------
		Creo el  ActionListener con el mismo c�digo que el bot�n, ya q usuarios pueden pulsar enter y obviar boton guardar
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
		campoTxtTotal.setEditable(false);//EXTRA est� establecida en FALSE, NO permite que se pueda escribir sobre el JTextField,para q no m cambien las cuentas
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
	
	
	//En la clase Examen se crear�n los siguientes m�todos:
	//------------------------------------------------------------------Metodo devolverIngresos: devolver� el array ingresos
	public float  devolverIngresos(){
    	for(int i=0;i<ingresos.length;i++){
    	//System.out.println("ingresos= "+ingresos[i]); 	
    	 
	}
		return ingIntrod;
	
	}
	//-----------------------------------Metodo devolverGastos: devolver� el array gastos------------------------------------
	public float devolverGastos(){
		/*for(int i=0;i<gastos.length;i++){
			
			JOptionPane.showMessageDialog(null,"N�mero de gasto: "+i+ " introducido en caja con un valor de  "+gastos[i]);
		}*/
		return gastoIntrod;
	}
	
	//------------------------------Metodo resetear: resetear� a 0 el array ingresos, gastos, n�mero de ingresos y n�mero de gastos.
   
    public void resetTotal(){
    	 
    	for(int i=0;i<ingresos.length;i++){
    		ingresos[i]=0;   		
    	}
    	for (int g=0;g<gastos.length;g++){
    		gastos[g]=0;
    	} 
    	numIngr.setText("0");
    	numGast.setText("0");
    	JOptionPane.showMessageDialog(null,"N�mero de Ingresos: "+ingIntrod+" \nN�mero de Gastos: "+gastoIntrod);
	    System.out.println("N�mero de Ingresos: "+ingIntrod+"\nN�mero de Gastos: "+gastoIntrod);
    }
}
    



