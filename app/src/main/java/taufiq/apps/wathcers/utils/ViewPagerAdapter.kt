package taufiq.apps.wathcers.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import taufiq.apps.wathcers.ui.MoviesFragment
import taufiq.apps.wathcers.ui.TvFragment


class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MoviesFragment()
            1 -> TvFragment()
            else -> Fragment()
        }
    }


}