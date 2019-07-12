package pe.sura.api.consentimientodatos.feature.empresa.canal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.sura.api.consentimientodatos.exception.ApiExceptionHandler;

@Controller
@RequestMapping("/consentimiento-datos/api/v1")
public class CanalController {

	@Autowired
	private CanalService canalService;
	
	@GetMapping(value = "/empresas/{idEmpresa}/canales")
	public ResponseEntity<List<Canal>> findByIdEmpresa(@PathVariable("idEmpresa") String idEmpresa) {
		List<Canal> result = canalService.findByIdEmpresa(idEmpresa);
		if(result != null) 
			return ResponseEntity.ok().body(result);
		else
			throw new ApiExceptionHandler.NotFoundException();
	}
	
	@GetMapping(value = "/empresas/{idEmpresa}/canales/{id}")
	public ResponseEntity<Canal> findByIdEmpresaAndId(@PathVariable("idEmpresa") String idEmpresa, @PathVariable("id") String id) {
		Canal result = canalService.findByIdEmpresaAndId(idEmpresa, id);
		if(result != null) 
			return ResponseEntity.ok().body(result);
		else
			throw new ApiExceptionHandler.NotFoundException();
	}
}
