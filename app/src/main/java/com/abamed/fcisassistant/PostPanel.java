package com.abamed.fcisassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import FcisAssistant.Adminstration;
import FcisAssistant.FirebaseClass;
import FcisAssistant.Post;

public class PostPanel extends AppCompatActivity {
private Button postbtn;
private EditText posttext;
private TextView textView;
private String postername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_panel);
        Bundle b = getIntent().getExtras();
        postername = b != null ? b.getString("postername") : null;
        posttext=findViewById(R.id.postspace);
        postbtn=findViewById(R.id.postbutton);
        textView=findViewById(R.id.charactercount);
        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post=new Post(postername,posttext.getText().toString(),"uknown");
                FirebaseClass.WritePost(post);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
