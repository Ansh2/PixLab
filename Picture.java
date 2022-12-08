import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super() child
		 * constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height the height of the desired picture
	 * @param width  the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName, height
	 *         and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of the
	 * picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
				count++;
			}
		}
		System.out.println("# of times the body of the nested loop executes = " + count);
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in the
	 * current picture
	 * 
	 * @param fromPic  the picture to copy from
	 * @param startRow the start row to copy to
	 * @param startCol the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		flower1.explore();
		flower2.explore();
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	// Exercise 3 | A5

	public void keepBlueOnly() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}

	// Exercise 4 | A5

	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixelObj : row) {
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setBlue(255 - pixelObj.getBlue());
				pixelObj.setGreen(255 - pixelObj.getGreen());

			}
		}

	}

	// Exercise 5 | A5

	public void grayscale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixobj : row) {
				int average = (int) ((pixobj.getRed() + pixobj.getBlue() + pixobj.getGreen()) / 3.0);
				pixobj.setBlue(average);
				pixobj.setRed(average);
				pixobj.setGreen(average);
			}
		}

	}

	// Exercise 6 CHALLENGE | A5

	public void fixUnderwater() {
		long sum = 0; 
		long count = 0; 
		Pixel[][] pixels = this.getPixels2D(); 
		 for (Pixel[] row : pixels) {
			 for (Pixel pixObj: row) {
				 int average = (int) ((pixObj.getRed() + pixObj.getBlue() + pixObj.getGreen()) / 3.0);
				 sum += average; 
				 count++; 
			 }
		 }
		 int averageAll = (int) (sum / count); 
		 for (Pixel[] row : pixels) {
			 for (Pixel pixObj: row) {
				 //change only blue and green because red does not have any effect on picture
				 pixObj.setBlue((pixObj.getBlue() - averageAll) * 2);
				 pixObj.setGreen((pixObj.getGreen() - averageAll) * 2);
			 }
		 }
		 

		 
		
	}
	
	// Exercise 1 | A6

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	// Exercise 2 | A6

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPix = null;
		Pixel rightPix = null;
		int length = pixels.length;

		for (int row = 0; row < length / 2; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				leftPix = pixels[row][col];
				rightPix = pixels[length - 1 - row][col];
				rightPix.setColor(leftPix.getColor());
			}
		}
	}

	// Exercise 3 | A6

	public void mirrorHorizontalBotToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPix = null;
		Pixel rightPix = null;
		int length = pixels.length;

		for (int row = 0; row < length / 2; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				leftPix = pixels[row][col];
				rightPix = pixels[length - 1 - row][col];
				leftPix.setColor(rightPix.getColor());
			}
		}
	}

	// Exercise 4 | A6 Challenge

	public void mirrorDiagonal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPix = null;
		Pixel rightPix = null;

		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length && col < pixels.length; col++) {
				leftPix = pixels[row][col];
				rightPix = pixels[col][row];
				leftPix.setColor(rightPix.getColor());
			}
		}

	}

	// Exercise 2 | A7

	public void mirrorArms() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int mirrorPoint = 292;

		for (int row = 160; row < 195; row++) {
			for (int col = 106; col < mirrorPoint; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[195 - row + 195][col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}

	}

	// Exercise 3 | A7

	public void mirrorGull() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int mirrorPoint = 345;

		for (int row = 233; row < 320; row++) {
			for (int col = 239; col < mirrorPoint; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][357 - col + 357];
				rightPixel.setColor(leftPixel.getColor());
			}
		}

	}

	// Exercise 1 | A8

	public void copy2(Picture fromPic, int fromStartRow, int fromEndRow, int fromStartCol, int fromEndCol,
			int toStartRow, int toStartCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();

		for (int fromRow = fromStartRow, toRow = toStartRow; fromRow < fromEndRow
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = fromStartCol, toCol = toStartCol; fromCol < fromEndCol
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());

			}

		}

	}

	// Exercise 2 | A8

	public void myCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture mark = new Picture("blue-mark.jpg");
		Picture gorge = new Picture("gorge.jpg");
		Picture flower2ZeroBlue = new Picture("flower2.jpg");
		Picture blueMotorcycle = new Picture("blueMotorcycle.jpg");
		this.copy2(mark, 172, 284, 276, 385, 0, 0);
		this.copy2(flower1, 3, 33, 27, 66, 112, 0);
		this.copy2(mark, 172, 284, 276, 385, 142, 0);
		Picture mirrorGorge = new Picture(gorge);
		mirrorGorge.mirrorHorizontal();
		this.copy2(mirrorGorge, 76, 120, 82, 173, 254, 0);
		this.copy2(blueMotorcycle, 84, 166, 100, 234, 298, 0);
		flower2ZeroBlue.zeroBlue();
		this.copy2(flower1, 0, 67, 0, 71, 380, 0);
		mark.grayscale();
		this.copy2(mark, 217, 250, 306, 350, 447, 0);
		this.mirrorVertical();
		this.write("collage.jpg");

	}

	// Exercise 1 | A9

	public void edgeDetection2(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				
				//for checking horizontally 
				if (row < pixels.length - 1) {
					leftPixel = pixels[row][col];
					rightPixel = pixels[row + 1][col];
					rightColor = rightPixel.getColor();
					if (leftPixel.colorDistance(rightColor) > edgeDist) {
						leftPixel.setColor(Color.BLACK);
					}
				} 
				//for checking vertically
				if (col < pixels[0].length - 1) {
					leftPixel = pixels[row][col];
					rightPixel = pixels[row][col - 1];
					rightColor = rightPixel.getColor();
					if (leftPixel.colorDistance(rightColor) > edgeDist) {
						leftPixel.setColor(Color.BLACK);
					}
				}
				
			
				leftPixel.setColor(Color.WHITE);
			}
		}
	}
	
	public void chromakey(Picture screen) {
		Pixel[][] person = this.getPixels2D(); //person 
		Pixel[][] background = screen.getPixels2D(); //moon
		Pixel fromPixel = null;
		Pixel toPixel = null;
		
		//make 2Dim arrays of the background 
		for (int row = 0; row < person.length; row++) {
			for (int col = 0; col < person[0].length; col++) {
//				if (person[row][col].getGreen() > 100) {
				if (person[row][col].getGreen()	> person[row][col].getBlue() 
						&& person[row][col].getGreen() > person[row][col].getRed()) {
					fromPixel = background[row][col];
					toPixel = person[row][col];
					toPixel.setColor(fromPixel.getColor());
				}
//				if (person[row][col].colorDistance(Color.GREEN) < 40) {
//					person[row][col] = background[row][col]; 
				}
			}
		}
		
		
		
		
		
		//there is some variation in the color black (don't assume that green ius exactly one value. Go look for how you adjust fo
		//r nearness. 
		//they all appear black 
		//same thing for anycolor 
		//for setgonagraphy, focus on the red values. There is an easy transition in numbers for the red (the beach example) 
		//
		//the second picture does not have the smoothness 
		//the right picture has no odd numbers 
		//changed all the pictures that if it had an odd red, it would change it to have an even red 
	
		//MR SCARPITTA SAID THAT FOR ENCODE YOU CHANGE EVERYTHING TO RED EXCEPT FOR THE ONES WHERE THE MESSAGE IS ENCODED
	
		//cahnged the new reds to even reds 
		//the only odd reds are the ones that are encoded with the message 
		//your decode is going to take this new picture and its going to make a new picture decode 
		// has to look not neat 1
		//Wednesday *need to have all methods working*
		//White is always 255, 255, 255 
		//there should be four pictures  for one normal, one message, one encoeed picture, and one decodd picture 

