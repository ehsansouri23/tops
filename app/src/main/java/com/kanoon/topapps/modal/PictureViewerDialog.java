package com.kanoon.topapps.modal;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kanoon.topapps.R;

/**
 * Created by ehsan on 3/30/2018.
 */

public class PictureViewerDialog extends Dialog {

    private Context context;
    private String picPath;
    private ImageView image;
    private TextView doneBtn;

    public PictureViewerDialog(Context context, String picPath) {
        super(context);
        this.context = context;
        this.picPath = picPath;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.picture_viewer_dialog_layout);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        image = (ImageView) findViewById(R.id.image);
        doneBtn = (TextView) findViewById(R.id.done_btn);
        doneBtn.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/sl.ttf"));
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        Glide.with(context)
                .load(picPath)
                .placeholder(R.mipmap.ic_launcher)
                .into(image);
    }
}
