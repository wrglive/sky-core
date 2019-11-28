# sky-core
sky架构的核心包慢慢拓展啦
##特色
1.自定义日志@AutoLogger注解
2.新增简易的 鉴权注解.
3.自定义对token校验
4.自定义异常.
5.mybatis优化, 无需任何修改就可以 无缝对enum类进行index存储  name取出.
例如: Gender MAN(0)  saveToDb : 0 ->  queryToPoJo MAN;
6.整合好的redisTemplate
