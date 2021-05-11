package taufiq.apps.wathcers.ui

import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.data.db.tv.TvShowEntity

/**
 * Created By Taufiq on 5/3/2021.
 *
 */
object SampleDatas {
    fun getSampleOfMovieList(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                0,
                460465,
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                7.8,
                "2021-04-07",
                false
            ),
            MovieEntity(
                0, 1, "", "", "", "",
                0.0, "", false
            ),
            MovieEntity(
                0, 2, "", "", "", "",
                0.0, "", false
            ),
            MovieEntity(
                0, 3, "", "", "", "",
                0.0, "", false
            ),
            MovieEntity(
                0, 4, "", "", "", "",
                0.0, "", false
            ),
            MovieEntity(
                0, 5, "", "", "", "",
                0.0, "", false
            ),

            )
    }

//    fun getSampleOfDetailMovie(): DetailMovieResponse {
//        return DetailMovieResponse(
//            "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
//            listOf(
//                Genre("Fantasy"),
//                Genre("Action"),
//                Genre("Adventure"),
//                Genre("Science Fiction"),
//                Genre("Thriller")
//            ),
//            "https://www.mortalkombatmovie.net",
//            460465,
//            "en",
//            "Mortal Kombat",
//            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
//            "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
//            "2021-04-07",
//            110,
//            "Released",
//            "Mortal Kombat",
//            7.8,
//            2015
//        )
//    }

    // TV SAMPLE
    fun getSampleOfTvList(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                0,
                88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                7.0,"2021-03-19", false
            ),
            TvShowEntity(0, 88396, "", "", "", "", 1.0, "",false),
            TvShowEntity(0, 88396, "", "", "", "", 1.0, "", false),
            TvShowEntity(0, 88396, "", "", "", "", 1.0, "",false),
            TvShowEntity(0, 88396, "", "", "", "", 1.0, "",false),
            TvShowEntity(0, 88396, "", "", "", "", 1.0, "", false),
            TvShowEntity(0, 88396, "", "", "", "", 1.0, "",false),
        )
    }

//    fun getSampleOfDetailTvShow(): DetailTvResponse {
//        return DetailTvResponse(
//            "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
//            "2021-03-19",
//            listOf(
//                Genres("Sci-Fi & Fantasy"),
//                Genres("Action & Adventure"),
//                Genres("Drama"),
//                Genres("War & Politics")
//            ),
//            "https://www.disneyplus.com/series/the-falcon-and-the-winter-soldier/4gglDBMx8icA",
//            88396,
//            "2021-04-23",
//            "The Falcon and the Winter Soldier",
//            "The Falcon and the Winter Soldier",
//            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.\",Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
//            2556.792,
//            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
//            "Ended",
//            7.9,
//            5208
//        )
//    }


}