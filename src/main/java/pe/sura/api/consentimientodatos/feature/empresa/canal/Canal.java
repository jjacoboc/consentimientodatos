package pe.sura.api.consentimientodatos.feature.empresa.canal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "canal")
public class Canal {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", nullable = false, length = 15)
	private String id;
	
	@Column(name = "id_empresa", nullable = false, length = 10)
	private String idEmpresa;
	
	@Column(name = "vc_descripcion", nullable = false, length = 25)
	private String descripcion;
	
	public Canal() {}
	
	public Canal(String id, String idEmpresa,String descripcion) {
		this.id = id;
		this.idEmpresa = idEmpresa;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
