package xzh.com.gallery_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import xzh.com.gallery_master.adapter.HorizontalScrollViewAdapter;
import xzh.com.gallery_master.model.GalleryModel;
import xzh.com.gallery_master.view.MyHorizontalScrollView;
import xzh.com.gallery_master.view.MyHorizontalScrollView.*;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.id_image)
    ImageView idImage;
    @Bind(R.id.id_gallery)
    LinearLayout idGallery;
    @Bind(R.id.id_horizontalScrollView)
    MyHorizontalScrollView idHorizontalScrollView;

    private HorizontalScrollViewAdapter mAdapter;
    private List<GalleryModel> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
       initData();
       initAdapter();
    }

    private void initAdapter() {
      mAdapter=new HorizontalScrollViewAdapter(this,datas);
        idHorizontalScrollView
                .setCurrentImageChangeListener(new CurrentImageChangeListener()
                {
                    @Override
                    public void onCurrentImgChanged(int position,
                                                    View viewIndicator)
                    {
                        idImage.setImageResource(datas.get(position).image);
                        viewIndicator.setBackgroundColor(getResources().getColor(R.color.c2));
                    }
                });
        //添加点击回调
        idHorizontalScrollView.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onClick(View view, int position)
            {
                idImage.setImageResource(datas.get(position).image);
                view.setBackgroundColor(getResources().getColor(R.color.c2));
            }
        });
        idHorizontalScrollView.setDatas(mAdapter);
    }

    private void initData() {
        datas=new ArrayList<>();
        GalleryModel model=new GalleryModel();
        model.image=R.mipmap.a;
        model.name="清纯美女";
        datas.add(model);
        model=new GalleryModel();
        model.image=R.mipmap.b;
        model.name="野蛮美女";
        datas.add(model);
        model=new GalleryModel();
        model.image=R.mipmap.c;
        model.name="可爱美女";
        datas.add(model);
        model=new GalleryModel();
        model.image=R.mipmap.d;
        model.name="活泼美女";
        datas.add(model);
        model=new GalleryModel();
        model.image=R.mipmap.e;
        model.name="女汉子";
        datas.add(model);
        model=new GalleryModel();
        model.image=R.mipmap.f;
        model.name="外国美女";
        datas.add(model);
        model=new GalleryModel();
        model.image=R.mipmap.g;
        model.name="日本美女";
        datas.add(model);
        model=new GalleryModel();
        model.image=R.mipmap.h;
        model.name="韩国美女";
        datas.add(model);
        model=new GalleryModel();
        model.image=R.mipmap.l;
        model.name="美国美女";
        datas.add(model);
    }
}
