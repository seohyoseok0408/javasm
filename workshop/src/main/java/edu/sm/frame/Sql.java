package edu.sm.frame;

public class Sql {
    public static String insertCust = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static String selectCust = "SELECT * FROM Customer";
    public static String selectOneCust = "SELECT * FROM Customer WHERE id = ?";
    public static String deleteCust = "DELETE FROM Customer WHERE id = ?";
    public static String updateCust =
            "UPDATE Customer SET pwd=?, name = ?, address=?, phone=?, birthdate=? WHERE id = ?";
    public static String insertProduct = "INSERT INTO product VALUES (?,?,?,?)";
    public static String selectProduct = "SELECT * FROM product";
    public static String selectOneProduct = "SELECT * FROM product WHERE id = ?";
    public static String deleteProduct = "DELETE FROM product WHERE id = ?";
    public static String updateProduct =
            "UPDATE product SET name = ?, price = ? WHERE id = ?";
}
