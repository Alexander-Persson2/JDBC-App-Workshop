package org.example.dao;

import org.example.model.City;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {
    private Connection connection;


    public CityDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public City findById(int id) {
        City city = null;
        String query = "SELECT * FROM city WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                city = new City(rs.getInt("id"), rs.getString("name"), rs.getString("countrycode"), rs.getInt("population"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public List<City> findByCode(String code) {
        return new ArrayList<>();
    }

    @Override
    public List<City> findByName(String name) {
        return new ArrayList<>();
    }

    @Override
    public List<City> findAll() {
        return new ArrayList<>();

    }

    @Override
    public City add(City city) {
        return null;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public int delete(City city) {
        return 0;
    }


}

