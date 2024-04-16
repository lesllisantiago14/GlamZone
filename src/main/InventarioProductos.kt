class InventarioProductos {
    private val productos = mutableListOf<ProductoMaquillaje>()

    // Método para agregar un nuevo producto al inventario
    fun agregarProducto(producto: ProductoMaquillaje) {
        productos.add(producto)
    }

    // Método para buscar un producto por su nombre
    fun buscarProducto(nombre: String): ProductoMaquillaje? {
        return productos.find { it.nombre == nombre }
    }
    fun productoDisponible(nombre: String): Boolean {
        return buscarProducto(nombre) != null
    }
}