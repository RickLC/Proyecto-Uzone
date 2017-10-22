package com.glitched.uzonewebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Information {
    private int id;
    private String description;
    private double avgPoints;
    private int voteQuantity;
    private User user;

    public Information(int id, String description, double avgPoints, int voteQuantity, User user) {
        this.id = id;
        this.description = description;
        this.avgPoints = avgPoints;
        this.voteQuantity = voteQuantity;
        this.user = user;
    }

    public Information() {}

    public int getId() {return id; }

    public void setId(int id) {this.id = id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description;}

    public double getAvgPoints() {return avgPoints;}

    public void setAvgPoints(double avgPoints) {this.avgPoints = avgPoints; }

    public int getVoteQuantity() {return voteQuantity; }

    public void setVoteQuantity(int voteQuantity) {this.voteQuantity = voteQuantity; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Information from (ResultSet rs,UsersEntity usersEntity,UserTypesEntity userTypesEntity) {
        Information info = new Information();
        try {
                    info.setId(rs.getInt("info_id"));
                    info.setDescription(rs.getString("info_description"));
                    info.setAvgPoints(rs.getDouble("info_avgPoints"));
                    info.setVoteQuantity(rs.getInt("info_voteQuantity"));
                    info.setUser(usersEntity.findById(rs.getInt("user_id"),userTypesEntity));
                    return info;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
