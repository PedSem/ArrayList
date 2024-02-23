public class Contacto {
    
    //Añadir los campos tipos String
    private  String name;
    private String PhoneNumber;
    //LLamar los campos con el constructor
    public Contacto(String name,String PhoneNumber){
        this.name=name;
        this.PhoneNumber=PhoneNumber;


    }
    //Usar el metodo para llamar al name
    public String getname() {
        return name;
    }
    //Usar el metodo para llamar al PhoneNumber
    public String getPhoneNumber() {
        return PhoneNumber;
    }


    //Metodo para poder llamar tanto al name ccomo al PhoneNumber
    public static Contacto CreateContact(String name,String PhoneNumber){
        return new Contacto(name, PhoneNumber);
    }
}
