
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Base64;

import javax.crypto.SecretKey;
public class Avatar {
    Maze lab=new Maze();
    public  static int x=40;
    public  static int y=40;
    int width=40;
    int height=40;
    int movement=40;

    private static final String key = "MySecretKey12345";


    public static String decryptAES(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    public void paint(Graphics grafico){
        grafico.setColor(Color.red);
        grafico.fillRect(x, y, width, height);
        grafico.setColor(Color.BLACK);
        grafico.drawRect(x, y, width, height);
        grafico.setColor(Color.black);
        grafico.fillOval(x+16,y+3,8,8);
        grafico.setColor(Color.black);
        grafico.fillRect(x+9,y+12,4,14);
        grafico.fillRect(x+11,y+12,4,4);
        grafico.fillRect(x+28,y+12,4,14);
        grafico.fillRect(x+26,y+12,4,4);
         grafico.fillRect(x+14,y+12,13,14);
        grafico.fillRect(x+14,y+24,6,14);
        grafico.fillRect(x+21,y+24,6,14);
    }

    public void teclaPresionada(KeyEvent event) throws Exception {



        int[][]maze=lab.getMaze();
        
        if(event.getKeyCode()==37){
            if(maze[y/40][(x/40)-1] !=1){
                x=x-movement;

            }
        }
        if(event.getKeyCode()==39){
            if(maze[y/40][(x/40)+1]!=1){
                x=x+movement;

            }
        }
        if(event.getKeyCode()==40){
            if(maze[(y/40)+1][x/40]!=1){
                y=y+movement;

            }
        }
        if(event.getKeyCode()==38){
            if(maze[(y/40)-1][x/40]!=1){
                y=y-movement;


            }
        }
        if(x==840 && y==440){

            String input = JOptionPane.showInputDialog("<html><body style='width: 100%; padding: 3px; border-style: dashed; borderRadius: 10px; text-align: center; background:rgb(120 53 15); border-radius: 5px; border:6px solid rgb(69 26 3); '>"
                    + "<h1 style='font-size: 20px; color:rgb(69 26 3); font-weight: 700; '>ادخل المفتاح لفتح الباب يعتمد هذا المفتاح على جميع المفاتيح التي تم التقاطها:</h1>"
                    + "</body></html>");

             if(Game.word.equals(decryptAES(input))){
                  JOptionPane.showMessageDialog(null ,"<html><body style='width: 100%; padding: 3px; border-style: dashed; borderRadius: 10px; text-align: center; background:rgb(34 197 94); border-radius: 5px; border:6px solid rgb(6 78 59); '>"
                          +"<h1 style='font-size: 20px; color:rgb(2 132 199);; font-weight: 700; '>"+"\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89لقد فزت , قمت بأنقاذ الاميره \uD83D\uDC83\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89"+"</h1>"
                                 + "<p style='font-size: 20px; color:rgb(2 132 199);; font-weight: 700; '>"+Game.word+" -to- "+ Game.wordInput+"</p>"
                                 + "</body></html>"
                                );
             }else{
                 JOptionPane.showMessageDialog(null ,"loss");
             }


            x=40;
            y=40;
        }



            if(x==200 && y==200){

                JOptionPane.showMessageDialog(null ,"<html><body style='width: 100%; padding: 3px; border-style: dashed; borderRadius: 10px; text-align: center; background:#dcfce7; border-radius: 5px; border:6px solid #38bdf8; '>"
                        + "<h1 style='font-size: 20px; color:#38bdf8; font-weight: 700; '>"+Game.wordInput.charAt(6)+" "+Game.wordInput.charAt(7)+" "+Game.wordInput.charAt(8)+" "+Game.wordInput.charAt(9)+" "+Game.wordInput.charAt(10)+" "+Game.wordInput.charAt(11)+"</h1>"
                         + "</body></html>");
             }
            if(x==280 && y==280){
                JOptionPane.showMessageDialog(null ,"<html><body style='width: 100%; padding: 3px; border-style: dashed; borderRadius: 10px; text-align: center; background:#dcfce7; border-radius: 5px; border:6px solid #38bdf8; '>"
                        + "<h1 style='font-size: 20px; color:#38bdf8; font-weight: 700; '>"+Game.wordInput.charAt(0)+" "+Game.wordInput.charAt(1)+" "+Game.wordInput.charAt(2)+" "+Game.wordInput.charAt(3)+" "+Game.wordInput.charAt(4)+" "+Game.wordInput.charAt(5)+"</h1>"
                        + "</body></html>");
             }
            if(x==480 && y==360){
                JOptionPane.showMessageDialog(null ,"<html><body style='width: 100%; padding: 3px; border-style: dashed; borderRadius: 10px; text-align: center; background:#dcfce7; border-radius: 5px; border:6px solid #38bdf8; '>"
                        + "<h1 style='font-size: 20px; color:#38bdf8; font-weight: 700; '>"+Game.wordInput.charAt(12)+" "+Game.wordInput.charAt(13)+" "+Game.wordInput.charAt(14)+" "+Game.wordInput.charAt(15)+" "+Game.wordInput.charAt(16)+" "+Game.wordInput.charAt(17)+ "</h1>"
                        + "</body></html>");
             }
            if(x==720 && y==200){
                JOptionPane.showMessageDialog(null ,"<html><body style='width: 100%; padding: 3px; border-style: dashed; borderRadius: 10px; text-align: center; background:#dcfce7; border-radius: 5px; border:6px solid #38bdf8; '>"
                        + "<h1 style='font-size: 20px; color:#38bdf8; font-weight: 700; '>"+Game.wordInput.charAt(18)+" "+Game.wordInput.charAt(19)+" "+Game.wordInput.charAt(20)+" "+Game.wordInput.charAt(21)+" "+Game.wordInput.charAt(22)+" "+Game.wordInput.charAt(23)+"</h1>"
                        + "</body></html>");
             }


    }
}   
