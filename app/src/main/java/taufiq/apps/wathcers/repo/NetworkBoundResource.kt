package taufiq.apps.wathcers.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import taufiq.apps.wathcers.network.StatusResponse
import taufiq.apps.wathcers.network.TmdbResponse
import taufiq.apps.wathcers.vo.Resources

/**
 * Created By Taufiq on 5/9/2021.
 *
 */
abstract class NetworkBoundResource<ResultType, RequestType> {

    private val result = MediatorLiveData<Resources<ResultType>>()

    init {
        result.value = Resources.loading(null)

        val dbSource = loadFromDB()

        result.addSource(dbSource) {
            result.removeSource(dbSource)
            if (shouldFetch(it)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    result.value = Resources.success(newData)
                }
            }
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()
        result.addSource(dbSource) {
            result.value = Resources.loading(it)
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response.status) {
                StatusResponse.SUCCESS ->
                    CoroutineScope(Dispatchers.IO).launch {
                        saveCallResult(response.body)
                        withContext(Main) {
                            result.addSource(loadFromDB()) {
                                result.value = Resources.success(it)
                            }
                        }
                    }

                StatusResponse.ERROR ->{
                    onFetchFailed()
                    result.addSource(dbSource) {
                    result.value = Resources.error(response.message!!, it)
                    }

                }
            }
        }
    }

    fun asLiveData(): LiveData<Resources<ResultType>> = result

    private fun onFetchFailed() {}

    protected abstract fun saveCallResult(body: RequestType)

    protected abstract fun createCall(): LiveData<TmdbResponse<RequestType>>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun loadFromDB(): LiveData<ResultType>


}