import javax.swing.*;
import javax.swing.plaf.nimbus.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.nio.file.*;
import java.io.*;
public class rexRun
{
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static boolean jump,isJumpEnabled = true,isObstructionsEnabled = true;
    static Container c;
    static JFrame f;
    static panel Panel;
    static boolean title_done = false;
    static int avatar_width = 150,avatar_height = 150;
    static ImageIcon rex1_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex1.png");
    static ImageIcon rex2_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex2.png");
    static ImageIcon rex3_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex3.png");
    static ImageIcon rex4_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex4.png");
    static ImageIcon rex5_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex5.png");
    static ImageIcon rex6_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex6.png");
    static ImageIcon rex7_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex7.png");
    static ImageIcon rex8_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex8.png");
    static ImageIcon rex9_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex9.png");
    static ImageIcon rex10_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex10.png");
    static ImageIcon rex11_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex11.png");
    static ImageIcon rex12_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex12.png");
    static ImageIcon rex13 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex13 extended.gif");
    static ImageIcon rex14_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex14.png");
    static ImageIcon rex15 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex15 extended.gif");
    static ImageIcon rex16_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex16.png");
    static ImageIcon rex17_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex17.png");
    static ImageIcon rex18_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex18.png");
    static ImageIcon rex19_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex19.png");
    static ImageIcon rex20_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex20.png");
    static ImageIcon rex21_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex21.png");
    static ImageIcon rex22_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex22.png");
    static ImageIcon rex23_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex23.png");
    static ImageIcon rex24_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex24.png");
    static ImageIcon rex25_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex25.png");
    static ImageIcon rex26_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex26.png");
    static ImageIcon rex27_icon = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex27.png");
    static ImageIcon rex28 = new ImageIcon(System.getProperty("user.dir")+"\\sprites\\rex28 extended.gif");
    static ImageIcon rex1 = new ImageIcon(rex1_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex2 = new ImageIcon(rex2_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex3 = new ImageIcon(rex3_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex4 = new ImageIcon(rex4_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex5 = new ImageIcon(rex5_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex6 = new ImageIcon(rex6_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex7 = new ImageIcon(rex7_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex8 = new ImageIcon(rex8_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex9 = new ImageIcon(rex9_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex10 = new ImageIcon(rex10_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex11 = new ImageIcon(rex11_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex12 = new ImageIcon(rex12_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex14 = new ImageIcon(rex14_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex16 = new ImageIcon(rex16_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex17 = new ImageIcon(rex17_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex18 = new ImageIcon(rex18_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex19 = new ImageIcon(rex19_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex20 = new ImageIcon(rex20_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex21 = new ImageIcon(rex21_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex22 = new ImageIcon(rex22_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex23 = new ImageIcon(rex23_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex24 = new ImageIcon(rex24_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex25 = new ImageIcon(rex25_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex26 = new ImageIcon(rex26_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    static ImageIcon rex27 = new ImageIcon(rex27_icon.getImage().getScaledInstance(avatar_width,avatar_height,Image.SCALE_SMOOTH));
    public static void main(String args[]) throws InterruptedException,IOException
    {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Panel = new panel();
        f = new JFrame("Rex Run");
        f.setSize(screenSize);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"\\objects\\rex run icon.png");
        f.setIconImage(icon.getImage());
        c = f.getContentPane();
        Title_screen(Panel);
        f.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent  e){   }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_SPACE && !Panel.isJumping && !Panel.gravChanging && !Panel.gameOver && !Panel.isFloating && Panel.panel_added){
                    new Thread(() -> {
                        Panel.jump();
                    }).start();
                }else if(e.getKeyCode() == KeyEvent.VK_SHIFT && !Panel.isJumping && !Panel.gameOver && Panel.panel_added){
                    new Thread(() ->{
                        Panel.grav_shift();
                    }).start();
                }else if(e.getKeyCode() == KeyEvent.VK_ENTER && !Panel.pause && title_done && !Panel.gameOver && Panel.panel_added)
                {
                    Panel.pause();
                }
            }
            public void keyReleased(KeyEvent e){   }
        });
    }
    static int press = 0;
    public static void Title_screen(JPanel Panel2) throws InterruptedException
    {
        c.removeAll();
        c.repaint();
        ImageIcon rex_icon = null;
        if(Panel.sprite == 1){
            rex_icon = new ImageIcon(rex1_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 2){
            rex_icon = new ImageIcon(rex2_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 3){
            rex_icon = new ImageIcon(rex3_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 4){
            rex_icon = new ImageIcon(rex4_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 5){
            rex_icon = new ImageIcon(rex5_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 6){
            rex_icon = new ImageIcon(rex6_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 7){
            rex_icon = new ImageIcon(rex7_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 8){
            rex_icon = new ImageIcon(rex8_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 9){
            rex_icon = new ImageIcon(rex9_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 10){
            rex_icon = new ImageIcon(rex10_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 11){
            rex_icon = new ImageIcon(rex11_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 12){
            rex_icon = new ImageIcon(rex12_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 13){
            rex_icon = new ImageIcon(rex13.getImage());
        }else if(Panel.sprite == 14){
            rex_icon = new ImageIcon(rex14_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 15){
            rex_icon = new ImageIcon(rex15.getImage());
        }else if(Panel.sprite == 16){
            rex_icon = new ImageIcon(rex16_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 17){
            rex_icon = new ImageIcon(rex17_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 18){
            rex_icon = new ImageIcon(rex18_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 19){
            rex_icon = new ImageIcon(rex19_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 20){
            rex_icon = new ImageIcon(rex20_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 21){
            rex_icon = new ImageIcon(rex21_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 22){
            rex_icon = new ImageIcon(rex22_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 23){
            rex_icon = new ImageIcon(rex23_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 24){
            rex_icon = new ImageIcon(rex24_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 25){
            rex_icon = new ImageIcon(rex25_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 26){
            rex_icon = new ImageIcon(rex26_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 27){
            rex_icon = new ImageIcon(rex27_icon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        }else if(Panel.sprite == 28){
            rex_icon = new ImageIcon(rex28.getImage());
        }
        c.setLayout(null);
        c.setBackground(Color.gray);
        JLabel game_name = new JLabel("REX RUN");
        game_name.setFont(new Font("",Font.BOLD,50));
        game_name.setForeground(Color.yellow);
        game_name.setSize(400,60);
        game_name.setLocation(350,250);
        c.add(game_name);
        JLabel credit = new JLabel("DEVELOPED BY SHASHWAT GUPTA");
        credit.setFont(new Font("",Font.BOLD,30));
        credit.setForeground(Color.white);
        credit.setSize(600,40);
        credit.setLocation(220,320);
        c.add(credit);
        JLabel rex_i = new JLabel(rex_icon);
        rex_i.setSize(200,200);
        rex_i.setLocation(screenSize.width-300,200);
        c.add(rex_i);
        JLabel meet_rex = new JLabel("HIS NAME IS REX");
        meet_rex.setFont(new Font("",Font.BOLD,30));
        meet_rex.setForeground(Color.cyan);
        meet_rex.setSize(300,40);
        meet_rex.setLocation(screenSize.width-330,150);
        c.add(meet_rex);
        JButton edit = new JButton("EDIT AVATAR");
        edit.setFont(new Font("",Font.BOLD,30));
        edit.setForeground(Color.white);
        edit.setBackground(Color.black);
        edit.setSize(300,60);
        edit.setLocation(screenSize.width-340,450);
        edit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                edit_avatar(Panel2);
            }
        });
        c.add(edit);
        JButton start = new JButton("CLICK TO START THE GAME");
        start.setFont(new Font("",Font.BOLD,30));
        start.setForeground(Color.white);
        start.setBackground(Color.black);
        start.setSize(600,60);
        start.setLocation(200,450);
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(press == 0)
                {
                    press++;
                    c.removeAll();
                    c.repaint();
                    instructions(Panel);
                    //c.add(Panel);
                    f.requestFocusInWindow();
                }
            }
        });
        c.add(start);
        title_done = true;
    }
    public static void instructions(JPanel Panel){
        JLabel jump = new JLabel("PRESS SPACEBAR TO JUMP");
        jump.setFont(new Font("",Font.BOLD,40));
        jump.setForeground(Color.white);
        jump.setSize(600,40);
        jump.setLocation(440,120);
        c.add(jump);
        JLabel grav_shift = new JLabel("PRESS SHIFT TO CHANGE THE GRAVITY");
        grav_shift.setFont(new Font("",Font.BOLD,40));
        grav_shift.setForeground(Color.white);
        grav_shift.setSize(800,40);
        grav_shift.setLocation(350,220);
        c.add(grav_shift);
        JLabel pause = new JLabel("PRESS ENTER TO PAUSE THE GAME");
        pause.setFont(new Font("",Font.BOLD,40));
        pause.setForeground(Color.white);
        pause.setSize(800,40);
        pause.setLocation(400,320);
        c.add(pause);
        JButton cont = new JButton("CONTINUE");
        cont.setBackground(Color.black);
        cont.setForeground(Color.white);
        cont.setSize(300,60);
        cont.setFont(new Font("Bold",Font.BOLD,40));
        cont.setFocusable(false);
        cont.setLocation((screenSize.width/2)-100,screenSize.height-300);
        cont.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                c.removeAll();
                c.add(Panel);
                c.repaint();
            }
        });
        c.add(cont);
    }
    public static void edit_avatar(JPanel Panel2)
    {
        c.removeAll();
        JButton back = new JButton("BACK");
        back.setFont(new Font("",Font.BOLD,30));
        back.setSize(150,50);
        back.setLocation(30,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try
                {
                    Title_screen(Panel2);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }
        });
        c.add(back);
        JPanel edit_avat = new JPanel();
        edit_avat.setBackground(Color.gray);
        edit_avat.setLayout(new GridLayout(15,3,180,50));
        JLabel r1 = new JLabel(rex1);
        JLabel r2 = new JLabel(rex2);
        JLabel r3 = new JLabel(rex3);
        JLabel r4 = new JLabel(rex4);
        JLabel r5 = new JLabel(rex5);
        JLabel r6 = new JLabel(rex6);
        JLabel r7 = new JLabel(rex7);
        JLabel r8 = new JLabel(rex8);
        JLabel r9 = new JLabel(rex9);
        JLabel r10 = new JLabel(rex10);
        JLabel r11 = new JLabel(rex11);
        JLabel r12 = new JLabel(rex12);
        JLabel r13 = new JLabel(rex13);
        JLabel r14 = new JLabel(rex14);
        JLabel r15 = new JLabel(rex15);
        JLabel r16 = new JLabel(rex16);
        JLabel r17 = new JLabel(rex17);
        JLabel r18 = new JLabel(rex18);
        JLabel r19 = new JLabel(rex19);
        JLabel r20 = new JLabel(rex20);
        JLabel r21 = new JLabel(rex21);
        JLabel r22 = new JLabel(rex22);
        JLabel r23 = new JLabel(rex23);
        JLabel r24 = new JLabel(rex24);
        JLabel r25 = new JLabel(rex25);
        JLabel r26 = new JLabel(rex26);
        JLabel r27 = new JLabel(rex27);
        JLabel r28 = new JLabel(rex28);
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
                if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 1;
                b1.setText("Selected");
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 2;
                b2.setText("Selected");
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 3;
                b3.setText("Selected");
            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 4;
                b4.setText("Selected");
            }
        });
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 5;
                b5.setText("Selected");
            }
        });
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 6;
                b6.setText("Selected");
            }
        });
        b7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 7;
                b7.setText("Selected");
            }
        });
        b8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 8;
                b8.setText("Selected");
            }
        });
        b9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 9;
                b9.setText("Selected");
            }
        });
        b10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 10;
                b10.setText("Selected");
            }
        });
        b11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 11;
                b11.setText("Selected");
            }
        });
        b12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 12;
                b12.setText("Selected");
            }
        });
        b13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 13;
                b13.setText("Selected");
            }
        });
        b14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 14;
                b14.setText("Selected");
            }
        });
        b15.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 15;
                b15.setText("Selected");
            }
        });
        b16.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 16;
                b16.setText("Selected");
            }
        });
        b17.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 17;
                b17.setText("Selected");
            }
        });
        b18.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 18;
                b18.setText("Selected");
            }
        });
        b19.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 19;
                b19.setText("Selected");
            }
        });
        b20.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 20;
                b20.setText("Selected");
            }
        });
        b21.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 21;
                b21.setText("Selected");
            }
        });
        b22.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 22;
                b22.setText("Selected");
            }
        });
        b23.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 23;
                b23.setText("Selected");
            }
        });
        b24.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 24;
                b24.setText("Selected");
            }
        });
        b25.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 25;
                b25.setText("Selected");
            }
        });
        b26.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 26;
                b26.setText("Selected");
            }
        });
        b27.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 28){
                    b28.setText("Select");
                }
                Panel.sprite = 27;
                b27.setText("Selected");
            }
        });
        b28.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Panel.sprite == 1){
                    b1.setText("Select");
                }else if(Panel.sprite == 2){
                    b2.setText("Select");
                }else if(Panel.sprite == 3){
                    b3.setText("Select");
                }else if(Panel.sprite == 4){
                    b4.setText("Select");
                }else if(Panel.sprite == 5){
                    b5.setText("Select");
                }else if(Panel.sprite == 6){
                    b6.setText("Select");
                }else if(Panel.sprite == 7){
                    b7.setText("Select");
                }else if(Panel.sprite == 8){
                    b8.setText("Select");
                }else if(Panel.sprite == 9){
                    b9.setText("Select");
                }else if(Panel.sprite == 10){
                    b10.setText("Select");
                }else if(Panel.sprite == 11){
                    b11.setText("Select");
                }else if(Panel.sprite == 12){
                    b12.setText("Select");
                }else if(Panel.sprite == 13){
                    b13.setText("Select");
                }else if(Panel.sprite == 14){
                    b14.setText("Select");
                }else if(Panel.sprite == 15){
                    b15.setText("Select");
                }else if(Panel.sprite == 16){
                    b16.setText("Select");
                }else if(Panel.sprite == 17){
                    b17.setText("Select");
                }else if(Panel.sprite == 18){
                    b18.setText("Select");
                }else if(Panel.sprite == 19){
                    b19.setText("Select");
                }else if(Panel.sprite == 20){
                    b20.setText("Select");
                }else if(Panel.sprite == 21){
                    b21.setText("Select");
                }else if(Panel.sprite == 22){
                    b22.setText("Select");
                }else if(Panel.sprite == 23){
                    b23.setText("Select");
                }else if(Panel.sprite == 24){
                    b24.setText("Select");
                }else if(Panel.sprite == 25){
                    b25.setText("Select");
                }else if(Panel.sprite == 26){
                    b26.setText("Select");
                }else if(Panel.sprite == 27){
                    b27.setText("Select");
                }
                Panel.sprite = 28;
                b28.setText("Selected");
            }
        });
        if(Panel.sprite == 1){
            b1.setText("Selected");
        }else if(Panel.sprite == 2){
            b2.setText("Selected");
        }else if(Panel.sprite == 3){
            b3.setText("Selected");
        }else if(Panel.sprite == 4){
            b4.setText("Selected");
        }else if(Panel.sprite == 5){
            b5.setText("Selected");
        }else if(Panel.sprite == 6){
            b6.setText("Selected");
        }else if(Panel.sprite == 7){
            b7.setText("Selected");
        }else if(Panel.sprite == 8){
            b8.setText("Selected");
        }else if(Panel.sprite == 9){
            b9.setText("Selected");
        }else if(Panel.sprite == 10){
            b10.setText("Selected");
        }else if(Panel.sprite == 11){
            b11.setText("Selected");
        }else if(Panel.sprite == 12){
            b12.setText("Selected");
        }else if(Panel.sprite == 13){
            b13.setText("Selected");
        }else if(Panel.sprite == 14){
            b14.setText("Selected");
        }else if(Panel.sprite == 15){
            b15.setText("Selected");
        }else if(Panel.sprite == 16){
            b16.setText("Selected");
        }else if(Panel.sprite == 17){
            b17.setText("Selected");
        }else if(Panel.sprite == 18){
            b18.setText("Selected");
        }else if(Panel.sprite == 19){
            b19.setText("Selected");
        }else if(Panel.sprite == 20){
            b20.setText("Selected");
        }else if(Panel.sprite == 21){
            b21.setText("Selected");
        }else if(Panel.sprite == 22){
            b22.setText("Selected");
        }else if(Panel.sprite == 23){
            b23.setText("Selected");
        }else if(Panel.sprite == 24){
            b24.setText("Selected");
        }else if(Panel.sprite == 25){
            b25.setText("Selected");
        }else if(Panel.sprite == 26){
            b26.setText("Selected");
        }else if(Panel.sprite == 27){
            b27.setText("Selected");
        }else if(Panel.sprite == 28){
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
        scroll_edit.setBounds(0,100,screenSize.width-5,screenSize.height-160);
        scroll_edit.setPreferredSize(new Dimension(screenSize.width+5,screenSize.height+5));
        scroll_edit.getVerticalScrollBar().setUnitIncrement(15);
        f.add(scroll_edit);
        c.repaint();
    }
}