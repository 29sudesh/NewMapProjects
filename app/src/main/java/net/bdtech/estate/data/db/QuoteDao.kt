package net.bdtech.estate.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.bdtech.estate.data.db.entities.Owner

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllQuotes(owners : List<Owner>)

    @Query("SELECT * FROM Owner")
    fun getQuotes() : LiveData<List<Owner>>

}