data class Empleado(val id: Int, var nombre: String, var puesto: String)


object Informacion{
    fun generarInformeEmpleado(empleado: Empleado) {
        // Generar un informe del empleado
        println("Generando informe para el empleado ${empleado.nombre}")
    }
}


object BaseDatosEmpleado{//Puede ser object o meter en un companion object
    fun guardarEmpleado(empleado: Empleado) {
        // Conexión a la base de datos
        println("Conectando a la base de datos...")
        // Lógica para guardar el empleado
        println("Empleado ${empleado.nombre} guardado en la base de datos")
    }

    fun eliminarEmpleado(empleado: Empleado) {
        // Conexión a la base de datos
        println("Conectando a la base de datos...")
        // Lógica para eliminar el empleado
        println("Empleado ${empleado.nombre} eliminado de la base de datos")
    }
}

fun main() {
    val empleado = Empleado(1, "Juan Pérez", "Desarrollador")
    BaseDatosEmpleado.guardarEmpleado(empleado)
    Informacion.generarInformeEmpleado(empleado)
    BaseDatosEmpleado.eliminarEmpleado(empleado)
}