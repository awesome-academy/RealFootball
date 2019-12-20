package vn.sunasterisk.realfootball.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import vn.sunasterisk.realfootball.data.model.Highlight

@Dao
interface HighlightDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveHighlight(highlight: List<Highlight>)

    @Query("SELECT * FROM highlight")
    fun getHighlight(): LiveData<List<Highlight>>

    @Query("DELETE FROM highlight")
    fun deleteHighlith()
}
