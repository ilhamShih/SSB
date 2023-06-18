package com.ssb.mvp.repository

import android.util.Log
import com.ssb.mvp.presenter.DelegateShih


class RepositoryShih(mStringBuilder: StringBuilder) : DelegateShih {

    private var stringBuilder: StringBuilder = mStringBuilder

    override val smStringBuilder: StringBuilder get() = stringBuilder

    override fun addStringToBuilder(str: String) {
        if (str.isNotEmpty()) {
            smStringBuilder.append(str)
        }
    }

    override fun updateStringToBuilder(str: String, strNew: String): StringBuilder {
        if (smStringBuilder.lastIndexOf(str) > -1 && smStringBuilder.isNotEmpty()) if (smStringBuilder.lastIndexOf(
                str
            ) > -1
        ) {
            if (smStringBuilder.isNotEmpty()) {
                val i = smStringBuilder.lastIndexOf(str)
                smStringBuilder.replace(i, i + str.length, strNew)
            }
        }
        return smStringBuilder
    }

    override fun addAllStringToBuilder(str: MutableList<*>) {
        for (i2 in str.indices)
            smStringBuilder.append(str[i2])
    }

    override fun deleteOneLine(str: String, boolean: Boolean): StringBuilder {
        if (smStringBuilder.lastIndexOf(str) > -1 && smStringBuilder.isNotEmpty())
            if (smStringBuilder.lastIndexOf(str) > -1) {
                if (smStringBuilder.isNotEmpty()) {
                    if (boolean) {
                        val i = smStringBuilder.lastIndexOf(str)
                        smStringBuilder.delete(i, i + str.length)
                    } else {
                        val i = smStringBuilder.indexOf(str)
                        smStringBuilder.delete(i, str.length)
                    }
                }
            }
        return smStringBuilder
    }

    override fun deleteAllLine(str: String): StringBuilder {
        if (smStringBuilder.lastIndexOf(str) > -1 && smStringBuilder.isNotEmpty())
            for (i2 in smStringBuilder.indices)
                if (smStringBuilder.lastIndexOf(str) > -1 && smStringBuilder.isNotEmpty()) {
                    val i = smStringBuilder.lastIndexOf(str)
                    smStringBuilder.delete(i, i + str.length)
                } else {
                    break
                }
        return smStringBuilder
    }

    override fun deleteOneLineBaze(): StringBuilder {
        if (smStringBuilder.isNotEmpty()) {
            val coll = smStringBuilder.length
            smStringBuilder.delete(coll - 1, coll)
        }
        return smStringBuilder
    }

    override fun deleteAll(): StringBuilder {
        if (smStringBuilder.isNotEmpty()) {
            val coll = smStringBuilder.length
            smStringBuilder.delete(0, coll)
        }
        return smStringBuilder
    }

    override fun deleteSelection(start: Int, end: Int): StringBuilder {
        if (smStringBuilder.isNotEmpty())
            if (start >= 0 && end >= 1)
                smStringBuilder.delete(start, end)
        return smStringBuilder
    }

    override fun addStringToBuilderSelection(str: String?, start: Int, end: Int, size: Int) {
        val iControlStart: Int
        if (start >= 0 && end >= 0) {
            iControlStart = if (size == 0) 0 else {
                start
            }
            try {
                smStringBuilder.insert(iControlStart, str)
            } catch (e: Exception) {
                Log.d("TAG", "Error addStringToBuilderSelection()")
            }
        }
    }

    override fun getShow(): Boolean {
        return true
    }

    override fun setShow(show1: Boolean?) {
        /*show = show1!!*/
    }

    /*  fun minusSize(siz1: Float) {
         siz -= siz1
     }

     fun plusSize(siz1: Float) {
         siz += siz1
     }

     fun resetSize(): Float {
         return 40f.also { siz = it }
     }

    */

}