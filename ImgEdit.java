import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class ImgEdit {

	public static void main(String[] args) {
		
		String filePath;
		int select;
		Scanner input0 = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Filepath?");
		filePath = input0.nextLine();
		
		System.out.println("This program will show a comparison and analysis(except option 8) of the original Lenna image to your modification selection. Choose from the following:\n");
		System.out.println("1. GS-Each pixel is assigned grayscale value for red, green, and blue.");
		System.out.println("\n2. HR-Each pixel is assigned half its red value, grayscale green value, and grayscale blue value.");
		System.out.println("\n3. HG-Each pixel is assigned grayscale red value, half its green value, and grayscale blue value.");
		System.out.println("\n4. HB-Each pixel is assigned grayscale red value, grayscale green value, and half its blue value.");
		System.out.println("\n5. NR-Each pixel is assigned zero red value, grayscale green value, and grayscale blue value.");
		System.out.println("\n6. NG-Each pixel is assigned grayscale red value, zero green value, and grayscale blue value.");
		System.out.println("\n7. NB-Each pixel is assigned grayscale red value, grayscale green value, and zero blue value.");
		System.out.println("\n8. ALL-Show all preloaded images simultaneously.");
		System.out.println("\n9. EXIT-Program terminates.");
		select = input.nextInt();
		
		if (select == 1) {
			ImageUtils img = new ImageUtils();
			Color[][] regLenna = img.loadImage("filePath");
			img.addImage(regLenna, "Unmodified");
			Color[][] gray = gray(regLenna);
			img.addImage(gray, "Monochromatic");
			img.display();
			System.out.println("\nHere is a standard grayscale version of the original image. Each pixel is defined by values alpha(not explored in this program), red,");
			System.out.println("green, and blue on a scale 0-255. The script runs through each of 262,144 pixels, finds and assigns the averages of red, green, and blue.");
			System.out.println("The result is this monochromatic version of Lenna.");
		}
		else if (select == 2) {
			ImageUtils img = new ImageUtils();
			Color[][] regLenna = img.loadImage("filePath");
			img.addImage(regLenna, "Unmodified");
			Color[][] rWashed = rWash(regLenna);
			img.addImage(rWashed, "Half Red, GS Green, GS Blue");
			img.display();
			System.out.println("\nThis image assigns grayscale values to green and blue while only halving each pixel's red value. I found this to be a fairly interesting");
			System.out.println("version of the photograph as it reminded me of that 'washed out', faded look of my parents' family albums of growing up in the 1970s.");
		}
		else if (select == 3) {
			ImageUtils img = new ImageUtils();
			Color[][] regLenna = img.loadImage("filePath");
			img.addImage(regLenna, "Unmodified");
			Color[][] gWashed = gWash(regLenna);
			img.addImage(gWashed, "GS Red, Half Green, GS Blue");
			img.display();
			System.out.println("\nThis version doesn't strike me as anything other than its basic description-just results in a faded, purple version of Lenna.");
		}
		else if (select == 4) {
			ImageUtils img = new ImageUtils();
			Color[][] regLenna = img.loadImage("filePath");
			img.addImage(regLenna, "Unmodified");
			Color[][] bWashed = bWash(regLenna);
			img.addImage(bWashed, "GS Red, GS Green, Half Blue");
			img.display();
			System.out.println("\nAt first glance, it just looks like its description, but this one also reminded me of older family photographs as well(think parents' parents). While the pictures, when taken");
			System.out.println("may not have looked like this, in time the physical materials of the printed photograph fade and become oxidized or 'yellowed' (although much lighter shades of yellowing).");
		}
		else if (select == 5) {
			ImageUtils img = new ImageUtils();
			Color[][] regLenna = img.loadImage("filePath");
			img.addImage(regLenna, "Unmodified");
			Color[][] tealed = teal(regLenna);
			img.addImage(tealed, "No Red, GS Green, GS Blue");
			img.display();
			System.out.println("\nThis version doesn't strike me as anything other than its basic description-just results in a less faded, dark-teal version of Lenna.");
		}
		else if (select == 6) {
			ImageUtils img = new ImageUtils();
			Color[][] regLenna = img.loadImage("filePath");
			img.addImage(regLenna, "Unmodified");
			Color[][] purpled = purple(regLenna);
			img.addImage(purpled, "GS Red, No Green, GS Blue");
			img.display();
			System.out.println("\nThis version doesn't strike me as anything other than its basic description-just results in a less faded, dark-purple version of Lenna.");
		}
		else if (select == 7) {
			ImageUtils img = new ImageUtils();
			Color[][] regLenna = img.loadImage("filePath");
			img.addImage(regLenna, "Unmodified");
			Color[][] yellowed = yellow(regLenna);
			img.addImage(yellowed, "GS Red, GS Green, No Blue");
			img.display();
			System.out.println("\nThis version doesn't strike me as anything other than its basic description-just results in a less faded, dark-yellow version of Lenna.");
		}
		else if (select == 8) {
		
		ImageUtils img = new ImageUtils();
		Color[][] regLenna = img.loadImage("filePath");
		img.addImage(regLenna, "Unmodified");
		Color[][] gray = gray(regLenna);
		img.addImage(gray, "Monochromatic");
		Color[][] rWashed = rWash(regLenna);
		img.addImage(rWashed, "Half Red, GS Green, GS Blue");
		Color[][] gWashed = gWash(regLenna);
		img.addImage(gWashed, "GS Red, Half Green, GS Blue");
		Color[][] bWashed = bWash(regLenna);
		img.addImage(bWashed, "GS Red, GS Green, Half Blue");
		Color[][] tealed = teal(regLenna);
		img.addImage(tealed, "No Red, GS Green, GS Blue");
		Color[][] purpled = purple(regLenna);
		img.addImage(purpled, "GS Red, No Green, GS Blue");
		Color[][] yellowed = yellow(regLenna);
		img.addImage(yellowed, "GS Red, GS Green, No Blue");
		img.display();
		System.out.println("\nAll preloaded renderings.");
		}
		else if (select == 9) {
			System.out.println("Have a wonderful day!");
			}
		}

	public static Color[][] gray(Color[][] img) {
		Color[][] gLenna = ImageUtils.cloneArray(img);
		for(int i = 0; i < gLenna.length; i++) {
			for(int j = 0; j < gLenna[i].length; j++) {
				Color pixel = img[i][j];
				int red = pixel.getRed();
				int green = pixel.getGreen();
				int blue = pixel.getBlue();
				int avg = (red+green+blue)/3;
				gLenna[i][j] = new Color(avg, avg, avg);
			}
		}
		return gLenna;
}
	public static Color[][] rWash(Color[][] img) {
		Color[][] rWashLenna = ImageUtils.cloneArray(img);
		for(int i = 0; i < rWashLenna.length; i++) {
			for(int j = 0; j < rWashLenna[i].length; j++) {
				Color pixel = img[i][j];
				int red = pixel.getRed();
				int green = pixel.getGreen();
				int blue = pixel.getBlue();
				int avg = (red+green+blue)/3;
				int rFade = (int) (red*0.5);
				rWashLenna[i][j] = new Color(rFade, avg, avg);
			}
		}
		return rWashLenna;
}
	public static Color[][] gWash(Color[][] img) {
		Color[][] gWashLenna = ImageUtils.cloneArray(img);
		for(int i = 0; i < gWashLenna.length; i++) {
			for(int j = 0; j < gWashLenna[i].length; j++) {
				Color pixel = img[i][j];
				int red = pixel.getRed();
				int green = pixel.getGreen();
				int blue = pixel.getBlue();
				int avg = (red+green+blue)/3;
				int gFade = (int) (green*0.5);
				gWashLenna[i][j] = new Color(avg, gFade, avg);
			}
		}
		return gWashLenna;
}
	public static Color[][] bWash(Color[][] img) {
		Color[][] bWashLenna = ImageUtils.cloneArray(img);
		for(int i = 0; i < bWashLenna.length; i++) {
			for(int j = 0; j < bWashLenna[i].length; j++) {
				Color pixel = img[i][j];
				int red = pixel.getRed();
				int green = pixel.getGreen();
				int blue = pixel.getBlue();
				int avg = (red+green+blue)/3;
				int bFade = (int) (blue*0.5);
				bWashLenna[i][j] = new Color(avg, avg, bFade);
			}
		}
		return bWashLenna;
}
	public static Color[][] teal(Color[][] img) {
		Color[][] tealLenna = ImageUtils.cloneArray(img);
		for(int i = 0; i < tealLenna.length; i++) {
			for(int j = 0; j < tealLenna[i].length; j++) {
				Color pixel = img[i][j];
				int red = pixel.getRed();
				int green = pixel.getGreen();
				int blue = pixel.getBlue();
				int avg = (red+green+blue)/3;
				tealLenna[i][j] = new Color(0, avg, avg);
		
		}
	}
		return tealLenna;
}		
	public static Color[][] purple(Color[][] img) {
			Color[][] purpleLenna = ImageUtils.cloneArray(img);
			for(int i = 0; i < purpleLenna.length; i++) {
				for(int j = 0; j < purpleLenna[i].length; j++) {
					Color pixel = img[i][j];
					int red = pixel.getRed();
					int green = pixel.getGreen();
					int blue = pixel.getBlue();
					int avg = (red+green+blue)/3;
					purpleLenna[i][j] = new Color(avg, 0, avg);
			
		}
	}
			return purpleLenna;
}			
		public static Color[][] yellow(Color[][] img) {
				Color[][] yellowLenna = ImageUtils.cloneArray(img);
				for(int i = 0; i < yellowLenna.length; i++) {
					for(int j = 0; j < yellowLenna[i].length; j++) {
						Color pixel = img[i][j];
						int red = pixel.getRed();
						int green = pixel.getGreen();
						int blue = pixel.getBlue();
						int avg = (red+green+blue)/3;
						yellowLenna[i][j] = new Color(avg, avg, 0);
				
		}
	}
			return yellowLenna; 
}

}
		
		
		
		
		