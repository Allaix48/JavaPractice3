package org.practical3;

import org.apache.http.HttpResponse;
import org.practical3.model.data.Post;
import org.practical3.model.transfer.Answer;
import org.practical3.model.transfer.requests.PostsRequest;
import org.practical3.model.transfer.requests.WallRequest;
import org.practical3.utils.Commons;
import org.practical3.utils.HttpClientManager;
import org.practical3.utils.PropertyManager;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class PostServiceAPI {

     static String getBaseURL(){
        return PropertyManager.getPropertyAsString("service.posts.addr", "http://localhost:8027");
    }

    private static Answer sendRequest(String url, Object request) throws Exception {


        HttpResponse response = Commons.HttpClientManager.sendPost(url, request);

        return processResponce(response);


    }

    static Answer processResponce(  HttpResponse response) throws Exception {
        switch (response.getStatusLine().getStatusCode()) {
            case HttpServletResponse.SC_OK:
                return HttpClientManager.getResponseBody(response);

            case HttpServletResponse.SC_NOT_FOUND:
                return null;
            case HttpServletResponse.SC_NOT_IMPLEMENTED:
            case HttpServletResponse.SC_BAD_REQUEST:
                System.out.println("[POST SERVICE ERROR]: " + HttpClientManager.getResponseBody(response).Status);
            default:
                throw new Exception();
        }
    }


    public static Collection<Post> getPosts(PostsRequest postsRequest) throws Exception {
        String url = String.format("%s/posts?action=getPosts", getBaseURL());
        Answer postServiceAnswer =  sendRequest(url,postsRequest);
        return (postServiceAnswer!=null)? (Collection<Post>) postServiceAnswer.Data: new ArrayList<Post>();
    }

    public static Collection<Post> getWall(WallRequest wallRequest) throws Exception {
        String url = String.format("%s/posts?action=getWall", getBaseURL());
        Answer postServiceAnswer =  sendRequest(url,wallRequest);
        return (postServiceAnswer!=null)? (Collection<Post>) postServiceAnswer.Data: new ArrayList<Post>();
    }

    public static int insertPosts(Collection<Post> posts) throws Exception {
        String url = String.format("%s/posts?action=insertPosts", getBaseURL());
        Answer postServiceAnswer =  sendRequest(url,posts);
        return (postServiceAnswer!=null)? 1: 0;
    }
    public static int deletePosts(Collection<Integer> post_ids) throws Exception {
        String url = String.format("%s/posts?action=deletePosts", getBaseURL());
        Answer postServiceAnswer =  sendRequest(url,post_ids);
        return (postServiceAnswer!=null)? postServiceAnswer.AffectedRows: 0;
    }
    public static int updatePostf(Collection<Post> posts)throws Exception {
        String url = String.format("%s/posts?action=insertPosts", getBaseURL());
        Answer postServiceAnswer =  sendRequest(url,posts);
        return (postServiceAnswer!=null)? postServiceAnswer.AffectedRows: 0;
    }

    public static int removePosts(Collection<Integer> post_ids)throws Exception {
        throw new NotImplementedException();
    }
    public static int restorePosts(Collection<Integer> post_ids)throws Exception {
        throw new NotImplementedException();
    }



    public static int searchPosts()throws Exception {
        throw new NotImplementedException();
    }


}
