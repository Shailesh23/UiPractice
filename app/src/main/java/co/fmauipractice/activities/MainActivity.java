package co.fmauipractice.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import co.fmauipractice.R;
import co.fmauipractice.customviews.DialerView;
import co.fmauipractice.interfaces.NetworkDownloadCallFinished;
import co.fmauipractice.pojos.DataSetInfo;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NetworkDownloadCallFinished {

    TextView textView;
    DialerView dialerView;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_server_response);
        dialerView = (DialerView) findViewById(R.id.dialer_view);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);

        Button button = (Button) findViewById(R.id.btn_call_server);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistIntent = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(artistIntent);
            }
        });
    }



    @Override
    public void serverResult(Response<DataSetInfo> serverResponse) {
        textView.setText(serverResponse.body().toString());
    }
}
