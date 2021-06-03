package org.practical3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public enum PostField {
    POST_ID("post_id"),
    OWNER_ID("owner_id"),
    CONTENT("content"),
    TIMESTAMP("timestamp"),
    IS_REMOVED("isRemoved"),
    IS_REDACTED("isRedated"),
    IS_COMMENTABLE("isCommentable"),
    COUNT_LIKES("CountLikes"),
    COUNT_REPOSTS("CountReposts");

    private static PostField classItem = PostField.OWNER_ID;
    private final String val;

    public  String getVal(){
        return  val;
    }
    PostField(String val) {
        this.val = val;
    }

    public static Collection<PostField> getAllFields()  {
        return new ArrayList<PostField>(Arrays.asList(classItem.getDeclaringClass().getEnumConstants()));
    }

    public static PostField parse(String s) throws IllegalArgumentException {

        for (PostField postField : PostField.values()) {
            String fieldVal= postField.getVal();
            if(s.equals(fieldVal))
                return postField;
        }

       throw new IllegalArgumentException();

    }
}
