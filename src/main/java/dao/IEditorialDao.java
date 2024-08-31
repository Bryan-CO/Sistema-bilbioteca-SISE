package dao;

import java.util.List;


import models.Editorial;

public interface IEditorialDao {
	public List<Editorial>getEditorials();
	public void addEditorial();
	Editorial getEditorial(Integer editorialId);
}

