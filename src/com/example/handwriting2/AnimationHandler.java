package com.example.handwriting2;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;

public class AnimationHandler 
{
	static int i = 0;
	
//	public static void AnimationStart()
//	{
//		if(MainActivity.drawLine == 1)
//		{
//			animatedChalk(MainActivity.rectangle1[1].getX(), MainActivity.rectangle1[1].getY(),
//					MainActivity.rectangle1[2].getX(), MainActivity.rectangle1[2].getY(), 
//					MainActivity.rectangle1[3].getX(), MainActivity.rectangle1[3].getY(), 
//					MainActivity.rectangle1[4].getX(), MainActivity.rectangle1[4].getY(), 
//					MainActivity.rectangle1[5].getX(), MainActivity.rectangle1[5].getY(),
//					MainActivity.rectangle1[6].getX(), MainActivity.rectangle1[6].getY(),
//					MainActivity.rectangle1[7].getX(), MainActivity.rectangle1[7].getY(),
//					MainActivity.rectangle1[8].getX(), MainActivity.rectangle1[8].getY(),
//					MainActivity.rectangle1[8].getX(), MainActivity.rectangle1[8].getY(),
//					MainActivity.rectangle1[8].getX(), MainActivity.rectangle1[8].getY());
//		}
//	    else if(MainActivity.drawLine == 2)
//		{
//			animatedChalk(MainActivity.rectangle1[9].getX(), MainActivity.rectangle1[9].getY(),
//					MainActivity.rectangle1[10].getX(), MainActivity.rectangle1[10].getY(), 
//					MainActivity.rectangle1[11].getX(), MainActivity.rectangle1[11].getY(), 
//					MainActivity.rectangle1[12].getX(), MainActivity.rectangle1[12].getY(), 
//					MainActivity.rectangle1[13].getX(), MainActivity.rectangle1[13].getY(),
//					MainActivity.rectangle1[14].getX(), MainActivity.rectangle1[14].getY(),
//					MainActivity.rectangle1[15].getX(), MainActivity.rectangle1[15].getY(),
//					MainActivity.rectangle1[16].getX(), MainActivity.rectangle1[16].getY(),
//					MainActivity.rectangle1[17].getX(), MainActivity.rectangle1[17].getY(),
//					MainActivity.rectangle1[17].getX(), MainActivity.rectangle1[17].getY());
//		}
//		else if(MainActivity.drawLine == 3)
//		{
//			animatedChalk(MainActivity.rectangle1[17].getX()+10, MainActivity.rectangle1[17].getY(),
//					MainActivity.rectangle1[18].getX()+10, MainActivity.rectangle1[18].getY(), 
//					MainActivity.rectangle1[19].getX()+10, MainActivity.rectangle1[19].getY(), 
//					MainActivity.rectangle1[20].getX()+10, MainActivity.rectangle1[20].getY(), 
//					MainActivity.rectangle1[21].getX()+10, MainActivity.rectangle1[21].getY(),
//					MainActivity.rectangle1[21].getX()+10, MainActivity.rectangle1[21].getY(),
//					MainActivity.rectangle1[21].getX()+10, MainActivity.rectangle1[21].getY(),
//					MainActivity.rectangle1[21].getX()+10, MainActivity.rectangle1[21].getY(),
//					MainActivity.rectangle1[21].getX()+10, MainActivity.rectangle1[21].getY(),
//					MainActivity.rectangle1[21].getX()+10, MainActivity.rectangle1[21].getY());
//		}
//		else if(MainActivity.drawLine == 4)
//		{
//			animatedChalk(MainActivity.rectangle1[20].getX()+5, MainActivity.rectangle1[20].getY()+10,
//					MainActivity.rectangle1[21].getX(), MainActivity.rectangle1[21].getY()+15, 
//					MainActivity.rectangle1[22].getX(), MainActivity.rectangle1[22].getY()+20, 
//					MainActivity.rectangle1[23].getX(), MainActivity.rectangle1[23].getY()+20, 
//					MainActivity.rectangle1[24].getX(), MainActivity.rectangle1[24].getY()+20,
//					MainActivity.rectangle1[24].getX(), MainActivity.rectangle1[24].getY()+20, 
//					MainActivity.rectangle1[24].getX(), MainActivity.rectangle1[24].getY()+20, 
//					MainActivity.rectangle1[24].getX(), MainActivity.rectangle1[24].getY()+20, 
//					MainActivity.rectangle1[24].getX(), MainActivity.rectangle1[24].getY()+20, 
//					MainActivity.rectangle1[24].getX(), MainActivity.rectangle1[24].getY()+20);
//		}
//		else if(MainActivity.drawLine == 5)
//		{
//			animatedChalk(MainActivity.rectangle1[24].getX(), MainActivity.rectangle1[24].getY()+20,
//					MainActivity.rectangle1[25].getX(), MainActivity.rectangle1[25].getY()+20, 
//					MainActivity.rectangle1[26].getX(), MainActivity.rectangle1[26].getY()+20, 
//					MainActivity.rectangle1[27].getX(), MainActivity.rectangle1[27].getY()+20, 
//					MainActivity.rectangle1[28].getX(), MainActivity.rectangle1[28].getY()+20,
//					MainActivity.rectangle1[28].getX(), MainActivity.rectangle1[28].getY()+20,
//					MainActivity.rectangle1[28].getX(), MainActivity.rectangle1[28].getY()+20,
//					MainActivity.rectangle1[28].getX(), MainActivity.rectangle1[28].getY()+20,
//					MainActivity.rectangle1[28].getX(), MainActivity.rectangle1[28].getY()+20,
//					MainActivity.rectangle1[28].getX(), MainActivity.rectangle1[28].getY()+20);
//		}
//		else if(MainActivity.drawLine == 6)
//		{
//			animatedChalk(MainActivity.rectangle1[29].getX(), MainActivity.rectangle1[29].getY()+20,
//					MainActivity.rectangle1[30].getX(), MainActivity.rectangle1[30].getY()+20, 
//					MainActivity.rectangle1[31].getX(), MainActivity.rectangle1[31].getY()+20, 
//					MainActivity.rectangle1[32].getX(), MainActivity.rectangle1[32].getY()+20, 
//					MainActivity.rectangle1[32].getX(), MainActivity.rectangle1[32].getY()+20,
//					MainActivity.rectangle1[32].getX(), MainActivity.rectangle1[32].getY()+20,
//					MainActivity.rectangle1[32].getX(), MainActivity.rectangle1[32].getY()+20,
//					MainActivity.rectangle1[32].getX(), MainActivity.rectangle1[32].getY()+20,
//					MainActivity.rectangle1[32].getX(), MainActivity.rectangle1[32].getY()+20,
//					MainActivity.rectangle1[32].getX(), MainActivity.rectangle1[32].getY()+20);
//		}
//		else if(MainActivity.drawLine == 7)
//		{
//			animatedChalk(MainActivity.rectangle1[32].getX(), MainActivity.rectangle1[32].getY()+20,
//					MainActivity.rectangle1[33].getX(), MainActivity.rectangle1[33].getY()+20, 
//					MainActivity.rectangle1[34].getX(), MainActivity.rectangle1[34].getY()+20, 
//					MainActivity.rectangle1[35].getX(), MainActivity.rectangle1[35].getY()+20, 
//					MainActivity.rectangle1[36].getX(), MainActivity.rectangle1[36].getY()+20,
//					MainActivity.rectangle1[37].getX(), MainActivity.rectangle1[37].getY()+20,
//					MainActivity.rectangle1[38].getX(), MainActivity.rectangle1[38].getY()+20,
//					MainActivity.rectangle1[39].getX(), MainActivity.rectangle1[39].getY()+20,
//					MainActivity.rectangle1[39].getX(), MainActivity.rectangle1[39].getY()+20,
//					MainActivity.rectangle1[39].getX(), MainActivity.rectangle1[39].getY()+20);
//		}
//	}
	
