## 参数

> 命令行：java -jar -Dcookie="" -Dhost=sd -Dusbkey=0 -Dbusiness=0 -Ddownload=0 -Dstartdate=20170101 -Denddate=20200828 Evcard-1.0.0.jar 

- cookie：
登录后网页接口中的cookie。
- host：
各地区网站前缀,例如sd.gov.122.cn 则host=sd
- usbkey：
是否需要usbkey.0:不需要,1:需要
- download：
是否需要断点续传. 0:不需要,1:需要(在数据量大中途中断的情况下第二次爬取时打开使用)。
- business：
网页是否存在运营车辆 0:无运营车辆,1:有运营车辆 
- startdate：
违章查询查询开始时间 
- enddate：
违章查询查询结束时间。
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																						