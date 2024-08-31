package mappers;
import models.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class categoriaMapper {
	public static List<Categoria> hashToCategorias(List<Map<String, Object>> lista){
		List<Categoria> categorias = new ArrayList<>();
		lista.forEach(item -> {
			Categoria cat = new Categoria();
			cat.setCategoriaId(Integer.parseInt(item.get("categoria_id").toString()));
			cat.setCategoria(item.get("categoria").toString());
			categorias.add(cat);
		});
		return categorias;
	}
}