	public static void animatedChalk(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4,
			float x5, float y5, float x6, float y6, float x7, float y7, float x8, float y8,float x9, float y9,
			float x10, float y10, float x11, float y11, float x12, float y12, float x13,float y13, float x14, float y14,
			float x15, float y15, float x16, float y16)
	{
		Path chalkPath = null;
		
		chalkPath = new Path(16)
		.to(x1 - 50, y1 - 20).to(x2 - 50, y2 - 20).to(x3 - 50, y3 - 20).to(x4 - 50, y4 - 20)
		.to(x5 - 50, y5 - 20).to(x6 - 50, y6 - 20).to(x7 - 50, y7 - 20).to(x8 - 50, y8 - 20)
		.to(x9 - 50, y9 - 20).to(x10 - 50, y10 - 20).to(x11 - 50, y11 - 20).to(x12 - 50, y12 - 20)
		.to(x13 - 50, y13 - 20).to(x14 - 50, y14 - 20).to(x15 - 50, y15 - 20).to(x16 - 50, y16 - 20)
		;
		
		MainActivity.handTutorial.registerEntityModifier(new PathModifier((float)3.5, chalkPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				//Debug.d("onPathStarted"); 
				//MainActivity.animStart = 1;
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
				MainActivity.drawLine = 9;
				MainActivity.animStart = 0;
				
				MainActivity.soundPlayCount++;
				if(MainActivity.soundPlayCount == 1)
				{
					//play the sound
					MainActivity.soundPlayCount++;
					MainActivity.audioPlay = true;
					MainActivity.playAudio(R.raw.two);
				}
				
				MainActivity.handTutorial.setVisible(false);
				
				for(int j = 0; j<= MainActivity.counter; j++)
				{
					if(MainActivity.tutorialWhiteChalk[j]!= null)
					{
						for(int i=1; i<=MainActivity.counter; i++)
						{
							MainActivity.tutorialWhiteChalk[i].setVisible(false);
							MainActivity.tutorialWhiteChalk[i].setX(MainActivity.CAMERA_WIDTH + 300);
						}
					}
				}
				
				MainActivity.counter = 0;
				MainActivity.handTutorial.setX(MainActivity.rectangle1[1].getX());
			}
		}));
	}
	
	public static void animatedChalk1(float x1, float y1, float x2, float y2)
	{
		Path chalkPath = null;
		
		chalkPath = new Path(2)
		.to(x1 - 50, y1 - 20).to(x2 - 50, y2 - 20);
		
		MainActivity.handTutorial.setVisible(true);
		
		MainActivity.handTutorial.registerEntityModifier(new PathModifier((float)1.0, chalkPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				//Debug.d("onPathStarted"); 
				MainActivity.animStart = 1;
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
				MainActivity.drawLine = 9;
				//MainActivity.animStart = 0;
				
				
//				for(int i=1; i<=MainActivity.counter; i++)
//				{
//					MainActivity.tutorialWhiteChalk[i].setVisible(false);
//					MainActivity.tutorialWhiteChalk[i].setX(MainActivity.CAMERA_WIDTH + 300);
//				}
//				MainActivity.counter = 0;
//				MainActivity.handTutorial.setX(MainActivity.rectangle1[1].getX());
				
				AnimationHandler.animatedChalk(
						MainActivity.rectangle1[9].getX(), MainActivity.rectangle1[9].getY()+20, 
						MainActivity.rectangle1[17].getX()+5, MainActivity.rectangle1[17].getY()+10,
						MainActivity.rectangle1[21].getX()+35, MainActivity.rectangle1[21].getY()+15,
						MainActivity.rectangle1[24].getX()+20, MainActivity.rectangle1[24].getY()+80, 
						MainActivity.rectangle1[28].getX()-80, MainActivity.rectangle1[28].getY()+60,
						MainActivity.rectangle1[30].getX()-100, MainActivity.rectangle1[30].getY()-15, 
						MainActivity.rectangle1[31].getX()-70, MainActivity.rectangle1[31].getY()-30, 
						MainActivity.rectangle1[32].getX()+5, MainActivity.rectangle1[32].getY()+40, 
						MainActivity.rectangle1[32].getX()+5, MainActivity.rectangle1[32].getY()+60, 
						MainActivity.rectangle1[32].getX()+5, MainActivity.rectangle1[32].getY()+20, 
						MainActivity.rectangle1[32].getX()+5, MainActivity.rectangle1[32].getY()+20, 
						MainActivity.rectangle1[32].getX()+5, MainActivity.rectangle1[32].getY()+20, 
						MainActivity.rectangle1[32].getX()+5, MainActivity.rectangle1[32].getY()+20, 
						MainActivity.rectangle1[32].getX()+5, MainActivity.rectangle1[32].getY()+20, 
						MainActivity.rectangle1[32].getX()+5, MainActivity.rectangle1[32].getY()+20,
						MainActivity.rectangle1[39].getX()+5, MainActivity.rectangle1[39].getY()+20);
			}
		}));
	}
}
