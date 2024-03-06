import GestorPedidos
import GestorPedidos as GestorPedidos1

interface ProcesarPedidos<T> {
    fun procesar(pedido:T)
}

data class PedidoFisico(val id:Int , val tipo:String , val detalles:String,val direccion:String)
data class PedidoDigital(val id:Int , val tipo:String , val detalles:String,val urlDescarga:String)
data class PedidoSuscripcion(val id:Int , val tipo:String , val detalles:String,val duracionSuscripcion:Int)


class ProcesadorPedidoDigital:ProcesarPedidos<PedidoDigital>{
    override fun procesar(pedido: PedidoDigital) {
        println("Procesando pedido ${pedido.tipo} : ${pedido.detalles} con url : ${pedido.urlDescarga}")
    }
}

class ProcesadorPedidoFisico:ProcesarPedidos<PedidoFisico>{
    override fun procesar(pedido: PedidoFisico) {
        println("Procesando pedido ${pedido.tipo} : ${pedido.detalles} con destinatario ${pedido.direccion}")
    }
}

class ProcesadorPedidoSuscripcion:ProcesarPedidos<PedidoSuscripcion> {
    override fun procesar(pedido: PedidoSuscripcion) {
        println("Procesando ${pedido.tipo} : ${pedido.detalles} con deracion ${pedido.duracionSuscripcion}")
    }
}

class GestorPedidos<T>{
    private val procesadores:ProcesarPedidos<T>
        get() {
            TODO()
        }
    fun gestionarProcesadores(procesarPedidos: ProcesarPedidos<T>){

    }
}

fun main() {
    //TODO: Crear un diccionario con la clave del tipo de pedido y el procesador que lo va a gestionar  Map<String, ProcesadorPedido>



    //TODO: Crear una variable gestorPedidos para gestionar los pedidos

    // Procesar pedidos...

    //TODO: Crear una variable que contenga un pedido 1 de tipo "digital" para un "E-book de Kotlin"





//TODO: Utilizar gestorPedidos para procesar este pedido
    gestorPedidos(PedidoDigital(1,"digital","E-book de Kotlin","tsafduyvsf.com"))
    //Hacer lo mismo para un pedido "fisico" ("Libro impreso de Kotlin") y procesarlo
    gestorPedidos(PedidoFisico(2,"fisico","Libro impreso de kotlin","C/augfasgfui 12"))
    //Hacer lo mismo para una "suscripción" ("Suscripción a curso de Kotlin") y procesarlo
    gestorPedidos(PedidoSuscripcion(3,"suscripcíon","Suscripción a curso de kotlin",12))
    //TODO: Hacer lo mismo para un tipo "desconocido" ("Producto misterioso") y procesarlo
    //TODO: Al procesar este pedido mostrará un mensaje de tipo de pedido no soportado.
}