package vn.sunasterisk.realfootball.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rifqimfahmi.foorballapps.vo.FavoriteMatch
import com.rifqimfahmi.foorballapps.vo.FavoriteTeam
import vn.sunasterisk.realfootball.FootballApplication
import vn.sunasterisk.realfootball.data.model.Highlight
import vn.sunasterisk.realfootball.data.model.Match
import vn.sunasterisk.realfootball.data.model.Player
import vn.sunasterisk.realfootball.data.model.Team

@Database(
    entities = [Match::class, Team::class, Player::class, FavoriteMatch::class, FavoriteTeam::class,Highlight::class],
    version = 1
)
abstract class FootBallDb : RoomDatabase() {

    abstract fun playerDao(): PlayerDao
    abstract fun matchDao(): MatchDao
    abstract fun teamDao(): TeamDao
    abstract fun highlightDao() : HighlightDao

    companion object {
        @Volatile
        private var INSTANCE: FootBallDb? = null

        fun getDatabase(): FootBallDb {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    FootballApplication.applicationContext!!,
                    FootBallDb::class.java,
                    "football_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
