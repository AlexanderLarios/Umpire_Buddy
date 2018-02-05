package logiclotus.umpirebuddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button strikeButton, ballButton;
    private TextView ballTextView, strikeTextView;
    private int ballCount = 0, strikeCount = 0;
    //saving states for ball and strike counts
    static final String STATE_BALL = "balls";
    static final String STATE_STRIKE = "strikes";

    //Save state
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_BALL, ballCount);
        savedInstanceState.putInt(STATE_STRIKE, strikeCount);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Resume
        if(savedInstanceState !=null) {
            ballCount = savedInstanceState.getInt(STATE_BALL);
            strikeCount = savedInstanceState.getInt(STATE_STRIKE);
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        strikeButton = (Button) findViewById(R.id.strikeButton);
        ballButton = (Button) findViewById(R.id.ballButton);
        ballTextView = (TextView) findViewById(R.id.ballTextView);
        strikeTextView = (TextView) findViewById(R.id.strikeTextView);

        strikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("OUT!");
                builder.setMessage("Three Strikes You're Out!");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog out = builder.create();
                strikeCount++;
                strikeTextView.setText(String.valueOf(strikeCount));
                if(strikeCount >= 3){
                    out.show();
                    strikeCount=0;
                    strikeTextView.setText(String.valueOf(strikeCount));
                }

            }
        });


        ballButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("WALK!");
                builder.setMessage("WALK!");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog walk = builder.create();
                ballCount++;
                ballTextView.setText(String.valueOf(ballCount));
                if(ballCount >= 4){
                    walk.show();
                    ballCount=0;
                    ballTextView.setText(String.valueOf(ballCount));
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            setContentView(R.layout.activity_about);

        }
        if (id == R.id.reset) {
            ballCount = 0;
            strikeCount = 0;
            strikeTextView.setText(String.valueOf(strikeCount));
            ballTextView.setText(String.valueOf(ballCount));
        }


        return super.onOptionsItemSelected(item);
    }
}
