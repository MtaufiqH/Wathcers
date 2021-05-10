package taufiq.apps.wathcers.data.db.tv

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Created By Taufiq on 5/7/2021.
 *
 */
@Parcelize
@Entity(tableName = "tv_show_table")
data class TvShowEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @NonNull
    @ColumnInfo(name = "tv_id")
    var tvId: Int = 0,

    @ColumnInfo(name = "tv_name")
    var tvName: String? = null,

    @ColumnInfo(name = "movie_desc")
    var desc: String? = null,

    @ColumnInfo(name = "movie_poster")
    var poster: String? = null,

    @NonNull
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
) : Parcelable