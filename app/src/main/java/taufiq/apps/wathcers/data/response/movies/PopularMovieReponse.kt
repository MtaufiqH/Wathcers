package taufiq.apps.wathcers.data.response.movies


import com.google.gson.annotations.SerializedName

data class PopularMovieReponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)