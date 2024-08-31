package dao;

import java.util.List;

import models.Idioma;

public interface IIdiomaDao {
	public List<Idioma>getIdioma();
	 void addIdioma(Idioma idioma);
	 Idioma getIdioma(Integer IdiomaId);
}
