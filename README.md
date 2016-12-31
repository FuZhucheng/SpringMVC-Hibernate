
## J2EE项目系列（二）--博客管理系统（Maven+SpringMVC+Hibernate以及附加分页和一对多查询功能）
### 大家在使用过程中，可先阅读我的博客会有更好的理解。[博客管理系统](http://blog.csdn.net/Jack__Frost/article/details/53946765)
### 转载请注明：【JackFrost的博客】     
### 更多内容，可以访问[JackFrost的博客](http://blog.csdn.net/jack__frost?viewmode=contents)
### 喜欢就给个star咯，谢谢大家。
***
### 一、项目介绍（功能业务逻辑，运用的知识，项目数据库等）
#### （1）**功能介绍**：
#### 1.添加管理账号，包括账号、密码，你的名字(新旧名字)。还有一系列的增删改查。
#### 2.添加博客文章，文章的日期、内容、标题、id。还有一系列的增删改查。
#### 3.实现外键级联属性
#### 4.实现分页查询统计
#### 5.实现一对多查询
#### 6.部分前端代码，基于bootstrap的样式和js.min
#### （2）**运用的知识**：
#### 使用Intellij进行开发的，spring，hibernate，mysql，maven
#### 1.基本数据库知识MySQL
#### 2.SpringMVC+hibernate
#### 3.（重点）框架的MVC设计模式的应用
#### 4.（重点）分页查询
#### 5.（重点）一对多查询
#### 6.部分前端代码，基于bootstrap的样式和js.min以及一些jstl
#### 7.JpaRepository的使用
***
## Demo部分截图：
### 下面是用户表的增删改查
![这里写图片描述](http://img.blog.csdn.net/20161231122934659?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvSmFja19fRnJvc3Q=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
### 下面是实现一对多的查询
![这里写图片描述](http://img.blog.csdn.net/20161231122954034?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvSmFja19fRnJvc3Q=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
### 下面是博客文章的总表，并实现分页查询
![这里写图片描述](http://img.blog.csdn.net/20161231123030275?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvSmFja19fRnJvc3Q=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
