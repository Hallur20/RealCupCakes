
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataMapper {

    DBConnector conn;

    public ArrayList<Bottoms> Bottoms() {
        PreparedStatement preparedStatement = null;
        ArrayList<Bottoms> bList = new ArrayList<>();
        String selectSQL = "SELECT bName, bPrice FROM bottoms WHERE bId >= ?";
        try {
            preparedStatement = DBConnector.getConnection().prepareStatement(selectSQL);
            preparedStatement.setInt(1, 1000); //id skal være større end 1000.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String bName = rs.getString("bName");
                int bPrice = rs.getInt("bPrice");
                bList.add(new Bottoms(bName, bPrice));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);

        }
        return bList;
    }

    public ArrayList<Toppings> Toppings() {
        PreparedStatement preparedStatement = null;
        ArrayList<Toppings> tList = new ArrayList<>();
        String selectSQL = "SELECT tName, tPrice FROM toppings WHERE tId >= ?";
        try {
            preparedStatement = DBConnector.getConnection().prepareStatement(selectSQL);
            preparedStatement.setInt(1, 2000); //id skal være større end 2000.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String tName = rs.getString("tName");
                int tPrice = rs.getInt("tPrice");
                tList.add(new Toppings(tName, tPrice));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);

        }
        return tList;
    }

    public ArrayList<Users> Users() {
        PreparedStatement preparedStatement = null;
        ArrayList<Users> uList = new ArrayList<>();
        String selectSQL = "SELECT email, userPass, balance FROM users WHERE userId >= ?";
        try {
            preparedStatement = DBConnector.getConnection().prepareStatement(selectSQL);
            preparedStatement.setInt(1, 1); //id skal være større end 0.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String userPass = rs.getString("userPass");
                int balance = rs.getInt("balance");
                uList.add(new Users(email, userPass, balance));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);

        }
        return uList;
    }
    public String seeOrder(String email){
        PreparedStatement preparedStatement = null;
        String selectSQL = "select * from invoices where email = ?";
        String returnString = "Order: ";
        try{
            preparedStatement = DBConnector.getConnection().prepareStatement(selectSQL);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int userId = rs.getInt("userId");
                int tPriceTotal = rs.getInt("tPriceTotal");
                int bPriceTotal = rs.getInt("bPriceTotal");
                returnString += "User-ID: " + userId + ", Total Bottom-Price: " + bPriceTotal + ", Total Toppings-Price: " + tPriceTotal;                
            }
                        
        } catch(Exception ex){
            
        } return returnString;
    }
    public void deleteInvoices() throws SQLException{
        PreparedStatement preparedStatement = null;
        String deleteSQL = "delete from invoices where userId > ?";
        try{
            preparedStatement = DBConnector.getConnection().prepareStatement(deleteSQL);
            preparedStatement.setInt(1, 0);
            preparedStatement.executeUpdate();

        } catch(Exception ex){
            
        }
    }


    public void insertInvoice(String email, int tPriceTotal, int bPriceTotal, int balance) throws SQLException {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        PreparedStatement preparedStatement3 = null;
        String selectSQL = "select userId from users where email = ?";
        String insertSQL = "INSERT into invoices() values(?, ?, ?, ?)";
        String updateSQL = "update users set balance = ? where email = ?";

        try {
            preparedStatement1 = DBConnector.getConnection().prepareStatement(selectSQL);
            preparedStatement1.setString(1, email);
            ResultSet rs = preparedStatement1.executeQuery();
            int userId = 0;
            while (rs.next()) {
                userId = rs.getInt("userId");
            }

            preparedStatement2 = DBConnector.getConnection().prepareStatement(insertSQL);
            preparedStatement2.setInt(1, userId);
            preparedStatement2.setString(2, email);
            preparedStatement2.setInt(3, tPriceTotal);
            preparedStatement2.setInt(4, bPriceTotal);
            preparedStatement2.executeUpdate();
            
            preparedStatement3 = DBConnector.getConnection().prepareStatement(updateSQL);
            preparedStatement3.setInt(1, balance);
            preparedStatement3.setString(2, email);
            preparedStatement3.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
