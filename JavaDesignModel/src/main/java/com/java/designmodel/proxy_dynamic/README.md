## 动态代理
动态代理说白了都是模板代码，Java为开发者提供了InvocationHandler,实现该接口重写其invoke 方法即可。
## 动态代理代码分析
这里可以看到，DynamicProxyHandler 内部持有的并不是一个具体的对象，而是 Object 类，而在其 invoke 方法中，又会根据具体的 Object 对象及参数调用其对应的方法。这样当我们在客户端调用时，完全是根据委托类通过 Proxy.newProxyInstance 方法动态的创建代理类。在上面的代码中，我们是通过委托类 RealSubject 动态的创建了一个代理类，通过代理类调用抽象主题中定义好的方法，实际上就会调用委托类中的具体实现。而在Java中，我们可以通过反射机制，动态的创建类及其实例，因此，我们便可以在运行时通过不同的委托类，更灵活的创建代理类，从而实现不同的功能。
