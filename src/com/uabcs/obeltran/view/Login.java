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
import com.uabcs.obeltran.controller.LoginController;

public class Login extends JFrame{
	
	
	int width=0;
	int height=0;
	JPanel principal;
	JPanel nulo;
	public JTextField jtfEmail;
	public JPasswordField jpfPassword;
	JLabel welcome;
	JLabel welcome2;
	JLabel mark;
	ImageIcon bien;
	Font myFont2;
	Font myFont3;
	JButton ingresar;
	JButton registrar;
	JLabel askUser;
	JLabel askPassword;
	JPanel nuloContenedor;
	Formato f;
	
	public Login() 
	{
		this.initComponents();
		
		
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize);
		
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		System.out.println(getSize());
		
		setSize(width/2, height/2);
		setResizable(false);
		setVisible(true);
		setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);
		
		principal.setLayout(new BorderLayout());
		nuloContenedor.setLayout(new GridLayout(1,1));
		nulo.setLayout(null);
		nulo.setBackground(new Color(54,57,63));
		principal.setBackground(new Color(54,57,63));
		
		Font myFont = new Font("Helvetica", Font.BOLD, 12);
		mark.setForeground(new Color(233,233,234));
		mark.setBackground(new Color(233,233,234));
		
		jtfEmail.setBackground(new Color(49,51,57));
		jtfEmail.setForeground(new Color(233,233,234));
		jpfPassword.setBackground(new Color(49,51,57));
		jpfPassword.setForeground(new Color(233,233,234));
		
		
		
		welcome.setIcon(bien);
		
		welcome.setFont(myFont2);
		welcome.setForeground(new Color(233,233,234));
		
		
		welcome2.setFont(myFont3);
		welcome2.setForeground(new Color(233,233,234));
		
		
		
				
		
		ingresar.setFont(myFont);
		ingresar.setForeground(new Color(230,234,248));
		ingresar.setBackground(new Color(114,137,218));
		
		
		registrar.setFont(myFont);
		registrar.setBackground(new Color(121, 131, 255));
		
		
		askUser= new JLabel("Correo");
		askUser.setFont(myFont);
		askUser.setForeground(new Color(185,187,190));
		askPassword= new JLabel("Contraseña");
		askPassword.setFont(myFont);
		askPassword.setForeground(new Color(185,187,190));
		

		mark.setBounds(0,0,100,20);
		welcome.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)-90,screenSize.width/2-this.getSize().width/2,50);
		welcome2.setBounds((screenSize.width/4-this.getSize().width/4)+75,(screenSize.height/4-this.getSize().height/4)-60,screenSize.width/2-this.getSize().width/2,50);

		askUser.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)-35,screenSize.width/2-this.getSize().width/2,50);
		askPassword.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)+55,screenSize.width/2-this.getSize().width/2,50);
		
		jtfEmail.setBounds(screenSize.width/4-this.getSize().width/4,screenSize.height/4-this.getSize().height/4,screenSize.width/2-this.getSize().width/2,30);
		jpfPassword.setBounds(screenSize.width/4-this.getSize().width/4,(screenSize.height/4-this.getSize().height/4)+90,screenSize.width/2-this.getSize().width/2,30);
		//registrar.setBounds(screenSize.width/4-this.getSize().width/4,270,(screenSize.width/2-this.getSize().width/2)/2,30);
		ingresar.setBounds((screenSize.width/4-this.getSize().width/4),(screenSize.height/4-this.getSize().height/4)+125,(screenSize.width/2-this.getSize().width/2),30);
		
		registrar.setBounds(0,(screenSize.height/4-this.getSize().height/4)+125,50,20);
		
		nulo.add(jtfEmail);
		nulo.add(jpfPassword);
		nulo.add(ingresar);
		nulo.add(registrar);
		
		
		nulo.add(askUser);
		nulo.add(askPassword);
		nulo.add(welcome);
		nulo.add(welcome2);
		//nuloContenedor.add(nulo);
		
		
		principal.add(mark, BorderLayout.NORTH);
		principal.add(nulo, BorderLayout.CENTER);
		
		add(principal);
		
		
		validate();
		repaint();
		
		
	}
	
	public void init(LoginController c){
		this.ingresar.addActionListener(c);
		this.ingresar.setActionCommand("login");
		this.registrar.addActionListener(c);
		this.registrar.setActionCommand("registrar");
	}
	
	private void initComponents(){
		 f = new Formato(); 
		 principal= new JPanel();
		 nulo= new JPanel();
		 jtfEmail= new JTextField();
		 jpfPassword= new JPasswordField();
		 welcome = new JLabel("¡Bienvenido!");
		 welcome2 = new JLabel("¡Es bueno verte aqui!");
		 mark= new JLabel("Twitmail© ");
		 bien = new ImageIcon("img/bien.png");
		 myFont2 = new Font("Helvetica", Font.BOLD, 24);
		 myFont3 = new Font("Helvetica", Font.BOLD, 14);
		 ingresar= new JButton("INGRESAR");
		 registrar = new JButton("REGISTRAR");
		 askUser= new JLabel();
		 askPassword= new JLabel();
		 nuloContenedor= new JPanel();
	}

}
























