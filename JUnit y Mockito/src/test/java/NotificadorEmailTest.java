import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.example.EmailCliente;
import org.example.NotificadorEmail;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    @Test
    public void testNotificar() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("oscar.boj2000@gmail.com", "Hola Mundo");

        // Verificar que emailClienteMock.enviarCorreo se llamó con los argumentos correctos
        verify(emailClienteMock).enviarCorreo("oscar.boj2000@gmail.com", "Hola Mundo");
    }

    // Test para verificar que se lanza una excepción con dirección vacía
    @Test
    public void testNotificarConDireccionVacia() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Verificar que se lanza IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            notificador.notificar("", "Mensaje");
        });

        // Verificar que no se realiza el envío si la dirección es vacía
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar que se lanza una excepción con mensaje nulo
    @Test
    public void testNotificarConMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Verificar que se lanza IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            notificador.notificar("oscar.boj2000@gmail.com", null);
        });

        // Verificar que no se realiza el envío si el mensaje es nulo
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar que se lanza una excepción con dirección nula
    @Test
    public void testNotificarConDireccionNula() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Verificar que se lanza IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            notificador.notificar(null, "Mensaje");
        });

        // Verificar que no se realiza el envío si la dirección es nula
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar que se lanza una excepción con mensaje vacío
    @Test
    public void testNotificarConMensajeVacio() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Verificar que se lanza IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            notificador.notificar("oscar.boj2000@gmail.com", "");
        });

        // Verificar que no se realiza el envío si el mensaje es vacío
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }
}
