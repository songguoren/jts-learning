## org.locationtech.jts.geom.Envelope 使用说明

###  Envelope 边界操作类
#### 说明
定义二维坐标的平面的矩形区域;获取minx,miny,maxy,maxx等
#### 操作示例
```java
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Envelope;


/**
 * 矩形区域边界测试类
 */
public class EnvelopeTest {

    public static void main(String[] args) {


        Envelope envelope = new Envelope(new Coordinate(8.0,1.0), new Coordinate(1.0,1.0));

        //获取两个点的最大最小经纬度
        System.out.printf("minx=%s \r\n",envelope.getMinX());
        System.out.printf("minY=%s \r\n",envelope.getMinY());

    }
}
```