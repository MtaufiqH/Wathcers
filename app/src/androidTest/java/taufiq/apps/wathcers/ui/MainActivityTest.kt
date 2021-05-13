package taufiq.apps.wathcers.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.*
import org.junit.runners.MethodSorters
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.utils.EspressoIdlingResource

/**
 * Created By Taufiq on 5/4/2021.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MainActivityTest {


    private val sampleMovie = SampleDatas.getSampleOfMovieList()
    private val sampleTvShow = SampleDatas.getSampleOfTvList()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

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
    fun _1loadMoviesAndClickOne() {
        onView(withId(R.id.bottomNavigationView)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        }

        onView(withId(R.id.iv_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.root_scroll)).perform(swipeUp())
    }

    @Test
    fun _2loadTvShowAndClickOne() {
        onView(withId(R.id.bottomNavigationView)).check(matches(isDisplayed()))
        onView(withId(R.id.menu_tv)).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).apply {
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        }

        onView(withId(R.id.iv_backdrop_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_poster_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_overview_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_rating_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.root_scroll_tv)).perform(swipeUp())
    }

    @Test
    fun _3loadMovies() {
        onView(withId(R.id.rv_movies)).apply {
            check(matches(isDisplayed()))
            perform(
                RecyclerViewActions
                    .scrollToPosition<RecyclerView.ViewHolder>(sampleTvShow.size)
            )
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        }
        onView(withId(R.id.iv_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
    }

    @Test
    fun _4loadTvShow() {
        onView(withId(R.id.menu_tv)).perform(click())
        onView(withId(R.id.rv_tv_show)).apply {
            check(matches(isDisplayed()))
            perform(
                RecyclerViewActions
                    .scrollToPosition<RecyclerView.ViewHolder>(sampleMovie.size)
            )
            perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        }
        onView(withId(R.id.iv_backdrop_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_poster_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_overview_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_rating_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date_tv)).check(matches(isDisplayed()))

    }

    @Test
    fun _5insertAndDeleteFromDbMovie() {
        onView(withId(R.id.bottomNavigationView)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed())).apply {
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
            onView(withId(R.id.favorite_movie)).perform(click())
            pressBack()
        }
        onView(withId(R.id.menu_favorite)).perform(click())
        onView(withId(R.id.rv_movies_favorite)).apply {
            check(matches(isDisplayed()))
            perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
            onView(withId(R.id.favorite_movie)).perform(click())
            pressBack()
        }
    }

    @Test
    fun _6insertAndDeleteFromTvDb() {
        onView(withId(R.id.bottomNavigationView)).check(matches(isDisplayed()))
        onView(withId(R.id.menu_tv)).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.favorite_tv)).check(matches(isDisplayed())).perform(click())
        pressBack()

        onView(withId(R.id.menu_favorite)).perform(click())
        onView(withText(R.string.tab_text_2)).perform(click())
        onView(withId(R.id.rv_tv_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.favorite_tv)).check(matches(isDisplayed())).perform(click())
        pressBack()
    }
}

