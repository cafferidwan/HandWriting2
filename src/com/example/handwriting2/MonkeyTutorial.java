package com.example.handwriting2;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;
import org.andengine.util.modifier.ease.EaseBounceOut;

public class MonkeyTutorial extends AnimatedSprite
{

	public MonkeyTutorial(float pX, float pY, ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pTiledSpriteVertexBufferObject) 
	{
		super(pX, pY,  pTiledTextureRegion, pTiledSpriteVertexBufferObject);
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	{
		switch (pSceneTouchEvent.getAction()) 
		{
		case TouchEvent.ACTION_DOWN:
			if(MainActivity.animStart == 0 && MainActivity.drawingDisabler == 0)
			{
				AnimationHandler.animatedChalk1(MainActivity.rectangle1[1].getX(), MainActivity.rectangle1[1].getY()+20, 
						MainActivity.rectangle1[8].getX()+20, MainActivity.rectangle1[8].getY()+20);
			}
		break;
		
		case TouchEvent.ACTION_UP:

		break;
		
		}

		return true;
	}
	public static void monkeyTutorialstart()
	{
		//Path createMonkeyPath = null;
		
		Path createMonkeyPath = new Path(2)
		.to(100, -600).to(20, 3);
		
		MainActivity.monkeyTutorial.registerEntityModifier(new PathModifier((float)4.3, createMonkeyPath, null, new IPathModifierListener()
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
				MainActivity.tutorialCount++;
				Debug.d("Tutorial count:"+MainActivity.tutorialCount);
				if(MainActivity.animStart == 0 && MainActivity.drawingDisabler == 0 && MainActivity.tutorialCount == 1)
				{
					//animStart = 1;
					
					//play the sound
					MainActivity.audioPlay = true;
					MainActivity.playAudio(R.raw.one);
					//play the animation after delay
					MainActivity.mScene.registerUpdateHandler(new TimerHandler(6, new ITimerCallback() {
						
						@Override
						public void onTimePassed(TimerHandler pTimerHandler) 
						{
							// TODO Auto-generated method stub
							AnimationHandler.animatedChalk1(MainActivity.rectangle1[1].getX(), MainActivity.rectangle1[1].getY()+20, 
									MainActivity.rectangle1[8].getX()+20, MainActivity.rectangle1[8].getY()+20);
						}
					}));
					
				}
			}
		} , EaseBounceOut.getInstance()));
	}
}
