package com.example.marsrobots.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marsrobots.data.Image
import io.reactivex.Single

@Dao
interface ImageDao {

    @Query("SELECT * from Images")
    fun getImages(): Single<List<Image>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(images: Image)
}