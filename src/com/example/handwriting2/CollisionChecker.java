package com.example.handwriting2;

import android.content.Intent;

public class CollisionChecker 
{
	
	static int val  ;
	
	public static void collisionCheck(float a, float b)
	{
		if (MainActivity.Flag1[1] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[1])) 
		{
			//next instruction for first line
			MainActivity.drawLine = 1; 
			MainActivity.Flag = 0; 
			MainActivity.Flag1[2] = 1;
			loop(1, a, b);
		} 
		else if (MainActivity.Flag1[2] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[2]))
		{
			//next instruction for first line
			MainActivity.drawLine = 1; 
			loop(2, a, b);
		} 
		else if (MainActivity.Flag1[3] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[3])) 
		{
			//next instruction for first line
			MainActivity.drawLine = 1; 
			loop(3, a, b);
		} 
		else if (MainActivity.Flag1[4] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[4]))
		{
			//next instruction for first line
			MainActivity.drawLine = 1; 
			loop(4, a, b);
		} 
		else if (MainActivity.Flag1[5] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[5])) 
		{
			//next instruction for first line
			MainActivity.drawLine = 1; 
			loop(5, a, b);
		} 
		else if (MainActivity.Flag1[6] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[6])) 
		{
			//next instruction for first line
			MainActivity.drawLine = 1; 
			loop(6, a, b);
		}
		else if (MainActivity.Flag1[7] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[7]))
		{
			//next instruction for first line
			MainActivity.drawLine = 1;
			loop(7, a, b);
		} 
		else if (MainActivity.Flag1[8] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[8]))
		{
			//next instruction for drawing the second line
			MainActivity.drawLine = 2;
			loop(8, a, b);
		}
		// 2nd Line
		else if (MainActivity.Flag1[9] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[9])) 
		{
			//next instruction for drawing the second line
			MainActivity.drawLine = 2;
			loop(9, a, b);  
		}
		else if (MainActivity.Flag1[10] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[10]))
		{
			//next instruction for drawing the second line
			MainActivity.drawLine = 2;
			loop(10, a, b);
		} 
		else if (MainActivity.Flag1[11] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[11]))
		{
			//next instruction for drawing the second line
			MainActivity.drawLine = 2;
			loop(11, a, b);
		} 
		else if (MainActivity.Flag1[12] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[12]))
		{
			//next instruction for drawing the second line
			MainActivity.drawLine = 2;
			loop(12, a, b);
		} 
		else if (MainActivity.Flag1[13] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[13]))
		{
			//next instruction for drawing the second line
			MainActivity.drawLine = 2;
			loop(13, a, b);
		} 
		else if (MainActivity.Flag1[14] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[14]))
		{
			//next instruction for drawing the second line
			MainActivity.drawLine = 2;
			loop(14, a, b);
		} 
		else if (MainActivity.Flag1[15] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[15]))
		{
			//next instruction for drawing the second line
			MainActivity.drawLine = 2;
			loop(15, a, b);
		} 
		else if (MainActivity.Flag1[16] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[16]))
		{
			//next instruction for third line
			MainActivity.drawLine = 3; 
			loop(16, a, b);
		}
		//3rd line
		else if (MainActivity.Flag1[17] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[17])) 
		{
			//next instruction for third line
			MainActivity.drawLine = 3; 
			loop(17, a, b);
		} 
		else if (MainActivity.Flag1[18] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[18]))
		{
			//next instruction for third line
			MainActivity.drawLine = 3; 
			loop(18, a, b);
		} 
		else if (MainActivity.Flag1[19] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[19]))
		{
			//next instruction for forth line
			MainActivity.drawLine = 4; 
			loop(19, a, b);
		} 
		//4th line
		else if (MainActivity.Flag1[20] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[20]))
		{
			//next instruction for forth line
			MainActivity.drawLine = 4; 
			loop(20, a, b);
		} 
		else if (MainActivity.Flag1[21] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[21]))
		{
			//next instruction for forth line
			MainActivity.drawLine = 4; 
			loop(21, a, b);
		}
		//5th line
		else if (MainActivity.Flag1[22] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[22]))
		{
			//next instruction for forth line
			MainActivity.drawLine = 4; 
			loop(22, a, b);
		} 
		else if (MainActivity.Flag1[23] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[23]))
		{
			//next instruction for fifth line
			MainActivity.drawLine = 5; 
			loop(23, a, b);
		} 
		//6th line
		else if (MainActivity.Flag1[24] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[24]))
		{
			//next instruction for fifth line
			MainActivity.drawLine = 5; 
			loop(24, a, b);
		} 
		else if (MainActivity.Flag1[25] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[25]))
		{
			//next instruction for fifth line
			MainActivity.drawLine = 5; 
			loop(25, a, b);
		} 
		//7th line
		else if (MainActivity.Flag1[26] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[26]))
		{
			//next instruction for fifth line
			MainActivity.drawLine = 5; 
			loop(26, a, b);
		} 
		else if (MainActivity.Flag1[27] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[27]))
		{
			//next instruction for sixth line
			MainActivity.drawLine = 6; 
			loop(27, a, b);
		}
		//8th line
		else if (MainActivity.Flag1[28] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[28]))
		{
			//next instruction for sixth line
			MainActivity.drawLine = 6; 
			loop(28, a, b);
		} 
		else if (MainActivity.Flag1[29] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[29]))
		{
			//next instruction for sixth line
			MainActivity.drawLine = 6; 
			loop(29, a, b);
		}
		else if (MainActivity.Flag1[30] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[30]))
		{
			//next instruction for sixth line
			MainActivity.drawLine = 6; 
			loop(30, a, b);
		} 
		else if (MainActivity.Flag1[31] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[31]))
		{
			//next instruction for sixth line
			MainActivity.drawLine = 6; 
			loop(31, a, b);
		}
		//9th line
		else if (MainActivity.Flag1[32] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[32]))
		{
			//next instruction for seventh line
			MainActivity.drawLine = 7; 
			loop(32, a, b);
		}
		else if (MainActivity.Flag1[33] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[33]))
		{
			//next instruction for seventh line
			MainActivity.drawLine = 7; 
			loop(33, a, b);
		}
		else if (MainActivity.Flag1[34] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[34]))
		{
			//next instruction for seventh line
			MainActivity.drawLine = 7; 
			loop(34, a, b);
		}
		else if (MainActivity.Flag1[35] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[35]))
		{
			//next instruction for seventh line
			MainActivity.drawLine = 7; 
			loop(35, a, b);
		}
		else if (MainActivity.Flag1[36] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[36]))
		{
			//next instruction for seventh line
			MainActivity.drawLine = 7; 
			loop(36, a, b);
		}
		else if (MainActivity.Flag1[37] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[37]))
		{
			//next instruction for seventh line
			MainActivity.drawLine = 7; 
			loop(37, a, b);
		}
		else if (MainActivity.Flag1[38] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[38]))
		{
			//next instruction for seventh line
			MainActivity.drawLine = 7; 
			loop(38, a, b);
		}
		else if (MainActivity.Flag1[39] == 1 && MainActivity.whiteChalk.collidesWith(MainActivity.rectangle1[39]))
		{
			//next instruction for seventh line
			MainActivity.drawLine = 7; 
			loop(39, a, b);
			
			for(int i = 0; i<40; i++)
			{
				MainActivity.Flag1[i] = 0;
			}
			
			MainActivity.drawLine = 1;
			MainActivity.mScene.unregisterUpdateHandler(MainActivity.timer1);
		}  
		else 
		{
			MainActivity.mScene.detachChild(MainActivity.whiteChalk);
			val = 0;
		}

	}
	
	
	public static void loop(int a, float x, float y)
	{
		for(int i=1; i<a; i++)
		{
			val = 1;
			MainActivity.Flag1[i] = 0;
			MainActivity.Flag1[a] = 1;
			MainActivity.Flag1[a+1] = 1; 
			MainActivity.touchPositionX = x;
			MainActivity.touchPositionY = y;
		}
	}
	
	public void finishActivity()
	{
		Intent intent = MainActivity.MainActivityInstace.getIntent();
		MainActivity.MainActivityInstace.finish();
		MainActivity.MainActivityInstace.startActivity(intent); 
	}
}
