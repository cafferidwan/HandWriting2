package com.example.handwriting2;

import java.io.Serializable;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.ScreenCapture;
import org.andengine.entity.util.ScreenCapture.IScreenCaptureCallback;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.FileUtils;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.view.Display;

public class MainActivity extends SimpleBaseGameActivity implements IOnSceneTouchListener
{
	static int CAMERA_WIDTH;
	static int CAMERA_HEIGHT; 
	public Camera mCamera;   
	public static Scene mScene;
	public ScreenCapture screenCapture;

	public static ITextureRegion 
			mMoOutLineTextureRegion, mPopUpBlackBoardTextureRegion,
			mShowScreenCaptureRegion, mCreatePopUpRegion,
			mCorrectLetterRegion, mHandTutorialTextureRegion,
			mCrossRegion;
	public static ITextureRegion mWhiteChalkTextureRegion, mStarTextureRegion;
	public static ITextureRegion mbackGroundTextureRegion, mDusterTextureRegion, 
			mbackGround2TextureRegion, mSlidingScreenTextureRegion;
	
	private BuildableBitmapTextureAtlas mAnimatedBitmapTextureAtlas;
	public TiledTextureRegion mMonkeyTextureRegion, mBlackBoardTextureRegion;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasPieceChalk, mBitmapTextureAtlasBlackBoard,
									 mBitmapTextureAtlasMoOutLine, mBitmapTextureAtlasBackGround,
									 mBitmapTextureAtlasWhiteChalk, mBitmapTextureAtlasStar,
									 mBitmapTextureAtlasBookIcon, mBitmapTextureAtlasHandWirtingBook,
									 mBitmapTextureAtlasBoard, mBitmapTextureAtlasHandCross, 
									 mBitmapTextureAtlasDuster, mBitmapTextureAtlasMonkeyBrush,
									 mBitmapTextureAtlasHandTutorial;
	
	public static TiledTextureRegion mPieceChalkTextureRegion;

	public static Sprite backGround, blackBoard, moOutLine, moExample, tutorial, slidingScreen,
						 handTutorial;
	public static Sprite whiteChalk, createPopUp, correctLetter, drawnPicture, cross, board;
	public static PopUp showScreen;
	public static Chalk pieceChalk; 
	public static Duster duster;
	public static Sprite tutorialWhiteChalk[] =new Sprite[3000];
	
	public static MonkeyTutorial monkeyTutorial;

	public static MainActivity MainActivityInstace;
	public static VertexBufferObjectManager vertexBufferObjectManager;

	public static int Flag;
	public static TimerHandler timer1;
	
	public static Rectangle rectangle1[] = new Rectangle[500];
	public static int Flag1[] = new int[500];
	public static Sprite star [] = new Sprite[500];

	public static float touchPositionX;
	public static float touchPositionY;
	public static MainActivity getSharedInstances() 
	{
		return MainActivityInstace;
	}
	
	public static int touch, drawLine = 0;
	public static float moOutLineX, moOutLineY, width, thick;
	public static boolean reveal, screenShot = false;
	static Boolean audioPlay = false;
	static MediaPlayer mediaPlayer = new MediaPlayer();

	//Screen Shot texture
	static TextureRegion textureRegion;
	static BitmapTextureAtlas texture;
	static BitmapTextureAtlasSource source;
	static int changeTexture = 0;
	
	//Stars variables
	public static int num = 0, aCounter = 0;
	//Tutorial variables
	static int animStart = 0 , counter = 0 ;
	
	//Popup window variables
	public static int popUpVal = 0, drawingDisabler = 0;
	
	//Popup duster value
	public static int popUpDuster = 0, dusterDisabler = 0;
	
	//Tutorial Count
	public static int tutorialCount, soundPlayCount;
	
	Rectangle rect;
	
	//Outline structure serialize
	public static int rectangle1Serialze, a1 ;
	
