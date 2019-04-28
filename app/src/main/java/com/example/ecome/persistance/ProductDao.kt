package com.example.ecome.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.ecome.data.vos.ProductImageVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.util.AppUtils

@Dao
abstract class ProductDao {

    @Query("Select * from product")
    abstract fun getProduct(): MutableList<ProductVO>

    @Query("Select * from product where product_id = :id")
    abstract fun getProductById(id: Int): ProductVO

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertProduct(products: MutableList<ProductVO>): List<Long>

    fun saveProductsWithItems(products: MutableList<ProductVO>, imageDao: ProductImageDao, productDao: ProductDao) {
        var images: ArrayList<ProductImageVO> = ArrayList<ProductImageVO>()

        for (p in products) {
            var id = p.product_id
            for (image in p.product_image_url!!) {
                image.product_id = id
                images.add(image)
            }
        }
        var pid = productDao.insertProduct(products)
        var debug = images
        var id = imageDao.insertProductImage(images)

    }


    fun getProductsWithItems(imageDao: ProductImageDao, productDao: ProductDao): MutableList<ProductVO> {
        var products: MutableList<ProductVO> = ArrayList()
        var collection = productDao.getProduct()
        for (p in collection) {
            p.product_image_url = imageDao.getProductImageById(p.product_id!!)
            var debug = p

            products.add(p)

        }
        var debug = products
        return products

    }

    fun getProductsWithId(imageDao: ProductImageDao, productDao: ProductDao,id:Int):  ProductVO {

            var collection = productDao.getProductById(id)
          var images = imageDao.getProductImageById(collection.product_id!!)



            collection.product_image_url = images


        return collection
        }


}