#### java io流
io代表input/output即输出输出的流
所以java的io流主要围绕InputStream/OutputStream展开

```puml

abstract class InputStream
class FileInputStream
class FilterInputStream
class ObjectInputStream
class DataInputStream
class BufferedInputStream

abstract class OutputStream
class FileOutputStream
class FilterOutputStream
class ObjectOutputStream
class DataOutputStream
class BufferedOutputStream

FilterInputStream <|-- DataInputStream
FilterInputStream <|-- BufferedInputStream
InputStream <|-- FilterInputStream
InputStream <|-- FileInputStream
InputStream <|-- ObjectInputStream

FilterOutputStream <|-- DataOutputStream
FilterOutputStream <|-- BufferedOutputStream
OutputStream <|-- FileOutputStream
OutputStream <|-- FilterOutputStream
OutputStream <|-- ObjectOutputStream

Object <|-- InputStream
Object <|-- OutputStream

```
#### 注意在使用完流后可以需要关闭流对象，调用close()方法
