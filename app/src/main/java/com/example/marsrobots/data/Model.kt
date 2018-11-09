package com.example.marsrobots.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Images")
data class Image(@PrimaryKey(autoGenerate = true) val id: Int,
                 val links: Links,
                 val data: Data)

data class Links(val href: String)

data class Data(val description: String,
                @SerializedName("date_created") val dateCreated: String)

data class ImagesList(@SerializedName("items") val items: List<Image>)