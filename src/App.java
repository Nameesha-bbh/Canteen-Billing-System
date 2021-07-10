import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.xdevapi.Statement;
public class App extends Application {
    public static void main(String[] args) {
    launch(args);
    }
    public void start(Stage primaryStage) {
        Connection con = null;
        Statement stmt = null;
        String url;
        try{
            Class classlldr = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Name of Class = " + classlldr.getName());
            System.out.println("Package Name = " + classlldr.getPackage());
            System.out.println("Interface Name = " + classlldr.getInterfaces());
            Class.forName("com.mysql.cj.jdbc.Driver");
            url="jdbc:mysql://localhost:3306/spring";
            con = DriverManager.getConnection(url);
        }
        catch (Exception e){
            System.out.println("error");
            System.exit(0);
        }
        primaryStage.setTitle("Employee Login Form");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        Label userName = new Label("Enter Username:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        Button btn = new Button("Sign in");
        grid.add(btn, 1, 4);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.close();
                GridPane data = new GridPane();
                
                data.setHgap(10);
                data.setVgap(10);
                data.setAlignment(Pos.CENTER);
                data.setPadding(new Insets(25, 25, 25, 25));
                Scene dataScene = new Scene(data, 400, 300);
                
                Stage dataWindow = new Stage();
                dataWindow.setScene(dataScene);
                dataWindow.setTitle("Customer Details");
                Label d = new Label("Enter customer data");
                Font font = Font.font("Verdana", FontWeight.BLACK, 15);
                d.setFont(font);
                data.add(d,0,1);
                
                Label name = new Label("Customer name:");
                data.add(name,0,2);
                TextField nameD = new TextField();
                data.add(nameD,1,2);

                Label ph = new Label("Customer phone number:");
                data.add(ph,0,3);
                TextField phD = new TextField();
                data.add(phD,1,3);

                Label age = new Label("Customer age:");
                data.add(age,0,4);
                TextField ageD = new TextField();
                data.add(ageD,1,4);

                Button submit = new Button("Submit details");
                data.add(submit,0,5);
                submit.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent e) {
                        dataWindow.close();
                        GridPane gridOrder = new GridPane();
                        
                        gridOrder.setHgap(10);
                        gridOrder.setVgap(10);
                        gridOrder.setPadding(new Insets(25, 25, 25, 25));
                        Scene secondScene = new Scene(gridOrder, 1000, 400);
                        
                        Stage newWindow = new Stage();
                        newWindow.setTitle("Order Page");
                        newWindow.setScene(secondScene);
                        Label welcome = new Label("Welcome to the Canteen Billing Software");
                        gridOrder.add(welcome,0,1);
                        Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 20);
                        welcome.setFont(font);

                        //menu
                        Label menu = new Label("Menu");
                        gridOrder.add(menu,0,2);
                        Font menuFont = Font.font("Aerial",FontWeight.BLACK, 15);
                        menu.setFont(menuFont);

                        //Price
                        Label price = new Label("Price");
                        gridOrder.add(price,1,2);
                        price.setFont(menuFont);

                        //Quantity
                        Label quantity = new Label("Quantity");
                        gridOrder.add(quantity,2,2);
                        quantity.setFont(menuFont);
                        
                        //menu items
                        Label pp = new Label("Panipuri");
                        gridOrder.add(pp,0,3);
                        Label mp = new Label("Masala Puri");
                        gridOrder.add(mp,0,4);
                        Label bp = new Label("Bhel Puri");
                        gridOrder.add(bp,0,5);

                        //menu price
                        Label ppPrice = new Label("RS. 25");
                        gridOrder.add(ppPrice,1,3);
                        Label mpPrice = new Label("RS. 30");
                        gridOrder.add(mpPrice,1,4);
                        Label bpPrice = new Label("RS. 30");
                        gridOrder.add(bpPrice,1,5);

                        //Quantity textfield
                        TextField ppE = new TextField();
                        gridOrder.add(ppE,2,3);
                        TextField mpE = new TextField();
                        gridOrder.add(mpE,2,4);
                        TextField bpE = new TextField();
                        gridOrder.add(bpE,2,5);
                        newWindow.show();

                        Button order = new Button("Place Order");
                        gridOrder.add(order,2,6);
                    
                    }
                });
                
                dataWindow.show();
            }

            
        });
        primaryStage.show();
    }
}
