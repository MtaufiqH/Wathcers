package taufiq.apps.wathcers.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.data.DataSourceDummy


/**
 * Created By Taufiq on 4/17/2021.
 */
class MainActivityTest {

    private val movies = DataSourceDummy.getAllPopularMovies()
    private val tvs = DataSourceDummy.getAllPopularTvShow()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions
                .scrollToPosition<RecyclerView.ViewHolder>(movies.size)
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).check(matches(withText(movies[0].title)))
        onView(withId(R.id.tv_movie_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_overview)).check(matches(withText(movies[0].description)))
        onView(withId(R.id.tv_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year)).check(matches(withText(movies[0].date)))
        onView(withId(R.id.btn_book)).perform(click())
    }

    @Test
    fun loadTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions
                .scrollToPosition<RecyclerView.ViewHolder>(tvs.size)
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_movie_title_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title_tv)).check(matches(withText(tvs[0].title)))
        onView(withId(R.id.tv_movie_overview_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_overview_tv)).check(matches(withText(tvs[0].description)))
        onView(withId(R.id.tv_year_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year_tv)).check(matches(withText(tvs[0].date)))
        onView(withId(R.id.btn_book_tv)).perform(click())
    }

}