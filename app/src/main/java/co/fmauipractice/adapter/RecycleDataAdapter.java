package co.fmauipractice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import co.fmauipractice.R;
import co.fmauipractice.helpers.DataSetRules;
import co.fmauipractice.pojos.Artists;

/**
 * Created by Shal on 18-12-2016.
 */

public class RecycleDataAdapter extends RecyclerView.Adapter<RecycleDataAdapter.DataObjectHolder>{

    List<Artists> dataList = new ArrayList<>();
    private Context context;
    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        Artists artist = dataList.get(position);
        String bio = artist.getArtistBio();
        String name = artist.getArtistName();
        String url = dataList.get(position).getArtistImageFile().replaceAll("\\\\","");

        holder.artistBio.setText(bio);
        holder.artistName.setText(name);

        if(context!=null){
            System.out.println("images ::"+url);
            Glide.with(context).load(url).centerCrop()
                    .placeholder(R.color.colorPrimary).crossFade().into(holder.artistImage);
        }
    }

    public void setContext(Context context){
        this.context = context;
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addItem(List<Artists> artist){
        dataList.addAll(DataSetRules.getCleanArtistsDataSet(artist));
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder{
        TextView artistName;
        TextView artistBio;
        ImageView artistImage;

        public DataObjectHolder(View itemView) {
            super(itemView);
            artistName = (TextView) itemView.findViewById(R.id.text_artist_name);
            artistBio = (TextView) itemView.findViewById(R.id.text_artist_bio);
            artistImage = (ImageView) itemView.findViewById(R.id.image_artist);
        }
    }
}
