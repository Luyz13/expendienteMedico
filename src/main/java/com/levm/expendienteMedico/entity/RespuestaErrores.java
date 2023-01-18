package com.levm.expendienteMedico.entity;

import java.util.Map;

public class RespuestaErrores extends RespuestaBase {
	
	private Map<String, String> errores;

	public Map<String, String> getErrores() {
		return errores;
	}

	public void setErrores(Map<String, String> errores) {
		this.errores = errores;
	}
	
	
	
	
}
