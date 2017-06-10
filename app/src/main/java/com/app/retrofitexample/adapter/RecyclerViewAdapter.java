package com.app.retrofitexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.retrofitexample.R;
import com.app.retrofitexample.model.WorldpopulationItem;
import com.app.retrofitexample.utils.ImageLoadedCallback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by User122 on 02-09-2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    //private ArrayList<ActorsItem> arrayList;
    //private ArrayList<AlbumList> arrayList;
    private ArrayList<WorldpopulationItem> arrayList;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<WorldpopulationItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recyclerview, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    //Replace the content of the view
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        //get data from the item data
        viewHolder.txtName.setText(arrayList.get(position).getCountry());
        Picasso.with(context)
                .load(arrayList.get(position).getFlag())
                .into(viewHolder.imgPerson, new ImageLoadedCallback(viewHolder.progressBar) {
                    @Override
                    public void onSuccess() {
                        if (viewHolder.progressBar != null) {
                            viewHolder.progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }

    //Inner class to hold a reference to each item of RecylcerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName;
        public ImageView imgPerson;
        public ProgressBar progressBar = null;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            txtName = (TextView) itemLayoutView.findViewById(R.id.txtName);

            imgPerson = (ImageView) itemLayoutView.findViewById(R.id.imgPerson);

            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}