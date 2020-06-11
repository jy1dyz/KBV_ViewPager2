package kg.study.kbv_viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.flaviofaria.kenburnsview.KenBurnsView
import com.squareup.picasso.Picasso
import kg.study.kbv_viewpager2.ImagePagerAdapter.ImagePagerViewHolder
import java.util.*

class ImagePagerAdapter : RecyclerView.Adapter<ImagePagerViewHolder>() {
    private var imageList: ArrayList<Image>? = null

    /* public ImagePagerAdapter(List<Image> imageList) {
        this.imageList = imageList;
    }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagePagerViewHolder {
        return ImagePagerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_view_pager,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ImagePagerViewHolder, position: Int) {
        //Image currentImage = imageList.get(position);
        holder.loadImage(imageList!![position])
        //   holder.loadImage(setImageList(imageList));
    }

    override fun getItemCount(): Int {
        return imageList!!.size
    }

    class ImagePagerViewHolder(itemView: View) : ViewHolder(itemView) {
        private val kenBurnsView: KenBurnsView
        fun loadImage(image: Image) {
            Picasso.get().load(image.imageUrl).into(kenBurnsView)
        }

        init {
            kenBurnsView = itemView.findViewById(R.id.ken_burns_view)
        }
    }

    fun setImageList(images: ArrayList<Image>?) {
        imageList = images
        notifyDataSetChanged()
    }
}