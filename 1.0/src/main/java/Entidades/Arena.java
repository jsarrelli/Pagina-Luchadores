package Entidades;

import java.sql.SQLException;

import BaseDeDatos.BaseDeDatos;
import Interfaz.Almacenable;

public class Arena implements Almacenable{
	private String Tipo;
	private String Tama�o;
	private int Lugar_idLugar;
	
	public Arena(String tipo, String tama�o, int lugar_idLugar) {
		super();
		Tipo = tipo;
		Tama�o = tama�o;
		Lugar_idLugar = lugar_idLugar;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getTama�o() {
		return Tama�o;
	}

	public void setTama�o(String tama�o) {
		Tama�o = tama�o;
	}

	public int getLugar_idLugar() {
		return Lugar_idLugar;
	}

	public void setLugar_idLugar(int lugar_idLugar) {
		Lugar_idLugar = lugar_idLugar;
	}

	@Override
	public void guardarEnDB() {
		// TODO Auto-generated method stub
		try {
			BaseDeDatos.insertarArena(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void modificarEnDB() {
		// TODO Auto-generated method stub
		
		
		try {
			BaseDeDatos.modificarArena(this,BaseDeDatos.buscarIdArena(this.Tipo));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminarEnDB() {
		// TODO Auto-generated method stub
		
		try {
			BaseDeDatos.eliminarArena(BaseDeDatos.buscarIdArena(this.Tipo));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
