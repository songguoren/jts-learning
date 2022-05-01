## GIS开发入门指导
### 前言
梳理从没有地图开发经验，到逐渐熟悉GIS数据的历程过程中的资料

### OGC OpenGIS协会

OGC 全称 Open Geospatial Consortium，是一个非盈利的、国际化的、自愿协商的标准化组织，它的主要目的就是制定与空间信息、基于位置服务相关的标准。这些标准就是 OGC 的“产品”，而这些标准的用处就在于使不同厂商、不同产品之间可以通过统一的接口进行互操作。

在 GIS 领域，OGC 已经是一个比较“官方”的标准化机构了，它不但包括了 ESRI、Google、Oracle 等业界强势企业作为其成员，同时还和 W3C、ISO、IEEE 等协会或组织结成合作伙伴关系。因此，OGC 的标准虽然并不带有强制性，但是因为其背景和历史的原因，它所制定的标准天然地具有一定的权威性。

* [OGC官网](https://www.ogc.org/)
* [OSGeo中国站](https://www.osgeo.cn/)
* [OGC标准介绍中文](https://www.osgeo.cn/doc_ogcstd/index.html)

制定标准的开放协会，制定的标准,举例：
 
* [Simple Feature Access - Part 1: Common Architecture](https://www.ogc.org/standards/sfa) OpenGIS Implementation Specification for Geographic information - Simple feature access - Part 1: Common architecture 基础地理信息模型标准，JTS类库参考此标准实现自己的结构定义
* [Simple Feature Access - Part 2: SQL Option](https://www.ogc.org/standards/sfs) OpenGIS Implementation Specification for Geographic information - Simple feature access - Part 2: SQL option SQL操作标准定义，常见的ST_asText,ST_xx等实现参考此标准，PostGIS、oracle spatial等参考此标准实现

通过以上的标准理解GIS里面的建模基础,点、线、面等

### JAVA类库

* [JTS简介](https://blog.csdn.net/weixin_40294332/article/details/124124042) java类库实现,[github](https://github.com/locationtech/jts)
* [spatial4j简介](https://blog.csdn.net/weixin_40294332/article/details/124210247) [spatial4j GitHub](https://github.com/locationtech/spatial4j) 扩展了JTS，提供圆Circle，提供读取GeoJSON，提供距离计算等
* [incubator-sedona](https://github.com/apache/incubator-sedona) spark+geotools，分布式GIS运算

OSGeo产品

* [GeoTools](https://blog.csdn.net/weixin_40294332/article/details/112506324) java类库 [github](https://github.com/geotools/geotools) ，模型定义通过JTS，上层提供应用接口、插件等
* [GeoServer](https://github.com/geoserver/geoserver) java服务，展现编辑地理信息数据
* [GeoApi](https://github.com/opengeospatial/geoapi) GeoAPI 为地理空间应用提供了一套编程接口。在一系列的包或模块中，GeoAPI 3.0定义了元数据处理和大地测量参考（地图投影）的接口。GeoAPI接口严格遵循国际标准化组织（ISO）在其19100系列文件中和开放地理空间协会（OGC）在其摘要和实施规范中合作发布的抽象模型。GeoAPI对这些标准进行了解释和调整，以符合Java或Python程序员的期望。这些标准为GeoAPI提供了丰富的内容，这来自于规范编写者的专业知识。
* [Udig](https://github.com/locationtech/udig-platform) 界面化的gis操作工具类似Qgis，在eclipse界面上面实现

### 界面工具

QGIS是一个开源的基础地理信息系统平台软件,是在 GNU 公共许可证 (GPL) 版本 2 或更高版本下发布的,[qGis下载地址](https://www.qgis.org/en/site/) 

JTS TestBuilder:JTS界面工具，[下载地址](https://sourceforge.net/projects/jts-topo-suite/files/) [下载地址](https://www.tsusiatsoftware.net/jts/main.html) 