package taufiq.apps.wathcers.ui

import taufiq.apps.wathcers.data.MovieResult
import taufiq.apps.wathcers.data.TvShowResult
import taufiq.apps.wathcers.data.detailmovie.DetailMovieResponse
import taufiq.apps.wathcers.data.detailmovie.Genre
import taufiq.apps.wathcers.data.detailtv.DetailTvResponse
import taufiq.apps.wathcers.data.detailtv.Genres

/**
 * Created By Taufiq on 5/3/2021.
 *
 */
object SampleData {
    fun getSampleOfMovieList(): List<MovieResult> {
        return listOf(
            MovieResult(
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                460465,
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "2021-04-07",
                "Mortal Kombat",
                7.8,
                2004
            ),
            MovieResult(
                "", 1, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 2, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 3, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 4, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 5, "", "", "", "",
                "", 0.0, 1
            ),
            MovieResult(
                "", 6, "", "", "", "",
                "", 0.0, 1
            ),

            )
    }

    fun getSampleOfDetailMovie(): DetailMovieResponse {
        return DetailMovieResponse(
            "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
            listOf(
                Genre("Fantasy"),
                Genre("Action"),
                Genre("Adventure"),
                Genre("Science Fiction"),
                Genre("Thriller")
            ),
            "https://www.mortalkombatmovie.net",
            460465,
            "en",
            "Mortal Kombat",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            "2021-04-07",
            110,
            "Released",
            "Mortal Kombat",
            7.8,
            2015
        )
    }

    // TV SAMPLE
    fun getSampleOfTvList(): List<TvShowResult> {
        return listOf(
            TvShowResult(
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "2021-03-19",
                88396,
                "The Falcon and the Winter Soldier",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                5208
            ),
            TvShowResult("", "", 0, "", "", "", "", 1.0, 0),
            TvShowResult("", "", 1, "", "", "", "", 1.0, 0),
            TvShowResult("", "", 2, "", "", "", "", 1.0, 0),
            TvShowResult("", "", 3, "", "", "", "", 1.0, 0),
            TvShowResult("", "", 4, "", "", "", "", 1.0, 0),
            TvShowResult("", "", 5, "", "", "", "", 1.0, 0),
            TvShowResult("", "", 6, "", "", "", "", 1.0, 0),
        )
    }

    fun getSampleOfDetailTvShow(): DetailTvResponse {
        return DetailTvResponse(
            "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            "2021-03-19",
            listOf(
                Genres("Sci-Fi & Fantasy"),
                Genres("Action & Adventure"),
                Genres("Drama"),
                Genres("War & Politics")
            ),
            "https://www.disneyplus.com/series/the-falcon-and-the-winter-soldier/4gglDBMx8icA",
            88396,
            "2021-04-23",
            "The Falcon and the Winter Soldier",
            "The Falcon and the Winter Soldier",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.\",Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            2556.792,
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            "Ended",
            7.9,
            5208
        )
    }


}