import java.awt.Color;

public class ImageBot {
	public static void main(String[] args) {
		
		ImageUtils utils = new ImageUtils();
		
		Color[][] orig = utils.loadImage("src/LennaCV.png");
		utils.addImage(orig, "Original Image");
		
		Color[][] grey = darkerGreyScale(orig); 
		utils.addImage(grey, "Darker Grey Scale");
		
		Color[][] negative = negative(orig);
		utils.addImage(negative, "Negative");
		
		Color[][] sepia = sepia(orig);
		utils.addImage(sepia, "Sepia");
		
		utils.display();
		
	}
	
	public static Color[][] darkerGreyScale(Color[][] image){
		
		Color[][] tmp = ImageUtils.cloneArray(image);
		for(int x = 0; x < tmp.length; x++)
		{
			for(int y=0; y < tmp[x].length; y++)
			{
				Color pixel = tmp[x][y];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
				int avg = (r + b + g) / 6;
				tmp[x][y] = new Color(avg, avg, avg);
			}
		}
		return tmp;
	}
	
	public static Color[][] negative(Color[][] image) {
		
		Color[][] tmp = ImageUtils.cloneArray(image);
		for(int x = 0; x < tmp.length; x++)
		{
			for(int y=0; y < tmp[x].length; y++)
			{
                Color pixel = tmp[x][y];
                
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();
 
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                
                tmp[x][y] = new Color(r, g, b); }}
		return tmp; }
        
	public static Color[][] sepia(Color[][] img) {
		
	 Color[][] tmp = ImageUtils.cloneArray(img);
	 for(int x = 0; x < tmp.length; x++)
		{
			for(int y=0; y < tmp[x].length; y++)
			{
			  Color pixel = tmp[x][y];
			  
			  int r = pixel.getRed(); 
			  int g = pixel.getGreen();
			  int b = pixel.getBlue();
			  int newR = (int)(0.393*r + 0.769*g + 0.189*b);
			  int newG = (int)(0.349*r + 0.686*g + 0.168*b);
			  int newB = (int)(0.272*r + 0.534*g + 0.131*b);
			  
			  if(newR > 255)
			  {
			   newR = 255;
			  }
			  if(newG > 255)
			  {
			   newG = 255;  
			  }
			  if(newB > 255)
			  {
			   newB = 255;  
			  }
			  
			  
			  tmp[x][y] = new Color(newR, newG, newB);  }}  
	 return tmp; }
	
	
	}
	
		