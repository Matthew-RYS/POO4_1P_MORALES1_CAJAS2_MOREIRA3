package proyectopoo;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.*;
import java.util.Properties;
public class Estudiante extends Usuario{
    private String matricula;
    private String carrera;

    public Estudiante(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, String rol, String matricula, String carrera){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, rol);
        this.matricula=matricula;
        this.carrera=carrera;
    }


    @Override
    public void gestionarReserva(Date fecha, Espacio espacio, String motivo){ 
        Reserva r = new Reserva(fecha, espacio, motivo, Estado.PENDIENTE);
    }
    public void enviarCorreo(Reserva r){
        String linea1 = "El estudiante "+this.nombres+" y apellidos "+this.apellidos+" ha realizado una reserva con codigo "+ r.getCodigoReserva()+ " para la fecha "+r.getFecha()+" en la "+r.getEspacio().getTipo()+r.getEspacio().getNombre();
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
    public String getMatricula(){
        return matricula;
    }
    public String getCarrera(){
        return carrera;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public void setCarrera(String carrera){
        this.carrera = carrera;
    }
    
}
