package com.chopperhl.event;

public class CustomView extends View {

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("View ---> OnTouch");
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        System.out.println("View ---> Dispatch");
        return super.dispatchTouchEvent(event);
    }
}
