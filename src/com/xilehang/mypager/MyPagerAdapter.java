
package com.xilehang.mypager;
import java.util.List;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

 // ������
    public  class  MyPagerAdapter  extends PagerAdapter {
        private List<View> mListViews; // ͼƬ��
        public MyPagerAdapter(){
        }
        public MyPagerAdapter(Activity mActivity,List<View> mListViews){
            this.mListViews=mListViews;
        }
        public int getCount() {
            if (mListViews.size() == 1) {// һ��ͼƬʱ��������
                return mListViews.size();
            }
            return Integer.MAX_VALUE;
        }
        /**
            ����List�е�ͼƬԪ��װ�ص��ؼ���
*/
        public Object instantiateItem(View v, int i) {
            if (((ViewPager) v).getChildCount() == mListViews.size()) {
                ((ViewPager) v)
                        .removeView(mListViews.get(i % mListViews.size()));
            }
            ((ViewPager) v).addView(mListViews.get(i % mListViews.size()), 0);
            return mListViews.get(i % mListViews.size());
        }

        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == (arg1);
        }

        public void destroyItem(ViewGroup view, int i, Object object) {
            view.removeView(mListViews.get(i%mListViews.size()));
        }
        
    }

