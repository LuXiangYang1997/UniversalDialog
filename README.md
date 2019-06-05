# UniversalDialog
一个通用的Dialog，可以满足基本需求
## 依赖：   implementation 'com.github.LuXiangYang1997:UniversalDialog:v1.0.1'
![image](https://github.com/LuXiangYang1997/UniversalDialog/blob/master/images/WechatIMG2.png)
![image](https://github.com/LuXiangYang1997/UniversalDialog/blob/master/images/WechatIMG3.png)
![image](https://github.com/LuXiangYang1997/UniversalDialog/blob/master/images/WechatIMG4.png)
![image](https://github.com/LuXiangYang1997/UniversalDialog/blob/master/images/WechatIMG5.png)
## 使用方法：
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
# 当前提供了4种基本布局如不需自定义可以进行使用：
    //一个提示文案，两个按钮
    public static final int ONE_NORMAL_STYLE = R.layout.layout_one_universal_dialog;
    //一个提示文案，一个按钮
    public static final int SECOND_NORMAL_STYLE = R.layout.layout_second_universal_dialog;
    //可以显示图片和文案，两个按钮
    public static final int THREE_NORMAL_STYLE = R.layout.layout_three_universal_dialog;
    //可以显示图片和文案，只有一个按钮
    public static final int FOUR_NORMAL_STYLE = R.layout.layout_four_universal_dialog;
    
# 如需自定义布局可以将第二个参数和第三个参数进行相应调整即可
    
