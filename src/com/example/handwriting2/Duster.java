package com.example.handwriting2;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;
import org.andengine.util.modifier.ease.EaseBounceOut;

import android.content.Intent;

public class Duster extends Sprite
{

	public Duster(float pX, float pY, 
			ITextureRegion pTextureRegion,
			VertexBufferObjectManager pSpriteVertexBufferObject) 
	{
		super(pX, pY, pTextureRegion, pSpriteVertexBufferObject);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	{
		switch (pSceneTouchEvent.getAction()) 
		{
		case TouchEvent.ACTION_DOWN:
 
			createDusterPopUp(0);
			
		break;
		
		case TouchEvent.ACTION_UP:

		break;
		
		}

		return true;
	}
	
	public static void createDusterPopUp(int upDown)
	{
		MainActivity.popUpDuster = upDown;
		Path createPopUpPath = null;
		
		//Down to up
		if(upDown == 0)
		{
			MainActivity.dusterDisabler = 1;
			MainActivity.duster.setY(-400);
			
			finishDuster();
		}
		//Up to down
		else if(upDown == 1) 
		{ 
			createPopUpPath = new Path(2)
			.to(MainActivity.CAMERA_WIDTH/2+70, -400).to(MainActivity.CAMERA_WIDTH/2 + 100, 200);
			MainActivity.dusterDisabler = 0;
		
		MainActivity.duster.registerEntityModifier(new PathModifier((float)4.0, createPopUpPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{

			}
			
			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{

			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{

			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{ 
				//play the sound for first time only
				Debug.d("sound:"+MainActivity.soundPlayCount);
				if(MainActivity.soundPlayCount == 2)
				{
					MainActivity.soundPlayCount++;
					//play the sound
					MainActivity.audioPlay = true;
					MainActivity.playAudio(R.raw.three);
				}
			}
		} , EaseBounceOut.getInstance()));
		}
	}

	//Sliding screen
	public static void finishDuster() 
	{

		MainActivity.slidingScreen = new Sprite(0, -800, MainActivity.mSlidingScreenTextureRegion, MainActivity.vertexBufferObjectManager);
		MainActivity.mScene.attachChild(MainActivity.slidingScreen);
		
		Path finishingPath = new Path(2).to(-1200, 0).to(MainActivity.CAMERA_WIDTH  + 10, 0);

		MainActivity.slidingScreen.registerEntityModifier(new PathModifier((float) 1.8, finishingPath, null, new IPathModifierListener()
				{
					@Override
					public void onPathStarted(final PathModifier pPathModifier,final IEntity pEntity) 
					{
						//Restarting the activity
						MainActivity.mScene.registerUpdateHandler(new TimerHandler((float)1, new ITimerCallback() {
							
							@Override
							public void onTimePassed(TimerHandler pTimerHandler)
							{
								// TODO Auto-generated method stub
								MainActivity.mScene.detachChild(MainActivity.pieceChalk);
								MainActivity.mScene.detachSelf();
								
								//Resetting the stars
								MainActivity.aCounter=0;
								MainActivity.star[17].setVisible(false);
								MainActivity.num = 0;			
								
								MainActivity.mScene.unregisterUpdateHandler(MainActivity.timer1);
								MainActivity.MainActivityInstace.finish();
								MainActivity.MainActivityInstace.startActivity(new Intent(MainActivity.MainActivityInstace.getBaseContext(),
										MainActivity.class));
							}
						}));
					}
 
					@Override
					public void onPathWaypointStarted(final PathModifier pPathModifier,final IEntity pEntity, final int pWaypointIndex) 
					{
						
					}

					@Override
					public void onPathWaypointFinished(final PathModifier pPathModifier,final IEntity pEntity, final int pWaypointIndex) 
					{

					}

					@Override
					public void onPathFinished(final PathModifier pPathModifier,final IEntity pEntity)
					{
						
					}
				}));
	}
}
