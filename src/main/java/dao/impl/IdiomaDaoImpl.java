package dao.impl;

import java.util.List;

import config.Conexion;
import dao.IIdiomaDao;
import mappers.idiomaMapper;
import models.Idioma;

public class IdiomaDaoImpl implements IIdiomaDao {

	@Override
	public void addIdioma(String idioma) {
		try {
			Conexion.executeProcedure("addidioma", new Object[] {idioma});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Idioma> getIdiomas() {
		List<Idioma> idiomas = null;
		try {
			idiomas = idiomaMapper.hashToIdiomas(Conexion.executeProcedureWithReturn("getidiomas"));
		} catch (Exception e) {
			System.out.println("AQUI ERROR");
		}
		return idiomas;
	}
	
}
