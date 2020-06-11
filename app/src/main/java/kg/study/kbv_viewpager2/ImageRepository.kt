package kg.study.kbv_viewpager2

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ImageRepository {
    private var images: ArrayList<Image>? = ArrayList()
    private val mutableLiveData = MutableLiveData<List<Image>?>()
    fun getMutableLiveData(): MutableLiveData<List<Image>?> {
        val imageApiService = RetrofitClient.service
        val call = imageApiService.fetchImages()
        call!!.enqueue(object : Callback<ImageDBResponse?> {
            override fun onResponse(call: Call<ImageDBResponse?>, response: Response<ImageDBResponse?>) {
                //List<Image> imageList = response.body();
                val imageResponse = response.body()
                if (imageResponse != null && imageResponse.imageList != null) {
                    images = imageResponse.imageList as ArrayList<Image>?
                    mutableLiveData.value = images
                }
            }

            override fun onFailure(call: Call<ImageDBResponse?>, t: Throwable) {}
        })
        return mutableLiveData
    }
}