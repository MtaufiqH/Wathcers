package taufiq.apps.wathcers.data.db.movie

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Taufiq on 5/7/2021.
 *
 */
@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @NonNull
    @ColumnInfo(name = "movie_id")
    var movieId: Int = 0,

    @ColumnInfo(name = "movie_name")
    var movieName: String? = null,

    @ColumnInfo(name = "movie_desc")
    var movieDesc: String? = null,

    @ColumnInfo(name = "movie_poster")
    var poster: String? = null,

    @NonNull
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)