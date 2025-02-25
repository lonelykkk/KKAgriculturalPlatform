# 前言
本项目为前后端分离的农产品销售助农平台系统，jdk版本建议使用1.8，可用于学习、毕业设计等等
# 注意点
项目必须放在纯英文目录下，也就是绝对路径不能有中文

 

项目启动后，浏览器输入本地访问地址

前台登录页面

http://localhost:8080/lelenongchanpinxiaoshou/front/index.html

 

后台登录页面

http://localhost:8080/lelenongchanpinxiaoshou/admin/dist/index.html#/login

管理员				账户:admin 		密码：admin

商家				账户:a1 		密码：123456

商家				账户:a2 		密码：123456

商家				账户:a3 		密码：123456

用户				账户:a1 		密码：123456

用户				账户:a2 		密码：123456

用户				账户:a3 		密码：123456

# **摘  要**

如今社会上各行各业，都喜欢用自己行业的专属软件工作，互联网发展到这个时候，人们已经发现离不开了互联网。新技术的产生，往往能解决一些老技术的弊端问题。因为传统农产品销售系统信息管理难度大，容错率低，管理人员处理数据费工费时，所以专门为解决这个难题开发了一个农产品销售系统管理系统，可以解决许多问题。

农产品销售系统管理系统按照操作主体分为管理员和用户。管理员的功能包括收货地址管理、购物车管理、字典管理、交流论坛管理、公告信息管理、农产品管理、农产品收藏管理、农产品评价管理、农产品订单管理、商家管理、用户管理、管理员管理。用户的功能等。该系统采用了Mysql数据库，Java语言，Spring Boot框架等技术进行编程实现。

农产品销售系统管理系统可以提高农产品销售系统信息管理问题的解决效率，优化农产品销售系统信息处理流程，保证农产品销售系统信息数据的安全，它是一个非常可靠，非常安全的应用程序。

## 一、 **简介**

人人帮扶的农产品销售助农平台。

## **1.设计目的**

该项目主要为了提供农产品销售系统信息处理的解决方案，它可以短时间处理完信息，并且这些信息都有专门的存储设备，而且数据的备份和迁移都可以设定为无人值守，从人力角度和信息处理角度以及信息安全角度，农产品销售系统管理系统是完胜传统纸质操作的，从而解决帮助农民解决农场品卖不出去而导致产品腐烂等一系列问题。

## **2.应用领域和对象**

2.1应用领域

该项目主要应用于广大农民由于农产品卖不出去且没有足够的渠道去售卖农产品而提供的助农平台。  

2.2 服务对象

农民。

3.技术特点

3.1数据库及可视化工具：

   数据库：mysql5.6

​		可视化工具：Navicat16

3.2 开发工具包：JDK1.8

​	3.3 web服务器：Tomcat7

3.4 浏览器：Microsoft Edge

3.5 技术栈：

​		语言：java,javascript

​		框架：springboot

## 二、 **产品概述** 

### **1.系统流程**

农产品销售系统管理系统投入使用后，使用者如果能看到相应的流程操作图会提高程序的理解能力。

### **2.操作流程**

