package co.com.popstyle.servicios.manejo.exception;

public class InternalFatalError extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private static final String DESCRIPCION = "Error Interno del Servidor";
	
	public InternalFatalError(String detalle) {
		super(DESCRIPCION +" : "+detalle);
	}

}
