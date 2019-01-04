package test.app.com.logintest.data.remote.execeptions

import android.content.Context
import androidx.arch.core.util.Function
import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.HttpException

import java.util.Objects

class ExceptionParser<T : Throwable>(private val context: Context) : Function<T, Flowable<T>> {

    @Throws(Exception::class)
    override fun apply(t: T): Flowable<T> {
        if (t is HttpException) {
            val httpException = t as HttpException
            if (httpException.response() != null && httpException.response().errorBody() != null) {
                val errorBody = Objects.requireNonNull<ResponseBody>(httpException.response().errorBody()).string()
                //                if (!TextUtils.isEmpty(errorBody) &&
                //                        errorBody.contains(Constants.RESPONSE_ERROR_CODE) &&
                //                        errorBody.contains(Constants.RESPONSE_ERROR_MESSAGE) &&
                //                        errorBody.contains(Constants.RESPONSE_RESULT)) {
                //                    BaseResponse baseResponse = new Gson().fromJson(errorBody, BaseResponse.class);
                //                    return Flowable.error(new ApiFailedModel(baseResponse));
                //                }
            }
        }
        return Flowable.error(t)
    }
}