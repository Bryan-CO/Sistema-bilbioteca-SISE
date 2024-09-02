package mappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.Autor;

public class autorMapper {
	public static List<Autor> hashToAutores(List<Map<String, Object>> lista) {
		List<Autor> autores = new ArrayList<>();
		lista.forEach(item -> {
			Autor autor = new Autor();
			autor.setAutor(item.get("nombre").toString());
			autor.setAutorId(Integer.parseInt(item.get("idautor").toString()));
			
			autores.add(autor);
		});
		return autores;
	}
}
