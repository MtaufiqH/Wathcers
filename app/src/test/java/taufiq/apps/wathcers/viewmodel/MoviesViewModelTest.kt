package taufiq.apps.wathcers.viewmodel


import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import taufiq.apps.wathcers.data.DataModel

/**
 * Created By Taufiq on 4/17/2021.
 */
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var dataMovies: DataModel

    @Before
    fun initViewModel() {
        viewModel = MoviesViewModel()
        dataMovies = DataModel(
            7,
            "Black Water: Abyss",
            "An adventure-loving couple convince their friends to explore a remote, uncharted cave system in the forests of Northern Australia. With a tropical storm approaching, they abseil into the mouth of the cave, but when the caves start to flood, tensions rise as oxygen levels fall and the friends find themselves trapped. Unknown to them, the storm has also brought in a pack of dangerous and hungry crocodiles.",
            "https://image.tmdb.org/t/p/w500/95S6PinQIvVe4uJAd82a2iGZ0rA.jpg",
            "2020"
        )
    }

    @Test
    fun testGetAllMovies() {
        val movies = viewModel.allMovies
        val expectedValues = 10
        assertNotNull(movies)
        assertEquals(expectedValues, movies.size)
    }

    @Test
    fun testGetMoviesById() {
        val expectedId = dataMovies.id
        val expectedTitle = dataMovies.title
        val expectedDescription = dataMovies.description
        val expectedImageUrl = dataMovies.image
        val expectedDate = dataMovies.date
        assertEquals(expectedId, viewModel.getMoviesById(7)?.id)
        assertEquals(expectedTitle, viewModel.getMoviesById(7)?.title)
        assertEquals(expectedDescription, viewModel.getMoviesById(7)?.description)
        assertEquals(expectedImageUrl, viewModel.getMoviesById(7)?.image)
        assertEquals(expectedDate, viewModel.getMoviesById(7)?.date)

    }
}