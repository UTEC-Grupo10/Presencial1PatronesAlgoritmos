
public enum Funcionalidades {
	CONTROL_INVENTARIO("Control de inventario",1),
	VENTAS("Ventas", 2),
	COMPRAS("Compras", 3),
	CUENTA_CORRIENTE("Cuenta corriente", 4),
	SUELDOS("Sueldos", 5);
	
	private String nombre;
	private int indice;
	private Funcionalidades(String nombre, int indice) {
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
