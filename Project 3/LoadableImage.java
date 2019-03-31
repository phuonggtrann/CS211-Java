// both Loadable and StillImage
public class LoadableImage implements Loadable, StillImage { // implements the interaces 
  private int[][] pixelInput; // delcare 2d array
  // declare variable for image's size 
  private int w;
  private int h;

  // Default constructor
  public LoadableImage() {
    this.w = 0;
    this.h = 0;
  }

  // Over-load constructor
  public LoadableImage(int w, int h) {
    this.h = h;
    this.w = w;
  }

  // return true if the first element is 55
  // false if it's not or there's no first element
  public boolean matches(int[] data) {
    boolean isMatch = false;
    if (data.length < 1) { // if array is empty
      isMatch = false;
    } else {
      if (data[0] == 55) { // only true if index 0 euqal 55
        isMatch = true;
      } else {
        isMatch = false;
      }
    }
    return isMatch; // return answer 
  }
  
  // self declared void method to create internal array
  private void setPixelInput(int[] data) {
    int counter = 3; // 0,1,2 index is the information about the image, doesn't count
    // initialize 2d array
    this.pixelInput = new int[data[2]][data[1]];
    // Load the pixel data into array
    for (int a = 0; a < data[2]; a++) {
      for (int b = 0; b < data[1]; b++) {
        this.pixelInput[a][b] = data[counter];
        counter++;
      }
    }
  }

  // throw a LoadException if no width/height
  // or there isn't enough pixel data
  // or pixel data out of bound (0-999)
  // if ok, construct new LoadableImage with dimenions
  public LoadableImage load(int[] data) throws LoadException {
    if (data.length < 3) {
      throw new LoadException("There is no width or height");
    } else {
      if (data.length < (data[1] * data[2] + 3) || data.length > (data[1] * data[2] + 3)) {
        throw new LoadException("Data mismatch");
      } else {
        for (int i : data) {
          if (i < 0 || i > 999) {
            throw new LoadException("pixel value out of range");
          }
        }
      }
      // create new LoadableImage and initialize width and height
      LoadableImage img = new LoadableImage(data[1], data[2]);
      // this.w = data[1];
      // this.h = data[2];
      img.setPixelInput(data);
      return img;
    }

  }

  // return width of the loaded image, in pixels
  // no specific behavior if this is called without loading an image first
  public int width() {
    return this.w;
  }

  // same as width() but return height
  public int height() {
    return this.h;
  }

  // return pixel at coordinate (x,y)
  // If ask for out of bounds, throw exception
  // no specific behavior if this is called without loading an image first
  public int getPixel(int x, int y) {
    int value = 0;
    try {
      value = this.pixelInput[y][x];
    } catch (IndexOutOfBoundsException e) { // if out of bounds

    }
    return value;
  }
}
