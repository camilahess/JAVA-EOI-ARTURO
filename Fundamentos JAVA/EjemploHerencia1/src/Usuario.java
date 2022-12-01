public class Usuario extends Persona { //clase de la cual heredo "Persona"

    private String correo;
    private String password;


    public Usuario(String nombre, int edad, String correo, String password) {
        //con super cogemos atributos de la clase base
        super(nombre, edad); // super clase, super es Persona, la clase de la cual heredamos. Lamamos al constructor de la clase Persona para inicializar.
        this.correo = correo;
        this.password = password;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Usuario [nombre="+ getNombre()+ ", edad=" + getEdad() + ", correo=" + correo + ", password=" + password + "]";

    }
    
}
