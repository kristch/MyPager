package com.xilehang.mypager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.Toast;
//:������ͻ,ֻ��Ҫ���ӿؼ���onTouch������ getParent().requestDisallowInterceptTouchEvent(true)...
public class MainActivity extends Activity {

	 private ChildViewPager myPager; // ͼƬ����
	    private LinearLayout ovalLayout; // Բ������
	    private List<View> listViews; // ͼƬ��
	    
	    private EditText name;
	    private EditText phone;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        myPager = (ChildViewPager) findViewById(R.id.myvp);
	        name =(EditText) findViewById(R.id.name);
	        phone= (EditText) findViewById(R.id.phone);
	        System.out.println(name+"");
	        InitViewPager();
	        myPager.setAdapter(new MyPagerAdapter(this, listViews));
	    }

	    /**
	     * ��ʼ��ͼƬ
	     */
	    private void InitViewPager() {
	        listViews = new ArrayList<View>();
	        int[] imageResId = new int[] { R.drawable.ic_launcher, R.drawable. ic_launcher,
	                R.drawable. ic_launcher, R.drawable.ic_launcher, R.drawable. ic_launcher };
	        for (int i = 0; i < imageResId.length; i++) {
	            ImageView imageView = new ImageView(this);
	            imageView.setImageResource(imageResId[i]);
	            imageView.setScaleType(ScaleType.CENTER_CROP);
	            listViews.add(imageView);
	        }
	    }

	}
