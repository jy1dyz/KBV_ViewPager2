package kg.study.kbv_viewpager2

import com.google.gson.annotations.SerializedName

class ImageDBResponse {
    @SerializedName("imgSrc")
    var image: String? = null
    var imageList: List<Image>? = null

}