	@Override
	public EngineOptions onCreateEngineOptions() 
	{
		// TODO Auto-generated method stub
		
		//Initializing and clearing at every beginning of the game
		Flag1[1] = 1;
		Flag = 1;
		
		for(int i=2; i<40; i++)
		{
			Flag1[i] = 0;
		}
		source = null;
		//texture.clearTextureAtlasSources();
		texture = null;
		changeTexture = 0;
				
		MainActivityInstace = this;
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_HEIGHT = display.getHeight();
		CAMERA_WIDTH = display.getWidth();

		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	}

	@Override
	protected void onCreateResources() 
	{
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory
				.setAssetBasePath("HandWritingGfx/");
		
		//Loading bitmaps
		mBitmapTextureAtlasBackGround = new BitmapTextureAtlas(this.getTextureManager(), 1600, 864, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasPieceChalk = new BitmapTextureAtlas(this.getTextureManager(), 100, 100, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasBlackBoard = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasMoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 254, 262, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasWhiteChalk = new BitmapTextureAtlas(this.getTextureManager(), 50, 50, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasStar = new BitmapTextureAtlas(this.getTextureManager(), 50, 50, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasBookIcon = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasHandWirtingBook = new BitmapTextureAtlas(this.getTextureManager(), 1600, 800, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasBoard = new BitmapTextureAtlas(this.getTextureManager(), 600, 600, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasHandCross = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasDuster = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasMonkeyBrush = new BitmapTextureAtlas(this.getTextureManager(), 1300, 600, TextureOptions.BILINEAR);

		mBitmapTextureAtlasHandTutorial = new BitmapTextureAtlas(this.getTextureManager(), 100, 100, TextureOptions.BILINEAR);

		//Loading texture region
		mPieceChalkTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasPieceChalk, this,
				"pieceChalk.png", 0, 0,  1, 1); 
				
		mPopUpBlackBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBoard, this,
				"board.png", 0, 0,  1, 1); 
				
		mbackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBackGround, this,
				"JungleBG.png", 0, 0,  1, 1); 
		
		mBlackBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBlackBoard, this,
				"blackboard.png", 0, 0,  1, 1); 
				
		mMoOutLineTextureRegion =  BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMoOutLine, this,
				"moOutlineCrop.png", 0, 0,  1, 1); 
				
		mWhiteChalkTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWhiteChalk, this,
				"chalk2.png", 0, 0,  1, 1);
		
		mStarTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasStar, this,
				"star.png", 0, 0,  1, 1);
				
		mShowScreenCaptureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBookIcon, this,
				"bookIcon.png", 0, 0,  1, 1);
				
		mCreatePopUpRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHandWirtingBook, this,
				"handwritingbook.png", 0, 0,  1, 1);
				
		mCrossRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHandCross, this,
				"cross.png", 0, 0,  1, 1);
		
		mDusterTextureRegion =  BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasDuster, this,
				"duster.png", 0, 0,  1, 1);
				
		mSlidingScreenTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMonkeyBrush, this,
				"monkeyBrush3.png", 0, 0,  1, 1);
		
		mHandTutorialTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHandTutorial, this,
				"hand.png", 0, 0,  1, 1);
				
		mAnimatedBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 2000, 267, TextureOptions.NEAREST);
		mMonkeyTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedBitmapTextureAtlas, this, "sp1.png", 10, 1);
		
		try 
		{
			this.mAnimatedBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
		
		mBitmapTextureAtlasBackGround.load();
		mBitmapTextureAtlasPieceChalk.load();
		mBitmapTextureAtlasBlackBoard.load();
		mBitmapTextureAtlasMoOutLine.load();
		mBitmapTextureAtlasWhiteChalk.load();
		mBitmapTextureAtlasStar.load();
		mBitmapTextureAtlasBookIcon.load();
		mBitmapTextureAtlasHandWirtingBook.load();
		mBitmapTextureAtlasBoard.load();
		mBitmapTextureAtlasHandCross.load();
		mBitmapTextureAtlasDuster.load();
		mBitmapTextureAtlasMonkeyBrush.load();
		mBitmapTextureAtlasHandTutorial.load();
	}

	@Override
	protected Scene onCreateScene()
	{
		// TODO Auto-generated method stub
		mScene = new Scene();
		mScene.setBackground(new Background(Color.WHITE));
	
		//Re-creating the stars
		num = 0;
		aCounter = 0;
		
		//Setting animation counter 
		animStart = 0;
		counter = 0;
		
		//pop up value disabler
		popUpVal = 0;
		drawingDisabler = 0;
		
		//pop up duster
		popUpDuster = 0;
		dusterDisabler = 0;
		
		//Outline Structure Serialize
		rectangle1Serialze = 0;
		a1 = 0;
		
		vertexBufferObjectManager = getVertexBufferObjectManager();

		backGround = new Sprite(0, 0, mbackGroundTextureRegion,
				getVertexBufferObjectManager());
		backGround.setHeight(CAMERA_HEIGHT);
		backGround.setWidth(CAMERA_WIDTH);
		mScene.attachChild(backGround);

		moOutLineX = CAMERA_WIDTH / 2 - 130;
		moOutLineY = CAMERA_HEIGHT / 2 - 130;
		
		blackBoard = new Sprite(moOutLineX-160, moOutLineY-85, mBlackBoardTextureRegion,
				getVertexBufferObjectManager());
		blackBoard.setHeight((float) (blackBoard.getHeight()*1.7));
		blackBoard.setWidth((float) (blackBoard.getWidth()*1.5));
		mScene.attachChild(blackBoard);
		
		
		moOutLine = new Sprite(moOutLineX, moOutLineY, mMoOutLineTextureRegion,
				getVertexBufferObjectManager());
		mScene.attachChild(moOutLine);
		
		monkeyTutorial = new MonkeyTutorial(100, -400, mMonkeyTextureRegion,
				getVertexBufferObjectManager());
		monkeyTutorial.animate(new long[]{1000, 1000, 1000, 100, 100, 4000, 1000, 1000, 100, 100}, 0, 9, true);
		mScene.registerTouchArea(monkeyTutorial);
		mScene.attachChild(monkeyTutorial);
		
		MonkeyTutorial.monkeyTutorialstart();
		
		handTutorial = new Sprite(100, 100, mHandTutorialTextureRegion, getVertexBufferObjectManager());
		handTutorial.setVisible(false);
		handTutorial.setScale((float)0.7);
		mScene.attachChild(handTutorial);
		
		duster = new Duster(CAMERA_WIDTH/2+100, -400, mDusterTextureRegion, vertexBufferObjectManager);
		duster.setScale((float) 0.5);
		mScene.registerTouchArea(duster);
		mScene.attachChild(duster);
		
		//Duster.createDusterPopUp(0);
		
		reveal = false;
		thick = 3;
		width = moOutLine.getWidth()/10;
		
		//Hide status bar
		//StatusBar.showStatusBar();
		
		//Draw Outline
		DrawOutline.Draw();
		
		//Create Stars
		Stars.createStars();
		
		//Chalk 
		MainActivity.pieceChalk = new Chalk(MainActivity.moOutLineX -10, MainActivity.moOutLineY -80,
				MainActivity.mPieceChalkTextureRegion, MainActivity.MainActivityInstace.getVertexBufferObjectManager());
		MainActivity.mScene.attachChild(MainActivity.pieceChalk);
		pieceChalk.setScale((float) 0.7);
		
		timer1 = new TimerHandler((float) 1.0f/120,true, new ITimerCallback() 
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) 
			{
				// TODO Auto-generated method stub 
				
				if(animStart == 1 )
				{
					MainActivity.DrawImage2(MainActivity.handTutorial.getX()+20 , MainActivity.handTutorial.getY() -20);
				}
				
//				if(tutorialWhiteChalk!= null && AnimationHandler.j == 0) 
//				{
//					mScene.detachChild(tutorialWhiteChalk);
//					//tutorialWhiteChalk.setVisible(false);
//				} 
				
				if(!(pieceChalk.getX()>=0) && Flag1[38] == 0)  
				{
					Debug.d("chalk create");
					pieceChalk = new Chalk(MainActivity.moOutLineX -10, MainActivity.moOutLineY -80,
							MainActivity.mPieceChalkTextureRegion, MainActivity.MainActivityInstace.getVertexBufferObjectManager());
					MainActivity.mScene.attachChild(MainActivity.pieceChalk);
					pieceChalk.setScale((float) 0.7);
				}
				
				//When there is no interaction with the device, play the animation
				if(touch == 0)
				{	
					//Tutorial showing
					//AnimationHandler.AnimationStart();
				}
				else if(touch == 1)
				{
					pieceChalk.clearEntityModifiers();
				}
				
				//Continuing the star collision
				if(num != 0)
				{
					Stars.starCol(num);
				}
				
			}
		});
		mScene.registerUpdateHandler(timer1);
		
		rect = new Rectangle(pieceChalk.getX(), pieceChalk.getY(), 30, 30, getVertexBufferObjectManager());
		rect.setVisible(false);
		rect.setColor(Color.GREEN);
		mScene.attachChild(rect);
		
		mScene.setOnSceneTouchListener(this);
		
		//Pop up window
		showScreen = new PopUp(40, 310, mShowScreenCaptureRegion, getVertexBufferObjectManager());
		mScene.registerTouchArea(showScreen);
		showScreen.setScale((float) 0.6);
		mScene.attachChild(showScreen);
		
		return mScene;
	}
	
	public void setCurrentScene(Scene scene)
	{
		mScene = scene;
		getEngine().setScene(mScene);
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent)
	{
		// TODO Auto-generated method stub
//		if (pSceneTouchEvent.isActionDown() && animStart == 0)
//		{
//			//The touch is enabled
//			touch = 1;
//			//For piece chalk to be dragged within letter mo range
//			
//			if((pSceneTouchEvent.getX()> moOutLine.getX() && 
//					pSceneTouchEvent.getX()< moOutLine.getX()+moOutLine.getWidth()) &&
//					(pSceneTouchEvent.getY()> moOutLine.getY() && 
//					pSceneTouchEvent.getY()< moOutLine.getY()+moOutLine.getHeight()))
//			{
//				pieceChalk.setPosition(
//						pSceneTouchEvent.getX() - pieceChalk.getWidth() / 2,
//						pSceneTouchEvent.getY() - pieceChalk.getHeight() / 2 - 35);
//			}
//			
//			return true;
//		} 
		if (pSceneTouchEvent.isActionMove() && animStart == 0)
		{
			
			touch = 1;
			
			//Rectangle setPosition
			rect.setPosition(
					pSceneTouchEvent.getX() - rect.getWidth()/2,
					pSceneTouchEvent.getY() - rect.getHeight()/2 );
			
//			for(int a=1; a<40; a++)
//			{
//				if(rect.collidesWith(rectangle1[a]))
//				{
//					Debug.d("rectangle1 collision no:"+a);
//					pieceChalk.setPosition(rect.getX()- pieceChalk.getWidth()/3,
//							rect.getY()-pieceChalk.getHeight()/2);
//					
//					if(a == 8)
//					{
//						a1++;
//						if(a1==1)
//						{
//							rectangle1Serialze++;
//						}
//					}
//					
//				}
//			}
			
			if(rectangle1Serialze == 0)
			{
				for(int a=1; a<10; a++)
				{
					if(rect.collidesWith(rectangle1[a]))
					{
						Debug.d("rectangle1 collision no:"+a);
						pieceChalk.setPosition(rect.getX()- pieceChalk.getWidth()/3,
								rect.getY()-pieceChalk.getHeight()/2);
						
						if(drawingDisabler == 0)
						{
							DrawImage(pSceneTouchEvent.getX() - 25, 
								pSceneTouchEvent.getY() - 30); 
						}
						
						if(a == 8)
						{
							a1++;
							if(a1==1)
							{
								rectangle1Serialze++;
							}
						}
						
					}
				}
			}
			
			if(rectangle1Serialze == 1)
			{
				a1 = 0;
				for(int a=12; a<25; a++)
				{
					if(rect.collidesWith(rectangle1[a]))
					{
						Debug.d("rectangle1 collision no:"+a);
						pieceChalk.setPosition(rect.getX()- pieceChalk.getWidth()/3,
								rect.getY()-pieceChalk.getHeight()/2);
						
						if(drawingDisabler == 0)
						{
							DrawImage(pSceneTouchEvent.getX() - 25, 
								pSceneTouchEvent.getY() - 30); 
						}
						
						if(a == 24)
						{
							a1++;
							if(a1==1)
							{
								rectangle1Serialze++;
							}
						}
						
					}
				}
				Debug.d("r:"+rectangle1Serialze);
			}
			
			if(rectangle1Serialze == 2)
			{
				a1 = 0;
				for(int a=25; a<40; a++)
				{
					if(rect.collidesWith(rectangle1[a]))
					{
						Debug.d("rectangle1 collision no:"+a);
						pieceChalk.setPosition(rect.getX()- pieceChalk.getWidth()/3,
								rect.getY()-pieceChalk.getHeight()/2);
						
						if(drawingDisabler == 0)
						{
							DrawImage(pSceneTouchEvent.getX() - 25, 
								pSceneTouchEvent.getY() - 30); 
						}
						
						if(a == 40)
						{
							a1++;
							if(a1==1)
							{
								rectangle1Serialze++;
							}
						}
						
					}
				}
			}
			//For drawing white chalk
//			if(drawingDisabler == 0)
//			{
//				DrawImage(pSceneTouchEvent.getX() - 25, 
//					pSceneTouchEvent.getY() - 30); 
//			}
			//For piece chalk to be dragged within letter mo range 
//			if((pSceneTouchEvent.getX()> moOutLine.getX() && 
//					pSceneTouchEvent.getX()< moOutLine.getX()+moOutLine.getWidth()) &&
//					(pSceneTouchEvent.getY()> moOutLine.getY() && 
//					pSceneTouchEvent.getY()< moOutLine.getY()+moOutLine.getHeight()))
//			{
//				pieceChalk.setPosition(
//						pSceneTouchEvent.getX() - pieceChalk.getWidth() / 2,
//						pSceneTouchEvent.getY() - pieceChalk.getHeight() / 2 - 35);
//			} 
			
			if(whiteChalk!= null) 
			{
				//One by one Collision checker
				CollisionChecker.collisionCheck(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				//get the position
				Position.getPosition(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
			}
			
			if( whiteChalk!=null && whiteChalk.collidesWith(star[1]) && CollisionChecker.val !=0)
			{
				//play sound
				MainActivity.audioPlay = true;
				MainActivity.playAudio(R.raw.star);
				
				mScene.detachChild(star[1]); 
				MainActivity.star[1].setPosition(MainActivity.CAMERA_WIDTH, MainActivity.CAMERA_HEIGHT);
				num=1;
			}
			//Checking for the screenshot
			if(Flag1[38]== 1)
			{
				screenCapture = new ScreenCapture();
				mScene.attachChild(screenCapture);
				
				mScene.registerUpdateHandler(new TimerHandler((float)0.5, new ITimerCallback() 
				{
					@Override
					public void onTimePassed(TimerHandler pTimerHandler)
					{
						// TODO Auto-generated method stub
						screenShot();
					}
				}));
			}
			if(Flag1[39] == 1)
			{
				for(int j=1; j<18; j++)
				{
					star[j].setY(CAMERA_WIDTH+CAMERA_WIDTH); 
				}
				MainActivity.audioPlay = true;
				MainActivity.playAudio(R.raw.lettercompletesound);
				
				Duster.createDusterPopUp(1);
				Flag1[39] = 0;
			}
			
			return true;  
		}
		else if (pSceneTouchEvent.isActionUp() && animStart == 0) 
		{
				//The touch is disabled
				touch = 0;
		}
		return true;
	}  
	
	//Audio play Function
	public static void playAudio(int val)
	{
		if(audioPlay)
		{
			mediaPlayer = MediaPlayer.create(MainActivityInstace.getBaseContext(), val);
			try 
			{
				mediaPlayer.start();
				mediaPlayer.setLooping(false);
			} 
			catch (IllegalStateException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			audioPlay = true;
		}
	}
	
	public void DrawImage(float x, float y)
	{ 
		// TODO Auto-generated method stub
		whiteChalk = new Sprite(x, y, MainActivity.mWhiteChalkTextureRegion,
				MainActivity.vertexBufferObjectManager); 
		Debug.d("whiteChalk.x:"+whiteChalk.getX());
		//whiteChalk.setVisible(false);
		mScene.attachChild(MainActivity.whiteChalk);
		whiteChalk.setScale((float) 0.4);
		
	}
	
	public static void DrawImage2(float x, float y)
	{ 
		// TODO Auto-generated method stub
		counter++;
		if(counter >600)
		{
			animStart = 0;
			counter=0;
		}
		//Debug.d("counter:"+counter);
		tutorialWhiteChalk[counter] = new Sprite(x, y, MainActivity.mWhiteChalkTextureRegion,
				MainActivity.vertexBufferObjectManager); 
		//Debug.d("counter:"+counter);
		//whiteChalk.setVisible(false);
		mScene.attachChild(MainActivity.tutorialWhiteChalk[counter]);
		tutorialWhiteChalk[counter].setScale((float) 0.4);
	}
	 
	public void screenShot()
	{
		final int viewWidth = MainActivity.this.mRenderSurfaceView.getWidth() - 525;
		final int viewHeight = MainActivity.this.mRenderSurfaceView.getHeight() - 165;
		
		pieceChalk.setVisible(false);
		//final float time = System.currentTimeMillis();
		screenCapture.capture(264, 80, viewWidth, viewHeight,FileUtils.getAbsolutePathOnInternalStorage
				(getApplicationContext(), "/screen"+".jpg") , new IScreenCaptureCallback() 
		{ 
			@Override
			public void onScreenCaptured(final String pFilePath) 
			{
				MainActivity.this.runOnUiThread(new Runnable()
				{
					@Override
					public void run() 
					{
						//Debug.d("Screenshot: " + pFilePath + " taken!");
						changeTexture = 1;
						new setTexture(FileUtils.getAbsolutePathOnInternalStorage
								(getApplicationContext(), "/screen"+".jpg"));
					} 
				});
			}

			@Override
			public void onScreenCaptureFailed(final String pFilePath, final Exception pException)
			{
				MainActivity.this.runOnUiThread(new Runnable()
				{
					@Override
					public void run() 
					{
						changeTexture = 0;
					}
				});
			}
		});

	}
	
	public static class setTexture
	{
		public setTexture(String address)
		{ 
			//this.mDrawnPictureRegion = textureRegion;
			source = new BitmapTextureAtlasSource(
					BitmapFactory.decodeFile(address));
			texture = new BitmapTextureAtlas(MainActivityInstace.getTextureManager(), 1000, 1000);
			texture.addTextureAtlasSource(source, 0, 0);
			texture.load();
			textureRegion = (TextureRegion) TextureRegionFactory.createFromSource(texture, source, 0, 0);
		}
		
	}
//	@Override
//	public void onStop()
//	{
//		super.onStop();
//		mScene.clearUpdateHandlers();
//	}
	
//	@Override
//	public void onDestroy()
//	{
//		super.onDestroy();
//		//mScene.clearUpdateHandlers();
//	}
}
