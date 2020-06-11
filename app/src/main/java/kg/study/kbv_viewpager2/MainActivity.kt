package kg.study.kbv_viewpager2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import java.util.*

class MainActivity : AppCompatActivity() {
    var timer: Timer? = null
    var page = 0
    lateinit var imagePager: ViewPager2

    // List<Image> imageList = new ArrayList<>();
    var imageList: MutableList<Image> = ArrayList()
    private var mainViewModel: MainViewModel? = null
    private var imagePagerAdapter: ImagePagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imagePager = findViewById(R.id.view_pager2)

        var imageOne = Image()
        imageOne.imageUrl = "https://i.pinimg.com/originals/83/4f/9f/834f9f93b533239dd0ca3528be1b46f8.jpg";
        imageList.add(imageOne)
        var imageTwo =  Image()
        imageTwo.imageUrl = "https://puteved.io/_media/%D1%81%D1%88%D0%B0/%D0%B0%D0%BB%D1%8F%D1%81%D0%BA%D0%B0/%D0%B0%D0%BB%D1%8F%D1%81%D0%BA%D0%B0.jpg";
        imageList.add(imageTwo)
        var imageThree =  Image()
        imageThree.imageUrl = "https://c1.staticflickr.com/5/4341/35860488264_806d3f8d69_c.jpg";
        imageList.add(imageThree)
        var imageFour =  Image()
        imageFour.imageUrl = "https://www.pnp.ru/upload/entities/2020/03/29/article/detailPicture/36/00/be/da/a0f0a5832689f53c8a14d64ceb9fdc64.jpg";
        imageList.add(imageFour)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        imagePagerAdapter = ImagePagerAdapter()
        imagePager.setAdapter(imagePagerAdapter)
        pageSwitcher(15)
        //getAllImages();
    }

    val allImages: Unit
        get() {
            mainViewModel!!.allImages.observe(this, Observer { images -> imagePagerAdapter!!.setImageList(images as ArrayList<Image>) })
        }

    fun pageSwitcher(seconds: Int) {
        timer = Timer()
        timer!!.scheduleAtFixedRate(RemindTask(), 0, seconds * 1000.toLong())
    }

    internal inner class RemindTask : TimerTask() {
        override fun run() {
            runOnUiThread {
                if (page > imageList.size) { // In my case the number of pages are 5
                    timer!!.cancel()
                    // Showing a toast for just testing purpose
                    Toast.makeText(applicationContext, "Timer stopped",
                            Toast.LENGTH_LONG).show()
                } else {
                    imagePager!!.currentItem = page++
                }
            }
        }
    }
}