import java.awt.*;
import javax.swing.*;

public class coin extends Rectangle{
    ImageIcon coin_icon = new ImageIcon(System.getProperty("user.dir")+"\\objects\\coin.gif");
    Image coin = coin_icon.getImage();
    coin(int x,int y){
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
    }
    public void draw(Graphics g2){
        g2.drawImage(coin,x,y,width,height,null);
    }
}