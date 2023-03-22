package se.liu.ida.andla.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FirstFragment firstFragment;
    private  SecondFragment secondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (firstFragment == null )
            firstFragment = FirstFragment.newInstance();
        if(secondFragment == null){
            secondFragment = SecondFragment.newInstance("","");
            secondFragment.setOnTDP028Listener(new TDP028Listener() {
                @Override
                public void newData(String data) {
                    swapBackToFirst(data);
                }
            });
        }
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,firstFragment).commitNow();
        Button b  = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapToSecond();
            }
        });

    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if( fragment instanceof  SecondFragment)
            ((SecondFragment) fragment).setOnTDP028Listener(new TDP028Listener() {
                @Override
                public void newData(String data) {
                    swapBackToFirst(data);
                }
            });
    }

    private void swapBackToFirst(String data) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,firstFragment).commitNow();
    }

    private void swapToSecond() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,secondFragment).commitNow();
    }
}
