package se.liu.ida.andla.fleraskrmer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String OUR_MESSAGE="THISISOURMESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnotherActivity();
            }
        });
    }

    private void startAnotherActivity() {
        Intent intent = new Intent(this,SecondActivity.class);
        EditText input = findViewById(R.id.email);
        String value = input.getText().toString();
        intent.putExtra(MainActivity.OUR_MESSAGE,value);
        startActivity(intent);
    }
}
