package com.example.universaldialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.universaldialoglib.Constant;
import com.example.universaldialoglib.UniversalDialog;

public class MainActivity extends AppCompatActivity {

    private int[] dialogLayoutItemIds = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneDialog();
            }
        });
        findViewById(R.id.btn_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondDialog();
            }
        });
        findViewById(R.id.btn_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threeDialog();
            }
        });
        findViewById(R.id.btn_four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourDialog();
            }
        });

    }

    private void oneDialog() {


        UniversalDialog universalDialog = new UniversalDialog(this, 0, dialogLayoutItemIds, Constant.ONE_NORMAL_STYLE, true);
        universalDialog.setLeftBtnStr("确定");
        universalDialog.setRightBtnStr("取消");
        universalDialog.setContentStr("通用Dialog");
        universalDialog.setImgResource(R.mipmap.ic_launcher_round);
        universalDialog.setmOnItemClickListener(new UniversalDialog.OnItemClickListener() {
            @Override
            public void onItemClickListener(UniversalDialog mDialog, View mView) {
                switch (mView.getId()) {
                    case R.id.tv_confirm:
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                        break;
                    case R.id.tv_cancel:
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                        break;
                }
            }
        });
        universalDialog.show();


    }

    private void secondDialog() {


        UniversalDialog universalDialog = new UniversalDialog(this, 0, dialogLayoutItemIds, Constant.SECOND_NORMAL_STYLE, true);
        universalDialog.setOneBtnStr("确定");
        universalDialog.setContentStr("通用Dialog");
        universalDialog.setImgResource(R.mipmap.ic_launcher_round);
        universalDialog.setmOnItemClickListener(new UniversalDialog.OnItemClickListener() {
            @Override
            public void onItemClickListener(UniversalDialog mDialog, View mView) {
                switch (mView.getId()) {
                    case R.id.tv_confirm:
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                        break;
                }
            }
        });
        universalDialog.show();


    }

    private void threeDialog() {


        UniversalDialog universalDialog = new UniversalDialog(this, 0, dialogLayoutItemIds, Constant.THREE_NORMAL_STYLE, true);
        universalDialog.setLeftBtnStr("确定");
        universalDialog.setRightBtnStr("取消");
        universalDialog.setContentStr("通用Dialog");
        universalDialog.setImgResource(R.mipmap.ic_launcher_round);
        universalDialog.setmOnItemClickListener(new UniversalDialog.OnItemClickListener() {
            @Override
            public void onItemClickListener(UniversalDialog mDialog, View mView) {
                switch (mView.getId()) {
                    case R.id.tv_confirm:
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                        break;
                    case R.id.tv_cancel:
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                        break;
                }
            }
        });
        universalDialog.show();


    }

    private void fourDialog() {


        UniversalDialog universalDialog = new UniversalDialog(this, 0, dialogLayoutItemIds, Constant.FOUR_NORMAL_STYLE, true);
        universalDialog.setOneBtnStr("确定");
        universalDialog.setContentStr("通用Dialog");
        universalDialog.setImgResource(R.mipmap.ic_launcher_round);
        universalDialog.setmOnItemClickListener(new UniversalDialog.OnItemClickListener() {
            @Override
            public void onItemClickListener(UniversalDialog mDialog, View mView) {
                switch (mView.getId()) {
                    case R.id.tv_confirm:
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                        break;
                }
            }
        });
        universalDialog.show();
    }

}
