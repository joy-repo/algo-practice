package test.miscprobs;

import java.util.concurrent.Flow;

public class MyFlow {


  public static interface Subscriber<T> {
    /**
     * Method invoked prior to invoking any other Subscriber
     * methods for the given Subscription. If this method throws
     * an exception, resulting behavior is not guaranteed, but may
     * cause the Subscription not to be established or to be cancelled.
     *
     * <p>Typically, implementations of this method invoke {@code
     * subscription.request} to enable receiving items.
     *
     * @param subscription a new subscription
     */
    public void onSubscribe(Flow.Subscription subscription);

    /**
     * Method invoked with a Subscription's next item.  If this
     * method throws an exception, resulting behavior is not
     * guaranteed, but may cause the Subscription to be cancelled.
     *
     * @param item the item
     */
    public void onNext(T item);

    /**
     * Method invoked upon an unrecoverable error encountered by a
     * Publisher or Subscription, after which no other Subscriber
     * methods are invoked by the Subscription.  If this method
     * itself throws an exception, resulting behavior is
     * undefined.
     *
     * @param throwable the exception
     */
    public void onError(Throwable throwable);

    /**
     * Method invoked when it is known that no additional
     * Subscriber method invocations will occur for a Subscription
     * that is not already terminated by error, after which no
     * other Subscriber methods are invoked by the Subscription.
     * If this method throws an exception, resulting behavior is
     * undefined.
     */
    public void onComplete();
  }

  public static interface Publisher<T> {
    /**
     * Adds the given Subscriber if possible.  If already
     * subscribed, or the attempt to subscribe fails due to policy
     * violations or errors, the Subscriber's {@code onError}
     * method is invoked with an {@link IllegalStateException}.
     * Otherwise, the Subscriber's {@code onSubscribe} method is
     * invoked with a new {@link Flow.Subscription}.  Subscribers may
     * enable receiving items by invoking the {@code request}
     * method of this Subscription, and may unsubscribe by
     * invoking its {@code cancel} method.
     *
     * @param subscriber the subscriber
     * @throws NullPointerException if subscriber is null
     */
    public void subscribe(Flow.Subscriber<? super T> subscriber);
  }


}
