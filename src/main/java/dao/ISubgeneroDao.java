package dao;

import java.util.List;
import models.Subgenero;

public interface ISubgeneroDao {
	public void addSubgenero(String subgenero);
	public List<Subgenero> getSubgeneros();
}
