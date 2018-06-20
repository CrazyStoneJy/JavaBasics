package rxjava;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import test.Logs;

import java.util.concurrent.TimeUnit;

/**
 * Created by crazystone on 18-3-8.
 */
public class RxJavaTest {

    public static void main(String... args) {
        Flowable.just("test")
                .map(new Function<String, Boolean>() {
                    @Override
                    public Boolean apply(@NonNull String s) throws Exception {
                        if (s.equals("test")) {
                            return true;
                        }
                        return false;
                    }
                }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean bool) throws Exception {
                Logs.l(bool);
            }
        });

    }

}
