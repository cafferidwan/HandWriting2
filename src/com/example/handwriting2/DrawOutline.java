package com.example.handwriting2;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.util.color.Color;

public class DrawOutline
{
	public static void Draw()
	{
		// 1st line
		for (int i = 1; i < 9; i++)
		{
			MainActivity.rectangle1[i] = Structure(MainActivity.moOutLineX + 25
					* i, MainActivity.moOutLineY + 13, MainActivity.width,
					MainActivity.thick, 0, MainActivity.reveal);
		}

		MainActivity.touchPositionX = MainActivity.rectangle1[1].getX();
		MainActivity.touchPositionY = MainActivity.rectangle1[1].getY();

		// 2nd line
		for (int i = 9; i < 17; i++)
		{
			MainActivity.rectangle1[i] = Structure(MainActivity.moOutLineX - 55
					+ 11 * i, MainActivity.moOutLineY - 84 + 11 * i,
					MainActivity.thick, MainActivity.width, -45,
					MainActivity.reveal);
		}
		// 3rd line
		for (int i = 17; i < 20; i++) 
		{
			MainActivity.rectangle1[i] = Structure(MainActivity.moOutLineX
					+ 244 - 7 * i, MainActivity.moOutLineY - 227 + 20 * i,
					MainActivity.thick, MainActivity.width, 18,
					MainActivity.reveal);
		}
		// 4th line
		for (int i = 20; i < 22; i++)
		{
			MainActivity.rectangle1[i] = Structure(MainActivity.moOutLineX
					+ 460 - 18 * i, MainActivity.moOutLineY + 10 + 8 * i,
					MainActivity.thick, MainActivity.width, 70,
					MainActivity.reveal);
		}
		// 5th line
		for (int i = 22; i < 24; i++) 
		{
			MainActivity.rectangle1[i] = Structure(MainActivity.moOutLineX
					+ 460 - 18 * i, MainActivity.moOutLineY + 550 - 17 * i,
					MainActivity.thick, MainActivity.width, 130,
					MainActivity.reveal);
		}
		// 6th line
		for (int i = 24; i < 26; i++) 
		{
			MainActivity.rectangle1[i] = Structure(MainActivity.moOutLineX
					+ 165 - 5 * i, MainActivity.moOutLineY - 260 + 16 * i,
					MainActivity.thick, MainActivity.width, 15,
					MainActivity.reveal);
		}
		// 7th line
		for (int i = 25; i < 28; i++)
		{
			MainActivity.rectangle1[i] = Structure(MainActivity.moOutLineX
					- 440 + 20 * i, MainActivity.moOutLineY + 165 - 2 * i,
					MainActivity.thick, MainActivity.width, 85,
					MainActivity.reveal);
		}
		// 8th line
		for (int i = 28; i < 32; i++) 
		{
			MainActivity.rectangle1[i] = Structure(MainActivity.moOutLineX
					- 375 + 18 * i, MainActivity.moOutLineY - 385 + 18 * i,
					MainActivity.thick, MainActivity.width + 25, -45,
					MainActivity.reveal);
		}
		// 9th line
		for (int i = 32; i < 40; i++)
		{
			MainActivity.rectangle1[i] = Structure(
					MainActivity.moOutLineX + 200, MainActivity.moOutLineY
							+ 1025 - 26 * i, MainActivity.thick,
					MainActivity.width, 180, MainActivity.reveal);
		}
	}

	public static Rectangle Structure(float x, float d, float w, float h,
			float rotate, boolean reveal) 
	{
		Rectangle rect = new Rectangle(x, d, w, h,
				MainActivity.vertexBufferObjectManager);
		rect.setColor(Color.BLUE);
		rect.setRotation(rotate);
		rect.setVisible(reveal);
		MainActivity.mScene.attachChild(rect);

		return rect;
	}
}
