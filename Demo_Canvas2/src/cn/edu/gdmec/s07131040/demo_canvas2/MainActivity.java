package cn.edu.gdmec.s07131040.demo_canvas2;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
	private List<PointF> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}
	protected class MyView extends View{
		Paint paint = new Paint();

		public MyView(Context context) {
			super(context);
			
			list=new ArrayList<PointF>();
			
			paint.setColor(Color.BLACK);
			paint.setStrokeWidth(5);
			
		}
		@Override
		protected void onDraw(Canvas canvas) {
			for(PointF f:list){
				canvas.drawPoint(f.x,f.y, paint);
			}
		}
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			PointF point = new PointF(event.getX(),event.getY());
			list.add(point);
			invalidate();//通知重绘界面
			
			return true;
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
