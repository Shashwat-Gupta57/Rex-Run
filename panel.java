import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import javax.swing.plaf.nimbus.*;
import java.awt.event.*;
import java.io.*;

public class panel extends JPanel{
    static boolean isJumping = false,shieldThreadRunning = false,pause = false,invincibling = false,invincible = false,isFloating = false,gameOver = false,grav = true,gravChanging = false,gameStart = false,gravityTimerRunning = false;
    Timer gravityTimer;
    Thread shieldThread;
    JButton restart,exit;
    long time1,time2;
    rex player;
    rexRun main = new rexRun();
    coin coin1,coin2,coin3,coin4,coin5;
    blocks obj1,obj2,obj3;
    public int sprite = 1,a = 0,x1 = 1500,shieldX = 8000,shieldY = 450,lives = 1,lifeX = 15000,lifeY = 450,i = 0,float_countdown = 30,minDist = 300,GThreads = 0,highScore = 0,score = 0,playerY = 420,playerX = 300,x2 = 2000,x3 = 2500,x4 = 3500,x5 = 5000,y1 = 440,y2 = 400,y3 = 420,coinX1 = 800,coinX2 = 875,coinX3 = 950,coinX4 = 1025,coinX5 = 1100,coinY1 = 450,coinY2 = 450,coinY3 = 450,coinY4 = 450,coinY5 = 450,coinScore = 0,speed = 1;
    Graphics g2;
    life life;
    shield shield;
    jump_pillars pillar1,pillar2,pillar3;
    boolean avat_editting = false,panel_added = false;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ImageIcon coin_icon = new ImageIcon(System.getProperty("user.dir")+"\\objects\\coin_front.png");
    ImageIcon life_icon = new ImageIcon(System.getProperty("user.dir")+"\\objects\\life.png");
    ImageIcon rex_icon1 = new ImageIcon(main.rex1_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon2 = new ImageIcon(main.rex2_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon3 = new ImageIcon(main.rex3_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon4 = new ImageIcon(main.rex4_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon5 = new ImageIcon(main.rex5_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon6 = new ImageIcon(main.rex6_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon7 = new ImageIcon(main.rex7_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon8 = new ImageIcon(main.rex8_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon9 = new ImageIcon(main.rex9_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon10 = new ImageIcon(main.rex10_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon11 = new ImageIcon(main.rex11_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon12 = new ImageIcon(main.rex12_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon14 = new ImageIcon(main.rex14_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon16 = new ImageIcon(main.rex16_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon17 = new ImageIcon(main.rex17_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon18 = new ImageIcon(main.rex18_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon19 = new ImageIcon(main.rex19_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon20 = new ImageIcon(main.rex20_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon21 = new ImageIcon(main.rex21_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon22 = new ImageIcon(main.rex22_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon23 = new ImageIcon(main.rex23_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon24 = new ImageIcon(main.rex24_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon25 = new ImageIcon(main.rex25_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon26 = new ImageIcon(main.rex26_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon rex_icon27 = new ImageIcon(main.rex27_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
    ImageIcon life_icon_shop = new ImageIcon(System.getProperty("user.dir")+"\\objects\\lifeEnlarged.png");
    ImageIcon coin_icon_shop = new ImageIcon(System.getProperty("user.dir")+"\\objects\\coin_shop.png");
    String filePath = System.getProperty("user.dir");
    Path path = Paths.get(filePath+"\\Saves.txt");
    panel() throws java.io.IOException
    {
        setSize(screenSize);
        setLocation(0,0);
        if(!Files.exists(path)){
            Files.createFile(path);
        }else{
            highScore = (Files.lines(path).findFirst().orElse(null)) == null ? 0 : Integer.parseInt(Files.lines(path).findFirst().orElse(null));
            coinScore = (Files.lines(path).skip(1).findFirst().orElse(null)) == null ?  0:Integer.parseInt(Files.lines(path).skip(1).findFirst().orElse(null));
            sprite = Files.lines(path).skip(2).findFirst().orElse(null) == null ?  1:Integer.parseInt(Files.lines(path).skip(2).findFirst().orElse(null));
        }
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setLayout(null);
        setBackground(new Color(200,200,200));
        shieldThread = new Thread(()-> shield_equipped());
        gravityTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                gravityTimerRunning = true;
                float_countdown--;
                if(gameOver)
                {
                    gravityTimerRunning = false;
                    float_countdown = 30;
                    gravityTimer.stop();
                    
                }else{
                    if(playerY < 100 || playerY > 400)
                    {
                        gravityTimerRunning = false;
                        gravityTimer.stop();
                    }else{
                        if(isFloating == false || pause){
                            return;
                        }
                        if(float_countdown == 0)
                        {
                            gravityTimerRunning = false;
                            gravityTimer.stop();
                            float_countdown = 30;
                            new Thread(()->grav_shift()).start();
                        }
                        repaint();
                    }
                }
            }
        });
        exit = new JButton("EXIT THE GAME");
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        exit.setSize(350,50);
        exit.setFont(new Font("Bold",Font.BOLD,40));
        exit.setFocusable(false);
        exit.setLocation(650,600);
        exit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                
                try{
                    if(Files.lines(path).findFirst().orElse(null) == null){
                        Files.write(path,(String.valueOf(score)+"\n").getBytes());
                        Files.write(path,(String.valueOf(coinScore)+"\n").getBytes(),StandardOpenOption.APPEND);
                        Files.write(path,String.valueOf(sprite).getBytes(),StandardOpenOption.APPEND);
                    }else{
                        if(score > highScore){
                            Files.write(path,(String.valueOf(score)+"\n").getBytes());
                        }else{
                            Files.write(path,(String.valueOf(highScore)+"\n").getBytes());
                        }
                        Files.write(path,(String.valueOf(coinScore)+"\n").getBytes(),StandardOpenOption.APPEND);
                        Files.write(path,String.valueOf(sprite).getBytes(),StandardOpenOption.APPEND);
                    }
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
                System.exit(0);
            }
        });
        restart = new JButton("RESTART");
        restart.setBackground(Color.black);
        restart.setForeground(Color.white);
        restart.setSize(300,50);
        restart.setFont(new Font("Bold",Font.BOLD,40));
        restart.setFocusable(false);
        restart.setLocation(250,600);
        restart.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                gameOver = false;
                main.isJumpEnabled = true;
                main.isObstructionsEnabled = true;
                lives = 2;
                x1 = 1500;
                x2 = 2000;
                x3 = 2400;
                x4 = 3500;
                x5 = 5000;
                y1 = 440;
                y2 = 400;
                lifeX = 1000;
                lifeY = 450;
                shieldX = 8000;
                shieldY = 450;
                i = 0;
                y3 = 420;
                coinX1 = 800;
                coinX2 = 875;
                coinX3 = 950;
                float_countdown = 30;
                coinX4 = 1050;
                coinX5 = 1100;
                coinY1 = 450;
                coinY2 = 450;
                coinY3 = 450;
                coinY4 = 450;
                coinY5 = 450;
                coinScore = 0;
                grav = true;
                gravChanging = false;
                gravityTimerRunning = false;
                isJumping = false;
                isFloating = false;
                playerY = 420;
                remove(restart);
                remove(exit);
                a = 0;
                score = 0;
            }});
    }
    public void paintComponent(Graphics g)
    {
        panel_added = true;
        super.paintComponent(g);
        player = new rex(playerX,playerY,80,80,gameOver,sprite);
        obj1 = new blocks(x1,y1,60,60);
        obj2 = new blocks(x2,y2,80,100);
        obj3 = new blocks(x3,y3,80,80);
        pillar1 = new jump_pillars(x4,340,160);
        pillar2 = new jump_pillars(x4,80,100);
        pillar3 = new jump_pillars(x5,180,320);
        life = new life(lifeX,lifeY);
        shield = new shield(shieldX,shieldY);
        coin1 = new coin(coinX1,coinY1);
        coin2 = new coin(coinX2,coinY2);
        coin3 = new coin(coinX3,coinY3);
        coin4 = new coin(coinX4,coinY4);
        coin5 = new coin(coinX5,coinY5);
        g2 = g;
        if(speed > 4){
            speed = 1;
        }
        if(gameOver == true && !pause){
            this.add(restart);
            this.add(exit);
            g.setColor(Color.red);
            g.setFont(new Font("BOLD",Font.BOLD,50));
            g.drawString("GAME OVER",530,140);
            repaint();
        }
        if(isFloating && !gameOver && !pause)
        {
            g2.setColor(Color.red);
            g2.setFont(new Font("",Font.BOLD,30));
            g2.drawString(""+float_countdown/10,200,550);
            repaint();
        }
        if(a == 0 && !pause){
            a = 1;
            Thread obstructionsThread = new Thread(() -> {
                while (!gameOver && !pause) {
                    obstructions();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            obstructionsThread.start();
        }
        if(!invincible && !pause){
            player.draw(g2);
        }
        else if(invincible && !invincibling && !pause)
        {
            new Thread(() -> life_used()).start();
        }
        if(main.isObstructionsEnabled == true && !pause){
            obstructions();
        }else if(!pause && !main.isObstructionsEnabled){
            obj1.draw(g2);
            obj2.draw(g2);
            obj3.draw(g2);
            life.draw(g2);
            coin1.draw(g2);
            coin2.draw(g2);
            coin3.draw(g2);
            coin4.draw(g2);
            coin5.draw(g2);
            shield.draw(g2);
            pillar1.draw(g2);
            pillar2.draw(g2);
            pillar3.draw(g2);
        }
        if(!gameOver  && !pause){
            g2.setColor(Color.gray);
            i++;
            if(i > 10){
                i = 0;
                score++;
            }
            g2.setColor(Color.black);
            g2.setFont(new Font("Bold",Font.BOLD,30));
            g2.drawString("Score : "+score,50,50);
            g2.drawImage(life_icon.getImage(),500,15,50,50,null);
            g2.drawString("x "+lives,570,45);
            g2.drawImage(coin_icon.getImage(),800,15,50,50,null);
            g2.drawString("x "+coinScore,870,45);
        }else if(gameOver && !pause){
            if(score > highScore){
                highScore = score;
            }
            g2.setColor(Color.black);
            g2.setFont(new Font("Bold",Font.BOLD,30));
            g2.drawString("Highest Score : "+highScore,530,300);
            g2.setColor(Color.black);
            g2.setFont(new Font("Bold",Font.BOLD,30));
            g2.drawString("Current Score : "+score,530,350);
        }
        if(player.intersects(obj1) || player.intersects(obj2) || player.intersects(obj3) || player.intersects(pillar1) || player.intersects(pillar2)  || player.intersects(pillar3)){
            if(lives > 0 && !invincible){
                invincible = true;
                lives--;
            }else if(!invincible){
                main.isJumpEnabled = false;
                main.isObstructionsEnabled = false;
                try{
                    Files.write(path,(String.valueOf(highScore)+"\n").getBytes());
                    Files.write(path,(String.valueOf(coinScore)+"\n").getBytes(),StandardOpenOption.APPEND);
                    Files.write(path,String.valueOf(sprite).getBytes(),StandardOpenOption.APPEND);
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
                gameOver = true;
                repaint();
            }
        }
        if(!pause)
        {
            g.setColor(Color.black);
            g.fillRect(0,500,2000,10);
            g.fillRect(0,70,2000,10);
        }
    }
    public void pause()
    {
        if(avat_editting){
            main.c.add(this);
            panel_added = true;
            repaint();
        }
        avat_editting = false;
        removeAll();
        repaint();
        JLabel game_paused = new JLabel("GAME PAUSED");
        game_paused.setForeground(Color.red);
        game_paused.setSize(500,70);
        game_paused.setFont(new Font("Bold",Font.BOLD,60));
        game_paused.setFocusable(false);
        game_paused.setLocation(450,100);
        add(game_paused);
        pause = true;
        exit.setLocation(500,600);
        exit.setSize(350,60);
        add(exit);
        JLabel rex_i = new JLabel(rex_icon1);
        if(sprite == 1){
            rex_i.setIcon(rex_icon1);
        }else if(sprite == 2){
            rex_i.setIcon(rex_icon2);
        }else if(sprite == 3){
            rex_i.setIcon(rex_icon3);
        }else if(sprite == 4){
            rex_i.setIcon(rex_icon4);
        }else if(sprite == 5){
            rex_i.setIcon(rex_icon5);
        }else if(sprite == 6){
            rex_i.setIcon(rex_icon6);
        }else if(sprite == 7){
            rex_i.setIcon(rex_icon7);
        }else if(sprite == 8){
            rex_i.setIcon(rex_icon8);
        }else if(sprite == 9){
            rex_i.setIcon(rex_icon9);
        }else if(sprite == 10){
            rex_i.setIcon(rex_icon10);
        }else if(sprite == 11){
            rex_i.setIcon(rex_icon11);
        }else if(sprite == 12){
            rex_i.setIcon(rex_icon12);
        }else if(sprite == 13){
            rex_i.setIcon(main.rex13);
        }else if(sprite == 14){
            rex_i.setIcon(rex_icon14);
        }else if(sprite == 15){
            rex_i.setIcon(main.rex15);
        }else if(sprite == 16){
            rex_i.setIcon(rex_icon16);
        }else if(sprite == 17){
            rex_i.setIcon(rex_icon17);
        }else if(sprite == 18){
            rex_i.setIcon(rex_icon18);
        }else if(sprite == 19){
            rex_i.setIcon(rex_icon19);
        }else if(sprite == 20){
            rex_i.setIcon(rex_icon20);
        }else if(sprite == 21){
            rex_i.setIcon(rex_icon21);
        }else if(sprite == 22){
            rex_i.setIcon(rex_icon22);
        }else if(sprite == 23){
            rex_i.setIcon(rex_icon23);
        }else if(sprite == 24){
            rex_i.setIcon(rex_icon24);
        }else if(sprite == 25){
            rex_i.setIcon(rex_icon25);
        }else if(sprite == 26){
            rex_i.setIcon(rex_icon26);
        }else if(sprite == 27){
            rex_i.setIcon(rex_icon27);
        }else if(sprite == 28){
            rex_i.setIcon(main.rex28);
        }
        rex_i.setSize(200,200);
        rex_i.setLocation(80,350);
        add(rex_i);
        JButton edit = new JButton("EDIT AVATAR");
        edit.setFont(new Font("",Font.BOLD,30));
        edit.setForeground(Color.white);
        edit.setBackground(Color.black);
        edit.setSize(300,60);
        edit.setLocation(30,600);
        edit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                panel_added = false;
                main.c.remove(main.Panel);
                avat_editting = true;
                edit_avatar();
            }
        });
        add(edit);
        JButton resume = new JButton("RESUME GAME");
        resume.setBackground(Color.black);
        resume.setForeground(Color.white);
        resume.setSize(350,60);
        resume.setFont(new Font("Bold",Font.BOLD,40));
        resume.setFocusable(false);
        resume.setLocation(500,300);
        resume.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                pause = false;
                exit.setLocation(650,600);
                exit.setSize(350,50);
                a = 0;
                main.f.requestFocusInWindow();
                removeAll();
                repaint();
            }
        });
        add(resume);
        JButton shop = new JButton("SHOP");
        shop.setBackground(Color.black);
        shop.setForeground(Color.white);
        shop.setSize(350,60);
        shop.setFont(new Font("Bold",Font.BOLD,40));
        shop.setFocusable(false);
        shop.setLocation(500,400);
        shop.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                removeAll();
                shop();
                repaint();
            }
        });
        add(shop);
        JButton settings = new JButton("SETTINGS");
        settings.setBackground(Color.black);
        settings.setForeground(Color.white);
        settings.setSize(350,60);
        settings.setFont(new Font("Bold",Font.BOLD,40));
        settings.setFocusable(false);
        settings.setLocation(500,500);
        settings.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                removeAll();
                settings();
                repaint();
            }
        });
        add(settings);
        repaint();
    }
    public void shop(){
        JLabel not_enough = new JLabel("NOT ENOUGH REX-COINS TO BUY THIS ITEM");
        not_enough.setSize(800,40);
        not_enough.setLocation(350,560);
        not_enough.setFont(new Font("",Font.BOLD,30));
        not_enough.setForeground(Color.red);
        JButton back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setSize(200,50);
        back.setFont(new Font("Bold",Font.BOLD,40));
        back.setFocusable(false);
        back.setLocation((screenSize.width/2)-100,screenSize.height-200);
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                removeAll();
                pause();
                repaint();
            }
        });
        add(back);
        JLabel owned_c_label = new JLabel("OWNED");
        owned_c_label.setSize(200,40);
        owned_c_label.setLocation(10,10);
        owned_c_label.setFont(new Font("",Font.BOLD,30));
        add(owned_c_label);
        JLabel coins_owned = new JLabel(coin_icon);
        coins_owned.setSize(50,50);
        coins_owned.setLocation(150,10);
        add(coins_owned);
        JLabel coins_owned_num = new JLabel("X "+coinScore);
        coins_owned_num.setSize(200,40);
        coins_owned_num.setLocation(210,10);
        coins_owned_num.setFont(new Font("",Font.BOLD,30));
        add(coins_owned_num);
        JLabel owned_l_label = new JLabel("OWNED");
        owned_l_label.setSize(200,40);
        owned_l_label.setLocation(screenSize.width-320,10);
        owned_l_label.setFont(new Font("",Font.BOLD,30));
        add(owned_l_label);
        JLabel lives_owned = new JLabel(life_icon);
        lives_owned.setSize(50,50);
        lives_owned.setLocation(screenSize.width-180,10);
        add(lives_owned);
        JLabel lives_owned_num = new JLabel("X "+lives);
        lives_owned_num.setSize(200,40);
        lives_owned_num.setLocation(screenSize.width-120,10);
        lives_owned_num.setFont(new Font("",Font.BOLD,30));
        add(lives_owned_num);
        JLabel  one = new JLabel("1");
        one.setSize(100,130);
        one.setLocation(230,130);
        one.setFont(new Font("",Font.BOLD,120));
        add(one);
        JLabel life_label = new JLabel(life_icon_shop);
        life_label.setSize(200,200);
        life_label.setFocusable(false);
        life_label.setLocation(250,100);
        add(life_label);
        JLabel equals = new JLabel("=");
        equals.setSize(50,80);
        equals.setLocation(440,160);
        equals.setFont(new Font("",Font.BOLD,80));
        add(equals);
        JLabel coin_label = new JLabel(coin_icon_shop);
        coin_label.setSize(100,100);
        coin_label.setLocation(530,155);
        add(coin_label);
        JLabel price = new JLabel("x 50");
        price.setSize(250,100);
        price.setLocation(640,150);
        price.setFont(new Font("",Font.BOLD,80));
        add(price);
        JButton buy = new JButton("BUY");
        buy.setForeground(Color.white);
        buy.setBackground(Color.black);
        buy.setSize(150,50);
        buy.setLocation(850,180);
        buy.setFont(new Font("",Font.BOLD,30));
        buy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(coinScore >= 50)
                {
                    lives++;
                    coinScore -= 50;
                    lives_owned_num.setText("X "+lives);
                    coins_owned_num.setText("X "+coinScore);
                }
                else
                {
                    new Thread(() -> {
                        add(not_enough);
                        repaint();
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                        remove(not_enough);
                        repaint();
                    }).start();
                }
            }
        });
        add(buy);
    }
    public void settings(){
        JButton back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.yellow);
        back.setSize(200,50);
        back.setFont(new Font("Bold",Font.BOLD,40));
        back.setFocusable(false);
        back.setLocation(50,50);
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                removeAll();
                pause();
                repaint();
            }
        });
        add(back);
        JLabel speed_label = new JLabel("SPEED = "+speed+" X");
        speed_label.setFont(new Font("",Font.BOLD,30));
        speed_label.setSize(300,40);
        speed_label.setForeground(Color.black);
        speed_label.setLocation(200,200);
        add(speed_label);
        JButton speed_sub = new JButton("-");;
        JButton speed_add = new JButton("+");
        speed_add.setBackground(Color.black);
        speed_add.setForeground(Color.white);
        speed_add.setSize(50,35);
        speed_add.setFont(new Font("Bold",Font.BOLD,30));
        speed_add.setFocusable(false);
        speed_add.setLocation(400,205);
        speed_add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                if(speed < 3)
                {
                    speed++;
                    speed_label.setText("SPEED = "+speed+" X");
                    repaint();
                }
                if(speed == 3){
                    speed_add.enable(false);
                }
                if(speed > 1)
                {
                    speed_sub.enable(false);
                }
            }
        });
        add(speed_add);
        speed_sub.setBackground(Color.black);
        speed_sub.setForeground(Color.white);
        speed_sub.setSize(50,35);
        speed_sub.setFont(new Font("Bold",Font.BOLD,30));
        speed_sub.setFocusable(false);
        speed_sub.setLocation(470,205);
        speed_sub.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                if(speed > 1)
                {
                    speed--;
                    speed_label.setText("SPEED = "+speed+" X");
                    repaint();
                }
                if(speed == 1){
                    speed_sub.enable(false);
                }
                if(speed < 3)
                {
                    speed_add.enable(true);
                }
            }
        });
        add(speed_sub);
    }
    public void grav_shift(){
        if(!gameOver && !pause){
            gravChanging = true;
            GThreads++;
            if(isFloating && !pause){
                if(grav){
                    grav = false;
                }else{
                    grav = true;
                }
            }
            if(grav && !pause){
            for(;playerY > 80;){
                if(pause){
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                    continue;
                }
                if(gameOver){
                    break;
                }
                if(!invincible && !pause){
                    player.draw(g2);
                }
                if(!grav || GThreads > 1){
                    if(GThreads > 1){
                        if(!gravityTimerRunning){
                            float_countdown = 30;
                            gravityTimer.start();
                        }
                    }
                    isFloating = true;
                    break;
                }
                try{
                    Thread.sleep(1);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                playerY--;
                isFloating = false;
                repaint();
            }
            grav = false;
            }else if(!grav && !pause){
                for(;playerY < 420;){
                if(pause){
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                    continue;
                }
                if(gameOver){
                    break;
                }
                if(grav || GThreads > 1){
                    if(GThreads > 1){
                        if(!gravityTimerRunning){
                            gravityTimer.start();
                        }
                    }
                    isFloating = true;
                    break;
                }
                if(!invincible && !pause){
                    player.draw(g2);
                }
                try{
                    Thread.sleep(1);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                playerY++;
                isFloating = false;
                repaint();
                }   
                grav = true;
            }
            gravChanging = false;
            GThreads--;
        }else{}
    }
    public void life_used()
    {
        invincibling = true;
        for(int l = 0;l < 4;l++)
        {
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            long time1 = System.currentTimeMillis(),time2 = 0;
            while(time2-time1  < 300)
            {
                time2 = System.currentTimeMillis();
                if(!pause){
                    player.draw(g2);
                }
            }
        }
        invincible = false;
        invincibling = false;
    }
    public void shield_equipped()
    {
        shieldThreadRunning = true;
        invincible = true;
        invincibling = true;
        for(int i = 1;i <= 15;i++){
            try
            {
                Thread.sleep(300);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            long time1 = System.currentTimeMillis(),time2 = 0;
            while(time2-time1  < 300)
            {
                time2 = System.currentTimeMillis();
                player.draw(g2);
            }
        }
        invincible = false;
        invincibling = false;
        shieldThreadRunning = false;
    }
    public void jump(){
        isJumping = true;
        for(int i = 0;i < 35;i++){
            if(main.isJumpEnabled == false){
                break;
            }
            if(grav && !gravChanging){
                playerY-= 7;
            }else if(!gravChanging && !grav){
                playerY += 7;
            }
            try{
                Thread.sleep(8);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            repaint();
        }
        for(int i = 0;i < 5;i++)
        {
            if(main.isJumpEnabled == false){
                break;
            }
            if(grav && !gravChanging){
                playerY-= 5;
            }else if(!gravChanging && !grav){
                playerY += 5;
            }
            try{
                Thread.sleep(10);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            repaint();
        }
        for(int i = 0;i < 5;i++)
        {
            if(main.isJumpEnabled == false){
                break;
            }
            if(grav && !gravChanging){
                playerY+= 5;
            }else if(!gravChanging && !grav){
                playerY-= 5;
            }
            try{
                Thread.sleep(10);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            repaint();
        }
        for(int i = 0;i < 35;i++)
        {
            if(main.isJumpEnabled == false){
                break;
            }
            if(grav && !gravChanging){
                playerY+= 7;
            }else if(!gravChanging && !grav){
                playerY-=7;
            }
            try{
                Thread.sleep(8);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            repaint();
        }
        isJumping = false;
    }
    public void obstructions()
    {
        if(x1 < -80){
            x1 = (int)((Math.random()*1000)+1500);
            if(!grav){
                y1 = 80;
            }else{
                y1 = 440;
            }
        }
        if(lifeX < -50){
            lifeX = (int)((Math.random()*15000)+30000);
            lifeY = (int)((Math.random()*370)+80);
        }
        if(shieldX < -50){
            shieldX = (int)((Math.random()*10000)+20000);
            shieldY = (int)((Math.random()*370)+80);
        }
        if(x4 < -80){
            x4 = (int)((Math.random()*2500)+2500);
        }
        if(x5 < -80){
            x5 = (int)((Math.random()*1500)+2500);
        }
        if(x2 < -80){
            x2 = (int)((Math.random()*1000)+1500);
            if(!grav){
                y2 = 80;
            }else{
                y2 = 400;
            }
        }
        if(x3 < -80){
            x3 = (int)((Math.random()*1000)+1500);
            if(!grav){
                y3 = 80;
            }else{
                y3 = 420;
            }
        }
        if(Math.abs(x2-x1) < minDist){
            x2 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(x3-x2) < minDist){
            x3 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(x3-x1) < minDist){
            x3 = (int)((Math.random()*1000)+1500);
        }
        if (Math.abs(x4 - x1) < minDist) {
            x1 = (int) ((Math.random() * 2500) + 2500);
        }
        if (Math.abs(x4 - x2) < minDist) {
            x2 = (int) ((Math.random() * 2500) + 2500);
        }
        if (Math.abs(x4 - x3) < minDist) {
            x3 = (int) ((Math.random() * 2500) + 2500);
        }
        if (Math.abs(x5 - x1) < minDist) {
            x1 = (int) ((Math.random() * 2500) + 2500);
        }
        if (Math.abs(x5 - x2) < minDist) {
            x2 = (int) ((Math.random() * 2500) + 2500);
        }
        if (Math.abs(x5 - x3) < minDist) {
            x3 = (int) ((Math.random() * 2500) + 2500);
        }
        if (Math.abs(x5 - x4) < minDist+400) {
            x4 = (int) ((Math.random() * 2500) + 2500);
        }
        if (Math.abs(lifeX - x1) < minDist && lifeY - y1 < 100) {
            if(x1 < screenSize.width){
                x1 = (int) ((Math.random() * 2500) + 2500);
            }
            else{
                lifeX = (int)((Math.random()*15000)+30000);
                lifeY = (int)((Math.random()*370)+80); 
            }
        }
        if (Math.abs(lifeX - x2) < minDist && lifeY - y2 < 100) {
            if(x2 < screenSize.width){
                x2 = (int) ((Math.random() * 2500) + 2500);
            }else{
                lifeX = (int)((Math.random()*15000)+30000);
                lifeY = (int)((Math.random()*370)+80); 
            }
        }
        if (Math.abs(lifeX - x3) < minDist && lifeY - y3 < 100) {
            if(x3 < screenSize.width){
                x3 = (int) ((Math.random() * 2500) + 2500);
            }
            else{
                lifeX = (int)((Math.random()*15000)+30000);
                lifeY = (int)((Math.random()*370)+80); 
            }
        }
        if (Math.abs(lifeX - x4) < minDist) {
            if(x4 < screenSize.width){
                x4 = (int) ((Math.random() * 2500) + 2500);
            }
            else{
                lifeX = (int)((Math.random()*15000)+30000);
                lifeY = (int)((Math.random()*370)+80); 
            }
        }
        if (Math.abs(lifeX - x5) < minDist) {
            if(x5 < screenSize.width){
                x5 = (int) ((Math.random() * 2500) + 2500);
            }
            else{
                lifeX = (int)((Math.random()*15000)+30000);
                lifeY = (int)((Math.random()*370)+80); 
            }
        }
        if (Math.abs(shieldX - x1) < minDist && Math.abs(shieldY - y1) < 100) {
            if(x1 < screenSize.width){
                x1 = (int) ((Math.random() * 2500) + 2500);
            }else{
                shieldX = (int)((Math.random()*10000)+20000);
                shieldY = (int)((Math.random()*370)+80); 
            }
        }
        if (Math.abs(shieldX - x2) < minDist && Math.abs(shieldY - y2) < 100) {
            if(x2 < screenSize.width){
                x2 = (int) ((Math.random() * 2500) + 2500);
            }else{
                shieldX = (int)((Math.random()*10000)+20000);
                shieldY = (int)((Math.random()*370)+80); 
            }
        }
        if (Math.abs(shieldX - x3) < minDist && Math.abs(shieldY - y3) < 100) {
            if(x3 < screenSize.width){
                x3 = (int) ((Math.random() * 2500) + 2500);
            }else{
                shieldX = (int)((Math.random()*10000)+20000);
                shieldY = (int)((Math.random()*370)+80); 
            }
        }
        if (Math.abs(shieldX - x4) < minDist) {
            if(x4 < screenSize.width){
                x4 = (int) ((Math.random() * 2500) + 2500);
            }else{
                shieldX = (int)((Math.random()*10000)+20000);
                shieldY = (int)((Math.random()*370)+80); 
            }
        }
        if (Math.abs(shieldX - lifeX) < minDist && Math.abs(shieldY-lifeY) < 100) {
            if(x5 < screenSize.width){
                x5 = (int) ((Math.random() * 2500) + 2500);
            }else{
                shieldX = (int)((Math.random()*10000)+20000);
                shieldY = (int)((Math.random()*370)+80); 
            }
        }
        if (Math.abs(coinX1 - x1) < minDist || Math.abs(coinX1 - x2) < minDist || Math.abs(coinX1 - x3) < minDist || Math.abs(coinX1 - x4) < minDist || Math.abs(coinX1 - x5) < minDist ) {
            coinX1 = (int) ((Math.random() * 1000) + 1500);
        }
        if (Math.abs(coinX2 - x1) < minDist || Math.abs(coinX2 - x2) < minDist || Math.abs(coinX2 - x3) < minDist || Math.abs(coinX2 - x4) < minDist || Math.abs(coinX2 - x5) < minDist) {
            coinX2 = (int) ((Math.random() * 1000) + 1500);
        }
        if (Math.abs(coinX3 - x1) < minDist || Math.abs(coinX3 - x2) < minDist || Math.abs(coinX3 - x3) < minDist || Math.abs(coinX3 - x4) < minDist || Math.abs(coinX3 - x5) < minDist) {
            coinX3 = (int) ((Math.random() * 1000) + 1500);
        }
        if (Math.abs(coinX4 - x1) < minDist || Math.abs(coinX4 - x2) < minDist || Math.abs(coinX4 - x3) < minDist || Math.abs(coinX4 - x4) < minDist || Math.abs(coinX4 - x5) < minDist) {
            coinX4 = (int) ((Math.random() * 1000) + 1500);
        }
        if (Math.abs(coinX5 - x1) < minDist || Math.abs(coinX5 - x2) < minDist || Math.abs(coinX5 - x3) < minDist || Math.abs(coinX5 - x4) < minDist || Math.abs(coinX5 - x5) < minDist) {
            coinX5 = (int) ((Math.random() * 1000) + 1500);
        }
        if(coinX1 < -50 || player.intersects(coin1)){
            coinX1 = (int)((Math.random()*1000)+1500);
            if(!grav){
                coinY1 = 80;
            }else{
                coinY1 = 450;
            }
            if(player.intersects(coin1)){
                coinScore++;
                coin1 = new coin(coinX1,coinY1);
            }
            coin1 = new coin(coinX1,coinY1);
        }
        if(coinX2 < -50 || player.intersects(coin2)){
            coinX2 = (int)((Math.random()*1000)+1500);
            if(!grav){
                coinY2 = 80;
            }else{
                coinY2 = 450;
            }
            if(player.intersects(coin2)){
                coinScore++;
                coin2 = new coin(coinX2,coinY2);
            }
            coin2 = new coin(coinX2,coinY2);
        }
        if(coinX3 < -50 || player.intersects(coin3)){
            coinX3 = (int)((Math.random()*1000)+1500);
            if(!grav){
                coinY3 = 80;
            }else{
                coinY3 = 450;
            }
            if(player.intersects(coin3)){
                coinScore++;
                coin3 = new coin(coinX3,coinY3);
            }
            coin3 = new coin(coinX3,coinY3);
        }
        if(coinX4 < -50 || player.intersects(coin4)){
            coinX4 = (int)((Math.random()*1000)+1500);
            if(!grav){
                coinY4 = 80;
            }else{
                coinY4 = 450;
            }
            if(player.intersects(coin4)){
                coinScore++;
                coin4 = new coin(coinX4,coinY4);
            }
            coin4 = new coin(coinX4,coinY4);
        }
        if(coinX5 < -50 || player.intersects(coin5)){
            coinX5 = (int)((Math.random()*1000)+1500);
            if(!grav){
                coinY5 = 80;
            }else{
                coinY5 = 450;
            }
            if(player.intersects(coin5)){
                coinScore++;
                coin5 = new coin(coinX5,coinY5);
            }
            coin5 = new coin(coinX5,coinY5);
        }
        if(Math.abs(coinX1-coinX2) < 70 && Math.abs(coinY1-coinY2) < 300){
            coinX1 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX1-coinX3) < 70 && Math.abs(coinY1-coinY3) < 300){
            coinX1 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX1-coinX4) < 70 && Math.abs(coinY1-coinY4) < 300){
            coinX1 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX1-coinX5) < 70 && Math.abs(coinY1-coinY5) < 300){
            coinX1 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX2-coinX1) < 70 && Math.abs(coinY2-coinY1) < 300){
            coinX2 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX2-coinX3) < 70 && Math.abs(coinY2-coinY3) < 300){
            coinX2 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX2-coinX4) < 70 && Math.abs(coinY2-coinY4) < 300){
            coinX2 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX2-coinX5) < 70 && Math.abs(coinY2-coinY5) < 300){
            coinX2 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX3-coinX1) < 70 && Math.abs(coinY3-coinY1) < 300){
            coinX3 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX3-coinX2) < 70 && Math.abs(coinY3-coinY2) < 300){
            coinX3 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX3-coinX4) < 70 && Math.abs(coinY3-coinY4) < 300){
            coinX3 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX3-coinX5) < 70 && Math.abs(coinY3-coinY5) < 300){
            coinX3 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX4-coinX1) < 70 && Math.abs(coinY4-coinY1) < 300){
            coinX4 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX4-coinX2) < 70 && Math.abs(coinY4-coinY2) < 300){
            coinX4 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX4-coinX3) < 70 && Math.abs(coinY4-coinY3) < 300){
            coinX4 = (int)((Math.random()*1000)+1500);
        }
        if(Math.abs(coinX4-coinX5) < 70 && Math.abs(coinY4-coinY5) < 300){
            coinX4 = (int)((Math.random()*1000)+1500);
        }
        if(lifeX < -50 || player.intersects(life)){
            lifeX = (int)((Math.random()*10000)+20000);
            lifeY = (int)((Math.random()*370)+80);
            if(player.intersects(life)){
                lives++;
                life = new life(lifeX,lifeY);
            }
            life = new life(lifeX,lifeY);
        }
        if(shieldX < -50 || player.intersects(shield)){
            shieldX = (int)((Math.random()*10000)+20000);
            shieldY = (int)((Math.random()*370)+80);
            if(player.intersects(shield) && !invincible){
                invincible = true;
                if(!shieldThreadRunning){
                    shieldThread.start();
                }
                shield = new shield(shieldX,shieldY);
            }
            shield = new shield(shieldX,shieldY);
        }
        pillar1.draw(g2);pillar2.draw(g2);shield.draw(g2);pillar3.draw(g2);obj1.draw(g2);obj2.draw(g2);obj3.draw(g2);coin1.draw(g2);coin2.draw(g2);coin3.draw(g2);coin4.draw(g2);coin5.draw(g2);life.draw(g2);x1-= speed;x2-= speed;x3-= speed;x4 -= speed;x5 -= speed;coinX1 -= speed;coinX2 -= speed;coinX3 -= speed;coinX4 -= speed;coinX5 -= speed;lifeX-=speed;shieldX-=speed;
        repaint();
    }
    public void edit_avatar(){
        main.c.removeAll();
        JButton back = new JButton("BACK");
        back.setFont(new Font("",Font.BOLD,30));
        back.setSize(150,50);
        back.setLocation(30,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                main.c.removeAll();
                main.c.repaint();
                pause();
            }
        });
        main.c.add(back);
        JPanel edit_avat = new JPanel();
        edit_avat.setBackground(Color.gray);
        edit_avat.setLayout(new GridLayout(15,3,180,50));
        JLabel r1 = new JLabel(main.rex1);
        JLabel r2 = new JLabel(main.rex2);
        JLabel r3 = new JLabel(main.rex3);
        JLabel r4 = new JLabel(main.rex4);
        JLabel r5 = new JLabel(main.rex5);
        JLabel r6 = new JLabel(main.rex6);
        JLabel r7 = new JLabel(main.rex7);
        JLabel r8 = new JLabel(main.rex8);
        JLabel r9 = new JLabel(main.rex9);
        JLabel r10 = new JLabel(main.rex10);
        JLabel r11 = new JLabel(main.rex11);
        JLabel r12 = new JLabel(main.rex12);
        JLabel r13 = new JLabel(main.rex13);
        JLabel r14 = new JLabel(main.rex14);
        JLabel r15 = new JLabel(main.rex15);
        JLabel r16 = new JLabel(main.rex16);
        JLabel r17 = new JLabel(main.rex17);
        JLabel r18 = new JLabel(main.rex18);
        JLabel r19 = new JLabel(main.rex19);
        JLabel r20 = new JLabel(main.rex20);
        JLabel r21 = new JLabel(main.rex21);
        JLabel r22 = new JLabel(main.rex22);
        JLabel r23 = new JLabel(main.rex23);
        JLabel r24 = new JLabel(main.rex24);
        JLabel r25 = new JLabel(main.rex25);
        JLabel r26 = new JLabel(main.rex26);
        JLabel r27 = new JLabel(main.rex27);
        JLabel r28 = new JLabel(main.rex28);
        JButton b1 = new JButton("Select");
        JButton b2 = new JButton("Select");
        JButton b3 = new JButton("Select");
        JButton b4 = new JButton("Select");
        JButton b5 = new JButton("Select");
        JButton b6 = new JButton("Select");
        JButton b7 = new JButton("Select");
        JButton b8 = new JButton("Select");
        JButton b9 = new JButton("Select");
        JButton b10 = new JButton("Select");
        JButton b11 = new JButton("Select");
        JButton b12 = new JButton("Select");
        JButton b13 = new JButton("Select");
        JButton b14 = new JButton("Select");
        JButton b15 = new JButton("Select");
        JButton b16 = new JButton("Select");
        JButton b17 = new JButton("Select");
        JButton b18 = new JButton("Select");
        JButton b19 = new JButton("Select");
        JButton b20 = new JButton("Select");
        JButton b21 = new JButton("Select");
        JButton b22 = new JButton("Select");
        JButton b23 = new JButton("Select");
        JButton b24 = new JButton("Select");
        JButton b25 = new JButton("Select");
        JButton b26 = new JButton("Select");
        JButton b27 = new JButton("Select");
        JButton b28 = new JButton("Select");
        b1.setFont(new Font("",Font.BOLD,40));
        b2.setFont(new Font("",Font.BOLD,40));
        b3.setFont(new Font("",Font.BOLD,40));
        b4.setFont(new Font("",Font.BOLD,40));
        b5.setFont(new Font("",Font.BOLD,40));
        b6.setFont(new Font("",Font.BOLD,40));
        b7.setFont(new Font("",Font.BOLD,40));
        b8.setFont(new Font("",Font.BOLD,40));
        b9.setFont(new Font("",Font.BOLD,40));
        b10.setFont(new Font("",Font.BOLD,40));
        b11.setFont(new Font("",Font.BOLD,40));
        b12.setFont(new Font("",Font.BOLD,40));
        b13.setFont(new Font("",Font.BOLD,40));
        b14.setFont(new Font("",Font.BOLD,40));
        b15.setFont(new Font("",Font.BOLD,40));
        b16.setFont(new Font("",Font.BOLD,40));
        b17.setFont(new Font("",Font.BOLD,40));
        b18.setFont(new Font("",Font.BOLD,40));
        b19.setFont(new Font("",Font.BOLD,40));
        b20.setFont(new Font("",Font.BOLD,40));
        b21.setFont(new Font("",Font.BOLD,40));
        b22.setFont(new Font("",Font.BOLD,40));
        b23.setFont(new Font("",Font.BOLD,40));
        b24.setFont(new Font("",Font.BOLD,40));
        b25.setFont(new Font("",Font.BOLD,40));
        b26.setFont(new Font("",Font.BOLD,40));
        b27.setFont(new Font("",Font.BOLD,40));
        b28.setFont(new Font("",Font.BOLD,40));
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 1;
                b1.setText("Selected");
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 2;
                b2.setText("Selected");
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 3;
                b3.setText("Selected");
            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 4;
                b4.setText("Selected");
            }
        });
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 5;
                b5.setText("Selected");
            }
        });
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 6;
                b6.setText("Selected");
            }
        });
        b7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 7;
                b7.setText("Selected");
            }
        });
        b8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 8;
                b8.setText("Selected");
            }
        });
        b9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 9;
                b9.setText("Selected");
            }
        });
        b10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 10;
                b10.setText("Selected");
            }
        });
        b11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 11;
                b11.setText("Selected");
            }
        });
        b12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 12;
                b12.setText("Selected");
            }
        });
        b13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 13;
                b13.setText("Selected");
            }
        });
        b14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 14;
                b14.setText("Selected");
            }
        });
        b15.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 15;
                b15.setText("Selected");
            }
        });
        b16.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 16;
                b16.setText("Selected");
            }
        });
        b17.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 17;
                b17.setText("Selected");
            }
        });
        b18.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 18;
                b18.setText("Selected");
            }
        });
        b19.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 19;
                b19.setText("Selected");
            }
        });
        b20.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 20;
                b20.setText("Selected");
            }
        });
        b21.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 21;
                b21.setText("Selected");
            }
        });
        b22.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 22;
                b22.setText("Selected");
            }
        });
        b23.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 23;
                b23.setText("Selected");
            }
        });
        b24.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 24;
                b24.setText("Selected");
            }
        });
        b25.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 25;
                b25.setText("Selected");
            }
        });
        b26.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 26;
                b26.setText("Selected");
            }
        });
        b27.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 28){
                    b28.setText("Select");
                }
                sprite = 27;
                b27.setText("Selected");
            }
        });
        b28.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(sprite == 1){
                    b1.setText("Select");
                }else if(sprite == 2){
                    b2.setText("Select");
                }else if(sprite == 3){
                    b3.setText("Select");
                }else if(sprite == 4){
                    b4.setText("Select");
                }else if(sprite == 5){
                    b5.setText("Select");
                }else if(sprite == 6){
                    b6.setText("Select");
                }else if(sprite == 7){
                    b7.setText("Select");
                }else if(sprite == 8){
                    b8.setText("Select");
                }else if(sprite == 9){
                    b9.setText("Select");
                }else if(sprite == 10){
                    b10.setText("Select");
                }else if(sprite == 11){
                    b11.setText("Select");
                }else if(sprite == 12){
                    b12.setText("Select");
                }else if(sprite == 13){
                    b13.setText("Select");
                }else if(sprite == 14){
                    b14.setText("Select");
                }else if(sprite == 15){
                    b15.setText("Select");
                }else if(sprite == 16){
                    b16.setText("Select");
                }else if(sprite == 17){
                    b17.setText("Select");
                }else if(sprite == 18){
                    b18.setText("Select");
                }else if(sprite == 19){
                    b19.setText("Select");
                }else if(sprite == 20){
                    b20.setText("Select");
                }else if(sprite == 21){
                    b21.setText("Select");
                }else if(sprite == 22){
                    b22.setText("Select");
                }else if(sprite == 23){
                    b23.setText("Select");
                }else if(sprite == 24){
                    b24.setText("Select");
                }else if(sprite == 25){
                    b25.setText("Select");
                }else if(sprite == 26){
                    b26.setText("Select");
                }else if(sprite == 27){
                    b27.setText("Select");
                }
                sprite = 28;
                b28.setText("Selected");
            }
        });
        if(sprite == 1){
            b1.setText("Selected");
        }else if(sprite == 2){
            b2.setText("Selected");
        }else if(sprite == 3){
            b3.setText("Selected");
        }else if(sprite == 4){
            b4.setText("Selected");
        }else if(sprite == 5){
            b5.setText("Selected");
        }else if(sprite == 6){
            b6.setText("Selected");
        }else if(sprite == 7){
            b7.setText("Selected");
        }else if(sprite == 8){
            b8.setText("Selected");
        }else if(sprite == 9){
            b9.setText("Selected");
        }else if(sprite == 10){
            b10.setText("Selected");
        }else if(sprite == 11){
            b11.setText("Selected");
        }else if(sprite == 12){
            b12.setText("Selected");
        }else if(sprite == 13){
            b13.setText("Selected");
        }else if(sprite == 14){
            b14.setText("Selected");
        }else if(sprite == 15){
            b15.setText("Selected");
        }else if(sprite == 16){
            b16.setText("Selected");
        }else if(sprite == 17){
            b17.setText("Selected");
        }else if(sprite == 18){
            b18.setText("Selected");
        }else if(sprite == 19){
            b19.setText("Selected");
        }else if(sprite == 20){
            b20.setText("Selected");
        }else if(sprite == 21){
            b21.setText("Selected");
        }else if(sprite == 22){
            b22.setText("Selected");
        }else if(sprite == 23){
            b23.setText("Selected");
        }else if(sprite == 24){
            b24.setText("Selected");
        }else if(sprite == 25){
            b25.setText("Selected");
        }else if(sprite == 26){
            b26.setText("Selected");
        }else if(sprite == 27){
            b27.setText("Selected");
        }else if(sprite == 28){
            b28.setText("Selected");
        }
        edit_avat.add(r1);
        edit_avat.add(r2);
        edit_avat.add(r3);
        edit_avat.add(r4);
        edit_avat.add(b1);
        edit_avat.add(b2);
        edit_avat.add(b3);
        edit_avat.add(b4);
        edit_avat.add(r5);
        edit_avat.add(r6);
        edit_avat.add(r7);
        edit_avat.add(r8);
        edit_avat.add(b5);
        edit_avat.add(b6);
        edit_avat.add(b7);
        edit_avat.add(b8);
        edit_avat.add(r9);
        edit_avat.add(r10);
        edit_avat.add(r11);
        edit_avat.add(r12);
        edit_avat.add(b9);
        edit_avat.add(b10);
        edit_avat.add(b11);
        edit_avat.add(b12);
        edit_avat.add(r13);
        edit_avat.add(r14);
        edit_avat.add(r15);
        edit_avat.add(r16);
        edit_avat.add(b13);
        edit_avat.add(b14);
        edit_avat.add(b15);
        edit_avat.add(b16);
        edit_avat.add(r17);
        edit_avat.add(r18);
        edit_avat.add(r19);
        edit_avat.add(r20);
        edit_avat.add(b17);
        edit_avat.add(b18);
        edit_avat.add(b19);
        edit_avat.add(b20);
        edit_avat.add(r21);
        edit_avat.add(r22);
        edit_avat.add(r23);
        edit_avat.add(r24);
        edit_avat.add(b21);
        edit_avat.add(b22);
        edit_avat.add(b23);
        edit_avat.add(b24);
        edit_avat.add(r25);
        edit_avat.add(r26);
        edit_avat.add(r27);
        edit_avat.add(r28);
        edit_avat.add(b25);
        edit_avat.add(b26);
        edit_avat.add(b27);
        edit_avat.add(b28);
        JScrollPane scroll_edit = new JScrollPane(edit_avat);
        //scroll_edit.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll_edit.setBounds(0,100,screenSize.width-5,screenSize.height-160);
        scroll_edit.setPreferredSize(new Dimension(screenSize.width+5,screenSize.height+5));
        scroll_edit.getVerticalScrollBar().setUnitIncrement(15);
        main.f.add(scroll_edit);
        main.c.repaint();
    }
}
