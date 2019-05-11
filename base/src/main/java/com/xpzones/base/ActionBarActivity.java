package com.xpzones.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xpzones.base.base.R;
import com.xpzones.widget.ActionBar;

public abstract class ActionBarActivity extends BaseActivity {

    //    @BindView(R2.id.actionbar)
    protected ActionBar actionBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        actionBar = findViewById(R.id.actionbar);
    }

    protected void setTitleText(String title) {
        if (actionBar != null) {
            actionBar.setCenterText(title);
        }
    }

    protected void setTitleText(int title) {
        if (actionBar != null) {
            actionBar.setCenterText(getString(title));
        }
    }
    protected boolean isActionBar() {
        return true;
    }
}
