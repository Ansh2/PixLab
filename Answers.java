
public class Answers {

	//A1: Introduction to digital pictures and color 
	
	/*
	 
	 
 		Questions: 
 		
 		1. How many bits does it take to represent values from 0 to 225? 
 		
 		11111111  =   8 bits
 		
 		2. How many bytes does it take to represent a color in the RGB color model? 
 		
 		3 bytes
 		
 		3. How many pixels are in a picture that is 640 pixels wide and 480 pixels high? 
 		
 		307,200 pixels are in that picture. 
 		 

	 */
	
	//A2: Picking a Color 
	
	/*
	 
	 Questions: 
	 1. How can you make pink? 
	    
	    [r=255,g=0,b=255]
	    
	 2. How can you make yellow? 
	 
	 	[r=255,g=255,b=0]
	 
	 3. How can you make purple? 
	 
	 	[r=190,g=0,b=255]
	 
	 4. How can you make white? 
	 
	 	[r=225,g=225,b=255]
	 
	 5. How can you make dark gray? 
	 
	 	[r=102,g=102,b=102]
	 
	 */

	//A3: Exploring a picture 
	
	/* 
	 
	 Questions: 
	 
	 1. What is the row index for the top left corner of the picture? 
	 
	 Row: 0 
	 
	 2. What is the column index for the top left corner of the picture? 
	 
	 Column: 0 
	 
	 3. The width of this picture is 640. What is the right most column index? 
	 
	 Column: 639
	 
	 
	 4. The height of this picture is 480. What is the bottom most row index? 
	 
	 Row: 479
	 
	 5. Does the row index increase from left to right or top to bottom? 
	 
	 "top to bottom"
	 
	 6. Does the column index increase from left to right or top to bottom?  
	 
	 "left to right" 
	 
	 7. Set the zoom to 500%. Can you see squares of color? This is called pixelation. 
	    Pixelation means displaying a picture so magnified that the individual pictures looks 
	    like small squares. 
	    
	    Yes. Moreover, the image is blurry due to the pixelation as you see small squares 
	    in the picture. 

	 
	 EXERCISES: 
	 
	 1. Done 
	 2. DONE (Check again) 
	 
		 
	 
	  	 
	 */
	
	//A4: Two-dimensional arrays in Java
		
	/*
	 
	 Exercises: 
	 
  		Done with exercises 1, 2, and 3; 
	 
	 
	 
	 */

	//A5: Modifying a picture 
	
	
	/*
	 
	 Questions: 
	 
	 1. Open Picture.java and look for the method getPixels2D. Is it there?
	 
	 No, but the method is being called. 
	 
	2. Open SimplePicture.java and look for the method getPixels2D. Is it there?
	
	Yes, there is a method in this class. 
	
	
	3. Does the following code compile?
		DigitalPicture p = new DigitalPicture();
		
		No
		
		
	4. Assuming that a no-argument constructor exists for SimplePicture, would the following
		code compile?
		DigitalPicture p = new SimplePicture();

		Yes 


	5. Assuming that a no-argument constructor exists for Picture, does the following code
		compile?
		DigitalPicture p = new Picture();

		Yes 

	6. Assuming that a no-argument constructor exists for Picture, does the following code
		compile?
		SimplePicture p = new Picture();

		Yes


	7. Assuming that a no-argument constructor exists for SimplePicture, does the following
		code compile?
		Picture p = new SimplePicture();
	 					(after the new keyword is the type of the object). ***IMPORTANT***
	    No 
	 
	
	Exercises: 
	1. Done
	2. Done
	3. Done 
	4. Done
	5. Done
	6. DONE
	

	 */
	
	//A6: Mirroring Pictures
	/*

	Exercises: 
	1. Done 
	2. Done
	3. Done 
	4. Done (but need to understand the logic behind it (CHALLENGE)); 

	 */
	
	//A7: Mirroring part of a picture
	
	/*

	Questions:
1. How many times would the body of this nested for loop execute?
	for (int row = 7; row < 17; row++)
		for (int col = 6; col < 15; col++)
	
	16 - 7 + 1 = 10 
	14 - 6 + 1 = 9
	
	90 times
	
2. How many times would the body of this nested for loop execute?
	for (int row = 5; row <= 11; row++)
		for (int col = 3; col <= 18; col++)
	
	11 - 5 + 1 = 7 
	18 - 3 + 1 = 16 
	
	112 times 


	Exercises: 
	1. DONE
	2. DONE, but need to check
	3. DONE, but need to check
	 */
	
	//A8 | Creating a collage 
	
	/*
	Exercises: 
	1. DONE, but do not know how to add static method for just copy2 method
	2. DONE

	 */
	
	//A9 | Simple edge detection 
	
	/*
	Exercises: 
	1. DONE
	2. need to do with Showrya
	 */
	
}
