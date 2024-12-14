package com.ssb.mvp.repository

import android.util.Log
import com.ssb.mvp.presenter.StringBuilderDelegate


class StringBuilderRepository(private var builder: StringBuilder) : StringBuilderDelegate {

    override val currentBuilder: StringBuilder
        get() = builder

    override fun appendString(text: String) {
        if (text.isNotEmpty()) {
            builder.append(text)
        }
    }

    override fun replaceString(target: String, replacement: String): StringBuilder {
        val index = builder.lastIndexOf(target)
        if (index != -1) {
            builder.replace(index, index + target.length, replacement)
        }
        return builder
    }

    override fun appendAllStrings(items: MutableList<*>) {
        items.forEach { builder.append(it) }
    }


    override fun removeString(target: String, fromLast: Boolean): StringBuilder {
        val index = if (fromLast) builder.lastIndexOf(target) else builder.indexOf(target)
        if (index != -1) {
            builder.delete(index, index + target.length)
        }
        return builder
    }

    override fun removeAllOccurrences(target: String): StringBuilder {
        while (builder.contains(target)) {
            val index = builder.lastIndexOf(target)
            builder.delete(index, index + target.length)
        }
        return builder
    }

    override fun removeLastCharacter(): StringBuilder {
        if (builder.isNotEmpty()) {
            builder.deleteAt(builder.length - 1)
        }
        return builder
    }

    override fun clearBuilder(): StringBuilder {
        builder.clear()
        return builder
    }

    override fun removeSubstring(start: Int, end: Int): StringBuilder {
        if (start in 0..end && end <= builder.length) {
            builder.delete(start, end)
        }
        return builder
    }

    override fun insertStringAtPosition(
        text: String?,
        start: Int,
        end: Int,
        size: Int
    ) {
        if (text.isNullOrEmpty()) return
        val insertPosition = if (size == 0) 0 else start
        if (insertPosition in 0..end && end <= builder.length) {
            try {
                builder.insert(insertPosition, text)
            } catch (e: Exception) {
                Log.e("StringBuilderRepository", "Error in insertStringAtPosition: ${e.message}")
            }
        }
    }

    override fun isVisible(): Boolean = true

    override fun setVisible(isVisible: Boolean?) {

    }
}