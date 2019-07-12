package pe.sura.api.consentimientodatos.feature.consentimiento.historial;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consentimiento_historial")
public class ConsentimientoHistorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "id_consentimiento", nullable = false)
	private Integer idConsentimiento;
	
	@Column(name = "id_empresa", nullable = false, length = 10)
	private String idEmpresa;
	
	@Column(name = "id_canal", nullable = false, length = 15)
	private String idCanal;
	
	@Column(name = "id_tipodocumento", nullable = false, length = 3)
	private String idTipoDocumento;
	
	@Column(name = "vc_nrodocumento", nullable = false, length = 16)
	private String nroDocumento;
	
	@Column(name = "vc_identificador", nullable = false, length = 20)
	private String identificador;
	
	@Column(name = "vc_email", nullable = false, length = 50)
	private String email;
	
	@Column(name = "vc_telefono", nullable = false, length = 50)
	private String telefono;
	
	@Column(name = "vc_usuarioreg", nullable = false, length = 50)
	private String usuarioReg;
	
	@Column(name = "ch_estado", nullable = false, length = 1)
	private String estado;
	
	@Column(name = "dt_fechaevento", nullable = false)
	private Date fechaEvento;
	
	public ConsentimientoHistorial() {}
	
	public ConsentimientoHistorial( 
			Integer idConsentimiento,
			String idEmpresa, 
			String idCanal, 
			String idTipoDocumento, 
			String nroDocumento, 
			String identificador, 
			String email,
			String telefono,
			String usuarioReg,
			String estado,
			Date fechaEvento) {
		this.idConsentimiento = idConsentimiento;
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

	public Integer getIdConsentimiento() {
		return idConsentimiento;
	}

	public void setIdConsentimiento(Integer idConsentimiento) {
		this.idConsentimiento = idConsentimiento;
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
}
