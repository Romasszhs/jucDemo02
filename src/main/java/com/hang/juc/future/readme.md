对比 Future<V>，CompletableFuture 优点在于：

* 不需要手工分配线程，JDK 自动分配
* 代码语义清晰，异步任务链式调用
* 支持编排异步任务