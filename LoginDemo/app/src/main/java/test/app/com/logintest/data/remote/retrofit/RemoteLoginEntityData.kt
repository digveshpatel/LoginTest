package test.app.com.logintest.data.remote.retrofit

import android.content.Context
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.reactivestreams.Publisher
import retrofit2.Response
import test.app.com.logintest.data.local.db.XaccData
import test.app.com.logintest.data.remote.execeptions.ExceptionParser
import test.app.com.logintest.data.remote.retrofit.model.LoginRequest



class RemoteLoginEntityData(private val context: Context) : CommonRetrofit<BaseApi>(context), LoginEntityData {

    override val restClass: Class<BaseApi>
        get() = BaseApi::class.java


    private fun <T> applyServiceTransformer(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream ->
            upstream.compose { upstream ->
                upstream.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
            }
                //.onErrorResumeNext(ExceptionParser(context))
        }
    }

    override fun postLogin(name: String, password: String): Flowable<Response<ResponseBody>>? {
        return getNetworkService()!!.postLogin(LoginRequest(name, password))
            .compose(applyServiceTransformer())
    }

    override fun saveUserXaccToLocal(xaccData: XaccData) {}


}