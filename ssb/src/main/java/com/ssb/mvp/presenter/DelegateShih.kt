package com.ssb.mvp.presenter

import java.lang.StringBuilder

interface DelegateShih {

    val smStringBuilder: StringBuilder
    fun addStringToBuilder(str: String) {}
    fun updateStringToBuilder(str: String, strNew: String): StringBuilder = StringBuilder()
    fun addAllStringToBuilder(str: MutableList<*>) {}
    fun deleteOneLine(str: String, boolean: Boolean): StringBuilder = StringBuilder()
    fun deleteAllLine(str: String): StringBuilder = StringBuilder()
    fun deleteOneLineBaze(): StringBuilder = StringBuilder()
    fun deleteAll(): StringBuilder = StringBuilder()
    fun deleteSelection(start: Int, end: Int): StringBuilder = StringBuilder()
    fun addStringToBuilderSelection(str: String?, start: Int, end: Int, size: Int) {}
    fun getShow(): Boolean? = false
    fun setShow(show1: Boolean?) {}

}