package org.example;

public class NotificadorEmail {
    private EmailCliente emailCliente;

    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String direccion, String mensaje) {
        // Verifica que la dirección y el mensaje no sean nulos o vacíos antes de enviar el correo
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección de correo no puede ser nula o vacía");
        }
        if (mensaje == null || mensaje.isEmpty()) {
            throw new IllegalArgumentException("El mensaje no puede ser nulo o vacío");
        }
        emailCliente.enviarCorreo(direccion, mensaje);
    }
}
