package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.PooledConnection;
import com.example.App;
import com.example.entidades.Category;

public class CategoryDAOMariaDB implements CategoryDAO {

    private final PooledConnection pcon;

    public CategoryDAOMariaDB(PooledConnection pcon) {
        this.pcon = pcon;
    }

    @Override

    public List<Category> findAll() {
        List<Category> cats = new ArrayList<>();
        try(Connection conn = pcon.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            while(rs.next()) {
                cats.add(new Category(rs.getInt("id"), rs.getString("name")));
            }

        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return cats;
    }

    @Override
    public Category findById(int id) {
        Category cat1 =  null; //Creamos la categoría que vamos a devolver a null
        try(Connection conn = pcon.getConnection()) {

            PreparedStatement st = conn.prepareStatement("SELECT * FROM category WHERE id = ? ");
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();

           if (rs.first()){ //result set( al primer y único resultado con el first)
                cat1 = new Category(id, rs.getString("name"));

                //otra forma
                //cat1.setId(rs.getInt("id"));
                //cat1.setName(rs.getString("name"));
           }
        } catch(SQLException e) {

            System.err.println(e.getMessage());

        }

        return cat1;
       
    }

    @Override
    public Category insert(Category c) {
        try(Connection conn = pcon.getConnection()) {

            PreparedStatement st = conn.prepareStatement("INSERT INTO category(name) VALUES (?) ", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, c.getName());
            st.executeUpdate();
            
            ResultSet rs = st.getGeneratedKeys(); 
            rs.first();
            c = new Category(rs.getInt(1), c.getName()); //Devolvemos un nuevo objeto
        } catch(SQLException e) {

            System.err.println(e.getMessage());

        }
        return c;
    }

    @Override
    public boolean update(Category c) {
        boolean actualizada = false;
        try(Connection conn = pcon.getConnection()) {

            PreparedStatement st = conn.prepareStatement("UPDATE category SET name = ? WHERE id = ? ");
            st.setString(1, c.getName());
            st.setInt(2, c.getId());
            int filas = st.executeUpdate();
            if (filas > 0 ) {
                actualizada = true;
            }
            
        } catch(SQLException e) {

            System.err.println(e.getMessage());

        }
        return actualizada;
    }

    @Override
    public boolean delete(int id) {
        boolean borrada = false;
        try(Connection conn = pcon.getConnection()) {

            PreparedStatement st = conn.prepareStatement("DELETE FROM category WHERE id = ? ");
            st.setInt(1, id);
            int filas = st.executeUpdate();
            if (filas > 0 ) {
                borrada = true;
            }
            
        } catch(SQLException e) {

            System.err.println(e.getMessage());

        }
        return borrada;
    }

    }
