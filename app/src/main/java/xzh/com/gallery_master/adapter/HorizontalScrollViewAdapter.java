package xzh.com.gallery_master.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import xzh.com.gallery_master.R;
import xzh.com.gallery_master.model.GalleryModel;

public class HorizontalScrollViewAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater mInflater;
    private List<GalleryModel> mDatas;

    public HorizontalScrollViewAdapter(Context context, List<GalleryModel> mDatas) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    public int getCount() {
        return mDatas.size();
    }

    public Object getItem(int position) {
        return mDatas.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(
                    R.layout.activity_gallery_item, parent, false);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        initItem(viewHolder,position);
        return convertView;
    }

    private void initItem(ViewHolder viewHolder, int position) {
        viewHolder.itemImage.setImageResource(mDatas.get(position).image);
        viewHolder.itemText.setText(mDatas.get(position).name);
    }

     class ViewHolder {
        @Bind(R.id.item_image)
        ImageView itemImage;
        @Bind(R.id.item_text)
        TextView itemText;

        public ViewHolder(View parent) {
            ButterKnife.bind(this, parent);
            parent.setTag(this);
        }
    }

}
