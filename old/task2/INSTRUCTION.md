# How I solved task2 

1. In your constructor create **global variables for your `shutdown`, `timeout`, and `limit`**. Make sure you have __default value__ when you aren't sending any values.
2. Copy in your solution from **task1**, method: **askServer**.
3. Add __limiter__ variable, this variable will be used to limit the range of message fetching from server. It should have a default value of your buffer-size. It will get the default value when either the limit is higher than your buffer-size or when limit is at 0 (your default value from constructor). If the limit is less the your buffer-size and not zero then make it assigned the value from global variable.
4. Add __timeout__ value in socket. [READ HERE](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/Socket.html#setSoTimeout(int))
5. Add __counter__ variable, which it can either be the **limit** (global variable) or a [default value](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/Socket.html#getReceiveBufferSize()). This is on condition that the the global variable for limit is on the default value.
6. In your `while-loop` you have to add:
  1. Your counter variable for making sure you don't go over the limit.
  2. You have to add arguments for your read method on InputStream. [`.read(byte[], off, len)`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/InputStream.html#read(byte%5B%5D,int,int)).
7. Add a loop breaker with if-statement and `break;` inside. This will execute when the InputStream is unable to read any more text.
8. Decrease the value of counter.
9. Condition on shutdown, if we want to [shudown input](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/Socket.html#shutdownInput())
10. Add **catch exception** if there is need of it.
