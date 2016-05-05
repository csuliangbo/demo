package readthefucksoucecode.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import readthefucksoucecode.demo.model.ProductDetailInfo;
import readthefucksoucecode.demo.model.ProductSubDetailInfo;

public class CheckInchPopWindow implements OnDismissListener, OnClickListener, TextWatcher {
    public interface OnSelectedCompleteLinstener {
        /**
         * 商品详情被选中回调
         */
        public abstract void onComplete(ProductSubDetailInfo result);
    }

    private OnSelectedCompleteLinstener onSelectedCompleteListener;

    public void setOnSelectedCompleteListener(
            OnSelectedCompleteLinstener selectedCompleteListener) {
        this.onSelectedCompleteListener = selectedCompleteListener;
    }

    private TextView pop_add, pop_reduce;
    private EditText pop_num;
    private ImageView pop_del;

    private PopupWindow popupWindow;
    private OnItemClickListener listener;
    private final int ADDORREDUCE = 1;
    private Context context;
    private ProductDetailInfo mInfo;


    private SingleSelectCheckBoxs sscb_inch, sscb_color;

    private ArrayList<ProductSubDetailInfo> mSubDetailData = new ArrayList<ProductSubDetailInfo>();
    private TextView inventory_tv;
    private TextView real_price_tv;
    private ImageView iv_adapter_grid_pic;
    private DisplayImageOptions mOptions;

    private TextView ok_tv;
    private int mWhich;

    private TextView has_choose_tv;


    private ArrayList<String> mInchListStr = new ArrayList<String>();
    private ArrayList<String> mColorListStr = new ArrayList<String>();


    private String mSizeResult, mColorResult;


