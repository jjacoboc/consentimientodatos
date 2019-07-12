package pe.sura.api.consentimientodatos.feature.tipodocumento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentosRepository;
	
	public List<TipoDocumento> findAll() {
		return tipoDocumentosRepository.findAll();
	}
}
