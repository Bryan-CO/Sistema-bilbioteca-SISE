package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import config.Conexion;
import dao.IIdiomaDao;
import models.Autor;
import models.Idioma;

public class IdiomaDaoImpl implements IIdiomaDao {
	

	    @Override
	    public List<Idioma> getIdioma() {
	        Connection cn = null;
	        List<Idioma> idiomas = new ArrayList<>();

	        try {
	            cn = Conexion.getConnection();
	            String sql = "SELECT * FROM getIdiomas()";
	            PreparedStatement psmt = cn.prepareStatement(sql);
	            ResultSet rs = psmt.executeQuery();

	            while (rs.next()) {
	                Idioma idioma = ResultSetToObject(rs);
	                idiomas.add(idioma);
	            }

	            rs.close();
	            psmt.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (cn != null) cn.close();
	            } catch (SQLException e2) {
	                e2.printStackTrace();
	            }
	        }

	        return idiomas;
	    }

	    private Idioma ResultSetToObject(ResultSet rs) throws SQLException {
	        Idioma idioma = new Idioma();
	        idioma.setIdiomaId(rs.getInt("idioma_id"));
	        idioma.setIdioma(rs.getString("idioma"));
	        return idioma;
	    }

	    @Override
	    public void addIdioma(Idioma idioma) {
	        Connection cn = null;
	        CallableStatement smtm = null;
	        System.out.println("Entrando agregar");
	        try {
	     	   //Obtener la Conexion
	 		cn=Conexion.getConnection();
	 		
	 		//Preparar la llamada a la funcion almacenada
	 		String sql = "{CALL añadir_idioma(?)}";
	 		smtm = cn.prepareCall(sql);
	 		
	 	
	 		//Establecer los parametros
	 		
	 		smtm.setString(1, idioma.getIdioma());
	 		
	 		smtm.executeUpdate();
	 		
	 		System.out.println("Idioma añadido correctamente");
	 		
	  		
	 	} catch (Exception e) {
	 	 e.printStackTrace();
	 	 System.out.println("Error al añadir el autor: " + e.getLocalizedMessage());
	 	 
	 	}finally {
	 		// Cerrar los recursos
	 		try {
	 			if(smtm != null) smtm.close();
	 			if(cn != null) cn.close();
	 		} catch ( SQLException e2) {
	 			e2.printStackTrace();
	 			// TODO: handle exception
	 		}
	 	}
	        
	 	
	     }
}

