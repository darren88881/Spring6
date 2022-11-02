Bean的生命周期5步走系列
    第一步:实例化Bean
    第二步:Bean属性赋值
    第三步:初始化Bean
    第四步:使用Bean
    第五步:销毁Bean

Bean的生命周期7步走系列:在实例化Bean的前和后加了两步。
        第1.1步-实例化之前-后期处理器
    第一步:实例化Bean
        第1.1步-实例化之后-后期处理器

    第二步:Bean属性赋值
    第三步:初始化Bean
    第四步:使用Bean
    第五步:销毁Bean

    需要实现InstantiationAwareBeanPostProcessor接口并重写Instantiation方法后并配置到xml,
        postProcessBeforeInstantiation:实例化之前-后期处理器
        postProcessAfterInstantiation :实例化之后-后期处理器

Bean的生命周期9步走系列:在初始化Bean的前和后添加两步。
        第1.1步-实例化之前处理器
    第一步:实例化Bean
        第1.1步-实例化之后处理器

    第二步:Bean属性赋值

        第3.1步-初始化前置处理器
    第三步:初始化Bean
        第3.2步-初始化后置处理器

    第四步:使用Bean
    第五步:销毁Bean


    需要实现BeanPostProcessor接口并重写 Initialization 方法后并配置到xml,
        postProcessBeforeInitialization:初始化之前-后期处理器
        postProcessAfterInitialization :初始化之后-后期处理器

Bean的生命周期10步走系列:比9步多了在属性赋值之后感知。

        第1.1步-实例化之前处理器
    第一步:实例化Bean
        第1.1步-实例化之后处理器

    第二步:Bean属性赋值
        第2.2步-属性赋值后感知

        第3.1步-初始化前置处理器
    第三步:初始化Bean
        第3.2步-初始化后置处理器

    第四步:使用Bean
    第五步:销毁Bean

    需要这个类实现Aware(感知)接口，
        如：BeanNameAware、BeanClassLoaderAware、BeanFactoryAware、ApplicationContextAware
    在属性赋值之后感知可以获取或设置下面信息
        BeanName、BeanClassLoader、BeanFactory、ApplicationContext

Bean的生命周期11步走系列:比10步多添加了初始化Bean之前处理的方法。
        第1.1步-实例化之前处理器
    第一步:实例化Bean
        第1.1步-实例化之后处理器

    第二步:Bean属性赋值
        第2.2步-属性赋值后感知

        第3.1步-初始化前置处理器
        第3.1.1步-初始化之前调用
    第三步:初始化Bean
        第3.2步-初始化后置处理器

    第四步:使用Bean
    第五步:销毁Bean

    需要这个类实现InitializingBean接口，重写afterPropertiesSet方法

Bean的生命周期12步走系列:在销毁Bean之前添加了一步。
        第1.1步-实例化之前处理器
    第一步:实例化Bean
        第1.1步-实例化之后处理器

    第二步:Bean属性赋值
        第2.2步-属性赋值后感知

        第3.1步-初始化前置处理器
            第3.1.1步-初始化之前调用
    第三步:初始化Bean
        第3.2步-初始化后置处理器

    第四步:使用Bean

        第5.1步-销毁-在destroy-method 之前调用
    第五步:销毁Bean

    需要这个类实现DisposableBean接口，并重写destroy方法，调用时机是在指定destroy-method 之前调用