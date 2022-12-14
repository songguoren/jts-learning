## JTS简介

JTS提供了一套操作几何向量的java类库<br>
早期版本 com.vividsolutions，已废弃不在维护<br>
现在版本 com.locationtech.jts 由eclipse开源基金会托管<br>
## 使用说明
### 入门指导
[GIS开发入门指导](gisguider.md)<br>
### jts-core 核心库使用说明
[jts-core核心类库使用说明](docs/jts-core/readme.md)<br>
具体结合示例代码详细介绍JTS下面核心包下面的geometry、coordinate、wkb、wkt等操作使用说明
### jts案例
[计算点到线的垂线](docs/jts-core/demo/foot-point.md)<br>
[延线的画线方向，判断点在线的右侧还是左侧](docs/jts-core/demo/left-right.md)<br>
[线到线投影](docs/jts-core/demo/linetolineshadow.md)<br>
[根据起始点求一个线的子线](docs/jts-core/demo/sublinebypoint.md)<br>
[计算线上面距离点起点一定距离的交点坐标](docs/jts-core/demo/lineatob.md)<br>
[扩buffer,左扩N米右扩N米](docs/jts-core/demo/buffer.md)<br>
[单位换算](docs/jts-core/demo/km-degree.md)<br>
## 代码类库地址

[JTS GitHub](https://github.com/locationtech/jts)

## 代码包结构

核心模块:  

* `jts-core` - 核心类库:提供geometry model, operations, algorithms, and spatial data structures  
* `jts-io-common` - I/O classes for open spatial formats  

The following modules depend on proprietary libraries, and are not built by default:  

* `jts-io-ora` - Oracle reader and writer  
* `jts-io-sde` - SDE reader and writer  

The following modules are applications and data for testing and working with JTS  

* `jts-tests` - The JTS XML test suite and the Test Runner application  
* `jts-app` -The TestBuilder GUI, for working with JTS geometry interactively  

## Maven坐标

```xml
<dependency>  
 <groupId>org.locationtech.jts</groupId> 
 <artifactId>jts-core</artifactId> 
 <version>1.16.1</version>
</dependency>  
```




