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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class App extends Application{
    String mainreq,mainnum,mainage,mainid;
    int updateDBMS=0;
    int paniPuri=0, masalaPuri=0,bhelPuri =0,vegNoodles=0,chickenNoodles=0;
    public static void main(String[] args)  throws IOException{
    
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
                try 
                {
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
                        while(rs.next())
                        {
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
                catch(Exception e1)
                {
                    System.out.println(e1);
                }

                primaryStage.close();
                GridPane ask = new GridPane();
                
                ask.setHgap(10);
                ask.setVgap(10);
                ask.setAlignment(Pos.CENTER);
                ask.setPadding(new Insets(25, 25, 25, 25));
                Scene askScene = new Scene(ask, 300, 300);
                
                Stage askWindow = new Stage();
                askWindow.setScene(askScene);
                askWindow.setTitle("Select  button to order");
                Button newOrder = new Button("New Order");
                ask.add(newOrder,0,1);
                newOrder.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent f){
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
                        
                        Label id = new Label("Customer ID:");
                        data.add(id,0,2);
                        TextField ID = new TextField();
                        data.add(ID,1,2);

                        Label name = new Label("Customer name:");
                        data.add(name,0,3);
                        TextField nameD = new TextField();
                        data.add(nameD,1,3);
        
                        Label ph = new Label("Customer phone number:");
                        data.add(ph,0,4);
                        TextField phD = new TextField();
                        data.add(phD,1,4);
        
                        Label age = new Label("Customer age:");
                        data.add(age,0,5);
                        TextField ageD = new TextField();
                        data.add(ageD,1,5);
        
                        Button submit = new Button("Submit details");
                        data.add(submit,0,6);
                        submit.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent g){
                                String name,ph,age;
                                int id_g = Integer.parseInt(ID.getText());
                                name = nameD.getText();
                                mainreq = nameD.getText();
                                mainnum = phD.getText();
                                mainage = ageD.getText();
                                ph = phD.getText();
                                age = ageD.getText();
                                mainid = ID.getText();
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
                                Label vn = new Label("Veg Noodles");
                                gridOrder.add(vn,0,6);
                                Label cn = new Label("Chicken Noodles");
                                gridOrder.add(cn,0,7);
        
                                //menu price
                                Label ppPrice = new Label("RS. 25");
                                gridOrder.add(ppPrice,1,3);
                                Label mpPrice = new Label("RS. 30");
                                gridOrder.add(mpPrice,1,4);
                                Label bpPrice = new Label("RS. 30");
                                gridOrder.add(bpPrice,1,5);
                                Label vnPrice = new Label("RS. 50");
                                gridOrder.add(vnPrice,1,6);
                                Label cnPrice = new Label("RS. 100");
                                gridOrder.add(cnPrice,1,7);
        
                                //Quantity textfield
                                TextField ppE = new TextField();
                                gridOrder.add(ppE,2,3);
                                TextField mpE = new TextField();
                                gridOrder.add(mpE,2,4);
                                TextField bpE = new TextField();
                                gridOrder.add(bpE,2,5);
                                TextField vnE = new TextField();
                                gridOrder.add(vnE,2,6);
                                TextField cnE = new TextField();
                                gridOrder.add(cnE,2,7);
                                
        
                                Label panipuri = new Label();
                                gridOrder.add(panipuri,3,3);
                                Label masalapuri = new Label();
                                gridOrder.add(masalapuri,3,4);
                                Label bhelpuri = new Label();
                                gridOrder.add(bhelpuri,3,5);
                                Label vegnoodles = new Label();
                                gridOrder.add(vegnoodles,3,6);
                                Label chiknoodles = new Label();
                                gridOrder.add(chiknoodles,3,7);
                                Label t = new Label();
                                gridOrder.add(t,3,8);
                                Button foodprice = new Button("Check Total Price");
                                gridOrder.add(foodprice,3,9);
                                foodprice.setOnAction(new EventHandler<ActionEvent>(){
                                    public void handle(ActionEvent h){
                                        int p=0,m=0,b2=0,v=0,c=0,total=1;
                                        if (ppE.getText().equals(""))
                                        {
                                            panipuri.setText("Rs."+String.valueOf(p));
                                        }
                                        else{
        
                                            p = Integer.parseInt(ppE.getText());
                                            p = p * 25;
                                            panipuri.setText("Rs."+String.valueOf(p));
                                        }
                                       
                                        if (mpE.getText().equals(""))
                                        {
                                            masalapuri.setText("Rs."+String.valueOf(m));
                                        }
                                        else{
        
                                            m = Integer.parseInt(mpE.getText());
                                            m = m * 30;
                                            masalapuri.setText("Rs."+String.valueOf(m));
                                        }
        
                                        if (bpE.getText().equals(""))
                                        {
                                            bhelpuri.setText("Rs."+String.valueOf(b2));
                                        }
                                        else{
        
                                            b2 = Integer.parseInt(bpE.getText());
                                            b2 = b2 * 30;
                                            bhelpuri.setText("Rs."+String.valueOf(b2));
                                        }
                                        if (vnE.getText().equals(""))
                                        {
                                            vegnoodles.setText("Rs."+String.valueOf(v));
                                        }
                                        else{
        
                                            v = Integer.parseInt(vnE.getText());
                                            v = v * 50;;
                                            vegnoodles.setText("Rs."+String.valueOf(v));
                                        }
                                        if (cnE.getText().equals(""))
                                        {
                                            chiknoodles.setText("Rs."+String.valueOf(c));
                                        }
                                        else{
        
                                            c = Integer.parseInt(cnE.getText());
                                            c = c * 100;
                                            chiknoodles.setText("Rs."+String.valueOf(c));
                                        }
                                        total = p + m + b2 + v + c;
                                        t.setText("Total Price is Rs."+total);
                                    }
                                });
                                Button order = new Button("Place Order");
                                gridOrder.add(order,2,8);
                                order.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent e) {
                                        
                                        if(ppE.getText().equals(""))
                                        {
                                            paniPuri = 0;
                                        }
                                        else{
                                            paniPuri = Integer.parseInt(ppE.getText())*25;
                                        }
                                        if(mpE.getText().equals(""))
                                        {
                                            masalaPuri = 0;
                                        }
                                        else{
                                            masalaPuri = Integer.parseInt(mpE.getText())*30;
                                        }
                                        if(bpE.getText().equals(""))
                                        {
                                            bhelPuri = 0;
                                        }
                                        else{
                                            bhelPuri = Integer.parseInt(bpE.getText())*30;
                                        }
                                        if(vnE.getText().equals(""))
                                        {
                                            vegNoodles = 0;
                                        }
                                        else{
                                            vegNoodles = Integer.parseInt(vnE.getText())*50;
                                        }
                                        if(cnE.getText().equals(""))
                                        {
                                            chickenNoodles = 0;
                                        }
                                        else{
                                            chickenNoodles = Integer.parseInt(cnE.getText())*100;
                                        }
                                        if(updateDBMS == 0){try 
                                        {
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
                                                    + "bp,"
                                                    + "vn,"
                                                    + "cn,"
                                                    + "ID)"
                                                    +  "VALUES(?,?,?,?,?,?,?,?,?)";
                                                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                                                    preparedStatement.setString(1,name);
                                                    preparedStatement.setString(2,ph);
                                                    preparedStatement.setString(3,age);
                                                    preparedStatement.setString(4,ppE.getText());
                                                    preparedStatement.setString(5,mpE.getText());
                                                    preparedStatement.setString(6,bpE.getText());
                                                    preparedStatement.setString(7,vnE.getText());
                                                    System.out.println(vnE.getText());
                                                    System.out.println(cnE.getText());
                                                    System.out.println(id_g);
                                                    preparedStatement.setString(8,cnE.getText());
                                                    preparedStatement.setString(9,Integer.toString(id_g));
                                                    preparedStatement.execute();
                                                    con.close();
                                        }
                                        catch(Exception e1)
                                        {

                                        }}
                                        
                                        GridPane bill = new GridPane();
                        
                                        bill.setHgap(10);
                                        bill.setVgap(10);
                                        
                                        bill.setPadding(new Insets(25, 25, 25, 25));
                                        Scene billScene = new Scene(bill, 300, 300);
                                        
                                        Stage billWindow = new Stage();
                                        billWindow.setScene(billScene);
                                        billWindow.setTitle("Final Bill");
                                        Font menuFont = Font.font("Aerial",FontWeight.BLACK, 15);
                                
                                        Label billMenu = new Label("Food Ordered");
                                        bill.add(billMenu,0,1);
                                        billMenu.setFont(menuFont);
                                        Label billPrice = new Label("Price");
                                        bill.add(billPrice,1,1);
                                        billPrice.setFont(menuFont);
                                        int i=2,j=2;
                                        if(paniPuri != 0)
                                        {
                                            Label finalP = new Label("Pani Puri");
                                            bill.add(finalP,0,i);
                                            i++;
                                            Label finalPB = new Label();
                                            bill.add(finalPB,1,j);
                                            j++;
                                            finalPB.setText(Integer.toString(paniPuri));
                                        }
                                        if(masalaPuri != 0)
                                        {
                                            Label finalM = new Label("Masala Puri");
                                            bill.add(finalM,0,i);
                                            i++;
                                            Label finalPM = new Label();
                                            bill.add(finalPM,1,j);
                                            j++;
                                            finalPM.setText(Integer.toString(masalaPuri));
                                        }
                                        if(bhelPuri != 0)
                                        {
                                            Label finalB = new Label("Bhel Puri");
                                            bill.add(finalB,0,i);
                                            i++;
                                            Label finalBB = new Label();
                                            bill.add(finalBB,1,j);
                                            j++;
                                            finalBB.setText(Integer.toString(bhelPuri));
                                        }

                                        if(vegNoodles != 0)
                                        {
                                            Label finalB = new Label("Veg Noodles");
                                            bill.add(finalB,0,i);
                                            i++;
                                            Label finalBB = new Label();
                                            bill.add(finalBB,1,j);
                                            j++;
                                            finalBB.setText(Integer.toString(vegNoodles));
                                        }

                                        if(chickenNoodles != 0)
                                        {
                                            Label finalB = new Label("Chicken Noodles");
                                            bill.add(finalB,0,i);
                                            i++;
                                            Label finalBB = new Label();
                                            bill.add(finalBB,1,j);
                                            j++;
                                            finalBB.setText(Integer.toString(chickenNoodles));
                                        }
                                        Label totalBill = new Label();
                                        bill.add(totalBill,0,i);
                                        int finalBillPrint = paniPuri + masalaPuri + bhelPuri + vegNoodles + chickenNoodles;
                                        if(finalBillPrint > 0)
                                            totalBill.setText("Total Price : Rs."+Integer.toString(finalBillPrint));
                                        //Later
                                        Label question = new Label("Do you want to print the bill?");
                                        bill.add(question,0,i+1);
                                        Button print = new Button("YES");
                                        bill.add(print,1,j+1);
                                        print.setOnAction(new EventHandler<ActionEvent>(){
                                            public void handle(ActionEvent x)
                                            {
                                                try{
                                                File file = new File("Bill.txt");
                                                FileWriter fw = new FileWriter(file);
                                                PrintWriter pw = new PrintWriter(fw);
                                                pw.println("Customer ID: "+id_g);
                                                pw.println("Customer Name: "+mainreq);
                                                pw.println("Customer number: "+mainnum);
                                                pw.println("Customer age: "+mainage);
                                                pw.println("**************TOTAL AMOUNT**************");
                                                pw.println("FOOD                QUANTITY     RATE(In Rupee)");
                                                if(paniPuri != 0)
                                                    pw.println("Pani Puri      "+"        "+ppE.getText()+"         "+paniPuri);
                                                if(masalaPuri != 0)
                                                    pw.println("Masala Puri    "+"        "+mpE.getText()+"         "+masalaPuri);
                                                if(bhelPuri != 0)
                                                    pw.println("Bhel Puri      "+"        "+bpE.getText()+"         "+bhelPuri);
                                                if(vegNoodles != 0)
                                                    pw.println("Veg Noodles    "+"        "+vnE.getText()+"         "+vegNoodles);
                                                if(chickenNoodles != 0)
                                                    pw.println("Chicken Noodles"+"        "+cnE.getText()+"         "+chickenNoodles);
                                               pw.println("****************************************");
                                                int totaAmount = paniPuri+masalaPuri+bhelPuri+vegNoodles+chickenNoodles;
                                                pw.println("Total amount: Rs."+totaAmount);
                                                pw.close();
                                                
                                            }
                                                catch(Exception file)
                                                {
                                                    System.out.println(file);
                                                }
                                                newWindow.close();
                                                billWindow.close();
                                            }
                                        });
                                        Button no = new Button("NO");
                                        no.setOnAction(new EventHandler<ActionEvent>(){
                                            public void handle(ActionEvent x)
                                            {
                                                newWindow.close();
                                                billWindow.close();
                                            }
                                        });
                                        j = j + 1;
                                        bill.add(no,2,j);
                                        billWindow.show();
                                    }
                                });
                                Button previous = new Button("Load previous order?");
                                gridOrder.add(previous,2,9);
                                previous.setOnAction(new EventHandler<ActionEvent>(){
                                    @Override
                                    public void handle(ActionEvent e)
                                    {
                                        //updateDBMS = 1;
                                        try 
                                        {

                                            Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
                                               
                                           final String JdbcDriver="com.mysql.cj.jdbc.Driver";
                                           final String user="root";
                                           final String pass="nameesha";
                                           final String db_url="jdbc:mysql://127.0.0.1:3306/login";
                                           Connection con=DriverManager.getConnection(db_url,user,pass);
                                           
                                           Statement stmt=(Statement) con.createStatement();
                                           
                                           ResultSet rs1 = stmt.executeQuery("select pp,mp,bp,vn,cn from user_details where ID="+id_g+" and name='"+mainreq+"' and phoneno='"+mainnum+"' and age='"+mainage+"';");
                                           while(rs1.next()){
                                                ppE.setText(rs1.getString(1));
                                                mpE.setText(rs1.getString(2));
                                                bpE.setText(rs1.getString(3));
                                                vnE.setText(rs1.getString(4));
                                                cnE.setText(rs1.getString(5));
                                                updateDBMS = 1;
                                                break;
                                           }
                                           ppE.setText(rs1.getString(1));
                                           con.close();
                                        }
                                        catch(Exception e2)
                                        {
        
                                        }
                                    }
                                });
                                newWindow.show();
                            }
                        });

                        dataWindow.show();
                    }
                });
                

                askWindow.show();
            
            }

        });



        primaryStage.show();
    }

}
    