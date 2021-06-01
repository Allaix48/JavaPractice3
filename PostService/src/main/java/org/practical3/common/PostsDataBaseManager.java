package org.practical3.common;


import org.practical3.model.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class PostsDataBaseManager extends DataBaseManager {
    public PostsDataBaseManager() throws SQLException {
        super();
    }

    public String  getData() throws SQLException {

        String str = super.Connection.nativeSQL("select * from db.posts");

        Statement statement = super.Connection.createStatement();
        ResultSet result = statement.executeQuery(str);
        String output = "";
        while (result.next()) {
            output += result.getString("content") + "\n";
        }
        return  output;
    }


    public Collection<Post> getPosts(Collection<Integer> ids){
        return null;
    }
    

}
