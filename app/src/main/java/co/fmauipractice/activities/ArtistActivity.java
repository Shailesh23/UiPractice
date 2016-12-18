package co.fmauipractice.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import co.fmauipractice.R;
import co.fmauipractice.ServerCall.ServerCall;
import co.fmauipractice.adapter.RecycleDataAdapter;
import co.fmauipractice.pojos.Artists;
import co.fmauipractice.pojos.DataSetInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistActivity extends AppCompatActivity implements Callback<DataSetInfo<Artists>> {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecycleDataAdapter recycleDataApdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //TODO: Use DI to get this object
        ServerCall serverCall = new ServerCall();
        serverCall.getArtistsTypeList(this);
    }

    @Override
    public void onResponse(Call<DataSetInfo<Artists>> call, Response<DataSetInfo<Artists>> response) {
        recycleDataApdapter = new RecycleDataAdapter();
        recycleDataApdapter.addItem(response.body().getDataset());

        recyclerView.setAdapter(recycleDataApdapter);
        System.out.println(response.body().getTitle());
    }

    @Override
    public void onFailure(Call<DataSetInfo<Artists>> call, Throwable t) {

    }
}