使用者在操作农产品销售系统管理系统中，应该按照本系统提供的操作流程（如下图）进行操作，可以减少操作失误，从而节省进入农产品销售系统管理系统的时间。

 
![image](https://github.com/user-attachments/assets/22e0a0f3-aa40-44ae-93ff-6bcd2bb2b65f)


###  

### **3.登录流程**

农产品销售系统管理系统通过登录功能（如下图）引导使用者进入指定的功能操作区，也避免非本系统的用户享受本系统提供的服务以及查看本系统提供的信息，进而保证用户安全。

 

![image](https://github.com/user-attachments/assets/b8221271-a028-4bce-873e-8654d85fdb36)

 

### **4.删除信息流程**

农产品销售系统管理系统通过登录功能（如下图）引导使用者进入指定的功能操作区，也避免非本系统的用户享受本系统提供的服务以及查看本系统提供的信息，进而保证用户安全。

![image](https://github.com/user-attachments/assets/dd917153-732f-4310-85cb-a3fda3a492d7)

### **5.添加信息流程**

农产品销售系统管理系统提供可视化的功能操作区，非常方便使用者进行数据操作，当使用者往系统中录入数据时（如下图），本系统也会进行数据合法性的判断，符合要求的数据才能够在数据库指定表中进行登记。

![image](https://github.com/user-attachments/assets/68d6e155-bff7-4fec-98e5-b7601b38e31d)

 

### **三、后台管理端**

后台管理端分为商家登录和管理员登录，商家主要有对农产品上架并进行售卖等权限、而管理员则可以对商家进行统一审核管理。

 

#### **1.商家登录**

商家登录后可以对农产品进行增删改查等一系列操作、并且可以查看客户对自己农产品的评价、同时可以实时监控用户购买相关农产品的订单信息，方便管理。（如下图）

![image](https://github.com/user-attachments/assets/23ed51cb-40d7-47fe-9c48-760d00cf0111)


（农产品管理）

![image](https://github.com/user-attachments/assets/60e48d19-b2bd-41ee-bb0c-81b8499d5d1d)

（农产品评论管理）

 

#### **1.1交流论坛管理**

商家可以设置自己店铺的交流论坛、从而方便用户在该店铺实时聊天，帮助用户快速的了解该店铺的农产品相关信息以及提供宝贵建议。

 

 

 

 

![image](https://github.com/user-attachments/assets/4b8265b7-8ed1-417e-9ad1-47b980a6100e)

（交流论坛管理）

 

### **1.2 公告管理**

下图即为编码实现的公告管理界面，管理员在公告管理界面中新增公告，可以删除公告。

 

 

![image](https://github.com/user-attachments/assets/caaf90a7-fe84-40e4-8b46-86c2d6e38e0f)

（公告管理）

 

 

 

### **1.3 轮播图管理**

商家可以设置自己店铺的轮播图界面，之后会被管理员统一管理，然后由管理员设置用户界面首页的轮播图推荐，从而加大产品的曝光度。

![image](https://github.com/user-attachments/assets/0243024e-3696-4151-8867-68c2a07e9227)

（商家轮播图管理）

 

#### **2 管理员登录**

管理员登录后除了具有普通商家所有的一切权限之外，还可以对所有商家进行统一审核管理，并且能够管理所有商家的店铺以及所有商家的订单信息，此外还可以对前台客户端进行权限管理。

![image](https://github.com/user-attachments/assets/c0584f9b-e007-4364-a4f7-e3e49f931068)

（管理员对普通商家进行管理）

 

 

#### **2.1 用户管理**

管理员可以对前台用户端已注册的账号进行统一审核管理，可以查看所有用户信息并且有权限修改用户信息。

![image](https://github.com/user-attachments/assets/03820063-c87f-468c-88e1-594724b3370f)

(管理员对普通用户进行管理)

### **2.2 农产品管理**

下图即为编码实现的农产品管理界面，管理员在农产品管理界面中可以对界面中显示，可以对所有店铺的农产品信息的农产品状态进行查看，可以添加新的农产品信息等。

![image](https://github.com/user-attachments/assets/7af604d0-173a-4600-a46d-05745dda992e)

（农产品管理界面）

### **2.3 农产品订单管理**

下图即为编码实现的农产品订单管理界面，管理员在农产品订单管理界面中查看所有农产品订单种类信息，农产品订单描述信息，新增农产品订单信息等。

![image](https://github.com/user-attachments/assets/f0f102a9-3821-4693-97dc-10a777ab7e55)

（农产品订单管理界面）

### **2.4 公告管理**

下图即为编码实现的公告管理界面，管理员在公告管理界面中新增公告，可以删除公告。

![image](https://github.com/user-attachments/assets/4f3a2002-e02e-4461-b4b8-c92018e1557c)

（公告管理界面）

### **2.5 公告类型管理**

下图即为编码实现的公告类型管理界面，管理员在公告类型管理界面查看公告的工作状态，可以对公告的数据进行导出，可以添加新公告的信息，可以编辑公告信息，删除公告信息。

![image](https://github.com/user-attachments/assets/624dd2a7-0812-4969-ac05-75080a05a537)

 

（公告类型管理）

 

# **四、用户端功能**

### **1. 农产品**

下图即为编码实现的农产品界面，用户可以在客户端点击产看农产品详情，并且可以查看产品的评论列表，从而决定是否加入购物车并对产品进行购买，填写收获信息并支付订单后将会通过雪花算法生成订单编号方便后续查询。

![image](https://github.com/user-attachments/assets/4c3045d0-3756-4c22-bbfc-efdf5703f68b)

（农产品购买界面）

### **2. 农产品订单**

如下图即为编码实现的农产品订单界面。

![image](https://github.com/user-attachments/assets/b26cf4a4-66a9-4647-b81e-e0212d934ab5)

（农产品订单管理界面）

### **3. 公告**

下图即为后台管理员实现的公告管理界面。

![image](https://github.com/user-attachments/assets/91d7687c-6adb-4881-a42c-f76f23a08d9f)

（公告管理界面）

### **4. 公告类型**

即为编码实现的公告类型管理界面。

![image](https://github.com/user-attachments/assets/a677e986-b7b9-4263-a1d1-b4a7f01fc6cf)

（公告类型管理界面）

### **5. 用户购物车管理**

用户可以在主页查看自己添加过的购物车农产品信息，并且可以选择是否删除购物车或者确认订单并支付。

![image](https://github.com/user-attachments/assets/7e2f2c5f-720b-4cae-ba2e-31414c60ec56)

（查询购物车信息）

 

 

 

 

### **6. 用户个人中心**

用户可以在个人中心查看或修改个人信息，并且可以充值余额，同时可以设置收货地址，并且可以查看自己的历史订单以及收藏过的农产品店铺。

![image](https://github.com/user-attachments/assets/dc726f4c-08da-4580-b754-623fb0e4abd6)

（用户个人中心）

![image](https://github.com/user-attachments/assets/6c802052-eca0-4a8d-b941-21fc0fd2b9e3)

（用户个人中心地址管理）

![image](https://github.com/user-attachments/assets/dc270320-5680-465c-bc02-82e959624181)

（用户农产品收藏信息）

![image](https://github.com/user-attachments/assets/799c783f-8856-4f0c-bb8d-e211c07a98ea)

（用户订单信息）

 

### **五、系统测试**

当系统测试环节开始的时候，也就说明对于系统的编码已经弄得大致通顺了，剩下来需要对一些模块和功能进行测试，这个环节就叫系统测试。在程序开发过程中，系统测试是整个开发过程不能缺少的。原因很简单，系统开发人员在面对各种需求需要对各个模块进行编码，开发人员编写过程中，对于程序的理解全部都在编码里面，一人计短，当一个人去做一些事情的时候，把自己的理解变成成果，有可能理解错误，这个在程序开发过程中很常见。程序开发人员在面对复杂的逻辑，没有想象中的多么清晰，开发过程就是面对着一堆代码，不断的变换数据类型，这些很容易实现程序开发人员的想法，但是如果是比较复杂的逻辑，很可能会出现各种问题，这是无法避免的。所以说，需要额外的人员进行系统测试编写，要站在用户使用的角度去发现问题，这样开发与测试的分离，有助于系统开发的强壮，让程序表达的更完美一些。之所以把系统测试安排到程序开发过程中的原因在于，当测试过程中发现的问题可以最快速度的反馈到程序开发人员手里，可以以最快的时间解决问题。所以必须在系统测试环节做好应该做好的事情，让程序开发从开始到结束都有一个完美的流程。

## **1.** **功能测试**

本节主要选择一些功能进行具体测试描述，在相应的功能里面，根据不同的输入看看能否达到理想中的效果。以下会描述部分功能的测试过程和结果。

### **2. 登录功能测试**

登录是一个常规功能，虽然是常规功能，但是用处很大，可以拒绝非法用户访问，只有合法用户才可以访问对应的功能。

表6.1 管理员登录功能测试表

| 管理员账号 | 管理员密码 | 结果         |
| ---------- | ---------- | ------------ |
| uuu        | uuu        | 成功登录系统 |
| yyy        | uuu        | 登录失败     |
| uuu        | yyy        | 登录失败     |

## **3.** **系统测试结果**

对农产品销售系统管理系统进行了各种检测，包含功能检测和性能检测，操作性检测，兼容性检测，通过各方面检测结果来判定系统是符合设计目标，并且在扩展性或者是稳定性上面，也有很好的表现，能完全的满足用户需求。

 

 
