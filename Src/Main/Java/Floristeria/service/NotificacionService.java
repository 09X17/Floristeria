package Floristeria.service;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    public void enviarNotificacion(String email, String mensaje) {
        // Implementa la lógica de envío de notificaciones (por ejemplo, correo electrónico)
        System.out.println("Notificación enviada a " + email + ": " + mensaje);
    }
}
