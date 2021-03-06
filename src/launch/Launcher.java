package launch;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Launcher extends Application{

    private static Stage stage;

    //les trucs abstract servent √† faire les points d'extensibilit√© pour que le code soit SOLID comme on l'apprend en cours, parce que c'est demand√©.
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Chargement du scenario
        stage = primaryStage;
        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/Background1.fxml")));
        stage.setScene(scene);
        stage.show();
    }


    public static Stage getStage() {
        return stage;
    }
}


/*
COMMENT FAIRE DES PROPRIETES JFX
private StringProperty toto = new SimpleStringProperty();
    public String getToto{return toto.get();
    public void setToto(String value){toto.set(valeur);}
    public ReadOnlyStringProperty totoProperty(){return toto;}

objet.propiete().bind(objet2.property())
-------------bindBidirectionel(------);
<Button text="${objet.prop}" />





 Boucleur: juste beep



 a faire: gestion des PVs, ennemis, regler collision gauche/haut avec l'attaque
 Fait: attaque vers toutes directions (ZQSD), deplacement d'attaque, collisionneur d'attaque
 */