package mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.Editorial;

public class editorialMapper {
	public static List<Editorial> hashToEditoriales(List<Map<String, Object>> lista){
		List<Editorial> editoriales = new ArrayList<>();
		lista.forEach(item ->{
			Editorial edi = new Editorial();
			edi.setEditorialId(Integer.parseInt(item.get("editorial_id").toString()));
			edi.setEditorial(item.get("editorial").toString());
			
			editoriales.add(edi);
		});
		
		return editoriales;
	}
}
