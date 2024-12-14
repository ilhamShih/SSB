package com.ssb

import com.ssb.mvp.Flag
import com.ssb.mvp.presenter.StringBuilderWrapper
import org.junit.Test

class ExampleUnitTest {

    private val shhString = StringBuilderWrapper()
    private val arrayList =
        arrayListOf("String 1 ", "String 2 ", "String 3 ", "String 4 ", "String 5 ")

    @Test
    fun testDeleteOneLineFlags() {
        // Добавление строк из списка в StringBuilder
        shhString.appendAllStrings(arrayList)

        // --- Flag START_SEARCH ------
        println(shhString.removeString("Strin", Flag.START_SEARCH).toString())
        /** Результат:
         * Удаляет первое вхождение "Strin" начиная с начала строки.
         *
         * Результат: "g 1 String 2 String 3 String 4 String 5"
         */

        // --- Flag END_SEARCH ------
        println(shhString.removeString("String 4 ", Flag.END_SEARCH).toString())
        /** Результат:
         * Удаляет первое вхождение "String 4 " начиная с конца строки.
         *
         * Результат: "String 1 String 2 String 3 String 5"
         */
    }

    @Test
    fun testDeleteOneLine() {
        // Добавление строк из списка в StringBuilder
        shhString.appendAllStrings(arrayList)
        // Удаление первого вхождения "String 4 " начиная с конца строки
        println(shhString.removeString("String 4 ", Flag.END_SEARCH).toString())

        /** Результат:
         * Удаляет первое вхождение "String 4 ".
         *
         * Результат: "String 1 String 2 String 3 String 5"
         */
    }

    @Test
    fun testDeleteOneLineBaze() {
        // Добавление строк из списка в StringBuilder
        shhString.appendAllStrings(arrayList)

        // Удаляем последний символ до тех пор, пока длина строки не станет меньше 20
        do {
            println(shhString.removeLastCharacter().toString())
        } while (shhString.currentBuilder.length > 20)

        /** Результат:
         * Удаляет последний символ, пока строка не станет длиной меньше 20.
         * Пример на несколько шагов:
         *
         * String 1 String 2 String 3 String 4 String 5
         * String 1 String 2 String 3 String 4 String
         * String 1 String 2 String 3 String 4 Strin
         * String 1 String 2 String 3 String 4 Stri
         * String 1 String 2 String 3 String 4 Str
         * String 1 String 2 String 3 String 4 St
         * ...
         * После нескольких шагов строка укорачивается до нужной длины.
         */
    }

    @Test
    fun testUpdateStringToBuilder() {
        // Добавление строк из списка в StringBuilder
        shhString.appendAllStrings(arrayList)

        // Заменяем последнее вхождение "String 1" на "New String Main"
        println(shhString.replaceLastOccurrence(str = "String 1", "New String Main").toString())

        /** Результат:
         * Заменяет последнее вхождение "String 1" на "New String Main".
         *
         * Результат: "New String Main String 2 String 3 String 4 String 5"
         */
    }
}