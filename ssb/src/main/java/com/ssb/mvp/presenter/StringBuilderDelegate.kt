package com.ssb.mvp.presenter

import com.ssb.mvp.Flag

interface StringBuilderDelegate {

    /** Возвращает текущий экземпляр StringBuilder. */
    val currentBuilder: StringBuilder

    /**
     * Добавляет строку `text` в конец текущего StringBuilder, если строка не пуста.
     *
     * Пример:
     * val builder = StringBuilder("Hello")
     * builder.appendString(" World")
     * // Результат: "Hello World"
     */
    fun appendString(text: String)

    /**
     * Заменяет последнее вхождение строки `target` на строку `replacement`.
     * Если строка `target` не найдена, никаких изменений не происходит.
     *
     * Пример:
     * val builder = StringBuilder("Hello World")
     * builder.replaceString("World", "Kotlin")
     * // Результат: "Hello Kotlin"
     */
    fun replaceString(target: String, replacement: String): StringBuilder

    /**
     * Добавляет элементы из списка `items` в конец текущего StringBuilder.
     * Применяет метод `toString()` к каждому элементу списка перед добавлением.
     *
     * Пример:
     * val builder = StringBuilder("Hello")
     * builder.appendAllStrings(mutableListOf(1, 2, 3))
     * // Результат: "Hello123"
     */
    fun appendAllStrings(items: MutableList<*>)

    /**
     * Удаляет первое или последнее вхождение строки `target` из текущего StringBuilder.
     * Параметр `fromLast` определяет, удаляется ли последнее (`[Flag.END_SEARCH]`) или первое (`[Flag.START_SEARCH]`) вхождение.
     *
     * Пример:
     * val builder = StringBuilder("Hello World World")
     * builder.removeString("World", Flag.START_SEARCH)
     * // Результат: "Hello World"
     */
    fun removeString(target: String, fromLast: Flag): StringBuilder

    /**
     * Удаляет все вхождения строки `target` из текущего StringBuilder.
     *
     * Пример:
     * val builder = StringBuilder("Hello World World")
     * builder.removeAllOccurrences("World")
     * // Результат: "Hello "
     */
    fun removeAllOccurrences(target: String): StringBuilder

    /**
     * Удаляет последний символ из текущего StringBuilder, если он не пуст.
     *
     * Пример:
     * val builder = StringBuilder("Hello")
     * builder.removeLastCharacter()
     * // Результат: "Hell"
     */
    fun removeLastCharacter(): StringBuilder

    /**
     * Заменяет последнее вхождение строки `str` на новую строку `strNew` в объекте StringBuilder.
     *
     * Пример:
     * val builder = StringBuilder("Hello World")
     * builder.replaceLastOccurrence("World", "Kotlin")
     * // Результат: "Hello Kotlin"
     */
    fun replaceLastOccurrence(str: String, strNew: String): StringBuilder

    /**
     * Очищает текущий StringBuilder, удаляя все символы.
     *
     * Пример:
     * val builder = StringBuilder("Hello World")
     * builder.clearBuilder()
     * // Результат: ""
     */
    fun clearBuilder(): StringBuilder

    /**
     * Удаляет подстроку из текущего StringBuilder, начиная с индекса `start` и заканчивая индексом `end`.
     * Работает только если индексы находятся в допустимых пределах.
     *
     * Пример:
     * val builder = StringBuilder("Hello World")
     * builder.removeSubstring(0, 5)
     * // Результат: " World"
     */
    fun removeSubstring(start: Int, end: Int): StringBuilder

    /**
     * Вставляет строку `text` в текущий StringBuilder на позицию `start`.
     * Если передано значение `size = 0`, строка вставляется в начало.
     *
     * Пример:
     * val builder = StringBuilder("Hello World")
     * builder.insertStringAtPosition("Kotlin", 6, 11, 0)
     * // Результат: "Hello KotlinWorld"
     */
    fun insertStringAtPosition(text: String?, start: Int, end: Int, size: Int)

