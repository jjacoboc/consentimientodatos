package pe.sura.api.consentimientodatos.feature.consentimiento;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.sura.api.consentimientodatos.exception.ApiExceptionHandler;

@Controller
@RequestMapping("/consentimiento-datos/api/v1")
public class ConsentimientoController {

	@Autowired
	private ConsentimientoService consentimientoService;
	
	@GetMapping(value = "/consentimientos/{id}")
	public ResponseEntity<Consentimiento> find(@PathVariable("id") Integer id) {
		Consentimiento result = consentimientoService.find(id);
		if(result != null) 
			return ResponseEntity.ok().body(result);
		else
			throw new ApiExceptionHandler.NotFoundException();
	}
	
	@PostMapping(value = "/consentimientos")
	public ResponseEntity<Consentimiento> save(@RequestBody @Valid Consentimiento consentimiento) {
		return ResponseEntity.ok().body(consentimientoService.save(consentimiento));
	}
	
	@PutMapping(value = "/consentimientos/{id}")
	public ResponseEntity<Consentimiento> update(@RequestBody @Valid Consentimiento consentimiento, @PathVariable("id") Integer id) {
		Consentimiento result = consentimientoService.find(id);
		if(result == null)
			throw new ApiExceptionHandler.NotFoundException();
		else {
			result.setIdEmpresa(consentimiento.getIdEmpresa());
			result.setIdCanal(consentimiento.getIdCanal());
			result.setEmail(consentimiento.getEmail());
			result.setTelefono(consentimiento.getTelefono());
			result.setEstado(consentimiento.getEstado());
			return ResponseEntity.ok().body(consentimientoService.update(result));
		}
	}
}
