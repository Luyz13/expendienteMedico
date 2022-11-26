package com.levm.expendienteMedico.DTO;

public class Response {
	private long id;
	private String status;
	private String msj;

	public Response(long id, String status, String msj) {
		super();
		this.id = id;
		this.status = status;
		this.msj = msj;
	}

	public Response(long id) {
		super();
		this.id = id;

	}

	public Response() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}
