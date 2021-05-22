package taufiq.apps.wathcers.vo

/**
 * Created By Taufiq on 5/7/2021.
 *
 */
class Resources<T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resources<T> =
            Resources(Status.SUCCESS, data, null)

        fun <T> error(message: String, data: T?): Resources<T> =
            Resources(Status.ERROR, data, message)

        fun <T> loading(data: T?): Resources<T> =
            Resources(Status.LOADING, data, null)
    }
}
