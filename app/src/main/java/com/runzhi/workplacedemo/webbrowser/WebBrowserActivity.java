package com.runzhi.workplacedemo.webbrowser;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;

import com.runzhi.workplacedemo.R;

public class WebBrowserActivity extends AppCompatActivity {

    private static final String HOME_PAGE_URL = "https://www.bing.com";

    EditText mTextBox;
    ImageView mGoButton;
    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.webview_title_bar);
        }

        mTextBox = findViewById(R.id.webview_text_box);
        mTextBox.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    loadUrl(mTextBox.getText().toString());
                    return true;
                }
                return false;
            }
        });
        mGoButton = findViewById(R.id.webview_enter_button);
        mWebview = findViewById(R.id.webview);
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (mTextBox != null) {
                    mTextBox.setText(url);
                }
                return false;
            }
        });
        mGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadUrl(mTextBox.getText().toString());
            }
        });
        loadHomePage();
    }

    private void loadUrl(String text) {
        if (mWebview != null) {
            mWebview.loadUrl(convertToUrl(text));
            InputMethodManager inputMethodManager =
                    (InputMethodManager)  this.getSystemService(Activity.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null && this.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(
                        this.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    private String convertToUrl(String text) {
        if (text.startsWith("https://www.")) {
            return text;
        }
        else if (text.startsWith("www.")) {
            return "https://" + text;
        }
        else {
            return "https://www.bing.com/search?q=" + text;
        }
    }

    private void loadHomePage() {
        if (mWebview != null) {
            mTextBox.setText(HOME_PAGE_URL);
            mWebview.loadUrl(HOME_PAGE_URL);
        }
    }
}
