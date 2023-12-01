package com.sleepace.m8701wsdk.demo;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sleepace.m8701wsdk.demo.R;

public class BaseActivity extends Activity implements OnClickListener {
	protected final String TAG = this.getClass().getSimpleName();
	protected ImageView ivBack;
	protected TextView tvTitle;
	protected ImageView ivRight;
	protected BaseActivity mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mContext = this;
	}

	protected void findView() {
		ivBack = (ImageView) findViewById(R.id.iv_back);
		tvTitle = (TextView) findViewById(R.id.tv_title);
	};

	protected void initListener() {
		if(ivBack != null){
			ivBack.setOnClickListener(this);
		}
	};

	protected void initUI() {
		
	};
	

	@Override
	public void onClick(View v) {
		if(v == ivBack){
			finish();
		}
	}
	
	public void showTips(String msg) {
        final Dialog dialog = new Dialog(this, R.style.myDialog);
        dialog.setContentView(R.layout.dialog_warn_tips);

        TextView tvTips = (TextView) dialog.findViewById(R.id.warn_tips);
        Button btn = (Button) dialog.findViewById(R.id.warn_bt);
        
        tvTips.setText(msg);
        btn.setText(android.R.string.ok);

        OnClickListener mListner = new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        };

        btn.setOnClickListener(mListner);
        Window win = dialog.getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        win.setAttributes(lp);

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
	
	
}


















