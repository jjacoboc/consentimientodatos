package pe.sura.api.consentimientodatos.feature.empresa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmpresaRepository extends JpaRepository<Empresa, String>{

	public List<Empresa> findAll();

}
