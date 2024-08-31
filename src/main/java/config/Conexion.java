package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conexion {

	private final static String DRIVER_CLASS_NAME ="org.postgresql.Driver";
	private final static String URL ="jdbc:postgresql://localhost/sistema_biblioteca";
	private final static String USERNAME="postgres";
	private final static String PASSWORD="godofwar12345";
	
	
	private Conexion() {
		
	}
	
	@SuppressWarnings("deprecation")
	
	public static Connection getConnection() throws SQLException{
		Connection cn = null;
		try {
			Class.forName(DRIVER_CLASS_NAME).newInstance();
			cn=DriverManager.getConnection(URL,USERNAME,PASSWORD);

		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return cn;
	}
	
	public static void executeProcedure(String nameProcedure, Object[] parametros) throws SQLException {
		try(
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("CALL " + createQuery(nameProcedure, parametros));
				
		){
			if(parametros.length > 0) {
				for (int i = 0; i < parametros.length; i++) {
		            ps.setObject(i + 1, parametros[i]);
		        }
			}
			ps.executeUpdate();			 
		}
	}
	
	public static void executeProcedure(String nameProcedure) throws SQLException {
		try(
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("CALL " + nameProcedure + "();");
				
		){
			ps.executeUpdate();			 
		}
	}
	
	public static List<Map<String, Object>> executeProcedureWithReturn(String nameProcedure, Object[] parametros) throws SQLException {
		List<Map<String, Object>> results = null;
		try(
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + createQuery(nameProcedure, parametros));
		){
			if(parametros.length > 0) {
				for (int i = 0; i < parametros.length; i++) {
		            ps.setObject(i + 1, parametros[i]);
		        }
			}
			
			 try (ResultSet rs = ps.executeQuery()) {
				 results = new ArrayList<>();
				 ResultSetMetaData metaData = rs.getMetaData();
	             int columnCount = metaData.getColumnCount();
	                while (rs.next()) {
	                    Map<String, Object> row = new HashMap<>();
	                    for (int i = 1; i <= columnCount; i++) {
	                        row.put(metaData.getColumnName(i), rs.getObject(i));
	                    }
	                    results.add(row);
	                }
	            }
		}
		return results;
		
	}
	
	public static List<Map<String, Object>> executeProcedureWithReturn(String nameProcedure) throws SQLException {
		List<Map<String, Object>> results = null;
		try(
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + nameProcedure + "();");
		){
			
			 try (ResultSet rs = ps.executeQuery()) {
				 results = new ArrayList<>();
				 ResultSetMetaData metaData = rs.getMetaData();
	             int columnCount = metaData.getColumnCount();
	                while (rs.next()) {
	                    Map<String, Object> row = new HashMap<>();
	                    for (int i = 1; i <= columnCount; i++) {
	                        row.put(metaData.getColumnName(i), rs.getObject(i));
	                    }
	                    results.add(row);
	                }
	            }
		}
		return results;
		
	}
	private static String createQuery(String query, Object[] parametros) {
		if(parametros.length == 0){
            return query + "()";
        }
		
		String queryResult = query;
        String params = "(";
        for(int i = 1; i <= parametros.length; i++){
            params += "?";
            if(i == parametros.length){
                params += ")";
            }
            else{
                params += ", ";
            }
        }

        for(int i = 1; i <= parametros.length; i++){
            System.out.println("Elemnto: " + i + ", es: " + parametros[i-1]);
        }


        return queryResult + params;

	}
}
