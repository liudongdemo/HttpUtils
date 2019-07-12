package com.tydfd.httputils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tydfd.tydfdokhttp.http.NeOkHttp;
import com.tydfd.tydfdokhttp.http.ResponseBean;
import com.tydfd.tydfdokhttp.http.TimeDateUtils;
import com.tydfd.tydfdokhttp.http.UserBean;
import com.tydfd.tydfdokhttp.util.IJsonDataListener;


/**
 * @author liudo
 */
public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mTextView;
    /**
     * http://www.mxnzp.com/api/holiday/single/20181208 获取今日运势
     */
    private String url = "http://www.mxnzp.com/api/holiday/single/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);
        String time = TimeDateUtils.getCurrentDateStr(TimeDateUtils.FORMAT_TYPE_1);
        url = url+ time;
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
                UserBean userBean = new UserBean();
                userBean.setUsername("");
                userBean.setPassword("");
                NeOkHttp.sendJsonRequest(null, url,userBean, ResponseBean.class, new IJsonDataListener<ResponseBean>() {
                    @Override
                    public void onSuccess(final ResponseBean rb) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTextView.setText(rb.getData());
                            }
                        });
                        Log.i("===> ",rb.toString());
                    }

                    @Override
                    public void onFailure() {

                    }
                });
            }
        });


    }


    public void Test(){
        TimeUtils.getTimeZoneDatabaseVersion();
    }

}
