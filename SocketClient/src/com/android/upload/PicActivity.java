package com.android.upload;

import android.app.Activity;  
import android.content.Intent;  
import android.database.Cursor;  
import android.net.Uri;  
import android.os.Bundle;  
import android.provider.MediaStore;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
  
public class PicActivity extends Activity {  
    /** Called when the activity is first created. */  
    private Button myButton_02 = null;  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main2);  
          
        myButton_02 = (Button)findViewById(R.id.button2);  
        myButton_02.setOnClickListener(new OnClickListener() {  
  
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);  
                startActivityForResult(intent, 1);  
            }  
        });  
    }  
    protected void onActivityResult(int requestCode, int resultCode, Intent data)  
    {  
        if (resultCode == Activity.RESULT_OK)  
        {  
            Uri uri = data.getData();  
            Cursor cursor = this.getContentResolver().query(uri, null, null, null, null);  
            cursor.moveToFirst();  
            for (int i = 0; i < cursor.getColumnCount(); i++)  
            {// 取得图片uri的列名和此列的详细信息  
                System.out.println(i + "-" + cursor.getColumnName(i) + "-" + cursor.getString(i));  
            }  
        }  
    }  
      
}
      