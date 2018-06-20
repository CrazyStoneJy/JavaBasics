package rxjava;

import io.reactivex.*;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import org.omg.CORBA.INTERNAL;
import test.Logs;
import utils.Dates;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by crazystone on 18-3-8.
 */
public class ObservalTest {

    Flowable flowable;
    Observable observable;

    public static void main(String[] args) {

//        create();
        // 将一个类型转为另一个类型
//        map();
        // 将发送的内容多个类型合并为一个新的数据类型
//        zip();
        // 合并发射器
//        concat();
        // 元素唯一
//        distinct();
        // 使用过滤条件过滤元素
//        filter();
        // 缓存输出
//        buffer();
//        timer();
//        interval();
//        doOnNext();
        // 跳过skip(例如:2)个再输出
//        skip();
        // 最多输出多少个
//        take();
        // 获取最后一个元素
//        last();
        // 合并多个发射器
//        merge();
        // 将数据集累加,只返回最后结果
//        reduce();
        // 将数据集累加,输出每次累加的结果
//        scan();
//        flatMap();
//        concatMap();
        // ???
//        defer();
        chain();

    }

    private static void chain() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("hello");
                e.onNext("nihao");
                e.onComplete();
            }
        }).flatMap(new Function<String, ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> apply(@NonNull String s) throws Exception {
                return Observable.just(1, 2, 3);
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l(integer);
            }
        });

    }

    private static void concatMap() {
        Observable.just(1, 2, 3).concatMap(new Function<Integer, ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> apply(@NonNull Integer integer) throws Exception {
                return Observable.just(integer);
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l(integer);
            }
        });
    }

    private static void scan() {
        Observable.just(1, 2, 3).scan(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                return integer + integer2;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l(integer);
            }
        });
    }

    private static void reduce() {
        Observable.just(1, 2, 3, 4).reduce(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                // integer 上一次的累加值 , integer2 发送的数
                Logs.l("i:" + integer);
                Logs.l("j:" + integer2);
                return integer + integer2;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l(integer);
            }
        });
    }

    private static void merge() {
        Observable.merge(Observable.just(1, 2, 3), Observable.just(4, 5, 6)).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l(integer);
            }
        });
    }

    private static void last() {
        Observable.just(1, 2, 3).last(2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                io.utils.Logs.l(integer);
            }
        });
    }

    private static void defer() {
        Observable observable = Observable.defer(new Callable<ObservableSource<?>>() {
            @Override
            public ObservableSource<?> call() throws Exception {
                return Observable.just(1, 2, 3);
            }
        });
        observable.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Logs.l(o);
            }
        });
    }

    private static void take() {
        Observable.just(1, 2, 3, 4, 5).take(2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l(integer);
            }
        });
    }

    private static void skip() {
        Observable.just(1, 2, 3, 4, 5, 6).skip(2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l(integer);
            }
        });
    }

    private static void doOnNext() {
        Observable.just(1, 2, 3, 4).doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l("doOnNext:" + integer);
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l("subsrciber:" + integer);
            }
        });
    }

    private static void timer() {
        Logs.l("start:" + Dates.getNowData());
        Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Logs.l("end:" + Dates.getNowData());
                    }
                });
    }

    private static void buffer() {
        Observable.just(1, 2, 3, 4, 5).buffer(3, 2).subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Exception {
                Logs.l(">>>begin>>>");
                for (Integer integer : integers) {
                    System.out.println(integer);
                }
                Logs.l(">>>end>>>");
            }
        });
    }

    private static void filter() {
        Observable.just(1, 4, 243, 3, 23, 14).filter(new Predicate<Integer>() {
            @Override
            public boolean test(@NonNull Integer integer) throws Exception {
                return integer > 10;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l(integer);
            }
        });
    }

    /**
     * 元素唯一
     */
    private static void distinct() {
        Observable.just(1, 1, 2, 4, 3, 3).distinct().subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Logs.l(integer);
            }
        });
    }

    private static void interval() {
        io.utils.Logs.l("start:" + Dates.getNowData());
        Disposable d = Observable.interval(2, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Logs.l("end:" + Dates.getNowData());
                    }
                });
        d.dispose();
    }

    private static void flatMap() {
        Observable.just(1, 2, 3).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                List<String> list = new ArrayList();
                for (int i = 0; i < 2; i++) {
                    list.add(integer + "-" + i);
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Logs.l(s);
            }
        });
    }

    /**
     * ???有疑问先阁下
     */
    private static void concat() {
        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Logs.l(integer);
                    }
                });
    }

    private static void printThread() {
        Logs.l(Thread.currentThread().getName());
    }

    private static void zip() {
        Observable.zip(new ObservableSource<String>() {
            @Override
            public void subscribe(@NonNull Observer<? super String> observer) {
                for (int i = 0; i < 5; i++) {
                    observer.onNext("person" + i);
                }
            }
        }, new ObservableSource<Integer>() {
            @Override
            public void subscribe(@NonNull Observer<? super Integer> observer) {
                for (int i = 0; i < 5; i++) {
                    observer.onNext(i);
                }
            }
        }, new BiFunction<String, Integer, Person>() {
            @Override
            public Person apply(@NonNull String s, @NonNull Integer integer) throws Exception {
                Person person = new Person(s, integer);
                return person;
            }
        }).subscribe(p -> {
            Logs.l(p);
        });

    }

    private static void map() {
//        Observable.create(e -> {
//            e.onNext(33);
//        }).map(i -> {
//            return "value:" + i;
//        }).subscribe(s -> {
//            Logs.l(s);
//        });
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                String value = "result is " + integer;
                return value;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Logs.l(s);
            }
        });
    }


    private static void create() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                for (int i = 0; i < 10; i++) {
                    String value = "value" + i;
                    e.onNext(value);
                    Logs.l("launch " + value);
                }
                e.onComplete();
            }
        }).subscribe(new Observer<String>() {
            Disposable disposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.disposable = d;
            }

            @Override
            public void onNext(@NonNull String s) {
                Logs.l(s + " is coming");
                if (s.equals("value2")) {
                    disposable.dispose();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Logs.l("finished");
            }
        });
    }


}
