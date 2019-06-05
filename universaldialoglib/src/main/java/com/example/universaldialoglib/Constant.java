package com.example.universaldialoglib;

/**
 * @author created by luxiangyang on 2019-06-05
 */
public class Constant {

    //一个提示文案，两个按钮
    public static final int ONE_NORMAL_STYLE = R.layout.layout_one_universal_dialog;
    //一个提示文案，一个按钮
    public static final int SECOND_NORMAL_STYLE = R.layout.layout_second_universal_dialog;
    //可以显示图片和文案，两个按钮
    public static final int THREE_NORMAL_STYLE = R.layout.layout_three_universal_dialog;
    //可以显示图片和文案，只有一个按钮
    public static final int FOUR_NORMAL_STYLE = R.layout.layout_four_universal_dialog;

    //有两个按钮时的id集合
    public static final int[] ONE_NORMAL_STYLE_ITEMIDS = {R.id.tv_confirm, R.id.tv_cancel, R.id.tv_content};
    //有一个按钮的id数组
    public static final int[] SECOND_NORMAL_STYLE_ITEMIDS = {R.id.tv_confirm, R.id.tv_content};
    //带有图片两个按钮的id数组
    public static final int[] THREE_NORMAL_STYLE_ITEMIDS = {R.id.tv_confirm, R.id.tv_cancel, R.id.tv_content,R.id.img_icon};
    //带有图片一个按钮的数组
    public static final int[] FOUR_NORMAL_STYLE_ITEMIDS = {R.id.tv_confirm, R.id.tv_content,R.id.img_icon};


}
