package App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

public class Ventana extends JFrame{
	JPanel dPersonales;
	
	public static void main(String[] args) {
		
		Ventana v = new Ventana();

	}
	
	public Ventana() {
		super("Formulario de contacto");
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		dPersonales = new JPanel(new GridBagLayout());
		DatosPersonales();
		ProbarConexion();
		Tabla();
		Opciones();
		pack();
		this.setMinimumSize(this.getSize());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	void Opciones() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		Dimension d = new Dimension(100, 30);
		
		panel.add(CrearBoton("Ir", d));
		panel.add(CrearBoton("Guardar", d));
		panel.add(CrearBoton("Eliminar", d));
		panel.add(CrearBoton("Modificar", d));
		panel.add(CrearBoton("Limpiar", d));
		panel.add(CrearBoton("Salir", d));
		
		panel.setAlignmentX(CENTER_ALIGNMENT);
		this.getContentPane().add(panel);
	}
	
	JButton CrearBoton(String texto, Dimension d) {
		JButton boton = new JButton(texto);
		boton.setMinimumSize(d);
		boton.setPreferredSize(d);
		return boton;
	}
	
	void Tabla() {
		Dimension d = new Dimension(400, 100);
		Vector<Vector> fils = new Vector<Vector>();
		Vector<String> cols = new Vector<String>();
		
		cols.addElement("Nombre");
		cols.addElement("Apelido");
		cols.addElement("Email");
		cols.addElement("Celular");
		cols.addElement("Direccion");
		cols.addElement("Sexo");
		
		JTable tabla = new JTable(fils, cols);
		//tabla.setMinimumSize(new Dimension(500, 100));
		//tabla.setPreferredSize(new Dimension(500, 100));
		//tabla.setMaximumSize(new Dimension(500, 100));
		tabla.setPreferredScrollableViewportSize(d);
		JScrollPane sp = new JScrollPane(tabla);
		sp.setAlignmentX(CENTER_ALIGNMENT);
		this.getContentPane().add(sp);
	}
	
	void ProbarConexion() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 5));
		
		JButton boton1 = new JButton("Probar Conexion");
		JButton boton2 = new JButton("Probar Conexion");
		
		Dimension d = new Dimension(225, 25);
		boton1.setMinimumSize(d);
		boton1.setPreferredSize(d);
		
		boton2.setMinimumSize(d);
		boton2.setPreferredSize(d);
		
		panel.add(boton1);
		panel.add(boton2);
		
		panel.setAlignmentX(CENTER_ALIGNMENT);
		this.getContentPane().add(panel);
	}
	
	void DatosPersonales() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints restricciones = new GridBagConstraints();
		
		restricciones = setRestricciones(0,0,1,2);
		restricciones.weighty = 1d;
		restricciones.fill = GridBagConstraints.BOTH;
		restricciones.insets = new Insets(3,3,20,3);
		panel.add(Formulario(), restricciones);
		restricciones.weighty = 0d;
		
		restricciones = setRestricciones(1,0,1,1);
		restricciones.weighty = 1d;
		restricciones.insets = new Insets(3,3,3,3);
		panel.add(Foto(), restricciones);
		restricciones.weighty = 0d;
		
		restricciones = setRestricciones(1,1,1,1);
		restricciones.insets = new Insets(3,3,20,3);
		panel.add(SeleccionSexo(), restricciones);
		panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Datos Personales"));
		
		panel.setAlignmentX(CENTER_ALIGNMENT);
		this.getContentPane().add(panel);
	}
	
	JPanel SeleccionSexo() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel etiqueta = new JLabel("Sexo:");
		etiqueta.setAlignmentX(LEFT_ALIGNMENT);
		String[] opciones = {"--Seleccione Genero--", "Mascullino", "Femenino"};
		JComboBox listaGenero = new JComboBox(opciones);
		listaGenero.setAlignmentX(LEFT_ALIGNMENT);
		
		panel.add(etiqueta);
		panel.add(listaGenero);
		return panel;
	}
	
	JPanel Foto() {	
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints restricciones = new GridBagConstraints();
		
		JLabel imagen = new JLabel("FOTO");
		imagen.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		imagen.setHorizontalAlignment(SwingConstants.CENTER); 
		imagen.setMinimumSize(new Dimension(150, 120));
		imagen.setPreferredSize(new Dimension(150, 120));
		restricciones = setRestricciones(0,0,1,1);
		panel.add(imagen, restricciones);

		
		JButton boton = new JButton("Cargar Foto");
		boton.setPreferredSize(new Dimension(20, 10));
		boton.setPreferredSize(new Dimension(150, 25));
		JPanel botonPanel = new JPanel(new FlowLayout());
		botonPanel.add(boton);
		restricciones = setRestricciones(0,1,1,1);
		panel.add(botonPanel, restricciones);		
		
		return panel;
	}
	
	JPanel Formulario() {
		JPanel panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints restricciones = new GridBagConstraints();

		restricciones.fill = GridBagConstraints.HORIZONTAL;
		restricciones.anchor = GridBagConstraints.WEST;
 
		restricciones = setRestricciones(0, 0, 3, 1);
		restricciones.insets = new Insets(3,3,5,3);
		panel.add(hacerCampo("Nombre del Contacto:", 20), restricciones);
		
		restricciones = setRestricciones(0, 1, 3, 1);
		restricciones.insets = new Insets(3,3,20,3);
		panel.add(hacerCampo("Apellido del Contacto:", 20), restricciones);

		restricciones = setRestricciones(0, 2, 2, 1);
		restricciones.insets = new Insets(3,3,20,3);
		panel.add(hacerCampo("Email:", 11), restricciones);
		
		restricciones = setRestricciones(2, 2, 1, 1);
		restricciones.insets = new Insets(3,3,20,3);
		panel.add(hacerCampo("Celular:", 8), restricciones);
		
		restricciones = setRestricciones(0, 3, 3, 1);
		restricciones.insets = new Insets(3,3,3,3);
		panel.add(hacerCampo("Direccion:", 20), restricciones);
		
		return panel;
	}
		
	
	GridBagConstraints setRestricciones(int x, int y, int width, int height) {
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = x;
		grid.gridy = y;
		grid.gridwidth = width;
		grid.gridheight = height;
		return grid;
	}
	
	JPanel hacerCampo(String texto, int anchoTextField) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setSize(anchoTextField, 30);
		
		JLabel etiqueta = new JLabel(texto);
		etiqueta.setAlignmentX(LEFT_ALIGNMENT);
		
		JTextField campo = new JTextField(anchoTextField);
		campo.setAlignmentX(LEFT_ALIGNMENT);
		
		panel.add(etiqueta);
		panel.add(campo);
		
		return panel;
	}
	
	JPanel hacerCampo(String texto) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel etiqueta = new JLabel(texto);
		etiqueta.setAlignmentX(LEFT_ALIGNMENT);
		
		JTextField campo = new JTextField();
		
		panel.add(etiqueta);
		panel.add(campo);
		
		return panel;
	}

}
