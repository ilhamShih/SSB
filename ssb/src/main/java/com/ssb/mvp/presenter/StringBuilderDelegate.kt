package com.ssb.mvp.presenter

interface StringBuilderDelegate {

    /** Возвращает текущий экземпляр StringBuilder.*/
    val currentBuilder: StringBuilder
   /**Добавляет строку `text` в конец текущего StringBuilder, если строка не пуста.*/
    fun appendString(text: String)
    /**Заменяет последнее вхождение строки `target` на строку `replacement`.
     *  Если строка `target` не найдена, никаких изменений не происходит.*/
    fun replaceString(target: String, replacement: String): StringBuilder
    /**Добавляет элементы из списка `items` в конец текущего StringBuilder.
     * Применяет метод `toString()` к каждому элементу списка перед добавлением.*/
    fun appendAllStrings(items: MutableList<*>)
    /**Удаляет первое или последнее вхождение строки `target` из текущего StringBuilder.
     *  Параметр `fromLast` определяет, удаляется ли последнее (`true`) или первое (`false`) вхождение.*/
    fun removeString(target: String, fromLast: Boolean): StringBuilder
    /**Удаляет все вхождения строки `target` из текущего StringBuilder.*/
    fun removeAllOccurrences(target: String): StringBuilder
    /**Удаляет последний символ из текущего StringBuilder, если он не пуст.*/
    fun removeLastCharacter(): StringBuilder
    /**Очищает текущий StringBuilder, удаляя все символы.*/
    fun clearBuilder(): StringBuilder
    /**Удаляет подстроку из текущего StringBuilder, начиная с индекса `start` и заканчивая индексом `end`.
     * Работает только если индексы находятся в допустимых пределах.*/
    fun removeSubstring(start: Int, end: Int): StringBuilder
    /**Вставляет строку `text` в текущий StringBuilder на позицию `start`.
     * Если передано значение `size = 0`, строка вставляется в начало.*/
    fun insertStringAtPosition(text: String?, start: Int, end: Int, size: Int)
    /**Возвращает флаг видимости. В данном случае всегда возвращает `true`.*/
    fun isVisible(): Boolean?
    /**Устанавливает флаг видимости. В данной реализации метод пуст и не выполняет никаких действий.*/
    fun setVisible(isVisible: Boolean?)
}