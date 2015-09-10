package com.asilarslan.sendfeedback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5;
    Button button;
    EditText editText;
    int review=0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1= (Button) findViewById(R.id.btn_1);
        btn2= (Button) findViewById(R.id.btn_2);
        btn3= (Button) findViewById(R.id.btn_3);
        btn4= (Button) findViewById(R.id.btn_4);
        btn5= (Button) findViewById(R.id.btn_5);
        button= (Button) findViewById(R.id.button);
        editText= (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String message = editText.getText().toString();

                if (message.isEmpty() || review == 0) {
                    WarningAlert.CreateAlert(MainActivity.this, "Oops!", "Can't be empty", "Ok");
                } else {

                    ParseObject noteObject = new ParseObject("Feedback");
                    noteObject.put("review", review);
                    noteObject.put("message", message);
                    noteObject.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(MainActivity.this, "Review submitted!", Toast.LENGTH_LONG).show();


                            } else {
                                WarningAlert.CreateAlert(MainActivity.this, "Sorry", e.getMessage(), "Ok");
                            }
                        }
                    });
                }
            }
        });

        btn1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btn1.setPressed(true);
                btn2.setPressed(false);
                btn3.setPressed(false);
                btn4.setPressed(false);
                btn5.setPressed(false);
                review = 1;
                return true;
            }
        });

        btn2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btn1.setPressed(false);
                btn2.setPressed(true);
                btn3.setPressed(false);
                btn4.setPressed(false);
                btn5.setPressed(false);
                review = 2;
                return true;
            }
        });

        btn3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btn1.setPressed(false);
                btn2.setPressed(false);
                btn3.setPressed(true);
                btn4.setPressed(false);
                btn5.setPressed(false);
                review = 3;
                return true;
            }
        });

        btn4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btn1.setPressed(false);
                btn2.setPressed(false);
                btn3.setPressed(false);
                btn4.setPressed(true);
                btn5.setPressed(false);
                review = 4;
                return true;
            }
        });

        btn5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btn1.setPressed(false);
                btn2.setPressed(false);
                btn3.setPressed(false);
                btn4.setPressed(false);
                btn5.setPressed(true);
                review = 5;
                return true;
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
