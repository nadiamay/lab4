package ru.pkgh.lab4

fun main() {
    println("Задание 2. Алфавитный анализатор текста")
    print("Введите строку текста: ")
    val text = readlnOrNull()?.trim() ?: ""

    if (text.isEmpty()) {
        println("Ошибка: Текст пуст!")
        return
    }

    val words = text.split("[\\s,.:;!?\\-\"]+".toRegex())
        .filter { it.isNotEmpty() }
        .map { it.lowercase() }

    if (words.isEmpty()) {
        println("Ошибка: В тексте не найдено слов!")
        return
    }

    println("\nСлова в алфавитном порядке: ${words.sorted().distinct()}")
    println("Слова в обратном алфавитном порядке: ${words.sortedDescending().distinct()}")

    print("\nВведите одну букву для поиска слов: ")
    val searchLetter = readlnOrNull()?.trim()?.lowercase() ?: ""

    if (searchLetter.length != 1) {
        println("Ошибка: Нужно ввести ровно одну букву!")
    } else {
        val filteredWords = words.filter { it.startsWith(searchLetter) }.distinct()
        if (filteredWords.isEmpty()) {
            println("Слов, начинающихся на букву '$searchLetter', не найдено.")
        } else {
            println("Слова на букву '$searchLetter': $filteredWords")
        }
    }
}
