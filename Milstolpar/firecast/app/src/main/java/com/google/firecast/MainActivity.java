package com.google.firecast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {
    public static final String NAME_KEY = "name";
    public static final String AGE_KEY = "age";
    public static final String TAG = "info";

    TextView textView;

    private DocumentReference some = FirebaseFirestore.getInstance().document("data/info");


    @Override
    protected void onStart() {
        super.onStart();
        some.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException error) {
                String nameText = documentSnapshot.getString(NAME_KEY);
                String ageText = documentSnapshot.getString(AGE_KEY);
                textView.setText("Your name is: " + nameText + "  ||  Your age is: " + ageText);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textFromFire);
    }

    public void saveInfo(View view) {
        EditText nameView = (EditText) findViewById(R.id.EditTextTextPersonName);
        EditText ageView = (EditText) findViewById(R.id.EditTextAge);
        String nameText = nameView.getText().toString();
        String ageText = ageView.getText().toString();

        Map<String, Object> dataToSave = new HashMap<String, Object>();
        dataToSave.put(NAME_KEY, nameText);
        dataToSave.put(AGE_KEY, ageText);

        some.set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d(TAG, "The name and the age has been saved");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Info unsaved", e);
            }
        });
    }
}