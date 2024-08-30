package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;
import dao.ICategoriaDao;
import models.Categoria;

public class CategoriaDaoImpl implements ICategoriaDao {
	
	   @Override
	    public List<Categoria> getCategoria() {
	        Connection cn = null;
	        List<Categoria> categorias = new ArrayList<>();
	        try {
	            cn = Conexion.getConnection();
	            String sql = "SELECT * FROM getCategorias()";
	            PreparedStatement psmt = cn.prepareStatement(sql);
	            ResultSet rs = psmt.executeQuery();

	            while(rs.next()) {
	                categorias.add(ResultSetToObject(rs));
	            }
	            rs.close();
	            psmt.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(cn != null) {  // Error: '!=' is used instead of '!='
	                    cn.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return categorias;
	    }

	    private Categoria ResultSetToObject(ResultSet rs) throws SQLException {
	        Categoria categoria = new Categoria();
	        categoria.setCategoriaId(rs.getInt("categoria_id"));  // Possible error: 'ccategoria_id' might be a typo
	        categoria.setCategoria(rs.getString("categoria"));
	        return categoria;
	    }

		@Override
		public void addCategoria() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addCategoria(Categoria categoria) {
			Connection cn= null;
			CallableStatement smtm = null;
			System.out.println("Entregado agregar");
			try {
				cn=Conexion.getConnection();
				
				String sql = "{CALL addCategoria(?)}";
				smtm = cn.prepareCall(sql);
				
				smtm.setString(1, categoria.getCategoria());
				
				smtm.executeUpdate();
				
				System.out.println("Categoria añadido correctamente");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al añdir la categoria"+ e.getLocalizedMessage());
			}
			
			
		}
	    

	
}


