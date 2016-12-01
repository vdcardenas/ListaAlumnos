package salesianas.listaalumnos;

/**
 * Created by esaup on 01/12/2016.
 */

public class Alumno {
    private String nombre;
    private String dni;
    private String curso;
    private String telef;
    private byte imagen;


    public Alumno(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    public Alumno(String nombre, String dni, String curso, String telef, byte imagen) {
        this.nombre = nombre;
        this.dni = dni;
        this.curso = curso;
        this.telef = telef;
        this.imagen = imagen;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public byte getImagen() {
        return imagen;
    }

    public void setImagen(byte imagen) {
        this.imagen = imagen;
    }
}
