// both Loadable and StillImage
public class LoadableImage implements Loadable, StillImage {
    private int[][] pixelInput;
    // Default construct=or
    public LoadableImage() {}
    
    // Over-load constructor
    public LoadableImage(int w, int h) {
        this.pixelInput = new int[h][w];
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

    // throw a LoadException if no width/height 
        //or there isn't enough pixel data
        // or pixel data out of bound (0-999)
    // if ok, construct new LoadableImage with dimenions
    public LoadableImage load(int[] data) throws LoadException {
        int notQualify=0;
        int i=0;
        for (int a=0; a<=this.h; a++) {
            for (int b=0; b<=this.w; b++) {
                this.pixelInput[h][w]=data[i];
                i++;
            }
        }
        // no width or height
        if (data.length<3) {throw new LoadException();
        }
        else {
            for (int x: data) {
                if (x<0 || x>999) {
                    throw new LoadException();
                    notQualify++;}
            }
            if (notQualify<1) {
                if (data.length-3==data[0]*data[1]) {
                    this.w=data[1];
                    this.h=data[2];
                    this.pixelInput=data;
                    LoadableImage newImg = new LoadableImage(data[1], data[2]);
                    return newImg;
                }
                else {throw new LoadException();}
            }
        }
    }
    

    // return width of the loaded image, in pixels 
    // no specific behavior if this is called without loading an image first
    public int width() {
        try{
            return this.w;
        }
        catch (LoadException e) {}
    }

    // same as width() but return height
    public int height() {
        try {
            return this.h;
        }
        catch (LoadException e) {}
    }

    // return pixel at coordinate (x,y)
    // If ask for out of bounds, throw exception
    // no specific behavior if this is called without loading an image first
    public int getPixel(int x, int y) {
        // FIXME: if out of bound
        try {
            return this.pixelInput[x][y];
        }
        catch (LoadException e) {}
    }

}