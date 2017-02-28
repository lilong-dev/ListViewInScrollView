package com.admin.scrollview_listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Created by admin on 2017/2/28.
 */

public class MyListView extends ListView {
    private int nowY;
    private int lastX,lastY;
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

   @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int y = (int) ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                nowY = y;
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                if(isTop() && y > nowY){
                    getParent().requestDisallowInterceptTouchEvent(false);
                }else if(isBottom() && y < nowY){
                    getParent().requestDisallowInterceptTouchEvent(false);
                }else{
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean isBottom() {
        boolean result=false;
        if (getLastVisiblePosition() == (getCount() - 1)) {
            final View bottomChildView = getChildAt(getLastVisiblePosition() - getFirstVisiblePosition());
            result= (getHeight()>=bottomChildView.getBottom());
        };
        return  result;
    }

    public boolean isTop() {
        boolean result=false;
        if(getFirstVisiblePosition()==0){
            final View topChildView = getChildAt(0);
            result=topChildView.getTop()==0;
        }
        return result ;
    }
}
