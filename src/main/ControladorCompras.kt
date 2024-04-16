class ControladorCompras
    ( private val inventario: InventarioProductos){
    fun comprarProducto(cliente: Cliente, nombreProducto: String): ProductoMaquillaje {
        if (!inventario.productoDisponible(nombreProducto)) {
            // Si el producto no está disponible, lanzamos una excepción
            throw ProductoNoDisponibleException(nombreProducto)
        }
        val producto = inventario.buscarProducto(nombreProducto)!!
        // Simulación de compra
        println("${cliente.nombre} ha comprado ${producto.nombre} por ${producto.precio}")
        return producto
    }
}

val labialRojo = ProductoMaquillaje("Labial Rojo", "Labial", 15.99)
val sombraOjos = ProductoMaquillaje("Sombra de Ojos", "Sombra", 12.50)


val inventario = InventarioProductos()
inventario.agregarProducto(labialRojo)
inventario.agregarProducto(sombraOjos)


val cliente = interactuarConUsuario()


val controladorCompras = ControladorCompras(inventario)

val registroVentas = RegistroVentas()

while (true) {
    println("¿Qué producto deseas comprar? (Escribe 'salir' para salir)")
    val producto = readLine() ?: ""
    if (producto.equals("salir", ignoreCase = true)) {
        println("¡Gracias por visitarnos!")
        break
    }

    try {
        val productoComprado = controladorCompras.comprarProducto(cliente, producto)
        registroVentas.agregarVenta(Venta(cliente, productoComprado, productoComprado.precio))
    } catch (ex: ProductoNoDisponibleException) {
        println(ex.message)
    }
}

val generadorEstadisticas = GeneradorEstadisticas(registroVentas)
println("Total de ventas: ${generadorEstadisticas.calcularTotalVentas()}")
println("Productos más vendidos:")
val productosMasVendidos = generadorEstadisticas.obtenerProductosMasVendidos()
productosMasVendidos.forEach { (producto,cantidad) ->
    println("$producto: $cantidad")
}
}

