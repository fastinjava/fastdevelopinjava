# Spring Cloud Gateway 基本知识.md
## 过滤器基础
### 过滤器的生命周期

Spring Cloud Gateway 的 Filter 的生命周期不像 Zuul 的那么丰富，它只有两个：“pre” 和 “post”。
PRE ： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择
请求的微服务、记录调试信息等。
POST ：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的 HTTP
###  过滤器类型
Spring Cloud Gateway 的 Filter 从作用范围可分为另外两种GatewayFilter 与 GlobalFilter。
GatewayFilter ：应用到单个路由或者一个分组的路由上。
GlobalFilter ：应用到所有的路由上。

## 局部过滤器
局部过滤器（GatewayFilter），是针对单个路由的过滤器。可以对访问的URL过滤，进行切面处理。在
Spring Cloud Gateway中通过GatewayFilter的形式内置了很多不同类型的局部过滤器。这里简单将
Spring Cloud Gateway内置的所有过滤器工厂整理成了一张表格，虽然不是很详细，但能作为速览使
用.
