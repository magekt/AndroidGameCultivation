package com.gurukul.android.data

import android.content.Context
import com.gurukul.core.model.Shishya
import com.google.gson.Gson
import java.io.File

/**
 * Repository for persisting shishya state to local JSON storage.
 */
class ShishyaRepository(private val context: Context) {

    private val file = File(context.filesDir, "shishya.json")
    private val gson = Gson()

    fun save(shishya: Shishya) {
        val json = gson.toJson(shishya)
        file.writeText(json)
    }

    fun load(): Shishya? {
        return if (file.exists()) {
            val json = file.readText()
            gson.fromJson(json, Shishya::class.java)
        } else {
            null
        }
    }

    fun clear() {
        file.delete()
    }
}