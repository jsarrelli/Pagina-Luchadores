package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;






import java.util.Vector;

import Entidades.Arena;
import Entidades.Entrenador;
import Entidades.Justicia;
import Entidades.Lugar;
import Entidades.Peleador;
import Entidades.Tipo;

public class BaseDeDatos {

	//////////////////////////////////////FUNCIONES QUE INSERTAN////////////////////////////////////////////////////////////////////////////////////////////////
	public static void insertarPeleador(Peleador peleador) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;


		stmt.execute("INSERT INTO Peleador (Nombre,Apodo,Peso,Altura,Categoria,Modalidad,Edad,DNI_Peleador,idEntrenador)"
				+ " VALUES('"+peleador.getNombre()+"','"+peleador.getApodo()+"','"+peleador.getPeso()+"','"+peleador.getAltura()+"',"
				+ "'"+peleador.getCategoria()+"','"+peleador.getModalidad()+"','"+peleador.getDNI_Peleador()+"','"+peleador.getIdEntrenador()+"')");

	}


	public static void insertarEntrenador(Entrenador entrenador) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;


		stmt.execute("INSERT INTO Peleador (DNI_Entrenador,Nombre,Telefono,Direccion)"
				+ " VALUES('"+entrenador.getDNI_Entrenador()+"','"+entrenador.getNombre()+"','"+entrenador.getTelefono()+"','"+entrenador.getDireccion()+"')");

	}

	public static void insertarJusticia(Justicia justicia) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;


		stmt.execute("INSERT INTO Justicia (DNI_Justicia,Nombre,Edad,Modalidad)"
				+ " VALUES('"+justicia.getDNI_Justicia()+"','"+justicia.getNombre()+"','"+justicia.getEdad()+"','"+justicia.getModalidad()+"')");

	}

	public static void insertarLugar(Lugar lugar) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;


		stmt.execute("INSERT INTO Lugar (Nombre,Direccion,Telefono)"
				+ " VALUES('"+lugar.getNombre()+"','"+lugar.getDireccion()+"','"+lugar.getTelefono()+"')");

	}

	public static void insertarArena(Arena arena) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;


		stmt.execute("INSERT INTO Arena (Tipo,Tamaño,Lugar_idLugar)"
				+ " VALUES('"+arena.getTipo()+"','"+arena.getTamaño()+"','"+arena.getLugar_idLugar()+"')");

	}

	public static void insertarTipo(Tipo tipo) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;


		stmt.execute("INSERT INTO Tipo (Rol)"
				+ " VALUES('"+tipo.getRol()+"')");

	}

	///////////////////////////////////////////////FUNCIONES QUE MODIFICAN////////////////////////////////////////////////////////////
	public static void modificarPeleador(Peleador peleador,int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;



		stmt.execute("UPDATE Peleador set Nombre='"+peleador.getNombre()+"', Apodo='"+peleador.getApodo()+"',Peso='"+peleador.getPeso()+"'"
				+ ",Altura='"+peleador.getAltura()+"',Categoria='"+peleador.getCategoria()+"',Modalidad='"+peleador.getEdad()+"'"
				+ "DNI_Peleador='"+peleador.getDNI_Peleador()+"',idEntrenador='"+peleador.getIdEntrenador()+"' WHERE idPeleador='"+id+"'");


	}

	public static void modificarEntrenador(Entrenador entrenador,int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;



		stmt.execute("UPDATE Peleador set DNI_Entrenador='"+entrenador.getDNI_Entrenador()+"',Nombre='"+entrenador.getNombre()+"', Telefono='"+entrenador.getTelefono()+"'"
				+ ",Direccion='"+entrenador.getDireccion()+"' WHERE idEntrenador='"+id+"'");


	}

	public static void modificarJusticia(Justicia justicia,int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;



		stmt.execute("UPDATE Justicia set DNI_Entrenador='"+justicia.getDNI_Justicia()+"',Nombre='"+justicia.getNombre()+"'"
				+ ",Edad='"+justicia.getEdad()+"',Modalidad='"+justicia.getModalidad()+"' WHERE idJusticia='"+id+"'");

	}

	public static void modificarLugar(Lugar lugar,int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;



		stmt.execute("UPDATE Lugar set Nombre='"+lugar.getNombre()+"',Direccion='"+lugar.getDireccion()+"', Telefono='"+lugar.getTelefono()+"'"
				+ " WHERE idLugar='"+id+"'");


	}

	public static void modificarArena(Arena arena,int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;



		stmt.execute("UPDATE Arena set Tipo='"+arena.getTipo()+"',Tamaño='"+arena.getTamaño()+"', Lugar_idLugar='"+arena.getLugar_idLugar()+"'"
				+ " WHERE idArena='"+id+"'");


	}

	public static void modificarTipo(Tipo tipo,int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;



		stmt.execute("UPDATE Tipo set Rol='"+tipo.getRol()+"' WHERE idTipo='"+id+"'");


	}



	////////////////////////////////////FUNCIONES QUE ELIMINAN////////////////////////////////////////////////////////////////////////////////////	
	public static void eliminarPeleador(int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;

		stmt.execute("DELETE FROM Peleador WHERE idPeleador='"+id+"'");

	}

	public static void eliminarEntrenador(int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;

		stmt.execute("DELETE FROM Entrenador WHERE idEntrenador='"+id+"'");

	}

	public static void eliminarJusticia(int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;

		stmt.execute("DELETE FROM Justicia WHERE idJusticia='"+id+"'");

	}

	public static void eliminarLugar(int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;

		stmt.execute("DELETE FROM Lugar WHERE idLugar='"+id+"'");

	}

	public static void eliminarTipo(int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;

		stmt.execute("DELETE FROM Tipo WHERE idTipo='"+id+"'");

	}


	public static void eliminarArena(int id) throws ClassNotFoundException, SQLException
	{


		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;

		stmt.execute("DELETE FROM Arena WHERE idArena='"+id+"'");

	}

	//////////////////////////////////////////////FUNCIONES AUXILIARES/////////////////////////////////////////////////////////


	public static int buscarIdPeleador(String DNI_Peleador)throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;


		rs= stmt.executeQuery("SELECT idPeleador FROM Peleador WHERE DNI_Peleador='"+DNI_Peleador+"'");
		while ( rs.next() ) {

			int resultado=rs.getInt("idPeleador");
			return resultado;

		}
		return -1;

	}

	public static int buscarIdEntrenador(String DNI_Entrenador)throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;


		rs= stmt.executeQuery("SELECT idEntrenador FROM Entrenador WHERE DNI_Entrenador='"+DNI_Entrenador+"'");
		while ( rs.next() ) {

			int resultado=rs.getInt("idEntrenador");
			return resultado;

		}
		return -1;

	}

	public static Entrenador buscarEntrenador(int idEntrenador)throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;


		rs= stmt.executeQuery("SELECT * FROM Entrenador WHERE idEntrenador='"+idEntrenador+"'");
		while ( rs.next() ) {

			String dNI_Entrenador=rs.getString("DNI_Entrenador");
			String nombre=rs.getString("Nombre");
			String telefono=rs.getString("Telefono");
			String direccion=rs.getString("Direccion");





			Entrenador entrenador=new Entrenador(dNI_Entrenador, nombre, telefono, direccion);
			return entrenador;

		}
		return null;

	}

	public static int buscarIdArena(String Tipo)throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;


		rs= stmt.executeQuery("SELECT idArena FROM Arena WHERE Tipo='"+Tipo+"'");
		while ( rs.next() ) {

			int resultado=rs.getInt("idArena");
			return resultado;

		}
		return -1;

	}

	public static int buscarIdLugar(String Nombre)throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;


		rs= stmt.executeQuery("SELECT idLugar FROM Lugar WHERE Nombre='"+Nombre+"'");
		while ( rs.next() ) {

			int resultado=rs.getInt("idLugar");
			return resultado;

		}
		return -1;

	}

	public static int buscarIdTipo(String Rol)throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;


		rs= stmt.executeQuery("SELECT idTipo FROM Tipo WHERE Rol='"+Rol+"'");
		while ( rs.next() ) {

			int resultado=rs.getInt("idTipo");
			return resultado;

		}
		return -1;

	}
	
	public static String buscarRol(int idTipo)throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;


		rs= stmt.executeQuery("SELECT Rol FROM Tipo WHERE idTipo='"+idTipo+"'");
		while ( rs.next() ) {

			String resultado=rs.getString("Rol");
			return resultado;

		}
		return null;

	}


	public static int buscarIdJusticia(String DNI_Justicia)throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;


		rs= stmt.executeQuery("SELECT idJusticia FROM Justicia WHERE DNI_Justicia='"+DNI_Justicia+"'");
		while ( rs.next() ) {

			int resultado=rs.getInt("idJusticia");
			return resultado;

		}
		return -1;

	}

	public static boolean tienePeleador(int idEntrenador) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;

		rs= stmt.executeQuery("SELECT idPeleador FROM Peleador WHERE Entrenador_idEntrenador='"+idEntrenador+"'");

		while ( rs.next() ) {


			return true;


		}
		return false;



	}


	public static boolean tieneJusticia(int idTipo) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;

		rs= stmt.executeQuery("SELECT idJusticia FROM Peleador WHERE Tipo_idTipo='"+idTipo+"'");

		while ( rs.next() ) {


			return true;


		}
		return false;



	}


	public static void borrarPeleadoresSegunEntranador (int idEntrenador)throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;

		stmt.execute("DELETE FROM Peleadore WHERE Entrenador_idEntreandor='"+idEntrenador+"'");
	}


	public static void borrarJusticiasSegunTipo (int idTipo)throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;

		stmt.execute("DELETE FROM Justicia WHERE Tipo_idTipo='"+idTipo+"'");
	}





	////////////////////////////////////////SELECTS//////////////////////////////////


	public static Vector<Arena> DameArenas() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;

		Vector<Arena> arenas=new Vector<Arena>();
		rs= stmt.executeQuery("SELECT * FROM Arena");

		while ( rs.next() ) {



			String tipo=rs.getString("Tipo");
			String tamaño=rs.getString("Tamano");
			int lugar_idLugar=rs.getInt("Lugar_idLugar");


			Arena arena=new Arena(tipo, tamaño, lugar_idLugar);
			arenas.add(arena);

		}
		return arenas;



	}


	public static Vector<Peleador> DamePeleadores() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;

		Vector<Peleador> peleadores=new Vector<Peleador>();
		rs= stmt.executeQuery("SELECT * FROM Peleador");

		while ( rs.next() ) {



			String nombre=rs.getString("Nombre");
			String apodo=rs.getString("Apodo");
			float peso=rs.getFloat("Peso");
			float altura=rs.getFloat("Altura");
			String categoria=rs.getString("Categoria");
			String modalidad=rs.getString("Modalidad");
			int edad=rs.getInt("Edad");
			String direccion=rs.getString("Direccion");
			String dNI_Peleador=rs.getString("DNI_Peleador");
			int idEntrenador=rs.getInt("Entrenador_idEntrenador");




			Peleador peleador=new Peleador(nombre, apodo, peso, altura, categoria, modalidad, edad, direccion, dNI_Peleador, idEntrenador);
			peleadores.add(peleador);

		}
		return peleadores;



	}
	
	
	
	public static Vector<Entrenador> DameEntrenadores() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;

		Vector<Entrenador> entrenadores=new Vector<Entrenador>();
		rs= stmt.executeQuery("SELECT * FROM Entrenador");

		while ( rs.next() ) {



			String dNI_Entrenador=rs.getString("DNI_Entrenador");
			String nombre=rs.getString("Nombre");
			String telefono=rs.getString("Telefono");
			String direccion=rs.getString("Direccion");
		





			Entrenador entrenador=new Entrenador(dNI_Entrenador, nombre, telefono, direccion);
		entrenadores.add(entrenador);

		}
		return entrenadores;



	}
	
	public static Vector<Lugar> DameLugares() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;

		Vector<Lugar> lugares=new Vector<Lugar>();
		rs= stmt.executeQuery("SELECT * FROM Lugar");

		while ( rs.next() ) {



			String nombre=rs.getString("Nombre");
			String telefono=rs.getString("Telefono");
			String direccion=rs.getString("Direccion");





		Lugar lugar=new Lugar(nombre, direccion, telefono);
		lugares.add(lugar);

		}
		return lugares;



	}
	
	
	public static Vector<Justicia> DameJusticias() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;

		Vector<Justicia> justicias=new Vector<Justicia>();
		rs= stmt.executeQuery("SELECT * FROM Justicia");

		while ( rs.next() ) {



			String dNI_Justicia=rs.getString("DNI_Justicia");
			String nombre=rs.getString("Nombre");
			int edad=rs.getInt("Edad");
			String modalidad=rs.getString("Modalidad");
			int tipo_idTipo=rs.getInt("Tipo_idTipo");
		





	Justicia justicia=new Justicia(dNI_Justicia, nombre, edad, modalidad, tipo_idTipo);
		justicias.add(justicia);

		}
		return justicias;



	}
	
	public static boolean ValidaUsuario(String Nombre,String Contraseña) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;


		rs= stmt.executeQuery("SELECT * FROM Usuario WHERE Nombre='"+Nombre+"' AND Contrasena='"+Contraseña+"'");

		while ( rs.next() ) {



			
			return true;






		}
		return false;


	}
	
	public static boolean existePeleador(String DNI) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peleadores", "root", "") ;
		Statement stmt = conn.createStatement() ;
		ResultSet rs;


		rs= stmt.executeQuery("SELECT * FROM Peleador WHERE DNI_Peleador='"+DNI+"'");

		while ( rs.next() ) {



			
			return true;






		}
		return false;


	}
	
	
	
	
}
