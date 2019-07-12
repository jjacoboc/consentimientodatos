package pe.sura.api.consentimientodatos.feature.empresa.canal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CanalRepository extends JpaRepository<Canal, String>{

	public List<Canal> findByIdEmpresa(String idEmpresa);
	
	public Canal findByIdEmpresaAndId(String idEmpresa, String id);

}
