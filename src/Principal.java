import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Se encontro el Driver para Oracle DB - La libreria necesaria esta referenciada");
			
			String idPersonaST = JOptionPane.showInputDialog("Id: ");
	        Integer idPersona; // Integer es el tipo wrapper del tipo nativo int
	        idPersona = Integer.parseInt(idPersonaST);    
	        String nombre1 = JOptionPane.showInputDialog("Nombre1: ");
	        String nombre2 = JOptionPane.showInputDialog("Nombre2: ");
	        String apellido1 = JOptionPane.showInputDialog("Apellido1: ");
	        String apellido2 = JOptionPane.showInputDialog("Apellido2: ");
	        String documento = JOptionPane.showInputDialog("Documento: ");
	        String email = JOptionPane.showInputDialog("Email: ");
	        String clave = JOptionPane.showInputDialog("Password: ");
	        String fecNac = JOptionPane.showInputDialog("Fecha nacimiento: ");
			String rol = JOptionPane.showInputDialog("Rol: ");
			
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"JAVA",
						"JAVA"
						);
				System.out.println("Conexion creada con exito, es posible acceder");

				String INSERT_PERSONA = "INSERT INTO PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,NOMBRE2,CLAVE,MAIL,FECHA_NAC,ID_ROL) VALUES (?,?,?,?,?,?,?,?,?,?)";
				
				
				//**** START FORMATEO DE FECHA *************
				SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
				String reformattedStr = "";
				try {

				    reformattedStr = myFormat.format(myFormat.parse(fecNac));

				} catch (ParseException e) {
				    e.printStackTrace();
				}
				//****** END FORMATEO DE FECHA **********
				
				
				PreparedStatement statement = connection.prepareStatement(INSERT_PERSONA);
				statement.setInt(1,idPersona);
				statement.setString(2, documento);
				statement.setString(3, apellido1);
				statement.setString(4, apellido2);
				statement.setString(5, nombre1);
				statement.setString(6, nombre2);
				statement.setString(7, clave);
				statement.setString(8, email);
				statement.setString(9, reformattedStr);
				statement.setInt(10, Integer.parseInt(rol)); //Parseando id de tipo string a entero
				
				int filasIngresadas = statement.executeUpdate();
				
				
				
				String consulta = "SELECT * FROM PERSONA";
				
				try {
					Statement sentencia = connection.createStatement();
					ResultSet personasRS = sentencia.executeQuery(consulta);
					
					while(personasRS.next()) {
	
						System.out.println(personasRS.getString("DOCUMENTO") + ", "+ personasRS.getString("APELLIDO1")+ ", " + personasRS.getString("NOMBRE1"));

					}
				}catch(SQLException e) {
					System.out.println("**************************************");
					System.out.println("Error al ejecutar la consulta -> " + consulta);
					System.out.println("**************************************");
					e.printStackTrace();
					return;
				}
				try {
					connection.close();
					System.out.println("Conexion cerrada con exito");

				}catch(SQLException e) {
					System.out.println("Error al cerrar la conexion!!");
					e.printStackTrace();
					return;
				}
			}catch(SQLException e) {
				System.out.println("No logramos instanciar una conexion!!");
				e.printStackTrace();
				return;
			}
			
		}catch (ClassNotFoundException e){
			System.out.println("No tienes el drive en tu build-path?");
			e.printStackTrace();
			return;
		}
	}

}
