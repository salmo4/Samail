 package com.samcompany.samail;
 import android.content.Intent;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;

 public class MainActivity extends AppCompatActivity {

     EditText etTo, etSub, etMsg;
     Button btSend;
     String la, subiect, mesaj;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         etTo = (EditText) findViewById(R.id.etTo);
         etSub = (EditText) findViewById(R.id.etSub);
         etMsg = (EditText) findViewById(R.id.etMsg);

         btSend = (Button) findViewById(R.id.btSend);

         btSend.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 la = etTo.getText().toString();
                 subiect = etSub.getText().toString();
                 mesaj = etMsg.getText().toString();


                 Intent email = new Intent(Intent.ACTION_SEND);
                 email.putExtra(Intent.EXTRA_EMAIL, new String[]{ la});
                 email.putExtra(Intent.EXTRA_SUBJECT, subiect);
                 email.putExtra(Intent.EXTRA_TEXT, mesaj);

                 //need this to prompts email client only
                 email.setType("message/rfc822");

                 startActivity(Intent.createChooser(email, "Alege un Client de E-mail :"));
             }
         });
     }
 }

