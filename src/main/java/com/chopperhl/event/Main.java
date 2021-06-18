package com.chopperhl.event;

public class Main {


    public static void main(String[] args) {
        CustomVIewGroup root = new CustomVIewGroup("root") {
            @Override
            public boolean onInterceptTouchEvent() {
                return false;
            }
        };

        CustomVIewGroup viewGroup = new CustomVIewGroup("second");
        viewGroup.addChild(new CustomView());
        root.addChild(viewGroup);
        root.dispatchTouchEvent(new MotionEvent());
    }
}
