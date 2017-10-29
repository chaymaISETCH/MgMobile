package com.example.sameh.mymg;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

public class Produits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        BoomMenuButton bmb = (BoomMenuButton) findViewById(R.id.bmb);
        int[] bd=new int[]{
                R.drawable.heart,
                R.drawable.list,
                R.drawable.catalogue,
                R.drawable.parking,
                R.drawable.recette,
                R.drawable.facebook

        };
        String[] bd1=new String[]{
                "centre d'intérêt",
                "Liste",
                "Catalogue",
                "Place Parking",
                "Recette",
                "Facebook"
        };

        for (int i = 0; i < bd.length; i++) {
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalImageRes(bd[i])
                    .normalText(bd1[i]);

            bmb.addBuilder(builder);


        }

    }
}




