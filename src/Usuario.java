import java.util.Date;

public class Usuario {

	private String documento;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private Date fecNac;
	private String email;
	private String clave;
	private Rol rol;
	
	public Usuario(String documento, String nombre1, String apellido1, Date fecNac,  String email,
			String clave, Rol rol) {
		super();
		this.documento = documento;
		this.nombre1 = nombre1;
		this.apellido1 = apellido1;
		this.email = email;
		this.clave = clave;
		this.rol = rol;
		this.fecNac = fecNac;
	}

	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Date getFecNac() {
		return fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	
	

}
