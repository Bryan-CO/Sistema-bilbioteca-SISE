package mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.Subgenero;

public class subgeneroMapper {
	public static List<Subgenero> hashToSubgeneros(List<Map<String, Object>> lista){
		List<Subgenero> subgeneros = new ArrayList<>();
		lista.forEach( item ->{
			Subgenero sub = new Subgenero();
			sub.setSubgeneroId(Integer.parseInt(item.get("subgenero_id").toString()));
			sub.setSubgenero(item.get("subgenero").toString());
			
			subgeneros.add(sub);
		});
		
		return subgeneros;
	}
}