    /**
     * Возвращает флаг видимости. В данном случае всегда возвращает `true`.
     *
     * Пример:
     * val builder = StringBuilder("Hello")
     * builder.isVisible() // Результат: true
     */
    fun isVisible(): Boolean?

    /**
     * Устанавливает флаг видимости. В данной реализации метод пуст и не выполняет никаких действий.
     *
     * Пример:
     * builder.setVisible(false) // Не выполняет действий в текущей реализации.
     */
    fun setVisible(isVisible: Boolean?)

    /**
     * Добавляет в текущий StringBuilder элементы из списка `items`,
     * разделяя их строкой-разделителем `separator`.
     *
     * Пример:
     * val builder = StringBuilder("Apple")
     * builder.appendWithSeparator(listOf("Banana", "Orange"), ", ")
     * // Результат: "Apple, Banana, Orange"
     */
    fun appendWithSeparator(items: List<String>, separator: String)

    /**
     * Вставляет строку `text` в начало текущего StringBuilder.
     *
     * Пример:
     * val builder = StringBuilder("World")
     * builder.prependString("Hello ")
     * // Результат: "Hello World"
     */
    fun prependString(text: String)

    /**
     * Заменяет все вхождения строки `target` на строку `replacement` в текущем StringBuilder.
     *
     * Пример:
     * val builder = StringBuilder("apple apple apple")
     * builder.replaceAllOccurrences("apple", "orange")
     * // Результат: "orange orange orange"
     */
    fun replaceAllOccurrences(target: String, replacement: String): StringBuilder

    /**
     * Извлекает подстроку из текущего StringBuilder от позиции `start` до позиции `end`.
     * Возвращает пустую строку, если диапазон недействителен.
     *
     * Пример:
     * val builder = StringBuilder("Hello World")
     * builder.getSubstring(0, 5)
     * // Результат: "Hello"
     */
    fun getSubstring(start: Int, end: Int): String

    /**
     * Находит все вхождения строки `target` в текущем StringBuilder и возвращает список их позиций.
     *
     * Пример:
     * val builder = StringBuilder("apple orange apple banana apple")
     * builder.findAllOccurrences("apple")
     * // Результат: [0, 12, 24]
     */
    fun findAllOccurrences(target: String): List<Int>

    /**
     * Заменяет все вхождения строки `target` на строку `replacement` в текущем StringBuilder,
     * игнорируя регистр символов.
     *
     * Пример:
     * val builder = StringBuilder("Apple apple aPpLe")
     * builder.replaceIgnoreCase("apple", "orange")
     * // Результат: "orange orange orange"
     */
    fun replaceIgnoreCase(target: String, replacement: String): StringBuilder

    /**
     * Форматирует строку по заданному шаблону `format` с параметрами `args`
     * и добавляет её в конец текущего StringBuilder.
     *
     * Пример:
     * val builder = StringBuilder("The number is: ")
     * builder.appendFormattedString("%d", 42)
     * // Результат: "The number is: 42"
     */
    fun appendFormattedString(format: String, vararg args: Any)

    /**
     * Проверяет, является ли текущий StringBuilder пустым.
     *
     * Пример:
     * val builder = StringBuilder("Hello")
     * builder.isEmpty()
     * // Результат: false
     */
    fun isEmpty(): Boolean

    /**
     * Добавляет в текущий StringBuilder все строки из `strings`, разделяя их строкой-разделителем `separator`.
     *
     * Пример:
     * val builder = StringBuilder("Apple")
     * builder.appendStringsWithSeparator("Banana", "Orange", separator = ", ")
     * // Результат: "Apple, Banana, Orange"
     */
    fun appendStringsWithSeparator(vararg strings: String, separator: String)

    /**
     * Возвращает длину текущего StringBuilder.
     *
     * Пример:
     * val builder = StringBuilder("Hello World")
     * builder.length()
     * // Результат: 11
     */
    fun length(): Int
}