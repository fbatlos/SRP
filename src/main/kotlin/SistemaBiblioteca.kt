data class Libro(val isbn: String, var titulo: String, var autor: String, var estado:estadoLibro = estadoLibro.disponibre)


object Informe{
    fun generarInformeLibro(libro: Libro) {
        // Generar un informe del empleado
        println("Libro : ${libro.titulo} de ${libro.autor} con isbn : ${libro.isbn} , está ${libro.estado}")
    }
}

object Prestamo{
    fun prestar(libro: Libro){
        if (Inventario.disponibilidadLibro(libro)){
            libro.estado = estadoLibro.prestado//Esto en Inventario
            println("Aquí tienes el libro.")
        }else{
            println("El libro ya ha sido prestado")
        }
    }

    fun devolver(libro: Libro){
        if (!Inventario.disponibilidadLibro(libro)){
            Inventario.añadirLibro(libro)
            libro.estado = estadoLibro.disponibre
            println("Gracias por devolverlo.")
        }else{
            println("Ya nos lo han devuelto.")
        }
    }
}

object Inventario{//Puede ser object o meter en un companion object
    private val inventario = mutableSetOf<Libro>()

    fun añadirLibro(libro: Libro){
        inventario.add(libro)
        println("Se añadió un libro.")
    }

    fun eliminarLibro(libro: Libro){
        inventario.forEach {
            if (libro == it){
                inventario.remove(libro)
                println("El libro ha sido removido.")
            }else {
                println("El libro no está.")
            }
        }

    }

    fun disponibilidadLibro(libro: Libro): Boolean {
        println("El libro ${libro.titulo} está ${libro.estado}")
        if (estadoLibro.disponibre == libro.estado){
            return true
        }else
            return false
    }

    fun mostarInventario() {
        inventario.forEach { Informe.generarInformeLibro(it) }
    }
}

fun main() {
    val libro1 = Libro("123-456-789" , "Kotlin para principiantes" , "Juan Pérez")
    val libro2 = Libro("987-654-321" , "Desarrollo de kotlin" , "Ana López")
    val libro3 = Libro("456-789-123" , "Fundamento en kotlin" , "Carlos Garcia")
    Inventario.añadirLibro(libro1)
    Inventario.añadirLibro(libro2)
    Inventario.añadirLibro(libro3)

    Inventario.mostarInventario()

    Prestamo.prestar(libro1)
    Prestamo.prestar(libro1)
    Prestamo.prestar(libro2)

    Informe.generarInformeLibro(libro1)

    Inventario.mostarInventario()

    Inventario.eliminarLibro(libro1)
    Inventario.eliminarLibro(libro1)

    Prestamo.devolver(libro1)
    Prestamo.devolver(libro2)





}