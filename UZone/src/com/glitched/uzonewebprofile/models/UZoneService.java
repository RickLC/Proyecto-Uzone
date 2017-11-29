package com.glitched.uzonewebprofile.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UZoneService {
    Connection connection;
    UZoneDataStore dataStore;

    public UZoneService() {
        try {
            InitialContext context = new InitialContext();
            dataStore = new UZoneDataStore();
            connection = ((DataSource)context
                    .lookup("MySQLDataSource"))
                    .getConnection();
            dataStore.setConnection(connection);
        } catch(NamingException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public UZoneDataStore getDataStore() {
        return dataStore;
    }

    public void setDataStore(UZoneDataStore dataStore) {
        this.dataStore = dataStore;
    }

    //UserType methods
    public List<UserType> findAllUserTypes() { return dataStore.findAllUserTypes(); }

    //Information methods
    public List<Information> findAllInformations() { return dataStore.findAllInformations(); }

    //User methods
    public List<User> findAllUsers() {
        return dataStore.findAllUsers();
    }

    public User findUserById(int id) {
        return dataStore.findUserById(id);
    }

    public User findUserByUsername(String username) {
        return dataStore.findUserByUsername(username);
    }

    public boolean findUserByLogin(String username,String password) {
        return dataStore.findUserByLogin(username,password);
    }

    public boolean createUser(User user) {
        return dataStore.createUser(user);
    }

    public boolean createUser(String username,String password,String name,String lastName,String email,String birthDate,char genre,int id) {
        return dataStore.createUser(username,password,name,lastName,email,birthDate,genre,id);
    }

    //Information Methods
    public Information findInformationByUserId (int userId) {
        return dataStore.findInformationByUserId(userId);
    }

    public Information findInformationByUserUsername(String username) {
        return dataStore.findInformationByUserUsername(username);
    }

    public boolean createInformation(String description, double averagePoints, int voteQuantity, String username) {
        return dataStore.createInformation(description,averagePoints,voteQuantity,username);
    }

    public boolean updateInformation(int userId) {
        return dataStore.updateInformation(userId);
    }

    //Posts methods
    public List<Post> findLastest() {
        return dataStore.findLastest();
    }

    public List<Post> findByUser(int user_id) { return dataStore.findByUser(user_id); }

    public Post findPostById(int id) {
        return dataStore.findPostById(id);
    }

    public boolean createPost(Post post) {
        return dataStore.createPost(post);
    }

    public boolean createPost(int id,String title,String date,String description,String url) {
        return dataStore.createPost(id,title,date,description,url);
    }

    public List<Post> showSearch(String title) {return dataStore.showSearch(title); }

    public boolean deletePostById(int id){return dataStore.deletePostById(id);}

    //Comment methods
    public List<Comment> findCommentByPost(int postId) {
        return dataStore.findCommentByPost(postId);
    }

    public boolean createComment(int postId,String description,String date,int userId) {
        return dataStore.createComment(postId,description,date,userId);
    }

    public boolean deleteCommentByPost(int postId) {
        return dataStore.deleteCommentByPost(postId);
    }

    //Events methods
    public List<Event> showEvents() {
        return dataStore.showEvents();
    }

    public List<Event> findEventByUser(int userId) {
        return dataStore.findEventByUser(userId);
    }

    public Event findEventById(int eventId) {
        return dataStore.findEventById(eventId);
    }

    public boolean createEvent(Event event) { return dataStore.createEvent(event); }

    public boolean createEvent(int id,String picture_url,String title,String ubication, String tags, String websites,String date, String dateLimit, String description, double salary) {
        return dataStore.createEvent(id,title,picture_url,ubication,tags,websites,date,dateLimit,description,salary);
    }

    public List<Event> findAllEvents() {
        return dataStore.findAllEvents();
    }

    //Postulant methods
    public List<Postulant> findPostulantByEvent(int eventId) {
        return dataStore.findPostulantByEvent(eventId);
    }
    public boolean createPostulant(int eventId,int userId,String date) {
        return dataStore.createPostulant(eventId,userId,date);
    }

    public boolean checkPostulant(int eventId, int userId) {
        return dataStore.checkPostulant(eventId,userId);
    }

    //Point methods
    public boolean createPoint(int origin,int target,int quantity) {
        return dataStore.createPoint(origin,target,quantity);
    }

    public boolean createPoint(Point point) {
        return dataStore.createPoint(point);
    }

    public boolean checkPoint(int origin,int target) {
        return dataStore.checkPoint(origin,target);
    }

    public boolean updatePoint(int origin,int target,int quantity) {
        return dataStore.updatePoint(origin,target,quantity);
    }

    public int getQuantity(int origin, int target) {
        return dataStore.getQuantity(origin,target);
    }
}
