package dao;

import java.util.List;
import models.Idioma;

public interface IIdiomaDao {
	public void addIdioma(String idioma);
	public List<Idioma> getIdiomas();
}
