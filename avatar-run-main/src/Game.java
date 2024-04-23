/**
 * PANEL DE JUEGO Y OPCIONES DE BASE
 * @author fucalex
 * 
 */

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.lang.Thread;
/**
 * El panel de juego (Game) hereda atributos y métodos de la clase principal
 * (o clase base) "JPanel", sin embargo, "Game", al ser una subclase, puede 
 * agregar sus propios campos y métodos. (Pilar fundamental de la POO).
 */
public class Game extends JPanel{
    Maze maze=new Maze();
    Avatar avatar=new Avatar();
    public static int level=1;

    public  static  String wordInput = "";
    public  static  String word = "";

   /**
    * Para leer del teclado es necesario registrar un objeto que se encargue de 
    * "escuchar" si una tecla es presionada. Este objeto es conocido como 
    * "Listener", con metodos que seran llamados cuando se presione una tecla. 
    * Aqui, el Listener se registra en "Game" usando el método addKeyListener.
    * 
    * Nota: la (e), significa "event"
    */

    public  Game(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    avatar.teclaPresionada(e);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        
             @Override
            public void keyReleased(KeyEvent e) {
            
            }
        
    });
        setFocusable(true);
    }
    
   /**
    * Las caracteristicas visibles del laberinto y el personaje, son definidas 
    * en sus respectivos archivos
     * @param grafico
    */

    public void paint(Graphics grafico){
        maze.paint(grafico);
        avatar.paint(grafico);
    }
   /**
    * Para cambiar de nivel, cuando el avatar llegue a una posicion determinada
    * en el laberinto (definido en avatar.java), al nivel actual se le sumará 
    * una unidad para indicar que se debe cargar el siguiente nivel en el
	* frame del juego.
    */    
    public static int changeLevel(){
        return level++;
    }
    
   /**
    * Para cargar el laberinto, cuando se cargue la base del siguiente nivel,
    * dependiendo el número de la misma (1, 2 o 3), se cargará el laberinto
    * (definido en maze.java), por medio de "return level".
    */

   public static String encrypt(String message, int key) {
       String alphabet = "abcdefghijklmnopqrstuvwxyz";

       String encrypted = "";
       for(int i =0 ; i<message.length() ; i++){
           char ch =message.charAt(i);
           int index = alphabet.indexOf(ch);
           int total = index * key % 26;
           encrypted += alphabet.charAt(total);
       }
       return encrypted;
   }

    private static final String key = "MySecretKey12345";


    public static String encryptAES(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt) {
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

    public static int getLevel(){
        return level;
    }
    
   /**
    * Aqui definimos el tamaño y el titulo de la ventana del juego 
    * (en pixeles (ancho, alto), qué va a ir en ella (el juego en sí y su 
    * localizacion ["setlocation", definido en coordenadas]), y la forma en la 
    * que cerraremos el juego.
    */ 

    public static void main(String[]args) throws Exception {

                 String input = JOptionPane.showInputDialog("<html><body style='width: 100%; borderRadius: 10px; text-align: center; background:#38bdf8; border-radius: 5px; border:6px solid #1d4ed8; '>"
                        + "<h1 style='font-size: 20px; color:#082f49; '>Game " +
                         "N & M</h1>"
                        + "<p style='font-size: 12px; color:pink'>الرجاء إدخال اسمك لبدء في إنقاذ الأميرة:</p>"
                        + "</body></html>");

                JOptionPane.showMessageDialog(null ,"<html><body style='width: 100%; border-style: dashed; borderRadius: 10px; text-align: center; background:red; border-radius: 5px; border:6px solid #450a0a; '>"
                        + "<h1 style='font-size: 20px; color:#450a0a; font-weight: 700; '>تحذير!!</h1>"
                        + "<p style='font-size: 16px; color:#450a0a'>  تم تشفير اسمك يا  "+" ( "+ input+ " ) "+"قم بالتقاط الاحرف المشفره وجمعها لتساعدك في فك شفره باب القلعه</p>"
                        + "</body></html>");



                 wordInput = encryptAES(input);
                 word = input;

       JFrame myWindow=new JFrame("N & M ∫_☻");
       Game game =new Game();
       myWindow.add(game);
       myWindow.setSize(920,540);
       myWindow.setLocation(300,200);
       myWindow.setVisible(true);
       myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

       
       while (true){
           try {
               Thread.sleep(10);
        } catch (InterruptedException ex) {
             Logger.getLogger(Game.class.getName()).log(Level.SEVERE, "you lose");
        }
        myWindow.repaint();   
        


        if(getLevel()>3){
            JOptionPane.showMessageDialog(null, "you did it! see you soon.");
            System.exit(0);
            }
        }
    }
}



