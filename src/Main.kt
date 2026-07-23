import java.util.Scanner

fun main() {
    println("=== ACTIVIDAD 2: 10 EJERCICIOS EN KOTLIN ===\n")

    // Instancia global del scanner para reutilizar en las lecturas de consola
    val scanner = Scanner(System.`in`)

    ejercicio1(scanner)
    ejercicio2(scanner)
    ejercicio3(scanner)
    ejercicio4(scanner)
    ejercicio5(scanner)
    ejercicio6(scanner)
    ejercicio7() // Llama a la función demostrando el uso de parámetros por defecto
    ejercicio8(scanner)
    ejercicio9(scanner)
    ejercicio10(scanner)
}

// ==================== EJERCICIO 1 ====================
// Pedir nombre y edad para mostrar saludo personalizado usando String Templates
fun ejercicio1(scanner: Scanner) {
    println("\n--- Ejercicio 1: Saludo Personalizado ---")
    print("Ingresa tu nombre: ")
    val nombre: String = scanner.nextLine()

    print("Ingresa tu edad: ")
    val edad: Int = scanner.nextLine().toIntOrNull() ?: 0

    saludar(nombre, edad)
}

fun saludar(nombre: String, edad: Int) {
    println("¡Hola, $nombre! Tienes $edad años y es un gusto saludarte.")
}

// ==================== EJERCICIO 2 ====================
// Calculadora básica con manejo de división por cero
fun ejercicio2(scanner: Scanner) {
    println("\n--- Ejercicio 2: Calculadora Básica ---")
    print("Ingresa el primer número: ")
    val num1: Double = scanner.nextLine().toDoubleOrNull() ?: 0.0

    print("Ingresa el segundo número: ")
    val num2: Double = scanner.nextLine().toDoubleOrNull() ?: 0.0

    val suma = num1 + num2
    val resta = num1 - num2
    val multiplicacion = num1 * num2

    println("Suma: $num1 + $num2 = $suma")
    println("Resta: $num1 - $num2 = $resta")
    println("Multiplicación: $num1 * $num2 = $multiplicacion")

    if (num2 != 0.0) {
        val division = num1 / num2
        println("División: $num1 / $num2 = $division")
    } else {
        println("División: No es posible dividir por cero.")
    }
}

// ==================== EJERCICIO 3 ====================
// Clasificador de edad utilizando la estructura `when`
fun ejercicio3(scanner: Scanner) {
    println("\n--- Ejercicio 3: Clasificador de Edad ---")
    print("Ingresa una edad para clasificar: ")
    val edad: Int = scanner.nextLine().toIntOrNull() ?: -1

    val categoria = when (edad) {
        in 0..12 -> "Niño"
        in 13..17 -> "Adolescente"
        in 18..59 -> "Adulto"
        in 60..120 -> "Adulto Mayor"
        else -> "Edad inválida"
    }

    println("Resultado: La categoría para $edad años es -> $categoria")
}

// ==================== EJERCICIO 4 ====================
// Cuenta regresiva desde un número dado usando un bucle `while`
fun ejercicio4(scanner: Scanner) {
    println("\n--- Ejercicio 4: Contador Regresivo ---")
    print("Ingresa un número entero para iniciar la cuenta regresiva: ")
    var contador: Int = scanner.nextLine().toIntOrNull() ?: 0

    if (contador <= 0) {
        println("Por favor ingresa un número entero positivo mayor a 0.")
        return
    }

    print("Cuenta regresiva: ")
    while (contador >= 0) {
        print("$contador ")
        contador--
    }
    println()
}

// ==================== EJERCICIO 5 ====================
// Promedio de 5 notas utilizando un bucle `for`
fun ejercicio5(scanner: Scanner) {
    println("\n--- Ejercicio 5: Promedio de 5 Notas ---")
    var sumaNotas = 0.0
    val totalNotas = 5

    for (i in 1..totalNotas) {
        print("Ingresa la nota #$i: ")
        val nota = scanner.nextLine().toDoubleOrNull() ?: 0.0
        sumaNotas += nota
    }

    val promedio = sumaNotas / totalNotas
    println("El promedio final de las $totalNotas notas es: ${String.format("%.2f", promedio)}")
}

