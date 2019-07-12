package pe.sura.api.consentimientodatos.util;

public class Constantes {

	public final static String NOT_FOUND_MESSAGE = "No encontrado";
	public final static String INTERNAL_SERVER_MESSAGE = "Error";
	
	/* OBJETOS MAPEADOS*/
	public final static String CONSENTIMIENTO = "Consentimiento";
	public final static String CONSENTIMIENTO_HISTORIAL = "ConsentimientoHistorial";
	public final static String EMPRESA = "Empresa";
	
	/*CAMPOS MAPEADOS DEL OBJETO CONSENTIMIENTO*/
	public final static String CONS_ID_EMPRESA = "idEmpresa";
	public final static String CONS_ID_CANAL = "idCanal";
	public final static String CONS_ID_TIPO_DOCUMENTO = "idTipoDocumento";
	public final static String CONS_NRO_DOCUMENTO = "nroDocumento";
	public final static String CONS_ESTADO = "estado";
	
	public final static String CONS_IDEMPRESA_ERROR_MSG = "Empresa inválida";
	public final static String CONS_IDCANAL_ERROR_MSG = "Canal por empresa inválido";
	public final static String CONS_IDTIPODOCUMENTO_ERROR_MSG = "Tipo documento inválido";
	public final static String CONS_NRODOCUMENTO_ERROR_MSG = "Empresa inválida";
	public final static String CONS_ESTADO_ERROR_MSG = "Estado inválido";
}
