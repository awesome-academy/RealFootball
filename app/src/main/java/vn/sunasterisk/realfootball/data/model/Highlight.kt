package vn.sunasterisk.realfootball.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "highlight",primaryKeys = ["embed"])
data class Highlight(
    @SerializedName("embed")
    val embed: String,
    @SerializedName("title")
    val title: String
)
