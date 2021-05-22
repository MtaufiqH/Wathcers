package taufiq.apps.wathcers.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.data.db.tv.TvShowEntity

/**
 * Created By Taufiq on 5/7/2021.
 *
 */
@Database(entities = [MovieEntity::class, TvShowEntity::class], version = 1, exportSchema = false)
abstract class TmdbDatabase : RoomDatabase() {
    abstract fun tmbdDao(): TmdbDao
}