//	public void encode(Picture message) {
//		Pixel[][] chemplant = this.getPixels2D(); 
//		Pixel[][] mes = message.getPixels2D(); 
//		Pixel fromPixel = null;
//		Pixel toPixel = null; 
//		Pixel red = null; 
//		for (int row = 0; row < chemplant.length; row++) {
//			for (int col = 0; col < chemplant[0].length; col++) {
//				if (chemplant[row][col].getRed() % 2 == 0) { //we need to make sure that all of them are odd like mr s said
//					red = chemplant[row][col]; 
//					red.setRed(red.getRed() + 1);
//				}
//			}
//		}
//		for (int row = 0; row < mes.length; row++) {
//			for (int col = 0; col < mes[0].length; col++) {
//				if (mes[row][col].getColor().equals(Color.BLACK)) {
//					fromPixel = mes[row][col]; 
//					toPixel = chemplant[row][col]; 
//					
//					toPixel.setRed(toPixel.getRed() + 1); //we do this to make them even like mr s said for the ones with the message
//				}
//			}
//		} 
//		
//	
//	}
	
	  public void encode(Picture sentence) {
		  
			 Pixel[][] chemplant = this.getPixels2D();
			 Pixel[][] message = sentence.getPixels2D();

			 for (int row = 0; row < chemplant.length; row++) {
				 for (int col = 0; col < chemplant[0].length; col++) {
					 int red = chemplant[row][col].getRed();
					 if (message[row][col].getBlue() < 50) {
						 if (red % 2 == 1)
							chemplant[row][col].setRed(red+1);
					 }
					 else {
						 if (red % 2 == 0) {
							 chemplant[row][col].setRed(red+1); 
						 }
						 
					 }
				 }
			 }
		  }

//	
	public void decode() {
		
		Pixel[][] chemplant = this.getPixels2D(); 
		for (int row = 0; row < chemplant.length; row++) {
			for (int col = 0; col < chemplant[0].length; col++) {
				if (chemplant[row][col].getRed() % 2 == 0) { //we are searching again for which ones are even which means that they have the encoded message
                    chemplant[row][col].setColor(Color.BLACK); 
                    
				}
				else {
					chemplant[row][col].setColor(Color.WHITE);
				}
			}
		}
		
		
	
		
	}
	
	public void custom(Picture arrow) {
		Pixel[][] background = this.getPixels2D(); 
		Pixel[][] person = arrow.getPixels2D(); 
		Pixel leftPixel = null; 
		Pixel rightPixel = null; 
		
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
		
	}
	
	
	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();

	}

} // this } is the end of class Picture, put all new methods before this
