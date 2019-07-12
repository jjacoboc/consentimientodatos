package pe.sura.api.consentimientodatos.feature.empresa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import pe.sura.api.consentimientodatos.feature.empresa.canal.Canal;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", nullable = false, length = 10)
	private String id;
	
	@Column(name = "vc_descripcion", nullable = false, length = 25)
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Canal.class)
	private List<Canal> listaCanal = new ArrayList<>();
	
	public Empresa() {}
	
	public Empresa(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Canal> getListaCanal() {
		return listaCanal;
	}

	public void setListaCanal(List<Canal> listaCanal) {
		this.listaCanal = listaCanal;
	}
	
}
