package ru.pkgh.lab4

fun main() {
    println("Задание 3. Транспонирование матрицы")
    print("Введите количество строк матрицы: ")
    val rows = readlnOrNull()?.trim()?.toIntOrNull()
    print("Введите количество столбцов матрицы: ")
    val cols = readlnOrNull()?.trim()?.toIntOrNull()

    if (rows == null || cols == null || rows <= 0 || cols <= 0) {
        println("Ошибка: Размеры матрицы должны быть положительными числами и не 0!")
        return
    }

    val matrix = Array(rows) { IntArray(cols) { (0..9).random() } }

    println("\nИсходная матрица:")
    printMatrix(matrix)

    val transposed = Array(cols) { i ->
        IntArray(rows) { j ->
            matrix[j][i]
        }
    }

    println("\nТранспонированная матрица:")
    printMatrix(transposed)
}

fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        for (element in row) {
            print(String.format("%3d", element))
        }
        println()
    }
}
