package alexlarios.umpirebuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button strikeButton, ballButton;
    private TextView ballNumber, strikeNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     strikeButton = (Button) findViewById(R.id.strikeButton)


    }

    public void onStrikeButton(View view) {
    }

    public void onBallButton(View view) {
    }
}
