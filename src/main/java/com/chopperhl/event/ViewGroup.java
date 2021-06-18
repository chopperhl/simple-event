package com.chopperhl.event;

import java.util.LinkedList;

public class ViewGroup extends View {
    private LinkedList<View> children = new LinkedList<>();
    private TouchTarget mFirstTouchTarget = null;
    private boolean disallowedIntercept = false;

    public void addChild(View view) {
        children.add(view);
    }

    public void setDisallowedIntercept(boolean disallowedIntercept) {
        this.disallowedIntercept = disallowedIntercept;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean handle = false;
        boolean hasDispatch = false;
        boolean intercept = false;

        if (!disallowedIntercept) {
            intercept = onInterceptTouchEvent();
        }
        if (!intercept) {
            for (View v : children) {
                if (dispatchTransformedTouchEvent(event, v)) {
                    //命中多个时，用next节点以链表存储
                    //child节点表示子节点表示子view的层级关系，next节点表示同时命中多个view时链表存储集合-
                    mFirstTouchTarget = new TouchTarget();
                    mFirstTouchTarget.child = v;
                    hasDispatch = true;
                }
            }
        }
        if (mFirstTouchTarget == null) {
            handle = dispatchTransformedTouchEvent(event, null);
        } else {
            if (hasDispatch) {
                handle = true;
            } else {
                if (dispatchTransformedTouchEvent(event, mFirstTouchTarget.child)) {
                    handle = true;
                }
            }
        }
        return handle;
    }

    private boolean dispatchTransformedTouchEvent(MotionEvent event, View child) {
        boolean handle = false;
        if (checkInBound(event, child)) {
            if (child == null) {
                handle = super.dispatchTouchEvent(event);
            } else {
                handle = child.dispatchTouchEvent(event);
            }
        }
        return handle;
    }

    /**
     * 判断落点是否命中
     *
     * @param event
     * @param view
     * @return
     */
    private boolean checkInBound(MotionEvent event, View view) {
        return true;
    }

}
