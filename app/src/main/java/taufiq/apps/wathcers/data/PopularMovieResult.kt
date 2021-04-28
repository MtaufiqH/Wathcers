package taufiq.apps.wathcers.data


import com.google.gson.annotations.SerializedName

data class PopularMovieResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieResult>
)