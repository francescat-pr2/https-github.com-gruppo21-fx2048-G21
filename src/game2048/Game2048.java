package game2048;

import static javafx.application.Application.launch;
import static java.awt.event.InputEvent.BUTTON1_MASK;
import com.sun.glass.events.KeyEvent;
import giocatoreAutomatico.GiocatoreAutomatico;
import giocatoreAutomatico.player.MyGiocatoreAutomatico;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.Timer;

/**
 * @author bruno.borges@oracle.com
 */
public class Game2048 extends Application {


    private GameManager gameManager;
    private Bounds gameBounds;
    private GiocatoreAutomatico myPlayer;
   


    Robot rbt2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameManager = new GameManager();
        gameBounds = gameManager.getLayoutBounds();
        
        //restituisce un oggetto di tipo giocatoreAutomatico
        myPlayer = GiocatoreAutomatico.getGiocatoreAutomatico();

        //oggeto button per 'attivare' il giocatore automatico
        Button button2 = new Button("Giocatore Automatico");
        
        StackPane root = new StackPane(gameManager);
        root.setPrefSize(gameBounds.getWidth(), gameBounds.getHeight());
        ChangeListener<Number> resize = (ov, v, v1) -> {
            gameManager.setLayoutX((root.getWidth() - gameBounds.getWidth()) / 2d);
            gameManager.setLayoutY((root.getHeight() - gameBounds.getHeight()) / 2d);
        };
        root.widthProperty().addListener(resize);
        root.heightProperty().addListener(resize);

        Scene scene = new Scene(root, 600, 720);
        scene.getStylesheets().add("game2048/game.css");
        addKeyHandler(scene);
        addSwipeHandlers(scene);

       // addBtnClicked(scene);
        
        
        if (isARMDevice()) {
            primaryStage.setFullScreen(true);
            primaryStage.setFullScreenExitHint("");
        }

        if (Platform.isSupported(ConditionalFeature.INPUT_TOUCH)) {
            scene.setCursor(Cursor.NONE);
        }

        primaryStage.setTitle("2048FX");
        
        //allineamento e aggiunta del button nella finestra
        button2.setTranslateX(10);
        button2.setTranslateY(100);
        root.setAlignment(button2,Pos.TOP_CENTER);
        root.getChildren().add(button2);

        
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(gameBounds.getWidth());
        primaryStage.setMinHeight(gameBounds.getHeight());
        primaryStage.show();
        
        
          //creazione dell oggetto robot che andrà a simulare la pressione di un tasto
        try {
                rbt2=new Robot();
        }catch (AWTException ex) {
                   Logger.getLogger(Game2048.class.getName()).log(Level.SEVERE, null, ex);
        }

       //azione che viene svolta alla pressione del button 'Giocatore Automatico'
       button2.setOnAction((ActionEvent event) -> {
           //System.out.println("button premuto");
           //istanzia un nuovo Thread 
          Thread t=
              new Thread(new Runnable() {
              //implementa le azioni che si svolgono nel nuovo thread
              @Override
              public void run() {
                  //System.out.println("thread lanciato");
                  //boolean di controllo per il ciclo while 
                  boolean cnt=gameManager.gameOver;
                  //al game over del gioco l'esecuzione del thread viene terminata
                  while(!cnt)
                  
                  try {
                        //se la finestra del gioco viene chiusa prima del game over
                        //il valore boolean di controllo del while cambia permettendo 
                        //di terminare il thread anche in questo caso
                       if(!primaryStage.isShowing()){
                           cnt=true;
                         return;
                            
                      }
                      
                       //System.out.println("while "+ gameManager.gameOver);
                        //l'oggetto Robot simula la pressione del tasto SHIFT che verrà catturato dal listener
                       rbt2.keyPress(KeyEvent.VK_SHIFT);
                      // System.out.println("SHIFT premuto");
                       //rilascio del tasto SHIFT
                       rbt2.keyRelease(KeyEvent.VK_SHIFT);
                      
                      //System.out.println(primaryStage.isShowing());
                      //il thread rimane in pausa 200 cent di sec
                      Thread.sleep(200);//mezzo secondo
                      
                      
                  } catch (InterruptedException ex) {
                      Logger.getLogger(Game2048.class.getName()).log(Level.SEVERE, null, ex);
                  }
               
                 }
              //}
          });//.start();
          //il thread viene mandato in esecuzione
          t.start();
           
           
           

        } );
        
                
    }

    private boolean isARMDevice() {
        return System.getProperty("os.arch").toUpperCase().contains("ARM");
    }

    private void addKeyHandler(Scene scene) {
       
        scene.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if (keyCode.equals(KeyCode.SHIFT)) {
               // System.out.println("SHIFT catturato");
                addBtnClicked();
                return;
            }
            if (keyCode.equals(KeyCode.S)) {
                gameManager.saveSession();
                return;
            }
            if (keyCode.equals(KeyCode.R)) {
                gameManager.restoreSession();
                return;
            }
            if (keyCode.isArrowKey() == false) {
                return;
            }
            
            
            
            Direction direction = Direction.valueFor(keyCode);
            gameManager.move(direction);
        });
    }

    private void addSwipeHandlers(Scene scene) {
        scene.setOnSwipeUp(e -> gameManager.move(Direction.UP));
        scene.setOnSwipeRight(e -> gameManager.move(Direction.RIGHT));
        scene.setOnSwipeLeft(e -> gameManager.move(Direction.LEFT));
        scene.setOnSwipeDown(e -> gameManager.move(Direction.DOWN));
        
    }
    
    
    
    
    //ascoltatore dell evento button Giocatore Automatico cliccato
    private void addBtnClicked(){//Scene scene) {
        
        //implementazione delle azione svolte quando viene cliccato il tasto SHIFT
       // scene.setOnKeyPressed(ke -> {
         // KeyCode keyCode = ke.getCode();
           // if (keyCode.equals(KeyCode.SHIFT)) {
                
                int pross;
                Direction direction=null;
          
                //valore int restituito dal metodo del Giocatore Automatico per la mossa da eseguire
                pross = myPlayer.prossimaMossa(gameManager.myGriglia);
                
                //ad ogni valore tra 0 e 3 viene assegnata la direzione della mossa
                switch(pross){
                    case 0: direction = Direction.UP;
                        //gameManager.move(Direction.UP);
                        System.out.println("mossa "+ pross);
                        break;
                    case 1: direction = Direction.RIGHT;
                        //gameManager.move(Direction.RIGHT);
                        System.out.println("mossa "+ pross);
                        break;
                    case 2: direction = Direction.DOWN;
                        //gameManager.move(Direction.DOWN);
                        System.out.println("mossa "+ pross);
                        break;
                    case 3: direction = Direction.LEFT;
                        //gameManager.move(Direction.LEFT);
                        System.out.println("mossa "+ pross);
                        break;
                }
                //viene richiamato il metodo move per eseguire la mossa in base alla direzione restituita
                gameManager.move(direction);
                //System.out.println(gameManager);
                //System.out.println(gameManager.gameOver);
          //  }});

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
