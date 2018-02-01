package alexlarios.umpirebuddy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button strikeButton, ballButton;
    private TextView ballTextView, strikeTextView;
    private int ballCount = 0, strikeCount= 0;
    private TextView outTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


}
