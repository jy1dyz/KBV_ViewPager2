package kg.study.kbv_viewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImagePagerAdapter extends RecyclerView.Adapter<ImagePagerAdapter.ImagePagerViewHolder> {

    private List<Image> imageList;

    public ImagePagerAdapter(List<Image> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override

    public ImagePagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImagePagerViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_view_pager,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ImagePagerViewHolder holder, int position) {
        holder.loadImage(imageList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    static class ImagePagerViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView kenBurnsView;

        ImagePagerViewHolder(@NonNull View itemView) {
            super(itemView);
            kenBurnsView = itemView.findViewById(R.id.ken_burns_view);

        }

        void loadImage(Image image) {
            Picasso.get().load(image.imageUrl).into(kenBurnsView);
        }
    }
}
