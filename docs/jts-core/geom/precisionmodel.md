## org.locationtech.jts.geom.PrecisionModel 使用说明

###  PrecisionModel 精度模式
#### 说明
精度模型是数值计算的核心，JTS使用默认的双精度模型。当使用较大值时，java中内置的数学并不是非常精确，可以通过配置GeometryFactory的PrecisionModel使用不同的精度。
#### 精度分类
**FIXED**: 固定精度表示坐标有固定的小数位数，小数点的位数由比例因子的对数10决定（log10 of the scale）<br>
**FLOATING**: JAVA中的double，双精度浮点型，参考IEEE-754标准<br>
**FLOATING_SINGLE**: JAVA中的float，单精度浮点型，参考IEEE-754标准
#### 操作示例
```java
PrecisionModel precisionModel = new PrecisionModel(PrecisionModel.FLOATING);
```