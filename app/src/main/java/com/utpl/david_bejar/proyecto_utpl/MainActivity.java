package com.utpl.david_bejar.proyecto_utpl;

import android.content.Intent;
import android.net.Uri;
import android.net.sip.SipAudioCall;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Cast of the UI Objects
        WebView webView1 = (WebView) findViewById(R.id.webView);
        //Can handle page navigation without using external browser to open links
        webView1.setWebViewClient(new WebViewClient());
        String url = "http://www.utpl.edu.ec/";
        webView1.loadUrl(url);
        //Activates javascript within webView1
        webView1.getSettings().setJavaScriptEnabled(true);
        //Enable Zoom into the webview
        WebSettings webSettings = webView1.getSettings();
        webSettings.setBuiltInZoomControls(true);



        //Code to use an intent to the complete broswer (better to interact and runs javascript)
        Uri uri = Uri.parse("http://www.utpl.edu.ec/");
        //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        //startActivity(intent);






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    //Handles the black button to navigate with the webview
    @Override
    public void onBackPressed() {
        WebView webView = (WebView) findViewById(R.id.webView);
        if (webView.copyBackForwardList().getCurrentIndex() > 0) {
            webView.goBack();
        }
        else {
            // Your exit alert code, or alternatively line below to finish
            super.onBackPressed(); // finishes activity
        }
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
