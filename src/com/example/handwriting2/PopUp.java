package com.example.handwriting2;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.modifier.ease.EaseBounceOut;

public class PopUp extends Sprite
{
	
	static IEntity en;
	
	public PopUp(int i, int j, ITextureRegion mShowScreenCaptureRegion,
			VertexBufferObjectManager vertexBufferObjectManager) 
	{
		super(i, j, mShowScreenCaptureRegion, vertexBufferObjectManager);
		// TODO Auto-generated constructor stub
		
	}

		@Override
		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
		{
			switch (pSceneTouchEvent.getAction()) 
			{
			case TouchEvent.ACTION_DOWN:

				if(MainActivity.drawingDisabler == 0 && MainActivity.animStart == 0 
				&& !MainActivity.mediaPlayer.isPlaying())
				{ 
					createPopUp(0);
				}
				
			break;
			
			case TouchEvent.ACTION_UP:

			break;
			
			}
 
			return true;
		}

	public static void createPopUp(int upDown)
	{

		MainActivity.popUpVal = upDown;
		Path createPopUpPath = null;
		
		//Down to up
		if(upDown == 0)
		{
			en = new Entity(100, MainActivity.CAMERA_HEIGHT+100);
			MainActivity.mScene.attachChild(en);
			
			createPopUpPath = new Path(2)
			.to(100, MainActivity.CAMERA_HEIGHT+500).to(100, 100);
			MainActivity.drawingDisabler = 1;
		}
		//Up to down
		else if(upDown == 1)
		{ 
			createPopUpPath = new Path(2)
			.to(100, 100).to(100, MainActivity.CAMERA_HEIGHT+500);
			MainActivity.drawingDisabler = 0;
		}
		
		MainActivity.createPopUp = new Sprite(-500, -300, MainActivity.mCreatePopUpRegion,
				MainActivity.vertexBufferObjectManager);
		MainActivity.createPopUp.setScale((float) 0.5);
		en.attachChild(MainActivity.createPopUp);
		 
		MainActivity.board = new Sprite(180, -200, MainActivity.mPopUpBlackBoardTextureRegion,
				MainActivity.vertexBufferObjectManager);
		MainActivity.board.setScale((float) 0.6);
		en.attachChild(MainActivity.board); 
		
		MainActivity.correctLetter = new Sprite(340, -70, MainActivity.mMoOutLineTextureRegion,
				MainActivity.vertexBufferObjectManager);
		MainActivity.correctLetter.setScale((float) 0.6);
		en.attachChild(MainActivity.correctLetter); 
		
		//If screen shot taken, then show screen shot image
		if(MainActivity.changeTexture == 1)
		{
			MainActivity.board = new Sprite(-180, -200, MainActivity.mPopUpBlackBoardTextureRegion,
					MainActivity.vertexBufferObjectManager);
			MainActivity.board.setScale((float) 0.6);
			en.attachChild(MainActivity.board); 
			
			MainActivity.drawnPicture = new Sprite(-40, -68, MainActivity.textureRegion,
				MainActivity.vertexBufferObjectManager); 
			MainActivity.drawnPicture.setScale((float) 0.6);
			en.attachChild(MainActivity.drawnPicture);
		}
		//If no screen shot taken, then show normal image
		else if(MainActivity.changeTexture == 0)
		{
			MainActivity.board = new Sprite(-180, -200, MainActivity.mPopUpBlackBoardTextureRegion,
					MainActivity.vertexBufferObjectManager);
			MainActivity.board.setScale((float) 0.6);
			en.attachChild(MainActivity.board); 
		}
			
		MainActivity.cross = new Sprite(530, -150, MainActivity.mCrossRegion, MainActivity.vertexBufferObjectManager)
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
				case TouchEvent.ACTION_DOWN:
					
					createPopUp(1);
					
				break;
				
				case TouchEvent.ACTION_UP:

				break;
				
				}

				return true;
			}
		};
		MainActivity.mScene.registerTouchArea(MainActivity.cross);
		MainActivity.cross.setScale((float) 0.3);
		en.attachChild(MainActivity.cross);

		en.registerEntityModifier(new PathModifier((float)1.3, createPopUpPath, null, new IPathModifierListener()
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
				if(MainActivity.soundPlayCount == 3)
				{
					MainActivity.soundPlayCount++;
					//play the sound
					MainActivity.audioPlay = true;
					MainActivity.playAudio(R.raw.four);
				}
				else if(MainActivity.soundPlayCount == 4)
				{
					MainActivity.soundPlayCount++;
					//play the sound
					MainActivity.audioPlay = true;
					MainActivity.playAudio(R.raw.five);
				}
				
			}
		} , EaseBounceOut.getInstance()));
	}
}
