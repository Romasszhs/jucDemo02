四个基本的流
FileOutputStream
FileInputStream
FileReader
FileWriter
缓存流
字节缓存流 BufferedInputStream ， BufferedOutputStream
public BufferedInputStream(InputStream in) ：创建一个 新的缓冲输入流。
public BufferedOutputStream(OutputStream out) ： 创建一个新的缓冲输出流。

字符缓存流 BufferedReader ， BufferedWriter
public BufferedReader(Reader in) ：创建一个 新的缓冲输入流。
public BufferedWriter(Writer out) ： 创建一个新的缓冲输出流。
字符缓存流还有特有的方法
BufferedReader： public String readLine() : 读一行文字。
BufferedWriter： public void newLine() : 写一行行分隔符,由系统属性定义符号。

转换流是字节和字符间的桥梁。
字符编码 Character Encoding : 就是一套自然语言的字符与二进制数之间的对应规则。
转换流java.io.InputStreamReader ，是Reader的子类，是从字节流到字符流的桥梁。
它读取字节，并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集。
构造方法
InputStreamReader(InputStream in) : 创建一个使用默认字符集的字符流。
InputStreamReader(InputStream in, String charsetName) : 创建一个指定字符集的字符流
构造举例
InputStreamReader isr = new InputStreamReader(new FileInputStream("in.txt"));
InputStreamReader isr2 = new InputStreamReader(new FileInputStream("in.txt") , "GBK")
指定编码读取
```java


```
转换流 java.io.OutputStreamWriter ，是Writer的子类，是从字符流到字节流的桥梁。
使用指定的字符集将字符编码为字节。它的字符集可以由名称指定，也可以接受平台的默认字符集。
构造方法
OutputStreamWriter(OutputStream in) : 创建一个使用默认字符集的字符流。
OutputStreamWriter(OutputStream in, String charsetName) : 创建一个指定字符集的字符流。
构造举例
OutputStreamWriter isr = new OutputStreamWriter(new FileOutputStream("out.txt"));
OutputStreamWriter isr2 = new OutputStreamWriter(new FileOutputStream("out.txt") , "GBK");

