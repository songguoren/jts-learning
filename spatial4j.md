## Spatial4j简介
Spatial4j是一个通用的空间/地理空间(spatial/geospatial) [ASL](http://www.apache.org/licenses/LICENSE-2.0.html) 授权的开源Java库。它的核心能力有三个方面:提供常见的形状,可以在欧几里得和测地线(球体)表面世界模型,提供距离计算和其他数学、读和写等格式的形状 [WKT](http://en.wikipedia.org/wiki/Well-known_text) 和[GeoJSON](http://geojson.org/geojson-spec.html#geometry-objects) 。Spatial4j是Eclipse基金会 [LocationTech](http://www.locationtech.org) 行业工作组的一个项目。

## 特性
具有地理空间感知的形状类(*)<br>
* 形状:点Point，矩形Rectangle，圆Circle，多边形Polygon(通过JTS)
* 几何运算:不相交disjoint，包含contains，内部within，相交intersects，不支持touch
* 边界计算
* 面积计算

距离计算支持三个公式(球面计算公式):
* [Law of Cosines(余弦定理)](http://en.wikipedia.org/wiki/Spherical_law_of_cosines)
* [Haversine默认使用球面模型](http://en.wikipedia.org/wiki/Haversine_formula)
* [Vincenty椭球模型](http://en.wikipedia.org/wiki/Vincenty's_formulae)
## 其他特性
Shapes支持的输入/输出格式:<br>
* [WKT](http://en.wikipedia.org/wiki/Well-known_text)
* [GeoJSON](http://geojson.org/geojson-spec.html#geometry-objects)
* [Polyshape](FORMATS.md#polyshape)
* [Jackson-databdind](https://github.com/FasterXML/jackson-databind)

其它格式支持，[请参考FORMATS.md](FORMATS.md)

## 代码类库地址

[spatial4j GitHub](https://github.com/locationtech/spatial4j)

## Maven坐标

```xml
<dependencies>
    <dependency>
        <groupId>org.locationtech.spatial4j</groupId>
        <artifactId>spatial4j</artifactId>
        <version>0.8</version>
    </dependency>
    
    <dependency>
        <groupId>org.noggit</groupId>
        <artifactId>noggit</artifactId>
        <version>0.8</version>
        <optional>true</optional>
    </dependency>
    
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.9.10.8</version>
        <optional>true</optional>
    </dependency>
    
    <dependency>
        <groupId>org.locationtech.jts</groupId>
        <artifactId>jts-core</artifactId>
        <version>1.18.1</version>
        <optional>true</optional>
    </dependency>
</dependencies>
```

## 代码例子
```java
public class Demo {

    public static void main(String[] args) {
        SpatialContext ctx = SpatialContext.GEO;
        ShapeFactory shapeFactory = ctx.getShapeFactory();
        Circle circle = shapeFactory.circle(new PointImpl(0.0,0.0,ctx),1);


        JtsSpatialContextFactory jtsCtxFactory = new JtsSpatialContextFactory();
        JtsSpatialContext jtsCtx = jtsCtxFactory.newSpatialContext();
        GeometryFactory geometryFactory = jtsCtxFactory.getGeometryFactory();
        Point point = geometryFactory.createPoint();//empty
        Shape shape = jtsCtx.getShapeFactory().makeShapeFromGeometry(point); 

    }
}

```




