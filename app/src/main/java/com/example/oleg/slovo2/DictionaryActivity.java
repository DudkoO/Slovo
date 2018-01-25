package com.example.oleg.slovo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DictionaryActivity extends AppCompatActivity implements View.OnClickListener {

    Button btRus;
    Button btDe;
    TextView tvDictionary;


    int currentLanguage = 0;
    final int RUS = 0;
    final int DE = 1;

    String[] rusWords = new String[0];
    String[] deWords = new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        setTitle( Data.tasksTitles[Data.num]);

        btRus = (Button) findViewById(R.id.btRus);
        btDe = (Button) findViewById(R.id.btDe);
        tvDictionary = (TextView) findViewById(R.id.tvDictionary);

        btRus.setOnClickListener(this);
        btDe.setOnClickListener(this);

        switch (Data.num) {
            case 0:
                rusWords = Data.animalsRusList;
                deWords  = Data.animalsDelishList;
                break;
            case 1:
                rusWords = Data.technicsRusList;
                deWords = Data.technicsDeList;
                break;
            case 2:
                rusWords = Data.clothesRusList;
                deWords = Data.clothesDelishList;
                break;
            case 3:
                rusWords = Data.foodRusList;
                deWords = Data.foodDelishList;
                break;
        }

        setWords();




    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        switch (viewId) {
            case R.id.btRus:
                currentLanguage = RUS;
                break;
            case R.id.btDe:
                currentLanguage = DE;
                break;
        }

        setWords();
    }


    private void setWords() {
        String str = "";
        if (currentLanguage == RUS) {
            for (int i = 0; i < rusWords.length; i++) {
                str += rusWords[i] + "\n\n";
            }
        } else {
            for (int i = 0; i < deWords.length; i++) {
                str += deWords[i] + "\n\n";
            }
        }

        tvDictionary.setText(str);
    }
}
