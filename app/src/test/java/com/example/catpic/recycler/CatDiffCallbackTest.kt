package com.example.catpic.recycler

import com.example.catpic.retrofit.CatPic
import org.junit.Assert.assertEquals
import org.junit.Test

class CatDiffCallbackTest {
    private val firstCat = CatPic("1", "url1")
    private val secondCat = CatPic("2", "url2")
    private val thirdCat = CatPic("1", "url1")
    private val callback = CatDiffCallback()

    @Test
    fun areItemsTheSameTest() {
        assertEquals(callback.areItemsTheSame(firstCat, secondCat), false)
        assertEquals(callback.areItemsTheSame(firstCat, thirdCat), true)
    }

    @Test
    fun areContentsTheSame() {
        assertEquals(callback.areContentsTheSame(firstCat, secondCat), false)
        assertEquals(callback.areContentsTheSame(firstCat, thirdCat), true)
    }

}
