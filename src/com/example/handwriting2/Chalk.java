package com.example.handwriting2;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class Chalk extends Sprite
{
	public Chalk(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager VertexBufferObject)
	{
		super(pX, pY, pTextureRegion, VertexBufferObject);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	{
		switch (pSceneTouchEvent.getAction()) 
		{
		case TouchEvent.ACTION_DOWN:
			
			break;
		
		case TouchEvent.ACTION_UP:

			break;
		
		case TouchEvent.ACTION_MOVE:

			//this.setPosition(pSceneTouchEvent.getX() - this.getWidth()/2, pSceneTouchEvent.getY() - this.getHeight()/2);
			break;
		}

		return true;
	} 
	
	//Chalk Paths
	public static void chalkPath(float x, float y)
	{
		final Path chalkPath = new Path(2).to(MainActivity.pieceChalk.getX(), MainActivity.pieceChalk.getY())
				.to(x - 50, y - 90);
		
		MainActivity.pieceChalk.registerEntityModifier(new PathModifier((float)0.4, chalkPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				//Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				//Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				//Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				
			}
		}));
	}
}
