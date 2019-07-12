package pe.sura.api.consentimientodatos.feature.consentimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsentimientoRepository extends JpaRepository<Consentimiento, Integer> {

	@SuppressWarnings("unchecked")
	public Consentimiento save(Consentimiento consentimiento);
	
	public Consentimiento find(Integer id);
	
	@Query(value= "UPDATE consentimiento c SET c.id_empresa = ?1, c.id_canal = ?2, c.vc_email = ?3, c.vc_telefono = ?4, c.ch_estado = ?5 WHERE c.id = ?6", nativeQuery = true)
	public Consentimiento update(String idEmpresa, String idCanal, String email, String telefono, String estado, Integer id);
}
