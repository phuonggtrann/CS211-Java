// both Loadable and StillImage
public class LoadableImage implements Loadable, StillImage {
    private int[][] pixelInput;
    private int w;
    private int h;
    // Default constructor
    public LoadableImage() {
      this.w=0;
      this.h=0;
    }
    
    // Over-load constructor
    public LoadableImage(int w, int h) {
        this.w=w;
        this.h=h;
    }
    
    // return true if the first element is 55
    // false if it's not or there's no first element
    public boolean matches(int[] data) {
        boolean isMatch = false;
        if (data.length<1) {isMatch=false;}
        else {
            if (data[0]==55) {isMatch=true;}
            else {isMatch=false;}
        }
        return isMatch;
    }
    private void setPixelInput(int[][] pixelInput){
      this.pixelInput=pixelInput;
    }

    // throw a LoadException if no width/height 
        //or there isn't enough pixel data
        // or pixel data out of bound (0-999)
    // if ok, construct new LoadableImage with dimenions
    public LoadableImage load(int[] data) throws LoadException {
      LoadableImage loaded=null;
      try{
        if (data.length<3){
          throw new LoadException("There is no width or height");
      }
        else if(data.length<(this.h*this.w+3)||data.length>(this.h*this.w+3) ){
          throw new LoadException ("Data mismatch");
        }else  {
          for (int i=0; i< data.length; i++){
            if(data[i]<0 || data[i]>999){
             throw new LoadException ("pixel value out of range");
            }
          }
          loaded= new LoadableImage(data[2], data[1]);
          int dataCounter=0;
          int [][] temp= new int[data[2]][data[1]];
          for(int i=0; i<data[2];i++){
            for(int z=0; z<data[1];z++){
              temp[i][z]=data[dataCounter];
              dataCounter++;
            }
          }
          loaded.setPixelInput(temp);
        }
      }catch(LoadException e){
        System.out.println(e);
      }
      return loaded;
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
      int value=0;
        try{
          value= this.pixelInput[x][y];
        }
        catch(IndexOutOfBoundsException e){ // if out of bounds 
          System.out.println(e);
        }
        return value;
    }
}