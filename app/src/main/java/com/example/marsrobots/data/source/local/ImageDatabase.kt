package com.example.marsrobots.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marsrobots.data.Image

@Database(entities = [(Image::class)], version = 1)
abstract class ImageDatabase : RoomDatabase() {

    abstract fun imageDao(): ImageDao
}

