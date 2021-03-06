/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackpeli;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author s1601378
 */
public class BlackJackPeli extends Application {

    @Override
    public void start(Stage primaryStage) {

        KorttiPakka pakka = new KorttiPakka(1);
        System.out.println(pakka);

        PelaajanKasi pelaajanKasi = new PelaajanKasi();

        primaryStage.setTitle("BlackJack Peli!");

        //luodaan GridPane objekti, asetetaan muuttujaan nimeltä grid
        GridPane grid = new GridPane();
        //muutetaan oletussijainti (vasen yläkulma) -> keskelle ruutua
        grid.setAlignment(Pos.CENTER);

        //gap ominaisuudet määrittävät välin rivien ja sarakkeiden välillä
        grid.setHgap(10);
        grid.setVgap(10);

        //kontrolloi tyhjää tilaa GridPanen reunojen ympärillä
        //järjestyksessä ylä reuna, oikea reuna, ala reuna ja vasen reuna
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Luo Text objektin (jota ei voi editoida) asettaa muuttujaan scenetitle tekstin "Welcome"
        Text scenetitle = new Text("Tervetuloa pelaamaan");
        //Käytetään setFont() metodia, ja asetetaan  fontti perhe (font family), lihavointi/painotus (weight), ja fontin koon scenetitle muuttujalle
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));//Style sheet parempi kuin inline tyyli
        //Lisääs scenetitle muuttujan Gridiin
        /*
         Numerointi sarakkeille ja riveille alkaa nollasta (0) ja scenetitle lisätään sarakkeeseen 0 ja riville 0
        The last two arguments of the grid.add() method set the sarake väli (column span) kakkoseksi (2) ja rivivälin (row span) ykköseksi (1).
        
         */
        grid.add(scenetitle, 0, 0, 2, 1);

        /*
        Tehdään Label objekti tekstillä "User Name" sarakkeeseen nolla (0), riville yksi (1) Text Field objekti, jota voi editoida.
        text field lisätään grid paneen sarakkeeseen (1), riville yksi (1).
        A password field and label are created and added to the grid pane in a similar fashion.
         */
        Label pelaajanKortitLabel = new Label("Pelaajan kortit:");
        grid.add(pelaajanKortitLabel, 2, 1);

        TextArea pelaajanKortitTextArea = new TextArea();
        pelaajanKortitTextArea.setEditable(false);
        pelaajanKortitTextArea.setPrefHeight(300);
        pelaajanKortitTextArea.setPrefWidth(200);
        grid.add(pelaajanKortitTextArea, 2, 2);
        Label pelaajanKorttienSumma = new Label("Korttien summa: " + pelaajanKasi.selvitaSumma());
        grid.add(pelaajanKorttienSumma, 2, 3);

        Label tietokoneenKortitLabel = new Label("Tietokoneen kortit:");
        grid.add(tietokoneenKortitLabel, 0, 1);

        TextArea tietokoneenKortitTextArea = new TextArea();
        tietokoneenKortitTextArea.setEditable(false);
        tietokoneenKortitTextArea.setPrefHeight(300);
        tietokoneenKortitTextArea.setPrefWidth(200);
        grid.add(tietokoneenKortitTextArea, 0, 2);

        int kortteja = 0;
        while (kortteja < 2) {

            Kortti jaettuKortti = pakka.jaaKortti();
            pelaajanKasi.otaKortti(jaettuKortti);
            pelaajanKortitTextArea.appendText(jaettuKortti + "\n");
            kortteja++;
        }
        
        if (pelaajanKasi.selvitaSumma() < 21) {
            //Luo napin nimellä btn ja labelillä "Sign in"
            Button lisaaKortti = new Button("Lisää kortti");
            Button lopeta = new Button("Lopeta");
            //Luo HBox layout pane nimeltään hbBtn with spacing of 10 pixels
            HBox hbBtn = new HBox(10);

            /*
            The HBox pane sets an alignment for the button that is different from the alignment applied to the other controls in the grid pane.
            The alignment property has a value of Pos.BOTTOM_RIGHT, which positions a node at the bottom of the space vertically and at the right edge of the space horizontally. 
             */
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            //The button is added as a child of the HBox pane, and the HBox pane is added to the grid in column 2, row 4
            hbBtn.getChildren().add(lopeta);
            hbBtn.getChildren().add(lisaaKortti);
            grid.add(hbBtn, 2, 4);

            lisaaKortti.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Kortti lisaKortti = pakka.jaaKortti();
                    pelaajanKasi.otaKortti(lisaKortti);
                    pelaajanKortitTextArea.appendText(lisaKortti + "\n");
                    pelaajanKorttienSumma.setText("Korttien summa: " + pelaajanKasi.selvitaSumma());
                }
            });
        }

        pelaajanKorttienSumma.setText("Korttien summa: " + pelaajanKasi.selvitaSumma());

        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
