import java.awt.Image;

public class CachedFileImageLoader implements ImageLoader {
    @Override
    public Image loadImage(String path) {
        return Util.loadImage(path);
    }
}
