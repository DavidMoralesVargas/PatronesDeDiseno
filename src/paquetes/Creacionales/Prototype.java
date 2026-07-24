package paquetes.Creacionales;

//Clase cliente
public class Prototype {

    public static void main(String[] args) {
        Prototipo principal = new Personaje(1, "Nombre", "Ataque", 13);
        System.out.println("Objeto principal: " + principal);
        System.out.println("Campos del objetos principal: " + principal.toString());

        Prototipo clonado = principal.clonar();
        System.out.println("Objeto clonalo: " + clonado);
        System.out.println("Campos del objetos clonado: " + principal.toString());
    }

}

//Iterfaz para clonar
interface Prototipo{
    Prototipo clonar();
}

class Personaje implements Prototipo{

    private int Id;
    private String Nombre;
    private String AtaqueEspecial;
    private int Vida;

    public Personaje(){}

    public Personaje(int id, String nombre, String ataqueEspecial, int vida) {
        Id = id;
        Nombre = nombre;
        AtaqueEspecial = ataqueEspecial;
        Vida = vida;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAtaqueEspecial() {
        return AtaqueEspecial;
    }

    public void setAtaqueEspecial(String ataqueEspecial) {
        AtaqueEspecial = ataqueEspecial;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int vida) {
        Vida = vida;
    }

    //Método encargado de hacer la clonación
    @Override
    public Prototipo clonar() {
        return new Personaje(this.Id, this.Nombre, this.AtaqueEspecial, this.Vida);
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", AtaqueEspecial='" + AtaqueEspecial + '\'' +
                ", Vida=" + Vida +
                '}';
    }
}
