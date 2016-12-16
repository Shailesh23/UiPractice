package co.fmauipractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.fmauipractice.ServerCall.ServerCall;
import co.fmauipractice.interfaces.NetworkDownloadCallFinished;
import co.fmauipractice.pojos.Artist;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NetworkDownloadCallFinished{

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_server_response);

        Button button = (Button) findViewById(R.id.btn_call_server);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerCall serverCall = new ServerCall(MainActivity.this);
                serverCall.getTypeList();
            }
        });
    }

    @Override
    public void serverResult(Response<Artist> artistResponse) {
        textView.setText(artistResponse.body().toString());
    }
}
