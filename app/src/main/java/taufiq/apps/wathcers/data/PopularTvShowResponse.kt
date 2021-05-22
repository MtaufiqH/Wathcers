package taufiq.apps.wathcers.data


import com.google.gson.annotations.SerializedName

data class PopularTvShowResponse(
    @SerializedName("results")
    val results: List<TvShowResult>,
)