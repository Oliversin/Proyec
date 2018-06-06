package com.uabcs.obeltran.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.uabcs.obeltran.controller.RegistroController;

public class Registro extends JFrame{
	
	int width=0;
	int height=0;
	
	JPanel principal;
	JPanel nulo;
	public JTextField jtfEmail;
	public JPasswordField jpfPassword;
	public JTextField jtfUser;
	public JTextField jtfName;
	public JTextField jtfLastN;
	JLabel mark;
	ImageIcon bien;
	Font myFont;
	JLabel askUser;
	JLabel askEmail;
	JLabel askName;
	JLabel askLastN;
	JLabel askPassword;
	JPanel nuloContenedor;
	JButton registrar;
	Formato f;

	
	
	
	
	public Registro()
	{
		this.initComponents();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		
		setSize(width/2, height/2);
		setVisible(true);
		setResizable(false);
		setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);
		
		principal.setLayout(new BorderLayout());
		principal.setBackground(new Color(54,57,63));
		nuloContenedor.setLayout(new GridLayout(1,1));
		nulo.setLayout(null);
		nulo.setBackground(new Color(54,57,63));
		
		mark.setFont(myFont);
		mark.setForeground(new Color(233,233,234));
		mark.setBackground(new Color(233,233,234));
		registrar.setFont(myFont);
		askUser.setFont(myFont);
		askPassword.setFont(myFont);
		askEmail.setFont(myFont);
		askName.setFont(myFont);
		askLastN.setFont(myFont);
		
		askEmail= f.nuevoJLabel("Correo");
		askPassword= f.nuevoJLabel("Contraseña");
		askUser=f.nuevoJLabel("Nombre de usuario");
		askName= f.nuevoJLabel("Nombre");
		askLastN=f.nuevoJLabel("Apellido");
		
		jtfEmail=f.nuevoJText();
		jpfPassword=f.nuevoJPass();
		jpfPassword.setForeground(new Color(233,233,234));
		jtfUser=f.nuevoJText();
		jtfName=f.nuevoJText();
		jtfLastN=f.nuevoJText();
		
		mark.setBounds(0,0,100,20);
		//askUser.setBounds(screenSize.width/4-this.getSize().width/4,15,150,50);
		askEmail.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)-120,screenSize.width/2-this.getSize().width/2,50);
		jtfEmail.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)-85,screenSize.width/2-this.getSize().width/2,30);

		//askPassword.setBounds(30,90,150,50);
		askPassword.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)-45,screenSize.width/2-this.getSize().width/2,50);
		jpfPassword.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)-10,screenSize.width/2-this.getSize().width/2,30);
		
		//askEmail.setBounds(30,165,150,50);
		
		askUser.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)+30,screenSize.width/2-this.getSize().width/2,50);
		jtfUser.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)+65,screenSize.width/2-this.getSize().width/2,30);
		
		//askName.setBounds(30,240,150,50);
		askName.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)+105,screenSize.width/2-this.getSize().width/2,50);
		jtfName.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)+140,screenSize.width/2-this.getSize().width/2,30);
		
		//askLastN.setBounds(30,315,150,50);
		askLastN.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)+180,screenSize.width/2-this.getSize().width/2,50);
		jtfLastN.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)+215,screenSize.width/2-this.getSize().width/2,30);
		
		
		
		//registrar.setBounds(30,400,150,30);
		registrar.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)+255,screenSize.width/2-this.getSize().width/2,30);
		registrar.setBackground(new Color(114,137,218));
		registrar.setForeground(new Color(230,234,248));
		
		
		
		principal.add(mark, BorderLayout.NORTH);
		nulo.add(jtfEmail);
		nulo.add(jpfPassword);
		nulo.add(jtfUser);
		nulo.add(jtfName);
		nulo.add(jtfLastN);
		nulo.add(askUser);
		nulo.add(askPassword);
		nulo.add(askEmail);
		nulo.add(askName);
		nulo.add(askLastN);
		nulo.add(registrar);
		//nuloContenedor.add(nulo);
		principal.add(nulo, BorderLayout.CENTER);
		
		
		add(principal);
		validate();
		repaint();
		
		
	}
	
	public void init(RegistroController c){
		this.registrar.addActionListener(c);
		this.registrar.setActionCommand("registrar");
	}
	
	
	
	private void initComponents(){
		f = new Formato();
		principal = new JPanel();
		nulo = new JPanel();
		nuloContenedor = new JPanel();
		jtfEmail= new JTextField();
		jpfPassword= new JPasswordField();
		jtfUser= new JTextField();
		jtfName= new JTextField();
		jtfLastN= new JTextField();
		mark= new JLabel("Twitmail© ");
		myFont = new Font("Helvetica", Font.BOLD, 12);
		askUser= new JLabel("Nombre de usuario");
		askEmail= new JLabel("Correo");
		askPassword= new JLabel("Contraseña");
		askName= new JLabel("Nombre");
		askLastN= new JLabel("Apellido");
		registrar= new JButton("REGISTRAR");
		 
	}

}
























