package proyectopoo;
import java.util.Random;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.*;
import java.util.Properties;

public class Reserva {
    public Date fecha;
    public Espacio espacio;
    public Usuario usuario;
    public Estado estado;
    public int cantidadReserva;
    public String codigoReserva;
    public String motivo;
    
    public Reserva(Date fecha, Espacio espacio, String motivo, Estado estado){
        this.fecha = fecha;
        this.espacio = espacio;
        this.motivo = motivo;
        this.estado = estado;
    }
    public void cambiarEstado(String estado, String motivo){
        this.estado=Estado.NEGADO;
        this.motivo=motivo;

    }

    private int generarCodigo(){
        Random rd= new Random();
        int codigo=rd.nextInt(9000)+1000;
        return codigo;
        
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // public Espacio getEspacioDisponible() {
    //     return espacioDisponible;
    // }

//    public void setEspacioDisponible(Espacio espacioDisponible) {
//        this.espacioDisponible = espacioDisponible;
//    }

    public void enviarCorreo(){
        String linea1 = "El estudiante "+this.usuario.getNombres()+" y apellidos "+this.usuario.getApellidos()+" ha realizado una reserva con codigo "+this.codigoReserva+ " para la fecha "+this.fecha+" en la "+this.espacio.getTipo()+this.espacio.getNombre();
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
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.usuario.getCorreo()));
            mes.setSubject("Reserva realizada");
            mes.setText(linea);
            Transport.send(mes);
        } catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

    public void enviarCorreo(String materia){
        String linea1 = "Se le notifica que el profesor "+this.usuario.getNombres()+" y apellidos "+this.usuario.getApellidos()+" ha realizado una reserva con codigo "+ this.codigoReserva+ " para la fecha "+this.fecha+" en la "+this.espacio.getTipo()+ this.espacio.getNombre()+" para la materia "+materia;
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
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.usuario.getCorreo()));
            mes.setSubject("Reserva realizada");
            mes.setText(linea);
            Transport.send(mes);
        } catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getCantidadReserva() {
        return cantidadReserva;
    }

    public void setCantidadReserva(int cantidadReserva) {
        this.cantidadReserva = cantidadReserva;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public Espacio getEspacio() {
        return espacio;
    }
    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }


}