class RegistroVentas {
    private val ventas = mutableListOf<Venta>()

    // Método para agregar una venta al registro
    fun agregarVenta(venta: Venta) {
        ventas.add(venta)
    }

    // Método para obtener todas las ventas realizadas
    fun obtenerVentas(): List<Venta> {
        return ventas.toList()
    }
}