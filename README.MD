# Spring 挖坟
     从零搭建，模仿，参照，摸透。
     
     
# 如果报命名空间错误，
可以从网上下载 相应的xsd文件，防止classes文件夹下即可。

AOP 比较奇怪，修改为本地的xsd依然有问题，暂时不考虑先。
将命名空间注释掉，文件，先。

不仅要下载相应的xsd文件，因为我的项目对包做了修改，  
所以需要修改的地方比较多，记得修改xsd文件中的相关类，  
以及增加SPI接口的配置文件设置， 如 AOP需要的 spring.handlers文件.

由于Spring 的 CGLIB 的repack jar 没有源码，但是其中使用的是org.springframework包下的类，导致我的zero不能使用。

所以考虑是不是把 zero 修复掉

zero 目录层级被删掉后，代码成功了。


在这个代码的版本上做修改，还是怎么处理？ 2018-07-15


## master applicationContext 可以使用。

## simple 
    精简到最简单 - 20180717

