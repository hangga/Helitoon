package com.hangga.helitoon;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class Hero extends ImageView{

	public Hero(Context context) {
		super(context);
		init();
	}
	
	public Hero(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public Hero(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	private void init(){
		this.setScaleType(ScaleType.FIT_CENTER);
		this.setBackgroundResource(R.drawable.anim_hero);
		AnimationDrawable anim = (AnimationDrawable) this.getBackground();
		anim.start();
	}

}
