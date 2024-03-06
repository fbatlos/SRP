
interface metodoNotificador {
    fun enviarNotificacion(usuario: Usuario, mensaje: String)
}

class NotificacionEmai:metodoNotificador{
    override fun enviarNotificacion(usuario: Usuario, mensaje: String) {
           println("Enviando correo electrónico a ${usuario.email}: $mensaje")
        }
}
class NotificacionTelefono:metodoNotificador{
    override fun enviarNotificacion(usuario: Usuario, mensaje: String) {
            println("Enviando SMS a ${usuario.telefono}: $mensaje")
    }
}

class Notificador(private val metodo:metodoNotificador){
    fun enviarNotificacion(usuario: Usuario,mensaje: String){
        metodo.enviarNotificacion(usuario,mensaje)
    }
}

data class Usuario(val nombre: String, val email: String, val telefono: String)

// Uso
fun main() {
    val usuario = Usuario("Juan", "juan@example.com", "1234567890")
    val notificacionemail = Notificador(NotificacionEmai())
    notificacionemail.enviarNotificacion(usuario,"Hola")
    Notificador(NotificacionTelefono()).enviarNotificacion(usuario,"Pan")

}