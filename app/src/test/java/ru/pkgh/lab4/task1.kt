package ru.pkgh.lab4

fun main() {
    println("Задание 1. Фильтрация чисел и остатки")
    val numbers = mutableListOf<Int>()

    println("Вводите целые числа. Для окончания ввода введите 'стоп':")
    while (true) {
        print("Ввод: ")
        val input = readlnOrNull()?.trim()?.lowercase() ?: "стоп"
        if (input == "стоп") break

        val num = input.toIntOrNull()
        if (num == null) {
            println("Некорректный ввод! Нужно ввести целое число.")
            continue
        }
        numbers.add(num)
    }

    if (numbers.isEmpty()) {
        println("Ошибка: Вы не ввели ни одного числа!")
        return
    }

    print("\nВведите целое число-делитель: ")
    val divisor = readlnOrNull()?.trim()?.toIntOrNull()
    if (divisor == null || divisor == 0) {
        println("Ошибка: Делитель должен быть целым числом и не равен 0!")
        return
    }

    val divisible = numbers.filter { it % divisor == 0 }
    val notDivisible = numbers.filter { it % divisor != 0 }

    println("\nЧисла, делящиеся на $divisor без остатка: $divisible")
    println("Количество таких чисел: ${divisible.size}")
    println("Сумма таких чисел: ${divisible.sum()}")

    println("\nОстатки от деления остальных чисел:")
    if (notDivisible.isEmpty()) {
        println("Таких чисел нет.")
    } else {
        notDivisible.forEach { num ->
            println("Число $num | Остаток: ${num % divisor}")
        }
    }
}
