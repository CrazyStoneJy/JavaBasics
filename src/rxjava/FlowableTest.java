package rxjava;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import sun.rmi.runtime.Log;
import test.IntegerTest;
import test.Logs;

/**
 * Created by crazystone on 18-3-8.
 */
public class FlowableTest {

    public static void main(String... args) {

//        test();
        map();
    }

    private static void map() {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<String> e) throws Exception {
                e.onNext("value");
                e.onNext("1");
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR)
                .map(new Function<String, Boolean>() {
                    @Override
                    public Boolean apply(@NonNull String s) throws Exception {
                        return s.equals("1");
                    }
                }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Logs.l(aBoolean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }

    private static void test() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                Logs.l("emit 1");
//                e.onNext(2);
//                Logs.l("emit 2");
                for (int i = 0; i < 5; i++) {
                    e.onNext(i);
                }
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                Logs.l("onSubscribe");
                // 这是观察者能够处理的数量如果这个数量小于发送的数量,就会报MissingBackpressureException异常
                subscription.request(Integer.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                Logs.l("onNext->" + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                Logs.l("onError");
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                Logs.l("onComplete");
            }
        });
    }

}
