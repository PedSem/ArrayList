import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //Se añade en un Scanner para introducir los datos
    private static final Scanner scanner=new Scanner(System.in);
    private static final  TelefonoMovil telefonomovil=new TelefonoMovil("123456789");
    //Metodo para hacer un menu
    public static void imprimirMenu(){

        System.out.println("0-Salir");

        System.out.println("1-Imprimir Contactos");

        System.out.println("2-Agregar contacto");

        System.out.println("3-actualizar contacto");

        System.out.println("4-Eliminar contacto");

        System.out.println("5-Buscar/encontrar contacto");

        System.out.println("6-Volver a imprimir las opciones");

    }

    public static void main(String[] args) {

        boolean continuar = true;
        int opcion;
        imprimirMenu();
        while (continuar) {
            //Se hace una excepcion para asegurar que se escoge entre esas opciones
            try {
                System.out.println("Elige una opcion");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    //Opcion para salir
                    case 0:
                        System.out.println("Hasta luego");
                        break;
                    //Opcion para llamar printcontacts
                    case 1:
                        telefonomovil.printcontacts();
                        break;
                    //Opcion para llamar a addcontact
                    case 2:
                        addcontact();
                        break;
                    //Opcion para llamar actualizarcontacto
                    case 3:
                        actualizarcontacto();
                        break;
                    //Opcion para llamar eliminarcontacto
                    case 4:
                        Eliminarcontacto();
                        break;
                    //Opcion para llamar encontrarcontacto
                    case 5:
                        Encontrarcontacto();
                        break;
                    //Opcion para volver a imprimir el menu
                    case 6:
                        imprimirMenu();
                        break;
                }

            } catch (InputMismatchException e) {
                scanner.nextLine();

            }

        }
    }
    //Se añade un metodo para que introduzca el nombre y numerodetelefono
    public static void addcontact(){
        System.out.print("Ingresa el nombre:");
        String nombre= scanner.nextLine();
        //Excepcion para que el nombre no contenga numeros
        try {
            Integer.parseInt(nombre);
            System.err.println("Has introducido un numero cuando se esperaba un nombre");
            return;
        } catch (NumberFormatException e) {}

        System.out.println();
        System.out.print("Ingresa el numero de telefono:");
        String numerotelefono = scanner.nextLine();
        //Excepcion para que no contenga cualquier caracter el numerodetelefono
        try {
            Integer.parseInt(numerotelefono);
        } catch (NumberFormatException e) {
            System.err.println("El numero introducido contiene caracteres no validos");
            return;
        }
        Contacto contacto=Contacto.CreateContact(nombre,numerotelefono);
        //Dentro del metodo se añadirá ese nuevo contacto y se asegurará que no sea repetido
        boolean exito=telefonomovil.addNewContact(contacto);
        //Comprobar con un booleano si se ha cumplido el añadido del contacto
        if(exito){
            System.out.println("Se ha introducido correctamente");
        }else{
            System.out.println("Error ,Ese usuario ya existe");
        }


    }
    //Metodo para actualizar el contacto del nombre que se ha puesto
    public static void actualizarcontacto(){
        System.out.print("Introduce el nombre que quieres cambiar:");
        String ponernombre= scanner.nextLine();
        //Excepcion para que el nombre no contenga numeros
        try{
            Integer.parseInt(ponernombre);
            System.err.println("Has introducido un numero cuando se esperaba un nombre");
            return;
        } catch (NumberFormatException e) {}
        System.out.println();
        Contacto comprobarcontacto=telefonomovil.querycontact(ponernombre);
        System.out.print("Introduce el nuevo nombre:");
        String nombre= scanner.nextLine();
        //Excepcion para que el nombre no contenga numeros
        try {
            Integer.parseInt(nombre);
            System.err.println("Has introducido un numero cuando se esperaba un nombre");
            return;
        } catch (NumberFormatException e) {}

        System.out.println();
        System.out.print("Introduce el nuevo numero de telefono:");
        String numerotelefono= scanner.nextLine();
        //Excepcion para que no contenga cualquier caracter el numerodetelefono
        try {
            Integer.parseInt(numerotelefono);
        } catch (NumberFormatException e) {
            System.err.println("El numero introducido contiene caracteres no validos");
            return;
        }
        Contacto cambiarcontacto=Contacto.CreateContact(nombre,numerotelefono);
        //Asegurar que se ha modificado el contacto
        boolean exito=telefonomovil.UpdateContact(comprobarcontacto,cambiarcontacto);
        if(exito){
            System.out.println("Se cambió correctamente el contacto");
            System.out.println();

        }else{
            System.out.println("Error,el contacto inicial no existe");
        }

    }



    //Metodo para eliminar el contacto existente
    public static void Eliminarcontacto(){
        System.out.println("Que nombre deseas eliminar");
        String cambiarnombre= scanner.nextLine();
        //Excepcion para que el nombre no contenga numeros
        try{
            Integer.parseInt(cambiarnombre);
            System.err.println("Has introducido un numero cuando se esperaba un nombre");
            return;
        } catch (NumberFormatException e) {}
        System.out.println();
        //Dentro del metodo se asegurará que existe ese contacto y lo eliminará
        Contacto comprobarnombre=telefonomovil.querycontact(cambiarnombre);
        //Asegurar que se ha eliminado ese contacto
        boolean exito=telefonomovil.removeContact(comprobarnombre);
        if(exito){
            System.out.println("El contacto se borró correctamente");
            System.out.println();
        }else{
            System.out.println("El contacto no se borró porque no está en la lista");
        }

    }
    //Metodo para asegurar que ese contacto esta en la lista
    public static void Encontrarcontacto() {
        System.out.println("Introduce el nombre que desea buscar");
        String encontrarnombre = scanner.nextLine();
        //Excepcion para que el nombre no contenga numeros
        try{
            Integer.parseInt(encontrarnombre);
            System.err.println("Has introducido un numero cuando se esperaba un nombre");
            return;
        } catch (NumberFormatException e) {}
        System.out.println();

        Contacto contacto = telefonomovil.querycontact(encontrarnombre);
        //Asegurar que el contacto este dentro de esa lista
        if (contacto != null) {
            System.out.println("El nombre encontrado:" + contacto.getname() + "," + contacto.getPhoneNumber());
        } else {
            System.out.println("No se ha encontrado el contacto");
        }
    }
}

