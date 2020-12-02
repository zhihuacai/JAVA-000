学习笔记
Week7-01 第二题作业
com.czh.springboot.entity.Order Order实体类
com.czh.springboot.generatedata.GenerateOrder 生成order测试数据
com.czh.springboot.dataIngest.DataInsertPerformanceTest 20万数据插入性能测试(100万插入时间太久)
使用Statement直接插入 耗时：297 136 ms
使用PreStatement直接插入 耗时：211 348 ms

使用BatchStatement直接插入 耗时：238 773 ms
使用PreBatchStatement直接插入 耗时：213 552 ms

Week7-02 第一题作业：未完全完成
1).根据具体的 Service 方法是否会操作数据，注入不同的数据源,1.0版本
com.czh.springboot.multiple.source.IMultiSourceV1
com.czh.springboot.multiple.source.MultiSourceV1
com.czh.springboot.multiple.source.MultiSourceV1Test
com.czh.springboot.DataSourceConfig
com.czh.springboot.JdbcTemplateDataSourceConfig

2).改进版本
com.czh.springboot.DataSourceConfig

com.czh.springboot.multiple.source.DataSourceType
com.czh.springboot.multiple.source.DataSourcePartAspect
com.czh.springboot.multiple.source.DBContextHolder
com.czh.springboot.multiple.source.readOnly
com.czh.springboot.multiple.source.RoutingDataSource

Week7-02 第二题作业：未开始

