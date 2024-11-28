package proyectopoo.ReservaImplementacion;
import java.util.ArrayList;
import java.util.Scanner;
import proyectopoo.ReservaImplementacion.archivo.ManejoArchivos;
public class Sistema {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();                 
    public static ArrayList<Espacio> espacios = new ArrayList<>();
    public static ArrayList<Reserva> reservas = new ArrayList<>();
    public static ArrayList<Estudiante> estudiantes;
    public static ArrayList<Profesor> profesores;

    public static void logIn(String usuario, String contrasena) {
        //ArrayList<String> lineas = ManejoArchivos.LeeFichero("Usuario.txt");   
        boolean usuarioEncontrado = false;  
        String rol = "";
        String codigoUnico = "";
    
        // for (String linea : lineas) {
        //     String[] palabras = linea.split("\\|");
        //     if (palabras[4].equals(usuario) && palabras[5].equals(contrasena)) {//(usuario.equals("jperez")&&contrasena.equals("contrasena123")){
                 rol = "E";//palabras[7];
                 usuarioEncontrado = true;
                 codigoUnico = "001";//palabras[0];
        //         //break;
        //     }
        // }
        mostrarMenu(codigoUnico, rol, usuarioEncontrado);
    }
    

    public static void mostrarMenu(String codigoUnico, String rol, boolean usuarioEncontrado) {
        Scanner sc = new Scanner(System.in);
        int cantidadEspacio = 1;

        if (usuarioEncontrado) {
            boolean continuar = true;
            while (continuar) {
                System.out.println("\nBienvenido/a al sistema de Reservas");
                System.out.println("Elija una opción:");
                System.out.println("1. Gestionar Reserva");
                System.out.println("2. Consultar Reserva");
                System.out.println("3. Salir");

                int opcion = sc.nextInt();
                sc.nextLine(); 
                switch (opcion) {
                    case 1:
                        switch (rol) { 
                            case "E":
                                Estudiante e = new Estudiante(codigoUnico);
                                if(cantidadEspacio==1){
                                    e.gestionarReserva();
                                }
                                else{
                                    System.out.println("No se puede generar mas reservas");
                                }
                                break;
                            case "P":
                                Profesor p = new Profesor(codigoUnico);
                                p.gestionarReserva();
                                break;
                            case "A":
                                Admin a = new Admin(codigoUnico);
                                a.gestionarReserva();
                                break;
                            }
                    case 2:
                        switch (rol) {
                            case "E":
                                Estudiante e = new Estudiante(codigoUnico);
                                e.consultarReserva(Reserva.crearFecha());
                                break;
                            case "P":
                                Profesor p = new Profesor(codigoUnico);
                                p.consultarReserva(Reserva.crearFecha());
                                break;
                            case "A":
                                Admin.consultarReserva();
                                break;
                        }
                        break;
                    case 3:
                        continuar = false;
                        System.out.println("Gracias por usar el sistema de Reservas. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            }
        } else {
            System.out.println("Inicio de sesión inválido. Por favor, revise sus credenciales.");
        }
        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("RESERVAS ESPOL");
        System.out.print("Ingrese su usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        Usuario u = new Estudiante("002");
        Usuario r = new Estudiante("012");
        Usuario f = new Estudiante("022");
        Usuario g = new Estudiante("032");
        ArrayList<Usuario> usur = new ArrayList<Usuario>();
        usur.add(g);
        usur.add(f);
        usur.add(r);
        usur.add(u);
        Espacio e = new Espacio(Espacios.AULA,usur, "Aula", EstadoEspacio.DISPONIBLE, Rol.ESTUDIANTE, 2);
        Sistema.espacios.add(e);
        String contrasena = sc.nextLine();
        logIn(usuario, contrasena);
        sc.close();

    }

    public static void regresarMenuPrincipal(String codigoUnico, String rol){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDesea realizar otra acción? (Sí/No)");
        String continuar = sc.nextLine();
        if (continuar.equalsIgnoreCase("Sí")) {
            mostrarMenu(codigoUnico, rol, true);
        } else {
            System.out.println("Gracias por usar el sistema de Reservas. ¡Hasta pronto!");
        }
    }
}
