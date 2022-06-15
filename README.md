# NULS轻量版预言机功能说明
## 合约说明
* 测试网合约地址： tNULSeBaN48anzp2dE6H546bEu8BFwPKQAU4dj
### 合约功能
#### 功能说明 
管理员可以存储字符串key-value对倒合约中，并可以随时更新value值。
其他合约可以通过查询接口查询单个或多个key对应的value值，同时得到value更新时间
#### 主要方法
* submit 
提交单个key-value值，key支持
* batchSubmit 
批量提交多个key-value值
* getValue
查询单个key对应的value值和提交时间
* getValues
批量查询多个key对应的value值和提交时间
 