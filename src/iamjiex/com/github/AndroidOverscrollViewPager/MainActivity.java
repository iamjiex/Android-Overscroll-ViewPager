package iamjiex.com.github.AndroidOverscrollViewPager;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private OverscrollViewPager mOverscrollViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mOverscrollViewPager = (OverscrollViewPager) findViewById(R.id.overscroll_viewpager);
		mOverscrollViewPager.getOverscrollView().setAdapter(new SamplePagerAdapter());
		mOverscrollViewPager.getOverscrollView().setPageMargin(40);
		mOverscrollViewPager.getOverscrollView().setPageMarginDrawable(android.R.color.black);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	static class SamplePagerAdapter extends PagerAdapter {

		private static int[] sDrawables = {
			R.drawable.p01, R.drawable.p02, R.drawable.p03, R.drawable.p04,
			R.drawable.p05, R.drawable.p06, R.drawable.p07, R.drawable.p08,
			R.drawable.p09, R.drawable.p10, R.drawable.p11 };

		@Override
		public int getCount() {
			return sDrawables.length;
		}

		@Override
		public View instantiateItem(ViewGroup container, int position) {
			ImageView imageView = new ImageView(container.getContext());
			imageView.setImageResource(sDrawables[position]);

			container.addView(imageView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

			return imageView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}
	}

}
