package mappers;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import models.Idioma;

public class idiomaMapper {
	public static List<Idioma> hashToIdiomas(List<Map<String, Object>> lista){
		List<Idioma> idiomas = new ArrayList<>();
		lista.forEach(item->{
			Idioma idi = new Idioma();
			idi.setIdiomaId(Integer.parseInt(item.get("ididioma").toString()));
			idi.setIdioma(item.get("nombre").toString());
			
			idiomas.add(idi);
		});
		
		return idiomas;
	}
}
