package com.glitched.uzonewebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventsEntity extends BaseEntity {

    public EventsEntity() {
        super();
        setTableName("events");
    }

    public EventsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public List<Event> findByCriteria(String criteria, UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Event> events = new ArrayList<>();
            while (rs.next()) {
                events.add(Event.from(rs, usersEntity, userTypesEntity));
            }
            return events;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Event> findAll(UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria("", usersEntity, userTypesEntity);
    }

    public Event findById(int id, UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE id= %d", id), usersEntity, userTypesEntity).get(0);
    }

    /* public Event findBypictureUrl(String pictureUrl,  UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE pictureUrl='%s'",pictureUrl),usersEntity,userTypesEntity).get(0);
    }
    public Event date(String pictureUrl,  UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        //return findByCriteria(String.format("WHERE date='%s,%s'",date()),usersEntity,userTypesEntity).get(0);
    public Event findBydateLimit(String pictureUrl,  UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria(String.format("WHERE pictureUrl='%s'",pictureUrl),usersEntity,userTypesEntity).get(0);
    } */

    public List<Event> showEvents(UsersEntity usersEntity, UserTypesEntity userTypesEntity) {
        return findByCriteria("ORDER BY id DESC,date DESC",usersEntity,userTypesEntity);
    }

    public boolean create(Event event) {
        return executeUpdate(String.format(
                "INSERT INTO %s(user_id,title,ubication,picture_url,date,datelimit,description,salary,tags,websites)"
                        .concat("VALUES ('%d','%s','%s','%s','%s','%s','%s','%s','%s','%s')"),
                getTableName(),event.getUser().getId(),event.getTitle(),event.getPictureUrl(),event.getUbication(), event.getDate(), event.getDateLimit(), event.getDescription(),event.getTags(),event.getWebsites(),event.getSalary()));
    }

    public boolean create( User user,String picture_url,String title,String ubication, String tags, String websites,String date, String dateLimit, String description, double salary) {
        Event event = new Event();
        event.setUser(user);
        event.setTitle(title);
        event.setPictureUrl(picture_url);
        event.setUbication(ubication);
        event.setDate(date);
        event.setDateLimit(dateLimit);
        event.setDescription(description);
        event.setTags(tags);
        event.setWebsites(websites);
        event.setSalary(salary);
        return create(event);
    }
}