    public CheckInchPopWindow(Context context, ProductDetailInfo info) {
        this.context = context;
        this.mInfo = info;

        this.mOptions = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheOnDisc(true).cacheInMemory(true).build();

        View view = LayoutInflater.from(context).inflate(
                R.layout.adapter_popwindow, null);

        sscb_inch = (SingleSelectCheckBoxs) view.findViewById(R.id.sscb_inch);
        sscb_color = (SingleSelectCheckBoxs) view.findViewById(R.id.sscb_color);

        sscb_inch.setOnSelectListener(new OnSSChkClickEventInch());
        sscb_color.setOnSelectListener(new OnSSChkClickEventColor());

        ok_tv = (TextView) view.findViewById(R.id.ok_tv);

        pop_add = (TextView) view.findViewById(R.id.pop_add);
        pop_reduce = (TextView) view.findViewById(R.id.pop_reduce);
        pop_num = (EditText) view.findViewById(R.id.pop_num);

        pop_num.setSelection(1);

        pop_del = (ImageView) view.findViewById(R.id.pop_del);
        inventory_tv = (TextView) view.findViewById(R.id.inventory_tv);
        real_price_tv = (TextView) view.findViewById(R.id.real_price_tv);
        has_choose_tv = (TextView) view.findViewById(R.id.has_choose_tv);
        iv_adapter_grid_pic = (ImageView) view.findViewById(R.id.iv_adapter_grid_pic);

        pop_add.setOnClickListener(this);
        pop_reduce.setOnClickListener(this);
        pop_del.setOnClickListener(this);
        ok_tv.setOnClickListener(this);
        pop_num.addTextChangedListener(this);

        popupWindow = new PopupWindow(view, LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        popupWindow.setAnimationStyle(R.style.popWindow_anim_style);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOnDismissListener(this);

        if (mInfo != null) {
            mSubDetailData = mInfo.getItemList();

            if (mSubDetailData != null && !mSubDetailData.isEmpty()) {

                int sum = 0;
                String unit = "";

                for (int i = 0; i < mSubDetailData.size(); i++) {

                    ProductSubDetailInfo s = mSubDetailData.get(i);

                    sum += s.getStock();

                    if (!mInchListStr.contains(s.getSize_name())) {

                        mInchListStr.add(s.getSize_name());
                    }

                    if (!mColorListStr.contains(s.getColor_name())) {

                        mColorListStr.add(s.getColor_name());

                    }


                    if (s.getIs_main_item() == 1) {

                        if (!TextUtils.isEmpty(s.getUnit())) {

                            unit = s.getUnit();
                        }

                        real_price_tv.setText("￥" + s.getReal_price());

                        ImageLoader.getInstance().displayImage(s.getItem_pic(), iv_adapter_grid_pic, mOptions, null);

                    }

                }

                inventory_tv.setText("库存"+ sum + unit);

                sscb_inch.setData(mInchListStr);
                sscb_color.setData(mColorListStr);

                if (mSubDetailData.size() == 1) {


                    mSizeResult = mSubDetailData.get(0).getSize_name();
                    mColorResult = mSubDetailData.get(0).getColor_name();

                    sscb_inch.setOnlyOneChecked();
                    sscb_color.setOnlyOneChecked();

                }

            }

        }
    }

    public void setData(int which) {

        mWhich = which;
    }


    public interface OnItemClickListener {

        public void onClickAdd2Car(ProductSubDetailInfo info, Integer num);

        public void onClickBuyNow(ProductSubDetailInfo info, int num);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onDismiss() {

    }

    public void showAsDropDown(View parent) {
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
    }

    public void dissmiss() {

        if (popupWindow != null && popupWindow.isShowing()) {

            popupWindow.dismiss();
        }
    }

    @Override
    public void onClick(View v) {


        ProductSubDetailInfo result = null;

        if (mSubDetailData != null && !mSubDetailData.isEmpty()) {

            for (ProductSubDetailInfo p : mSubDetailData) {

                if (!TextUtils.isEmpty(mSizeResult) && !TextUtils.isEmpty(mColorResult)) {

                    if (p.getSize_name().equals(mSizeResult) && p.getColor_name().equals(mColorResult)) {

                        result = p;

                    }

                }
            }

        }


        switch (v.getId()) {

            case R.id.ok_tv:

                getResult2Show(result);
                if (pop_num.getText().toString().equals("")) {

                    pop_num.setText("1");
                    pop_num.setSelection(1);

                }
                if (result != null) {
                    try {


                        if (result.getStock() > 0) {

                            if (mWhich == 1) {

                                listener.onClickAdd2Car(result, Integer.valueOf(pop_num.getText().toString()));
                                dissmiss();

                            } else if (mWhich == 2) {

                                listener.onClickBuyNow(result, Integer.valueOf(pop_num.getText().toString()));
                                dissmiss();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

                break;
            case R.id.pop_add:

                if (result == null) {

                    Toast.makeText(context, "选择的对象为空", Toast.LENGTH_SHORT).show();

                } else {
                    if (pop_num.getText().toString().equals("")) {

                        pop_num.setText("1");
                        pop_num.setSelection(1);

                    }
                    try {
                        if (Integer.valueOf(pop_num.getText().toString()) < result.getStock()) {

                            if (result.getPurchase_quantity() != 0 && Integer.valueOf(pop_num.getText()
                                    .toString()) >= result.getLimit()) {

                                Toast.makeText(context, "您最多只能购买这么多了", Toast.LENGTH_SHORT).show();


                            } else {

                                String num_add = Integer.valueOf(pop_num.getText()
                                        .toString()) + ADDORREDUCE + "";
                                pop_num.setText(num_add);

                                if (!TextUtils.isEmpty(num_add)) {

                                    pop_num.setSelection(num_add.length());

                                }


                            }


                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                break;
            case R.id.pop_reduce:

                if (result == null) {

                    Toast.makeText(context, "选择的对象为空", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        if (pop_num.getText().toString().equals("")) {

                            pop_num.setText("1");
                            pop_num.setSelection(1);

                        }
                        if (!pop_num.getText().toString().equals("1")) {
                            String num_reduce = Integer.valueOf(pop_num.getText()
                                    .toString()) - ADDORREDUCE + "";
                            pop_num.setText(num_reduce);

                            if (!TextUtils.isEmpty(num_reduce)) {

                                pop_num.setSelection(num_reduce.length());

                            }


                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                break;
            // 关闭popwindow
            case R.id.pop_del:
                dissmiss();

                break;

            default:
                break;
        }

    }


    //=========================购买数量变化=====================================
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterTextChanged(Editable s) {


        try {

            ProductSubDetailInfo result = null;

            if (mSubDetailData != null && !mSubDetailData.isEmpty()) {

                for (ProductSubDetailInfo p : mSubDetailData) {

                    if (!TextUtils.isEmpty(mSizeResult) && !TextUtils.isEmpty(mColorResult)) {

                        if (p.getSize_name().equals(mSizeResult) && p.getColor_name().equals(mColorResult)) {

                            result = p;

                        }

                    }
                }

            }

            if (result != null) {

                if (Integer.valueOf(s.toString()) <= 0) {
                    pop_num.setText("1");
                    pop_num.setSelection(1);

                    Toast.makeText(context, "购买数量必须为正数", Toast.LENGTH_SHORT).show();
                } else if (Integer.valueOf(s.toString()) > result.getStock()) {
                    pop_num.setText(result.getStock() + "");

                    if (!TextUtils.isEmpty(result.getStock() + "")) {

                        pop_num.setSelection(result.getStock() + "".length());

                    }

                    Toast.makeText(context, "购买数量不能超过库存", Toast.LENGTH_SHORT).show();
                } else {

                    pop_num.setSelection(s.toString().length());

                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // position是-1的时候，没有选择任何条目
    private class OnSSChkClickEventInch implements SingleSelectCheckBoxs.OnSelectListener {

        @Override
        public void onSelect(int position) {

            if (position != -1) {

                mSizeResult = mInchListStr.get(position);

                ArrayList<String> temp_color = new ArrayList<String>();

                if (mSubDetailData != null && !mSubDetailData.isEmpty()) {

                    for (ProductSubDetailInfo p : mSubDetailData) {

                        if (p.getSize_name().equals(mSizeResult)) {

                            temp_color.add(p.getColor_name());

                        }

                    }


                }

                if (mColorListStr != null && !mColorListStr.isEmpty()) {

                    for (String str : mColorListStr) {

                        sscb_color.setData(str, false);

                        if (temp_color != null && !temp_color.isEmpty()) {


                            for (String canEnable : temp_color) {

                                if (canEnable.equals(str)) {

                                    sscb_color.setData(str, true);

                                }


                            }


                        }

                    }

                }

                if (!TextUtils.isEmpty(mColorResult)) {

                    ProductSubDetailInfo result = null;

                    if (mSubDetailData != null && !mSubDetailData.isEmpty()) {

                        for (ProductSubDetailInfo p : mSubDetailData) {

                            if (p.getSize_name().equals(mSizeResult) && p.getColor_name().equals(mColorResult)) {

                                result = p;

                            }

                        }

                    }

                    getResult2Show(result);

                }


            } else {

                mSizeResult = "";


                if (mColorListStr != null && !mColorListStr.isEmpty()) {

                    for (String str : mColorListStr) {

                        sscb_color.setData(str, true);


                    }

                }

                if (!TextUtils.isEmpty(mColorResult)) {

                    has_choose_tv.setText("请选择尺码");

                } else {

                    has_choose_tv.setText("请选择尺码、颜色");
                }


            }

        }
    }

    private void getResult2Show(ProductSubDetailInfo result) {

        if (result == null) {

            Toast.makeText(context, "选择的对象为空", Toast.LENGTH_SHORT).show();

        } else {
            if (onSelectedCompleteListener != null)
                onSelectedCompleteListener.onComplete(result);


            if (!TextUtils.isEmpty(result.getUnit())) {
                inventory_tv.setText("库存"+ result.getStock()
                        + result.getUnit());
            } else {

                inventory_tv.setText("库存" + result.getStock());

            }

            real_price_tv.setText((mInfo.getItemList().size() > 0) ? "¥" + result.getReal_price() : "¥");

            has_choose_tv.setText("已选择" + "\"" + result.getSize_name() + "\" " + result.getColor_name() + "\"");

            ImageLoader.getInstance().displayImage(result.getItem_pic(), iv_adapter_grid_pic, mOptions, null);

        }
    }


    private class OnSSChkClickEventColor implements SingleSelectCheckBoxs.OnSelectListener {

        @Override
        public void onSelect(int position) {

            if (position != -1) {

                mColorResult = mColorListStr.get(position);

                ArrayList<String> temp_size = new ArrayList<String>();

                if (mSubDetailData != null && !mSubDetailData.isEmpty()) {

                    for (ProductSubDetailInfo p : mSubDetailData) {

                        if (p.getColor_name().equals(mColorResult)) {

                            temp_size.add(p.getSize_name());

                        }

                    }


                }

                if (mInchListStr != null && !mInchListStr.isEmpty()) {

                    for (String str : mInchListStr) {

                        sscb_inch.setData(str, false);

                        if (temp_size != null && !temp_size.isEmpty()) {

                            for (String canEnable : temp_size) {

                                if (canEnable.equals(str)) {

                                    sscb_inch.setData(str, true);

                                }


                            }


                        }

                    }

                }


                if (!TextUtils.isEmpty(mSizeResult)) {

                    ProductSubDetailInfo result = null;

                    if (mSubDetailData != null && !mSubDetailData.isEmpty()) {

                        for (ProductSubDetailInfo p : mSubDetailData) {

                            if (p.getSize_name().equals(mSizeResult) && p.getColor_name().equals(mColorResult)) {

                                result = p;

                            }

                        }

                    }

                    getResult2Show(result);

                }

            } else {

                mColorResult = "";


                if (mInchListStr != null && !mInchListStr.isEmpty()) {

                    for (String str : mInchListStr) {

                        sscb_inch.setData(str, true);

                    }

                }

                if (!TextUtils.isEmpty(mSizeResult)) {

                    has_choose_tv.setText("请选择颜色");

                } else {

                    has_choose_tv.setText("请选择尺码、颜色");
                }

            }

        }
    }


}
