package taufiq.apps.wathcers.data


import com.google.gson.annotations.SerializedName

data class PopularTvShowResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TvShowResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)