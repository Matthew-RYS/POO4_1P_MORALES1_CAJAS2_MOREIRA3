package proyectopoo;
import java.util.Date;
import java.util.ArrayList;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.*;
import java.util.Properties;

public class Profesor extends Usuario{
    private String facultad;
    private ArrayList<String> materias;

    public Profesor(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, String rol, String facultad, ArrayList<String> materias){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, rol);
        this.facultad=facultad;
        this.materias=materias;
    }
    
    @Override
    public void gestionarReserva(Date fecha, Espacio espacio, String materia){
        Reserva r = new Reserva(fecha, espacio, materia, Estado.APROBADO);
    }

    public void enviarCorreo(Reserva r){
        String linea1 = "Se le notifica que el profesor "+this.nombres+" y apellidos "+this.apellidos+" ha realizado una reserva con codigo "+ r.getCodigoReserva()+ " para la fecha "+r.getFecha()+" en la "+r.getEspacio().getTipo()+r.getEspacio().getNombre()+" para la materia "+r.getMotivo();
        String linea2 = "Ingrese al sistema para aprobar o rechazar la reserva";
        String linea = linea1 + "\n"+ linea2;
        Dotenv dot = Dotenv.load(); 
        String host = dot.get("MAIL_HOST");
        String port = dot.get("MAIL_PORT");
        String user = dot.get("MAIL_USER");
        String pass = dot.get("MAIL_PASS");
        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user,pass);
            }
        });

        try {
            Message mes = new MimeMessage(session);
            mes.setFrom(new InternetAddress(user, "APP RESERVAS"));
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.correo));
            mes.setSubject("Reserva realizada");
            mes.setText(linea);
            Transport.send(mes);
        } catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void consultarReserva(Date fecha){
    }
    public String getFacultad(){
        return facultad;
    }
    public String getMaterias(){
        return String.join(" ", materias);
    }
    public void setFacultad(String facultad){
        this.facultad = facultad;
    }
    public void setMaterias(ArrayList<String> materias){
        this.materias = materias;
    }

    
}
