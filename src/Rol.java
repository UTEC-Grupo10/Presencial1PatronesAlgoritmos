import java.util.LinkedList;

public class Rol {

	private Roles rol;
	private LinkedList<Funcionalidades> funcionalidades = new LinkedList();
	public Rol() {
		// TODO Auto-generated constructor stub
	}
	public Roles getRol() {
		return rol;
	}
	public void setRol(Roles rol) {
		this.rol = rol;
	}
	public LinkedList<Funcionalidades> getFuncionalidades() {
		return funcionalidades;
	}
	public void setFuncionalidades(LinkedList<Funcionalidades> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
	

}
