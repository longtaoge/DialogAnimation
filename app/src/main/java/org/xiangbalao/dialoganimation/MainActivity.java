package org.xiangbalao.dialoganimation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener
{
    
    private Button button1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        
    }
    
    @Override
    public void onClick(View v)
    {
        
        MyDialog myDialog = new MyDialog(this);
        myDialog.getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        myDialog.show();
        
    }
    
    public class MyDialog extends AlertDialog
    {

        
        public MyDialog(Context context)
        {
            super(context);
            setCanceledOnTouchOutside(true);
            
            Window win = getWindow();
            win.requestFeature(Window.FEATURE_NO_TITLE);
            WindowManager.LayoutParams wAttrs = win.getAttributes();
            configWindow(win, wAttrs);
        }
        
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            Context ctxt = getContext();
            
            setContentView(R.layout.popwindow_verfication_image1);
        }
        
        private void configWindow(Window win, WindowManager.LayoutParams wAttrs)
        {
            
            wAttrs.gravity = Gravity.RIGHT;
            
        }
    }
    
}
