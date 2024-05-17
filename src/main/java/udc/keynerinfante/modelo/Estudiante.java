package udc.keynerinfante.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 

    @Column(name = "usuario_id")
    public int usuarioId;

    @Column(name = "semestre")
    private int semestre;

    @Column(name = "carrera")
    private String carrera;

    @Column(name = "universidad")
    private String universidad;

    public Estudiante() {
        // Constructor vacío necesario para JPA
    }

    public Estudiante(int usuarioId, int semestre, String carrera, String universidad) {
        this.usuarioId = usuarioId;
        this.semestre = semestre;
        this.carrera = carrera;
        this.universidad = universidad;
    }

    // Getters y Setters


    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
}
