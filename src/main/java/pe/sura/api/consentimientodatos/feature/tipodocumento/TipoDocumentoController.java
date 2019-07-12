package pe.sura.api.consentimientodatos.feature.tipodocumento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.sura.api.consentimientodatos.exception.ApiExceptionHandler;

@RestController
@RequestMapping("/consentimiento-datos/api/v1")
public class TipoDocumentoController {

	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@GetMapping(value = "/tiposdocumento")
	public ResponseEntity<List<TipoDocumento>> getAll() {
		List<TipoDocumento> result = tipoDocumentoService.findAll();
		if(result != null)
			return ResponseEntity.ok().body(result);
		else
			throw new ApiExceptionHandler.NotFoundException();
	}
}
