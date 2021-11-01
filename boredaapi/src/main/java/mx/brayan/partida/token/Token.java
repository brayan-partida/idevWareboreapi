package mx.brayan.partida.token;

public class Token {
	/**
	 * Objeto encargado de contener la informaci�n solicitada en una determinada
	 * operaci�n. Se ocupa un tipo Object para hacer uso del poliformismo, si el
	 * m�todo que se llama solicita un dato del tipo Usuario, obj contiene ese tipo
	 * de objeto. Si se solicita un dato del tipo Sistema, obj lo contiene. Incluso
	 * si se solicita una lista de objetos como ArrayList del tipo Estado, obj lo
	 * contiene.
	 */
	private Object obj;

	/**
	 * String con el mensaje personalizado de la funci�n Para una funci�n exitosa su
	 * valor por omisi�n es "Ok" Para una funci�n donde ocurre una excepci�n su
	 * valor por omisi�n es el mensaje de la excepci�n
	 */
	private String mensaje;

	/**
	 * Booleano con el resultado de la operaci�n que regresa el token Si el objetivo
	 * de la operaci�n se alcanza, este atributo tiene el valor verdadero Si no se
	 * alcanza el objetivo u ocurre una excepci�n, este atributo tiene el valor
	 * falso
	 */
	private boolean ok;
	private boolean error;

	/**
	 * Constructor por omisi�n que inicializa los parametros b�sicos de la clase.
	 */
	public Token() {
		this(true, "Ok", null);
	}

	/**
	 * Constructor con un token que va a contener una excepci�n
	 *
	 * @param e Excepcion que va a regresar
	 */
	public Token(Exception e) {
		this(false, e.getMessage(), e);
	}

	/**
	 * Constructor con un token que va a contener una excepci�n
	 *
	 * @param mensaje String con el mensaje personalizado de la excepcion para el
	 *                token
	 * @param e       Excepcion que va a regresar
	 */
	public Token(String mensaje, Exception e) {
		this(false, mensaje, e);
	}

	/**
	 * Constructor simple para una respuesta de token
	 *
	 * @param ok      Boolean con el valor del atributo ok del token
	 * @param mensaje String con el valor del mensaje del token
	 */
	public Token(boolean ok, String mensaje) {
		this(ok, mensaje, null);
	}

	/**
	 * Constructor para una operaci�n exitosa que devuelve un objeto, el atributo ok
	 * se inicializa como verdadero y el atributo mensaje se inicializa con el valor
	 * "Ok"
	 *
	 * @param obj Objeto que va a ser asignado al token
	 */
	public Token(Object obj) {
		if (obj != null && obj instanceof Exception) {
			this.ok = false;
			this.mensaje = ((Exception) obj).getMessage();
			this.obj = obj;
			this.error = true;
		} else {
			this.ok = true;
			this.mensaje = "Ok";
			this.obj = obj;
			this.error = false;
		}

	}

	/**
	 * Constructor para operaciones que devuelven un objeto y un mensaje
	 * personalizado, en caso de ser un objeto del tipo Exception, el atributo ok
	 * pasa a ser falso y el atributo error a verdadero; adicionalmente, si el
	 * mensaje es nulo o vac�o pasa a tener el mensaje del error
	 *
	 * @param ok
	 * @param mensaje
	 * @param obj
	 */
	public Token(boolean ok, String mensaje, Object obj) {
		this.obj = obj;
		this.ok = ok;
		this.mensaje = mensaje;
		this.error = false;
		if (this.obj != null) {
			if (this.obj instanceof Exception) {
				this.ok = false;
				if (mensaje == null || mensaje.trim().length() <= 0) {
					this.mensaje = ((Exception) this.obj).getMessage();
				}
				this.error = true;
			}
		}
	}

	/**
	 * m�todo que permite conocer el estado resultante de una operaci�n.
	 *
	 * @return true si la operaci�n fue exitosa, en caso contrario regresa false.
	 */
	public boolean getOk() {
		return ok;
	}

	/**
	 * Set para el atributo getOk.
	 *
	 * @param ok Recibe true o false.
	 */
	public void setOk(boolean ok) {
		this.ok = ok;
	}

	/**
	 * Get para el atributo mensaje
	 *
	 * @return una cadena con la informacion del error.
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Set para el atributo mensaje
	 *
	 * @param mensaje Recibe una cadena de texto
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Set para el atributo obj, en caso de ser un objeto del tipo excepci�n,
	 * autom�ticamente cambia el atributo ok a false y el atributo error a true
	 *
	 * @param obj recibe un objeto del tipo Object
	 */
	public void setObjeto(Object obj) {
		this.obj = obj;
	}

	/**
	 * Get para el atributo obj
	 *
	 * @return Regresa un objeto del tipo Object
	 */
	public Object getObjeto() {
		return obj;
	}

	/**
	 * Get para la excepci�n almacenada en el atributo obj en caso de que contenga
	 * un error
	 *
	 * @return Regresa un objeto del tipo Exception o nulo en caso de no ser un
	 *         objeto del tipo Exception
	 */
	public Exception getExcepcion() {
		if (this.obj instanceof Exception) {
			return (Exception) this.obj;
		}
		return null;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * Get para el atributo error
	 *
	 * @return Regresa un booleano indicando si el atributo obj tiene una variable
	 *         del tipo Exception
	 */
	public boolean getError() {
		return this.error;
	}
}
