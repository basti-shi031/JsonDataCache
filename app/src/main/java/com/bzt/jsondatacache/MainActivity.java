package com.bzt.jsondatacache;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


import com.bzt.jsonhelperlib.DeleteAllListener;
import com.bzt.jsonhelperlib.DeleteListener;
import com.bzt.jsonhelperlib.JsonHelper;
import com.bzt.jsonhelperlib.LoadBean;
import com.bzt.jsonhelperlib.LoadListener;
import com.bzt.jsonhelperlib.SaveListener;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity implements DeleteListener, DeleteAllListener, LoadListener, SaveListener {

    private JsonHelper jsonHelper;

    private String content = "测试";
    private String fileName = "/MainActivity.txt";

    private String content1 = "测试1";
    private String fileName1 = "/MainActivity1.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path =  getApplicationContext().getFilesDir().getAbsolutePath()+"/jsoncache";
        jsonHelper = new JsonHelper();
        /*jsonHelper.setOnDeleteListener(this);
        jsonHelper.setOnDeleteAllListener(this);
        jsonHelper.setOnLoadListener(this);
        jsonHelper.setOnSaveListener(this);*/

        jsonHelper.setOnAllListener(this,this,this,this);

        test(path);

        test1(path);


    }

    private void test1(final String path) {

        findViewById(R.id.save1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonHelper.saveJson(content1, path, fileName1,1);
            }
        });

        findViewById(R.id.load1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonHelper.loadJson(path, fileName1,1);
            }
        });

        findViewById(R.id.clear1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonHelper.clearCache(path, fileName1, 1);
            }
        });
    }

    private void test(final String path) {
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonHelper.saveJson(content,path, fileName,0);
            }
        });

        findViewById(R.id.load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               jsonHelper.loadJson(path,fileName,0);
            }
        });

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonHelper.clearCache(path, fileName, 0);
            }
        });

        findViewById(R.id.clearAll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonHelper.clearAllCache(path, 0);
            }
        });
    }

    @Override
    public void finishDeleteAll(int deleteTag) {
        switch (deleteTag){
            case 0:
                Log.i("Delete_ALL"+deleteTag,"完成");
                break;
        }
    }

    @Override
    public void finishDelete(int deleteTag, boolean success) {
        switch (deleteTag){
            case 0:
                if (success){
                    Log.i("Delete"+deleteTag,"完成");
                }else {
                    Log.i("Delete"+deleteTag,"失败");
                }
                break;
            case 1:
                if (success){
                    Log.i("Delete"+deleteTag,"完成");
                }else {
                    Log.i("Delete"+deleteTag,"失败");
                }
                break;
        }
    }

    @Override
    public void finishLoad(int loadTag, LoadBean loadBean) {
        switch (loadTag){
            case 0:
                if(loadBean.isSuccess()){
                    Log.i("Load"+loadTag,loadBean.getResult());
                }else{
                    Log.i("Load"+loadTag,"失败");
                }
                break;
            case 1:
                if(loadBean.isSuccess()){
                    Log.i("Load"+loadTag,loadBean.getResult());
                }else{
                    Log.i("Load"+loadTag,"失败");
                }

                break;
        }
    }

    @Override
    public void finishSave(int saveTag, boolean success) {
        switch (saveTag){
            case 0:
                if (success){
                    Log.i("Save"+saveTag,"成功");
                }else {
                    Log.i("Save"+saveTag,"失败");
                }
                break;
            case 1:
                if (success){
                    Log.i("Save"+saveTag,"成功");
                }else {
                    Log.i("Save"+saveTag,"失败");
                }
                break;
        }
    }
}
