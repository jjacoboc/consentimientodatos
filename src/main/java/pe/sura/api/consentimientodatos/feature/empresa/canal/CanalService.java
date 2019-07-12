package pe.sura.api.consentimientodatos.feature.empresa.canal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanalService {

	@Autowired
	private CanalRepository canalRepository;
	
	public List<Canal> findByIdEmpresa(String idEmpresa) {
		return canalRepository.findByIdEmpresa(idEmpresa);
	}
	
	public Canal findByIdEmpresaAndId(String idEmpresa, String id) {
		return canalRepository.findByIdEmpresaAndId(idEmpresa, id);
	}
}
