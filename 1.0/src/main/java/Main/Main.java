package Main;

import static spark.Spark.*;

import java.sql.SQLException;
import java.util.Vector;

import BaseDeDatos.BaseDeDatos;
import Entidades.Arena;
import Entidades.Peleador;
import Entidades.Lugar;
import Entidades.Entrenador;
import Entidades.Tipo;
import Entidades.Justicia;
import spark.Request;
import spark.Response;


public class Main {
	
private	static boolean autenticacionUsuario=true;
private static String Nombre, Contraseña;

	public static void main(String[] args) {
		
		
		
		staticFileLocation("/public");

		get("/Login", (req, res) -> Login(req,res));
		get("/ValidaUsuario", (req, res) -> ValidaUsuario(req,res));
		get("/Index", (req, res) -> index(req,res));
		get("/Arena", (req, res) -> Arena(req,res));
		get("/Peleador", (req, res) -> Peleador(req,res));
		get("/Entrenador", (req, res) -> Entrenador(req,res));
		get("/Lugar", (req, res) -> Lugar(req,res));
		get("/Justicia", (req, res) -> Justicia(req,res));
		get("/NuevoPeleador", (req, res) -> NuevoPeleador(req,res)); 
		get("/GuardarPeleador", (req, res) -> GuardarPeleador(req,res)); 




	}
	private static Object index (Request req, Response res) {


		return "<html>"
				+ includeHead()
				+	"<body>"


+	"	<div  id=\"header\"  >"
+		"		<ul class=\"nav\">"

	+	 " <div id=\"wrapper\">"  

	       +"<!-- Sidebar -->"
	       +" <div id=\"sidebar-wrapper\">" 
	       +"<ul class=\"sidebar-nav\">"     
	       + "<li class=\"sidebar-brand\">"       
	       + " <a href=\"/Index\">"         
	       + "  <u><b>Inicio</b></u>"           
	       + " </a>"       
	       + "</li>"   
	       + "<li>"  
	       + "<a href=\"/Peleador\">Peleadores</a>"     
	       +"</li>" 
	       +"<li>"
	       +   "  <a href=\"/Entrenador\">Entrenadores</a>" 
	       +" </li>"
	       + "<li>"
	       +"<a href=\"/Lugar\">Lugares</a>"   
	       +"</li>"
	       +"<li>" 
	       +"<a href=\"/Arena\">Arenas</a>"    
	       +"</li>"
	       +"<li>"
	       + " <a href=\"/Justicia\">Justicias</a>"  
	       +" </li>"
	       +" <li>"

		                +  "<a  href=\"logout.php\">Logout</a> " 
		                + "</li>"  
		                + "</ul> "  
		                +"</div> "
		                +" <!-- /#sidebar-wrapper -->"

		        +"<!-- Page Content --> "
		        +"<div id=\"page-content-wrapper\"> "
		        + " <div class=\"container-fluid\"> " 
		        +   "  <div class=\"row\">"   
		        +    "<div class=\"col-lg-12\">  "      
		        +     " <a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Menu</a>"        
		        +      " </div>"   
		        +    "</div> " 
		        + " </div> "
		        + "</div> "
		        +" <!-- /#page-content-wrapper -->  "

		    +" </div>"
		    +"<!-- /#wrapper --> "
		    +  " <script src=\"jquery.js\"></script>" 

		  + "<!-- Bootstrap Core JavaScript --> " 
		  + "  <script src=\"bootstrap.min.js\"></script>}"
		  +  "<!-- Menu Toggle Script -->"		    
		  +          "<script>"		    
		  +         "$(\"#menu-toggle\").click(function(e) {"
		  +        "e.preventDefault();"
		  +       " $(\"#wrapper\").toggleClass(\"toggled\");"		       
		  +      "});"		    
		  +     "</script>";
	}




