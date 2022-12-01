package com.example.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.PooledConnection;

import com.example.entidades.Product;

public class ProductDAOMariaDB implements ProductDAO {
    private final PooledConnection pcon;

    public ProductDAOMariaDB(PooledConnection pcon) {
        this.pcon = pcon;
    }

    @Override
    public List<Product> findByCategory(int idCat) {
        List<Product> prods = new ArrayList<>();

        try(Connection conn = pcon.getConnection()) {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM product WHERE category = ?");
            st.setInt(1, idCat);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                prods.add(new Product(rs.getInt("id"), rs.getString("reference"), rs.getString("name"),
                    rs.getDouble("price"), rs.getInt("category")));
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return prods;
    }

    @Override
    public Product insert(Product p) {
        try(Connection conn = pcon.getConnection()) {
            PreparedStatement stProd = conn.prepareStatement("INSERT INTO product (reference, name, price, category) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stProd.setString(1, p.getReference() );
            stProd.setString(2, p.getName());
            stProd.setDouble(3, p.getPrice());
            stProd.setInt(4, p.getCategory());
            stProd.executeUpdate();
            ResultSet rs = stProd.getGeneratedKeys();
            rs.first();
            p = new Product(rs.getInt("id"), rs.getString("reference"), rs.getString("name"), rs.getDouble("price"), rs.getInt("category"));

        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return p;
  
            
       
    }

    @Override
    public boolean delete(int idProd) {
        boolean borrado = false;
        try (Connection conn = pcon.getConnection()) {
            PreparedStatement st = conn.prepareStatement("DELETE FROM product WHERE id = ?");
            st.setInt(1, idProd);
            int filas = st.executeUpdate();
            borrado = filas > 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return borrado;
    }
}
