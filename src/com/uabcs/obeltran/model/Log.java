package com.uabcs.obeltran.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import com.uabcs.obeltran.db.DBConnection;

public class Log {
	
	public static final String TABLE = "log";
	private int id;
	private Date fecha;
	private Time hora;
	private String comentario;
	private int idUser;
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public int create() throws SQLException{
		int result = 0;
		
		DBConnection db = new DBConnection();
		Connection conn = null;
		try {
			
			conn = db.getConnection();
			String query = "INSERT INTO "+Log.TABLE+ "(fecha, hora, comentario, id_user)"+ " VALUES(?,?,?,?)";
			PreparedStatement stm = conn.prepareStatement(query);
			stm.setDate(1, this.fecha);
			stm.setTime(2, this.hora);
			stm.setString(3, this.comentario);
			stm.setInt(4, this.idUser);
			result = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn != null){
				conn.close();
				return result;
			}
		}
		
		return result;
	}

}
