package com.ssb.mvp.presenter

import com.ssb.mvp.repository.RepositoryShih
import kotlin.text.StringBuilder


class ShihString : DelegateShih {

    private var mStringBuilder = StringBuilder()

    override val smStringBuilder: StringBuilder get() = mStringBuilder

    private val mDelegateShih: DelegateShih = RepositoryShih(smStringBuilder)

    override fun addStringToBuilder(str: String) = mDelegateShih.addStringToBuilder(str)


    override fun updateStringToBuilder(str: String, strNew: String): StringBuilder =
        mDelegateShih.updateStringToBuilder(str, strNew)


    override fun addAllStringToBuilder(str: MutableList<*>) =
        mDelegateShih.addAllStringToBuilder(str)


    override fun deleteOneLine(str: String, boolean: Boolean): StringBuilder =
        mDelegateShih.deleteOneLine(str, boolean)

    override fun deleteAllLine(str: String): StringBuilder = mDelegateShih.deleteAllLine(str)


    override fun deleteOneLineBaze(): StringBuilder = mDelegateShih.deleteOneLineBaze()

    override fun deleteAll(): StringBuilder = mDelegateShih.deleteAll()

    override fun deleteSelection(start: Int, end: Int): StringBuilder =
        mDelegateShih.deleteSelection(start, end)

    override fun addStringToBuilderSelection(str: String?, start: Int, end: Int, size: Int) =
        mDelegateShih.addStringToBuilderSelection(str, start, end, size)

    override fun getShow(): Boolean? = mDelegateShih.getShow()

    override fun setShow(show1: Boolean?) = mDelegateShih.setShow(true)




}