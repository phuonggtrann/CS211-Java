/** 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar P3tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  javac -cp .;junit-cs211.jar *.java         # compile everything
 *  java -cp .;junit-cs211.jar P3tester        # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class P3tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("P3tester");
  }
  
  @Test public void loadexception_exists() {
    LoadException le = new LoadException("test");
    assertTrue("LoadException must be a type of Exception", le instanceof Exception);
    assertEquals("LoadException should initialize Exception's message", "test", le.getMessage());
  }

  private class DummyStillImage implements StillImage, Loadable {
    public int width() { return 0; }
    public int height() { return 0; }
    public int getPixel(int x, int y) { return 0; }
    public boolean matches(int[] data) { return false; }
    public Loadable load(int[] data) { return null; }
  }
  
  private class DummyAudioStream implements AudioStream, Loadable {
    public int freq() { return 0; }
    public int next() { return 0; }
    public boolean hasNext() { return false; }
    public boolean matches(int[] data) { return false; }
    public Loadable load(int[] data) { return null; }
  }
  
  private class DummyImageViewer extends ImageViewer {
    public boolean test = false;
    public void view(StillImage img) { test = true; }
  }
  
  private class DummyAudioPlayer extends AudioPlayer {
    public boolean test = false;
    public void playback(AudioStream aud) { test = true; }
  }
  
  @Test(timeout=1000) public void audioplayer_exists() {
    AudioPlayer ap = new DummyAudioPlayer();
    assertTrue("AudioPlayer should be a Player", ap instanceof Player);

    DummyAudioStream a = new DummyAudioStream();
    ap.playback(a);
 
    assertTrue("AudioPlayer should know how to play audio", ap.canPlay(a));
    assertFalse("AudioPlayer would not know how to play images", ap.canPlay(new DummyStillImage()));

    DummyAudioPlayer da = new DummyAudioPlayer();
    da.play(a);  // sets da.test if playback() is called
    assertTrue("AudioPlayer.play() should call playback()", da.test);
  }

  @Test(timeout=1000) public void imageviewer_exists() {
    ImageViewer ap = new DummyImageViewer();
    assertTrue("ImageViewer should be a Player", ap instanceof Player);

    DummyStillImage a = new DummyStillImage();
    ap.view(a);
 
    assertTrue("ImageViewer should know how to view images", ap.canPlay(a));
    assertFalse("ImageViewer would not know how to play audio", ap.canPlay(new DummyAudioStream()));

    DummyImageViewer da = new DummyImageViewer();
    da.play(a);  // sets da.test if playback() is called
    assertTrue("ImageViewer.play() should call view()", da.test);
  }
  
  private int[] goodImg1 = {55, 3, 4, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
  private int[][] goodImg1Validate = { {0, 3, 6, 9}, {1, 4, 7, 10}, {2, 5, 8, 11} };
  private int[] goodImg2 = {55, 4, 2, 2, 2, 3, 2, 4, 2, 5, 2};
  private int[][] goodImg2Validate = { {2, 4}, {2, 2}, {3, 5}, {2, 2} };
  private int[] badImg1 = {10, 2, 3, 1, 2, 3, 4, 5, 6};
  private int[] badImg2 = {55, 1};
  private int[] badImg3 = {55, 1, 1};
  private int[] badImg4 = {55, 1, 1, 1, 1};
  private int[] badImg5 = {55, 1, 1, 1000};
  private int[] badImg6 = {55, 1, 1, -1};
  private int[] badImg7 = {55};
  
  private void loadImageTestCase(LoadableImage img, int[] array, int[][] validate) {
    String errMsg = String.format("Incorrect width for %s", Arrays.toString(array));
    assertEquals(errMsg, validate.length, img.width());
    errMsg = String.format("Incorrect height for %s", Arrays.toString(array));
    assertEquals(errMsg, validate[0].length, img.height());
    for (int x = 0;  x < validate.length;  x++) {
      for (int y = 0;  y < validate[0].length;  y++) {
        errMsg = String.format("Incorrect pixel at (%d, %d) of %s", x, y, Arrays.toString(array));
        assertEquals(errMsg, validate[x][y], img.getPixel(x, y));
      }
    }
  }
  
  @Test(timeout=1000) public void loadableimage_load() throws Exception {
    LoadableImage loader = new LoadableImage();
    String errMsg = String.format("Any input image which begins with a 55 should be loadable: %s", Arrays.toString(badImg7));
    assertTrue(errMsg, loader.matches(badImg7));
    errMsg = String.format("Any input image which begins with a 55 should be loadable: %s", Arrays.toString(goodImg1));
    assertTrue(errMsg, loader.matches(goodImg1));
    errMsg = String.format("Any input image which does not begin with a 55 should not be loadable: %s", Arrays.toString(badImg1));
    assertFalse(errMsg, loader.matches(badImg1));
    
    LoadableImage img1 = loader.load(goodImg1);
    LoadableImage img2 = loader.load(goodImg2);
    loadImageTestCase(img1, goodImg1, goodImg1Validate);
    loadImageTestCase(img2, goodImg2, goodImg2Validate);
  
  }
  
  @Test(timeout=1000) public void loadableimage_loadfail() {
    LoadableImage loader = new LoadableImage();
    try { 
      loader.load(badImg7);
      fail("LoadableImage loader requires width and height");
    } catch (LoadException e) {}
    try { 
      loader.load(badImg2);
      fail("LoadableImage loader requires width and height");
    } catch (LoadException e) {}
    try { 
      loader.load(badImg3);
      fail("LoadableImage loader requires that dimensions match data size");
    } catch (LoadException e) {}
    try { 
      loader.load(badImg4);
      fail("LoadableImage loader requires that dimensions match data size");
    } catch (LoadException e) {}
    try { 
      loader.load(badImg5);
      fail("LoadableImage loader requires numbers between 0 and 999");
    } catch (LoadException e) {}
    try { 
      loader.load(badImg6);
      fail("LoadableImage loader requires numbers between 0 and 999");
    } catch (LoadException e) {}
  }

  private int[] badAud1 = {1,2,3};
  private int[] badAud2 = {3,2};
  private int[] badAud3 = {3,2,1};
  private int[] badAud4 = {3,2,1,10,1000};
  private int[] badAud5 = {3,2,1,10,-1000};
  private int[] goodAud1 = {3,2,1,100,0,1,2,3,4,6,7};
  private int[] goodAud2 = {3,2,1,1000,2,1,0,-1,-2};
  
  private void loadAudioTestCase(LoadableAudio aud, int[] array) {
    String errMsg = String.format("Incorrect frequency for %s", Arrays.toString(array));
    assertEquals(errMsg, array[3], aud.freq());
    for (int i = 4;  i < array.length;  i++) {
        errMsg = String.format("Premature finish before index %d of %s", i, Arrays.toString(array));
        assertTrue(errMsg, aud.hasNext());
        errMsg = String.format("Incorrect amplitude at index %d of %s", i, Arrays.toString(array));
        assertEquals(errMsg, array[i], aud.next());
    }
    errMsg = String.format("Finish not indicated at the end of %s", Arrays.toString(array));
    assertFalse(errMsg, aud.hasNext());
  }
  
  @Test(timeout=1000) public void loadableaudio_load() throws Exception {
    LoadableAudio loader = new LoadableAudio();
    String errMsg = String.format("Any input audio which begins with a 3,2,1 should be loadable: %s", Arrays.toString(badAud3));
    assertTrue(errMsg, loader.matches(badAud3));
    errMsg = String.format("Any input audio which begins with a 3,2,1 should be loadable: %s", Arrays.toString(goodAud1));
    assertTrue(errMsg, loader.matches(goodAud1));
    errMsg = String.format("Any input image which does not begin with a 3,2,1 should not be loadable: %s", Arrays.toString(badAud1));
    assertFalse(errMsg, loader.matches(badAud1));
    
    LoadableAudio aud1 = loader.load(goodAud1);
    LoadableAudio aud2 = loader.load(goodAud2);
    loadAudioTestCase(aud1, goodAud1);
    loadAudioTestCase(aud2, goodAud2);
  }
  
  @Test(timeout=1000) public void loadableaudio_loadfail() {
    LoadableAudio loader = new LoadableAudio();
    try { 
      loader.load(badAud3);
      fail("LoadableAudio loader requires frequency");
    } catch (LoadException e) {}
    try { 
      loader.load(badAud4);
      fail("LoadableAudio loader requires values between -999 and 999");
    } catch (LoadException e) {}
    try { 
      loader.load(badAud5);
      fail("LoadableAudio loader requires values between -999 and 999");
    } catch (LoadException e) {}
  }
  
  private int[] imgView = {55, 3, 4, 0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 999, 1};
  private String imgRes = "  .\n.oo\nOO@\n@@ \n";
  
  @Test(timeout=1000) public void textimageviewer_test() throws Exception {
    ImageViewer v = new TextImageViewer();
    setCapture();
    LoadableImage li = new LoadableImage().load(imgView);
    v.view(li); 
    String actual = getCapture();
    String expected = imgRes;
    assertEquals(expected, actual);
    unsetCapture();  
  }
  
  private int[] audPlay = {3,2,1,100,-999, -777, -333, 0, 333, 777, 999};
  private String audRes = "*\n"+
    "       *\n"+
    "                       *\n"+
    "                                   *\n"+
    "                                              *\n"+
    "                                                              *\n"+
    "                                                                     *\n";

  @Test(timeout=1000) public void textaudioplayer_test() throws Exception {
    AudioPlayer p = new TextAudioPlayer();
    setCapture();
    LoadableAudio la = new LoadableAudio().load(audPlay);
    p.playback(la); 
    String actual = getCapture();
    String expected = audRes;
    assertEquals(expected, actual);
    unsetCapture();  
  }
  
  private void testPlayer(MultimediaPlayer mp, int[] data, String expected) throws Exception {
    String input = Arrays.toString(data);
    String errMsg = String.format("player should recognize %s", input);
    assertTrue(errMsg, mp.matches(data));
    Loadable l = mp.load(data);
    errMsg = String.format("player should be able to play %s", input);
    assertTrue(errMsg, mp.canPlay(l));
    setCapture();
    mp.play(l);
    String actual = getCapture();
    errMsg = String.format("player incorrectly played input %s", input);
    assertEquals(errMsg, expected, actual);
    unsetCapture();
  }
  
  @Test(timeout=2000) public void multimediaplayer_test() throws Exception {
    MultimediaPlayer mp = new MultimediaPlayer();
    String errMsg = String.format("player should not recognize %s", Arrays.toString(badImg1));
    assertFalse(errMsg, mp.matches(badImg1));
    errMsg = String.format("player should not recognize %s", Arrays.toString(badAud1));
    assertFalse(errMsg, mp.matches(badAud1));
    testPlayer(mp, imgView, imgRes);
    testPlayer(mp, audPlay, audRes);
    setCapture();
    mp.play("johnson_center.txt");
    String actual = getCapture();
    String expected = imgOutput;
    unsetCapture();
    assertEquals("incorrect output playing back file johnson_center.txt", expected, actual);
  }
  
  @Test public void multimediaplayer_read() throws Exception {
    MultimediaPlayer mp = new MultimediaPlayer();
    try {
      mp.read("badfile.txt");
      fail("player should throw an exception when trying to read a badly-formed file (which contains non-numbers)");
    }
    catch (LoadException e) {}
    int[] actual = mp.read("goodfile.txt");
    int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    assertArrayEquals("player's read method produced an incorrect data array", expected, actual);
  }                                          
  
  private String imgOutput = "ooooooo.oooo.oOoOOOOOOoOOoOOoOOOO@OO@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"+ 
"ooOOoOOOOoOOOoooOOO@OOOOOOOOOOOOOOO@@OO@@@@@@@@@@@@@@@@@@@@@@@@@\n"+
"OOOOoOOOOoooOOOoOO@@@@@@@@@@OOOO@OOOOO@@@@@@@@@@@@@@@@@@@@@@@@@@\n"+
"OOOOOOOOOOOoOOooOO@@@@@@@@@@@@OOOOOOOO@O@@@@@@@@@@@@@@@@@@@@@@@@\n"+ 
"OOOOOoOOOOOOOO@@@O@@@@@@@@@@@@@OOOO@OO@@@@@@@@@@@@@@@@@@@@@@@@@@\n"+ 
"OOOOOOOOOOOOO@@@OOOOOOOOOO@@@O@@@@OOOOO@@@@@@@@@@@@@@@@@@@@@@@@@\n"+ 
"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO@@@@OOOOOO@@@@@@@@@@@@@@@@@@@@@@@\n"+ 
"@OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO@@@@@OO@OOO@@@@@@@@@@@@@@@@@@@@@@\n"+ 
"@OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO@@@@O@OO@@@OO@@@@@@O@@@@@@@@@@@@@\n"+ 
"o..ooooOOOOOOOOOOOOOoOOOOOOOOOO@@@@OO@O@O@@@@@@@@OOOO@@@@@@@@@@@\n"+ 
"...oooooooOOOoooOOOo.o.o.o.o.OO@@@@@O@@OO@@@O@@@@OOOO@@O@@@@@@@@\n"+ 
"....ooooooooOoooOOOooooooo.o.OO@oo@OooooooOO@@@@@OOOO@@@@@@@@@@@\n"+ 
"...ooooo.oooooooOOOo.o.....o.OO@Oo@ooo.o.ooooO@@@OOOO@@@@@@@@@@@\n"+ 
"...ooooooooooooooOOo.o.....o.OO@oo@o..o..ooooooOO@OOO@@@@@@@@@@@\n"+ 
"...ooooo.ooooooooOOo.o.....o.OO@oo@.o....oooooooooOOOO@@@@@@@@@@\n"+ 
"....ooooooooooooOOOo.o.......OO@oo@......oooooooooooOO@@@@@@@@@@\n"+ 
"....oo...o.oooooOOOo o.......OO@oo@......oooooooOooooooO@@@@@@@@\n"+ 
".o..oooooo.ooooooOOooo.....ooOO@oo@......oooooooooooooooooO@@@@@\n"+ 
".o.o.o...ooooooooOOo.o.o.o...OO@OO@......oooooooooooooooooooO@@@\n"+ 
"...o..oo...ooooooOOooooooooooOO@oo@......ooooooooooooooooOooOoOO\n"+ 
"...oo.oo.o.oooooOOOo.o.....o.OO@OO@......ooooooooooooooooOoooooo\n"+ 
".........o.oooooOOOooooooooooOO@oo@......ooooooooooooooooooooooo\n"+ 
".........ooooooooOOo.o.o.o.o.OO@OO@......oooooooooooooooooooOOoo\n"+ 
".........oooooooOOOooooooooo.OO@Oo@......ooooooooooooooooooooooo\n"+ 
".........ooooo..oOOo.......ooOO@OO@......ooooooooooooooooooooooo\n"+ 
"........ooooooo.oOOo.o.....o.OO@oo@......ooooooooooooooooooooooo\n"+ 
".........o.ooo.oooOo.........OO@oo@......ooooooooooooooooooooooo\n"+ 
".........o.ooo.ooOOo.......o.OO@oo@......ooooooooooooooooooooooo\n"+ 
"...........o.oo.ooO..o.....o.OO@oo@......ooooooooooooooooooooooo\n"+ 
"............ooo.oOOooooo.o.o.OO@oo@......ooooooooooooooooooooooo\n"+ 
"............o..oooOo.......o.OO@OO@......oooooo.oooooooooooooooo\n"+ 
"............oooooOOooooooooooOO@Oo@......ooooo..oooooooooooooooo\n"+ 
"............oooooooOOOOOOOOOOOO@@@@......ooooo. oooooooooooooooo\n"+ 
"............oooooooOOOOOOOOOOOO@@@@......o.o.....ooooooooooooooo\n"+ 
"..... ......ooooooOOOOOOOOOOOOO@@@@........... ..ooooooooooooooo\n"+ 
"..... ......o.o.ooOooooooooooOO@oO@........... . ...oooooooooooo\n"+ 
" ...........oo..ooO.........oOO@oO@.........o....ooooooooooooooo\n"+ 
"............oo..oOO........o.OO@OO@....... ..   ..Ooooooooo.oooo\n"+ 
"........ . .oo..oOO. ........OO@OO@...........  . oOOo.oo.. .ooo\n"+ 
"....   . . oOo .OOO. .. .....OO@OO@..oo...o. .    oooo....   o.o\n"+ 
"....     . oOo .OOO. .. . .ooOO@OO@...oo.oo.   . ..oo.....  .o..\n"+ 
"...........ooo..oOO. .. . .ooOO@OO@.. o..oo..... ...o....   .o .\n"+ 
".oOOOOooooo...OOoooo .. . .  ooOo.o.. ...ooo...ooO..o....  . . .\n"+ 
".....oo.OOOo..OOoOOO..... ........ooo ..o......ooO..o.oo   . . .\n"+ 
"oOo.Oo...ooo.....ooo..o.o.o.......oo...........ooo.o.... . ... .\n"+ 
"oOooOooO.oOoOOo...OOo...oooOoo.................o.Oo.oo.. . .o. O\n"+ 
"OO@OOOOOOOooooOOoOOOOOOO@@@O@OOOOO.............o.oo....... .o..o\n"+ 
"oOOOOOoOOOoOOO@@OOoO@@@@@@@OOOO@OOOOOO.ooOoooo..oooooo.oo.. ...o\n"+ 
"OOOOOOOOOOOO@@OOOO@@@@@O@@@OO@@@OoO@@@o@@@@@@@@@@@@@@@@@@@@oOo.@\n"+ 
"ooooo.ooOOOOOoOOoooooooOOoooOOOOOooOOOooO@@O@@O@@@@@@@@@@@@oOoo@\n"+ 
"o.ooooooOOOOOOOooooooooooooooo.oooooooOOOOOooooooOo.ooooooo.OooO\n"+ 
"oooOoo.oOOOOOOoooOOOOOOOOOoOOoOOoooooooOOOoooooOOOOOoOOoooooO..o\n"+ 
".o..oo.oOOOOOOoooooOOOOOooooOOOOoooooOooooOooooOOOOOoOooooooO..o\n"+ 
".oo....ooOOOooo.ooooOOOooooooOooooOoooOooooooooOOoOOOooooOOoO..o\n"+ 
".oo...oOOOooooo.oooooOoooooooOoooOoooooooooOooooOOOOooooooooo..o\n"+ 
"...o..ooooooooOOoooooooOooooOoooooooooooooOOoooooOooooooooOooooo\n"+ 
".....oo.ooO...OOOoo.oOoooooooo.oooo.oooooOOOoooooooooooooooooooo\n"+ 
"...oooo.o.oo..oooO...ooooooOoo.oooo.ooooooOooooooooooooooooooo.o\n"+ 
"..o.oo..o.ooooooOo.o.oo.oooOoo..oo....ooo.Oooooo.ooooooooooooooo\n"+ 
"...oo..ooo.oo..ooo..ooo...Ooooo.oo.o.ooo..oooooooOOooo..oo.ooooo\n"+ 
"o.oo..ooOoooO...ooo.ooo..oooo.o..ooo..ooo..oooo.oOOOoo....ooo...\n"+ 
"o.oooo.ooOOo..ooo.oo..o..oOo..ooo.oo.ooo..ooooooOoOO@O.oo.ooo.o.\n"+ 
"oOOo..oo.ooo...oo..o..o..ooo..oo..oo.oo.oooo.o.oOOOOO@oOoo..o...\n"+ 
"oooooo....o..oo..ooooo...oooo.o...o..o.ooo.o.oooOooOOOOOoooooooo\n";

    /** the lines below are for setting up input/output redirection so that the
    * tests can see what is being set to the screen as well as produce its own
    * pseudo-keyboard input.  No test appear below here. */
  
  static ByteArrayOutputStream localOut, localErr;
  static PrintStream sOut, sErr;

  @BeforeClass public static void setup() throws Exception {
    sOut = System.out;
    sErr = System.err;
  }
  
  @AfterClass public static void cleanup() throws Exception {
    unsetCapture();
  }
  
  private static void setCapture() {
   localOut = new ByteArrayOutputStream();
   localErr = new ByteArrayOutputStream();
   System.setOut(new PrintStream( localOut ) );
   System.setErr(new PrintStream( localErr ) );
  }

  private static String getCapture() {
   return localOut.toString().replaceAll("\\r?\\n", "\n");
  }

  private static void unsetCapture() {
   System.setOut( null );
   System.setOut( sOut );
   System.setErr( null );
   System.setErr( sErr );
  }
  
  
}