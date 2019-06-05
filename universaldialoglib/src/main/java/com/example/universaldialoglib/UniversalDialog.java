package com.example.universaldialoglib;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用的Dialog
 *
 * @author created by luxiangyang on 2019-06-05
 */
public class UniversalDialog extends Dialog implements View.OnClickListener {

    private Context mContext;//上下文对象
    private int mLayOutResId;//布局Id
    private int[] mListenerItemIds;//需要监听的view的Id  layoutResId为0则会根据默认布局
    private List<View> mViewList = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;//view点击监听
    private boolean mIsDimissTouchOut = false;//点击外部弹窗是否消失 默认不消失
    private int mDefaultStyleLayout = Constant.ONE_NORMAL_STYLE;//默认样式，只在layoutResId为0的情况下起效果
    private String mLeftBtnStr = "";//左边按钮的文案
    private String mRightBtnStr = "";//右边按钮的文案
    private String mContentStr = "";//中间提示文案
    private String mOneBtnStr = "";//只有一个按钮时的文案
    private int mLeftBtnColor = Color.BLACK;//左边按钮的颜色
    private int mRightBtnColor = Color.BLACK;//右边按钮的颜色
    private int mContentColor = Color.BLACK;//内容的颜色
    private int mOneBtnColor = Color.BLACK;//只有一个按钮的颜色
    private int mLeftBtnSize = 17;//左边按钮的文字大小
    private int mRightBtnSize = 17;//右侧按钮的文字大小
    private int mContentSize = 13;//内容的文字大小
    private int mOneBtnSize = 17;//只有一个按钮的文字大小
    private int imgResource;//icon


    /**
     * @param context          上下文对象
     * @param layoutResId      布局Id 如果不需要自己定义布局则传入0
     * @param mListenerItemIds 监听布局中view
     * @param isDimissTouchOut 点击外部是否可以消失
     */
    public UniversalDialog(Context context, int layoutResId, int[] mListenerItemIds, int defaultStyleLayout, boolean isDimissTouchOut) {
        super(context, R.style.Universal_Dialog_Style);//dialog风格
        this.mContext = context;
        this.mLayOutResId = layoutResId;
        this.mListenerItemIds = mListenerItemIds;
        this.mDefaultStyleLayout = defaultStyleLayout;
        this.mIsDimissTouchOut = isDimissTouchOut;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mLayOutResId == 0) {
            View view = LayoutInflater.from(mContext).inflate(mDefaultStyleLayout, null);
            if (view != null) {
                setContentView(view);
                if (mDefaultStyleLayout == Constant.ONE_NORMAL_STYLE || mDefaultStyleLayout == Constant.THREE_NORMAL_STYLE) {
                    if (mDefaultStyleLayout == Constant.THREE_NORMAL_STYLE) {
                        mListenerItemIds = Constant.THREE_NORMAL_STYLE_ITEMIDS;
                        ImageView imgView = view.findViewById(mListenerItemIds[3]);

                        imgView.setImageResource(imgResource);
                    } else {
                        mListenerItemIds = Constant.ONE_NORMAL_STYLE_ITEMIDS;
                    }
                    TextView leftTextView = view.findViewById(mListenerItemIds[0]);//左侧按钮
                    TextView rightTextView = view.findViewById(mListenerItemIds[1]);//右侧按钮
                    TextView contentTextView = view.findViewById(mListenerItemIds[2]);//内容

                    if (!TextUtils.isEmpty(mLeftBtnStr)) {
                        leftTextView.setText(mLeftBtnStr);
                    }

                    if (!TextUtils.isEmpty(mRightBtnStr)) {
                        rightTextView.setText(mRightBtnStr);
                    }
                    if (!TextUtils.isEmpty(mContentStr)) {
                        contentTextView.setText(mContentStr);
                    }

                    leftTextView.setTextColor(mLeftBtnColor);
                    leftTextView.setTextSize(mLeftBtnSize);


                    rightTextView.setTextColor(mRightBtnColor);
                    rightTextView.setTextSize(mRightBtnSize);


                    contentTextView.setTextColor(mContentColor);
                    contentTextView.setTextSize(mOneBtnSize);


                } else if (mDefaultStyleLayout == Constant.SECOND_NORMAL_STYLE || mDefaultStyleLayout == Constant.FOUR_NORMAL_STYLE) {
                    if (mDefaultStyleLayout == Constant.FOUR_NORMAL_STYLE) {
                        mListenerItemIds = Constant.FOUR_NORMAL_STYLE_ITEMIDS;
                        ImageView imgView = view.findViewById(mListenerItemIds[2]);

                        imgView.setImageResource(imgResource);

                    } else {
                        mListenerItemIds = Constant.SECOND_NORMAL_STYLE_ITEMIDS;
                    }

                    TextView confirmTextView = view.findViewById(mListenerItemIds[0]);//按钮
                    TextView contentTextView = view.findViewById(mListenerItemIds[1]);//内容
                    if (!TextUtils.isEmpty(mContentStr)) {
                        contentTextView.setText(mContentStr);
                    }
                    if (!TextUtils.isEmpty(mOneBtnStr)) {
                        confirmTextView.setText(mOneBtnStr);
                    }

                    confirmTextView.setTextColor(mOneBtnColor);
                    confirmTextView.setTextSize(mOneBtnSize);
                    contentTextView.setTextColor(mContentColor);
                    contentTextView.setTextSize(mContentSize);

                }
            }
        } else {
            setContentView(mLayOutResId);
        }

