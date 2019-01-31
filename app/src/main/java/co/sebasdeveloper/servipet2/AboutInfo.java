package co.sebasdeveloper.servipet2;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AboutInfo extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton btnFacebook;
    private FloatingActionButton btnLinkedin;
    private FloatingActionButton btnTwitter;
    private FloatingActionButton btnInstagram;

    private static final String URL_DEVELOPER_TWITTER = "https://twitter.com/Sebas_Camargo_";
    private static final String URL_DEVELOPER_INSTAGRAM = "https://www.instagram.com/es_sebas/";
    private static final String URL_DEVELOPER_FACEBOOK = "https://www.facebook.com/sebastian.lopez.336";
    private static final String URL_DEVELOPER_LINKEDIN = "http://www.linkedin.com/in/diego-sebastian-camargo-lopez-78317b14b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_info);
        btnFacebook = (FloatingActionButton) findViewById(R.id.btn_facebookDeveloper);
        btnTwitter = (FloatingActionButton) findViewById(R.id.btn_twitterDeveloper);
        btnLinkedin = (FloatingActionButton) findViewById(R.id.btn_linkedinDeveloper);
        btnInstagram = (FloatingActionButton) findViewById(R.id.btn_instagramDeveloper);
        toolbar = (Toolbar) findViewById(R.id.layout_actionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntentBrowser("linkedin");
            }
        });

        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntentBrowser("instagram");
            }
        });

        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntentBrowser("twitter");
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntentBrowser("facebook");
            }
        });
    }

    public void startIntentBrowser(String red){
        Intent intent;
        switch (red){
            case "facebook":
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_DEVELOPER_FACEBOOK));
                break;
            case "instagram":
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_DEVELOPER_INSTAGRAM));
                break;
            case "linkedin":
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_DEVELOPER_LINKEDIN));
                break;
            case "twitter":
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_DEVELOPER_TWITTER));
                break;
            default:
                intent = new Intent(Intent.ACTION_VIEW);
        }
        startActivity(intent);
    }


}
