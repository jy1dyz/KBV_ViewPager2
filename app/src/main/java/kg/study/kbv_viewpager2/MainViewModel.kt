package kg.study.kbv_viewpager2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val imageRepository: ImageRepository
    val allImages: LiveData<List<Image>?>
        get() = imageRepository.getMutableLiveData()

    init {
        imageRepository = ImageRepository()
    }
}