package udc.keynerinfante.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
	@Table(name = "Usuarios")
	public class Usuario {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "clave")
	    private String clave;

	    @Column(name = "nombre")
	    private String nombre;

	    @Column(name = "apellido")
	    private String apellido;

	    @Column(name = "fecha_nacimiento")
	    private Date fechaNacimiento;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "genero")
	    private String genero;

	    @Column(name = "telefono")
	    private String telefono;

	    public Usuario() {
	    }

	    public Usuario(String clave, String nombre, String apellido, Date fechaNacimiento, String email, String genero, String telefono) {
	        this.clave = clave;
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.fechaNacimiento = fechaNacimiento;
	        this.email = email;
	        this.genero = genero;
	        this.telefono = telefono;
	    }

	    // Getters y Setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getClave() {
	        return clave;
	    }

	    public void setClave(String clave) {
	        this.clave = clave;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public Date getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    public void setFechaNacimiento(Date fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getGenero() {
	        return genero;
	    }

	    public void setGenero(String genero) {
	        this.genero = genero;
	    }

	    public String getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }
	}



