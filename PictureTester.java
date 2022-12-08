/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  //Tester for Exercise 3 | A5 
  
  public static void testKeepBlueOnly() {
	  Picture caterpillar = new Picture("caterpillar.jpg"); 
	  caterpillar.keepBlueOnly(); 
	  caterpillar.explore(); 
  }
  
  //Tester for Exercise 4 | A5 
  
  public static void testNegate() {
	  Picture flower1 = new Picture("flower1.jpg"); 
	  flower1.negate(); 
	  flower1.explore();
  }
  
  //Tester for Exercise 5 | A5 
  
  public static void testGrayscale() {
	  Picture beach = new Picture("beach.jpg"); 
	  beach.grayscale(); 
	  beach.explore();
  }
  
  //Tester for Exercise 6 | A5

  public static void testFixUnderwater() {
	  Picture water = new Picture("water.jpg"); 
	  water.explore(); 
	  water.fixUnderwater(); 
	  water.explore(); 
	  
  }
  
  //Tester for Exercise 1 | A6
  
  public static void testMirrorVerticalRightToLeft() {
	  Picture caterpillar = new Picture ("caterpillar.jpg"); 
	  caterpillar.explore(); 
	  caterpillar.mirrorVerticalRightToLeft();
	  caterpillar.explore(); 
  }
  
  //Tester for Exercise 2 | A6 
  
  public static void testMirrorHorizontal() {
	  Picture redMotorcycle = new Picture("redMotorcycle.jpg"); 
	  redMotorcycle.explore(); 
	  redMotorcycle.mirrorHorizontal(); 
	  redMotorcycle.explore(); 
  }
  
  //Tester for Exercise 3 | A6  
  
  public static void testMirrorHorizontalBotToTop() {
	  Picture redMotorcycle = new Picture("redMotorcycle.jpg"); 
	  redMotorcycle.explore(); 
	  redMotorcycle.mirrorHorizontalBotToTop(); 
	  redMotorcycle.explore(); 
  }
  
  //Tester for Exercise 4 | A6 CHALLENGE
  
  public static void testMirrorDiagonal() {
	  Picture beach = new Picture("beach.jpg"); 
	  beach.explore(); 
	  beach.mirrorDiagonal();
	  beach.explore(); 
  }
  
  //Tester for Exercise 2 | A7 
  
  public static void testMirrorArms() {
	  Picture snowman = new Picture("snowman.jpg"); 
	  snowman.explore(); 
	  snowman.mirrorArms(); 
	  snowman.explore(); 
  }
  
  //Tester for Exercise 3 | A7 
  
  public static void testMirrorGull() {
	  Picture seagull = new Picture("seagull.jpg"); 
	  seagull.explore();
	  seagull.mirrorGull(); 
	  seagull.explore(); 
	  
  }
  
  //Tester for Exercise 1 & 2| A8 
  
  public static void testMyCollage() {
	  Picture canvas = new Picture("640x480.jpg");
	  canvas.myCollage();
	  canvas.explore();
  }
  
  //Tester for Exercise 1 | A9
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  //first method
  
  public static void testChromakey() {
	  
	  Picture endgame = new Picture("background1.jpg"); //background
	  Picture greenarrow = new Picture("arrow.jpg"); //person
	  endgame.explore(); 
	  greenarrow.explore(); 
	  greenarrow.chromakey(endgame);
	  greenarrow.explore(); 
  }
  
  //second method 
  
  public static void testSteganography() {
	  Picture message = new Picture("message.jpg"); 
	  Picture chemplant = new Picture("chemplant.jpg");
	  chemplant.explore(); 
	  message.explore(); 
	
	  chemplant.encode(message);
	  chemplant.explore(); 
	  chemplant.decode(); 
	  chemplant.explore(); 
	  
  }
  public static void testCustom(){
	  Picture willy = new Picture("willy.jpg"); 
	  Picture arrow = new Picture("arrow.jpg"); 
	  
	  willy.explore(); 
	  arrow.explore(); 
	  
	  
  }
  
  
  
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//    testZeroBlue();
    //testKeepOnlyBlue();
//    testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
//    testGrayscale();
//	  testChromakey();
	  testSteganography(); 
//	  testCustom(); 
//    testFixUnderwater();
//    testMirrorVertical();
//    testMirrorVerticalRightToLeft(); 
//    testMirrorHorizontal(); 
//    testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
//    testMirrorGull();
//    testMirrorDiagonal();
//    testCollage();
//    testMyCollage();
//    testCopy();
//    testEdgeDetection();
//    testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}