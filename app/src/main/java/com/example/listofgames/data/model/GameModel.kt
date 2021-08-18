package com.example.listofgames.data.model

import com.google.gson.annotations.SerializedName

data class GameModel(

	@field:SerializedName("GameModel")
	val gameModel: List<GameModelItem?>? = null
)

data class GameModelItem(

	@field:SerializedName("europe_release")
	val europeRelease: String? = null,

	@field:SerializedName("japan_release")
	val japanRelease: String? = null,

	@field:SerializedName("publisher")
	val publisher: String? = null,

	@field:SerializedName("north_america_release")
	val northAmericaRelease: String? = null,

	@field:SerializedName("developer")
	val developer: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
