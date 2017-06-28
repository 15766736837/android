package com.lai.behavior_demo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Lai on 2017/6/26.
 */

public class EasyBehavior extends CoordinatorLayout.Behavior<TextView>{
    public EasyBehavior() {
        super();
    }

    public EasyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency.getId() == R.id.behavior_iv;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        child.setX(dependency.getX());
        child.setY(dependency.getY() + dependency.getHeight() + 10);
        return true;
    }
}
