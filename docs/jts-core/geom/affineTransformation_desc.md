## 仿射变换理论基础
### 变化模型分类
变换模型是指根据待匹配图像与背景图像之间几何畸变的情况，所选择的能最佳拟合两幅图像之间变化的几何变换模型。可采用的变换模型有如下几种:刚性变换、仿射变换、透视变换和非线形变换等，如下图<br>
![变化种类](../../statics/geo/trans-more.png)<br>
其中第三个的仿射变换就是我们这节要讨论的。
仿射变换(Affine Transformation)
Affine Transformation是一种二维坐标到二维坐标之间的线性变换，保持二维图形的“平直性”（译注：straightness，即变换后直线还是直线不会打弯，圆弧还是圆弧）和“平行性”（译注：parallelness，其实是指保二维图形间的相对位置关系不变，平行线还是平行线，相交直线的交角不变）<br>
![仿射变化](../../statics/geo/affinetransfor-b.png)<br>
**c和d的区别可以看下图**
![cd区别](../../statics/geo/cddiffr.png)<br>
### 仿射变换(Affine Transformation)
仿射变换可以通过一系列的原子变换的复合来实现，包括：平移（Translation）、缩放（Scale）、反射（reflection）、旋转（Rotation）和剪切（Shear）<br>
![cd区别](../../statics/geo/transf.png)<br>
### 仿射变换(Affine Transformation)公式
![公式](../../statics/geo/expression.png)<br>
### 变化样例
#### 平移变换 Translation
将每一点移动到(x+tx, y+ty)，变换矩阵为
![平移公式](../../statics/geo/translation.png)<br>
平移变换是一种“刚体变换”，rigid-body transformation，就是不会产生形变的理想物体。
效果：
![平移效果图](../../statics/geo/translation-result.png)<br>
#### 缩放变换（Scale）
将每一点的横坐标放大（缩小）至sx倍，纵坐标放大（缩小）至sy倍，变换矩阵为：
![缩放变换公式](../../statics/geo/scale.png)<br>
变换效果如下：
![缩放变换效果图](../../statics/geo/scale-result.png)<br>
#### 剪切变换（Shear）
变换矩阵为：
![剪切变换公式](../../statics/geo/schear.png)<br>
相当于一个横向剪切与一个纵向剪切的复合
![剪切变换xy公式](../../statics/geo/schear-xy.png)<br>
效果：
![剪切变换result](../../statics/geo/schear-result.png)<br>

#### 旋转变换（Rotation）
目标图形围绕原点顺时针旋转theta弧度，变换矩阵为：
![旋转变换](../../statics/geo/rotation.png)<br>
效果：
![旋转变换result](../../statics/geo/rotation-result.png)<br>

### 一些常用变化样例
![一些常用变化样例](../../statics/geo/normal.png)<br>