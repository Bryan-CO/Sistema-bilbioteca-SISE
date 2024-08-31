package dao.impl;

import java.util.List;

import config.Conexion;
import dao.IEditorialDao;
import mappers.editorialMapper;
import models.Editorial;

public class EditorialDaoImpl implements IEditorialDao {

	@Override
	public void addEditorial(String editorial) {
		try {
			Conexion.executeProcedure("addEditorial", new Object[] {"El comercio"});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Editorial> getEditoriales() {
		List<Editorial> editoriales = null;
		try {
			editoriales = editorialMapper.hashToEditoriales(Conexion.executeProcedureWithReturn("getEditoriales"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editoriales;
	}

}
