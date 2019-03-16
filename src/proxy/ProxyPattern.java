package proxy;

public class ProxyPattern {

    public static void main(String[] args) {

        Image image = new ImageProxy("path");
        image.display();

    }

}

interface Image {
    void display();
}

class ImageImpl implements Image {

    String file;

    public ImageImpl(String file) {
        this.file = file;
        load();
    }

    void load() {
        System.out.println("Loading image from "+ file);
    }

    @Override
    public void display() {
        System.out.println("Displaying image from " + file);
    }
}

class ImageProxy implements Image {

    String file;
    ImageImpl image;

    public ImageProxy(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if(image == null){
            image = new ImageImpl(file);
        }

        image.display();
    }
}