        setCanceledOnTouchOutside(mIsDimissTouchOut);

        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width = defaultDisplay.getWidth();
        getWindow().setAttributes(layoutParams);

        for (int itemId : mListenerItemIds) {
            View view = findViewById(itemId);
            view.setOnClickListener(this);
            mViewList.add(view);
        }

    }

    public interface OnItemClickListener {

        void onItemClickListener(UniversalDialog mDialog, View mView);

    }

    /**
     * 点击监听
     *
     * @param mOnItemClickListener
     */
    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    /**
     * 左侧按钮文案
     *
     * @param leftBtnStr
     */
    public void setLeftBtnStr(String leftBtnStr) {
        this.mLeftBtnStr = leftBtnStr;
    }

    /**
     * 右侧按钮文案
     *
     * @param rightBtnStr
     */
    public void setRightBtnStr(String rightBtnStr) {
        this.mRightBtnStr = rightBtnStr;
    }


    /**
     * 内容文案
     *
     * @param contentStr
     */
    public void setContentStr(String contentStr) {
        this.mContentStr = contentStr;
    }

    /**
     * 左侧按钮颜色
     *
     * @param mLeftBtnColor
     */
    public void setmLeftBtnColor(int mLeftBtnColor) {
        this.mLeftBtnColor = mLeftBtnColor;
    }

    /**
     * 右侧按钮颜色
     *
     * @param mRightBtnColor
     */
    public void setmRightBtnColor(int mRightBtnColor) {
        this.mRightBtnColor = mRightBtnColor;
    }

    /**
     * 内容颜色
     *
     * @param mContentColor
     */
    public void setmContentBtnColor(int mContentColor) {
        this.mContentColor = mContentColor;
    }

    /**
     * 一个按钮颜色
     *
     * @param mOneBtnColor
     */
    public void setmOneBtnColor(int mOneBtnColor) {
        this.mOneBtnColor = mOneBtnColor;
    }

    /**
     * 一个按钮时的文案
     *
     * @param oneBtnStr
     */
    public void setOneBtnStr(String oneBtnStr) {
        this.mOneBtnStr = oneBtnStr;
    }

    /**
     * 左侧按钮的大小
     *
     * @param mLeftBtnSize
     */
    public void setmLeftBtnSize(int mLeftBtnSize) {
        this.mLeftBtnSize = mLeftBtnSize;
    }

    /**
     * 右侧按钮的大小
     *
     * @param mRightBtnSize
     */
    public void setmRightBtnSize(int mRightBtnSize) {
        this.mRightBtnSize = mRightBtnSize;
    }

    /**
     * 内容的大小
     *
     * @param mContentSize
     */
    public void setmContentSize(int mContentSize) {
        this.mContentSize = mContentSize;
    }

    /**
     * 一个按钮时的文案
     *
     * @param mOneBtnSize
     */
    public void setmOneBtnSize(int mOneBtnSize) {
        this.mOneBtnSize = mOneBtnSize;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    @Override
    public void onClick(View view) {
        mOnItemClickListener.onItemClickListener(UniversalDialog.this, view);
    }

}
