package ru.notasi.imagesgridjson.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.List;

import ru.notasi.imagesgridjson.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ImagesAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<String> mImagesList;
    private final LayoutInflater mInflater;

    public ImagesAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mImagesList = list;
        this.mInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mImagesList.size();
    }

    @Override
    public Object getItem(int i) {
        return mImagesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        String item = mImagesList.get(i);
        return mImagesList.indexOf(item);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mInflater.inflate(R.layout.image_card, viewGroup, false);
        }

        ImageView imageView = view.findViewById(R.id.image_thumbnail);

        Glide.with(mContext).load(mImagesList.get(i))
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_image_24)
                .error(R.drawable.ic_baseline_image_not_supported_24)
                .into(imageView);

        return view;
    }
}