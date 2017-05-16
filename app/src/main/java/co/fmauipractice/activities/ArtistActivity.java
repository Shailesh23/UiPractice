package co.fmauipractice.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import co.fmauipractice.R;
import co.fmauipractice.ServerCall.ServerCall;
import co.fmauipractice.adapter.RecycleDataAdapter;
import co.fmauipractice.di.DaggerServerDiComponent;
import co.fmauipractice.pojos.Artists;
import co.fmauipractice.pojos.DataSetInfo;
import dagger.Component;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistActivity extends AppCompatActivity implements Callback<DataSetInfo<Artists>> {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecycleDataAdapter recycleDataApdapter;
    boolean loading;
    @Inject ServerCall serverCall;
    int page = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_artist);

        serverCall = DaggerServerDiComponent.builder().build().serverCaller();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recycleDataApdapter = new RecycleDataAdapter();
        recyclerView.setAdapter(recycleDataApdapter);
        recycleDataApdapter.setContext(ArtistActivity.this);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (loading) {
                    return;
                }
                int totalCount = layoutManager.getItemCount();
                int visibleItemCount = layoutManager.getChildCount();
                int pastVisibleCount = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                if (pastVisibleCount + visibleItemCount >= totalCount) {
                    loadNewContent();
                }
            }
        });

        loadNewContent();
    }

    void loadNewContent() {
        //TODO: Use DI to get this object
        serverCall.getArtistsTypeList(this, page++);
        loading = true;
    }

    @Override
    public void onResponse(Call<DataSetInfo<Artists>> call, Response<DataSetInfo<Artists>> response) {

        recycleDataApdapter.addItem(response.body().getDataset());
        recycleDataApdapter.notifyDataSetChanged();
        loading = false;

        System.out.println(response.body().getTitle());
    }

    @Override
    public void onFailure(Call<DataSetInfo<Artists>> call, Throwable t) {

    }
}