// ==================== EJERCICIO 6 ====================
// Validador de Datos con Null Safety (?, ?:)
fun ejercicio6(scanner: Scanner) {
    println("\n--- Ejercicio 6: Validador de Datos (Null Safety) ---")

    print("Ingresa tu nombre (o deja vacío): ")
    val entradaNombre: String? = scanner.nextLine().takeIf { it.isNotBlank() }

    print("Ingresa tu edad (o deja vacío): ")
    val entradaEdad: Int? = scanner.nextLine().toIntOrNull()

    print("Ingresa tu altura en metros (ej. 1.75, o deja vacío): ")
    val entradaAltura: Double? = scanner.nextLine().toDoubleOrNull()

    // Manejo de nulos mediante el operador Elvis (?:)
    val nombreValido: String = entradaNombre ?: "Desconocido"
    val edadValida: Int = entradaEdad ?: 0
    val alturaValida: Double = entradaAltura ?: 0.0

    println("\n[Datos Procesados con Null Safety]")
    println("Nombre: $nombreValido")
    println("Edad: $edadValida años")
    println("Altura: $alturaValida m")
}

// ==================== EJERCICIO 7 ====================
// Función con parámetros por defecto
fun imprimirDatosPersonales(
    nombre: String = "Sin Nombre",
    edad: Int = 18,
    ciudad: String = "Medellín"
) {
    println("Nombre: $nombre | Edad: $edad | Ciudad: $ciudad")
}

fun ejercicio7() {
    println("\n--- Ejercicio 7: Función con Parámetros por Defecto ---")
    println("Llamada sin argumentos:")
    imprimirDatosPersonales()

    println("\nLlamada enviando solo el nombre:")
    imprimirDatosPersonales(nombre = "Carlos")

    println("\nLlamada enviando todos los argumentos:")
    imprimirDatosPersonales(nombre = "Sara", edad = 25, ciudad = "Bogotá")
}

// ==================== EJERCICIO 8 ====================
// Tabla de multiplicar del 1 al 10 usando bucle `for`
fun ejercicio8(scanner: Scanner) {
    println("\n--- Ejercicio 8: Tabla de Multiplicar ---")
    print("Ingresa el número del cual deseas ver la tabla: ")
    val numero: Int = scanner.nextLine().toIntOrNull() ?: 1

    println("Tabla del $numero:")
    for (i in 1..10) {
        val resultado = numero * i
        println("$numero x $i = $resultado")
    }
}

// ==================== EJERCICIO 9 ====================
// Conversor de temperatura (Celsius <-> Fahrenheit)
fun ejercicio9(scanner: Scanner) {
    println("\n--- Ejercicio 9: Conversor de Temperatura ---")
    println("1. Celsius a Fahrenheit")
    println("2. Fahrenheit a Celsius")
    print("Selecciona una opción (1 o 2): ")

    val opcion = scanner.nextLine().toIntOrNull() ?: 1

    when (opcion) {
        1 -> {
            print("Ingresa los grados Celsius: ")
            val celsius = scanner.nextLine().toDoubleOrNull() ?: 0.0
            val fahrenheit = (celsius * 9 / 5) + 32
            println("$celsius °C equivalen a ${String.format("%.2f", fahrenheit)} °F")
        }
        2 -> {
            print("Ingresa los grados Fahrenheit: ")
            val fahrenheit = scanner.nextLine().toDoubleOrNull() ?: 0.0
            val celsius = (fahrenheit - 32) * 5 / 9
            println("$fahrenheit °F equivalen a ${String.format("%.2f", celsius)} °C")
        }
        else -> println("Opción no válida.")
    }
}

// ==================== EJERCICIO 10 ====================
// Resumen Final Integrador
fun ejercicio10(scanner: Scanner) {
    println("\n--- Ejercicio 10: Resumen Final (Integrador) ---")

    print("Ingresa tu nombre completo: ")
    val nombreEntrada: String? = scanner.nextLine().takeIf { it.isNotBlank() }
    val nombre = nombreEntrada ?: "Usuario Anónimo"

    print("Ingresa tu edad: ")
    val edad = scanner.nextLine().toIntOrNull() ?: 0

    val categoria = when (edad) {
        in 0..12 -> "Niño"
        in 13..17 -> "Adolescente"
        in 18..59 -> "Adulto"
        in 60..120 -> "Adulto Mayor"
        else -> "Sin Clasificar"
    }

    val mensajePersonalizado = if (edad >= 18) {
        "¡Bienvenido/a $nombre! Tienes acceso completo a todas las funciones del sistema."
    } else {
        "¡Hola $nombre! Recuerda que estás navegando en modo restringido."
    }

    println("\n==========================================")
    println("           RESUMEN DEL USUARIO            ")
    println("==========================================")
    println("Nombre:     $nombre")
    println("Edad:       $edad años")
    println("Categoría:  $categoria")
    println("Estado:     $mensajePersonalizado")
    println("==========================================")
}