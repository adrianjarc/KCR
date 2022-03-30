package fri.kcr;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Adrian Jarc
 */

public class PicturePanel extends JPanel{
    private BufferedImage shownImage = null;
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (shownImage != null){
            this.setPreferredSize(new Dimension(shownImage.getWidth(), shownImage.getHeight()));
            revalidate();
            g.drawImage(shownImage, 0, 0, null);
        }
    }
    
    public void openFile(File f) throws Exception{
        BufferedImage slika = ImageIO.read(f);
        shownImage = new BufferedImage(slika.getWidth(), slika.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i=0; i<slika.getWidth(); i++){
            for (int j=0; j<slika.getHeight(); j++){
                shownImage.setRGB(i, j, slika.getRGB(i, j));
            }
        }
        repaint();
    }
    
    public void setOriginal(BufferedImage originalImage){
        shownImage = originalImage;
        repaint();
    }
        
    public void onlyRed(BufferedImage originalImage){
        BufferedImage novaSlika = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < originalImage.getWidth(); i++){
            for (int j = 0; j < originalImage.getHeight(); j++){
                int rgb = originalImage.getRGB(i, j);
                
                int red = (rgb >> 16) & 0xFF;
                int green = 0;
                int blue = 0;
                int nRgb = 0xFF000000 | (red << 16) | (green << 8) | (blue);

                novaSlika.setRGB(i, j, nRgb);
            }
        }
        shownImage = novaSlika;
        repaint();
    }
    
    public void onlyGreen(BufferedImage originalImage){
        BufferedImage novaSlika = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < originalImage.getWidth(); i++){
            for (int j = 0; j < originalImage.getHeight(); j++){
                int rgb = originalImage.getRGB(i, j);
                
                int red = 0;
                int green = (rgb >> 8) & 0xFF;
                int blue = 0;
                int nRgb = 0xFF000000 | (red << 16) | (green << 8) | (blue);

                novaSlika.setRGB(i, j, nRgb);
            }
        }
        shownImage = novaSlika;
        repaint();
    }
    
    public void onlyBlue(BufferedImage originalImage){
        BufferedImage novaSlika = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < originalImage.getWidth(); i++){
            for (int j = 0; j < originalImage.getHeight(); j++){
                int rgb = originalImage.getRGB(i, j);
                
                int red = 0;
                int green = 0;
                int blue = (rgb) & 0xFF;
                int nRgb = 0xFF000000 | (red << 16) | (green << 8) | (blue);

                novaSlika.setRGB(i, j, nRgb);
            }
        }
        shownImage = novaSlika;
        repaint();
    }
    
    public void sharpen(){
        float[] kernel={0, -1, 0, -1, 5, -1, 0, -1, 0};
        BufferedImageOp image = new ConvolveOp(new Kernel(3, 3, kernel));
        shownImage = image.filter(shownImage, null);
        repaint();
    }
    
    public void blur(){
        float[] kernel = new float[49];
        for (int i = 0; i < kernel.length; i++){
            kernel[i] = 1/50f;
        }
        BufferedImageOp image = new ConvolveOp(new Kernel(7, 7, kernel));
        shownImage = image.filter(shownImage, null);
        repaint();
    }
    
    public void edges(){
        float[] kernel = {0, 0, -1, -1, -1, 0, 0, 0, -2, -3, -3, -3, -2, 0, -1, -3, 5, 5, 5, -3, -1, -1, -3, 5, 16, 5, -3, -1, -1, -3, 5, 5, 5, -3, -1, 0, -2, -3, -3, -3, -2, 0, 0, 0, -1, -1, -1, 0, 0};
        BufferedImageOp image = new ConvolveOp(new Kernel(7, 7, kernel));
        shownImage = image.filter(shownImage, null);
        repaint();
    }
    
    public BufferedImage returnImage(){
        return this.shownImage;
    }
}
