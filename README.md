# Ayo
项目的基本框架，所有项目都fork这个，便于库的统一更新，然后拉不同的remote
---------------------------------------------------------------------


* git，下面指定的模块都要跑一下这三个命令，并且对应目录得放到gitignore里
    * 开新项目时，fork一下github上的Ayo
    * add一个remote upstream，来拉取库更新，提交库修改
    * add一个remote downstream，负责项目的提交和更新
    * git init
    * git remote add ...
    * git push origin master

* 项目引入：Ayo整体库配置
    * ayo-core：核心库
        * 这里放的是框架级的, ayocore里换东西，应该会影响到项目框架了
        * 区别于sdk，放的应该是常用工具类，如转换，日期，文件，什么的，sdk不会影响项目架构
        * 包括：
            * Activity基类，Activity统计
            * ActivityAttacher辅助框架，免manifest
            * Fragment框架，基于Fragmentation
            * MVP基础
            * EventBus
            * RxBus
            * RxJava轻引入
            * 权限
            * 崩溃日志
            * 调试日志
            * 初始化框架
            * 状态栏一体化
            * ButterKnife和Dagger2引入
            * DB依赖：AyoDB，取自XUtils
            * ACache
    * ayo-lang：基础库
        * 常用工具类，提供工具和语法上的便利，仅此而已
    * ayo-http：基础库
        * 需要指定worker和converter
    * 图片四件套
        * 选择：图库--MediaChooser
        * 选择：拍照--SquareCamera
        * 显示：VanGogh，兼容多套
        * 七牛上传
    * UI五件套：
        * animation：基于daimajia（androidanimations和easing）
        * view
        * list
        * template
        * notify

* 其他模块
    * imageloader
    * progress
    * imagepicker/crop/camera/(mediachooser/wechatchooser)
    * 七牛
    * share
    * umeng
    * video
    * IM系列
