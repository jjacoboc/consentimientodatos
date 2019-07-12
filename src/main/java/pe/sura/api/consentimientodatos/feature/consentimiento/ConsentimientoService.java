package pe.sura.api.consentimientodatos.feature.consentimiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsentimientoService {

	@Autowired
	private ConsentimientoRepository consentimientoRepository;
	
	public Consentimiento save(Consentimiento consentimiento) {
		return consentimientoRepository.save(consentimiento);
	}
	
	public Consentimiento find(Integer id) {
		return consentimientoRepository.find(id);
	}
	
	public Consentimiento update(Consentimiento consentimiento) {
		return consentimientoRepository.update(consentimiento.getIdEmpresa(), 
				consentimiento.getIdCanal(),
				consentimiento.getEmail(),
				consentimiento.getTelefono(),
				consentimiento.getEstado(),
				consentimiento.getId());
	}
}
