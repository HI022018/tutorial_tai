package tdtai.vn.horus.mvp_api

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import io.reactivex.Observable

class MainPresenter(private val mainView: MainView){
    fun getApiResult(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()!!
            .create(APIService::class.java)
            .getAPI()

        retrofit.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result ->
                    mainView.displayResultOnTextView(result)
                },
                { error ->
                    Log.e("ERROR: ",error.localizedMessage)
                }
            )
    }

    companion object {
        const val BASE_URL = "http://115.79.29.63:8101"
        const val SUB_URL = "/edc/rest/aboutus?version=1.0"
    }

    interface APIService{
        @GET(SUB_URL)
        fun getAPI():Observable<DataItem>
    }
}