package com.ssb.mvp.presenter

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

    override fun removeString(target: String, fromLast: Boolean): StringBuilder =
        stringBuilderDelegate.removeString(target, fromLast)

    override fun removeAllOccurrences(target: String): StringBuilder =
        stringBuilderDelegate.removeAllOccurrences(target)

    override fun removeLastCharacter(): StringBuilder =
        stringBuilderDelegate.removeLastCharacter()

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
}