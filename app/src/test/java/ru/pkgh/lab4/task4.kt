package ru.pkgh.lab4

data class Book(val author: String, val title: String, val year: Int)

fun main() {
    val library = mutableListOf<Book>()

    library.add(Book("Александр Пушкин", "Капитанская дочка", 1836))
    library.add(Book("Михаил Булгаков", "Мастер и Маргарита", 1967))
    library.add(Book("Александр Пушкин", "Евгений Онегин", 1833))
    library.add(Book("Лев Толстой", "Война и мир", 1869))

    while (true) {
        println("\n=== МЕНЮ БИБЛИОТЕКИ ===")
        println("1. Добавить книгу")
        println("2. Найти все книги автора")
        println("3. Найти книги в диапазоне лет")
        println("4. Показать все книги (сортировка по году)")
        println("5. Выход")
        print("Выберите пункт меню (1-5): ")

        val choice = readlnOrNull()?.trim()
        if (choice == "5" || choice?.lowercase() == "выход") {
            println("Программа завершена!")
            break
        }

        when (choice) {
            "1" -> {
                println("\n--- Добавление книги ---")
                print("Введите автора: ")
                val author = readlnOrNull()?.trim() ?: ""
                print("Введите название книги: ")
                val title = readlnOrNull()?.trim() ?: ""
                print("Введите год издания: ")
                val year = readlnOrNull()?.trim()?.toIntOrNull()

                if (author.isEmpty() || title.isEmpty() || year == null || year <= 0) {
                    println("Ошибка: Некорректные данные!")
                } else {
                    library.add(Book(author, title, year))
                    println("Книга успешно добавлена!")
                }
            }
            "2" -> {
                println("\n--- Поиск по автору ---")
                print("Введите имя автора: ")
                val searchAuthor = readlnOrNull()?.trim() ?: ""
                val result = library.filter { it.author.contains(searchAuthor, ignoreCase = true) }
                if (result.isEmpty()) println("Книг не найдено.")
                else result.forEach { println("- ${it.title} (${it.year} г.)") }
            }
            "3" -> {
                println("\n--- Поиск в диапазоне лет ---")
                print("Введите начальный год: ")
                val startYear = readlnOrNull()?.trim()?.toIntOrNull()
                print("Введите конечный год: ")
                val endYear = readlnOrNull()?.trim()?.toIntOrNull()

                if (startYear == null || endYear == null || startYear > endYear) {
                    println("Ошибка: Неверный диапазон!")
                } else {
                    val result = library.filter { it.year in startYear..endYear }
                    if (result.isEmpty()) println("Книг не найдено.")
                    else result.forEach { println("- [${it.year}] ${it.author} — \"${it.title}\"") }
                }
            }
            "4" -> {
                println("\n--- Все книги библиотеки (по году) ---")
                if (library.isEmpty()) println("Библиотека пуста.")
                else library.sortedBy { it.year }.forEach { println("[${it.year} г.] ${it.author} — \"${it.title}\"") }
            }
            else -> println("Ошибка: Неверный пункт меню!")
        }
    }
}
