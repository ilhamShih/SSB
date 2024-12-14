package com.ssb.mvp.repository

import android.util.Log
import com.ssb.mvp.Flag
import com.ssb.mvp.presenter.StringBuilderDelegate


class StringBuilderRepository(private var builder: StringBuilder) : StringBuilderDelegate {

    override val currentBuilder: StringBuilder
        get() = builder

    override fun appendString(text: String) {
        if (text.isNotEmpty()) {
            currentBuilder.append(text)
        }
    }

    override fun replaceString(target: String, replacement: String): StringBuilder {
        val index = currentBuilder.lastIndexOf(target)
        if (index != -1) {
            currentBuilder.replace(index, index + target.length, replacement)
        }
        return currentBuilder
    }

    override fun appendAllStrings(items: MutableList<*>) {
        items.forEach { currentBuilder.append(it) }
    }

    override fun removeString(target: String, fromLast: Flag): StringBuilder {
        val index = when (fromLast) {
            Flag.END_SEARCH -> currentBuilder.lastIndexOf(target)
            Flag.START_SEARCH -> currentBuilder.indexOf(target)
        }
        if (index != -1) {
            currentBuilder.delete(index, index + target.length)
        }
        return currentBuilder
    }

    override fun removeAllOccurrences(target: String): StringBuilder {
        while (currentBuilder.contains(target)) {
            val index = currentBuilder.lastIndexOf(target)
            currentBuilder.delete(index, index + target.length)
        }
        return currentBuilder
    }

    override fun removeLastCharacter(): StringBuilder {
        if (currentBuilder.isNotEmpty()) {
            currentBuilder.deleteAt(currentBuilder.length - 1)
        }
        return currentBuilder
    }

    override fun clearBuilder(): StringBuilder {
        currentBuilder.clear()
        return currentBuilder
    }

    override fun removeSubstring(start: Int, end: Int): StringBuilder {
        if (start in 0..end && end <= currentBuilder.length) {
            currentBuilder.delete(start, end)
        }
        return currentBuilder
    }

    override fun insertStringAtPosition(
        text: String?,
        start: Int,
        end: Int,
        size: Int
    ) {
        if (text.isNullOrEmpty()) return
        val insertPosition = if (size == 0) 0 else start
        if (insertPosition in 0..end && end <= currentBuilder.length) {
            try {
                currentBuilder.insert(insertPosition, text)
            } catch (e: Exception) {
                Log.e("StringBuilderRepository", "Error in insertStringAtPosition: ${e.message}")
            }
        }
    }

    override fun replaceLastOccurrence(str: String, strNew: String): StringBuilder {
        val index = currentBuilder.lastIndexOf(str)
        if (index > -1 && currentBuilder.isNotEmpty()) {
            currentBuilder.replace(index, index + str.length, strNew)
        }
        return currentBuilder
    }

    override fun appendWithSeparator(items: List<String>, separator: String) {
        items.joinTo(currentBuilder, separator)
    }

    override fun prependString(text: String) {
        if (text.isNotEmpty()) {
            currentBuilder.insert(0, text)
        }
    }

    override fun replaceAllOccurrences(target: String, replacement: String): StringBuilder {
        var index = currentBuilder.indexOf(target)
        while (index != -1) {
            currentBuilder.replace(index, index + target.length, replacement)
            index = currentBuilder.indexOf(target, index + replacement.length)
        }
        return currentBuilder
    }

    override fun getSubstring(start: Int, end: Int): String {
        return if (start in 0..end && end <= currentBuilder.length) {
            currentBuilder.substring(start, end)
        } else {
            ""
        }
    }

    override fun findAllOccurrences(target: String): List<Int> {
        val indices = mutableListOf<Int>()
        var index = currentBuilder.indexOf(target)
        while (index != -1) {
            indices.add(index)
            index = currentBuilder.indexOf(target, index + 1)
        }
        return indices
    }

    override fun replaceIgnoreCase(target: String, replacement: String): StringBuilder {
        val regex = Regex("(?i)$target")
        currentBuilder.replace(
            0,
            currentBuilder.length,
            currentBuilder.toString().replace(regex, replacement)
        )
        return currentBuilder
    }

    override fun appendFormattedString(format: String, vararg args: Any) {
        currentBuilder.append(String.format(format, *args))
    }

    override fun isEmpty(): Boolean {
        return currentBuilder.isEmpty()
    }

    override fun appendStringsWithSeparator(vararg strings: String, separator: String) {
        strings.joinTo(currentBuilder, separator)
    }

    override fun length(): Int {
        return currentBuilder.length
    }

    override fun isVisible(): Boolean = true

    override fun setVisible(isVisible: Boolean?) {

    }
}