package com.ssb

import com.ssb.mvp.Flag
import com.ssb.mvp.presenter.StringStringBuilder
import org.junit.Test

class ExampleUnitTest {
    private val shihString = StringStringBuilder()
    private val arrayList =
        arrayListOf("String 1 ", "String 2 ", "String 3 ", "String 4 ", "String 5 ")


    @Test
    fun testDeleteOneLineFlags() {
        shihString.addAllStringToBuilder(arrayList)
        // --- Flag START_SEARCH ------
        println(shihString.deleteOneLine("Strin", Flag.START_SEARCH).toString())
        /** Result ---> delete (Strin) С начала строки
         *
         *  g 1 String 2 String 3 String 4 String 5
         *
         * */

        // --- Flag END_SEARCH ------
        println(shihString.deleteOneLine("String 4 ", Flag.END_SEARCH).toString())
        /** Result ---> delete (Strin) С конца строки
         *
         *  String 1 String 2 String 3 String 4 g 5
         *
         * */

    }

    @Test
    fun testDeleteOneLine() {
        shihString.addAllStringToBuilder(arrayList)
        println(shihString.deleteOneLine("String 4 ", Flag.END_SEARCH).toString())

        /** Result ---> delete (String 4 )
         *
         *  String 1 String 2 String 3 String 5
         *
         * */
    }

    @Test
    fun testDeleteOneLineBaze() {
        shihString.addAllStringToBuilder(arrayList)
        do {
            println(shihString.deleteOneLineBaze().toString())
        } while (shihString.smStringBuilder.length > 20)

        /** Result --->
         *
         *  String 1 String 2 String 3 String 4 String 5
        String 1 String 2 String 3 String 4 String
        String 1 String 2 String 3 String 4 String
        String 1 String 2 String 3 String 4 Strin
        String 1 String 2 String 3 String 4 Stri
        String 1 String 2 String 3 String 4 Str
        String 1 String 2 String 3 String 4 St
        String 1 String 2 String 3 String 4 S
        String 1 String 2 String 3 String 4
        String 1 String 2 String 3 String 4
        String 1 String 2 String 3 String
        String 1 String 2 String 3 String
        String 1 String 2 String 3 Strin
        String 1 String 2 String 3 Stri
        String 1 String 2 String 3 Str
        String 1 String 2 String 3 St
         *
         * */

    }
    @Test
    fun testUpdateStringToBuilder() {

        shihString.addAllStringToBuilder(arrayList)
        println(shihString.updateStringToBuilder(str = "String 1" ,"New String Main").toString())

        /** Result ---> update (String 1)
         *
         *  New String Main String 2 String 3 String 4 String 5
         *
         * */
    }

}