package pe.sura.api.consentimientodatos.feature.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.sura.api.consentimientodatos.exception.ApiExceptionHandler;

@Controller
@RequestMapping("/consentimiento-datos/api/v1")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping(value = "/empresas")
	public ResponseEntity<List<Empresa>> getAll() {
		List<Empresa> result = empresaService.getAll();
		if(result != null)
			return ResponseEntity.ok().body(result);
		else
			throw new ApiExceptionHandler.NotFoundException();
	}
}
