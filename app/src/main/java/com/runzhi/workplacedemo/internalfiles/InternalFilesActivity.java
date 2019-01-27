package com.runzhi.workplacedemo.internalfiles;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.runzhi.workplacedemo.R;

public class InternalFilesActivity extends AppCompatActivity {
    private static final int READ_REQUEST_CODE = 14;

    private ImageView mFilePreviewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_files);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.drawer_item_file);
        }

        View openFileButton = findViewById(R.id.open_file_button);
        mFilePreviewer = findViewById(R.id.file_previewer);
        openFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");

                startActivityForResult(intent, READ_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri;
            uri = data.getData();
            if (uri != null) {
                mFilePreviewer.setImageURI(uri);
                mFilePreviewer.setVisibility(View.VISIBLE);
            }
        }
    }
}
