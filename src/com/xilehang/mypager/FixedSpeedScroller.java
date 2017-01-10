package com.xilehang.mypager;
import java.lang.reflect.Field;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.animation.Interpolator;
import android.widget.Scroller;
 /**
  * ͼƬ��������ʱ�������  , �������Ĭ��ʱ��ɲ�������� ,ͨ�����似���ı�ViewPager�Ļ���ʱ��
  *
  */
public class FixedSpeedScroller extends Scroller {  
    private Context context;
    private int mDuration = 500;  
    public FixedSpeedScroller(Context context) {  
        super(context);  
        this.context=context;
    }  
    public FixedSpeedScroller(Context context, Interpolator interpolator) {  
        super(context, interpolator);  
        this.context=context;
    } 
    /**
     *  ���øı�ViewPager�Ļ���ʱ��  
     * @param vp  ViewPager ����
     * @param time  ʱ��
     */
    public void setDuration(ViewPager vp,int time) {
         try {
             Field field = ViewPager.class.getDeclaredField("mScroller");
             field.setAccessible(true);
             this.setmDuration(time);//���÷���ʱ��
             field.set(vp, this);
         } catch (Exception e) {

         }
     } 
    @Override  
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {  
        //System.out.println("startScroll1");
        super.startScroll(startX, startY, dx, dy, mDuration);  
    }  
    @Override  
    public void startScroll(int startX, int startY, int dx, int dy) {  
        //System.out.println("startScroll2");
        super.startScroll(startX, startY, dx, dy, mDuration);  
    }  
    public void setmDuration(int time) {  
        mDuration = time;  
    }  
    public int getmDuration() {  
        return mDuration;  
    }  
}
