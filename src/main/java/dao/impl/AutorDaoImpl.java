package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.translation.messages_bg;

import config.Conexion;
import dao.IAutorDao;
import models.Autor;


public class AutorDaoImpl implements IAutorDao {
	

    @Override
    public List<Autor> getAutor() {
        Connection cn = null;
        List<Autor> autores = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            String sql = "SELECT * FROM getAutores()"; // Ajusta esto según el nombre real de la función
            PreparedStatement psmt = cn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                autores.add(ResultSetToObject(rs));
            }
            rs.close();
            psmt.close();

        } catch (Exception e) {
            e.printStackTrace(); // Usa e.printStackTrace() para imprimir el error en la consola
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace(); // Usa e.printStackTrace() para imprimir el error en la consola
            }
        }
        return autores;
    }

    private Autor ResultSetToObject(ResultSet rs) throws SQLException {
        Autor autor = new Autor();
        autor.setAutorId(rs.getInt("autor_id"));
        autor.setAutor(rs.getString("autor"));
        return autor;
    }

@Override
public void addAutor(Autor autor) {
       Connection cn = null;
       CallableStatement smtm = null;
       System.out.println("Entregado agregar");
       try {
    	   //Obtener la Conexion
		cn=Conexion.getConnection();
		
		//Preparar la llamada a la funcion almacenada
		String sql = "{CALL añadir_autor(?)}";
		smtm = cn.prepareCall(sql);
		
	
		//Establecer los parametros
		
		smtm.setString(1, autor.getAutor());
		
		smtm.executeUpdate();
		
		System.out.println("Autor añadido correctamente");
		
 		
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

