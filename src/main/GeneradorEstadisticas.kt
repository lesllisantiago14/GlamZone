class GeneradorEstadisticas {(private val registroVentas: RegistroVentas) {

    fun calcularTotalVentas(): Double {
        return registroVentas.obtenerVentas().sumByDouble { it.precioTotal }
    }

    fun obtenerProductosMasVendidos(): Map<String, Int> {
        val ventasPorProducto = mutableMapOf<String, Int>()
        registroVentas.obtenerVentas().forEach { venta ->
            ventasPorProducto[venta.producto.nombre] = ventasPorProducto.getOrDefault(venta.producto.nombre, 0) + 1
        }
        return ventasPorProducto
    }
}

    fun interactuarConUsuario(): Cliente {
        println("¡Bienvenido a la tienda de maquillaje!")
        println("Por favor, introduce tu nombre:")
        val nombre = readLine() ?: "Cliente"
        println("Por favor, introduce tu edad:")
        val edad = readLine()?.toIntOrNull() ?: 0
        return Cliente(nombre, edad)
}