package com.example.ecome.persistance

import android.arch.persistence.room.*
import com.example.ecome.data.vos.FavouriteVO
import com.example.ecome.data.vos.ProductImageVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.util.AppUtils

@Dao
abstract class ProductDao {

    @Query("Select * from product")
    abstract fun getProductFormDatabase(): MutableList<ProductVO>

    @Query("Select * from product where product_id = :id")
    abstract fun getProductById(id: Int): ProductVO

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertProduct(products: MutableList<ProductVO>): List<Long>


    //Todo to ask ,this dao should be in the favDao or not because it query the data from product table and not from fav table
    //Todo to ask , also should return the collection of ProductVO or need to create FavouriteVO with attribute in the ProductVO
    @Query("Select * from product inner join fav_table on   favProductId = product_id")
    abstract fun getFavProduct(): MutableList<ProductVO>

    @Query("Update product set history_count = :countItem where product_id = :id")
    abstract fun upDateProductCount(countItem: Int, id: Int)

    @Query("Select * from product where history_count > 0")
    abstract fun getProuductHistory(): MutableList<ProductVO>

    @Query("Select history_count from product where product_id = :id")
    abstract fun getProductCountWithId(id: Int): Int


    fun getProduct(favouriteDao: FavouriteDao, productDao: ProductDao): MutableList<ProductVO> {
        var products = productDao.getProductFormDatabase()
        var favId = favouriteDao.getFavItemId()
        for (productWithFav in favId) {

            for(product in products){
               if( product.product_id == productWithFav.favProductId ) {
                   product.isFavourite = true
                   break
               }
            }
            }
        return products
    }

    /**
     * update the product history count by quering the count of item and increse +1 and save again to base
     * method which is called by model class
     */
    fun upDateProductCountWithId(id: Int, productDao: ProductDao) {
        productDao.upDateProductCount(productDao.getProductCountWithId(id) + 1, id)
    }

}