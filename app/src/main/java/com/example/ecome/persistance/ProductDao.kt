package com.example.ecome.persistance


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ecome.data.vos.FavouriteVO
import com.example.ecome.data.vos.ProductImageVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.util.AppUtils

@Dao
abstract class ProductDao {

    @Query("Select * from product")
    abstract fun getProductFormDatabase(): LiveData<MutableList<ProductVO>>

    @Query("Select * from product where product_id = :id")
    abstract fun getProductById(id: Int): LiveData<ProductVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertProduct(products: MutableList<ProductVO>): List<Long>

    @Query("Update product set isFavourite = :fav where product_id =:id")
    abstract fun updateFavToProduct(id:Int,fav:Boolean)

    @Query("Select * from product inner join fav_table on   favProductId = product_id")
    abstract fun getFavProduct(): LiveData<MutableList<ProductVO>>

    @Query("Update product set history_count = :countItem where product_id = :id")
    abstract fun upDateProductCount(countItem: Int, id: Int)

    @Query("Select * from product where history_count > 0")
    abstract fun getProuductHistory(): LiveData<MutableList<ProductVO>>

    @Query("Select history_count from product where product_id = :id")
    abstract fun getProductCountWithId(id: Int): Int

    /*fun getProduct(favouriteDao: FavouriteDao, productDao: ProductDao): LiveData<MutableList<ProductVO>> {
        var products = productDao.getProductFormDatabase().value
        var favId = favouriteDao.getFavItemId().value
        for (productWithFav in favId!!) {
            for(product in products!!){
               if( product.product_id == productWithFav.favProductId ) {
                   product.isFavourite = true
                   break
               }
            }
            }
        return
    }*/

    /**
     * update the product history count by quering the count of item and increse +1 and save again to base
     * method which is called by model class
     */
    fun upDateProductCountWithId(id: Int, productDao: ProductDao) {
        productDao.upDateProductCount(productDao.getProductCountWithId(id) + 1, id)
    }

}