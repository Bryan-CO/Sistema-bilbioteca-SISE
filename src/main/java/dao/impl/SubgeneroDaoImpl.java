package dao.impl;

import java.util.List;

import config.Conexion;
import dao.ISubgeneroDao;
import mappers.subgeneroMapper;
import models.Subgenero;

public class SubgeneroDaoImpl implements ISubgeneroDao {

	@Override
	public void addSubgenero(String subgenero) {
		try {
			Conexion.executeProcedure("addsubgenero");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Subgenero> getSubgeneros() {
		List<Subgenero> subgeneros = null;
		try {
			subgeneros = subgeneroMapper.hashToSubgeneros(Conexion.executeProcedureWithReturn("getSubgeneros"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subgeneros;
	}

}
