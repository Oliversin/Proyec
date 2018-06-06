package com.uabcs.obeltran.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uabcs.obeltran.db.DBConnection;

public class User {
	
	public static final String TABLE = "user";
	private int id;
	private String email;
	private String password;
	private String username;
	private String name;
	private String LastN;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastN() {
		return LastN;
	}
	public void setLastN(String lastN) {
		LastN = lastN;
	}
	public static ArrayList<User> findALL(){
		ArrayList<User> usuarios = new ArrayList<User>();
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();
		
		String query = "SELECT * FROM "+ User.TABLE;
		try {
			PreparedStatement stm = conn.prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				usuarios.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return usuarios;
		}
	}
	
	public static User findByEmail(String email){
		User user = null;
		
		
		
		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();
			
			String query = "SELECT * FROM "+ User.TABLE+ " WHERE email = ?";
			PreparedStatement stm = conn.prepareStatement(query);
			stm.setString(1, email);
			ResultSet rs = stm.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	public static User findByUsername(String username){
		User user = null;
		
		
		
		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();
			
			String query = "SELECT * FROM "+ User.TABLE+ " WHERE username = ?";
			PreparedStatement stm = conn.prepareStatement(query);
			stm.setString(1, username);
			ResultSet rs = stm.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setLastN(rs.getString("lastName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	public static User findByEmailAndUsername(String email, String username){
		User user = null;
		
		
		
		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();
			
			String query = "SELECT * FROM "+ User.TABLE+ " WHERE email = ? AND username = ?";
			PreparedStatement stm = conn.prepareStatement(query);
			stm.setString(1, email);
			stm.setString(2, username);
			ResultSet rs = stm.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setLastN(rs.getString("lastName"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	public static int insertUser(String email, String password, String username, String name, String lastName) {
		User user = null;
		
		
		try {
			DBConnection db = new DBConnection();
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO "+User.TABLE+ "(email,password,username,name,lastName) VALUES(?,?,?,?,?)";
			PreparedStatement stm;
			stm = conn.prepareStatement(query);
			
			stm.setString(1, email);
			stm.setString(2, password);
			stm.setString(3, username);
			stm.setString(4, name);
			stm.setString(5, lastName);
			
			stm.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
	

}
