package com.chopperhl.event;

public class CustomVIewGroup extends ViewGroup {
    private String name;

    public CustomVIewGroup(String name) {
        this.name = name;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("Group:" + name + " ---> OnTouch");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        System.out.println("Group:" + name + " ---> Dispatch");
        return super.dispatchTouchEvent(event);
    }
}
