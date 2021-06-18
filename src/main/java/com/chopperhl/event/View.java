package com.chopperhl.event;

public class View {
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean handle = false;
        if (onTouchEvent(event)) {
            handle = true;
        }
        return handle;
    }

    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public boolean onInterceptTouchEvent() {
        return false;
    }
}
