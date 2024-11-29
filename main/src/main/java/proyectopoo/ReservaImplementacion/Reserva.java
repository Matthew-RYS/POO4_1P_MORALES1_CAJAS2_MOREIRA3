package proyectopoo.ReservaImplementacion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.Dotenv;

public class Reserva {
    public Date fecha;
    public Espacio espacio;
    public Usuario usuario;
    public Estado estado;
    public int codigoReserva;
    public String motivo;
    public static int contador;

    public Reserva(String codigoReserva, String codigoU, String fecha, String codigoE, String estado, String motivo){
        this.codigoReserva = Integer.parseInt(codigoReserva);
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            this.fecha = formato.parse(fecha);
        } catch (Exception e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        this.usuario = buscarUsuario(codigoU);
        this.espacio = buscarEspacio(Integer.parseInt(codigoE));
        this.estado = Estado.valueOf(estado);
        this.motivo = motivo;

    }
    

    public String toString(){
        return "Codigo:" + this.codigoReserva+
               "Fecha: " + String.valueOf(fecha)+
               "Tipo espacio: " + String.valueOf(this.espacio.getTipoEspacio())+
               "Nombre espacio" + String.valueOf(this.espacio.getNombre())+
               "Capacidad: " + String.valueOf(this.espacio.getCapacidad())+
               "Nombres: " + this.usuario.getNombres()+
               "Apellidos" + this.usuario.getApellidos();
    }
    public Reserva(Date fecha, int codigoE, String motivo, Estado estado, String codigoU){
        this.fecha = fecha;
        this.motivo = motivo;
        this.estado = estado;
        this.usuario = buscarUsuario(codigoU);
        this.espacio = buscarEspacio(codigoE);
        ++contador;
    }
    public Reserva(Date fecha){
        this.fecha =fecha;
    }
    public Reserva(Date fecha, int codigoE, String motivo, String codigoU){
        this.fecha = fecha;
        this.motivo = motivo;
        this.estado = Estado.APROBADO;
        this.usuario = buscarUsuario(codigoU);
        this.codigoReserva = generarCodigo();
        this.usuario = buscarUsuario(codigoU);
        this.espacio = buscarEspacio(codigoE);
        
        ++contador;
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

    public  void enviarCorreo(){
        String linea1 = "El estudiante "+this.usuario.getNombres()+" y apellidos "+this.usuario.getApellidos()+" ha realizado una reserva con codigo "+this.codigoReserva+ " para la fecha "+this.fecha+" en la "+this.espacio.getTipoEspacio()+this.espacio.getNombre();
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
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mijomore@espol.edu.ec"));
            mes.setSubject("Reserva realizada");
            mes.setText(linea);
            Transport.send(mes);
        } catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

    public void enviarCorreo(String materia){
        String linea1 = "Se le notifica que el profesor "+this.usuario.getNombres()+" y apellidos "+this.usuario.getApellidos()+" ha realizado una reserva con codigo "+ this.codigoReserva+ " para la fecha "+this.fecha+" en la "+this.espacio.getTipoEspacio()+ this.espacio.getNombre()+" para la materia "+materia;
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
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mijomore@espol.edu.ec"));
            mes.setSubject("Reserva realizada");
            mes.setText(linea);
            Transport.send(mes);
        } catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

    public void enviarCorreo(Estado est, String motivo){
        String linea ="";
        if(est.equals(Estado.APROBADO)){
            String linea1 = "Se ha aprobado su reserva con codigo "+this.codigoReserva+" por el siguiente motivo "+motivo;
            String linea2 = "Atentamente,\nDepartamento Administrativo";
            linea = linea1 + "\n"+ linea2;
        }
        else if(est.equals(Estado.NEGADO)){
            String linea1 = "Se ha rechazado su reserva con codigo "+this.codigoReserva+" por el siguiente motivo "+motivo;
            String linea2 = "Atentamente,\nDepartamento Administrativo";
            linea = linea1 + "\n"+ linea2;
        }
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
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mijomore@espol.edu.ec"));
            mes.setSubject("Reserva realizada");
            mes.setText(linea);
            Transport.send(mes);
        } catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

    public static Date crearFecha(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el dia");
        int dia = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el mes");
        int mes = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la hora");
        int hora = sc.nextInt();
        @SuppressWarnings("deprecation")
        Date fecha = new Date(dia, mes, 2024, hora, 30);
        return fecha;
    }

    public Usuario buscarUsuario(String codigoU){
        for(Usuario u:Sistema.usuarios){
            if(u.getCodigoUnico() == codigoU){
                return u;
            }
        }
        return null;
    }

    public Espacio buscarEspacio(int codigoE){
        for(Espacio e:Sistema.espacios){
            if(e.getCodigoEspacio() == codigoE){
                return e;
            }
        }
        return null;
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
    public int getCodigoReserva() {
        return codigoReserva;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public void setCodigoReserva(int codigoReserva) {
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