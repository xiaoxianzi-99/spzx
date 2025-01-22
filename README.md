# 电商系统
> 该项目主要包含：使用SpringBoot进行后端开发，前端包含中后台和前台
>
> - 其中中后台使用 ([vue3-element-admin后台管理系统前端解决方案](https://github.com/huzhushan/vue3-element-admin)),在此基础上进行二开，项目地址[xiaoxianzi-99/sqzx_frontend](https://github.com/xiaoxianzi-99/sqzx_frontend?tab=readme-ov-file)

## 主要功能

###  基础功能

1. 角色管理、用户管理、菜单管理
2. 商品管理、品牌管理、分类管理

###  拓展功能

1. 使用redis来进行用户权限管理，单独使用个线程来进行操作中的权限检验，包含分发，鉴权，续期等功能
2. 使用minio来进行文件存储
3. 使用easyExcel来进行excel文件读入以及导出
