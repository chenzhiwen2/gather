# gather
1.由于项目采用 lombok 框架，所以需要做以下工作（适用于eclipse，如果是idea，请自己网上搜索一下解决方案）：
 将 lombok.1.16.12.jar 拷贝到eclipse根目录下。并在eclipse.ini文件加入这两行代码：
-javaagent:lombok.1.16.12.jar
-Xbootclasspath/a:lombok.1.16.12.jar
(如果出现修改之后eclipse无法启动的情况，可能是lombok版本不兼容，请下载最新的lombok包)
