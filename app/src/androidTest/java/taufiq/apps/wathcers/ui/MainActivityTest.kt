package taufiq.apps.wathcers.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.utils.EspressoIdlingResource

/**
 * Created By Taufiq on 5/4/2021.
 */
class MainActivityTest {


    private val sampleMovie = SampleData.getSampleOfMovieList()
    private val sampleTvShow = SampleData.getSampleOfTvList()

    @Suppress("DEPRECATION")
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java, true)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance()
            .register(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance()
            .unregister(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
    }

    @Test
    fun loadMoviesAndClickOne() {
        onView(withId(R.id.tabs_id)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(sampleMovie.size))
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        }

        onView(withId(R.id.iv_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_released_status)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.root_scroll)).perform(swipeUp())
        onView(withId(R.id.btn_more)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShowAndClickOne() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).apply {
            perform(
                RecyclerViewActions
                    .scrollToPosition<RecyclerView.ViewHolder>(sampleTvShow.size)
            )
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        }

        onView(withId(R.id.iv_backdrop_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_poster_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_overview_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_released_status_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_rating_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_genre_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.root_scroll_tv)).perform(swipeUp())
        onView(withId(R.id.btn_more_tv)).check(matches(isDisplayed()))
    }
}