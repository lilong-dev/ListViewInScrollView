package com.admin.scrollview_listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Created by admin on 2017/2/28.
 */

public class MyScrollView extends ScrollView {
    private ListView mListView;
    int nowY;
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setListView(ListView listView){
        this.mListView = listView;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int y = (int) ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:{
                nowY = y;
                intercepted = super.onInterceptTouchEvent(ev);
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                if(isTop() && y > nowY){
                    intercepted = true;
                }else if(isBottom() && y < nowY){
                    intercepted = true;
                }else{
                    intercepted = false;
                }
                break;
            }
            case MotionEvent.ACTION_UP:{
                intercepted = false;
                break;
            }
            default:break;

        }
        return intercepted;
    }

    public boolean isBottom() {
        boolean result=false;
        if (mListView.getLastVisiblePosition() == (mListView.getCount() - 1)) {
            final View bottomChildView = mListView.getChildAt(mListView.getLastVisiblePosition() - mListView.getFirstVisiblePosition());
            result= (mListView.getHeight()>=bottomChildView.getBottom());
        };
        return  result;
    }

    public boolean isTop() {
        boolean result=false;
        if(mListView.getFirstVisiblePosition()==0){
            final View topChildView = mListView.getChildAt(0);
            result=topChildView.getTop()==0;
        }
        return result ;
    }
}
