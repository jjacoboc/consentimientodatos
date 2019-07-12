package pe.sura.api.consentimientodatos.feature.consentimiento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import pe.sura.api.consentimientodatos.feature.consentimiento.historial.ConsentimientoHistorial;

@Entity
@Table(name = "consentimiento")
public class Consentimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_empresa", nullable = false, length = 10)
	@NotNull
	private String idEmpresa;

	@Column(name = "id_canal", nullable = false, length = 15)
	@NotNull
	private String idCanal;

	@Column(name = "id_tipodocumento", nullable = false, length = 3)
	@NotNull
	private String idTipoDocumento;

	@Column(name = "vc_nrodocumento", nullable = false, length = 16)
	@NotNull
	private String nroDocumento;

	@Column(name = "vc_identificador", nullable = false, length = 20)
	private String identificador;

	@Column(name = "vc_email", nullable = false, length = 50)
	@Email(message = "Formato email inválido")
	private String email;

	@Column(name = "vc_telefono", nullable = false, length = 50)
	private String telefono;

	@Column(name = "vc_usuarioreg", nullable = false, length = 50)
	private String usuarioReg;

	@Column(name = "ch_estado", nullable = false, length = 1)
	private String estado;

	@Column(name = "dt_fechaevento", nullable = false)
	private Date fechaEvento;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = ConsentimientoHistorial.class)
	private List<ConsentimientoHistorial> listaHistorial = new ArrayList<>();

	public Consentimiento() {
	}

	public Consentimiento(String idEmpresa, String idCanal, String idTipoDocumento, String nroDocumento,
			String identificador, String email, String telefono, String usuarioReg, String estado, Date fechaEvento) {
		this.idEmpresa = idEmpresa;
		this.idCanal = idCanal;
		this.idTipoDocumento = idTipoDocumento;
		this.nroDocumento = nroDocumento;
		this.identificador = identificador;
		this.email = email;
		this.telefono = telefono;
		this.usuarioReg = usuarioReg;
		this.estado = estado;
		this.fechaEvento = fechaEvento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuarioReg() {
		return usuarioReg;
	}

	public void setUsuarioReg(String usuarioReg) {
		this.usuarioReg = usuarioReg;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public List<ConsentimientoHistorial> getListaHistorial() {
		return listaHistorial;
	}

	public void setListaHistorial(List<ConsentimientoHistorial> listaHistorial) {
		this.listaHistorial = listaHistorial;
	}

}
