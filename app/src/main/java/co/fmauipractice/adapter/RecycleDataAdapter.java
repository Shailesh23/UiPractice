package co.fmauipractice.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.fmauipractice.R;
import co.fmauipractice.pojos.Artists;

/**
 * Created by Shal on 18-12-2016.
 */

public class RecycleDataAdapter extends RecyclerView.Adapter<RecycleDataAdapter.DataObjectHolder>{

    List<Artists> dataList = new ArrayList<>();

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.artistBio.setText(dataList.get(position).getArtistBio());
        holder.artistName.setText(dataList.get(position).getArtistName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addItem(List<Artists> artist){
        dataList.addAll(artist);
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder{
        TextView artistName;
        TextView artistBio;

        public DataObjectHolder(View itemView) {
            super(itemView);
            artistName = (TextView) itemView.findViewById(R.id.text_artist_name);
            artistBio = (TextView) itemView.findViewById(R.id.text_artist_bio);
        }
    }
}
