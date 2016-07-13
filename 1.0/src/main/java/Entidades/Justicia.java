package Entidades;

import java.sql.SQLException;

import BaseDeDatos.BaseDeDatos;
import Interfaz.Almacenable;

public class Justicia implements Almacenable {
	
	private String DNI_Justicia;
	private String Nombre;
	private int Edad;
	private String Modalidad;
	private int Tipo_idTipo;
	
	
	public Justicia(String dNI_Justicia, String nombre,
			int edad, String modalidad, int tipo_idTipo) {
		super();
		DNI_Justicia = dNI_Justicia;
		Nombre = nombre;
	
		Edad = edad;
		Modalidad = modalidad;
		Tipo_idTipo = tipo_idTipo;
	}
	
	public String getDNI_Justicia() {
		return DNI_Justicia;
	}
	public void setDNI_Justicia(String dNI_Justicia) {
		DNI_Justicia = dNI_Justicia;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public String getModalidad() {
		return Modalidad;
	}
	public void setModalidad(String modalidad) {
		Modalidad = modalidad;
	}
	public int getTipo_idTipo() {
		return Tipo_idTipo;
	}
	public void setTipo_idTipo(int tipo_idTipo) {
		Tipo_idTipo = tipo_idTipo;
	}

	@Override
	public void guardarEnDB() {
		// TODO Auto-generated method stub
		
		try {
			BaseDeDatos.insertarJusticia(this);
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
			BaseDeDatos.modificarJusticia(this, BaseDeDatos.buscarIdJusticia(this.DNI_Justicia));
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
			BaseDeDatos.eliminarJusticia(BaseDeDatos.buscarIdJusticia(this.DNI_Justicia));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
