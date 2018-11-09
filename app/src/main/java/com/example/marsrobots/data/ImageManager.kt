package com.example.marsrobots.data

import com.example.marsrobots.data.source.local.ImageDao
import com.example.marsrobots.data.source.remote.ApiService
import io.reactivex.Single
import javax.inject.Inject

class ImageManager @Inject constructor(private val apiService: ApiService, private val imageDao: ImageDao) {
    fun getImages(): Single<List<Image>> = imageDao.getImages()
        .flatMap { images ->
            if (images.isEmpty()) getImagesFromApi()
            else Single.just(images)
        }

    private fun getImagesFromApi(): Single<List<Image>> = apiService.getImages()
        .map { imagesList -> imagesList.items }
        .flatMap { items ->
            items.forEach { imageDao.insert(it) }
            Single.just(items)
        }
}