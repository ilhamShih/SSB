package com.ssb.mvp.presenter

import com.ssb.mvp.Flag
import com.ssb.mvp.repository.StringBuilderRepository


class StringBuilderWrapper : StringBuilderDelegate {

    private var currentStringBuilder = StringBuilder()

    override val currentBuilder: StringBuilder
        get() = currentStringBuilder

    private val stringBuilderDelegate: StringBuilderDelegate =
        StringBuilderRepository(currentBuilder)

    override fun appendString(text: String) =
        stringBuilderDelegate.appendString(text)

    override fun replaceString(target: String, replacement: String): StringBuilder =
        stringBuilderDelegate.replaceString(target, replacement)

    override fun appendAllStrings(items: MutableList<*>) =
        stringBuilderDelegate.appendAllStrings(items)

    override fun removeString(target: String, fromLast: Flag): StringBuilder =
        stringBuilderDelegate.removeString(target, fromLast)

    override fun removeAllOccurrences(target: String): StringBuilder =
        stringBuilderDelegate.removeAllOccurrences(target)

    override fun removeLastCharacter(): StringBuilder =
        stringBuilderDelegate.removeLastCharacter()

    override fun replaceLastOccurrence(str: String, strNew: String): StringBuilder =
        stringBuilderDelegate.replaceLastOccurrence(str, strNew)


    override fun clearBuilder(): StringBuilder =
        stringBuilderDelegate.clearBuilder()

    override fun removeSubstring(start: Int, end: Int): StringBuilder =
        stringBuilderDelegate.removeSubstring(start, end)

    override fun insertStringAtPosition(text: String?, start: Int, end: Int, size: Int) =
        stringBuilderDelegate.insertStringAtPosition(text, start, end, size)

    override fun isVisible(): Boolean? =
        stringBuilderDelegate.isVisible()

    override fun setVisible(isVisible: Boolean?) =
        stringBuilderDelegate.setVisible(isVisible)

    override fun appendWithSeparator(items: List<String>, separator: String) {
        stringBuilderDelegate.appendWithSeparator(items, separator)
    }

    override fun prependString(text: String) {
        stringBuilderDelegate.prependString(text)
    }

    override fun replaceAllOccurrences(target: String, replacement: String): StringBuilder =
        stringBuilderDelegate.replaceAllOccurrences(target, replacement)

    override fun getSubstring(start: Int, end: Int): String =
        stringBuilderDelegate.getSubstring(start, end)

    override fun findAllOccurrences(target: String): List<Int> =
        stringBuilderDelegate.findAllOccurrences(target)

    override fun replaceIgnoreCase(target: String, replacement: String): StringBuilder =
        stringBuilderDelegate.replaceIgnoreCase(target, replacement)

    override fun appendFormattedString(format: String, vararg args: Any) {
        stringBuilderDelegate.appendFormattedString(format, args)
    }

    override fun isEmpty(): Boolean =
        stringBuilderDelegate.isEmpty()

    override fun appendStringsWithSeparator(vararg strings: String, separator: String) {
        stringBuilderDelegate.appendStringsWithSeparator(*strings, separator = separator)
    }

    override fun length(): Int =
        stringBuilderDelegate.length()

}