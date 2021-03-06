package com.github.adalpari.mvpretrofitjson.ui.main.view.listadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adalpari.mvpretrofitjson.R;
import com.github.adalpari.mvpretrofitjson.model.Comic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {

    private List<Comic> comicsList;
    private Context mContext;


    public ComicAdapter(List<Comic> comicsList, Context context) {
        if (comicsList == null) {
            this.comicsList = new ArrayList<>();
        } else {
            this.comicsList = comicsList;
        }

        this.mContext = context;
    }

    public void addComics(List<Comic> comicsList) {
        this.comicsList.addAll(comicsList);
        notifyDataSetChanged();
    }

    public Comic getComic(int position) {
        return comicsList.get(position);
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_comic, parent, false);

        return new ComicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        Comic comic = comicsList.get(position);
        Picasso.with(mContext)
                .load(comic.getPicture())
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.image_error)
                .fit()
                .into(holder.picture);
        holder.title.setText(comic.getTitle());
    }

    @Override
    public int getItemCount() {
        return comicsList.size();
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView title;

        public ComicViewHolder(View view) {
            super(view);
            picture = (ImageView) view.findViewById(R.id.ivPicture);
            title = (TextView) view.findViewById(R.id.tvMainTitle);
        }
    }
}