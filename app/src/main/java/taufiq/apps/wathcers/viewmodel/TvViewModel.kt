package taufiq.apps.wathcers.viewmodel

import androidx.lifecycle.ViewModel
import taufiq.apps.wathcers.data.DataModel
import taufiq.apps.wathcers.data.DataSourceDummy

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
class TvViewModel : ViewModel() {

    val allPopularTvShow = DataSourceDummy.getAllPopularTvShow()
    fun getTvById(id: Int): DataModel? {
        return DataSourceDummy.getTv(id)
    }
}