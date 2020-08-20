
public enum Roles {
	ADMINISTRADOR_SISTEMA("Administrador del sistema",1),
	JEFE_SECCION("Jefe de seccion", 2),
	OPERADOR_SECCION("Operador de seccion",3);
	
	private String nombre;
	private int indice;
	private Roles(String nombre, int indice) {
		this.nombre = nombre;
		this.indice = indice;
	}
	public String getNombre() {
		return nombre;
	}
	public int getIndice() {
		return indice;
	}
	
}
