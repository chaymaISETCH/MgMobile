package com.example.sameh.mymg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.Manifest.permission.READ_CONTACTS;
import static com.example.sameh.mymg.R.color.bleu;


public class Inscriprion extends AppCompatActivity {
    private EditText tNom;
    private EditText tPrenom;
    private EditText ttel;
    private EditText tmail;
    private EditText tPassword1;
    private EditText tPassword2;
    private Button b1;
  //  private String recup0, recup11, recup3, recup4, recup5, recup6;
   private  TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscriprion);
        tNom = (EditText) findViewById(R.id.nom);
        tPrenom = (EditText) findViewById(R.id.prenom);
        ttel = (EditText) findViewById(R.id.tel);
        tmail = (EditText) findViewById(R.id.email);
        tPassword1 = (EditText) findViewById(R.id.pass);
        tPassword2 = (EditText) findViewById(R.id.pass2);
        text = (TextView) findViewById(R.id.mood);
        b1 = (Button) findViewById(R.id.button1);
        EditText text = (EditText) findViewById(R.id.tel);
        PhoneNumberUtils.formatNumber(text.getText().toString());
        EditText text1 = (EditText) findViewById(R.id.ncarte);
        PhoneNumberUtils.formatNumber(text1.getText().toString());
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (tNom.getText().length()==0 || tPrenom.getText().length()==0|| ttel.getText().length()==0|| tmail.getText().length()==0|| tPassword1.getText().length()==0|| tPassword2.getText().length()==0) {
                   if(tNom.getText().length()==0){ tNom.setError("Remplir ce champ");}
                   if(tPrenom.getText().length()==0){ tPrenom.setError("Remplir ce champ");}
                    if(ttel.getText().length()==0){ttel.setError("Remplir ce champ");}
                    if(tmail.getText().length()==0){tmail.setError("Remplir ce champ");}
                    if(tPassword1.getText().length()==0){tPassword1.setError("Remplir ce champ");}
                    if(tPassword2.getText().length()<6){tPassword2.setError("Mot de passe faible");}
                    if(!(tPassword1.getText().equals(tPassword2.getText()))){tPassword2.setError("les mot de passe doit être identique");}

                } else{
                    Intent intent_next = new Intent(Inscriprion.this, Produits.class);
                    startActivity(intent_next);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                    finish();
                }
            }
        });


        tPassword1.addTextChangedListener(mTextEditorWatcher);
    }

        final TextWatcher mTextEditorWatcher = new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // When No Password Entered
                text.setText("Not Entered");
            }

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            public void afterTextChanged(Editable s)
            {


                if(s.length()==0)
                    text.setText("   Mot de passe doit dépasse 8 caractères");
                else if(s.length()<6){
                    text.setText("   faible");
                    text.setTextColor(getResources().getColor(R.color.Rouge));
                    text.setCompoundDrawablesWithIntrinsicBounds( R.drawable.bad, 0, 0, 0);
                }
                else if(s.length()<10) {
                    text.setText("   Passable");
                    text.setTextColor(getResources().getColor(R.color.Jaune));
                    text.setCompoundDrawablesWithIntrinsicBounds( R.drawable.gd, 0, 0, 0);


                }
                else if(s.length()<15){
                    text.setText("   Bien");
                    text.setTextColor(getResources().getColor(R.color.Vert));
                    text.setCompoundDrawablesWithIntrinsicBounds( R.drawable.good, 0, 0, 0);

                }
                else {
                    text.setText("   très bien");
                    text.setTextColor(getResources().getColor(R.color.Vert));
                    text.setCompoundDrawablesWithIntrinsicBounds( R.drawable.good, 0, 0, 0);

                }
                if(s.length()==20)
                    text.setText("   très longue");
            }
        };






}

