import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class App extends Application {
    String mainreq;
    public static void main(String[] args) {
    
    launch(args);
    }
    public void start(Stage primaryStage) {
    
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
        Label response = new Label();
        grid.add(response,1,5);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
                       
                   final String JdbcDriver="com.mysql.cj.jdbc.Driver";
                   final String user="root";
                   final String pass="nameesha";
                   final String db_url="jdbc:mysql://127.0.0.1:3306/login";
                   Connection con=DriverManager.getConnection(db_url,user,pass);
                   
                   Statement stmt=(Statement) con.createStatement();
                   ResultSet rs = stmt.executeQuery("select * from users;");
                   int res=0;
                   String eD;
                   String dD;
                   String eP,dP;
                   while(rs.next()){
                     eD = userTextField.getText();
                     dD = rs.getString(1);
                     eP = pwBox.getText();
                     dP = rs.getString(2);
                     if(eD.equals(dD) && eP.equals(dP))
                     {
                         res = 1;
                         break;
                     }
                     if(res == 0)
                     {
                         System.out.println("Wrong username or password");
                         System.exit(0);
                     }
                     con.close();
                   }
                   
               }
                catch(Exception e1){
                    
                    System.out.println(e1);
                }
                
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
                           String name,ph,age;
                           name = nameD.getText();
                           mainreq = nameD.getText();
                           ph = phD.getText();
                           age = ageD.getText();
                        
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

                        Label bill = new Label("Total Bill");
                        gridOrder.add(bill,3,2);
                        bill.setFont(menuFont);
                        
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

                        Label panipuri = new Label();
                        gridOrder.add(panipuri,3,3);
                        Label masalapuri = new Label();
                        gridOrder.add(masalapuri,3,4);
                        Label bhelpuri = new Label();
                        gridOrder.add(bhelpuri,3,5);
                        Label t = new Label();
                        gridOrder.add(t,3,6);
                        Button foodprice = new Button("Check Total Price");
                        gridOrder.add(foodprice,3,7);
                        foodprice.setOnAction(new EventHandler<ActionEvent>(){
                            public void handle(ActionEvent f){
                                String b = mpE.getText(),c = bpE.getText();
                                System.out.println(ppE.getText() == null);
                                int p,m,b2,total;
                                
                                    //p = Integer.parseInt(a);
                                    //p = p * 25;
                                
                                
                                
                                    p = 0;
                                
                                

                                m = Integer.parseInt(b);
                                m = m * 30;

                                b2 = Integer.parseInt(c);
                                b2 = b2 * 30;
                                total = 
                                panipuri.setText("Rs."+String.valueOf(p));
                                masalapuri.setText("Rs."+String.valueOf(m));
                                bhelpuri.setText("Rs."+String.valueOf(b2));

                            }
                        });

                        Button order = new Button("Place Order");
                        gridOrder.add(order,2,6);
                        order.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                try {
                                    Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
                                       
                                   final String JdbcDriver="com.mysql.cj.jdbc.Driver";
                                   final String user="root";
                                   final String pass="nameesha";
                                   final String db_url="jdbc:mysql://127.0.0.1:3306/login";
                                   Connection con=DriverManager.getConnection(db_url,user,pass);
                                   
                                   Statement stmt=(Statement) con.createStatement();
                                   String sql = "INSERT INTO user_details("
                                            + "name,"
                                            + "phoneno, "
                                            + "age,"
                                            + "pp,"
                                            + "mp,"
                                            + "bp)"
                                            +  "VALUES(?,?,?,?,?,?)";
                                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                                            preparedStatement.setString(1,name);
                                            preparedStatement.setString(2,ph);
                                            preparedStatement.setString(3,age);
                                            preparedStatement.setString(4,ppE.getText());
                                            preparedStatement.setString(5,mpE.getText());
                                            preparedStatement.setString(6,bpE.getText());
                                            preparedStatement.execute();
                                            con.close();
                                }
                                catch(Exception e1){
                                    
                                    System.out.println(e1);
                                }

                            }
                                
                        });
                        Button previous = new Button("Load previous order?");
                        gridOrder.add(previous,2,7);
                        previous.setOnAction(new EventHandler<ActionEvent>(){
                            @Override
                            public void handle(ActionEvent e)
                            {
                                try {
                                    Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
                                       
                                   final String JdbcDriver="com.mysql.cj.jdbc.Driver";
                                   final String user="root";
                                   final String pass="nameesha";
                                   final String db_url="jdbc:mysql://127.0.0.1:3306/login";
                                   Connection con=DriverManager.getConnection(db_url,user,pass);
                                   
                                   Statement stmt=(Statement) con.createStatement();
                                   
                                   ResultSet rs1 = stmt.executeQuery("select pp,mp,bp from user_details where name='"+mainreq+"';");
                                   while(rs1.next()){
                                        ppE.setText(rs1.getString(1));
                                        mpE.setText(rs1.getString(2));
                                        bpE.setText(rs1.getString(3));
                                        break;
                                   }
                                   ppE.setText(rs1.getString(1));
                                   con.close();
                                }
                                catch(Exception e1)
                                {

                                }
                            }
                        });
                        
                    
                    }
                });
                
                dataWindow.show();
            }

            
        });
        primaryStage.show();
    }
}
