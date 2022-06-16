/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import util.NetworkConnection;
import util.Reader;

/**
 *
 * @author DELL
 */
public class DemoProject extends Application {

    public static TextArea txtarea = new TextArea();
    public static String str = null;
    public static String name = null;

    NetworkConnection nc;
    int friendscount = 0;

    @Override
    public void start(Stage primaryStage) {

        TextField profiletext1 = new TextField();
        TextField profiletext2 = new TextField();
        TextField profiletext3 = new TextField();
        TextField profiletext4 = new TextField();
        TextField profiletext5 = new TextField();
        TextField profiletext6 = new TextField();
        profiletext1.setPromptText("Where do you work?");
        profiletext2.setPromptText("Where do you study?");
        profiletext3.setPromptText("Where did you study?");
        profiletext4.setPromptText("When you born?");
        profiletext5.setPromptText("Where do you live?");
        profiletext6.setPromptText("where are you from?");
        Button profilecompletebutton = new Button("Complete");
        VBox profilevbox = new VBox();
        profilevbox.setPadding(new Insets(10, 10, 10, 10));
        profilevbox.setSpacing(10);
        profilevbox.getChildren().addAll(profiletext1, profiletext2, profiletext3, profiletext4, profiletext5, profiletext6, profilecompletebutton);
        BorderPane profilepane = new BorderPane();
        profilepane.setCenter(profilevbox);
        Scene profilescene = new Scene(profilepane, 400, 400);

        ImageView myimageview = new ImageView();
        myimageview.setFitWidth(80);
        myimageview.setFitHeight(80);
        myimageview.setPreserveRatio(true);
        myimageview.setSmooth(true);
        myimageview.setCache(true);
        Label profilename = new Label();
        profilename.setPrefSize(350, 10);
        HBox profilenamelabel = new HBox();
        profilenamelabel.setPadding(new Insets(10, 10, 10, 10));
        profilenamelabel.setSpacing(30);
        profilenamelabel.getChildren().addAll(myimageview, profilename);
        Button PicChangebutton = new Button("Change");
        Button unfriendbtn=new Button("Unfriend");
     DropShadow shadow = new DropShadow();
     unfriendbtn.setEffect(shadow);
        Button othersprofilebtn=new Button("Profile");
        
        VBox othersprofilevbox=new VBox();
        HBox othersimagename=new HBox();
        ImageView othersimage=new ImageView();
      othersimage.setFitWidth(80);
       othersimage.setFitHeight(80);
        othersimage.setPreserveRatio(true);
       othersimage.setSmooth(true);
        othersimage.setCache(true);
        Label othersnamelabel=new Label() ;
       othersimagename.getChildren().addAll(othersimage,othersnamelabel);
       Label[] othersprofilelabel=new Label[6];
       for(int i=0;i<6;i++)
           othersprofilelabel[i]=new Label();
       BorderPane otherprofilepane=new BorderPane();
       othersprofilevbox.getChildren().addAll(othersimagename,othersprofilelabel[0],othersprofilelabel[1],othersprofilelabel[2],othersprofilelabel[3],othersprofilelabel[4],othersprofilelabel[5]);
       otherprofilepane.setLeft(othersprofilevbox);
     
       
        PicChangebutton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            System.out.println("hello its here where?");
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
            System.out.println("hello its hereiam");
            try {
                BufferedImage bufferedImage=null;
                Image image=null;
                if(file!=null)
                {bufferedImage = ImageIO.read(file);

                 image = SwingFXUtils.toFXImage(bufferedImage, null);
                }
                if(image==null)
                {
                    System.out.println("not select");
                }
                else{
                File f = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + name + ".jpg");
                f.createNewFile();
                ImageIO.write(bufferedImage, "jpg", f);
                //image.widthProperty(20);
                System.out.println("hello its here");
                myimageview.setImage(image);
                }
            } catch (IOException ex) {
                System.out.println("h");
                Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        Label[] profilelabel = new Label[6];
        for (int i = 0; i < 6; i++) {
            profilelabel[i] = new Label();
            profilelabel[i].setPrefHeight(15);
            profilelabel[i].setPrefWidth(400);
            profilelabel[i].isWrapText();
        }
        Button editbutton = new Button("Edit");
        editbutton.setOnAction(e -> {
            try {
                Scanner scan = new Scanner(new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + name + "profile" + ".txt"));
                int sc = 0;
                while (scan.hasNextLine()) {
                    String str = scan.nextLine();
                    if (sc == 0) {
                        profiletext1.setText(str);
                    }
                    if (sc == 1) {
                        profiletext2.setText(str);
                    }
                    if (sc == 2) {
                        profiletext3.setText(str);
                    }
                    if (sc == 3) {
                        profiletext4.setText(str);
                    }
                    if (sc == 4) {
                        profiletext5.setText(str);
                    }
                    if (sc == 5) {
                        profiletext6.setText(str);
                    }
                    sc++;
                }
            } catch (Exception ef) {

            }

            //File f=new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\"+name+"profile"+".txt");
            try {
                FileWriter fwOb = new FileWriter("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + name + "profile" + ".txt", false);
                PrintWriter pwOb = new PrintWriter(fwOb, false);
                pwOb.flush();
                pwOb.close();
                fwOb.close();

            } catch (Exception ef) {

            }
            primaryStage.setScene(profilescene);
            primaryStage.show();
        });

        TextField text1 = new TextField();
        Label scenedeatilusername = new Label();
        Label scenedetailpassword = new Label();
        Label welcomelabel = new Label("Welcome");

        Label sceneusername = new Label();
        Label label = new Label();
        Label label1scene1 = new Label();
        Label label2scene1 = new Label();
        label1scene1.setText("Username");
        label2scene1.setText("Password");
        Button newaccount = new Button("New Account");
        newaccount.setPrefSize(120, 15);
        TextField textscene1 = new TextField();
        textscene1.setPrefSize(80, 30);
        PasswordField password = new PasswordField();
        password.setPrefSize(80, 30);
        VBox vboxlabelscene1 = new VBox();
        vboxlabelscene1.setPadding(new Insets(10, 10, 10, 10));
        vboxlabelscene1.setSpacing(20);
        vboxlabelscene1.getChildren().addAll(label1scene1, label2scene1);
        VBox vboxscene1 = new VBox();
        Button scene1btn = new Button("Log in");
        vboxscene1.getChildren().addAll(textscene1, password, scene1btn, newaccount);
        vboxscene1.setPadding(new Insets(10, 10, 10, 10));
        vboxscene1.setSpacing(20);
        BorderPane bpane = new BorderPane();
        bpane.setLeft(vboxlabelscene1);
        //  bpane.setRight(newaccount);
        bpane.setCenter(vboxscene1);
        // TextField text2=new TextField();
        try {
            nc = new NetworkConnection("localhost", 12345);
        } catch (Exception e) {

        }

        Button btn1 = new Button("Send");
        //  Button btn2=new Button("Name Entry");
        BorderPane borpane = new BorderPane();
        borpane.setPadding(new Insets(10, 10, 10, 10));
        txtarea.setEditable(false);
        label.setFont(Font.font("Cambria", 32));

        //txtarea.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        //new NewThread(txtarea);
        text1.setPrefSize(400, 20);
        borpane.setCenter(txtarea);
        btn1.setPrefSize(50, 10);
        HBox hbox = new HBox();

        hbox.getChildren().addAll(text1, btn1);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(20);
        borpane.setTop(label);
        borpane.setBottom(hbox);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(welcomelabel, scenedeatilusername, scenedetailpassword);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(20);

        sceneusername.setFont(new Font("Tubular", 30));
        scenedeatilusername.setFont(new Font("Tubular", 20));
        scenedetailpassword.setFont(new Font("Tubular", 20));
        TextField signinusername = new TextField();
        signinusername.setPrefSize(120, 35);
        signinusername.setPromptText("Your username");
        Label signinlabel = new Label("Fields required");

        PasswordField signinpassword = new PasswordField();
        signinpassword.setPrefSize(120, 35);
        signinpassword.setPromptText("Your password");
        PasswordField signinconfirmpassword = new PasswordField();
        signinconfirmpassword.setPromptText("Confirm password");
        signinconfirmpassword.setPrefSize(120, 35);
        TextField signinemail = new TextField();
        signinemail.setPrefSize(120, 35);
        Button signincompletebutton = new Button("Complete");

        signinemail.setPromptText("Your email");

        TextField signincountry = new TextField();
        signincountry.setPrefSize(120, 35);
        signincountry.setPromptText("Your Country");
        VBox signinvbox = new VBox();

        signinvbox.getChildren().addAll(signinusername, signinpassword, signinconfirmpassword, signinemail, signincountry, signincompletebutton);
        signinvbox.setPadding(new Insets(10, 10, 10, 10));
        signinvbox.setSpacing(20);
        BorderPane signinbpane = new BorderPane();
        signinbpane.setCenter(signinvbox);
        Scene signinscene = new Scene(signinbpane, 400, 400);
        signinscene.getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
        Label loginfailed = new Label("Log in Failed");

        borpane.setTop(sceneusername);
        borpane.setLeft(vbox);

        TextField searchtext = new TextField();
        searchtext.setPrefSize(400, 20);
        Button searchbtn = new Button();
        try{
         File f = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\search.png");
                            f.createNewFile();
                            ImageView searchview=new ImageView();
                            searchview.setFitHeight(15);
                            searchview.setFitWidth(60);

                            BufferedImage bufferImage = ImageIO.read(f);
                           // BufferedImage img=new ImgUtils().scaleImage(50,50,"c:/test.jpg");
                            Image image = SwingFXUtils.toFXImage(bufferImage, null);
                            searchview.setImage(image);
                            searchbtn.setGraphic(searchview);
        }
        catch(Exception ef)
        {
            
        }
        HBox searchhbox = new HBox();
        searchhbox.getChildren().addAll(searchtext, searchbtn);
        searchhbox.setPadding(new Insets(10, 10, 10, 10));
        Button[] friendsbutton = new Button[20];
        Label searchlabel = new Label();
        searchlabel.setPrefSize(100, 10);
        searchlabel.setFont(Font.font("Cambria", 25));
        Button addButton = new Button("Add Friend");
        // Button editbutton=new Button("Edit");
        //editbutton.setTranslateX(200);
        //editbutton.setTranslateY(-200);
        addButton.setFont(Font.font("Cambria", 15));
        addButton.setPrefSize(120, 20);
        unfriendbtn.setPrefSize(120,20);
         Bloom bloom = new Bloom();
        bloom.setThreshold(1.0);
        unfriendbtn.setEffect(bloom);
        othersprofilebtn.setPrefSize(120, 20);
        HBox searchlabeladd = new HBox();
        searchlabeladd.getChildren().addAll(addButton, searchlabel,othersprofilebtn,unfriendbtn);
        searchlabeladd.setPadding(new Insets(10, 10, 10, 10));
        searchlabeladd.setSpacing(20);
        VBox searchvbox = new VBox();
        searchvbox.setPadding(new Insets(10, 10, 10, 10));
        searchvbox.setSpacing(20);
        searchvbox.getChildren().addAll(searchhbox, searchlabeladd, profilenamelabel, PicChangebutton, profilelabel[0], profilelabel[1], profilelabel[2], profilelabel[3], profilelabel[4], profilelabel[5], editbutton);
        BorderPane searchpane = new BorderPane();
        searchpane.setTop(searchvbox);
        // searchpane.setBottom(editbutton);
        Scene searchscene = new Scene(searchpane, 600, 600);
        searchscene.getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
        VBox NameVbox = new VBox();
        NameVbox.setPadding(new Insets(10, 10, 10, 10));
        othersprofilebtn.setOnAction(e->{
            try{
                for(int i=0;i<6;i++)
                {
                    othersprofilelabel[i].setText(null);
                }
            File fil = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + searchlabel.getText()+ "profile" + ".txt");
                            fil.createNewFile();
                            Scanner sc2 = new Scanner(fil);
                            int flag = 0;

                            System.out.println("ami");
                            while (sc2.hasNextLine()) {
                                String stri = sc2.nextLine();
                                if ((flag == 0) && (stri.length() > 0)) {
                                    othersprofilelabel[flag].setText("works at " + stri);
                                }
                                if ((flag == 0) && (stri.length() == 0)) {
                                    othersprofilelabel[flag].setText(" ");
                                }
                                if ((flag == 1) && (stri.length() > 0)) {
                                othersprofilelabel[flag].setText("studies at " + stri);
  

                                }
                                if ((flag == 1) && (stri.length() == 0)) {
                                    othersprofilelabel[flag].setText(" ");
                                }
                                if ((flag == 2) && (stri.length() > 0)) {
                                 othersprofilelabel[flag].setText("Studied at " + stri);
                                }
                                if ((flag == 2) && (stri.length() == 0)) {
                                   othersprofilelabel[flag].setText(" ");
                                }
                                if ((flag == 3) && (stri.length() > 0)) {
                                    othersprofilelabel[flag].setText("Born in " + stri);
                                }
                                if ((flag == 3) && (stri.length() == 0)) {
                                    othersprofilelabel[flag].setText(" ");
                                }
                                if ((flag == 4) && (stri.length() > 0)) {
                                    othersprofilelabel[flag].setText("Lives in " + stri);
                                }
                                if ((flag == 4) && (stri.length() == 0)) {
                                    othersprofilelabel[flag].setText(" ");
                                }
                                if ((flag == 5) && (stri.length() > 0)) {
                                   othersprofilelabel[flag].setText("From " + stri);
                                }
                                if ((flag == 4) && (stri.length() == 0)) {
                                   othersprofilelabel[flag].setText(" ");
                                }
                                //profilelabel[flag].setText(stri);
                                System.out.println(stri);
                                flag++;
                                
                                // primaryStage.setScene(searchscene);
                            }
                             File f = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + searchlabel.getText() + ".jpg");
                            f.createNewFile();
                            BufferedImage bufferedImage = ImageIO.read(f);
                            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                            othersimage.setImage(image);
                            othersnamelabel.setText(searchlabel.getText());
                            BorderPane b=new BorderPane();
                            Stage st=new Stage();
                            if (otherprofilepane.getScene() != null) {
                                otherprofilepane.getScene().setRoot(b);
                }
                              Scene othersscene=new Scene(otherprofilepane,400,400);
                                st.setScene(othersscene);
                                st.show();
            }
            catch(Exception ef)
            {
                
            }
            
        });
         
        // NameVbox.setSpacing(20);
        unfriendbtn.setOnAction(e->{
            String[] str=new String[20];
           int d=0;
            for(int i=0;i<friendscount;i++)
            {
                NameVbox.getChildren().clear();
                if(friendsbutton[i].getText().equals(searchlabel.getText())==false)
                {
                    str[d]=new String();
                    System.out.println(str[d]);
                    str[d]=friendsbutton[i].getText();
                    d++;
                }
            }
            friendscount=d;
            for(int i=0;i<d;i++)
            {
                System.out.println(str[i]);
                friendsbutton[i].setText(str[i]);
                //NameVbox.
                                NameVbox.getChildren().add(friendsbutton[i]);
                                //friendscount++;
                                //NameVbox.setTranslateY(-200);
                                searchpane.setRight(NameVbox);
            }
           
             try {
                 
                FileWriter fwOb = new FileWriter("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\" + name + "friends" + ".txt", false);
                PrintWriter pwOb = new PrintWriter(fwOb, false);
                pwOb.flush();
                pwOb.close();
                fwOb.close();

            } catch (Exception ef) {

            }
             try{
             File file=new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\" + name + "friends" + ".txt");
             file.createNewFile();
             FileWriter fw=null;
             BufferedWriter bw=null;
             fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
              for(int i=0;i<d;i++)
            {
              bw.write(str[i]);
              
              bw.write("\r\n");
            }
             }
             catch(Exception ef)
             {
                 
             }
            
        });
        profilecompletebutton.setOnAction(e -> {
            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                File file = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + name + "profile" + ".txt");
                //FileWriter fw=null;
                //BufferedWriter bw=null;
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                if (profiletext1.getText() != null) {
                    bw.write(profiletext1.getText());
                } else {
                    bw.write(profiletext1.getText());
                }
                bw.write("\r\n");
                if (profiletext2.getText() != null) {
                    bw.write(profiletext2.getText());
                } else {
                    bw.write(profiletext2.getText());
                }
                bw.write("\r\n");

                if (profiletext3.getText() != null) {
                    bw.write(profiletext3.getText());
                } else {
                    bw.write(profiletext3.getText());
                }
                bw.write("\r\n");
                if (profiletext4.getText() != null) {
                    bw.write(profiletext4.getText());
                } else {
                    bw.write(profiletext4.getText());
                }
                bw.write("\r\n");
                if (profiletext5.getText() != null) {
                    bw.write(profiletext5.getText());
                } else {
                    bw.write(profiletext5.getText());
                }
                bw.write("\r\n");
                if (profiletext6.getText() != null) {
                    bw.write(profiletext6.getText());
                } else {
                    bw.write(profiletext6.getText());
                }
                bw.write("\r\n");
            } catch (Exception ef) {

            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                    if (fw != null) {
                        fw.close();
                    }
                } catch (Exception ef) {
                    System.out.println(ef);
                }
            }
          
            try {
                File fil = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + name + "profile" + ".txt");
                fil.createNewFile();
                Scanner sc = new Scanner(fil);
                int f = 0;
                while (sc.hasNextLine()) {
                    String str = sc.nextLine();
                    System.out.println(str);
                    if ((f == 0) && (str.length() > 0)) {
                        profilelabel[f].setText("works at " + str);
                    }
                    if ((f == 0) && (str.length() == 0)) {
                        profilelabel[f].setText("");
                    }
                    if ((f == 1) && (str.length() > 0)) {
                        profilelabel[f].setText("Studies at " + str);
                    }
                    if ((f == 1) && (str.length() == 0)) {
                        profilelabel[f].setText(" ");
                    }

                    if ((f == 2) && (str.length() > 0)) {
                        profilelabel[f].setText("Studied  at " + str);
                    }
                    if ((f == 2) && (str.length() == 0)) {
                        profilelabel[f].setText(" ");
                    }

                    if ((f == 3) && (str.length() > 0)) {
                        profilelabel[f].setText("Born in " + str);
                    }
                    if ((f == 3) && (str.length() == 0)) {
                        profilelabel[f].setText(" ");
                    }

                    if ((f == 4) && (str.length() > 0)) {
                        profilelabel[f].setText("Lives in " + str);
                    }
                    if ((f == 4) && (str.length() == 0)) {
                        profilelabel[f].setText(" ");
                    }
                    if ((f == 5) && (str.length() > 0)) {
                        profilelabel[f].setText("From " + str);
                    }
                    if ((f == 5) && (str.length() == 0)) {
                        profilelabel[f].setText(" ");
                    }

                   f++;
                } 
            } catch (Exception ef) {

            }
            primaryStage.setScene(searchscene);
            primaryStage.show();

        });
        for (int i = 0; i < 20; i++) {
            friendsbutton[i] = new Button();
            friendsbutton[i].setPrefSize(120, 20);
            friendsbutton[i].setFont(Font.font("Cambria", 18));
        }

        Button[] sendarray = new Button[20];
        final TextField[] sendtextfield = new TextField[20];
        TextArea[] sendtextarea = new TextArea[20];
        for (int i = 0; i < 20; i++) {
            sendarray[i] = new Button("send");
        }

        for (int i = 0; i < 20; i++) {
            sendtextfield[i] = new TextField();
        }
        HBox[] sendhbox = new HBox[20];
        for (int i = 0; i < 20; i++) {
            sendhbox[i] = new HBox();
        }
        String[] friendsbtnname = new String[20];
        for (int i = 0; i < 20; i++) {
            friendsbtnname[i] = new String();
        }
        Scene[] scen = new Scene[70];
        int source = 0;
        BorderPane[] bsendpane = new BorderPane[20];
        for (int i = 0; i < 20; i++) {
            bsendpane[i] = new BorderPane();
        }
        Stage[] sendstage = new Stage[20];
        for (int i = 0; i < 20; i++) {
            sendstage[i] = new Stage();
        }

        for (int i = 0; i < 20; i++) {
            sendtextarea[i] = new TextArea();
            sendtextarea[i].setEditable(false);
            sendtextarea[i].setWrapText(true);
            sendtextarea[i].setPrefSize(200, 300);
        }
        int sendint, kh = 0;
        for (sendint = 0; sendint < 20; sendint++) {
            final int i = sendint;
            friendsbutton[sendint].setOnAction(e -> {
                //bsendpane.setTop(sendarray[sendint]);
                int project = 0;
                System.out.println(i + "i");
                friendsbtnname[i] = ((Button) e.getSource()).getText();
                System.out.println(friendsbtnname[i] + "friends btn name");
                sendhbox[i].getChildren().clear();

                sendhbox[i].getChildren().addAll(sendtextfield[i], sendarray[i]);
                bsendpane[i].setBottom(sendhbox[i]);
                bsendpane[i].setRight(sendtextarea[i]);
                sendtextarea[i].setText("");
                if (project == 0) {
                    try {
                        System.out.println(friendsbtnname[i] + "name");
                        File fool = null;
                        try {
                            fool = new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\" + name + friendsbtnname[i] + ".txt");
                            fool.createNewFile();
                        } catch (Exception ef) {

                        }

                        Scanner scan = new Scanner(fool);
                        while (scan.hasNextLine()) {
                            String str = scan.nextLine();
                            System.out.println(str);
                            sendtextarea[i].appendText(str + "\n");
                        }
                    } catch (FileNotFoundException ef) {
                        System.out.println(ef);
                    }
                }
                BorderPane b = new BorderPane();
                System.out.println("khairul azman");
                if (bsendpane[i].getScene() != null) {
                    bsendpane[i].getScene().setRoot(b);
                }
                HBox hb=new HBox();
                ImageView iv=new ImageView();
                iv.setFitHeight(60);
                iv.setFitWidth(90);
                Label lb=new Label();
                
                lb.setFont(Font.font("Cambria", 18));
                lb.setText(friendsbtnname[i]);
                hb.getChildren().addAll(iv,lb);
                try{
                File f = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" +friendsbtnname[i]+ ".jpg");
                            f.createNewFile();
                            BufferedImage bufferedImage = ImageIO.read(f);
                            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                            iv.setImage(image);
                }
                catch(Exception ed)
                {
                    
                }
                Label lblank=new Label();
                lblank.setPrefSize(30, 100);
                VBox bbox=new VBox();
                bbox.getChildren().addAll(lblank,hb);
                 Reflection r = new Reflection();
        r.setFraction(0.9);
               lb.setEffect(r);
                bsendpane[i].setLeft(bbox);
                scen[i] = new Scene(bsendpane[i], 400, 400);
                sendstage[i].setScene(scen[i]);
                scen[i].getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
                sendstage[i].show();
               
            });
        }
        for (int j = 0; j < 20; j++) {
            final int s = j;
            sendarray[j].setOnAction(e -> {
                if(sendtextfield[s].getText().length()>0){
                nc.write(friendsbtnname[s] + ":" + sendtextfield[s].getText());
                 Bloom bloo = new Bloom();
        bloo.setThreshold(1.0);
        sendtextarea[s].setEffect(bloo);
                sendtextarea[s].appendText("Send:" + sendtextfield[s].getText() + "\n");
                }
            });
        }
        addButton.setOnAction(e
                -> {
            if (searchlabel.getText().length() > 0) {
                int fk = 0;
                for (int i = 0; i < friendscount; i++) {
                    if (friendsbutton[i].getText().equals(searchlabel.getText())) {
                        fk = 1;
                    }
                }
                System.out.println(fk);
                if (fk == 0) {
                    System.out.println(friendscount + "scjskcsac");
                    friendsbutton[friendscount].setText(searchlabel.getText());
                    BufferedWriter bw = null;
                    FileWriter fw = null;

                    try {

                        File file = new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\" + name + "friends" + ".txt");

                        fw = new FileWriter(file.getAbsoluteFile(), true);
                        bw = new BufferedWriter(fw);

                        bw.write(searchlabel.getText());
                        bw.write("\r\n");

                    } catch (IOException ef) {

                        ef.printStackTrace();

                    } finally {

                        try {

                            if (bw != null) {
                                bw.close();
                            }

                            if (fw != null) {
                                fw.close();
                            }

                        } catch (IOException ex) {

                            ex.printStackTrace();

                        }
                    }
                    NameVbox.getChildren().add(friendsbutton[friendscount]);
                    friendscount++;
                    // NameVbox.setTranslateX(+200);
                    searchpane.setRight(NameVbox);
                    //NameVbox.setTranslateY(-200);
                    primaryStage.setScene(searchscene);
                }

            }

        });
        NameVbox.setTranslateY(-300);
        searchbtn.setOnAction(e -> {
            String string = searchtext.getText();
            try {

                boolean b = true;
                Scanner sc = new Scanner(new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\username.txt"));
                while (sc.hasNextLine()) {
                    //System.out.println("skdjcbsdc");
                    String str = sc.nextLine();
                    if (str.equals(string)) {

                        searchlabel.setText(str);

                    }
                }
            } catch (Exception ef) {

            }
        });
        /*btn1.setOnAction(e-> {
               
                   str=text1.getText();
                   txtarea.setEditable(false);
                   txtarea.appendText(str+"\n");
                   nc.write(str);
               
           });*/

        newaccount.setOnAction(e -> {
            primaryStage.setScene(signinscene);
        });
        Scene scene1 = new Scene(bpane, 380, 300);
        scene1.getStylesheets().add(getClass().getResource("CSSFile.css").toExternalForm());
        signinlabel.setFont(Font.font("Cambria", 32));

        signincompletebutton.setOnAction(e -> {
            int i = 0;
            if ((signinusername.getText().length() == 0) || (signinpassword.getText().length() == 0) || (signinconfirmpassword.getText().length() == 0) || (signinemail.getText().length() == 0) || (signincountry.getText().length() == 0)) //signinbpane.setBottom(signinlabel);
            {
                i++;
            }
            System.out.println(i);
            //System.out.println(signinusername.getText().length());

            if (i > 0) {
                signinlabel.setText("Fields required");
                signinbpane.setTop(signinlabel);
                System.out.println("Not founr");
            } else if (signinpassword.getText().equals(signinconfirmpassword.getText()) == false) {
                signinlabel.setText("Enter Password again");
                signinbpane.setTop(signinlabel);
            } else {
                BufferedWriter bw = null;
                FileWriter fw = null;
                BufferedWriter userbw = null;
                FileWriter userfw = null;

                try {
                    File f = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\All.jpg");
                    File profilefile = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + signinusername.getText() + "profile" + ".txt");
                    if (profilefile.createNewFile()) {
                        System.out.println("file is created");
                    } else {
                        System.out.println("exist");
                    }
                    BufferedImage bufferedImage = ImageIO.read(f);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    File fi = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + signinusername.getText() + ".jpg");
                    ImageIO.write(bufferedImage, "jpg", fi);

                    File file = new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\myfile.txt");
                    File user = new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\username.txt");

                    fw = new FileWriter(file.getAbsoluteFile(), true);
                    bw = new BufferedWriter(fw);
                    userfw = new FileWriter(user.getAbsoluteFile(), true);
                    userbw = new BufferedWriter(userfw);
                    userbw.write("\r\n");
                    userbw.write(signinusername.getText());
                    bw.write("\r\n");
                    bw.write(signinusername.getText());
                    bw.write("\r\n");
                    bw.write(signinpassword.getText());
                    bw.write("\r\n");
                    bw.write(signinconfirmpassword.getText());
                    bw.write("\r\n");
                    bw.write(signinemail.getText());
                    bw.write("\r\n");
                    bw.write(signincountry.getText());
                    bw.write("\r\n");
                } catch (IOException ef) {

                    ef.printStackTrace();

                } finally {

                    try {

                        if (bw != null) {
                            bw.close();
                        }
                        if (userbw != null) {
                            userbw.close();
                        }
                        if (fw != null) {
                            fw.close();
                        }
                        if (userfw != null) {
                            userfw.close();
                        }

                    } catch (IOException ex) {

                        ex.printStackTrace();

                    }
                }

                primaryStage.setScene(scene1);
            }

        });
        Scene scene = new Scene(borpane, 500, 500);

        String musicFile = "C:\\Users\\DELL\\Downloads\\take-that-rule-the-world-4-25437.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        scene1btn.setOnAction(e
                -> {
            try {
                boolean d = true;
                Scanner scan = new Scanner(new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\myfile.txt"));

                while (scan.hasNextLine()) {

                    String str = scan.nextLine();
                    //System.out.println("who");
                    if (str.equals(textscene1.getText())) {
                        str = scan.nextLine();
                        if (str.equals(password.getText())) {

                            /*d=false;
                     scenedeatilusername.setText("Username is:"+textscene1.getText());
               scenedetailpassword.setText("Password is:"+password.getText());
               sceneusername.setText(textscene1.getText());*/
                            name = textscene1.getText();
                            nc.write(textscene1.getText());
                            new Thread(new Reader(nc, friendsbtnname, sendtextarea)).start();
                            //  primaryStage.setScene(searchscene);
                            //primaryStage.show();
                            File fil = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + name + "profile" + ".txt");
                            fil.createNewFile();
                            Scanner sc2 = new Scanner(fil);
                            int flag = 0;

                            System.out.println("ami");
                            while (sc2.hasNextLine()) {
                                String stri = sc2.nextLine();
                                if ((flag == 0) && (stri.length() > 0)) {
                                    profilelabel[flag].setText("works at " + stri);
                                }
                                if ((flag == 0) && (stri.length() == 0)) {
                                    profilelabel[flag].setText(" ");
                                }
                                if ((flag == 1) && (stri.length() > 0)) {
                                    profilelabel[flag].setText("studies at " + stri);
                                }
                                if ((flag == 1) && (stri.length() == 0)) {
                                    profilelabel[flag].setText(" ");
                                }
                                if ((flag == 2) && (stri.length() > 0)) {
                                    profilelabel[flag].setText("Studied at " + stri);
                                }
                                if ((flag == 2) && (stri.length() == 0)) {
                                    profilelabel[flag].setText(" ");
                                }
                                if ((flag == 3) && (stri.length() > 0)) {
                                    profilelabel[flag].setText("Born in " + stri);
                                }
                                if ((flag == 3) && (stri.length() == 0)) {
                                    profilelabel[flag].setText(" ");
                                }
                                if ((flag == 4) && (stri.length() > 0)) {
                                    profilelabel[flag].setText("Lives in " + stri);
                                }
                                if ((flag == 4) && (stri.length() == 0)) {
                                    profilelabel[flag].setText(" ");
                                }
                                if ((flag == 5) && (stri.length() > 0)) {
                                    profilelabel[flag].setText("From " + stri);
                                }
                                if ((flag == 4) && (stri.length() == 0)) {
                                    profilelabel[flag].setText(" ");
                                }
                                //profilelabel[flag].setText(stri);
                                System.out.println(stri);
                                flag++;
                                // primaryStage.setScene(searchscene);
                            }
                            sc2.close();
                            System.out.println("here is the programme");
                            File fi = new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Filereader\\" + name + "friends" + ".txt");
                            System.out.println("here");
                            if (fi.createNewFile()) {
                                System.out.println("it is created");
                            } else {
                                System.out.println("it exists");
                            }
                            File f = new File("C:\\Users\\DELL\\Downloads\\BUET noticefoldername\\" + name + ".jpg");
                            f.createNewFile();
                            BufferedImage bufferedImage = ImageIO.read(f);
                            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                            myimageview.setImage(image);
                            profilename.setFont(Font.font("Cambria", 40));
                            profilename.setText(name);
                            System.out.println("after images");
                            Scanner sc = new Scanner(fi);
                            System.out.println("here");
                            System.out.println("here is the image");
                            while (sc.hasNextLine()) {
                                System.out.println("here is the imageafter");
                                String stri = sc.nextLine();
                                friendsbutton[friendscount].setText(stri);
                                NameVbox.getChildren().add(friendsbutton[friendscount]);
                                friendscount++;
                                NameVbox.setTranslateY(-200);
                                searchpane.setRight(NameVbox);

                                NameVbox.setTranslateY(-300);
                                // primaryStage.setScene(searchscene);

                            }
                            primaryStage.setScene(searchscene);
                            primaryStage.show();
                            // primaryStage.setScene(scene);
                            break;
                        }

                    }
                }
                if (d == true) {
                    loginfailed.setFont(Font.font("Cambria", 32));
                    bpane.setTop(loginfailed);

                }
            } catch (Exception fr) {

            }

        });
        //scene1.getStylesheets().add(this.getClass().getResource(“CSSFile.css”).toExternalForm());
        primaryStage.setScene(scene1);
        // scene1.getStylesheets().add("C:\\Users\\DELL\\Documents\\NetBeansProjects\\DemoProject\\src\\demoproject\\CSSFile.css");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
