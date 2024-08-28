package org.example;

import org.example.dao.CityDao;
import org.example.dao.CityDaoJDBC;
import org.example.model.City;
import org.example.util.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            CityDao cityDao = new CityDaoJDBC(connection);
            City city = cityDao.findById(1);
            System.out.println(city);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
