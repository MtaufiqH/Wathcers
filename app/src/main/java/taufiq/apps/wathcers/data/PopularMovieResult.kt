package taufiq.apps.wathcers.data


import com.google.gson.annotations.SerializedName

data class PopularMovieResult(
    @SerializedName("results")
    val results: List<MovieResult>
)