package com.company.androidspannable;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView textNumber;
    private ImageView imageView;
    private TextView textMailAmdName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);
        getSupportActionBar().hide();
        String number = getIntent().getStringExtra("number");
        textNumber = findViewById(R.id.textNumber);
        textNumber.setText(number);
        String name = getIntent().getStringExtra("name");
        textMailAmdName = findViewById(R.id.textMailAndName);
        String lastWord = "email";
        textMailAmdName.setText(name + " " + lastWord);

        Spannable spannable = new SpannableString(name+lastWord);
        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimaryDark)), 0, name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), name.length(), name.length()+lastWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
       textMailAmdName.setText( spannable );
        imageView = findViewById(R.id.imageV);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("photoId");
            imageView.setImageResource(resId);
        }
    }

    public void dial(View v) {
        String toDial = "tel:" + textNumber.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(toDial));
        startActivity(callIntent);
    }
    String subject = "Test";
    String message = "Test";

    public void sendEmail (View v){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"shpakavaa@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");
        startActivity(emailIntent);
    }
}
