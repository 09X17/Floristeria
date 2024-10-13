package Floristeria.service;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    public void enviarNotificacion(String email, String mensaje) {
        System.out.println("Notificación enviada a " + email + ": " + mensaje);
    }
}
