package taufiq.apps.wathcers.viewmodel

import taufiq.apps.wathcers.data.MovieResult
import taufiq.apps.wathcers.data.TvShowResult
import taufiq.apps.wathcers.data.detailmovie.DetailMovieResponse
import taufiq.apps.wathcers.data.detailtv.DetailTvResponse

/**
 * Created By Taufiq on 5/3/2021.
 *
 */
object SampleData {


    // MOVIE SAMPLE
    fun getSampleOfMovieList(): List<MovieResult> {
        return listOf(
            MovieResult(
                "", 0, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 0, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 0, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 0, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 0, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 0, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 0, "", "", "", "",
                "", 0.0, 1
            ),

            )
    }

    fun getSampleOfDetailMovie(): DetailMovieResponse{

    }

    // TV SAMPLE
    fun getSampleOfTvList(): List<TvShowResult>{

    }

    fun getSampleOfDetailTvShow(): DetailTvResponse{}




}