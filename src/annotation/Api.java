package annotation;

/**
 * Created by crazystone on 18-3-7.
 */
public interface Api {

    String getUser(@Path String path, @Query String query);

}
