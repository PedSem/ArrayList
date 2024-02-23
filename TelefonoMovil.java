import java.util.ArrayList;

public class TelefonoMovil {
    //Añadir los campos de tipo ArrayList y String
    private final   ArrayList<Contacto>mycontacts;
    private final  String mynumber;
    //Usar el constructor para llamar al mynumber e instanciar mycontacts
    public TelefonoMovil(String mynumber) {
        this.mycontacts =new ArrayList();
        this.mynumber = mynumber;
    }

    /*
                    findContact, recibe un parámetro de tipo Contacto y devuelve un int. El valor
                devuelto es su posición en ArrayList, será -1 (no existe) o un valor mayor o
                igual a 0 (sí existe).
                     */
    //Comprobar que el contacto existe
    private int findContact(Contacto contacto){
        if(mycontacts.contains(contacto)){
            return mycontacts.indexOf(contacto);
        }else{
            return -1;
        }

    }
    /*
vii. findContact, igual que arriba, solo que recibe un parámetro de tipo String.
Busca en la lista si existe un contacto con ese nombre
     */
//Buscar si existe ese contacto
    private int findContact(String name) {
        for(int i=0;i<mycontacts.size();i++){
            if(mycontacts.get(i).getname().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;

    }



    /*
    queryContact, recibe un parámetro de tipo String y devuelve un contacto. Usa
el String para buscar el nombre y luego devuelve el contacto. Devuelve nulo en
caso contrario.
     */
//Metodo para buscar ese nobmre y devolver el contacto
    public Contacto querycontact(String name){
        if(findContact(name)>=0){
            return mycontacts.get(findContact(name));
        }else{
            return null;
        }


    }

    /*
    addNewContact, recibe un parámetro de tipo Contacto y devuelve un valor
booleano. Devuelve verdadero si el contacto no existe y se ha podido añadir a la
lista o falso si por el contrario el contacto ya existe (no debemos agregar el mismo
contacto dos veces, con el mismo nombre).
     */
    //Metodo para añadir un contacto y asegurar que no sea el mismo
    public boolean addNewContact(Contacto contacto){
        if (findContact(contacto)==-1){
            mycontacts.add(contacto);
            return true;
        }else{
            return false;
        }

    }
    //Metodo para eliminar un contacto
    public boolean removeContact(Contacto contacto){
        if(findContact(contacto)>=0){
            mycontacts.remove(contacto);
            return true;
        }else{

            return false;
        }
    }
    //Metodo para modificar un contacto que existe y cambiarlo por otro
    public boolean UpdateContact(Contacto contacto,Contacto newcontacto){
        if(findContact(contacto)>=0){
            mycontacts.set(findContact(contacto),newcontacto);
            return true;
        }else{

            return false;
        }
    }
    //Imprimir los contactos que se han añadido
    public void printcontacts(){
        System.out.println("Tenemos "+ mycontacts.size()+ " Elementos del array list");
        System.out.println("Lista de contactos:");
        for(Contacto contacto : mycontacts){
            System.out.println(contacto.getname() + " -> " + contacto.getPhoneNumber());
        }
    }



}
