package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.Buildingentity;

@Repository

public class BuildingRepositorylmpl implements BuildingRepository {

    static final String DB_URL = "jdbc:mysql://localhost:3306/realestate";
    static final String USER = "root";
    static final String PASS = "123456";

    @Override
    public List<Buildingentity> findAll(String name, Integer districtid) {

        StringBuilder sql = new StringBuilder(
            "SELECT * FROM Building b WHERE 1=1 "
        );

        if (name != null && !name.equals("")) {
            sql.append("AND b.name LIKE '%" + name + "%' ");
        }

        if (districtid != null) {
            sql.append("AND b.districtid = " + districtid + " ");
        }

        List<Buildingentity> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());

            while (rs.next()) {

                Buildingentity building = new Buildingentity();

                building.setName(rs.getString("name"));
                building.setWard(rs.getString("ward"));
                building.setStreet(rs.getString("street"));
                building.setNumberofbasement(
                    rs.getInt("numberofbasement")
                );

                result.add(building);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}