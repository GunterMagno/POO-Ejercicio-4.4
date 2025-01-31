class Coche(
    marca: String?,
    modelo: String?,
    val caballos: Int,
    val puertas: Int,
    matricula: String,
    color: String
) {

    val marca: String = if (marca != null && marca.isNotBlank()) {
        marca.replaceFirstChar { it.uppercase() }
    } else {
        throw IllegalArgumentException("La marca no puede ser nula o vacía.")
    }

    val modelo: String = if (modelo != null && modelo.isNotBlank()) {
        modelo.replaceFirstChar { it.uppercase() }
    } else {throw IllegalArgumentException("El modelo no puede ser nulo o vacío.")}

    val matricula: String = if (matricula.length == 7) {
        matricula
    } else {throw IllegalArgumentException("La matrícula debe tener 7 caracteres.")}


    var color: String = color
        set(value) {
            if (value.isBlank()) throw IllegalArgumentException("El color no puede ser nulo o vacío.")
            field = value
        }

    init {
        require(caballos in 70..700) { "Los caballos deben estar entre 70 y 700." }
        require(puertas in 3..5) { "El número de puertas debe estar entre 3 y 5." }
    }

    override fun toString(): String {
        return "Coche(marca='$marca', modelo='$modelo', caballos=$caballos, puertas=$puertas, matricula='$matricula', color='$color')"
    }
}

fun main() {
    val coches = mutableListOf<Coche>()

    try {
        val coche1 = Coche("Toyota", "Corolla", 150, 4, "1234ABC", "Rojo")
        coches.add(coche1)
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche1: ${e.message}")
    }

    try {
        val coche2 = Coche("", "Focus", 120, 4, "5678DEF", "Azul")
        coches.add(coche2)
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche2: ${e.message}")
    }

    try {
        val coche3 = Coche("Ford", "", 200, 4, "9012GHI", "Negro")
        coches.add(coche3)
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche3: ${e.message}")
    }

    try {
        val coche4 = Coche("BMW", "X5", 50, 4, "3456JKL", "Blanco")
        coches.add(coche4)
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche4: ${e.message}")
    }

    try {
        val coche5 = Coche("Audi", "A3", 400, 6, "7890MNO", "Gris")
        coches.add(coche5)
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche5: ${e.message}")
    }

    try {
        val coche6 = Coche("Mercedes", "Clase A", 250, 4, "123ABC", "Verde")
        coches.add(coche6)
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche6: ${e.message}")
    }

    try {
        val coche7 = Coche("Volkswagen", "Golf", 180, 4, "1122XYZ", "Amarillo")
        coche7.color = ""
        coches.add(coche7)
    } catch (e: IllegalArgumentException) {
        println("Error al modificar el color de coche7: ${e.message}")
    }

    println("\n--- Coches creados correctamente ---")
    for (coche in coches) {
        println(coche)
    }
}