	private static Object Arena(Request req, Response res) {


		String ret = "<html>\n"
				+ includeHead()
				+"<body>"
				+	"<div  id=\"header\"  >"	
				+ 	"<ul class=\"nav\">"			
				+ 	" <div id=\"wrapper\">"	 

+           		    " <!-- Sidebar -->"   
+          		    "<div id=\"sidebar-wrapper\">"    
+         		      "<ul class=\"sidebar-nav\">"      
+        		       "<li class=\"sidebar-brand\">"         
+       		        "<a href=\"/Index\">"            
+      		           " Inicio	"
+     		          " </a>"         
+    		         "</li>"       
+   		        "<li>"        
+  		          "<a href=\"peleadores.html\">Peleadores</a>"          
+ 		            " </li>"   
+		           "<li>"       
+	             "<a href=\"/Entrenador\">Entrenadores</a>"       
+	            " </li>"   
+	           " <li>"    
+	          "  <a href=\"/Lugar\">Lugares</a>"        
+	         "</li>"       
+	        "<li>"        
+	       "<a href=\"/Arena\"><u><b>Arenas</b></u></a>"             
+	           "</li>"     
+	          "<li>"      
+	         " <a href=\"/Justicia\">Justicias</a>"          
+	        "  </li>"      
+	       "<li>"         
+	      "<a href=\"logout.php\">Logout</a>"              
+	     "</li>"           

           	+	   "</ul>"         

           	+	     "</div>"   
           	+	    " <!-- /#sidebar-wrapper -->"   
           	+	   "<div id=\"page-content-wrapper\">"
           	+	        " <div class=\"container-fluid\">"   
           	+	       "<div class=\"row\">"         
           	+	      "  <div class=\"col-lg-12\">"            

           	+	          " <a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Menu</a>"             

           	+	   "   </div>"              
           	+	  "</div>"              
           	+	 "  </div>"         
           	+	"</div>"        

           	+"</ul>"		
           	+"</div>"	    


+           "<!-- /#wrapper -->"		    

+           "<!-- jQuery -->"		    
+          "<script src=\"jquery.js\"></script>"		    

  +         "<!-- Bootstrap Core JavaScript -->"		    
  +        "<script src=\"bootstrap.min.js\"></script>"		    

+           "<!-- Menu Toggle Script -->"		    
+          "<script>"		    
+         "$(\"#menu-toggle\").click(function(e) {"
+        "e.preventDefault();"
+       " $(\"#wrapper\").toggleClass(\"toggled\");"		       
+      "});"		    
+     "</script>"		    
+    "<div align=\"right\"><a href=\"nuevaArena.html\"><img src=\"add.png\"  width='50' height='50'/> </a></div>"		

        +   "<center><font color=\"white\"><h1>Arenas</h1></font></center>"						

         +  "<table border=1 width=\"80%\" style=\"float:right;\">"					
         + "<thead>"					
         +		"<tr>"				
         +	"<td><b>Lugar</b></td>"					
         +	"<td><b>Tipo</b></td>"					
         +	"<td><b>Dimensiones</b></td>	"								
         +	"</tr>"				
         +	"</thead>"				
         +	"<tbody>";

		Vector<Arena> arenas=new Vector<Arena>();
		try {
			arenas=BaseDeDatos.DameArenas();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		for(Arena arena:arenas )
		{
			ret += "<tr>";
			ret += "<td>"+arena.getTamaño()+"</td>"; 
			ret += "<td>"+arena.getTamaño()+"</td>"; 
			ret += "<td>"+arena.getTamaño()+"</td>"; 
			try {
				ret += "<td><a href=\"eliminarArena.html?id="+BaseDeDatos.buscarIdArena(arena.getTipo())+"\">Eliminar</a></td>";
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ret += "</tr>";
		}






		ret	+="</tbody>"
				+"</table>"
				+" </body>\n"
				+ "</html>\n";

		return ret;
	}



	private static Object Peleador(Request req, Response res) {


		String ret = "<html>\n"
				+ includeHead()
				+"<body>"
				+	"<div  id=\"header\"  >"	
				+ 	"<ul class=\"nav\">"			
				+ 	" <div id=\"wrapper\">"	 

+           		    " <!-- Sidebar -->"   
+          		    "<div id=\"sidebar-wrapper\">"    
+         		      "<ul class=\"sidebar-nav\">"      
+        		       "<li class=\"sidebar-brand\">"         
+       		        "<a href=\"/Index\">"            
+      		           " Inicio	"
+     		          " </a>"         
+    		         "</li>"       
+   		        "<li>"        
+  		          "<a href=\"/Peleador\"><u><b>Peleadores</b></u></a>"          
+ 		            " </li>"   
+		           "<li>"       
+	             "<a href=\"/Entrenador\">Entrenadores</a>"       
+	            " </li>"   
+	           " <li>"    
+	          "  <a href=\"/Lugar\">Lugares</a>"        
+	         "</li>"       
+	        "<li>"        
+	       "<a href=\"/Arena\"><u>Arenas</a>"             
+	           "</li>"     
+	          "<li>"      
+	         " <a href=\"/Lugar\">Justicias</a>"          
+	        "  </li>"      
+	       "<li>"         
+	      "<a href=\"logout.php\">Logout</a>"              
+	     "</li>"           

           	+	   "</ul>"         

           	+	     "</div>"   
           	+	    " <!-- /#sidebar-wrapper -->"   
           	+	   "<div id=\"page-content-wrapper\">"
           	+	        " <div class=\"container-fluid\">"   
           	+	       "<div class=\"row\">"         
           	+	      "  <div class=\"col-lg-12\">"            

           	+	          " <a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Menu</a>"             

           	+	   "   </div>"              
           	+	  "</div>"              
           	+	 "  </div>"         
           	+	"</div>"        

           	+"</ul>"		
           	+"</div>"	    


+           "<!-- /#wrapper -->"		    

+           "<!-- jQuery -->"		    
+          "<script src=\"jquery.js\"></script>"		    

  +         "<!-- Bootstrap Core JavaScript -->"		    
  +        "<script src=\"bootstrap.min.js\"></script>"		    

+           "<!-- Menu Toggle Script -->"		    
+          "<script>"		    
+         "$(\"#menu-toggle\").click(function(e) {"
+        "e.preventDefault();"
+       " $(\"#wrapper\").toggleClass(\"toggled\");"		       
+      "});"		    
+     "</script>"		    
+    "<div align=\"right\"><a href=\"/NuevoPeleador\"><img src=\"add.png\"  width='50' height='50'/> </a></div>"		

        +   "<center><font color=\"white\"><h1>Peleadores</h1></font></center>"						

         +  "<table border=1 width=\"80%\" style=\"float:right;\">"					
         + "<thead>"					
         +		"<tr>"				
         +	"<td><b>Nombre</b></td>"					
         +	"<td><b>Apodo</b></td>"					
         +	"<td><b>Peso</b></td>	"	
         +	"<td><b>Altura</b></td>	"	
         +	"<td><b>Categoria</b></td>	"	
         +	"<td><b>Modalidad</b></td>	"	
         +	"<td><b>Edad</b></td>	"	
         +	"<td><b>Direccion</b></td>	"	
         +	"<td><b>DNI Peleador</b></td>	"	
         +	"<td><b>Entrenador</b></td>	"	
         +	"</tr>"				
         +	"</thead>"				
         +	"<tbody>";

		Vector<Peleador> peleadores=new Vector<Peleador>();
		try {
			peleadores=BaseDeDatos.DamePeleadores();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		for(Peleador peleador:peleadores )
		{
			ret += "<tr>";
			ret += "<td>"+peleador.getNombre()+"</td>"; 
			ret += "<td>"+peleador.getApodo()+"</td>"; 
			ret += "<td>"+peleador.getPeso()+"</td>"; 
			ret += "<td>"+peleador.getAltura()+"</td>"; 
			ret += "<td>"+peleador.getCategoria()+"</td>"; 
			ret += "<td>"+peleador.getModalidad()+"</td>"; 
			ret += "<td>"+peleador.getEdad()+"</td>"; 
			ret += "<td>"+peleador.getDireccion()+"</td>"; 
			ret += "<td>"+peleador.getDNI_Peleador()+"</td>"; 
			try {
				ret += "<td>"+BaseDeDatos.buscarEntrenador(peleador.getIdEntrenador()).getNombre()+"</td>";
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 	
			try {
				ret += "<td><a href=\"eliminarArena.html?id="+BaseDeDatos.buscarIdPeleador(peleador.getDNI_Peleador())+"\">Eliminar</a></td>";
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ret += "</tr>";
		}






		ret	+="</tbody>"
				+"</table>"
				+" </body>\n"
				+ "</html>\n";

		return ret;
	}


	private static Object Entrenador(Request req, Response res) {


		String ret = "<html>\n"
				+ includeHead()
				+"<body>"
				+	"<div  id=\"header\"  >"	
				+ 	"<ul class=\"nav\">"			
				+ 	" <div id=\"wrapper\">"	 

+           		    " <!-- Sidebar -->"   
+          		    "<div id=\"sidebar-wrapper\">"    
+         		      "<ul class=\"sidebar-nav\">"      
+        		       "<li class=\"sidebar-brand\">"         
+       		        "<a href=\"/Index\">"            
+      		           " Inicio	"
+     		          " </a>"         
+    		         "</li>"       
+   		        "<li>"        
+  		          "<a href=\"/Peleador\">Peleadores</a>"          
+ 		            " </li>"   
+		           "<li>"       
+	             "<a href=\"/Entrenador\"><u><b>Entrenadores</b></u></a>"       
+	            " </li>"   
+	           " <li>"    
+	          "  <a href=\"/Lugar\">Lugares</a>"        
+	         "</li>"       
+	        "<li>"        
+	       "<a href=\"/Arena\"><b>Arenas</a>"             
+	           "</li>"     
+	          "<li>"      
+	         " <a href=\"/Justicia\">Justicias</a>"          
+	        "  </li>"      
+	       "<li>"         
+	      "<a href=\"logout.php\">Logout</a>"              
+	     "</li>"           

           	+	   "</ul>"         

           	+	     "</div>"   
           	+	    " <!-- /#sidebar-wrapper -->"   
           	+	   "<div id=\"page-content-wrapper\">"
           	+	        " <div class=\"container-fluid\">"   
           	+	       "<div class=\"row\">"         
           	+	      "  <div class=\"col-lg-12\">"            

           	+	          " <a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Menu</a>"             

           	+	   "   </div>"              
           	+	  "</div>"              
           	+	 "  </div>"         
           	+	"</div>"        

           	+"</ul>"		
           	+"</div>"	    


+           "<!-- /#wrapper -->"		    

+           "<!-- jQuery -->"		    
+          "<script src=\"jquery.js\"></script>"		    

  +         "<!-- Bootstrap Core JavaScript -->"		    
  +        "<script src=\"bootstrap.min.js\"></script>"		    

+           "<!-- Menu Toggle Script -->"		    
+          "<script>"		    
+         "$(\"#menu-toggle\").click(function(e) {"
+        "e.preventDefault();"
+       " $(\"#wrapper\").toggleClass(\"toggled\");"		       
+      "});"		    
+     "</script>"		    
+    "<div align=\"right\"><a href=\"nuevaArena.html\"><img src=\"add.png\"  width='50' height='50'/> </a></div>"		

        +   "<center><font color=\"white\"><h1>Entrendores</h1></font></center>"						

         +  "<table border=1 width=\"80%\" style=\"float:right;\">"					
         + "<thead>"					
         +		"<tr>"				
         +	"<td><b>Nombre</b></td>"					
         +	"<td><b>DNI Entrenador</b></td>"					
         +	"<td><b>Telefono</b></td>	"	
         +	"<td><b>Direccion</b></td>	"	
         +	"</tr>"				
         +	"</thead>"				
         +	"<tbody>";

		Vector<Entrenador> entrenadores=new Vector<Entrenador>();
		try {
			entrenadores=BaseDeDatos.DameEntrenadores();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		for(Entrenador entrenador:entrenadores )
		{
			ret += "<tr>";
			ret += "<td>"+entrenador.getNombre()+"</td>"; 
			ret += "<td>"+entrenador.getDNI_Entrenador()+"</td>"; 
			ret += "<td>"+entrenador.getTelefono()+"</td>"; 
			ret += "<td>"+entrenador.getDireccion()+"</td>"; 


			try {
				ret += "<td><a href=\"eliminarArena.html?id="+BaseDeDatos.buscarIdEntrenador(entrenador.getDNI_Entrenador())+"\">Eliminar</a></td>";
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ret += "</tr>";
		}






		ret	+="</tbody>"
				+"</table>"
				+" </body>\n"
				+ "</html>\n";

		return ret;
	}



	private static Object Lugar(Request req, Response res) {


		String ret = "<html>\n"
				+ includeHead()
				+"<body>"
				+	"<div  id=\"header\"  >"	
				+ 	"<ul class=\"nav\">"			
				+ 	" <div id=\"wrapper\">"	 

+           		    " <!-- Sidebar -->"   
+          		    "<div id=\"sidebar-wrapper\">"    
+         		      "<ul class=\"sidebar-nav\">"      
+        		       "<li class=\"sidebar-brand\">"         
+       		        "<a href=\"/Index\">"            
+      		           " Inicio	"
+     		          " </a>"         
+    		         "</li>"       
+   		        "<li>"        
+  		          "<a href=\"/Peleador\">Peleadores</a>"          
+ 		            " </li>"   
+		           "<li>"       
+	             "<a href=\"/Entrenador\">Entrenadores</a>"       
+	            " </li>"   
+	           " <li>"    
+	          "  <a href=\"/Lugar\"><u><b>Lugares</b></u>"        
+	         "</li>"       
+	        "<li>"        
+	       "<a href=\"/Arena\">Arenas</a>"             
+	           "</li>"     
+	          "<li>"      
+	         " <a href=\"/Justicia\">Justicias</a>"          
+	        "  </li>"      
+	       "<li>"         
+	      "<a href=\"logout.php\">Logout</a>"              
+	     "</li>"           

           	+	   "</ul>"         

           	+	     "</div>"   
           	+	    " <!-- /#sidebar-wrapper -->"   
           	+	   "<div id=\"page-content-wrapper\">"
           	+	        " <div class=\"container-fluid\">"   
           	+	       "<div class=\"row\">"         
           	+	      "  <div class=\"col-lg-12\">"            

           	+	          " <a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Menu</a>"             

           	+	   "   </div>"              
           	+	  "</div>"              
           	+	 "  </div>"         
           	+	"</div>"        

           	+"</ul>"		
           	+"</div>"	    


+           "<!-- /#wrapper -->"		    

+           "<!-- jQuery -->"		    
+          "<script src=\"jquery.js\"></script>"		    

  +         "<!-- Bootstrap Core JavaScript -->"		    
  +        "<script src=\"bootstrap.min.js\"></script>"		    

+           "<!-- Menu Toggle Script -->"		    
+          "<script>"		    
+         "$(\"#menu-toggle\").click(function(e) {"
+        "e.preventDefault();"
+       " $(\"#wrapper\").toggleClass(\"toggled\");"		       
+      "});"		    
+     "</script>"		    
+    "<div align=\"right\"><a href=\"nuevaArena.html\"><img src=\"add.png\"  width='50' height='50'/> </a></div>"		

        +   "<center><font color=\"white\"><h1>Entrendores</h1></font></center>"						

         +  "<table border=1 width=\"80%\" style=\"float:right;\">"					
         + "<thead>"					
         +		"<tr>"				
         +	"<td><b>Nombre</b></td>"					
         +	"<td><b>Direccion</b></td>"					
         +	"<td><b>Telefono</b></td>	"	

         +	"</tr>"				
         +	"</thead>"				
         +	"<tbody>";

		Vector<Lugar> lugares=new Vector<Lugar>();
		try {
			lugares=BaseDeDatos.DameLugares();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		for(Lugar lugar:lugares )
		{
			ret += "<tr>";
			ret += "<td>"+lugar.getNombre()+"</td>"; 
			ret += "<td>"+lugar.getTelefono()+"</td>"; 
			ret += "<td>"+lugar.getDireccion()+"</td>"; 


			try {
				ret += "<td><a href=\"eliminarArena.html?id="+BaseDeDatos.buscarIdLugar(lugar.getNombre())+"\">Eliminar</a></td>";
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ret += "</tr>";
		}






		ret	+="</tbody>"
				+"</table>"
				+" </body>\n"
				+ "</html>\n";

		return ret;
	}



	private static Object Justicia(Request req, Response res) {


		String ret = "<html>\n"
				+ includeHead()
				+"<body>"
				+	"<div  id=\"header\"  >"	
				+ 	"<ul class=\"nav\">"			
				+ 	" <div id=\"wrapper\">"	 

+           		    " <!-- Sidebar -->"   
+          		    "<div id=\"sidebar-wrapper\">"    
+         		      "<ul class=\"sidebar-nav\">"      
+        		       "<li class=\"sidebar-brand\">"         
+       		        "<a href=\"/Index\">"            
+      		           " Inicio	"
+     		          " </a>"         
+    		         "</li>"       
+   		        "<li>"        
+  		          "<a href=\"/Peleador\">Peleadores</a>"          
+ 		            " </li>"   
+		           "<li>"       
+	             "<a href=\"/Entrenador\">Entrenadores</a>"       
+	            " </li>"   
+	           " <li>"    
+	          "  <a href=\"/Lugar\">Lugares</a>"        
+	         "</li>"       
+	        "<li>"        
+	       "<a href=\"/Arena\">Arenas</a>"             
+	           "</li>"     
+	          "<li>"      
+	         " <a href=\"/Justicia\"><u><b>Justicias</b></u></a>"          
+	        "  </li>"      
+	       "<li>"         
+	      "<a href=\"logout.php\">Logout</a>"              
+	     "</li>"           

           	+	   "</ul>"         

           	+	     "</div>"   
           	+	    " <!-- /#sidebar-wrapper -->"   
           	+	   "<div id=\"page-content-wrapper\">"
           	+	        " <div class=\"container-fluid\">"   
           	+	       "<div class=\"row\">"         
           	+	      "  <div class=\"col-lg-12\">"            

           	+	          " <a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Menu</a>"             

           	+	   "   </div>"              
           	+	  "</div>"              
           	+	 "  </div>"         
           	+	"</div>"        

           	+"</ul>"		
           	+"</div>"	    


+           "<!-- /#wrapper -->"		    

+           "<!-- jQuery -->"		    
+          "<script src=\"jquery.js\"></script>"		    

  +         "<!-- Bootstrap Core JavaScript -->"		    
  +        "<script src=\"bootstrap.min.js\"></script>"		    

+           "<!-- Menu Toggle Script -->"		    
+          "<script>"		    
+         "$(\"#menu-toggle\").click(function(e) {"
+        "e.preventDefault();"
+       " $(\"#wrapper\").toggleClass(\"toggled\");"		       
+      "});"		    
+     "</script>"		    
+    "<div align=\"right\"><a href=\"nuevaArena.html\"><img src=\"add.png\"  width='50' height='50'/> </a></div>"		

        +   "<center><font color=\"white\"><h1>Justicias</h1></font></center>"						

         +  "<table border=1 width=\"80%\" style=\"float:right;\">"					
         + "<thead>"					
         +		"<tr>"				
         +	"<td><b>Nombre</b></td>"					
         +	"<td><b>DNI Justicia</b></td>"					

         +	"<td><b>Edad</b></td>	"	
         +	"<td><b>Modaliad</b></td>	"	

         +	"<td><b>Rol</b></td>	"	

         +	"</tr>"				
         +	"</thead>"				
         +	"<tbody>";

		Vector<Justicia> justicias=new Vector<Justicia>();
		try {
			justicias=BaseDeDatos.DameJusticias();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		for(Justicia justicia : justicias )
		{
			ret += "<tr>";
			ret += "<td>"+justicia.getNombre()+"</td>"; 
			ret += "<td>"+justicia.getDNI_Justicia()+"</td>"; 
			ret += "<td>"+justicia.getEdad()+"</td>"; 
			ret += "<td>"+justicia.getModalidad()+"</td>"; 


			try {
				ret += "<td>"+BaseDeDatos.buscarRol(justicia.getTipo_idTipo())+"</td>";
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 


			try {
				ret += "<td><a href=\"eliminarArena.html?id="+BaseDeDatos.buscarIdJusticia(justicia.getDNI_Justicia())+"\">Eliminar</a></td>";
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ret += "</tr>";
		}






		ret	+="</tbody>"
				+"</table>"
				+" </body>\n"
				+ "</html>\n";

		return ret;
	}


	private static Object NuevoPeleador(Request req, Response res) 

	{
		String ret= "<html>"
				+ includeHead()
				+	"<body>"
+				" <center><h1>Nuevo Peleador</h1></center>"
				
+"<form name=\"nuevo_peleador\" method=\"POST\" action=\"/GuardarPeleador\"> "				
+	" <table width=\"50%\">"				
+	"<tr> "					
+				" <td width=\"20\"><b>Peleador</b></td>"			
+				" <td width=\"30\"><input type=\"text\" name=\"Nombre\" size=\"25\" /></td>"			
+			" </tr>"			
+		"<tr> "				
+		"<td><b>Apodo</b></td>  "					
+		" <td><input type=\"text\" name=\"Apodo\" size=\"25\" /></td>"					
+		" </tr>"				
+		" <tr>"				
+	"<td><b>Peso</b></td> "						
+"<td><input type=\"value\" name=\"Peso\" size=\"25\" /></td> "							
+	" </tr>"				
+	" 	<tr>"				
+	" <td><b>Altura</b></td>"						
+" <td><input type=\"value\" name=\"Altura\" size=\"25\" /></td>"							
+	" </tr>"					
+" <tr>"						
+"<td><b>Categoria</b></td> "							
+" <td><input type=\"text\" name=\"Categoria\" size=\"25\" /></td>"							
+		"</tr> "				
+		"<tr> "				
+	"<td><b>Modalidad</b></td>"						
+	"<td><input type=\"text\" name=\"Modalidad\" size=\"25\" /></td> "						
+		"</tr> "				
+		" <tr>"				
+	" <td><b>Edad</b></td>"						
+	"<td><input type=\"value\" name=\"Edad\" size=\"25\" /></td> "						
+	" </tr>"					
+" <tr>"						
+" <td><b>Direccion</b></td>"							
+	"<td><input type=\"text\" name=\"Direccion\" size=\"25\" /></td> "						
+	" </tr>"				
						
+"<tr> "						
+	"<td><b>DNI</b></td> "						
+"<td><input type=\"text\" name=\"DNI_Peleador\" size=\"25\" /></td> "							
+	" </tr>"					
					
+	"<tr> "					
+" <td><b>Entrenador</b></td>"							
+	" <td>"						
+	" <select name=\"Entrenador_idEntrenador\">";						

								try {
									for(Entrenador entrenador: BaseDeDatos.DameEntrenadores()){
ret+=" <option value="+entrenador.getDNI_Entrenador()+">";									
ret+=  entrenador.getNombre()	;								
									
ret+=" </option>";									
}
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
		
		
ret+=	"</select> "									
+		"</td> "					
+		" </tr>"				
+	"<tr> "					
+" <td colspan=\"2\"><center><input type=\"submit\" name=\"enviar\" value=\"Registrar\" /></center></td>"							
+		" </tr>"				
+	"</table> "				
+" </form>"				
+" </body>"			
+"</html";

return ret;
	}
	
	
	
	private static Object GuardarPeleador(Request req, Response res)
	
	{
		String nombre=req.queryParams("Nombre");
		String apodo=req.queryParams("Apodo");
		String peso=req.queryParams("Peso");
		String altura=req.queryParams("Altura");
		String categoria=req.queryParams("Categoria");
		String modalidad=req.queryParams("Modalidad");
		String edad= req.queryParams("Edad");
		String direccion=req.queryParams("Direccion");
		String dNI_Peleador=req.queryParams("DNI_Peleador");
		String idEntrenador=req.queryParams("Entrenador_idEntrenador");
		
		float pesofloat = Float.parseFloat(peso);
		float alturafloat=Float.parseFloat(altura);
		int edadint=Integer.parseInt(edad);
		int idEntrenadorint=Integer.parseInt(idEntrenador);
		Peleador peleador=new Peleador(nombre, apodo, pesofloat, alturafloat, categoria, modalidad, edadint, direccion, dNI_Peleador, idEntrenadorint);
		
		
		
		String ret= "<html>"
				+ includeHead()
+		"<body>"

		

+"</div>"	    



+	" <script src=\"js/jquery.js\"></script> "          


+	  "  <script src=\"js/bootstrap.min.js\"></script>" 


+	" <script>"   
+	  "   $(\"#menu-toggle\").click(function(e) {"
+	 "e.preventDefault();"       
+	"         $(\"#wrapper\").toggleClass(\"toggled\");     "
+	 " });"  
+	" </script>"   

+	"<head>"	
+	"<title>Guardar Peleador</title>"		
+	"</head>"	
+	"<body>"	
+	"<center>	";		
				
				try {
					if(!BaseDeDatos.existePeleador(dNI_Peleador)){
						BaseDeDatos.insertarPeleador(peleador);	
ret+=				"<h1>Peleador Guardado</h1>"
+	" <a href=\"/Peleador\">Regresar</a>";

					}
						else{ 
					ret+=	"<h1>Error al Guardar Usuario</h1>"
					+	" <a href=\"/NuevoPeleador\">Regresar</a>";	
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				
ret+="<p></p>	 "												
	
				
+ " </center>	"													
+	" </body>"	
+" </html>	";

				
				
return ret;
	}
	
	private static String includeHead() {
		{
			return ""
					+"<head>"
					+"<meta charset=\"utf-8\">"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					+ "  <meta name=\"description\" content=\"\">"
					+ "<meta name=\"author\" content=\"\">"
					+ " <link href=\"bootstrap.min.css\" rel=\"stylesheet\">"
					+ "<link href=\"simple-sidebar.css\" rel=\"stylesheet\">"
					+ "<link href=\"text.css\" rel=\"stylesheet\">"
					+"</head>";

		}
	}

	private static Object Login (Request req,Response res)
	{

		String ret =  " 	<html >"
				+"  <head> "	
				+	" <meta charset=\"UTF-8\">"    
				+	"  <title>Log-in</title> "  

+	"  <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>"

+"   <link rel=\"stylesheet\" href=\"style.css\">"	      

+	" </head> " 

+	" <body> " 

+	  "<div class=\"login-card\"> "  
+	  " <h1>Log-in</h1><br>"  
+	 "  <form   method=\"POST\" action=\"/ValidaUsuario\">"
+	 "<input type=\"text\" name=\"user\" placeholder=\"Username\"> "   
+	   " <input type=\"password\" name=\"pass\" placeholder=\"Password\"> ";


if(!autenticacionUsuario)
{
	ret+="<font color=\"red\" size=\"1\" >Usuario y/o Contraseña incorrecto</font>";
}
	

ret+= 	 "  <input type=\"submit\" name=\"login\" class=\"login login-submit\" value=\"login\">"  
+	 " </form>" 

+	 "<div class=\"login-help\"> " 
+	  " <a href=\"nuevoUsuario\">Register</a> "  
+	"</div> "  
+" </div>"	

+"	<!-- <div id=\"error\"><img src=\"https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png\" /> Your caps-lock is on.</div> --> "
+	"<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script> "    
+	"  <script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>"

+	"  </body>" 
+" </html>"	;


return ret;
	}
	
	
	
	
	
	
	private static Object ValidaUsuario (Request req,Response res)
	{
		
		Nombre=req.queryParams("user");
		Contraseña=req.queryParams("pass");
		
		System.out.println("Usuario: "+Nombre);
		System.out.println("Contraseña: "+Contraseña);
		

		try {
			if(BaseDeDatos.ValidaUsuario(Nombre, Contraseña))
			{
				return "<meta http-equiv=\"refresh\" content=\"0; url=/Index\"/>" ;
			}
			
			else{
				autenticacionUsuario=false;
				return "<meta http-equiv=\"refresh\" content=\"0; url=/Login\"/>" ;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}



}