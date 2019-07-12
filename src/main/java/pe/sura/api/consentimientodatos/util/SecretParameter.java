package pe.sura.api.consentimientodatos.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecretParameter {
	
	@JsonProperty("CONSENTIMIENTO_SURA_SQLSERVER_URL")
	private String cercaniabdCoreUrl;

	@JsonProperty("CONSENTIMIENTO_SURA_SQLSERVER_USR")
	private String cercaniabdCoreUsr;

	@JsonProperty("CONSENTIMIENTO_SURA_SQLSERVER_PWD")
	private String cercaniabdCorePassw;
	
	@JsonProperty("CONSENTIMIENTO_KEY_ENCRIPTACION")
	private String keyEncriptacion;
	

	public String getCercaniabdCoreUrl() {
		return cercaniabdCoreUrl;
	}

	public void setCercaniabdCoreUrl(String cercaniabdCoreUrl) {
		this.cercaniabdCoreUrl = cercaniabdCoreUrl;
	}

	public String getCercaniabdCoreUsr() {
		return cercaniabdCoreUsr;
	}

	public void setCercaniabdCoreUsr(String cercaniabdCoreUsr) {
		this.cercaniabdCoreUsr = cercaniabdCoreUsr;
	}

	public String getCercaniabdCorePassw() {
		return cercaniabdCorePassw;
	}

	public void setCercaniabdCorePassw(String cercaniabdCorePassw) {
		this.cercaniabdCorePassw = cercaniabdCorePassw;
	}

	public String getKeyEncriptacion() {
		return keyEncriptacion;
	}

	public void setKeyEncriptacion(String keyEncriptacion) {
		this.keyEncriptacion = keyEncriptacion;
	}
	
	

}
