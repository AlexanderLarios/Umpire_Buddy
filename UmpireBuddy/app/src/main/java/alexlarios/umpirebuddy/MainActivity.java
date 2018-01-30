package alexlarios.umpirebuddy;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button strikeButton, ballButton;
    private TextView ballTextView, strikeTextView;
    private int ballCount = 0, strikeCount= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     strikeButton = (Button) findViewById(R.id.strikeButton);
     ballButton = (Button) findViewById(R.id.ballButton);
     ballTextView = (TextView) findViewById(R.id.ballTextView);
     strikeTextView = (TextView) findViewById(R.id.strikeTextView);
    }


    public void onStrikeButton(View view) {
        strikeCount++;
        strikeTextView.setText(String.valueOf(strikeCount));
        if(strikeCount == 3){

        }
    }

    public void onBallButton(View view) {
        ballCount++;
        ballTextView.setText(String.valueOf(ballCount));
    }
}
