package com.discogs.adapters;

import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.discogs.ImageDownloader;
import com.discogs.activities.R;
import com.discogs.model.Image;

public class ImageAdapter extends BaseAdapter 
{
    private Context context;
	private List<Image> images;
	private ImageDownloader imageDownloader;
	private int galleryItemBackground;

    public ImageAdapter(Context context, List<Image> images) 
    {
        this.context = context;
        this.images = images;
        this.imageDownloader = new ImageDownloader();
        
        TypedArray typArray = context.obtainStyledAttributes(R.styleable.GalleryTheme);
        galleryItemBackground = typArray.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0);
        typArray.recycle();
    }

    public int getCount() 
    {
        return images.size();
    }

    public Object getItem(int position) 
    {
        return position;
    }

    public long getItemId(int position) 
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) 
    {
        ImageView imageView = new ImageView(context);

        imageView.setImageResource(R.drawable.ic_release);
        imageDownloader.download(images.get(position).getUri(), imageView);
        imageView.setLayoutParams(new Gallery.LayoutParams(150, 150));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(galleryItemBackground);

        return imageView;
    }
}