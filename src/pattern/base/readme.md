#### 尽量少用继承多用组合关系
> 继承
- 缺点：一个设计中继承过多会造成类之间的耦合严重，如果发生核心代码的改动会影响到其他子类．
- 优点：能够使得代码复用率变高

> 组合
- 优点：可以使类之间的进行解藕合，但是要注意组合的关系要尽量面向接口和抽象．
- 缺点：代码体量会变大，代码复用率变低

> 因此，一个好的代码设计必须权衡好继承和组合的比例．
如果同样的代码重复大于３次即可用继承．