package kg.study.kbv_viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 imagePager = findViewById(R.id.view_pager2);

        List<Image> imageList = new ArrayList<>();
        Image imageOne = new Image();
        imageOne.imageUrl = "https://i.pinimg.com/originals/83/4f/9f/834f9f93b533239dd0ca3528be1b46f8.jpg";
        imageList.add(imageOne);
        Image imageTwo = new Image();
        imageTwo.imageUrl = "https://puteved.io/_media/%D1%81%D1%88%D0%B0/%D0%B0%D0%BB%D1%8F%D1%81%D0%BA%D0%B0/%D0%B0%D0%BB%D1%8F%D1%81%D0%BA%D0%B0.jpg";
        imageList.add(imageTwo);
        Image imageThree = new Image();
        imageThree.imageUrl = "https://c1.staticflickr.com/5/4341/35860488264_806d3f8d69_c.jpg";
        imageList.add(imageThree);
        Image imageFour = new Image();
        imageFour.imageUrl = "https://www.pnp.ru/upload/entities/2020/03/29/article/detailPicture/36/00/be/da/a0f0a5832689f53c8a14d64ceb9fdc64.jpg";
        imageList.add(imageFour);

        imagePager.setAdapter(new ImagePagerAdapter(imageList));

    }
}