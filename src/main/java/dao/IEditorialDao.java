package dao;

import java.util.List;
import models.Editorial;

public interface IEditorialDao {
	public void addEditorial(String editorial);
	public List<Editorial> getEditoriales();
}

