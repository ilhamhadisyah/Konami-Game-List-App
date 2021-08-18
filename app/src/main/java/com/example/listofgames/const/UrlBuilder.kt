package com.example.listofgames.const

object UrlBuilder {
    fun makeUrl(path: String): String {
        val fixedPath = path.substringAfter('(').substringBefore(')')
        return "${Const.BASE_IMAGE}$fixedPath"
    }
}