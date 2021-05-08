package taufiq.apps.wathcers.network

/**
 * Created By Taufiq on 5/9/2021.
 *
 */
    class TmdbResponse<T>(val status: StatusResponse, val body: T, val message: String?) {
    companion object {
        fun <T> success(body: T): TmdbResponse<T> =
            TmdbResponse(StatusResponse.SUCCESS, body, null)

        fun <T> empty(msg: String, body: T): TmdbResponse<T> =
            TmdbResponse(StatusResponse.EMPTY, body, msg)

        fun <T> error(msg: String, body: T): TmdbResponse<T> =
            TmdbResponse(StatusResponse.ERROR, body, msg)
    }

}